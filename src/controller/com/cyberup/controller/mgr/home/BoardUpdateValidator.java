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
import com.cyberup.service.admin.AdminService;
import com.cyberup.model.home.Board;
import com.cyberup.service.home.BoardService;
import com.cyberup.util.EmailValidator;
import com.cyberup.util.HtmlUtils;

@Component
public class BoardUpdateValidator extends AbstractValidator {
	@Autowired
	private BoardService boardService;

	public boolean supports(Class<?> clazz) {
		return Board.class.isAssignableFrom(clazz);
	}

	
	public Board validate(Object target, ModelMap modelMap) {
		Board board = (Board)target;	
	
		
		if(!StringUtils.hasLength(board.getGubunID()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('데이터 전달값이 잘못되었습니다.');$(\"#gubunId\").focus();");
			return null;
		}
		
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
		
		return board;
	}
}
