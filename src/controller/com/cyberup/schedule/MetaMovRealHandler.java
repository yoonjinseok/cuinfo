package com.cyberup.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.course.Course;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Schedule;
import com.cyberup.model.course.ScheduleType;
//import com.cyberup.service.course.ContributorService;
import com.cyberup.service.course.CourseKemLongService;
import com.cyberup.service.course.CourseKemService;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.HistoryService;
import com.cyberup.service.course.LectureKemLongService;
import com.cyberup.service.course.LectureKemService;
import com.cyberup.service.course.LectureService;
import com.cyberup.service.course.MaterialService;
//import com.cyberup.service.course.MovieTechService;
import com.cyberup.service.course.ScheduleService;
import com.cyberup.util.DateFormatter;

public class MetaMovRealHandler {
	@Autowired
	private CourseService courseService;
//	@Autowired
//	private ContributorService contributorService;
//	@Autowired
	private CourseKemLongService courseKemLongService;
	@Autowired
	private CourseKemService courseKemService;
	@Autowired
	private LectureKemLongService lectureKemLongService;
	@Autowired
	private LectureKemService lectureKemService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private MaterialService materialService;
	@Autowired
//	private MovieTechService movieTechService;
	
	public CourseService getCourseService() {
		return courseService;
	}

//	public ContributorService getContributorService() {
//		return contributorService;
//	}

	public CourseKemLongService getCourseKemLongService() {
		return courseKemLongService;
	}

	public CourseKemService getCourseKemService() {
		return courseKemService;
	}

	public LectureKemLongService getLectureKemLongService() {
		return lectureKemLongService;
	}

	public LectureKemService getLectureKemService() {
		return lectureKemService;
	}

	public LectureService getLectureService() {
		return lectureService;
	}

	public MaterialService getMaterialService() {
		return materialService;
	}

//	public MovieTechService getMovieTechService() {
//		return movieTechService;
//	}

	public static MetaMovRealHandler getMetaMovRealHandler()
	{
		ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-realdatasource.xml", "spring/SiteConfig.xml");
		String[] beans = context.getBeanDefinitionNames();
		for(int i = 0; i < beans.length; i++)
		{
			System.out.println(beans[i]);
		}
		
		MetaMovRealHandler metaMovRealHandler = context.getBean(MetaMovRealHandler.class);
		
		return metaMovRealHandler;
	}
	
}
