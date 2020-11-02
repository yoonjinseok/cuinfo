package com.cyberup.controller.mgr.system;

import javax.validation.Validation;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.service.admin.AdminService;
import com.cyberup.util.EmailValidator;
import com.cyberup.util.PasswordValidator;
import com.cyberup.util.PhoneValidator;

@Component
public class AdminInsertValidator  extends AdminUpdateValidator {
	@Autowired
	private AdminService adminService;
	
	public boolean supports(Class<?> clazz) {
		return Admin.class.isAssignableFrom(clazz);
	}
	
	public Admin validate(Object target, ModelMap modelMap) {
		Admin admin = (Admin)target;
		
		super.validate(target, modelMap);
		
		if(super.hasErrors())
			return null;
		
		if(!StringUtils.hasLength(admin.getAdminPwd()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('패스워드를  입력하세요.');$(\"#adminPwd\").focus();");
			return null;
		}
		return admin;
	}
}
