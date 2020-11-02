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
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;

import com.cyberup.model.univ.Univ;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.univ.EnterGuideService;
import com.ibm.icu.text.SimpleDateFormat;

@Controller
@RequestMapping("/home/entr")
public class EnterGuideMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private EnterGuideService enterGuideService;
	@Autowired
	private CodeService codeService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@RequestMapping("/enterGuide")
	public String enterGuide(ModelMap model, ServletRequest request) {
		
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy", Locale.KOREA);
		Date dTime = new Date();
		String sTime = sdt.format(dTime);
		model.addAttribute("selectYear1", Integer.parseInt(sTime));
		model.addAttribute("selectYear2", Integer.parseInt(sTime)-1);
		model.addAttribute("selectYear3", Integer.parseInt(sTime)-2);
		model.addAttribute("selectYear4", Integer.parseInt(sTime)-3);
		model.addAttribute("selectYear5", Integer.parseInt(sTime)-4);
		model.addAttribute("selectYear6", Integer.parseInt(sTime)-5);
		model.addAttribute("selectYear7", Integer.parseInt(sTime)-6);
		
		return null;
	}
	
	@RequestMapping("/enterGuide2")
	public String enterGuide2(ModelMap model, ServletRequest request) {
		
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy", Locale.KOREA);
		Date dTime = new Date();
		String sTime = sdt.format(dTime);
		model.addAttribute("selectYear1", Integer.parseInt(sTime));
		model.addAttribute("selectYear2", Integer.parseInt(sTime)-1);
		model.addAttribute("selectYear3", Integer.parseInt(sTime)-2);
		model.addAttribute("selectYear4", Integer.parseInt(sTime)-3);
		model.addAttribute("selectYear5", Integer.parseInt(sTime)-4);
		model.addAttribute("selectYear6", Integer.parseInt(sTime)-5);
		model.addAttribute("selectYear7", Integer.parseInt(sTime)-6);
		
		return null;
	}
	
	@RequestMapping("/enterStep_New")
	public String enterStep_New(ModelMap model, ServletRequest request) {
		return null;
	}
	@RequestMapping("/enterStep_Time")
	public String enterStep_Time(ModelMap model, ServletRequest request) {
		return null;
	}
	
	@RequestMapping(value = "/enterGuide_list", method = RequestMethod.POST)
	public String list(Univ egParm, ModelMap modelMap) {
		Logger.getLogger(this.getClass()).debug("모집요강 리스트 호출");
		
		List<Univ> list = enterGuideService.selectEnterGuideList(egParm);
				
/*		
 		if(list.size() > 0)
			PagingModel.mappPages(modelMap, egParm.getCurrPage(), egParm.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, egParm.getCurrPage(), egParm.getShowCnt(), new PagingModel());
*/
		
		modelMap.addAttribute("enterGuideList",list);
		return null;
	}
	
	@RequestMapping(value = "/enterGuide2_list", method = RequestMethod.POST)
	public String list2(Univ egParm, ModelMap modelMap) {
		Logger.getLogger(this.getClass()).debug("대학원 모집요강 리스트 호출");
		
		List<Univ> list = enterGuideService.selectEnterGuideList2(egParm);
	
		modelMap.addAttribute("enterGuideList2",list);
		return null;
	}
	
}
