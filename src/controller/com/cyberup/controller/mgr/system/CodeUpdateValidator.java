package com.cyberup.controller.mgr.system;

import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.Code;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.UnivCodeService;
import com.cyberup.util.EmailValidator;

@Component
public class CodeUpdateValidator extends AbstractValidator {
	@Autowired
	private CodeService codeService;

	public boolean supports(Class<?> clazz) {
		return Code.class.isAssignableFrom(clazz);
	}

	public Code validate(Object target, ModelMap modelMap) {
		Code code = (Code)target;
		
		if(!StringUtils.hasLength(code.getCodeName()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('코드명을 입력하세요.');$(\"#codeName\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(code.getUseYn()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('사용여부를 선택하세요.');$(\"#useYn\").focus();");
			return null;
		}
				
		if(code.getCodeName().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('코드명의 길이 초과.');$(\"#codeName\").focus();");
			return null;
		}
		if(code.getCodeValue().getBytes().length > 30) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('코드값의 길이 초과.');$(\"#codeValue\").focus();");
			return null;
		}
		if(code.getCodeDesc().getBytes().length > 100) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('코드설명의 길이 초과.');$(\"#codeDesc\").focus();");
			return null;
		}
		if(code.getCodeOrder() > 100000)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('코드순서의 길이 초과.');$(\"#codeOrder\").focus();");
			return null;
		}
		
		return code;
	}
}
