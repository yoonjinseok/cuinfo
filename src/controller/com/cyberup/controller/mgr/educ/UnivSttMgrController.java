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

import net.dcollection.service.common.Logger;

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
import com.cyberup.model.course.CourseSearch;
import com.cyberup.model.educ.Statisitics;
import com.cyberup.model.educ.UnivStt;
import com.cyberup.model.home.FileUpload;
import com.cyberup.service.course.CourseSearchService;
import com.cyberup.service.educ.StatisiticsService;
import com.cyberup.service.educ.UnivSttService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.util.DateFormatter;
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
public class UnivSttMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator univSttUpdateValidator;
	
	@Autowired
	private UnivSttService univSttService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private FileUploadController fileUploadController;
	
	@Autowired
	private CourseSearchService courseSearchService;
	
	@Autowired
	private StatisiticsService statisiticsService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@Inject
	protected Provider<SessionUploadConfigMap> sessionUploadConfigMap;

	@Resource(name = "univSttUpdateValidator")
	public void setUnivSttUpdateValidator(MapValidator univSttUpdateValidator) {
		this.univSttUpdateValidator = univSttUpdateValidator;
	}

	@RequestMapping("/univStt")
	public String board(ModelMap model) {
		
		CourseSearch cs = new CourseSearch();		
		cs.setGubunId("0");
		model.addAttribute("univList",courseSearchService.selectUnivList(cs));
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		model.addAttribute("authLeverlId",admin.getAuthLevelId());
		
		return null;
	}

	/************** 리스트 **************/
	@RequestMapping(value = "/univStt_list", method = RequestMethod.POST)
	public String list(UnivStt univSttParam, ModelMap modelMap,
			String searchValue1, String searchValue2,
			String searchValue3, String searchValue4, String searchValue5) throws Exception {

		// 검색조건에 따라 내용/제목으로 검색할 수 있도록 변수를세팅한다.
		if ((StringUtils.hasLength(searchValue1))) {
			univSttParam.setTermState(searchValue1);
		}		
		if ((StringUtils.hasLength(searchValue2))) {
			univSttParam.setSttName(searchValue2);
		}
		if ((StringUtils.hasLength(searchValue3))) {
			univSttParam.setPutState(searchValue3);
		}
		if ((StringUtils.hasLength(searchValue4))) {
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			Date regDate = null;
			regDate = sdt.parse(searchValue4);
			univSttParam.setSttRegDate(regDate);
		}
		if ((StringUtils.hasLength(searchValue5))) {
			univSttParam.setUniversityID(Integer.valueOf(searchValue5));
		} else {
			Admin admin = (Admin)loginInfoProvider.get().currentUser();
			univSttParam.setUniversityID(admin.getUniversityId());
		}
		
		List<UnivStt> list = univSttService.selectList(univSttParam.getShowCnt(),
				univSttParam.getCurrPage(), univSttParam.getTermState(),
				univSttParam.getSttName(), univSttParam.getSttRegDate(),
				univSttParam.getPutState(), univSttParam.getUniversityID());
		modelMap.addAttribute("univSttList", list);

		if (list.size() > 0)
			PagingModel.mappPages(modelMap, univSttParam.getCurrPage(),
					univSttParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, univSttParam.getCurrPage(),
					univSttParam.getShowCnt(), new PagingModel());

		return null;
	}
	
	private void putAttfileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("xls,xlsx");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "UnivStt" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
	}

	/************** 글 수정 초기 화면 **************/
	@RequestMapping(value = "/univStt_modify")
	public String modify(UnivStt univSttParm, ModelMap modelMap, @RequestParam(required = true) String sttID)
	{
		System.out.println("univSttParm ==> " + univSttParm);
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();	
		
		//파일 환경 생성
		putAttfileConfig();
		
		//수정하고자 하는 글을 가져온다.
		UnivStt univStt = univSttService.selectInfo(univSttParm);	
		
		//양식에 대응된 대학교별 문서가 없을 시 새로 생성한다.
		if(univStt == null || univStt.getSttUnivID() == 0)
		{
			long sttUnivID = univSttService.selectSEQ_STT_UNIVERSITY();
			univSttParm.setSttUnivID(sttUnivID);
			univSttParm.setRegister(admin.getAdminId());
			// 파일 gid 생성
			//univSttParm.setUpfileGid(fileController.selectSEQ_FILE_GID());
			
			// 대학별 통계문서 관리 생성
			univSttService.insertInfo(univSttParm);
			
			univStt = univSttService.selectInfo(univSttParm);	
		}
		
		modelMap.addAttribute("univStt",univStt);
		
		//파일 리스트를 가져온다.
		if(univStt.getUpfileGid() > 0)
		{
			if(univStt.getUpfileID() > 0){
				
				List list = new ArrayList();
				list.add(fileUploadService.selectInfo(univStt.getUpfileID()));
				modelMap.addAttribute("fileList", list);
			}
		}
		modelMap.addAttribute("upFileGid",univStt.getUpfileGid());
		
		return null;
	}
	
	
	@RequestMapping(value = "/excle_updateFail", method = RequestMethod.POST)
	public String updateFail(HttpSession session, UnivStt univSttParam, ModelMap modelMap,
			SessionStatus sessionStatus){
		
		univSttUpdateValidator.validate(univSttParam, modelMap);
		if (univSttUpdateValidator.hasErrors())
			return null;
		
		univSttService.updateFailInfo(univSttParam);
		
		return null;
	}
	
	/************** 수정 처리 기능(db 저장) **************/
	@RequestMapping(value = "/univStt_update", method = RequestMethod.POST)
	public String update(HttpSession session, UnivStt univSttParam, ModelMap modelMap,
			SessionStatus sessionStatus) {

		univSttUpdateValidator.validate(univSttParam, modelMap);
		if (univSttUpdateValidator.hasErrors())
			return null;
		
		int upfileID = 0;
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();	
		univSttParam.setModifier(admin.getUserId());

		if(univSttParam.getUpfileSrc() != null && univSttParam.getUpfileSrc().length > 0)
		{
			//파일 그룹아이디가 없을시 생성
			if(univSttParam.getUpfileGid() == 0)
				univSttParam.setUpfileGid(fileUploadService.selectGroupKey());
			
			for(int i = 0; i < univSttParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(univSttParam.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(univSttParam.getUpfileSrc()[i] + "OriginalFilename");

				//파일 DB저장
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(univSttParam.getUpfileGid());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(admin.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(univSttParam.getUpfileSrc()[i]);
				upfileID = fileUploadService.insertInfo(fileUpload);
			}
		}

		// 통계문서 정보 수정
		
		System.out.println("upfileID ==> " + upfileID);
		
		univSttParam.setUpfileID(upfileID);
		
		univSttService.updateInfo(univSttParam);
		
		// 통계문서 정보 업데이트 후 해당 양식 문서 수집완료 체크
		if(univSttParam.getSttID() != null || univSttParam.getSttID() != 0)
		univSttService.updateSttGatherStateY(univSttParam.getSttID() + "");

		///////////////////int sttFileCnt = univSttService.selectSttFileCnt(admin.getUniversityId());
		//admin.setSttFileCnt(sttFileCnt + "");
		
		loginInfoProvider.get().save(admin);
		
		sessionStatus.setComplete();
		
		return null;
	}	
	
	/************** 통계 파일 컬럼 저장 기능(db 저장) **************/
	@RequestMapping(value = "/excle_update", method = RequestMethod.POST)
	public String excleUpdate(HttpSession session, UnivStt univSttParam, ModelMap modelMap,
			SessionStatus sessionStatus, @RequestParam(required = true) String forNum) {
		
		univSttUpdateValidator.validate(univSttParam, modelMap);
		if (univSttUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		univSttParam.setModifier(login.getUserId());
		
		if(univSttParam.getUpfileSrc() != null && univSttParam.getUpfileSrc().length > 0)
		{
			
			for(int i = 0; i < univSttParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(univSttParam.getUpfileSrc()[i]);
				
				// 정기 유형 파일 일시 파일중에 데이터를 켑취하여 테이불에 저장
				if("Y".equals(univSttParam.getTermState())) 
				{
					// 파일에 데이터를 캡취하여 테이불에 저장
					univSttService.excelUpload(path, univSttParam.getSttUnivID(), modelMap, forNum);			
				}
			}
		}
		
		return null;
	}	
	
	
	
	/************** 학교 리스트 검색 **************/
	@RequestMapping("/univStt_univList")
	public String recommendByUniv_list(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));
		return null;
	}
	
	/************** 대학교 통계 파일 다운로드 [대학별]**************/
	@RequestMapping(value = "/univStt_selSttFileDown")
	public void selSttFileDown(HttpServletRequest request, HttpServletResponse response,
			Statisitics statisiticsParam, @RequestParam(required = true) Integer fileID)throws Exception 
	{
		// 파일 환경을 세팅한다.		
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("xls,xlsx");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Statisitics" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
		Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
		
		String path = sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory();	
		
		FileUpload file = fileUploadService.selectInfo(fileID);
		
		String fileSaveName = file.getUpfileSource();
		String fileSavePath = file.getUpfilePath();
		String fileOrigName = file.getUpfileFilename();
		
		try {
			fileUploadController.download(request, response, fileSavePath, fileOrigName); // 다운로드
		} catch (Exception e) {
			throw e;
		} finally {
			
		}
			
	}
	
	/************** 대학교 통계 파일 다운로드 [대학별]**************/
	public void selSttFileDown(HttpServletRequest request, HttpServletResponse response,
			Statisitics statisiticsParam, @RequestParam(required = true) String fileGid
			, @RequestParam(required = true) String sttID)throws Exception 
	{
		// 파일 환경을 세팅한다.		
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("xls,xlsx");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Statisitics" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
		Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	

		
		List<FileUpload> sttFileList = univSttService.selSttFileDown(fileGid);
		Statisitics statisitics = statisiticsService.selectInfo(Long.parseLong(sttID));
		ZipFileDownUtil zf = new ZipFileDownUtil();
		
		String path = sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + sessionUploadConfig.getUploadSubectory();	
		
		String zipName = statisitics.getSttName().replaceAll("\\s", "") + ".zip";
		
		if("Y".equals(statisitics.getTermState()))
			zipName = statisitics.getSttYear() + "_" + statisitics.getSttMonth() + "_" + zipName;
		
		String copyPolderName = statisitics.getSttName();
		
		try {
			zf.getStyleZipFile(sttFileList, path, copyPolderName, zipName); //zip 파일 생성
			fileUploadController.download(request, response, zf.getZipPath() + "/" + zipName, zipName); // 다운로드
		} catch (Exception e) {
			throw e;
		} finally {
			zf.delZipDir(); // 삭제
		}
	}
}
