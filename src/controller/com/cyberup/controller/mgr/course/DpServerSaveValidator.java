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
public class DpServerSaveValidator extends DpServerUpdateValidator {

	public DataProvider validate(Object target, ModelMap modelMap) {
		super.validate(target, modelMap);
		
		DataProvider dataProvider = (DataProvider)target;
		
		if(!hasErrors())
		{
			if(dataProviderService.selectInfo(dataProvider.getUniversityId()) != null)
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('해당 대학교는 이미 등록되어있습니다.');");
				return null;
			}
		}
		
		return dataProvider;
	}
}
