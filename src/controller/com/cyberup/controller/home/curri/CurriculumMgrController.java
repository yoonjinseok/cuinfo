package com.cyberup.controller.home.curri;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.curri.Curriculum;
import com.cyberup.model.system.ReptClassification;
import com.cyberup.model.system.ReptDept;
import com.cyberup.model.univ.Univ;
import com.cyberup.model.univ.UnivDept;
import com.cyberup.service.common.HomeMainService;
import com.cyberup.service.curri.CurriculumService;
import com.cyberup.service.stats.ServiceStatsService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.ReptClassificationService;
import com.cyberup.service.system.ReptDeptService;
import com.cyberup.service.univ.UnivDeptService;
import com.cyberup.service.univ.UnivService;

@Controller
@RequestMapping("/home/curri")
public class CurriculumMgrController {
	@Autowired
	private CurriculumService curriculumService;
	
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	@Autowired
	private UnivDeptService univDeptService;
	
	@Autowired
	private ReptDeptService reptDeptService;
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private ReptClassificationService reptClassificationService;

	@Autowired
	private ServiceStatsService statsService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@RequestMapping("/areadept")
	public String areadept(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/areadeptList")
	public String areadeptList(Curriculum curriculum, ModelMap model) {
		List list = curriculumService.selectDeptList(curriculum);
		model.addAttribute("deptList", list);
		return null;
	}
	
	@RequestMapping("/deptDetail")
	public String deptDetail(Curriculum curriculum, ModelMap model) {
		
		//deptId를 설정하고, 페이징처리시 사용가능하도록 한다.
		model.addAttribute("param", curriculum);
		return null;
	}
	
	@RequestMapping("/deptDetailList")
	public String deptDetailList(Curriculum curriculum, ModelMap model) {
		List<Curriculum> list = curriculumService.selectDeptDetailList(curriculum);
		model.addAttribute("deptDetailList", list);
		
		if(list.size() > 0)
			PagingModel.mappPages(model, curriculum.getCurrPage(), curriculum.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, curriculum.getCurrPage(), curriculum.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping("/curriculum")
	public String curriculum(Curriculum curriculum, ModelMap model) {
		//학과클릭시 로그입력
		statsService.insServiceHits(curriculum.getUniversityId(), curriculum.getUnivdeptId());
		
		model.addAttribute("curriculumList", curriculumService.selectCurriculumList(curriculum));
		return null;
	}
	
	
	@RequestMapping("/curriKH1")
	public String curriKH1(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriKH2")
	public String curriKH2(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriKH3")
	public String curriKH3(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriKH4")
	public String curriKH4(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriCUK")
	public String curriCUK(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriDCU")
	public String curriDCU(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriBDU1")
	public String curriBDU1(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriBDU2")
	public String curriBDU2(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriTESOL")
	public String curriTESOL(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriISCU1")
	public String curriISCU1(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriISCU2")
	public String curriISCU2(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriSJCU1")
	public String curriSJCU1(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriSJCU2")
	public String curriSJCU2(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriWDU")
	public String curriWDU(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU1")
	public String curriHYCU1(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU2")
	public String curriHYCU2(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU3")
	public String curriHYCU3(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU4")
	public String curriHYCU4(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU5")
	public String curriHYCU5(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU6")
	public String curriHYCU6(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU7")
	public String curriHYCU7(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU8")
	public String curriHYCU8(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU9")
	public String curriHYCU9(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	@RequestMapping("/curriHYCU10")
	public String curriHYCU10(Curriculum curriculum, ModelMap model) {
		return null;
	}
	
	//학과네비게이션
	
	@RequestMapping("/deptList")
	public String selectDeptList(ModelMap model, Curriculum curriculum) {
		model.addAttribute("classifyName",curriculum.getClassifyName());
		model.addAttribute("deptList",curriculumService.selectDeptList(curriculum));
		return null;
	}
	
	/**20130917 뒤로가기 기능관련 수정
	 * @param model
	 * @param curriculum
	 * @return
	 */
	@RequestMapping("/navigationMajorArea")
	public String navigationMajorArea(ModelMap model, Curriculum curriculum) {
		
		model.addAttribute("curriculum", curriculum);
		model.addAttribute("classifyList",curriculumService.selectClassifyList());
		
		if(curriculum.getClassifyId() != null && !curriculum.getClassifyId().equals(""))
			model.addAttribute("deptList",curriculumService.selectDeptList(curriculum));
		
		return null;
	}
	
	@RequestMapping("/navigationMajorAreaGrad")
	public String navigationMajorAreaGrad(ModelMap model, Curriculum curriculum) {
		
		model.addAttribute("curriculum", curriculum);
		model.addAttribute("classifyList",curriculumService.selectClassifyList());
		
		if(curriculum.getClassifyId() != null && !curriculum.getClassifyId().equals(""))
			model.addAttribute("deptList",curriculumService.selectDeptList(curriculum));
		
		return null;
	}
	
	@RequestMapping("/navigationMajorArea_list")
	public String navigationMajorArea_list(Curriculum curriculum, ModelMap model){
		
		List list = curriculumService.selectDeptList(curriculum);
		model.addAttribute("deptList", list );
		
		return null;
	}
	
	@RequestMapping("/deptUnivList")
	public String deptUnivList(Curriculum curriculum, ModelMap model){
		
		List list = curriculumService.deptUnivList(curriculum);
		model.addAttribute("deptUnivList", list );
		
		return null;
	}
	
	@RequestMapping("/selectUnivList")
	public String selectUnivList(Curriculum curriculum, ModelMap model){
		
		List list = curriculumService.selectUnivList(curriculum);
		model.addAttribute("selectUnivList", list );
		
		return null;
	}
	
	@RequestMapping("/searchMajor")
	public String searchMajor(Curriculum curriculum, ModelMap model, ServletRequest request){
		List list = curriculumService.deptUnivList(curriculum);
		model.addAttribute("deptUnivList", list );
		model.addAttribute("universityId", request.getParameter("universityId"));
		model.addAttribute("univDeptName", request.getParameter("deptName"));
		model.addAttribute("classifyId", request.getParameter("classifyId"));
		model.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","","3", "1", "1", "Y"));
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("localSelect",codeService.selectList(67, "Y"));
		return null;
	}
	
	public String searchMajor(ModelMap model, ServletRequest request) {
		
		Logger.getLogger(this.getClass()).debug("DATA_searchMajor :" + request.getParameter("deptName") );
		Logger.getLogger(this.getClass()).debug("DATA_searchMajor :" + request.getParameter("classifyId") );
		
		model.addAttribute("universityId", request.getParameter("universityId"));
		model.addAttribute("univDeptName", request.getParameter("deptName"));
		model.addAttribute("classifyId", request.getParameter("classifyId"));
		model.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","","3", "1", "1", "Y"));
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("localSelect",codeService.selectList(67, "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/searchMajor_list", method = RequestMethod.POST)
	public String list(UnivDept univDeptParam, ModelMap model) {

		Logger.getLogger(this.getClass()).debug("DATA :" + univDeptParam.getShowCnt() );
		
		/*사용자 학과 리스트
		 * 대학별관리자의경우 리스트가 제한(3) 되며 사용자는 기본값으로 (0) 값이 들어간다.*/
		List<UnivDept> list = univDeptService.selectList(univDeptParam.getShowCnt(), univDeptParam.getCurrPage(), 
													univDeptParam.getUniversityId(), univDeptParam.getUniversityName(), 
													univDeptParam.getUnivDeptId(), univDeptParam.getUnivDeptName(), 
													univDeptParam.getDeptId(), univDeptParam.getDeptName(),
													univDeptParam.getDeptAllName(),
													univDeptParam.getClassifyId(), univDeptParam.getLocalId(),
													univDeptParam.getSearchCon1(),"1", univDeptParam.getSearchCon2(), 
													univDeptParam.getUseYn(),0);
		
		
		model.addAttribute("univDeptList", list );
		
		if(list.size() > 0)
			PagingModel.mappPages(model, univDeptParam.getCurrPage(), univDeptParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, univDeptParam.getCurrPage(), univDeptParam.getShowCnt(), new PagingModel());

		return null;
	}
	
	
	
	
	
	
	
	
}
