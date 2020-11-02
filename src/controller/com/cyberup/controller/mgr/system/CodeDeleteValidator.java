package com.cyberup.controller.mgr.system;

import java.util.List;

import org.apache.commons.validator.UrlValidator;
import org.apache.log4j.Logger;
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
public class CodeDeleteValidator extends AbstractValidator {
	@Autowired
	private CodeService codeService;
	
	public boolean supports(Class<?> clazz) {
		return Code.class.isAssignableFrom(clazz);
	}
	
	public Code validate(Object target, ModelMap modelMap) {
		Code code = (Code)target;
		
		Code code1 = codeService.selectInfo(code.getCodeId());
		
		Logger.getLogger(this.getClass()).debug("Validator ::" + code1.getCodeId());
		Logger.getLogger(this.getClass()).debug("Validator ::" + code1.getCodeGroup());
		
		if(code1.getCodeGroup()==null){
			Logger.getLogger(this.getClass()).debug("Validator 0::");
			List<Code> list = codeService.selectList(code1.getCodeId(), "");
			//List<Code> list = codeService.selectList(1, "");
			Logger.getLogger(this.getClass()).debug("Validator 1::" +list.size());
			//Logger.getLogger(this.getClass()).debug("Validator 2::" + list.get(0).getCodeId());
			
			if(list.size() !=0)
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('해당 그룹에 속한 코드가 존재하여 삭제하실 수 없습니다.');");
				return null;
			}
		}	
			
		
		return code;
	}
}
