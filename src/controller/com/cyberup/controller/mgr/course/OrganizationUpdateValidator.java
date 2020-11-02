package com.cyberup.controller.mgr.course;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Organization;
import com.cyberup.model.course.Schedule;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.service.course.OrganizationService;
import com.cyberup.service.course.ScheduleService;
import com.cyberup.util.EmailValidator;
import com.cyberup.util.HtmlUtils;
import com.cyberup.util.PhoneValidator;

@Component
public class OrganizationUpdateValidator extends AbstractValidator {
	@Autowired
	private OrganizationService organizationService;

	public boolean supports(Class<?> clazz) {
		return Organization.class.isAssignableFrom(clazz);
	}

	public Organization validate(Object target, ModelMap modelMap) {
		Organization organization = (Organization)target;
		
		if(!StringUtils.hasLength(organization.getOrgId()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('기관코드를 입력하세요.');$(\"#orgId\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(organization.getOrgName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('기관명을 입력하세요.');$(\"#orgName\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(organization.getCatalogName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('카탈로그값을 입력하세요.');$(\"#catalogName\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(organization.getAdminName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('관리자명을 입력하세요.');$(\"#adminName\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(organization.getAdminEmail()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('관리자 이메일을 입력하세요.');$(\"#adminEmail\").focus();");
			return null;
		}
		
		if(!EmailValidator.isValid(organization.getAdminEmail()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('이메일 주소가 유효하지 않습니다.');$(\"#adminEmail\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(organization.getAdminTelno()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('관리자 전화번호를 입력하세요.');$(\"#adminTelno\").focus();");
			return null;
		}
		
		if(!PhoneValidator.isValid(organization.getAdminTelno()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('전화번호가 유효하지 않습니다.');$(\"#adminTelno\").focus();");
			return null;
		}
		
		if(!HtmlUtils.isValidHtmlTag(organization.getEtc())){  
			setErrors(true);
			modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#etc\").focus();");
			return null;
		}
		
		return organization;
	}
}
