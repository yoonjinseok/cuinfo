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
import com.cyberup.model.univ.AcademyinfoLink;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.univ.AcademyinfoLinkService;
import com.cyberup.util.EmailValidator;

@Component
public class UnivStatsUpdateValidator extends AbstractValidator {
	
	@Autowired
	private AcademyinfoLinkService academyinfoLinkService;

	public boolean supports(Class<?> clazz) {
		return AcademyinfoLink.class.isAssignableFrom(clazz);
	}

	public AcademyinfoLink validate(Object target, ModelMap modelMap) {
		AcademyinfoLink academyinfoLink = (AcademyinfoLink)target;
		
		if(!StringUtils.hasLength(academyinfoLink.getInfoName())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('현황정보를 입력하세요.');$(\"#dpUrl\").val('');$(\"#infoName\").focus();");
			return null;
		}
		if(academyinfoLink.getInfoGubunId() == 0){
			setErrors(true);
			modelMap.addAttribute("message", "alert('현황정보 구분코드를 선택하세요.');$(\"#infoGubunId\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(academyinfoLink.getInfoUrlpattern())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('URL패턴을 입력하세요.');$(\"#dpUrl\").val('');$(\"#infoUrlpattern\").focus();");
			return null;
		}
		
		if(academyinfoLink.getInfoName().getBytes().length >= 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('현황정보의 길이 초과.');$(\"#infoName\").focus();");
			return null;
		}
		if(academyinfoLink.getInfoUrlpattern().getBytes().length > 1000) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('URL패턴의 길이 초과.');$(\"#infoUrlpattern\").focus();");
			return null;
		}
		
		return academyinfoLink;
	}
}
