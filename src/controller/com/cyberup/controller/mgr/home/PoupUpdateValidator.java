package com.cyberup.controller.mgr.home;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.home.Poup;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.home.PoupService;
import com.cyberup.util.EmailValidator;
import com.cyberup.util.HtmlUtils;

@Component
public class PoupUpdateValidator extends AbstractValidator {
	@Autowired
	private PoupService poupService;

	public boolean supports(Class<?> clazz) {
		return Poup.class.isAssignableFrom(clazz);
	}

	public Poup validate(Object target, ModelMap modelMap) {
		Poup poup = (Poup)target;
		
		if(!StringUtils.hasLength(poup.getTitle())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('제목을 입력하세요.');$(\"#title\").focus();");
			return null;			
		}

		if(!HtmlUtils.isValidHtmlTag(poup.getContent())){  
		   setErrors(true);
		   modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#content\").focus();");
		   return null;
		}
		
		if(!StringUtils.hasLength(poup.getShowStartDt())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('게시기간을 입력하세요.');$(\"#showStartDt\").focus();");
			return null;			
		}
		if(!StringUtils.hasLength(poup.getShowEndDt())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('게시기간을 입력하세요.');$(\"#showEndDt\").focus();");
			return null;			
		}

		if(poup.getSkinId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('스킨을 선택하세요.');$(\"#skinId\").focus();");
			return null;
		}
		if(poup.getPoupHeight() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('사이즈 HEIGHT를 선택하세요.');$(\"#poupHeight\").focus();");
			return null;
		}
		if(poup.getPoupWidth() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('사이즈 WIDTH를 선택하세요.');$(\"#poupWidth\").focus();");
			return null;
		}
		if(poup.getPoupTop() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('위치TOP를 선택하세요.');$(\"#poupTop\").focus();");
			return null;
		}
		if(poup.getPoupLeft() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('위치 LEFT를 선택하세요.');$(\"#poupLeft\").focus();");
			return null;
		}
		
		

		return poup;
	}
}
