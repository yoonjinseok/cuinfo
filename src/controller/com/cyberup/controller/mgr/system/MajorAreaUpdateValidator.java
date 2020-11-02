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
import com.cyberup.model.system.ReptClassification;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.system.ReptClassificationService;
import com.cyberup.util.EmailValidator;

@Component
public class MajorAreaUpdateValidator extends AbstractValidator {
	
	@Autowired
	private ReptClassificationService reptClassificationService;

	public boolean supports(Class<?> clazz) {
		return ReptClassification.class.isAssignableFrom(clazz);
	}

	public ReptClassification validate(Object target, ModelMap modelMap) {
		ReptClassification reptClassification = (ReptClassification)target;

		if(!StringUtils.hasLength(reptClassification.getClassifyName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('분야명을 입력하세요.');$(\"#classifyName\").focus();");
			return null;
		}

		if(reptClassification.getClassifyName().getBytes().length > 50) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('분야명의 길이 초과.');$(\"#classifyName\").focus();");
			return null;
		}
		if(reptClassification.getClassifyOrder() >= 1000) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('순서의 길이 초과.');$(\"#classifyOrder\").focus();");
			return null;
		}
		
		return reptClassification;
	}

}
