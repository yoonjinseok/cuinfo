package com.cyberup.controller.home.intro;


import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.ReptDept;
import com.cyberup.model.univ.UnivDept;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.ReptClassificationService;
import com.cyberup.service.system.ReptDeptService;
import com.cyberup.service.system.UnivCodeService;
import com.cyberup.service.univ.UnivDeptService;
import com.cyberup.service.stats.ServiceStatsService;
import com.ibm.icu.text.SimpleDateFormat;

@Controller
@RequestMapping("/home/intro")
public class searchMajorMgrController {
	
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private ReptDeptService reptDeptService;
	@Autowired
	private UnivDeptService univDeptService;
	@Autowired
	private ReptClassificationService reptClassificationService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private ServiceStatsService serviceStatsService;
	
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@RequestMapping("/searchMajor")
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
	public String list(UnivDept univDeptParam, ModelMap modelMap) {

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
		
		
		modelMap.addAttribute("univDeptList", list );
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, univDeptParam.getCurrPage(), univDeptParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, univDeptParam.getCurrPage(), univDeptParam.getShowCnt(), new PagingModel());

		return null;
	}
	
	@RequestMapping(value = "/searchMajorRank_list", method = RequestMethod.POST)
	public String rankList(UnivDept univDeptParam, ModelMap modelMap, @RequestParam(required=true) Integer searchCnt, Integer selectDeptId) {
		
		Logger.getLogger(this.getClass()).debug("selectDeptId :" + selectDeptId);
		List<ReptDept> list2 = reptDeptService.selectList(searchCnt, 1, "", "", "", "2", "2", "1","Y");
		modelMap.addAttribute("selectDeptId", selectDeptId);
		modelMap.addAttribute("reptDeptList", list2 );

		return null;
	}
	
	@RequestMapping(value = "/searchMajor_click", method = RequestMethod.POST)
	public String save(UnivDept univDeptParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date dTime = new Date();
		
		Logger.getLogger(this.getClass()).debug("dTime :" + dTime);
		Logger.getLogger(this.getClass()).debug("dTime :" + sdt.format(dTime));
		Logger.getLogger(this.getClass()).debug("getUniversityId :" + univDeptParam.getUniversityId());
		Logger.getLogger(this.getClass()).debug("DeptId :" + univDeptParam.getDeptId());
		
		serviceStatsService.insServiceHits(Integer.toString(univDeptParam.getUniversityId()), univDeptParam.getUnivDeptId());
		sessionStatus.setComplete();
		
		return null;
	}
}
