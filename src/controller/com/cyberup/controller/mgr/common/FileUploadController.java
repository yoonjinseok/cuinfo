package com.cyberup.controller.mgr.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.framework.model.SessionUploadProgress;
import com.cyberup.model.course.Material;
import com.cyberup.model.course.RelationType;
import com.cyberup.model.home.FileUpload;
import com.cyberup.service.course.LectureService;
import com.cyberup.service.course.MaterialService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.util.FileDeletor;
import com.cyberup.util.HtmlUtils;

@Controller
@RequestMapping("/mgr/common")
public class FileUploadController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	protected SiteConfiguration siteConfiguration;
	@Inject
	private Provider<SessionUploadConfigMap> sessionUploadConfigMap;
	@Inject
	private Provider<SessionUploadProgress> sessionUploadProgress;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping("/file_write")
	public String write(HttpServletRequest request, ModelMap model) {
		String eventHandler = request.getParameter("eventHandler");
		
		if(eventHandler == null)
			model.addAttribute("eventHandler", "setUploadResult");
		else
			model.addAttribute("eventHandler", eventHandler);
		
		return null;
	}
	
	private void writeSaveHistory(HttpSession session, File saveFile, String originalFilename)
	{
		Logger.getLogger(this.getClass()).debug("writeSaveHistory(" + session + ", " + saveFile + ", " + originalFilename + ") start");
		session.setAttribute(saveFile.getName(), saveFile.getPath());
		session.setAttribute(saveFile.getName() + "OriginalFilename", originalFilename);
		Logger.getLogger(this.getClass()).debug("writeSaveHistory(" + session + ", " + saveFile.getName() + ", " + originalFilename + ") success.");
	}

	@RequestMapping(value = "/file_upload2")
	public String upload2(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		upload(request, session, modelMap);
		
		return null;
	}
	@RequestMapping(value = "/file_upload")
	public String upload(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		System.out.println("###################### file_upload called ######################");
		System.out.println("###################### file_upload called ######################");
		System.out.println("###################### file_upload called ######################");
		
		try {
			SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig(request.getParameter(SessionUploadConfigMap.KEY));
			//SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig(request.getParameter("confKey"));
			
			System.out.println("request.getParameter(confKey) " + request.getParameter("confKey"));
			System.out.println(sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory());
			
			
			String eventHandler = request.getParameter("eventHandler");
			
			MultipartRequest multipartRequest = (MultipartRequest)request;
			MultipartFile file = multipartRequest.getFile("file");
			String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
			
			Logger.getLogger(this.getClass()).debug("lastIndexOf : " + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
			
			if(StringUtils.hasLength(sessionUploadConfig.getAcceptExts()))
			{
				if(!sessionUploadConfig.isValidExtension(extension))
				{
					throw new Exception(sessionUploadConfig.getAcceptExts() + " 파일만 업로드 할 수 있습니다.");
				}
			}
			
			Logger.getLogger(this.getClass()).debug("eventHandler : " + eventHandler);
			Logger.getLogger(this.getClass()).debug("file : " + file);
			
			File folder = new File(sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory());
			folder.mkdirs();

			File saveFile = new File(folder, UUID.randomUUID().toString() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
			//File saveFile = new File(folder, UUID.randomUUID().toString());
			
			file.transferTo(saveFile);
			
			writeSaveHistory(session, saveFile, file.getOriginalFilename());
			
			modelMap.addAttribute("errors", false);
			modelMap.addAttribute("message", "parent."+eventHandler+"('"+file.getOriginalFilename()+"', '"+saveFile.getName()+"', '"+file.getSize()+"');");
			
			modelMap.addAttribute("eventHandler", eventHandler);
			modelMap.addAttribute("originalFilename", file.getOriginalFilename());
			modelMap.addAttribute("srcName", saveFile.getName());
			modelMap.addAttribute("fileSize", file.getSize());
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(e.getMessage(), e);
			modelMap.addAttribute("errors", true);
			modelMap.addAttribute("message", "alert('"+e.getMessage()+"');");
		}
		
		return null;
	}
	
	private void ftpPut(final boolean isStream, final String uploadDir, final File file) throws Exception
	{
		new Thread(new Runnable() {
			
			public void run() {
				try {
					FTPClient ftpClient = new FTPClient();
					ftpClient.setControlEncoding("euc-kr");
					
					if(isStream)
					{
						ftpClient.connect(siteConfiguration.getStreamServer(), siteConfiguration.getStreamPort());
						
						int reply = ftpClient.getReplyCode();
						if(!FTPReply.isPositiveCompletion(reply))
						{
							ftpClient.disconnect();
							throw new Exception("server connect fail!");
						}
						
						if(!ftpClient.login(siteConfiguration.getStreamUserid(), siteConfiguration.getStreamPassword()))
						{
							ftpClient.logout();
							throw new Exception("server login fail!");
						}
						
						ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
						ftpClient.enterLocalPassiveMode();
						logger.debug("ftp work directory : " + ftpClient.printWorkingDirectory());
						ftpClient.changeWorkingDirectory(siteConfiguration.getStreamUploadDir());
						logger.debug("ftp work directory : " + ftpClient.printWorkingDirectory());
					}
					else
					{
						ftpClient.connect(siteConfiguration.getFileServer(), siteConfiguration.getFileServerPort());
						
						int reply = ftpClient.getReplyCode();
						if(!FTPReply.isPositiveCompletion(reply))
						{
							ftpClient.disconnect();
							throw new Exception("server connect fail!");
						}
						
						if(!ftpClient.login(siteConfiguration.getFileServerUserid(), siteConfiguration.getFileServerPassword()))
						{
							ftpClient.logout();
							throw new Exception("server login fail!");
						}
						
						ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
						ftpClient.enterLocalPassiveMode();
						logger.debug("ftp work directory : " + ftpClient.printWorkingDirectory());
						ftpClient.changeWorkingDirectory(siteConfiguration.getFileServerUploadDir());
						logger.debug("ftp work directory : " + ftpClient.printWorkingDirectory());
					}
					
					String[] dirs = StringUtils.split(uploadDir, "/");
					for(int i =0; i < dirs.length; i++)
					{
						ftpClient.makeDirectory(dirs[i]);
						logger.debug("ftp makeDirectory : " + ftpClient.getReplyString());
						ftpClient.changeWorkingDirectory(dirs[i]);
						logger.debug("ftp work directory : " + ftpClient.printWorkingDirectory());
					}
					
					FileInputStream fis = null;
					try {
						fis = new FileInputStream(file);
						boolean success = ftpClient.storeFile(file.getName(), fis);
						if(success)
						{
							file.delete();
							logger.info("file(isStream : "+isStream+") : " + file.getPath() + " upload success");
						}
						else
							throw new Exception("upload fail! : " + ftpClient.getReplyString());
					} finally {
						if(fis != null) fis.close();
					}
					
					ftpClient.logout();
				} catch (Exception e) {
					logger.error("file(isStream : "+isStream+") : " + file.getPath() + " upload fail : " + e.getMessage(), e);
				}
			}
		}).start();
	}
	
	private boolean isStream(String extension)
	{
		if(siteConfiguration.getStreamExts().indexOf(extension.toUpperCase()) >= 0)
			return true;
		else
			return false;
	}
	
	@RequestMapping(value = "/kocw_upload", method = RequestMethod.POST)
	public String kocwupload(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		
		try {
			final SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig(request.getParameter(SessionUploadConfigMap.KEY));
			//SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig(request.getParameter("confKey"));
			
			System.out.println("request.getParameter(confKey) " + request.getParameter("confKey"));
			System.out.println(sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory());
			
			MultipartRequest multipartRequest = (MultipartRequest)request;
			
			File folder = new File(sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory());
			folder.mkdirs();
			
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			String uploadDir = courseId+"/" + new DateFormatter("yyyyMMddHHmmss").print(new Date(),
					Locale.getDefault());
			
			String[] lectureIds = (String[])request.getParameterValues("lectureId");
			
			if(lectureIds != null)
			{
				for(int i = 0; i < lectureIds.length; i++)
				{
					MultipartFile lecfile = multipartRequest.getFile("lecture" + lectureIds[i]);
					
					if(lecfile != null)
					{
						if(lecfile.getSize() > 0)
						{
							String extension = lecfile.getOriginalFilename().substring(lecfile.getOriginalFilename().lastIndexOf(".") + 1);
							File lecsaveFile = new File(folder, (HtmlUtils.containKorean(lecfile.getOriginalFilename()))?UUID.randomUUID()+"."+extension:lecfile.getOriginalFilename());
							lecfile.transferTo(lecsaveFile);
							
							boolean isStream = isStream(extension);
							ftpPut(isStream, uploadDir, lecsaveFile);
							lectureService.updateLocation(Integer.parseInt(lectureIds[i]), (isStream?siteConfiguration.getStreamRemoteAddr():siteConfiguration.getFileServerRemoteAddr()) + uploadDir + "/" + lecsaveFile.getName());
						}
						else
						{
							lectureService.updateLocation(Integer.parseInt(lectureIds[i]), "");
						}
					}
					
					List<MultipartFile> lecfiles = multipartRequest.getFiles("lecfile" + lectureIds[i]);
					if(lecfiles != null)
					{
						Material material = new Material();
						material.setRelationId(Integer.parseInt(lectureIds[i]));
						material.setRelationType(RelationType.LECTURE.getValue());
						for(int k = 0; k < lecfiles.size(); k++)
						{
							if(lecfiles.get(k).getSize() > 0)
							{
								String extension = lecfiles.get(k).getOriginalFilename().substring(lecfiles.get(k).getOriginalFilename().lastIndexOf(".") + 1);
								
								File lecsaveFile = new File(folder, (HtmlUtils.containKorean(lecfiles.get(k).getOriginalFilename()))?UUID.randomUUID()+"."+extension:lecfiles.get(k).getOriginalFilename());
								lecfiles.get(k).transferTo(lecsaveFile);
								
								boolean isStream = isStream(extension);
								ftpPut(isStream, uploadDir, lecsaveFile);
								
								material.setLocation((isStream?siteConfiguration.getStreamRemoteAddr():siteConfiguration.getFileServerRemoteAddr()) + uploadDir + "/" + lecsaveFile.getName());
								material.setTitle(request.getParameterValues("lectitle" + lectureIds[i])[k]);
								materialService.constructInfo(material);
							}
						}
					}
				}
			}
			
			String[] delfileIds = (String[])request.getParameterValues("delfileId");
			if(delfileIds != null)
			{
				for(int i = 0; i < delfileIds.length; i++)
				{
					materialService.deleteInfo(Integer.parseInt(delfileIds[i]), "", 0, "");
				}
			}
			
			modelMap.addAttribute("errors", false);
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(e.getMessage(), e);
			modelMap.addAttribute("errors", true);
			modelMap.addAttribute("message", e.getMessage());
		}
		
		return null;
	}
	
	@RequestMapping("/file_status")
	public String status(ModelMap model) {
		
		model.addAttribute("status", sessionUploadProgress.get().getPercent());
		model.addAttribute("total", sessionUploadProgress.get().getTotalSize());
		model.addAttribute("current", sessionUploadProgress.get().getCurrentSize());
		model.addAttribute("item", sessionUploadProgress.get().getItem());
		
		return null;
	}
	
	@RequestMapping(value = "/file_delete", method = RequestMethod.POST)
	public String delete(HttpSession session, @RequestParam(required=true) String srcName, ModelMap modelMap, SessionStatus sessionStatus) {
		
		String filePath = (String)session.getAttribute(srcName);
		
		if(filePath != null)
		{
			new FileDeletor(new File(filePath)).start();
		}
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/file_delete_id", method = RequestMethod.POST)
	public String delete(HttpSession session, @RequestParam(required=true) Integer upfileId, ModelMap modelMap, SessionStatus sessionStatus) {
		
		FileUpload courseFileUpload = fileUploadService.selectInfo(upfileId);
		
		if(courseFileUpload != null)
		{
			new FileDeletor(new File(courseFileUpload.getUpfilePath())).start();
			
			fileUploadService.deleteInfo(upfileId);
		}
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/file_download")
	public String download(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam(required=true) String srcName, ModelMap modelMap) throws Exception {
		
		String filePath = (String)session.getAttribute(srcName);
		String originalFilename = (String)session.getAttribute(srcName + "OriginalFilename");
		
		if(!StringUtils.hasLength(filePath))
		{
			filePath = siteConfiguration.getUploadRootPath() + siteConfiguration.getImgPath() + srcName;
			originalFilename = srcName;
		}
		
		download(request, response, filePath, originalFilename);
		
		return null;
	}
	
	@RequestMapping(value = "/file_download2")
	public String download2(HttpServletRequest request, HttpServletResponse response, String filePath, String fileName) throws Exception {
		
		download(request, response, filePath, fileName);
		return "/mgr/blank.vm";
	}
	
	public void delete(String filePath) {
		new FileDeletor(new File(filePath)).start();
	}
	
	public void download(HttpServletRequest request, HttpServletResponse response, String filePath, String originalName) throws Exception{
		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;
		
		System.out.println("filePath => " + filePath);
		System.out.println("originalName => " + originalName);
		
		try 
		{			 
			File file = new File(filePath);
			Logger.getLogger(this.getClass()).debug("donwload file1 : " + file.getPath());
			Logger.getLogger(this.getClass()).debug("donwload file2 : " + originalName);
			Logger.getLogger(this.getClass()).debug("donwload file3 : " + URLEncoder.encode(originalName, "utf-8"));

			String strClient = request.getHeader("User-Agent");
			Logger.getLogger(this.getClass()).debug("strClient : " + strClient);
			originalName = originalName.replace(" ", "_").replace(",","_");
			
			try {
				// Explorer
				if ( strClient.indexOf("MSIE") != -1 ) { 
					//originalName = new String( originalName.getBytes("EUC-KR"), "ISO-8859-1").replaceAll(" ","%20");
					originalName = URLEncoder.encode(originalName, "utf-8");
				}
				// Opera
				else if ( strClient.indexOf("Opera") != -1 ) {
					originalName = new String( originalName.getBytes("UTF-8"), "ISO-8859-1");
				}
				// Chrome
				else if ( strClient.indexOf("Chrome") != -1 ) {
					originalName = originalName.replace(",","_");
					//window 에서는 아래의 주석 해제
					//originalName = new String( originalName.getBytes("EUC-KR"), "ISO-8859-1");
					
//					URLEncoder.encode(originalName, "utf-8");
				}
				// Safari
				else if ( strClient.indexOf("Safari") != -1 ) {
					originalName = originalName.replace(" ", "_");
					originalName = new String( originalName.getBytes("UTF-8"), "ISO-8859-1");
				}
				// FireFox
				else if ( strClient.indexOf("Firefox") != -1 ) {
					//window 에서는 아래의 주석 해제
					//originalName = new String( originalName.getBytes("UTF-8"), "ISO-8859-1");
					
				}
				// Other
				else{
					originalName = new String( originalName.getBytes("EUC-KR"), "ISO-8859-1");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			if (strClient.indexOf("MSIE 5.5") != -1) {
				response.setHeader("Content-Disposition", "filename=" + originalName + ";");//URLEncoder.encode(originalName, "utf-8")
			} else {
				 response.setHeader("Content-Disposition", "attachment; filename=" + originalName + ";");
				 response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			}
			response.setHeader("Content-Length", ""+ file.length());
			response.setHeader("Content-Transfer-Encoding", "binary;");
			response.setHeader("Pragma", "no-cache;");
			response.setHeader("Expires", "-1;");
			
		    // 사용자에게 보내주기 위해 스트림객체 생성  
	        fin = new BufferedInputStream(new FileInputStream(file)); // 인풋객체생성
	        outs = new BufferedOutputStream(response.getOutputStream()); // 응답객체생성
	        
	        byte b[] = new byte[(int)file.length()];
			int read = 0;
			
		    while ((read = fin.read(b)) != -1) {
		        outs.write(b,0,read);
		    }
		    
		    outs.close();
		    fin.close();		    
		}
		finally {
		    if(outs!=null) outs.close();
		    if(fin!=null) fin.close();
		}
	}
	
	@RequestMapping(value = "/file_download_id")
	public String download(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam(required=true) Integer upfileId, ModelMap modelMap) throws Exception {
		
		FileUpload fileUpload = fileUploadService.selectInfo(upfileId);
		
		download(request, response, fileUpload.getUpfilePath(), fileUpload.getUpfileFilename());
		
		//실서버의 업로드 경로를 로컬로 변경하여 이미지 확인
		//download(request, response, fileUpload.getUpfilePath().replace("/data1/cuinfo/apps/cuinfo", "d:/000_Project/008_keris/cyberup/WebContent"), fileUpload.getUpfileFilename());
		
		return null;
	}
}
