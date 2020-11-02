package com.cyberup.service.course;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.CourseDao;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.Lecture;
import com.cyberup.model.course.ScheduleType;


@Service
@Transactional
public class CourseService {
	private Logger logger = Logger.getLogger(CourseService.class);
	
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private CourseKemService courseKemService;

	public int deleteInfo(Integer courseId) {
		return this.courseDao.deleteInfo(courseId);
	}
	public void insertInfo(Course course) {
		this.courseDao.insertInfo(course);
	}
	public int updateInfo(Course course) {
		return this.courseDao.updateInfo(course);
	}
	public int updateStatus(Integer courseId, String svcStatus, String modifier)
	{
		return this.courseDao.updateStatus(courseId, svcStatus, modifier);
	}
	public int updateModDate(Integer courseId, String modifier)
	{
		return this.courseDao.updateModDate(courseId, modifier);
	}
	public Course selectInfo(int courseId) {
		return this.courseDao.selectInfo(courseId);
	}
	public List<Course> selectList(Integer sorting, Integer ascending, Integer showCnt, Integer currPage, String modStartDate, String modEndDate, String svcStatus, String universityName, String department, 
			String isPrev, String publicYn, String termYearStart, String termYearEnd, String type, String searchField, String searchValue)
	{
		return this.courseDao.selectList(sorting, ascending, showCnt, currPage, modStartDate, modEndDate, svcStatus, universityName, department, isPrev, publicYn, termYearStart, termYearEnd, type, searchField, searchValue);
	}  
	public List<Course> selectList(Course course)
			{
		return this.courseDao.selectList(course);
			}  
	
	public List<Course> selectListOfUniv(Integer universityId) {
		return this.courseDao.selectListOfUniv(universityId);
	}
	
	public Integer selectKey()
	{
		return this.courseDao.selectKey();
	}
	
	public Course getCourseInfo(Integer courseId)
	{
		Course course = this.courseDao.selectInfo(courseId);
		
		course.setLectureList(this.lectureService.getLectureList(courseId));
		
		return course;
	}
	
	public void reconstruct(Course preCourse, Course course, String courseStatus)
	{
		demolish(preCourse.getCourseId());
		
		construct(preCourse.getCourseId(), course);
		
		this.courseDao.updateStatus(preCourse.getCourseId(), courseStatus, course.getModifier());
	}
	
	public Integer construct(Course course)
	{
		Integer courseId = this.courseDao.selectKey();
		construct(courseId, course);
		
		return courseId;
	}
	public void construct(Integer courseId, Course course)
	{
		constructCourse(courseId, course);
		
		for(int i = 0; i < course.getLectureList().size(); i++)
		{
			course.getLectureList().get(i).setCourseId(courseId);
			course.getLectureList().get(i).setRegister(course.getRegister());
			course.getLectureList().get(i).setModifier(course.getRegister());
			lectureService.construct(course.getLectureList().get(i));
			logger.info("lecture("+i+") constructed");
		}
	}
	public void constructCourse(Integer courseId, Course course)
	{
		course.setCourseId(courseId);
		this.courseDao.insertInfo(course);
		logger.info("course inserted");
		courseKemService.construct(courseId, courseId, course);
		logger.info("course kem constructed");
	}
	
	public void synchronize(Date harvestSdate, Date harvestEdate, Course preCourse, Course course)
	{
		if(course.getScheduleType(harvestSdate, harvestEdate).equals(ScheduleType.UPDATE.getValue())
				|| course.getScheduleType(harvestSdate, harvestEdate).equals(ScheduleType.CREATE.getValue()))
		{
			reconstruct(preCourse, course, course.getSvcStatus());
		}
		else
		{
			this.courseDao.updateModDate(preCourse.getCourseId(), course.getModifier());
			
			for(int i = 0; i < course.getLectureList().size(); i++)
			{
				course.getLectureList().get(i).setCourseId(preCourse.getCourseId());
				course.getLectureList().get(i).setRegister(course.getRegister());
				course.getLectureList().get(i).setModifier(course.getRegister());
				lectureService.synchronize(harvestSdate, harvestEdate, course.getLectureList().get(i));
			}
		}
	}
	public void synchronizeCourse(Course course)
	{
		this.courseDao.deleteInfo(course.getCourseId());
		courseKemService.demolish(course.getCourseId(), "", 0);
		
		constructCourse(course.getCourseId(), course);
	}
	public void updateDeleteInfo(Integer courseId, String deletor)
	{
		this.courseDao.updateDeleteInfo(courseId, deletor);
	}
	
	public void demolish(Integer courseId)
	{
		this.courseDao.deleteInfo(courseId);
		courseKemService.demolish(courseId, "", 0);
		
		lectureService.demolish(courseId);
	}
	
	public String selectCourseStatus(Integer courseId)
	{
		return this.courseDao.selectCourseStatus(courseId);
	}
	
	public List<Integer> selectIdsOfIdentifier(Integer universityId, String courseIdentifier, String islock)
	{
		return this.courseDao.selectIdsOfIdentifier(universityId, courseIdentifier, islock);
	}
	public void updateIsLock(Integer courseId, String flag, String modifier)
	{
		this.courseDao.updateIsLock(courseId,flag, modifier);
		if(flag.equals("N"))
			this.courseDao.updateIsTemp(courseId, flag, modifier);
		
	}
	public String selectCourseIsLock(String universityId, String courseIdentifier)
	{
		return this.courseDao.selectCourseIsLock(universityId, courseIdentifier);
	}
	
	public List<Integer> selectDistList(String startDate, String endDate)
	{
		return this.courseDao.selectDistList(startDate, endDate);
	}
	public List<Integer> selectDistDelList(String startDate, String endDate)
	{
		return this.courseDao.selectDistDelList(startDate, endDate);
	}
	public List<HashMap> checkRecommend(Integer courseId, Integer type){
		return this.courseDao.checkRecommend(courseId, type);
	}
	
	public Integer insertRecommend(Integer courseId, Integer type){
		return this.courseDao.insertRecommend(courseId, type);
	}
	
	public Integer deleteRecommend(Integer courseId, Integer type){
		return this.courseDao.deleteRecommend(courseId, type);
	}
}
