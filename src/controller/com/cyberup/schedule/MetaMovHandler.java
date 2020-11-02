package com.cyberup.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PreDestroy;
import javax.persistence.CollectionTable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.course.CollectionType;
import com.cyberup.model.course.Course;
//import com.cyberup.model.course.CourseKem;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Lecture;
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

public class MetaMovHandler {
	@Autowired
	private CourseService courseService;
//	@Autowired
//	private ContributorService contributorService;
	@Autowired
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
//	@Autowired
//	private MovieTechService movieTechService;
	
	public static void main(String[] args) {
		try {
			//Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-datasource.xml", "spring/SiteConfig.xml");
			String[] beans = context.getBeanDefinitionNames();
			for(int i = 0; i < beans.length; i++)
			{
				System.out.println(beans[i]);
			}
			
			MetaMovHandler metaMovHandler = context.getBean(MetaMovHandler.class);
			
			metaMovHandler.manual();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void manual()
	{
		MetaMovRealHandler metaMovRealHandler = MetaMovRealHandler.getMetaMovRealHandler();
		
		List<Course> courses = courseService.selectListOfUniv(17);
		
		boolean isNext = false;
		for(int i = 0; i < courses.size(); i++)
		{
			if(courses.get(i).getCourseIdentifier().equals("17|2011|02|2011_2_1912009"))
			{
				isNext = true;
				continue;
			}
			else
			{
				if(!isNext)
					continue;
			}
			
			Course course = courseService.getCourseInfo(courses.get(i).getCourseId());
			
//			course.setKem(CollectionType.COURSE.getValue(), courseKemService.selectList(course.getCourseId(), course.getCourseId()));
//			course.setKem(CollectionType.COURSE.getValue() + "L", courseKemLongService.selectList(course.getCourseId(), course.getCourseId()));
//			course.setKem(CollectionType.PREVTECH.getValue(), courseKemService.selectList(course.getCourseId(), course.getPrevTech().getTechId()));
//			course.setKem(CollectionType.PREVTECH.getValue() + "L", courseKemLongService.selectList(course.getCourseId(), course.getPrevTech().getTechId()));
//			course.setKem(CollectionType.PLANFILE.getValue(), courseKemService.selectList(course.getCourseId(), course.getPlanFile().getAttfileId()));
//			course.setKem(CollectionType.PLANFILE.getValue() + "L", courseKemLongService.selectList(course.getCourseId(), course.getPlanFile().getAttfileId()));
//			if(course.getCourseFileList().size() > 0)
//			{
//				course.setKem(CollectionType.COURSEFILE.getValue(), courseKemService.selectList(course.getCourseId(), course.getCourseFileList().get(0).getAttfileId()));
//				course.setKem(CollectionType.COURSEFILE.getValue() + "L", courseKemLongService.selectList(course.getCourseId(), course.getCourseFileList().get(0).getAttfileId()));
//			}
//			if(course.getCourseContributorList().size() > 0)
//			{
//				course.setKem(CollectionType.CONTRIBUTOR.getValue(), courseKemService.selectList(course.getCourseId(), course.getCourseContributorList().get(0).getContributorId()));
//				course.setKem(CollectionType.CONTRIBUTOR.getValue() + "L", courseKemLongService.selectList(course.getCourseId(), course.getCourseContributorList().get(0).getContributorId()));
//			}
//
//			course.setLectureList(lectureService.getLectureList(course.getCourseId()));
//			for(int j = 0; j < course.getLectureList().size(); j++)
//			{
//				Lecture lecture = course.getLectureList().get(j);
//				lecture.setKem(CollectionType.LECTURE.getValue(), lectureKemService.selectList(lecture.getLectureId(), lecture.getLectureId()));
//				lecture.setKem(CollectionType.LECTURE.getValue() + "L", lectureKemLongService.selectList(lecture.getLectureId(), lecture.getLectureId()));
//
//				lecture.setKem(CollectionType.LECTECH.getValue(), lectureKemService.selectList(lecture.getLecTech().getTechId(), lecture.getLectureId()));
//				lecture.setKem(CollectionType.LECTECH.getValue() + "L", lectureKemLongService.selectList(lecture.getLecTech().getTechId(), lecture.getLectureId()));
//
//				if(lecture.getLecContributorList().size() > 0)
//				{
//					lecture.setKem(CollectionType.CONTRIBUTOR.getValue(), lectureKemService.selectList(lecture.getLecContributorList().get(0).getContributorId(), lecture.getLectureId()));
//					lecture.setKem(CollectionType.CONTRIBUTOR.getValue() + "L", lectureKemLongService.selectList(lecture.getLecContributorList().get(0).getContributorId(), lecture.getLectureId()));
//				}
//
//				if(lecture.getLecFileList().size() > 0)
//				{
//					lecture.setKem(CollectionType.LECFILE.getValue(), lectureKemService.selectList(lecture.getLecFileList().get(0).getAttfileId(), lecture.getLectureId()));
//					lecture.setKem(CollectionType.LECFILE.getValue() + "L", lectureKemLongService.selectList(lecture.getLecFileList().get(0).getAttfileId(), lecture.getLectureId()));
//				}
//			}
//
//			metaMovRealHandler.getCourseService().manualconstruct(course);
		}
	}
}
