package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;

@Repository
public class LectureKemDao extends BaseDAO {
	public int deleteInfo(Integer lectureId, Integer collTypeId, Integer metadicId)
	{
		Map param = new HashMap();
		param.put("collTypeId", collTypeId);
		param.put("lectureId", lectureId);
		param.put("metadicId", metadicId);

		return delete("LectureKemDao.deleteInfo", param);
	}
	public int deleteList(Integer lectureId, String collType, Integer collTypeId)
	{
		Map param = new HashMap();
		param.put("lectureId", lectureId);
		param.put("collType", collType);
		param.put("collTypeId", collTypeId);
		
		return delete("LectureKemDao.deleteList", param);
	}
	public int deleteNotIn(Integer lectureId, String collType, String[] collTypeIds)
	{
		Map param = new HashMap();
		param.put("lectureId", lectureId);
		param.put("collType", collType);
		param.put("collTypeIds", collTypeIds);
		
		return delete("LectureKemDao.deleteNotIn", param);
	}
	public int deleteListByCourseId(Integer courseId)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		
		return delete("LectureKemDao.deleteListByCourseId", param);
	}

	public void insertInfo(Integer lectureId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		Map param = new HashMap();
		param.put("collTypeId", collTypeId);
		param.put("lectureId", lectureId);
		param.put("metadicId", metadicId);
		param.put("kemVal", kemVal);
		
		insert("LectureKemDao.insertInfo", param);
	}
	
	public int updateInfo(Integer lectureId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		Map param = new HashMap();
		param.put("collTypeId", collTypeId);
		param.put("lectureId", lectureId);
		param.put("metadicId", metadicId);
		param.put("kemVal", kemVal);
		
		return update("LectureKemDao.updateInfo", param);
	}
}
