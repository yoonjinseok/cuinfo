package com.cyberup.controller.mgr.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.Lecture;
import com.cyberup.model.course.Organization;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.LectureService;
import com.cyberup.util.EmailValidator;
import com.cyberup.util.HtmlUtils;
import com.cyberup.util.PhoneValidator;

@Component
public class MetaCollectionLectureUpdateValidator extends AbstractValidator {
	@Autowired
	private LectureService lectureService;

	public boolean supports(Class<?> clazz) {
		return Lecture.class.isAssignableFrom(clazz);
	}

	public Lecture validate(Object target, ModelMap modelMap) {
		Lecture lecture = (Lecture)target;
		
		if(!StringUtils.hasLength(lecture.getLectureIdentifier()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('강의식별자를 입력하세요.');$(\"#lectureIdentifier\").focus();");
			return null;
		}
		if(!StringUtils.hasLength(lecture.getTitle()))
		{
			setErrors(true);
			modelMap.addAttribute("message", "alert('제목을 입력하세요.');$(\"#title\").focus();");
			return null;
		}
		
		if(!HtmlUtils.isValidHtmlTag(lecture.getDescription())){  
			setErrors(true);
			modelMap.addAttribute("message", "alert('제한된 html 태그를 사용하였습니다.');$(\"#description\").focus();");
			return null;
		}
		
		return lecture;
	}
}
