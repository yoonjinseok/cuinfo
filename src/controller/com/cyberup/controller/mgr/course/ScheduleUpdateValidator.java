package com.cyberup.controller.mgr.course;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Schedule;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.service.course.ScheduleService;
import com.cyberup.util.EmailValidator;

@Component
public class ScheduleUpdateValidator extends AbstractValidator {
	@Autowired
	private ScheduleService scheduleService;

	public boolean supports(Class<?> clazz) {
		return Schedule.class.isAssignableFrom(clazz);
	}

	public Schedule validate(Object target, ModelMap modelMap) {
		Schedule schedule = (Schedule)target;
		
		if(schedule.getUniversityId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('대학교를 선택하세요.');");
			return null;
		}
		
		if(schedule.getStartDate() == null)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('스케줄 시작일이 형식에 맞지 않거나 입력하지 않았습니다');$(\"#startDate\").val('');$(\"#startDate\").focus();");
			return null;
		}
		
		if(schedule.getIntervals() <= 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('실행주기를 일자단위로 입력하세요.');$(\"#intervals\").focus();");
			return null;
		}
		if(schedule.getRunHour() <= 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('실행시간을 입력하세요.');$(\"#runHour\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(schedule.getScheduleType()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('작업유형을 선택하세요.');$(\"#scheduleType\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(schedule.getStatus()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('등록상태를 선택하세요.');$(\"#status\").focus();");
			return null;
		}
		
		return schedule;
	}
}
