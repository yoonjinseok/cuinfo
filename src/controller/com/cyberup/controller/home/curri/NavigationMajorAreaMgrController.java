package com.cyberup.controller.home.curri;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;
//import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.curri.Recommend;
import com.cyberup.model.system.ReptClassification;
import com.cyberup.model.system.ReptDept;
import com.cyberup.model.univ.AcademyinfoLink;
import com.cyberup.model.univ.Univ;
import com.cyberup.model.univ.UnivDept;
import com.cyberup.service.common.HomeMainService;
import com.cyberup.service.curri.RecommendService;
import com.cyberup.service.stats.ServiceStatsService;
import com.cyberup.service.system.ReptClassificationService;
import com.cyberup.service.system.ReptDeptService;
import com.cyberup.service.univ.UnivService;
import com.ibm.icu.text.SimpleDateFormat;

@Controller
@RequestMapping("/home/curri")
public class NavigationMajorAreaMgrController {
	@Autowired
	private HomeMainService homeMainService;
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	@Autowired
	private ReptDeptService reptDeptService;
	@Autowired
	private ReptClassificationService reptClassificationService;
	@Autowired
	private UnivService univService;
	@Autowired
	private RecommendService recommendService;

	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@RequestMapping("/major")
	public String overall(Univ univ,ModelMap model) {
		
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		
		if(univ.getUniversityId() != 0){
			univ.setUniversity_id(univ.getUniversityId());
			model.addAttribute("univMajorList", univService.selectMajorList(univ));
		}
		
		return null;
	}
	
	@RequestMapping("/major2")
	public String major2(ModelMap model) {

		return null;
	}
	
	
	@RequestMapping("/majorList")
	public String majorList(Univ univ,ModelMap model) {
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		return null;
	}
	
	@RequestMapping("/majorInfo")
	public String majorInfo(Univ univ, ModelMap model) {
		
		model.addAttribute("univName", univ.getUniv_name());
		model.addAttribute("univMajorList", univService.selectMajorList(univ));
		
		return null;
	}
	
	@RequestMapping("major_sampleLecture")
	public String sampleLecture(Recommend recommend, ModelMap model) {
		
		model.addAttribute("sampleList", recommendService.sampleLectureList(recommend));
		
		return null;
	}
	
	@RequestMapping("major_recommendLecture")
	public String recommendLecture(Recommend recommend, ModelMap model) {
		
		model.addAttribute("recommendList", recommendService.recommendLectureList(recommend));
		
		return null;
	}
	
	
	
	
	
	
}