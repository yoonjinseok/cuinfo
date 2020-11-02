package com.cyberup.controller.mgr.course;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Organization;
import com.cyberup.model.course.Schedule;
import com.cyberup.model.course.ScheduleType;
import com.cyberup.service.course.HistoryService;
import com.cyberup.service.course.OrganizationService;
import com.cyberup.service.course.ScheduleService;

@Controller
@RequestMapping("/mgr/course")
public class OrganizerMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator organizationUpdateValidator;
	@Autowired
	private OrganizationService organizationService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@Resource(name="organizationUpdateValidator")
	public void setOrganizationUpdateValidator(MapValidator organizationUpdateValidator) {
		this.organizationUpdateValidator = organizationUpdateValidator;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		/* register appropriate date editor */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	} 
	
	
	@RequestMapping("/ctrOrgan")
	public String ctrOrgan(ModelMap model) {
		
		model.addAttribute(organizationService.selectInfo(""));
		
		return null;
	}
	
	@RequestMapping(value = "/ctrOrgan_update", method = RequestMethod.POST)
	public String update(Organization organizationParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		organizationUpdateValidator.validate(organizationParam, modelMap);
		
		if(organizationUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		organizationParam.setOrgModifier(login.getUserId());
		organizationParam.setOrgRegister(login.getUserId());
		
		if(organizationService.selectInfo("") != null)
			organizationService.updateInfo(organizationParam);
		else
			organizationService.insertInfo(organizationParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
}
