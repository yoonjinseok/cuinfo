package com.cyberup.controller.mgr.educ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.model.educ.Statisitics;
import com.cyberup.model.home.Board;
import com.cyberup.service.educ.StatisiticsService;
import com.cyberup.service.home.BoardService;

@Component
public class StatisiticsUpdateValidator extends AbstractValidator {

	@Autowired
	private StatisiticsService statisiticsService;

	
	public boolean supports(Class<?> clazz) {
		return Statisitics.class.isAssignableFrom(clazz);
	}

	
	public Statisitics validate(Object target, ModelMap modelMap) {
		Statisitics statisitics = (Statisitics)target;	
	
		
		if("Y".equals(statisitics.getTermState()) && !StringUtils.hasLength(statisitics.getSttYear()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('수집년도를 선택하세요.');$(\"#sttYear\").focus();");
			return null;
		}
		
		if("Y".equals(statisitics.getTermState()) && !StringUtils.hasLength(statisitics.getSttMonth()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('수집분기를 선택하세요.');$(\"#sttMonth\").focus();");
			return null;
		}
		
		if(statisitics.getDeadline() == null)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('마감일을 입력바랍니다.');$(\"#deadline\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(statisitics.getSttName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('통계명을 입력바랍니다.');$(\"#sttName\").focus();");
			return null;
		}
		
		if(statisitics.getUpfileSrc() != null && statisitics.getUpfileSrc().length <= 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('통계파일을 등록바랍니다.');$(\"#upload\").focus();");
			return null;
		} else if(statisitics.getUpfileSrc() != null && "Y".equals(statisitics.getTermState()) && statisitics.getUpfileSrc().length != 1 ) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('정기파일은 하나만 등록가능합니다.');$(\"#upload\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(statisitics.getDeclare()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('설명을 입력 바랍니다.');$(\"#declare\").val('');$(\"#adminEmail\").focus();");
			return null;
		}		
		
		Integer count = statisiticsService.isUpCheck(statisitics);
		if(count > 0 && "Y".equals(statisitics.getTermState()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('선택한 정기 년,월은 이미 등록되여있습니다.');$(\"#sttYear\").val('');$(\"#sttYear\").focus();");
			return null;
		}
		return statisitics;
	}
}
