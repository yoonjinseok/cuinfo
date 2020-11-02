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
public class ManualScheduleMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator scheduleUpdateValidator;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private OrganizationService organizationService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@Autowired
	private ScheduleMgrController scheduleMgrController;
	
	@Resource(name="scheduleUpdateValidator")
	public void setScheduleUpdateValidator(MapValidator scheduleUpdateValidator) {
		this.scheduleUpdateValidator = scheduleUpdateValidator;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		/* register appropriate date editor */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	} 
	
	
	@RequestMapping("/manualschedule")
	public String schedule(ModelMap model) {
		return null;
	}
	
	@RequestMapping(value = "/manualschedule_list", method = RequestMethod.POST)
	public String list(Schedule scheduleParam, ModelMap modelMap) {
		
		List<Schedule> list = scheduleService.selectList("Y", scheduleParam.getShowCnt(), scheduleParam.getCurrPage(), scheduleParam.getUniversityName(), scheduleParam.getStatus());
		modelMap.addAttribute("scheduleList", list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, scheduleParam.getCurrPage(), scheduleParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, scheduleParam.getCurrPage(), scheduleParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/manualschedule_modify")
	public String modify(Schedule scheduleParam, ModelMap modelMap)
	{
		scheduleMgrController.modify(scheduleParam, modelMap);
		
		return null;
	}
	
	@RequestMapping(value = "/manualschedule_update", method = RequestMethod.POST)
	public String update(Schedule scheduleParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		if(scheduleParam.getRunningStatus().equals("N"))
			scheduleParam.setStatus("N");
		else
			scheduleParam.setStatus("Y");
		
		scheduleUpdateValidator.validate(scheduleParam, modelMap);
		
		if(scheduleUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		scheduleParam.setScheduleModifier(login.getUserId());
		
		scheduleService.updateInfo(scheduleParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/manualschedule_delete", method = RequestMethod.POST)
	public String delete(Schedule scheduleParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		scheduleMgrController.delete(scheduleParam, modelMap, sessionStatus);
		
		return null;
	}
	
	@RequestMapping(value = "/manualschedule_write")
	public String write(ModelMap modelMap) {
		scheduleMgrController.write(modelMap);
		
		return null;
	}
	
	@RequestMapping(value = "/manualschedule_save", method = RequestMethod.POST)
	public String save(Schedule scheduleParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		scheduleUpdateValidator.validate(scheduleParam, modelMap);
		
		if(scheduleUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		Organization organization = organizationService.selectInfo("");
		
		scheduleParam.setManualYn("Y");
		scheduleParam.setOrgId(organization.getOrgId());
		scheduleParam.setScheduleRegister(login.getUserId());
		
		scheduleService.insertInfo(scheduleParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/manualschedule_history")
	public String history(History historyParam, ModelMap modelMap) {
		
		scheduleMgrController.history(historyParam, modelMap);
		
		return null;
	}
}
