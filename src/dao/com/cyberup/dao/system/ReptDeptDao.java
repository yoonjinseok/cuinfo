package com.cyberup.dao.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.ReptDept;

@Repository
public class ReptDeptDao extends BaseDAO  {

	public List<ReptDept> selectList(Integer showCnt, Integer currPage, String deptId, String deptName, String classifyId, 
									String searchCon1, String searchCon2, String searchCon3,String useYn)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("deptId", deptId);
		param.put("deptName", deptName);
		param.put("useYn", useYn);
		param.put("classifyId", classifyId);
		
		param.put("searchCon1", searchCon1);
		param.put("searchCon2", searchCon2);
		param.put("searchCon3", searchCon3);
		
		return queryForList("ReptDeptDao.selectList", param);
	}

	public ReptDept selectInfo(String deptId)
	{
		return (ReptDept)queryForObject("ReptDeptDao.selectInfo", Integer.parseInt(deptId));
	}

	public int deleteInfo(String deptId)
	{
		return delete("ReptDeptDao.deleteInfo", Integer.parseInt(deptId));
	}

	public void insertInfo(ReptDept ReptDept)
	{
		insert("ReptDeptDao.insertInfo", ReptDept);
	}
	
	public int updateInfo(ReptDept ReptDept)
	{
		return update("ReptDeptDao.updateInfo", ReptDept);
	}
	
}
