package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;

@Repository
public class CourseKemLongDao extends BaseDAO {
	public int deleteInfo(Integer courseId, Integer collTypeId, Integer metadicId)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collTypeId", collTypeId);
		param.put("metadicId", metadicId);

		return delete("CourseKemLongDao.deleteInfo", param);
	}
	public int deleteList(Integer courseId, String collType, Integer collTypeId)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collType", collType);
		param.put("collTypeId", collTypeId);

		return delete("CourseKemLongDao.deleteList", param);
	}
	public int deleteNotIn(Integer courseId, String collType, String[] collTypeIds)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collType", collType);
		param.put("collTypeIds", collTypeIds);
		
		return delete("CourseKemLongDao.deleteNotIn", param);
	}
	public int updateInfo(Integer courseId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collTypeId", collTypeId);
		param.put("metadicId", metadicId);
		param.put("kemVal", kemVal);
		
		return update("CourseKemLongDao.updateInfo", param);
	}

	public void insertInfo(Integer courseId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collTypeId", collTypeId);
		param.put("metadicId", metadicId);
		param.put("kemVal", kemVal);
		
		insert("CourseKemLongDao.insertInfo", param);
	}
}
