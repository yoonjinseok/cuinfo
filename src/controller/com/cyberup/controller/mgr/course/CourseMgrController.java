package com.cyberup.controller.mgr.course;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.LectureService;

@Controller
@RequestMapping("/mgr/course")
public class CourseMgrController {
	@Autowired
	private MetaCollectionController metaCollectionController;
	
	@Autowired
	protected CourseService courseService;
	@Autowired
	protected LectureService lectureService;
	
	@Inject
	protected Provider<LoginInfo> loginInfoProvider;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		/* register appropriate date editor */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/courseMgr")
	public String main(ModelMap model) {
		LoginUser login = loginInfoProvider.get().currentUser();
		
		metaCollectionController.metaCollection(model);
		
		model.put("login", login);
		
		return null;
	}
	
}
