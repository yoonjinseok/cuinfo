package com.cyberup.controller.mgr.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.model.course.Course;
import com.cyberup.service.course.CourseService;
import com.cyberup.util.HtmlUtils;

@Component
public class MetaCollectionUpdateValidator extends AbstractValidator {
	@Autowired
	private CourseService courseService;

	public boolean supports(Class<?> clazz) {
		return Course.class.isAssignableFrom(clazz);
	}

	public Course validate(Object target, ModelMap modelMap) {
		Course course = (Course)target;
		
		if(!StringUtils.hasLength(course.getCourseIdentifier()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('강좌식별자를 입력하세요.');$(\"#courseIdentifier\").focus();");
			return null;
		}
		if(course.getUniversityId() == 0)
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('학교를 선택하세요.');$(\"#universityId\").focus();");
			return null;
		}
		
		if(course.getCourseId() == 0)
		{
			if(courseService.selectIdsOfIdentifier(course.getUniversityId(), course.getCourseIdentifier(), "").size() > 0)
			{
				setErrors(true);
				modelMap.addAttribute("message", "alert('동일한 식별자의 강좌가 이미 있습니다.');$(\"#courseIdentifier\").focus();");
				return null;
			}
		}
		
		if(!StringUtils.hasLength(course.getTitle()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('제목을 입력하세요.');$(\"#title\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(course.getDepartmentId()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('학과코드를 입력하세요.');$(\"#departmentId\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(course.getDepartment()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('학과명을 입력하세요.');$(\"#department\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(course.getSvcStart()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('서비스시작일을 입력하세요.');$(\"#svcStart\").focus();");
			return null;
		}
		
		if(!StringUtils.hasLength(course.getSvcEnd()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('서비스종료일을 입력하세요.');$(\"#svcEnd\").focus();");
			return null;
		}
		
		if(!HtmlUtils.isValidHtmlTag(course.getDescription())){  
			setErrors(true);
			modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#description\").focus();");
			return null;
		}
		
		if(!HtmlUtils.isValidHtmlTag(course.getAssessment())){  
			setErrors(true);
			modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#assessment\").focus();");
			return null;
		}

		if(!HtmlUtils.isValidHtmlTag(course.getPlanLocation())){
			setErrors(true);
			modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#syllabusPath\").focus();");
			return null;
		}
		
		return course;
	}
}
