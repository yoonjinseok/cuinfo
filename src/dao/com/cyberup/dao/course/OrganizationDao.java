package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Organization;
import com.cyberup.model.course.Schedule;

@Repository
public class OrganizationDao extends BaseDAO {
	public int deleteInfo(String orgId)
	{
		return delete("OrganizationDao.deleteInfo", orgId);
	}

	public void insertInfo(Organization organization)
	{
		insert("OrganizationDao.insertInfo", organization);
	}

	public int updateInfo(Organization organization)
	{
		return update("OrganizationDao.updateInfo", organization);
	}

	public Organization selectInfo(String orgId)
	{
		Map param = new HashMap();
		param.put("orgId", orgId);
		
		return (Organization)queryForObject("OrganizationDao.selectInfo", param);
	}
}
