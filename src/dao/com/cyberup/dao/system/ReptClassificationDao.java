package com.cyberup.dao.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.ReptClassification;

@Repository
public class ReptClassificationDao extends BaseDAO  {

	public List<ReptClassification> selectList(Integer showCnt, Integer currPage, String classifyId, String classifyName, 
											String searchCon1, String searchCon2, String searchCon3, String useYn)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("classifyId", classifyId);
		param.put("classifyName", classifyName);
		param.put("useYn", useYn);
		
		param.put("searchCon1", searchCon1);
		param.put("searchCon2", searchCon2);
		param.put("searchCon3", searchCon3);
		
		return queryForList("ReptClassificationDao.selectList", param);
	}
	
	public List<ReptClassification> selectViewList(String useYn)
	{
		Map param = new HashMap();

		param.put("useYn", useYn);
	
		return queryForList("ReptClassificationDao.selectViewList", param);
	}
		
	
	public ReptClassification selectInfo(String classifyId)
	{
		return (ReptClassification)queryForObject("ReptClassificationDao.selectInfo", Integer.parseInt(classifyId));
	}

	public int deleteInfo(String classifyId)
	{
		return delete("ReptClassificationDao.deleteInfo", Integer.parseInt(classifyId));
	}

	public void insertInfo(ReptClassification reptClassification)
	{
		insert("ReptClassificationDao.insertInfo", reptClassification);
	}
	
	public int updateInfo(ReptClassification reptClassification)
	{
		return update("ReptClassificationDao.updateInfo", reptClassification);
	}
}
