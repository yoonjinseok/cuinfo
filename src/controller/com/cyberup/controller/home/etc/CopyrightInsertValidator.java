package com.cyberup.controller.home.etc;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.util.EmailValidator;

import com.cyberup.model.admin.Admin;
import com.cyberup.model.footer.Copyright;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.footer.CopyrightService;

@Component
public class CopyrightInsertValidator extends AbstractValidator {
	@Autowired
	private CopyrightService copyrightService;
	
	public boolean supports(Class<?> clazz) {
		return Copyright.class.isAssignableFrom(clazz);
	}
	
	public Copyright validate(Object target, ModelMap modelMap) {
		Copyright copyright = (Copyright)target;
		
		if(!StringUtils.hasLength(copyright.getkId())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('리스아이디를 입력하세요.');$(\"#kId\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(copyright.getEmail())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('이메일을 입력하세요.');$(\"#email\").focus();");
			return null;
		}
		if(StringUtils.hasLength(copyright.getEmail()))
		{
			if(!EmailValidator.isValid(copyright.getEmail()))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('Email이 유효하지 않습니다.');$(\"#email\").focus();");
				return null;
			}
		}
		if(!StringUtils.hasLength(copyright.getTelno1())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('전화번호를 입력하세요.');$(\"#telno1\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(copyright.getTelno2())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('전화번호를 입력하세요.');$(\"#telno2\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(copyright.getqSubject())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('제목 입력하세요.');$(\"#qSubject\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(copyright.getqContents())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('요청사유 및 의견을 입력하세요.');$(\"#qContents\").focus();");
			return null;
		}

		if(copyright.getkId().getBytes().length > 100) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('리스아이디의 길이 초과.');$(\"#kId\").focus();");
			return null;
		}
		if(copyright.getEmail().getBytes().length > 50) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('Email의 길이 초과.');$(\"#email\").focus();");
			return null;
		}
		if(copyright.getqSubject().getBytes().length > 255) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('제목의 길이 초과.');$(\"#qSubject\").focus();");
			return null;
		}
		if(copyright.getqContents().getBytes().length > 4000) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('요청사유 및 의견의 길이 초과.');$(\"#qContents\").focus();");
			return null;
		}
			
		return copyright;
	}
}
