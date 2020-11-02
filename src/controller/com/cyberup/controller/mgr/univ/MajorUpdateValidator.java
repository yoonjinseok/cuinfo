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
public class MajorUpdateValidator extends AbstractValidator {
	@Autowired
	private UnivDeptService univDeptService;

	public boolean supports(Class<?> clazz) {
		return UnivDept.class.isAssignableFrom(clazz);
	}

	public UnivDept validate(Object target, ModelMap modelMap) {
		UnivDept univDept = (UnivDept)target;
		
		
		if(univDept.getUniversityId() == 0){
			setErrors(true);
			modelMap.addAttribute("message", "alert('대학교를 선택하세요.');$(\"#universityId\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(univDept.getClassifyId()) ){
			setErrors(true);
			modelMap.addAttribute("message", "alert('대표학과분야를 선택하세요.');$(\"#classifyId\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(univDept.getDeptId()) ){
			setErrors(true);
			modelMap.addAttribute("message", "alert('대표학과를 선택하세요.');$(\"#deptId\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(univDept.getUnivDeptId())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('학과코드를 입력하세요.');$(\"#univDeptId\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(univDept.getUnivDeptName())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('학과명을 입력하세요.');$(\"#dpUrl\").val('');$(\"#univDeptName\").focus();");
			return null;
		}
		if(univDept.getUnivDeptName().getBytes().length > 100) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('대학학과의 길이 초과.');$(\"#univDeptName\").focus();");
			return null;
		}
		if(univDept.getUnivDeptDesc().getBytes().length > 1000) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('설명의 길이 초과.');$(\"#univDeptDesc\").focus();");
			return null;
		}
				
		return univDept;
	}
}

