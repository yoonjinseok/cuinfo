package com.cyberup.controller.mgr.user;

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

@Component
public class AdminLoginValidator extends AbstractValidator {
	@Autowired
	private AdminService adminService;

	public boolean supports(Class<?> clazz) {
		return Admin.class.isAssignableFrom(clazz);
	}

	public Admin validate(Object target, ModelMap modelMap) {
		Admin login = (Admin)target;
		
		if(!StringUtils.hasLength(login.getUserId()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('아이디를 입력하세요.');$(\"#adminId\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(login.getAdminPwd()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('패스워드를 입력하세요.');$(\"#adminPwd\").focus();");
			return null;
		}
		
		Admin admin = adminService.selectInfo(login.getUserId());
		
		if(admin == null)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('로그인 정보가 유효하지 않습니다.');");
			return null;
		}
		if(StringUtils.hasLength(admin.getAcceptIp()))
		{
			if(!admin.getAcceptIp().contains(login.getRemoteAddr()))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('시스템 로그인이 불가능한 PC입니다.');");
				return null;
			}
		}
		
		Logger.getLogger(this.getClass()).debug("adminPwd : " + EncryptorMd5.encode(EncryptorMd5.encrypt(login.getAdminPwd())));
		if (!admin.getAdminPwd().equals(EncryptorMd5.encode(EncryptorMd5.encrypt(login.getAdminPwd())))) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('로그인 정보가 유효하지 않습니다.');");
			return null;
		}
		if(!"Y".equals(admin.getUseYn()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('허가받지 않은 계정입니다.');");
			return null;
		}
		
		return admin;
	}
	
	public static void main(String[] args) {
		System.out.println(EncryptorMd5.encode(EncryptorMd5.encrypt("1234")));
	}
}
