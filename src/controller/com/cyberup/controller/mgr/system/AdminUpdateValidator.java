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
public class AdminUpdateValidator extends AbstractValidator {
	@Autowired
	private AdminService adminService;

	public boolean supports(Class<?> clazz) {
		return Admin.class.isAssignableFrom(clazz);
	}

	public Admin validate(Object target, ModelMap modelMap) {
		Admin admin = (Admin)target;
		
		System.out.println("Admin ==> " + admin);
		
		if(admin.getAuthLevelId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('권한그룹을 입력하세요.');$(\"#authLevelId\").focus();");
			return null;
		}
		if(admin.getAuthLevelId() != 3)
		{
			admin.setUniversityId(0);
		}
		/*
		else if(admin.getUniversityId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('소속학교를 입력하세요.');$(\"#universityId\").focus();");
			return null;
		}
		 * */
		
		if(!StringUtils.hasLength(admin.getAdminName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('이름을 입력하세요.');$(\"#adminName\").focus();");
			return null;
		}

		if(!StringUtils.hasLength(admin.getAdminId()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('아이디을 입력하세요.');$(\"#adminName\").focus();");
			return null;
		}
		
		if(StringUtils.hasLength(admin.getAdminPwd()))
		{
			if(!StringUtils.hasLength(admin.getAdminPwd2()))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('패스워드를 한번 더 입력하세요.');$(\"#adminPwd2\").focus();");
				return null;
			}
			
			if(!admin.getAdminPwd().equals(admin.getAdminPwd2()))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('패스워드가 서로 틀립니다.');$(\"#adminPwd2\").val('');$(\"#adminPwd2\").focus();");
				return null;
			}
			Logger.getLogger(this.getClass()).debug("adminValidator ::" + admin.getAdminPwd());
			if(!PasswordValidator.isValid(admin.getAdminPwd()))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('패스워드는 숫자와 알파벳을 반드시 포함하고 4~15글자여야 합니다.');$(\"#adminPwd\").val('');$(\"#adminPwd2\").val('');$(\"#adminPwd\").focus();");
				return null;
			}
		}
		
		if(!StringUtils.hasLength(admin.getAdminCompany()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('소속을 입력하세요.');$(\"#adminCompany\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(admin.getAdminPhone()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('연락처를 입력하세요.');$(\"#adminPhone\").focus();");
			return null;
		}
		
		if(!PhoneValidator.isValid(admin.getAdminPhone()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('연락처를 \\'-\\'를 포함해서 입력하세요.');$(\"#adminPhone\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(admin.getAdminEmail()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('이메일을 입력하세요.');$(\"#adminEmail\").focus();");
			return null;
		}
		
		if(!EmailValidator.isValid(admin.getAdminEmail()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('이메일이 유효하지 않습니다.');$(\"#adminEmail\").focus();");
			return null;
		}
		
		if(admin.getAdminId().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('아이디의 길이 초과.');$(\"#adminId\").focus();");
			return null;
		}
		if(admin.getAdminName().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('이름의 길이 초과.');$(\"#adminName\").focus();");
			return null;
		}
		if(admin.getAdminPwd().getBytes().length > 60) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('비밀번호의 길이 초과.');$(\"#adminPwd\").focus();");
			return null;
		}
		if(admin.getAdminCompany().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('소속의 길이 초과.');$(\"#adminCompany\").focus();");
			return null;
		}
		if(admin.getAdminDepart().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('부서의 길이 초과.');$(\"#adminDepart\").focus();");
			return null;
		}
		if(admin.getAdminPosition().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('직위의 길이 초과.');$(\"#adminPosition\").focus();");
			return null;
		}		
		if(admin.getAdminDuty().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('직책의 길이 초과.');$(\"#adminDuty\").focus();");
			return null;
		}
		
		if(admin.getAdminPhone().getBytes().length > 20) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('연락처의 길이 초과.');$(\"#adminPhone\").focus();");
			return null;
		}
		if(admin.getAdminEmail().getBytes().length > 200) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('이메일의 길이 초과.');$(\"#adminEmail\").focus();");
			return null;
		}
		if(admin.getAdminDesc().getBytes().length > 2000) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('설명과의 길이 초과.');$(\"#adminDesce\").focus();");
			return null;
		}

		return admin;
	}
}
