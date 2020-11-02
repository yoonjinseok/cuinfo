package com.cyberup.controller.mgr.home;

import org.apache.commons.lang.NumberUtils;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.model.admin.Admin;
import com.cyberup.service.admin.AdminService;
import com.cyberup.model.home.BoardUniv;
import com.cyberup.service.home.BoardUnivService;
import com.cyberup.util.EmailValidator;
import com.cyberup.util.HtmlUtils;

@Component
public class BoardUnivUpdateValidator extends AbstractValidator {

	public boolean supports(Class<?> clazz) {
		return BoardUniv.class.isAssignableFrom(clazz);
	}

	public BoardUniv validate(Object target, ModelMap modelMap) {
			
		BoardUniv board = (BoardUniv)target;	
		
		
		board.setStartDT(board.getStartDT().replace("-", ""));
		board.setEndDT(board.getEndDT().replace("-", ""));
		
		if(!StringUtils.hasLength(board.getTitle()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('제목을 입력바랍니다.');$(\"#title\").focus();");
			return null;
		}
		
		if(StringUtils.hasLength(board.getEmail()))
		{
			if(!EmailValidator.isValid(board.getEmail()))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('Email이 유효하지 않습니다.');$(\"#email\").val('');$(\"#adminEmail\").focus();");
				return null;
			}
		}else{
			setErrors(true);
			modelMap.addAttribute("message", "alert('Email을 입력 바랍니다.');$(\"#email\").val('');$(\"#adminEmail\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(board.getBoardContent()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('내용을 입력 하세요.');$(\"#boardContent\").focus();");
			return null;
		}
		
		if(!HtmlUtils.isValidHtmlTag(board.getBoardContent())){		
			setErrors(true);
			modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#title\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(board.getStartDT()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('행사 시작일을 입력 하세요..');$(\"#startDT\").focus();");
			return null;
		}
		if((board.getStartDT().length() !=8 )||(!NumberUtils.isNumber(board.getStartDT())))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('행사 시작일은 형식이 잘못되었습니다.');$(\"#useYn\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(board.getEndDT()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('행사 종료일 입력하세요.');$(\"#endDT\").focus();");
			return null;
		}
		if(( board.getEndDT().length() !=8 )||(!NumberUtils.isNumber(board.getEndDT())))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('행사 종료일 형식이 잘못되었습니다.');$(\"#endDT\").focus();");
			return null;
		}
		if( Integer.parseInt(board.getStartDT())> Integer.parseInt(board.getEndDT()) )
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('행사 종료일은 시작일보다 더 커야합니다.');$(\"#endDT\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(board.getUnivID()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('주관 대학을 선택하세요.');$(\"#univName\").focus();");
			return null;
		}
		return board;
	}
}
