package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;

@Repository
public class CourseKemDao extends BaseDAO {
	public int insertInfo(Integer courseId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collTypeId", collTypeId);
		param.put("metadicId", metadicId);
		param.put("kemVal", kemVal);
		
		return (Integer)insert("CourseKemDao.insertInfo", param);
	}
	
	public int updateInfo(Integer courseId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collTypeId", collTypeId);
		param.put("metadicId", metadicId);
		param.put("kemVal", kemVal);
		
		return update("CourseKemDao.updateInfo", param);
	}

	public int deleteInfo(Integer courseId, Integer collTypeId, Integer metadicId)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collTypeId", collTypeId);
		param.put("metadicId", metadicId);

		return delete("CourseKemDao.deleteInfo", param);
	}
	public int deleteList(Integer courseId, String collType, Integer collTypeId)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collType", collType);
		param.put("collTypeId", collTypeId);

		return delete("CourseKemDao.deleteList", param);
	}
	public int deleteNotIn(Integer courseId, String collType, String[] collTypeIds)
	{
		Map param = new HashMap();
		param.put("courseId", courseId);
		param.put("collType", collType);
		param.put("collTypeIds", collTypeIds);
		
		return delete("CourseKemDao.deleteNotIn", param);
	}
}
