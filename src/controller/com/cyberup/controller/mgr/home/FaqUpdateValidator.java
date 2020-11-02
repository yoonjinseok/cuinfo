package com.cyberup.controller.mgr.home;

/*
import org.apache.commons.validator.UrlValidator;
import org.springframework.util.PatternMatchUtils;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import com.cyberup.service.home.FaqService;
	@Autowired
	private FaqService faqService;
*/

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;

import com.cyberup.model.home.Faq;

@Component
public class FaqUpdateValidator extends AbstractValidator {


	public boolean supports(Class<?> clazz) {
		return Faq.class.isAssignableFrom(clazz);
	}

	@SuppressWarnings("unchecked")
	public Faq validate(Object target, ModelMap modelMap) {
		Faq faq = (Faq)target;
		
		if(!StringUtils.hasLength(faq.getQuestion())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('제목을 입력하세요.');$(\"#question\").focus();");
			return null;			
		}
		
		if(faq.getSectionId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('분류를 선택하세요.');");
			return null;
		}
		
		if(!StringUtils.hasLength(faq.getAnswer()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('내용을 입력하세요.');$(\"#answer\").focus();");
			return null;
		}
		
		
		return faq;
	}
}
