package com.cyberup.controller.mgr.univ;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.home.FileUpload;
import com.cyberup.model.univ.Univ;
import com.cyberup.service.common.DeadLinkCheckService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.univ.UnivService;

@Controller
@RequestMapping("/mgr/univ")
public class UnivInfoController {
	
	private MapValidator univInfoUpdateValidator;
	
	@Resource(name="univInfoUpdateValidator")
	public void setUnivInfoUpdateValidator(MapValidator univInfoUpdateValidator) {
		this.univInfoUpdateValidator = univInfoUpdateValidator;
	}
	
	private MapValidator boardUpdateValidator;
	//MapValidator 를 구현.
	
	@Autowired
	private FileUploadService fileUploadService;
	
	//Autowired 영역
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private UnivService univService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private DeadLinkCheckService deadLinkCheckService;
	
	
	//Inject
	
	@Inject
	private Provider<SessionUploadConfigMap> sessionUploadConfigMap;
	
	//세션정보를 사용하기 위함
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	//method
	
	@RequestMapping(value = "/deadLinkCheck_list", method = RequestMethod.POST)
	public String deadLinkCheck_list(Integer university_id, ModelMap modelMap){
		modelMap.addAttribute("univLinkList",univService.selectUnivLinkList(university_id));
		return "/mgr/univ/deadLinkCheck.vm";
	}
	
	@RequestMapping(value = "/deadLinkCheck", method = RequestMethod.POST)
	public String deadLinkCheck(Integer university_id, ModelMap modelMap){
		
		deadLinkCheckService.deadLinkCheck(university_id);
		modelMap.addAttribute("univLinkList",univService.selectUnivLinkList(university_id));
		
		return null;
	}
	
	@RequestMapping("/univInfo")
	public String univInfo(ModelMap modelMap) {
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		//대학원인지 확인후 값을 셋팅
;
		
		modelMap.addAttribute("gubunId",univService.getGetGubunId(login.getUserId()));
		//select 옵션값 셋팅
		modelMap.addAttribute(codeService.selectList(50, "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/univInfo_list", method = RequestMethod.POST)
	public String univInfoList(Univ univ, ModelMap modelMap) {
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		
		if(admin.getAuthLevelId() == 3){
			univ.setText(Integer.toString(admin.getUniversityId()));
			univ.setRadio("code");
		}
		
		List<Univ> list = univService.selectUnivInfoList(univ);
		
		//univInfoList 리턴
		modelMap.addAttribute("univList",list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, univ.getCurrPage(), univ.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, univ.getCurrPage(), univ.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	private void putAttfileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("hwp,doc,docx,xls,xlsx,ppt,pptx,jpg,jpeg,gif,png,pdf,mp4,flv");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 500);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Univ" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
	}
	
	/*
	private void putLogofileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("gif,jpg,png,bmp,tif");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 50);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Univ" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("logo", sessionUploadConfig);	
	}
	private void putVodfileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("mp4,flv");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 500);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Univ" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("vod", sessionUploadConfig);	
	}
	 */
	
	//코드 클릭시
	@RequestMapping("/introDefaultRegist")
	public String introDefaultRegist(Univ univ, ModelMap modelMap){
		
		//대학담당자일 경우 모집요강파일 올리지 못하게 하도록 하기 위해 auth를 얻어가기 위하여 추가
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		
		modelMap.addAttribute("adminInfo", admin);
		
		//파일 환경 생성 [파일 업로드에 이미지와 동영상을 위한 환경설정을 하여 map 으로 저장한다 ]
		//fileController.configFileUpload("Univ");
		
		/*
		putLogofileConfig();
		putVodfileConfig();
		 * */
		putAttfileConfig();
	
		univ = univService.selectUnivInfo(univ.getUniversity_id());
		
		String[] chairman = univService.selectChairmanInfo(univ.getUniversity_id());
		String[] principal = univService.selectPrincipalInfo(univ.getUniversity_id());
		modelMap.addAttribute("chairman", chairman);
		modelMap.addAttribute("principal", principal);
		
		modelMap.addAttribute("gubunSelect",codeService.selectList(50, "Y"));
		modelMap.addAttribute("localSelect",codeService.selectList(67, "Y"));
		//학교정보관리
		modelMap.addAttribute("univInfo",univ);
		//대학메뉴 링크정보
		modelMap.addAttribute("univLinkList",univService.selectUnivLinkList(univ.getUniversity_id()));
		
		System.out.println( "univ.getEntermodel() : " + univ.getEntermodel());
		
		//파일 리스트를 가져온다.
		if(univ.getEntermodel() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(univ.getEntermodel()));
		}
		
		return null;
	}
	
	@RequestMapping("/popChairman")
	public String popChairman(Univ univ, ModelMap modelMap){
		String[] chairman = univService.selectChairmanInfo(univ.getUniversityId());
		modelMap.addAttribute("chairman", chairman);
		return null;
	}
	@RequestMapping("/popChairman_save")
	public String popChairman_save(ModelMap modelMap, Univ univ) {
		univService.updateChairmanInfo(univ);
		return null;
	}
	@RequestMapping("/popPrincipal")
	public String popPrincipal(Univ univ, ModelMap modelMap){
		String[] principal = univService.selectPrincipalInfo(univ.getUniversityId());
		modelMap.addAttribute("principal", principal);
		return null;
	}
	@RequestMapping("/popPrincipal_save")
	public String popPrincipal_save(ModelMap modelMap, Univ univ) {
		univService.updatePrincipalInfo(univ);
		return null;
	}
	
	@RequestMapping(value = "/univInfo_update_file", method = RequestMethod.POST)
	public String univInfo_update_file(HttpSession session, Univ univ, ModelMap modelMap){
		//param 객체에 로그인되어있는 사람의 id 를 셋팅.
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univ.setModifier(login.getUserId());
		
		SessionUploadConfig sessionUploadConfig;
		
		String originalFilename_0 = univ.getOriginalFilename_0();
		String originalFilename_1 = univ.getOriginalFilename_1();
		String originalFilename_2 = univ.getOriginalFilename_2();
		
		// 파일 데이터 입력
		if(!"".equals(originalFilename_0)){
			univ.setLogo_upfile_gid(fileUploadService.selectGroupKey());
			
			String path = (String)session.getAttribute(originalFilename_0);
			String original = (String)session.getAttribute(originalFilename_0 + "OriginalFilename");
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setUpfileGid(univ.getLogo_upfile_gid());
			fileUpload.setUpfileFilename(original);
			fileUpload.setUpfilePath(path);
			fileUpload.setUpfileRegister(login.getUserId());
			fileUpload.setUpfileSize(new File(path).length());
			fileUpload.setUpfileSource(originalFilename_0);
			fileUploadService.insertInfo(fileUpload);
		}
		
		if(!"".equals(originalFilename_1)){
			univ.setVideo_img_upfile_gid(fileUploadService.selectGroupKey());
			
			String path = (String)session.getAttribute(originalFilename_1);
			String original = (String)session.getAttribute(originalFilename_1 + "OriginalFilename");
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setUpfileGid(univ.getUpfileGid());
			fileUpload.setUpfileFilename(original);
			fileUpload.setUpfilePath(path);
			fileUpload.setUpfileRegister(login.getUserId());
			fileUpload.setUpfileSize(new File(path).length());
			fileUpload.setUpfileSource(originalFilename_1);
			fileUploadService.insertInfo(fileUpload);
		}
		
		if(!"".equals(originalFilename_2)){
			univ.setVideo_upfile_gid(fileUploadService.selectGroupKey());
			
			String path = (String)session.getAttribute(originalFilename_2);
			String original = (String)session.getAttribute(originalFilename_2 + "OriginalFilename");
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setUpfileGid(univ.getUpfileGid());
			fileUpload.setUpfileFilename(original);
			fileUpload.setUpfilePath(path);
			fileUpload.setUpfileRegister(login.getUserId());
			fileUpload.setUpfileSize(new File(path).length());
			fileUpload.setUpfileSource(originalFilename_2);
			fileUploadService.insertInfo(fileUpload);
		}
		
		
		univService.modifyUnivInfo_file(univ);
		
		return null;
	}
	
	
	@RequestMapping(value = "/univInfo_update", method = RequestMethod.POST)
	public String univInfo_update(HttpSession session, HttpServletRequest request, Univ univ, ModelMap modelMap){
		
		univInfoUpdateValidator.validate(univ, modelMap);
		if(univInfoUpdateValidator.hasErrors())
			return null;
		
		
		SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig("att");
		//SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig(request.getParameter("confKey"));
		//System.out.println("request.getParameter(confKey) " + request.getParameter("confKey"));
		//System.out.println(sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory());
		String savePath = sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory() + File.separator;
		
		
		
		
		//param 객체에 로그인되어있는 사람의 id 를 셋팅.
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univ.setModifier(login.getUserId());

		String originalFilename_0 = univ.getOriginalFilename_0();
		String originalFilename_1 = univ.getOriginalFilename_1();
		String originalFilename_2 = univ.getOriginalFilename_2();
		String originalFilename_3 = univ.getOriginalFilename_3();
		
		// 파일 데이터 입력
		
		
		int file_Gid = 0;
		//파일정보 저장을 위해 사용할 Bean.
		FileUpload courseFileUpload = new FileUpload();
		courseFileUpload.setUpfileRegister(login.getUserId());
		if(univ.getLogo_upfile_gid() == 0 && !"".equals(originalFilename_0)){
			file_Gid = fileUploadService.selectGroupKey();
			univ.setUpfileGid(file_Gid);
			courseFileUpload.setUpfileGid(file_Gid);
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_0());
			courseFileUpload.setUpfileSize(univ.getFileSize_0());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_0());
			courseFileUpload.setUpfileSource(univ.getSrcName_0());
			
			univ.setLogo_upfile_gid(fileUploadService.insertInfo(courseFileUpload));
		}

		if(univ.getVideo_img_upfile_gid() == 0 && !"".equals(originalFilename_1)){
			file_Gid = fileUploadService.selectGroupKey();
			univ.setUpfileGid(file_Gid);
			courseFileUpload.setUpfileGid(file_Gid);
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_1());
			courseFileUpload.setUpfileSize(univ.getFileSize_1());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_1());
			courseFileUpload.setUpfileSource(univ.getSrcName_1());
			
			univ.setVideo_img_upfile_gid(fileUploadService.insertInfo(courseFileUpload));
		}
		
		if(univ.getVideo_upfile_gid() == 0 && !"".equals(originalFilename_2)){
			file_Gid = fileUploadService.selectGroupKey();
			univ.setUpfileGid(file_Gid);
			courseFileUpload.setUpfileGid(file_Gid);
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_2());
			courseFileUpload.setUpfileSize(univ.getFileSize_2());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_2());
			courseFileUpload.setUpfileSource(univ.getSrcName_2());
			
			univ.setVideo_upfile_gid(fileUploadService.insertInfo(courseFileUpload));
		}
		
		
		/* 모집요강을 연도별로 관리한다.
		 * 기존의 cu_svc_attfileupload 테이블은 유지하고 사용자 화면에서 연도별로 1개씩 표현하기 위하여 
		 * upfile_gid 의 값에 연도를 붙혀 관리하고 sequence 가 겹칠 가능성이 있다
		 * 파일 업로드시 오류가 발생할 경우 upfile_gid 의 값이 20000000 번 이상이면 sequence 를 변경이 필요하다. 
		 * */
		
		/*
		if(univ.getEntermodel() == 0 && !"".equals(originalFilename_3)){
			file_Gid = fileUploadService.selectGroupKey();
			univ.setUpfileGid(file_Gid);
			courseFileUpload.setUpfileGid(file_Gid);
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_3());
			courseFileUpload.setUpfileSize(univ.getFileSize_3());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_3());
			courseFileUpload.setUpfileSource(univ.getSrcName_3());
			
			univ.setEntermodel(fileUploadService.insertInfo(courseFileUpload));
		}
		 * */
		
		if(univ.getUpfileSrc() != null && univ.getUpfileSrc().length > 0)
		{
			if(univ.getEntermodel() == 0)
				univ.setEntermodel(fileUploadService.selectGroupKey());
			
			for(int i = 0; i < univ.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(univ.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(univ.getUpfileSrc()[i] + "OriginalFilename");
				
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(univ.getEntermodel());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(login.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(univ.getUpfileSrc()[i]);
				fileUploadService.insertInfo(fileUpload);
			}
		}
		
		
		univService.modifyUnivInfo(univ);
		
		return null;
	}
	
	@RequestMapping("/popLinkRegist")
	public String popLinkRegist(Univ univ,ModelMap modelMap) throws UnsupportedEncodingException{
		
		//String 	univ_name 	= URLDecoder.decode(univ.getUniversity_name(), "UTF-8");
		String 	univ_name 	= univ.getUniversity_name();
		Integer univ_id 	= univ.getUniversity_id();
		
		//화면에서 보일 학교명,id
		modelMap.addAttribute("univ_name",univ_name);
		modelMap.addAttribute("univ_id",univ_id);
		
		//화면에서 보일 링크정보
		modelMap.addAttribute("linkInfo",univService.selectUnivLinkInfo(univ.getLink_id()));
		
		//메뉴구분 코드13
		modelMap.addAttribute("gubunSelect",codeService.selectList(13, "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/linkInfo_update", method = RequestMethod.POST)
	public String linkInfo_update(Univ univ, ModelMap modelMap){
		
		univInfoUpdateValidator.validate(univ, modelMap);
		if(univInfoUpdateValidator.hasErrors())
			return null;
		
		
		//param 객체에 로그인되어있는 사람의 id 를 셋팅.
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univ.setModifier(login.getUserId());
		
		//form 내용을 업데이트.. 메소드의 인자로 model 을 넘겨서 ibatis 에서 그대로 사용..
		univService.modifyLinkInfo(univ);
		
		return null;
	}
	
	//종합
	@RequestMapping("/introOverAllRegist")
	public String introOverAllRegist(Univ univ,ModelMap modelMap)
	{
		Logger.getLogger(this.getClass()).debug("introOverAllRegist start");
		
		putAttfileConfig();
		Integer university_id 	= univ.getUniversity_id();
		
		//화면에서 보일 학교명,id
		modelMap.addAttribute("univ_id",university_id);
		modelMap.addAttribute("univOverallInfo",univService.selectUnivOverallInfo(university_id));
		
		Logger.getLogger(this.getClass()).debug("introOverAllRegist end");
		
		return null;
	}
	
	//인삿말,비전,홍보센터,오시는길
	@RequestMapping("/introOptionRegist")
	public String introOptionRegist(Univ univ,ModelMap modelMap)
	{
		putAttfileConfig();
		Integer university_id 	= univ.getUniversity_id();
		modelMap.addAttribute("univ_id",university_id);
		modelMap.addAttribute("univOptionInfo",univService.selectUnivOptionInfo(university_id));
		return null;
	}
	
	@RequestMapping(value = "/introOptionResist_save", method = RequestMethod.POST)
	public String write(HttpSession session, Univ univ,ModelMap modelMap,SessionStatus sessionStatus) {
		
		
		univInfoUpdateValidator.validate(univ, modelMap);
		if(univInfoUpdateValidator.hasErrors())
			return null;
		
		//수정자 정보 입력.
		LoginUser login = loginInfoProvider.get().currentUser();
		univ.setModifier(login.getUserId());
		univ.setRegister(login.getUserId());

		/*
		 * 파일 신규 등록인 경우 그룹아이디를 생성하도록 한다. 기존 등록된 파일 그룹 아이디가 없을 경우 새롭게 groupid 생성
		 */
		
		// view 단에서 기존 이미지 파일 정보를 가지고 있는다.
		
		System.out.println("check UnivInfoController ===========================================================================start");
		Integer greeting_type_id 	= univ.getGreeting_type_id();
		System.out.println("greeting_type_id => " + greeting_type_id);
		
		Integer vision_type_id 		= univ.getVision_type_id();
		
		System.out.println("vision_type_id => " + vision_type_id);
		Integer location_type_id 	= univ.getLocation_type_id();
		
		System.out.println("location_type_id => "+location_type_id);
		Integer public_type_id 		= univ.getPublic_type_id();
		System.out.println("public_type_id => " + public_type_id);
		
		
		String originalFilename_0 = univ.getOriginalFilename_0();
		System.out.println("originalFilename_0 => " + originalFilename_0);
		String originalFilename_1 = univ.getOriginalFilename_1();
		System.out.println("originalFilename_1 => " + originalFilename_1);
		String originalFilename_2 = univ.getOriginalFilename_2();
		System.out.println("originalFilename_2 => " + originalFilename_2);
		String originalFilename_3 = univ.getOriginalFilename_3();
		System.out.println("originalFilename_3 => " + originalFilename_3);
		System.out.println("check UnivInfoController ===========================================================================end");

		
		// 파일 데이터 입력
		int file_Gid = 0;
		SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig("att");
		String savePath = sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory() + File.separator;
		
		System.out.println("check savePath ===> " + savePath);
		System.out.println("check savePath ===> " + savePath);
		System.out.println("check savePath ===> " + savePath);
		
		FileUpload courseFileUpload = new FileUpload();
		courseFileUpload.setUpfileRegister(login.getUserId());
		
		if(!"".equals(originalFilename_0) && univ.getGreeting_img_upfile_id() == 0)
		{
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_0());
			courseFileUpload.setUpfileSize(univ.getFileSize_0());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_0());
			courseFileUpload.setUpfileSource(univ.getSrcName_0());
			univ.setGreeting_img_upfile_id(fileUploadService.insertInfo(courseFileUpload));
		}
		
		if(!"".equals(originalFilename_1) && univ.getVision_img_upfile_id() == 0)
		{
			
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_1());
			courseFileUpload.setUpfileSize(univ.getFileSize_1());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_1());
			courseFileUpload.setUpfileSource(univ.getSrcName_1());
			univ.setVision_img_upfile_id(fileUploadService.insertInfo(courseFileUpload));
			
		}
		
		if(!"".equals(originalFilename_2) && univ.getLocation_img_upfile_id() == 0)
		{
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_2());
			courseFileUpload.setUpfileSize(univ.getFileSize_2());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_2());
			courseFileUpload.setUpfileSource(univ.getSrcName_2());
			univ.setLocation_img_upfile_id(fileUploadService.insertInfo(courseFileUpload));
			
		}
		
		if(!"".equals(originalFilename_3) && univ.getPublic_img_upfile_id() == 0)
		{
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath+univ.getSrcName_3());
			courseFileUpload.setUpfileSize(univ.getFileSize_3());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_3());
			courseFileUpload.setUpfileSource(univ.getSrcName_3());
			univ.setPublic_img_upfile_id(fileUploadService.insertInfo(courseFileUpload));
			
		}
	
		univService.updateUnivOption(univ);
		sessionStatus.setComplete();
		return null;
	}
	
	@RequestMapping(value = "/introOptionResist_save_file", method = RequestMethod.POST)
	public String write_file(HttpSession session, Univ univ,ModelMap modelMap,SessionStatus sessionStatus) {
		
		//수정자 정보 입력.
		LoginUser login = loginInfoProvider.get().currentUser();
		univ.setModifier(login.getUserId());
		univ.setRegister(login.getUserId());
		
		/*
		 * 파일 신규 등록인 경우 그룹아이디를 생성하도록 한다. 기존 등록된 파일 그룹 아이디가 없을 경우 새롭게 groupid 생성
		 */
		
		// view 단에서 기존 이미지 파일 정보를 가지고 있는다.
		Integer greeting_type_id 	= univ.getGreeting_type_id();
		Integer vision_type_id 		= univ.getVision_type_id();
		Integer location_type_id 	= univ.getLocation_type_id();
		Integer public_type_id 		= univ.getPublic_type_id();
		
		String originalFilename_0 = univ.getOriginalFilename_0();
		String originalFilename_1 = univ.getOriginalFilename_1();
		String originalFilename_2 = univ.getOriginalFilename_2();
		String originalFilename_3 = univ.getOriginalFilename_3();
		
		// 파일 데이터 입력
		int file_Gid = 0;
		
		if(!"".equals(originalFilename_0))
		{
			if(univ.getGreeting_img_upfile_id() == 0)
				univ.setGreeting_img_upfile_id(fileUploadService.selectGroupKey());
			
			String path = (String)session.getAttribute(originalFilename_0);
			String original = (String)session.getAttribute(originalFilename_0 + "OriginalFilename");
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setUpfileGid(univ.getUpfileGid());
			fileUpload.setUpfileFilename(original);
			fileUpload.setUpfilePath(path);
			fileUpload.setUpfileRegister(login.getUserId());
			fileUpload.setUpfileSize(new File(path).length());
			fileUpload.setUpfileSource(originalFilename_0);
			fileUploadService.insertInfo(fileUpload);
		}
		
		if(!"".equals(originalFilename_1))
		{
			if(univ.getVision_img_upfile_id() == 0)
				univ.setVision_img_upfile_id(fileUploadService.selectGroupKey());
			
			String path = (String)session.getAttribute(originalFilename_1);
			String original = (String)session.getAttribute(originalFilename_1 + "OriginalFilename");
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setUpfileGid(univ.getUpfileGid());
			fileUpload.setUpfileFilename(original);
			fileUpload.setUpfilePath(path);
			fileUpload.setUpfileRegister(login.getUserId());
			fileUpload.setUpfileSize(new File(path).length());
			fileUpload.setUpfileSource(originalFilename_1);
			fileUploadService.insertInfo(fileUpload);
		}
		
		if(!"".equals(originalFilename_2))
		{
			if(univ.getLocation_img_upfile_id() == 0)
				univ.setLocation_img_upfile_id(fileUploadService.selectGroupKey());
			
			String path = (String)session.getAttribute(originalFilename_2);
			String original = (String)session.getAttribute(originalFilename_2 + "OriginalFilename");
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setUpfileGid(univ.getUpfileGid());
			fileUpload.setUpfileFilename(original);
			fileUpload.setUpfilePath(path);
			fileUpload.setUpfileRegister(login.getUserId());
			fileUpload.setUpfileSize(new File(path).length());
			fileUpload.setUpfileSource(originalFilename_2);
			fileUploadService.insertInfo(fileUpload);
		}
		
		if(!"".equals(originalFilename_3))
		{
			if(univ.getPublic_img_upfile_id() == 0)
				univ.setPublic_img_upfile_id(fileUploadService.selectGroupKey());
			
			String path = (String)session.getAttribute(originalFilename_3);
			String original = (String)session.getAttribute(originalFilename_3 + "OriginalFilename");
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setUpfileGid(univ.getUpfileGid());
			fileUpload.setUpfileFilename(original);
			fileUpload.setUpfilePath(path);
			fileUpload.setUpfileRegister(login.getUserId());
			fileUpload.setUpfileSize(new File(path).length());
			fileUpload.setUpfileSource(originalFilename_3);
			fileUploadService.insertInfo(fileUpload);
		}
		
		// 게시판 정보 업데이트
		univService.updateUnivOption_file(univ);
		
		sessionStatus.setComplete();
		return null;
	}
	
	//종합 save
	@RequestMapping(value = "/introOverallResist_save", method = RequestMethod.POST)
	public String overall_write(HttpSession session, Univ univ, ModelMap modelMap, SessionStatus sessionStatus,
			@RequestParam(required = true)  Integer imgUpfileGid, String originalFilename, String srcName, Long fileSize ) {
		
		if(imgUpfileGid == null) imgUpfileGid = 0;
		
		//등록형태 이미지일경우
		if(univ.getImgTypeId() == 23){
			univ.setOriginalFilename_0(originalFilename);
			univ.setSrcName_0(srcName);
			univ.setFileSize_0(fileSize);
		}
						
		univInfoUpdateValidator.validate(univ, modelMap);
		
		if(univInfoUpdateValidator.hasErrors())
			return null;
		
		//수정자 정보 입력.
		LoginUser login = loginInfoProvider.get().currentUser();
		univ.setModifier(login.getUserId());
		univ.setRegister(login.getUserId());

		/*
		 * 파일 신규 등록인 경우 그룹아이디를 생성하도록 한다. 기존 등록된 파일 그룹 아이디가 없을 경우 새롭게 groupid 생성
		 */
		
		// view 단에서 기존 이미지 파일 정보를 가지고 있는다.
		
		String originalFilename_0 = univ.getOriginalFilename_0();
		String originalFilename_1 = univ.getOriginalFilename_1();
		String originalFilename_2 = univ.getOriginalFilename_2();
		String originalFilename_3 = univ.getOriginalFilename_3();
		
		// 파일 데이터 입력 s
		int file_Gid = 0;
		SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig("att");
		String savePath = sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory() + File.separator;
		FileUpload courseFileUpload = new FileUpload();
		courseFileUpload.setUpfileRegister(login.getUserId());
		
		if(univ.getImgUpfileGid0() == 0 && !"".equals(originalFilename_0))
		{
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath + univ.getSrcName_0());
			courseFileUpload.setUpfileSize(univ.getFileSize_0());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_0());
			courseFileUpload.setUpfileSource(univ.getSrcName_0());
			univ.setImgUpfileGid0(fileUploadService.insertInfo(courseFileUpload));
			
		}
		
		if(univ.getImgUpfileGid1() == 0 && !"".equals(originalFilename_1))
		{
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath + univ.getSrcName_1());
			courseFileUpload.setUpfileSize(univ.getFileSize_1());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_1());
			courseFileUpload.setUpfileSource(univ.getSrcName_1());
			univ.setImgUpfileGid1(fileUploadService.insertInfo(courseFileUpload));
		}
		
		if(univ.getImgUpfileGid2() == 0 && !"".equals(originalFilename_2))
		{
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath + univ.getSrcName_2());
			courseFileUpload.setUpfileSize(univ.getFileSize_2());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_2());
			courseFileUpload.setUpfileSource(univ.getSrcName_2());
			univ.setImgUpfileGid2(fileUploadService.insertInfo(courseFileUpload));
		}
		
		if(univ.getImgUpfileGid3() == 0 && !"".equals(originalFilename_3))
		{
			courseFileUpload.setUpfileGid(fileUploadService.selectGroupKey());
			courseFileUpload.setUpfilePath(savePath + univ.getSrcName_3());
			courseFileUpload.setUpfileSize(univ.getFileSize_3());
			courseFileUpload.setUpfileFilename(univ.getOriginalFilename_3());
			courseFileUpload.setUpfileSource(univ.getSrcName_3());
			univ.setImgUpfileGid3(fileUploadService.insertInfo(courseFileUpload));
		}
		
		// 파일 데이터 입력 e

		// 게시판 정보 업데이트
		univService.updateUnivOverallInfo(univ);
		
		modelMap.addAttribute("univOverallInfo", univ);
		sessionStatus.setComplete();
		return null;
	}
	
	/************** 파일 삭제 처리 **************/
	@RequestMapping(value = "/introOverall_File_delete")
	public String introOverallFiledeleteDB(Univ univParm, ModelMap modelMap,
				@RequestParam(required = true) Integer fileIndex, Integer imgUpfileGid, Integer updateYn) {
		
		Logger.getLogger(this.getClass()).debug("DATA fileIndex : " + fileIndex);
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid0 : " + univParm.getImgUpfileGid0());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid1 : " + univParm.getImgUpfileGid1());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid2 : " + univParm.getImgUpfileGid2());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid3 : " + univParm.getImgUpfileGid3());
		
		if(fileIndex == 0 && univParm.getImgUpfileGid0() == 0)
			return null;
		if(fileIndex == 1 && univParm.getImgUpfileGid1() == 0)
			return null;		
		if(fileIndex == 2 && univParm.getImgUpfileGid2() == 0)
			return null;		
		if(fileIndex == 3 && univParm.getImgUpfileGid3() == 0)
			return null;		
		if(fileIndex == 4 && imgUpfileGid == 0)
			return null;	
		
		if(fileIndex == 0){
			univParm.setImgUpfileGid0(0);
		} else if(fileIndex == 1){
			univParm.setImgUpfileGid1(0);
		} else if(fileIndex == 2){
			univParm.setImgUpfileGid2(0);
		} else if(fileIndex == 3){
			univParm.setImgUpfileGid3(0);
		} else if(fileIndex == 4){
			univParm.setImgUpfileGid0(0);
		} else {
			return null;		
		}
		
		if(updateYn == null) 
			updateYn = 0;
		
		//모든 파일이 삭제되었는지 확인 후에 부모테이블 그룹파일값을 null로 초기화 한다
		if(updateYn != 1)
			univService.initFileOverall(univParm);
		
		return null;
	}
	@RequestMapping(value = "/introDefault_File_delete")
	public String introDefaultFiledeleteDB(Univ univParm, ModelMap modelMap,
				@RequestParam(required = true) Integer fileIndex, Integer imgUpfileGid, Integer updateYn) {
		
		Logger.getLogger(this.getClass()).debug("DATA fileIndex : " + fileIndex);
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid0 : " + univParm.getImgUpfileGid0());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid1 : " + univParm.getImgUpfileGid1());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid2 : " + univParm.getImgUpfileGid2());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid3 : " + univParm.getImgUpfileGid3());
		
		if(fileIndex == 0 && univParm.getLogo_upfile_gid() == 0)
			return null;
		if(fileIndex == 1 && univParm.getVideo_img_upfile_gid() == 0)
			return null;		
		if(fileIndex == 2 && univParm.getVideo_upfile_gid() == 0)
			return null;		
		
		
		if(fileIndex == 0){
			univParm.setLogo_upfile_gid(0);
		} else if(fileIndex == 1){
			univParm.setVideo_img_upfile_gid(0);
		} else if(fileIndex == 2){
			univParm.setVideo_upfile_gid(0);
		} else {
			return null;		
		}
		
		if(updateYn == null) 
			updateYn = 0;
		
		//모든 파일이 삭제되었는지 확인 후에 부모테이블 그룹파일값을 null로 초기화 한다
		if(updateYn != 1)
			univService.initFileDefault(fileIndex, univParm);
		
		return null;
	}
	@RequestMapping(value = "/introOption_File_delete")
	public String introOptionFiledeleteDB(Univ univParm, ModelMap modelMap,
				@RequestParam(required = true) Integer fileIndex, Integer imgUpfileGid, Integer updateYn) {
		
		Logger.getLogger(this.getClass()).debug("DATA fileIndex : " + fileIndex);
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid0 : " + univParm.getImgUpfileGid0());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid1 : " + univParm.getImgUpfileGid1());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid2 : " + univParm.getImgUpfileGid2());
		Logger.getLogger(this.getClass()).debug("DATA getImgUpfileGid3 : " + univParm.getImgUpfileGid3());
		
		if(fileIndex == 0 && univParm.getGreeting_img_upfile_id() == 0)
			return null;
		if(fileIndex == 1 && univParm.getVision_img_upfile_id() == 0)
			return null;		
		if(fileIndex == 2 && univParm.getLocation_img_upfile_id() == 0)
			return null;		
		if(fileIndex == 3 && univParm.getPublic_img_upfile_id() == 0)
			return null;		

		
		if(fileIndex == 0){
			univParm.setGreeting_img_upfile_id(0);
		} else if(fileIndex == 1){
			univParm.setVision_img_upfile_id(0);
		} else if(fileIndex == 2){
			univParm.setLocation_img_upfile_id(0);
		} else if(fileIndex == 3){
			univParm.setPublic_img_upfile_id(0);
		} else {
			return null;		
		}
		
		if(updateYn == null) 
			updateYn = 0;
		
		//모든 파일이 삭제되었는지 확인 후에 부모테이블 그룹파일값을 null로 초기화 한다
		if(updateYn != 1)
			univService.initFileOption(fileIndex, univParm);
		
		return null;
	}
	/************** 파일 삭제 처리 **************/
	@RequestMapping(value = "/introOverAll_imgMap")
	public String imgMap(Univ univParm, ModelMap modelMap) {
		return null;
	}
}
