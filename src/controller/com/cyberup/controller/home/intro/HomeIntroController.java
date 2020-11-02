package com.cyberup.controller.home.intro;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.course.CourseSearch;
import com.cyberup.model.univ.Univ;
import com.cyberup.service.course.CourseSearchService;
import com.cyberup.service.stats.ServiceStatsService;
import com.cyberup.service.univ.AcademyinfoLinkService;
import com.cyberup.service.univ.UnivService;
import com.ibm.icu.text.SimpleDateFormat;

/**-----------------------------------------------------------------------
 * Cuinfo Project
 *------------------------------------------------------------------------
 * @Class HomeIntroController.java
 * @Description 인트로 메인 컨트롤러
 * @author 김세아
 * @since -
 * @version 1.0
 *
 * @Copyright (c) 2019 코테크시스템  All rights reserved.
 *------------------------------------------------------------------------
 * Modification Information
 *------------------------------------------------------------------------
 * 수정일       수정자       수정내용
 * ----------- ---------  -----------------------------------------------
 * -			-			최초생성
 * 2019.03.26 	김세아		[사이버대학 안내]-[교육부 지원사업]-[교육부 지원사업(2018) 성인 학습자 역량 강화 교육콘텐츠 개발 사업 페이지 추가]
 */

@Controller
@RequestMapping("/home/intro")
public class HomeIntroController {
	
	@Autowired
	private UnivService univService;
	@Autowired
	private ServiceStatsService serviceStatsService;
	@Autowired
	private AcademyinfoLinkService academyinfoLinkService;
	@Autowired
	private CourseSearchService courseSearchService;
	
	@RequestMapping("/summary")
	public String summary(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/summaryGrad")
	public String summaryGrad(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/guidenew")
	public String guidenew(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/guideGrad")
	public String guideGrad(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/seminarGrad")
	public String seminarGrad(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/cyberPaperGrad")
	public String cyberPaperGrad(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/yearHistory")
	public String yearHistory(ModelMap model) {
		return null;
	}
	@RequestMapping("/guideTime")
	public String guideTime(ModelMap model) {
		return null;
	}
	@RequestMapping("/certificate1")
	public String certificate1(ModelMap model) {
		return null;
	}
	@RequestMapping("/certificate2")
	public String certificate2(ModelMap model) {
		return null;
	}
	@RequestMapping("/certificate3")
	public String certificate3(ModelMap model) {
		return null;
	}
	@RequestMapping("/certificate3_pop")
	public String certificate3_pop(ModelMap model) {
		return null;
	}
	@RequestMapping("/certificate4")
	public String certificate4(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/overall")
	public String overall(Univ univ,ModelMap model) {
		
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		
		if(univ.getUniversity_id() != 0)
			model.addAttribute("university_id",univ.getUniversity_id());
		
		return null;
	}
	
	@RequestMapping("/overallUnivList")
	public String overallUnivList(Univ univ,ModelMap model) {
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		return null;
	}
	
	@RequestMapping("/successUnivList")
	public String successUnivList(Univ univ,ModelMap model) {
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		return null;
	}
	
	@RequestMapping("/overallUnivInfo")
	public String selectUniv(Univ univ,ModelMap model) {
		serviceStatsService.insServiceHits(Integer.toString(univ.getUniversity_id()), "");
		
		//대학 정보 조회
		model.addAttribute("univTotalInfo", univService.selectUnivTotalInfo(univ));
		model.addAttribute("univLinkSchool",univService.selectUnivLinkSchool(univ));
		model.addAttribute("univLinkGraduate",univService.selectUnivLinkGraduate(univ));
		model.addAttribute("univLinkEntrance",univService.selectUnivLinkEntrance(univ));
		model.addAttribute("univLinkAttached",univService.selectUnivLinkAttached(univ));
		
		model.addAttribute("univDeptList",univService.selectUnivDept(univ));
		model.addAttribute("academyinfoLinkList",  academyinfoLinkService.selectViewList());
		
		SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date dTime = new Date();
		
		sdt = new SimpleDateFormat("yyyy", Locale.KOREA);
		dTime = new Date();
		String sTime = sdt.format(dTime);
		//model.addAttribute("selectYear", Integer.parseInt(sTime));
		model.addAttribute("selectYear", Integer.parseInt(sTime) - 1 );
		
		return null;
	}
	
	@RequestMapping("/overallUnivInfoGraduate")
	public String selectUnivGraduate(Univ univ,ModelMap model) {
		serviceStatsService.insServiceHits(Integer.toString(univ.getUniversity_id()), "");
		
		//대학원 정보 조회
		model.addAttribute("univTotalInfo", univService.selectUnivTotalInfo(univ));
		model.addAttribute("univLinkSchool",univService.selectUnivLinkSchool(univ));
		model.addAttribute("univLinkGraduate",univService.selectUnivLinkGraduate(univ));
		model.addAttribute("univLinkEntrance",univService.selectUnivLinkEntrance(univ));
		model.addAttribute("univLinkAttached",univService.selectUnivLinkAttached(univ));
		
		model.addAttribute("univDeptList",univService.selectUnivDept(univ));
		model.addAttribute("academyinfoLinkList",  academyinfoLinkService.selectViewList());
		
		SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date dTime = new Date();
		
		sdt = new SimpleDateFormat("yyyy", Locale.KOREA);
		dTime = new Date();
		String sTime = sdt.format(dTime);
		//model.addAttribute("selectYear", Integer.parseInt(sTime));
		model.addAttribute("selectYear", Integer.parseInt(sTime) - 1 );
		
		return null;
	}
	
	//학교정보관리. 기본정보수정 미리보기 (sitemesh 설정상 사용자쪽 controller 로 옮겨야함..)
	@RequestMapping("/overall_preview")
	public String overall_preview(Univ univ,ModelMap model, 
									Integer imgUpfileGid, String originalFilename, String srcName, Long fileSize )
	{
		univ.setShowCnt(999);
		
		model.addAttribute("univTotalInfo", univService.selectUnivTotalInfo(univ));
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		model.addAttribute("univDeptList",univService.selectUnivDept(univ));
		model.addAttribute("univLinkSchool",univService.selectUnivLinkSchool(univ));
		model.addAttribute("univLinkGraduate",univService.selectUnivLinkGraduate(univ));
		model.addAttribute("univLinkEntrance",univService.selectUnivLinkEntrance(univ));
		
		if(imgUpfileGid == null) imgUpfileGid = 0;
		if(univ.getImgTypeId() == 23){
			univ.setImgUpfileGid0(imgUpfileGid);
			univ.setSrcName_0(srcName);
			univ.setOriginalFilename_0(originalFilename);
			univ.setFileSize_0(fileSize);
		}
		
		Integer previewGubn 	= univ.getPreviewGubn(); 
		Integer universityId 	= univ.getUniversityId();
		
		model.addAttribute("univ",univ);
		model.addAttribute("universityId",universityId);
		model.addAttribute("previewGubn",previewGubn);
		
		//미리보기 구분값에 따라 열리는 화면 지정
		return "/home/intro/overall_preview.vm";
	}
	
	//대학원 소개 페이지 추가
	@RequestMapping("/overallGraduate")
	public String overallGraduate(Univ univ,ModelMap model) {
		model.addAttribute("univList",univService.selectGraduateUnivList(univ));
		
		if(univ.getUniversity_id() != 0)
			model.addAttribute("university_id",univ.getUniversity_id());
		
		return null;
	}
	
	
	//성공수기
	@RequestMapping("/successStory")
	public String successStory(Univ univ,ModelMap model)
	{
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		
		if(univ.getUniversity_id() != 0)
			model.addAttribute("university_id",univ.getUniversity_id());
		return null;
	}
	
	//성공수기
	@RequestMapping("/successStoryInfo")
	public String successStoryInfo(Univ univ,ModelMap modelMap)
	{
		modelMap.addAttribute("univName",univ.getUnivName());
		modelMap.addAttribute("successLink",univService.selectSuccessLink(univ));
		modelMap.addAttribute("successStory",univService.selectSuccessStory(univ));
		return null;
	}
	
	@RequestMapping("/characterization2014")
	public String charaterization2014(ModelMap modelMap) {
		return null;
	}
	
	@RequestMapping("/characterization")
	public String charaterization(ModelMap modelMap) {
		return null;
	}
	
	@RequestMapping("/characterizationResult")
	public String characterizationResult(ModelMap modelMap) {
		return null;
	}
	
	@RequestMapping("/goodCase")
	public String goodCase(ModelMap modelMap) { return null; }

	@RequestMapping("/empowermentDev")
	public String empowermentDev(ModelMap modelMap){ return null; }

	@RequestMapping("/certificate_subjectInfo")
	public String certificate_subjectInfo(ModelMap model, CourseSearch courseSearch, String gnb) {
		
		//페이지에서 타이틀 이미지변경을위해 gnb 값을 셋팅
		model.addAttribute("gnb", gnb);
		
		List<CourseSearch> list = courseSearchService.searchOpenCourseForCertificate(courseSearch);
		model.addAttribute("courseList", list);
		if(list.size() > 0)
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	
	@RequestMapping("/graduateList")
	public String graduateList(ModelMap modelMap, String univName) {
		modelMap.addAttribute("graduate",univName);
		modelMap.addAttribute("graduateList",univService.graduateList(univName));
		return null;
	}
	
	@RequestMapping("/graduateList2")
	public String graduateList2(ModelMap modelMap, String univName) {
		modelMap.addAttribute("graduate",univName);
		modelMap.addAttribute("graduateList",univService.graduateList(univName));
		return null;
	}
	
}