package com.cyberup.controller.mgr.educ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.model.educ.UnivStt;
import com.cyberup.model.home.Board;
import com.cyberup.service.home.BoardService;

@Component
public class UnivSttUpdateValidator extends AbstractValidator {

	public boolean supports(Class<?> clazz) {
		return UnivStt.class.isAssignableFrom(clazz);
	}

	
	public UnivStt validate(Object target, ModelMap modelMap) {
		UnivStt univStt = (UnivStt)target;	
		
		
		if((univStt.getUpfileGid() == null || univStt.getUpfileGid() == 0) && (univStt.getUpfileSrc() == null || univStt.getUpfileSrc().length <= 0))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('통계파일을 등록바랍니다.');$(\"#upload\").focus();");
			return null;
		}else if( univStt.getUpfileGid() != 0 && (univStt.getUpfileSrc() == null || univStt.getUpfileSrc().length <= 0))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('새로운 통계파일을 등록해주세요.');$(\"#upload\").focus();");
			return null;
		} else if(univStt.getUpfileSrc() != null && "Y".equals(univStt.getTermState()) && univStt.getUpfileSrc().length != 1 ) {
			setErrors(true);
			modelMap.addAttribute("message", "alert('정기파일은 하나만 등록가능합니다.');$(\"#upload\").focus();");
			return null;
		}
		
		return univStt;
	}
}
