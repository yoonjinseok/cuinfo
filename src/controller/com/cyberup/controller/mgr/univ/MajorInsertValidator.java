package com.cyberup.controller.mgr.univ;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.univ.UnivDept;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.univ.UnivDeptService;
import com.cyberup.util.EmailValidator;


@Component
public class MajorInsertValidator extends MajorUpdateValidator  {
	@Autowired
	private UnivDeptService univDeptService;
	
	public boolean supports(Class<?> clazz) {
		return UnivDept.class.isAssignableFrom(clazz);
	}
	
	public UnivDept validate(Object target, ModelMap modelMap) {
		UnivDept univDept = (UnivDept)target;
		
		super.validate(target, modelMap);
		
		if(super.hasErrors())
			return null;
		
		UnivDept univDept1 = univDeptService.selectInfo(univDept.getUnivDeptId(), univDept.getUniversityId());
		
		if(univDept1 != null)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('" + univDept.getUniversityName() + "에 등록된 ["+ univDept.getUnivDeptId() +"]"+ univDept.getUnivDeptName() +"가 존재합니다.');");
			return null;
		}
		
		return univDept;
	}
}
