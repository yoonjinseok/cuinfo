package com.cyberup.controller.mgr.system;

import org.apache.commons.validator.UrlValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.ReptDept;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.system.ReptDeptService;
import com.cyberup.util.EmailValidator;

@Component
public class MajorCodeUpdateValidator extends AbstractValidator {
	
	@Autowired
	private ReptDeptService reptDeptService;

	public boolean supports(Class<?> clazz) {
		return ReptDept.class.isAssignableFrom(clazz);
	}

	public ReptDept validate(Object target, ModelMap modelMap) {
		ReptDept ReptDept = (ReptDept)target;
		
		if(!StringUtils.hasLength(ReptDept.getDeptName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('학과명을 입력하세요.');$(\"#deptName\").focus();");
			return null;
		}
		
		if(ReptDept.getDeptName().getBytes().length > 50) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('대표학과명의 길이 초과.');$(\"#deptName\").focus();");
			return null;
		}
		if(ReptDept.getClassifyDesc().getBytes().length > 200) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('설명의 길이 초과.');$(\"#classifyDesc\").focus();");
			return null;
		}
		
		Logger.getLogger(this.getClass()).debug("getBytes 1: " +ReptDept.getDeptName());
		Logger.getLogger(this.getClass()).debug("getBytes 2: " +ReptDept.getDeptName().getBytes().length );
		Logger.getLogger(this.getClass()).debug("getBytes 2: " +ReptDept.getDeptName().length() );
		
		return ReptDept;
	}

}
