package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.course.Lecture;

@Repository
public class LectureDao extends BaseDAO {
	public int updateInfo(Lecture lecture)
	{
		return update("LectureDao.updateInfo", lecture);
	}
	public int updateLocation(Integer lectureId, String movLocation)
	{
		Map param = new HashMap();
		param.put("lectureId", lectureId);
		param.put("movLocation", movLocation);
		
		return update("LectureDao.updateLocation", param);
	}

	public Integer selectKey()
	{
		return (Integer)queryForObject("LectureDao.selectKey");
	}
	public void insertInfo(Lecture lecture)
	{
		insert("LectureDao.insertInfo", lecture);
	}

	public int deleteInfo(Integer lectureId, Integer courseId, String lectureIdentifier)
	{
		Map param = new HashMap();
		param.put("lectureId", lectureId);
		param.put("courseId", courseId);
		param.put("lectureIdentifier", lectureIdentifier);
		
		return delete("LectureDao.deleteInfo", param);
	}
	
	public int deleteListByCourseId(Integer courseId)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		
		return delete("LectureDao.deleteListByCourseId", param);
	}
	
	public List<Lecture> selectListOfUniv(int universityId)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		
		return queryForList("LectureDao.selectListOfUniv", param);
	}

	public Lecture selectInfo(Integer lectureId, Integer courseId, String lectureIdentifier)
	{
		Map param = new HashMap();
		param.put("lectureId", lectureId);
		param.put("courseId", courseId);
		param.put("lectureIdentifier", lectureIdentifier);
		
		return (Lecture)queryForObject("LectureDao.selectInfo", param);
	}
	
	public List<Lecture> selectList(Integer courseId)
	{
		return queryForList("LectureDao.selectList", courseId);
	}
}
