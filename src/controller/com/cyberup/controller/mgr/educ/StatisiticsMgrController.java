package com.cyberup.controller.mgr.educ;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.controller.mgr.common.FileUploadController;
import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.educ.Statisitics;
import com.cyberup.model.home.FileUpload;
import com.cyberup.service.educ.StatisiticsService;
import com.cyberup.service.educ.UnivSttService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.util.DateFormatter;
import com.cyberup.util.FileDeletor;
import com.ibm.icu.text.SimpleDateFormat;
/*************************************************************
 * 
 * 기   능 : 교과부 통계(CU_BOARD)관련 기능 구현 (대학별 통계 자료 관리,통계 자료 관리) 
 * 작성자 : 배진국 
 * 작성일 : 2012-10-25
 * 
 **************************************************************/
@Controller
@RequestMapping("/mgr/educ")
public class StatisiticsMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator statisiticsUpdateValidator;
	
	@Autowired
	private StatisiticsService statisiticsService;
	
	@Autowired
	private UnivSttService univSttService;
	
	@Autowired
	private FileUploadService fileUploadService;	
	
	@Autowired
	private FileUploadController fileUploadController;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@Inject
	protected Provider<SessionUploadConfigMap> sessionUploadConfigMap;

	@Resource(name = "statisiticsUpdateValidator")
	public void setStatisiticsUpdateValidator(MapValidator statisiticsUpdateValidator) {
		this.statisiticsUpdateValidator = statisiticsUpdateValidator;
	}

	@RequestMapping("/statisitics")
	public String board(ModelMap model) {		
		
		return null;
	}

	/************** 리스트 **************/
	@RequestMapping(value = "/statisitics_list", method = RequestMethod.POST)
	public String list(Statisitics statisiticsParam, ModelMap modelMap,
			String searchValue1, String searchValue2,
			String searchValue3, String searchValue4) throws Exception {

		// 검색조건에 따라 내용/제목으로 검색할 수 있도록 변수를세팅한다.
		if ((StringUtils.hasLength(searchValue1))) {
			statisiticsParam.setTermState(searchValue1);
		}		
		if ((StringUtils.hasLength(searchValue2))) {
				statisiticsParam.setSttName(searchValue2);
		}
		if ((StringUtils.hasLength(searchValue3))) {
			statisiticsParam.setGatherState(searchValue3);
		}
		if ((StringUtils.hasLength(searchValue4))) {
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			Date regDate = null;
			regDate = sdt.parse(searchValue4);
			statisiticsParam.setRegDate(regDate);
		}
		

		List<Statisitics> list = statisiticsService.selectList(statisiticsParam.getShowCnt(),
				statisiticsParam.getCurrPage(), statisiticsParam.getTermState(),
				statisiticsParam.getSttName(), statisiticsParam.getRegDate(),
				statisiticsParam.getGatherState());
		modelMap.addAttribute("statisiticsList", list);

		if (list.size() > 0)
			PagingModel.mappPages(modelMap, statisiticsParam.getCurrPage(),
					statisiticsParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, statisiticsParam.getCurrPage(),
					statisiticsParam.getShowCnt(), new PagingModel());

		return null;
	}
	
	private void putAttfileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("xls,xlsx");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Statisitics" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
	}

	/************** 글 수정 초기 화면 **************/
	@RequestMapping(value = "/statisitics_modify")
	public String modify(Statisitics statisiticsParm, ModelMap modelMap)
	{
		
		LoginUser login = loginInfoProvider.get().currentUser();		
		modelMap.addAttribute("login", login);		
		
		putAttfileConfig();
		
		//수정하고자 하는 글을 가져온다.
		Statisitics statisitics = statisiticsService.selectInfo(statisiticsParm.getSttID());	
		modelMap.addAttribute("statisitics",statisitics);
		
		//파일 리스트를 가져온다.
		if(statisitics.getUpfileID() > 0)
		{
			//modelMap.addAttribute("fileList", fileUploadService.selectList(statisitics.getUpfileGid()));
			List list = new ArrayList();
			FileUpload fu = fileUploadService.selectInfo(statisitics.getUpfileID());
			if(fu != null)
				list.add(fu);
			modelMap.addAttribute("fileList", list);
		}
		modelMap.addAttribute("upFileGid",statisitics.getUpfileGid());
		
		return null;
	}
	
	/************** 수정 처리 기능(db 저장) **************/
	@RequestMapping(value = "/statisitics_update", method = RequestMethod.POST)
	public String update(HttpSession session, Statisitics statisiticsParam, ModelMap modelMap,
			SessionStatus sessionStatus) {

		statisiticsUpdateValidator.validate(statisiticsParam, modelMap);
		if (statisiticsUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		statisiticsParam.setModifier(login.getUserId());

		if(statisiticsParam.getUpfileSrc() != null && statisiticsParam.getUpfileSrc().length > 0)
		{
			if(statisiticsParam.getUpfileGid() == 0)
				statisiticsParam.setUpfileGid(fileUploadService.selectGroupKey());
			
			for(int i = 0; i < statisiticsParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(statisiticsParam.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(statisiticsParam.getUpfileSrc()[i] + "OriginalFilename");
				
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(statisiticsParam.getUpfileGid());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(login.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(statisiticsParam.getUpfileSrc()[i]);
				int upfileID = fileUploadService.insertInfo(fileUpload);
				statisiticsParam.setUpfileID(upfileID);
			}
		}
		
		// 게시판 정보 업데이트
		statisiticsService.updateInfo(statisiticsParam);

		sessionStatus.setComplete();
		return null;
	}

	/************** 글 쓰기 초기 화면 **************/
	@RequestMapping(value = "/statisitics_write")
	public String write(ModelMap modelMap) {

//		LoginUser login = loginInfoProvider.get().currentUser();
//		modelMap.addAttribute("login", login);
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		modelMap.addAttribute("admin", admin);
	
		putAttfileConfig();
		
		return null;
	}

	/************** 등록 처리 기능(db 저장) **************/
	@RequestMapping(value = "/statisitics_save", method = RequestMethod.POST)
	public String save(HttpSession session, Statisitics statisiticsParam, ModelMap modelMap,
			SessionStatus sessionStatus) {
		
		statisiticsUpdateValidator.validate(statisiticsParam, modelMap);

		if (statisiticsUpdateValidator.hasErrors())
			return null;
		
	

		LoginUser login = loginInfoProvider.get().currentUser();
		statisiticsParam.setRegister(login.getUserId());

		if(statisiticsParam.getUpfileSrc() != null && statisiticsParam.getUpfileSrc().length > 0)
		{
			statisiticsParam.setUpfileGid(fileUploadService.selectGroupKey());
			for(int i = 0; i < statisiticsParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(statisiticsParam.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(statisiticsParam.getUpfileSrc()[i] + "OriginalFilename");
				
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(statisiticsParam.getUpfileGid());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(login.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(statisiticsParam.getUpfileSrc()[i]);
				int upfileId = fileUploadService.insertInfo(fileUpload);
				statisiticsParam.setUpfileID(upfileId);
			}
		}
		
		statisiticsService.insertInfo(statisiticsParam);

		sessionStatus.setComplete();

		return null;
	}

	/************** 게시물 삭제처리(db) **************/
	@RequestMapping(value = "/statisitics_delete")
	public String delete(Statisitics statisiticsParam, ModelMap modelMap,@RequestParam(required = true) Integer fileGid, Integer sttID) {
		

	//	System.out.println("\n\n\n\n****************************\n\n\n\n");
	//	System.out.println("boardID : "+ boardID);
	//	System.out.println("fileGid : "+ fileGid);
	//	System.out.println("\n\n\n\n****************************\n\n\n\n");		
		
		//파일 삭제 관련도 수행해야함
		if(fileGid > 0)
		{
			List<FileUpload> files = fileUploadService.selectList(fileGid);
			for(int i = 0; i < files.size(); i++)
			{
				new FileDeletor(new File(files.get(i).getUpfilePath())).start();
			}
			
			fileUploadService.deleteList(fileGid);
		}
		
		//글 삭제 
		statisiticsService.deleteInfo(sttID);
		return null;
	}
	
	/************** 대학교 재수집 요청 **************/
	@RequestMapping(value = "/statisitics_gather")
	public String selectSttGather(Statisitics statisiticsParm,ModelMap model) {
		model.addAttribute("univList",univSttService.selectUnivList(statisiticsParm.getGubunID(), statisiticsParm.getSttID()));
		model.addAttribute("gubunID",statisiticsParm.getGubunID());
		model.addAttribute("sttID",statisiticsParm.getSttID());
		return null;
	}	
	
	/************** 대학교 리스트 검색 **************/
	@RequestMapping(value = "/statisitics_univList")
	public String selectUnivList(Statisitics statisiticsParm,ModelMap model) {
		model.addAttribute("univList",univSttService.selectUnivList(statisiticsParm.getGubunID(), statisiticsParm.getSttID()));
		return null;
	}
	
	/************** 대학교 재수집 요청 **************/
	@RequestMapping(value = "/statisitics_reqGather", method = RequestMethod.POST)
	public String reqGather(Statisitics statisiticsParam, ModelMap modelMap,
			SessionStatus sessionStatus, @RequestParam(required = true) String univIDs)throws Exception
	{
		univSttService.upPutState(univIDs);
		
		// 재수집요청시 수집상태를 수집중으로 새팅
		if(statisiticsParam.getSttID()!= 0)
			statisiticsService.upGatherStateN(statisiticsParam.getSttID());
		
		sessionStatus.setComplete();

		return null;
	}
	
	/************** 대학교 통계 파일 다운로드 **************/
	@RequestMapping(value = "/statisitics_selUnivDown")
	public String selUnivDown(HttpServletRequest request, HttpServletResponse response,
			Statisitics statisiticsParam, @RequestParam(required = true) String univIDs, 
			@RequestParam(required = true) String sttID, ModelMap modelMap)throws Exception 
	{
		// 파일 환경을 세팅한다.	
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("xls,xlsx");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "UnivStt" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
		Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
		
		
		
		
		List<FileUpload> sttFileList = univSttService.selUnivDown(univIDs, sttID);
		Statisitics statisitics = statisiticsService.selectInfo(Long.parseLong(sttID));
		ZipFileDownUtil zf = new ZipFileDownUtil();
		
		String path = sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory();		
		
		File f = new File(path);
		if(!f.exists()){
			System.out.println("f.mkdirs go");
			f.mkdirs();
		}
		
		String zipName = statisitics.getSttName().replaceAll("\\s", "") + ".zip";
		
		if("Y".equals(statisitics.getTermState()))
			zipName = statisitics.getSttYear() + "_" + statisitics.getSttMonth() + ".zip";
//			zipName = statisitics.getSttYear() + "_" + statisitics.getSttMonth() + "_" + zipName;
		
		String copyPolderName = statisitics.getSttName();
		
		try {
			zf.getUnivZipFile(sttFileList, path, copyPolderName, zipName); //zip 파일 생성
			//fileUploadController.download(request, response, zf.getZipPath() + "/" + zipName, zipName); // 다운로드
			modelMap.put("zipPath", zf.getZipPath());
			modelMap.put("zipName", zipName);
			
			System.out.println("modelMap = " + modelMap);
			
		} catch (Exception e) {
			System.out.println("statisitics_selUnivDown error");
			e.printStackTrace();
		} finally {
			//zf.delZipDir(); // 삭제
		}
		
		return modelMap.toString();
	}
	
	/************** 대학교 통계 파일 다운로드 **************/
	@RequestMapping(value = "/statisitics_univDown")
	public void univDown(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) String zipPath, 
			@RequestParam(required = true) String zipName)throws Exception 
	{
		ZipFileDownUtil zf = new ZipFileDownUtil();
		
		try {
			fileUploadController.download(request, response, zipPath + "/" + zipName, zipName); // 다운로드	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			zf.delZipDir(zipPath); // 삭제
		}
		
	}
	

}
