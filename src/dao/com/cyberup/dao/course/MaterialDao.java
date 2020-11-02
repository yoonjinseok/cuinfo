package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.course.Material;

@Repository
public class MaterialDao extends BaseDAO {
	public List<Material> selectListOfUniv(int universityId)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		
		return queryForList("MaterialDao.selectListOfUniv", param);
	}
	public Material selectInfo(Integer attfileId, String relationType, Integer relationId, String attfileIdentifier)
	{
		Map param = new HashMap();
		param.put("attfileId", attfileId);
		param.put("relationType", relationType);
		param.put("relationId", relationId);
		param.put("attfileIdentifier", attfileIdentifier);
		
		return (Material)queryForObject("MaterialDao.selectInfo", param);
	}
	public List<Material> selectList(String relationType, Integer relationId)
	{
		Map param = new HashMap();
		param.put("relationType", relationType);
		param.put("relationId", relationId);
		
		return queryForList("MaterialDao.selectList", param);
	}
	
	public int deleteNotIn(String relationType, Integer relationId, String[] attfileIds)
	{
		Map param = new HashMap();
		param.put("attfileIds", attfileIds);
		param.put("relationType", relationType);
		param.put("relationId", relationId);
		
		return delete("MaterialDao.deleteNotIn", param);
	}

	public int deleteInfo(Integer attfileId, String relationType, Integer relationId, String attfileIdentifier)
	{
		Map param = new HashMap();
		param.put("attfileId", attfileId);
		param.put("relationType", relationType);
		param.put("relationId", relationId);
		param.put("attfileIdentifier", attfileIdentifier);
		
		return delete("MaterialDao.deleteInfo", param);
	}
	
	public int deleteListByCourseId(String relationType, Integer courseId)
	{
		Map param = new HashMap();
		param.put("relationType", relationType);
		param.put("courseId", courseId);
		
		return delete("MaterialDao.deleteListByCourseId", param);
	}
	
	public Integer insertInfo(Material material)
	{
		Integer key = (Integer)insert("MaterialDao.insertInfo", material);
		material.setAttfileId(key);
		
		return key;
	}

	public int updateInfo(Material material)
	{
		return update("MaterialDao.updateInfo", material);
	}
}
