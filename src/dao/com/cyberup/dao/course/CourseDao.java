package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.course.Course;

@Repository
public class CourseDao extends BaseDAO {
	
	public List<Integer> selectIdsOfIdentifier(Integer universityId, String courseIdentifier, String islock)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		param.put("courseIdentifier", courseIdentifier);
		param.put("islock", islock);
		
		return queryForList("CourseDao.selectIdsOfIdentifier", param);
	}
	public String selectCourseStatus(Integer courseId)
	{
		return (String)queryForObject("CourseDao.selectCourseStatus", courseId);
	}
	public int deleteInfo(Integer courseId)
	{
		return delete("CourseDao.deleteInfo", courseId);
	}

	public int updateDeleteInfo(Integer courseId, String deletor)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("deletor", deletor);
		
		return update("CourseDao.updateDeleteInfo", param);
	}

	public Integer selectKey()
	{
		return (Integer)queryForObject("CourseDao.selectKey");
	}
	public void insertInfo(Course course)
	{
		insert("CourseDao.insertInfo", course);
	}
	
	public int updateInfo(Course course)
	{
		return update("CourseDao.updateInfo", course);
	}
	
	public int updateStatus(Integer courseId, String svcStatus, String modifier)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("svcStatus", svcStatus);
		param.put("modifier", modifier);
		
		return update("CourseDao.updateStatus", param);
	}
	
	public int updateModDate(Integer courseId, String modifier)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("modifier", modifier);
		
		return update("CourseDao.updateModDate", param);
	}

	public Course selectInfo(int courseId)
	{
		return (Course)queryForObject("CourseDao.selectInfo", courseId);
	}
	
	public List<Course> selectList(Integer sorting, Integer ascending, Integer showCnt, Integer currPage, String modStartDate, String modEndDate, String svcStatus, String universityName, String department, 
			String isPrev, String publicYn, String termYearStart, String termYearEnd, String type, String searchField, String searchValue)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("modStartDate", modStartDate);
		param.put("modEndDate", modEndDate);
		param.put("svcStatus", svcStatus);
		param.put("universityName", universityName);
		param.put("department", department);
		param.put("isPrev", isPrev);
		param.put("publicYn", publicYn);
		param.put("termYearStart", termYearStart);
		param.put("termYearEnd", termYearEnd);
		param.put("type", type);
		param.put("searchField", searchField);
		param.put("searchValue", searchValue);
		param.put("sorting", sorting);
		param.put("ascending", ascending);
		
		return queryForList("CourseDao.selectList", param);
	}
	
	public List<Course> selectList(Course course)
	{
		return queryForList("CourseDao.selectList2", course);
	}
	
	public List<Course> selectListOfUniv(int universityId)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		
		return queryForList("CourseDao.selectListOfUniv", param);
	}
	
	public void updateIsLock(Integer courseId,String flag, String modifier)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("flag", flag);
		param.put("modifier", modifier);
		
		update("CourseDao.updateIsLock",param);
	}
	public void updateIsTemp(Integer courseId,String flag, String modifier)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("flag", flag);
		param.put("modifier", modifier);
		
		update("CourseDao.updateIsTemp",param);
	}
	public String selectCourseIsLock(String universityId, String courseIdentifier)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		param.put("courseIdentifier", courseIdentifier);
		
		return (String)queryForObject("CourseDao.selectCourseIsLock",param);
	}
	public List<Integer> selectDistList(String startDate, String endDate)
	{
		Map param = new HashMap();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		
		return queryForList("CourseDao.selectDistList", param);
	}
	public List<Integer> selectDistDelList(String startDate, String endDate)
	{
		Map param = new HashMap();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		
		return queryForList("CourseDao.selectDistDelList", param);
	}
	
	public List<HashMap> checkRecommend(Integer courseId, Integer type){
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("type", type);
		return queryForList("CourseDao.checkRecommend", param);
		
	}
	
	public Integer insertRecommend(Integer courseId, Integer type){
		try {
			Map param = new HashMap();
			param.put("courseId", courseId);
			param.put("type", type);
			insert("CourseDao.insertRecommend", param);
			return 1; 
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public Integer deleteRecommend(Integer courseId, Integer type){
		try {
			Map param = new HashMap();
			param.put("courseId", courseId);
			param.put("type", type);
			return delete("CourseDao.deleteRecommend", param);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}
