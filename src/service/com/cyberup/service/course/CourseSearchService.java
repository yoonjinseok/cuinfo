package com.cyberup.service.course;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.common.DeadLinkCheckDao;
import com.cyberup.dao.course.CourseSearchDao;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.CourseSearch;


@Service
@Transactional
public class CourseSearchService {
	
	@Autowired
	private CourseSearchDao courseSearchDao;
	@Autowired
	private DeadLinkCheckDao deadLinkCheckDao;
	
	public List univDeptList(CourseSearch courseSearch)
	{
		return courseSearchDao.univDeptList(courseSearch);
	}
	
	public List univDeptListForPublic(CourseSearch courseSearch)
	{
		return courseSearchDao.univDeptListForPublic(courseSearch);
	}
	
	public List rollUpList(CourseSearch courseSearch)
	{
		return courseSearchDao.rollUpList(courseSearch);
	}
	
	public List rollUpListForPublic(CourseSearch courseSearch)
	{
		return courseSearchDao.rollUpListForPublic(courseSearch);
	}
	
	public List searchOpenCourse_thumnail(CourseSearch courseSearch)
	{
		return courseSearchDao.searchOpenCourse_thumnail(courseSearch);
	}
	
	public List searchOpenCourse(CourseSearch courseSearch)
	{
		//상세검색 또는 디폴트검색일경우 DB 검색을 한다.
		String isDetail = courseSearch.getIsDetail();
		String text 	= courseSearch.getText();
		
		//20121118 와이즈넛 검색엔진 고도화 한후에 활성화한다.
		//return courseSearchDao.searchOpenCourse(courseSearch);
		
		if("".equals(text) && !"Y".equals(isDetail))//검색어가 없고 상세검색이 아닐경우
			return courseSearchDao.searchOpenCourse(courseSearch);
		else if("Y".equals(isDetail))//상세검색일경우
			//return courseSearchDao.searchOpenCourseDetail(courseSearch);
			return courseSearchDao.searchOpenCourse(courseSearch);
		else
			return courseSearchDao.courseSearch(courseSearch);
		
	}
	
	public List searchOpenCourse2(CourseSearch courseSearch)
	{
		//상세검색 또는 디폴트검색일경우 DB 검색을 한다.
		String isDetail = courseSearch.getIsDetail();
		String text 	= courseSearch.getText();
		
		//20121118 와이즈넛 검색엔진 고도화 한후에 활성화한다.
		//return courseSearchDao.searchOpenCourse(courseSearch);
		
		if("".equals(text) && !"Y".equals(isDetail))//검색어가 없고 상세검색이 아닐경우
			return courseSearchDao.searchOpenCourse2(courseSearch);
		else if("Y".equals(isDetail))//상세검색일경우
			return courseSearchDao.searchOpenCourse2(courseSearch);
		else
			return courseSearchDao.searchOpenCourse2(courseSearch);
			
		
	}
	
	public List searchOpenCourseForCertificate(CourseSearch courseSearch)
	{
		return courseSearchDao.searchOpenCourseForCertificate(courseSearch);
	}
	public CourseSearch selectCourseInfo(CourseSearch courseSearch) {
		return this.courseSearchDao.selectCourseInfo(courseSearch);
	}
	
	public CourseSearch selectCourseInfo3(String courseId) {
		return this.courseSearchDao.selectCourseInfo3(courseId);
	}
	
	
	
	public List selectLectureList(CourseSearch courseSearch) {
		return this.courseSearchDao.selectLectureList(courseSearch);
	}
	
	public List selectLectureList3(String courseId) {
		return this.courseSearchDao.selectLectureList3(courseId);
	}
	
	public List selectUnivList(CourseSearch courseSearch) {
		return this.courseSearchDao.selectUnivList(courseSearch);
	}
	
	public List selectUnivListForPublic(CourseSearch courseSearch) {
		return this.courseSearchDao.selectUnivListForPublic(courseSearch);
	}
	
	
	public List selectYearListForPublic(CourseSearch courseSearch) {
		return this.courseSearchDao.selectYearListForPublic(courseSearch);
	}
	
	
	public List selectUnivList2(CourseSearch courseSearch) {
		return this.courseSearchDao.selectUnivList2(courseSearch);
	}
	
	public List kocwApiSearch(String gubn,String text) throws Exception{
		
		//44번 개발서버는 riss와 연결되지 않음으로 return
		//if(true)
		//	return null;
		
		List list = null;
		
		try {
			
			if(deadLinkCheckDao.isValid("http://www.riss.kr/openApi?key=70aaa00tte60abr00aaa00ro00ja234a&version=1.0&type="+gubn+"&keyword="+URLEncoder.encode(text, "utf-8"), "75000") == 200)
				list = this.courseSearchDao.kocwApiSearch(gubn,text);	
			else 
				list = new ArrayList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List kocwApiSearch_univ(String gubn,String univname) throws Exception{
		return this.courseSearchDao.kocwApiSearch_univ(gubn,univname);
	}
	
	public List getYearList(){
		return this.courseSearchDao.getYearList();
	}
	public List selectPublicCourseList(CourseSearch courseSearch){
		return this.courseSearchDao.selectPublicCourseList(courseSearch);
	}
	
	public String selectCourseId(CourseSearch courseSearch){
		return this.courseSearchDao.selectCourseId(courseSearch);
		
	}
}
