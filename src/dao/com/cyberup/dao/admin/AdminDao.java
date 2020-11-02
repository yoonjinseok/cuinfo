package com.cyberup.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;

@Repository
public class AdminDao extends BaseDAO {

	public List<Admin> selectList(Integer showCnt, Integer currPage, Integer authLevelId, String adminId, String adminName, String adminCompany)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("authLevelId", authLevelId);
		param.put("adminId", adminId);
		param.put("adminName", adminName);
		param.put("adminCompany", adminCompany);
		
		return queryForList("AdminDao.selectList", param);
	}
	
	public int deleteInfo(String adminId)
	{
		return delete("AdminDao.deleteInfo", adminId);
	}

	public Admin selectInfo(String adminId)
	{
		return (Admin)queryForObject("AdminDao.selectInfo", adminId);
	}

	public int updateInfo(Admin admin)
	{
		return update("AdminDao.updateInfo", admin);
	}

	public void insertInfo(Admin admin)
	{
		insert("AdminDao.insertInfo", admin); 
	}
}
