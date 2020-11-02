package com.cyberup.controller.home.entr;

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

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.model.univ.AcademyinfoLink;
import com.cyberup.model.univ.Univ;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.univ.AcademyinfoLinkService;
import com.cyberup.service.univ.UnivService;
import com.ibm.icu.text.SimpleDateFormat;

@Controller
@RequestMapping("/home/entr")
public class EntrUnivStatsMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private UnivService univService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private AcademyinfoLinkService academyinfoLinkService; 
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@RequestMapping("/univStats")
	public String univStats(ModelMap model, ServletRequest request) {

		SimpleDateFormat sdt = new SimpleDateFormat("yyyy", Locale.KOREA);
		Date dTime = new Date();
		String sTime = sdt.format(dTime);
		model.addAttribute("selectYear1", Integer.parseInt(sTime));
		model.addAttribute("selectYear2", Integer.parseInt(sTime)-1);
		model.addAttribute("selectYear3", Integer.parseInt(sTime)-2);
		model.addAttribute("selectYear4", Integer.parseInt(sTime)-3);
		return null;
	}
	
	@RequestMapping(value = "/univStats_list", method = RequestMethod.POST)
	public String list(Univ univParam, ModelMap modelMap) {
		Logger.getLogger(this.getClass()).debug("list() start");
		List<AcademyinfoLink> list = academyinfoLinkService.selectViewList();
		modelMap.addAttribute("academyinfoLinkList", list );
		
		List<Univ> univList = univService.selectUnivList(0);
		modelMap.addAttribute("univList", univList );
		return null;
	}
	
	@RequestMapping("/univStats2")
	public String univStats2(ModelMap model, ServletRequest request) {

		SimpleDateFormat sdt = new SimpleDateFormat("yyyy", Locale.KOREA);
		Date dTime = new Date();
		String sTime = sdt.format(dTime);
		model.addAttribute("selectYear1", Integer.parseInt(sTime));
		model.addAttribute("selectYear2", Integer.parseInt(sTime)-1);
		model.addAttribute("selectYear3", Integer.parseInt(sTime)-2);
		model.addAttribute("selectYear4", Integer.parseInt(sTime)-3);
		return null;
	}
	
	@RequestMapping(value = "/univStats2_list", method = RequestMethod.POST)
	public String list2(Univ univParam, ModelMap modelMap) {
		Logger.getLogger(this.getClass()).debug("list() start");
		List<AcademyinfoLink> list = academyinfoLinkService.selectViewList();
		modelMap.addAttribute("academyinfoLinkList", list );
		
		List<Univ> univList = univService.selectUnivList2(0);
		modelMap.addAttribute("univList", univList );
		return null;
	}
}
