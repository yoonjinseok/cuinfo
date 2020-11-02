package com.cyberup.dao.univ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.univ.UnivDept;

@Repository
public class UnivDeptDao extends BaseDAO {
	public UnivDept selectInfo(String univDeptId, Integer universityId)
	{
		Map param = new HashMap();
		param.put("univDeptId", univDeptId);
		param.put("universityId", universityId);
		
		return (UnivDept)queryForObject("UnivDeptDao.selectInfo", param);
	}

	public int deleteInfo(String univDeptId, Integer universityId)
	{
		Map param = new HashMap();
		param.put("univDeptId", univDeptId);
		param.put("universityId", universityId);
		
		return delete("UnivDeptDao.deleteInfo", param);
	}

	public void insertInfo(UnivDept univDept)
	{
		insert("UnivDeptDao.insertInfo", univDept);
	}

	public List<UnivDept> selectList(Integer showCnt, Integer currPage, 
									Integer universityId, String universityName, 
									String univDeptId, String univDeptName, 
									String deptId, String deptName, 
									String deptAllName, 
									String classifyId, Integer localId, 
									String searchCon1, String searchCon2, String searchCon3,
									String useYn,Integer authLevelId)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("universityId", universityId);
		param.put("universityName", universityName);
		param.put("univDeptId", univDeptId);		
		param.put("univDeptName", univDeptName);
		param.put("deptId", deptId);
		param.put("deptName", deptName);
		
		param.put("deptAllName", deptAllName);
		
		param.put("useYn", useYn);
		param.put("classifyId", classifyId);
		param.put("localId", localId);
		
		param.put("searchCon1", searchCon1);
		param.put("searchCon2", searchCon2);
		param.put("searchCon2", searchCon3);
		
		param.put("authLevelId", authLevelId);
		return queryForList("UnivDeptDao.selectList", param);
	}

	public int updateInfo(UnivDept univDept)
	{
		return update("UnivDeptDao.updateInfo", univDept);
	}
	public int updateUnivDeptName(UnivDept univDept)
	{
		return update("UnivDeptDao.updateUnivDeptName", univDept);
	}
}
