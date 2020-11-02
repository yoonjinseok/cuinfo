package com.cyberup.controller.mgr.system;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.service.system.UnivCodeService;
import com.cyberup.util.EmailValidator;

@Component
public class UnivCodeUpdateValidator extends AbstractValidator {
	@Autowired
	private UnivCodeService univCodeService;

	public boolean supports(Class<?> clazz) {
		return UnivCode.class.isAssignableFrom(clazz);
	}

	public UnivCode validate(Object target, ModelMap modelMap) {
		UnivCode univCode = (UnivCode)target;
		
		if(univCode.getGubunId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('대학구분을 선택하세요.');");
			return null;
		}
		
		if(!StringUtils.hasLength(univCode.getUnivName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('대학명을 입력하세요.');$(\"#univName\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(univCode.getAcademyId()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('대학알리미코드를 입력하세요.');$(\"#academyId\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(univCode.getUseYn()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('사용여부를 선택하세요.');$(\"#useYn\").focus();");
			return null;
		}
		
		if(univCode.getLocalId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('소재지를 선택하세요.');$(\"#useYn\").focus();");
			return null;
		}
		
		return univCode;
	}
}
