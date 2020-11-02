package com.cyberup.controller.mgr.course;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.model.course.DataProvider;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.util.EmailValidator;

@Component
public class DpServerUpdateValidator extends AbstractValidator {
	@Autowired
	protected DataProviderService dataProviderService;

	public boolean supports(Class<?> clazz) {
		return DataProvider.class.isAssignableFrom(clazz);
	}

	public DataProvider validate(Object target, ModelMap modelMap) {
		DataProvider dataProvider = (DataProvider)target;
		
		if(dataProvider.getUniversityId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('대학교를 선택하세요.');");
			return null;
		}
		
		if(!StringUtils.hasLength(dataProvider.getDpName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('생산 기관명을 입력하세요.');$(\"#dpName\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(dataProvider.getDpUrl()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('기관URL을 입력하세요.');$(\"#dpUrl\").focus();");
			return null;
		}
		if(!new UrlValidator().isValid(dataProvider.getDpUrl()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('기관URL이 유효하지 않습니다.');$(\"#dpUrl\").val('');$(\"#dpUrl\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(dataProvider.getUseYn()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('운영여부를 선택하세요.');$(\"#useYn\").focus();");
			return null;
		}
		
		if(StringUtils.hasLength(dataProvider.getAdminEmail()))
		{
			if(!EmailValidator.isValid(dataProvider.getAdminEmail()))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('관리자 email이 유효하지 않습니다.');$(\"#adminEmail\").val('');$(\"#adminEmail\").focus();");
				return null;
			}
		}
		
		return dataProvider;
	}
}
