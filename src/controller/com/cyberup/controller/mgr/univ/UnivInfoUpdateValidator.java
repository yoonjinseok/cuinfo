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
import com.cyberup.model.univ.Univ;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.univ.UnivService;
import com.cyberup.util.EmailValidator;
import com.cyberup.util.HtmlUtils;

@Component
public class UnivInfoUpdateValidator extends AbstractValidator{
	@Autowired
	private UnivService univService;

	public boolean supports(Class<?> clazz) {
		return Univ.class.isAssignableFrom(clazz);
	}
	
	public Univ validate(Object target, ModelMap modelMap) {
		Univ univ = (Univ)target;
		
		if(univ.getPreviewGubn() == 1)
		{
			//11.11.27 종호추가.
			
			if(univ.getGubun_id().equals(""))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('대학구분을 선택해주세요.');$(\"#gubun_id\").focus();");
				return null;
			}
			if(univ.getUniv_zipcode().equals(""))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('우편번호를 입력해주세요.');$(\"#univ_zipcode\").focus();");
				return null;
			}
			else
			{
				if(univ.getUniv_zipcode().length() > 7)
				{
					setErrors(true);
					modelMap.addAttribute("message", "alert('우편번호는 6자리만 입력가능합니다.');$(\"#univ_zipcode\").focus();");
					return null;	
				}
			}
			
			if(univ.getUniv_address().equals(""))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('대표주소를 입력해주세요.');$(\"#univ_address\").focus();");
				return null;
			}
			
			if(univ.getLocal_id().equals(""))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('소재지를 선택해주세요.');$(\"#local_id\").focus();");
				return null;
			}
			
			/*이메일,대표홈페이지,대표전화,FAX,입학상담 연락처 도 유효성 검사를 할것인가 확인필요.
			 * 
			if(univ.getUniv_address().equals(""))
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('대표주소를 입력해주세요..');$(\"#univ_address\").focus();");
				return null;
			}
			 * */
			
			
			if(!univ.getUniv_email().equals(""))
			{
				String email = univ.getUniv_email();
				if(email.indexOf("@") < 0 || email.indexOf(".") < 0)
				{
					setErrors(true);
					modelMap.addAttribute("message", "alert('이메일 형식이 올바르지 않습니다.');$(\"#content\").focus();");
					return null;
				}
			}
		}
		else if(univ.getPreviewGubn() == 2)
		{
			if(!HtmlUtils.isValidHtmlTag(univ.getGreeting_content())){  
				   setErrors(true);
				   modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#greeting_content\").focus();");
				   return null;
			}	
			if(!HtmlUtils.isValidHtmlTag(univ.getVision_content())){  
				setErrors(true);
				modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#vision_content\").focus();");
				return null;
			}	
			if(!HtmlUtils.isValidHtmlTag(univ.getLocation_content())){  
				setErrors(true);
				modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#location_content\").focus();");
				return null;
			}	
			if(!HtmlUtils.isValidHtmlTag(univ.getPublic_content())){  
				setErrors(true);
				modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#public_content\").focus();");
				return null;
			}	
		
		} else if(univ.getPreviewGubn() == 4){
			if(univ.getLink_name().equals("")){			
				setErrors(true);
				modelMap.addAttribute("message", "alert('내용을 입력하세요.');$(\"#link_name\").focus();");
				return null;
			}
			
		} 
		else
		{
			if(univ.getImgTypeId() == 22){
				
				if(univ.getContent().equals("")){			
					setErrors(true);
					modelMap.addAttribute("message", "alert('내용을 입력하세요.');$(\"#content\").focus();");
					return null;
				}
			} else if(univ.getImgTypeId() == 23){
				
				if(univ.getSrcName_0().equals("")){
					setErrors(true);
					modelMap.addAttribute("message", "alert('이미지를 선택하세요.');");
					return null;
				}
				
			} else if(univ.getImgTypeId() == 24){
				
				if(univ.getSrcName_0().equals("")){
					setErrors(true);
					modelMap.addAttribute("message", "alert('이미지1를 선택하세요.');");
					return null;
				}
				if(univ.getSrcName_1().equals("")){
					setErrors(true);
					modelMap.addAttribute("message", "alert('이미지2를 선택하세요.');");
					return null;
				}
				if(univ.getSrcName_2().equals("")){
					setErrors(true);
					modelMap.addAttribute("message", "alert('이미지3를 선택하세요.');");
					return null;
				}
				if(univ.getSrcName_3().equals("")){
					setErrors(true);
					modelMap.addAttribute("message", "alert('이미지4를 선택하세요.');");
					return null;
				}
				
			} else {
				
					setErrors(true);
					modelMap.addAttribute("message", "alert('형태를 선택하세요.');$(\"#deptId\").focus();");
					return null;
			}
			
			if(!HtmlUtils.isValidHtmlTag(univ.getContent())){  
			   setErrors(true);
			   modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#content\").focus();");
			   return null;
			}
	
			if(!HtmlUtils.isValidHtmlTag(univ.getImgMapTag0())){  
				   setErrors(true);
				   modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#imgMapTag0\").focus();");
				   return null;
				}
			if(!HtmlUtils.isValidHtmlTag(univ.getImgMapTag1())){  
				   setErrors(true);
				   modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#imgMapTag1\").focus();");
				   return null;
				}
			if(!HtmlUtils.isValidHtmlTag(univ.getImgMapTag2())){  
				   setErrors(true);
				   modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#imgMapTag2\").focus();");
				   return null;
				}
			if(!HtmlUtils.isValidHtmlTag(univ.getImgMapTag3())){  
				   setErrors(true);
				   modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#imgMapTag3\").focus();");
				   return null;
				}		
		}
		return univ;
	}
}
