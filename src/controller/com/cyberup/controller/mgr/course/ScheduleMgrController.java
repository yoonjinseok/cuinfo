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
public class ScheduleMgrController {
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
	
	
	@RequestMapping("/schedule")
	public String schedule(ModelMap model) {
		return null;
	}
	
	@RequestMapping(value = "/schedule_list", method = RequestMethod.POST)
	public String list(Schedule scheduleParam, ModelMap modelMap) {
		
		List<Schedule> list = scheduleService.selectList("N", scheduleParam.getShowCnt(), scheduleParam.getCurrPage(), scheduleParam.getUniversityName(), scheduleParam.getStatus());
		modelMap.addAttribute("scheduleList", list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, scheduleParam.getCurrPage(), scheduleParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, scheduleParam.getCurrPage(), scheduleParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/schedule_modify")
	public String modify(Schedule scheduleParam, ModelMap modelMap)
	{
		Schedule schedule = scheduleService.selectInfo(scheduleParam.getScheduleId());
		
		modelMap.addAttribute(schedule);
		
		modelMap.addAttribute("types", ScheduleType.values());
		
		return null;
	}
	
	@RequestMapping(value = "/schedule_update", method = RequestMethod.POST)
	public String update(Schedule scheduleParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		scheduleUpdateValidator.validate(scheduleParam, modelMap);
		
		if(scheduleUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		scheduleParam.setScheduleModifier(login.getUserId());
		
		scheduleService.updateInfo(scheduleParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/schedule_delete", method = RequestMethod.POST)
	public String delete(Schedule scheduleParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		scheduleService.deleteInfo(scheduleParam.getScheduleId());
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/schedule_write")
	public String write(ModelMap modelMap) {
		modelMap.addAttribute("types", ScheduleType.values());
		
		return null;
	}
	
	@RequestMapping(value = "/schedule_save", method = RequestMethod.POST)
	public String save(Schedule scheduleParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		scheduleUpdateValidator.validate(scheduleParam, modelMap);
		
		if(scheduleUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		Organization organization = organizationService.selectInfo("");
		
		scheduleParam.setOrgId(organization.getOrgId());
		scheduleParam.setScheduleRegister(login.getUserId());
		
		scheduleService.insertInfo(scheduleParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/schedule_history")
	public String history(History historyParam, ModelMap modelMap) {
		
		List<History> list = historyService.selectList(historyParam.getShowCnt(), historyParam.getCurrPage(), historyParam.getScheduleId());
		modelMap.addAttribute("historyList", list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, historyParam.getCurrPage(), historyParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, historyParam.getCurrPage(), historyParam.getShowCnt(), new PagingModel());
		
		return null;
	}
}
