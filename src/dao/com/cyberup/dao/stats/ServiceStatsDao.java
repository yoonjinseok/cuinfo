package com.cyberup.dao.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.stats.ServiceStats;

@Repository
public class ServiceStatsDao extends BaseDAO {
	

	public List<ServiceStats> selectCourseList(ServiceStats serviceParam)
	{		
		return queryForList("ServiceStatsDao.selectCourseList", serviceParam);
	}
	
	public List<ServiceStats> selectUnivList(ServiceStats serviceParam)
	{		
		return queryForList("ServiceStatsDao.selectUnivList", serviceParam);
	}
	
	public List<ServiceStats> selectDeptList(ServiceStats serviceParam)
	{
	
		return queryForList("ServiceStatsDao.selectDeptList", serviceParam);
	}
	public void insCourseHits(String courseID, String univID, String deptID)
	{
		Map param = new HashMap();
		param.put("courseID", courseID);
		param.put("univID", univID);
		param.put("deptID", deptID);
		queryForObject("ServiceStatsDao.insCourseHits", param);
	}
	public void insServiceHits(String univID, String deptID)
	{
		Map param = new HashMap();
		param.put("univID", univID);
		param.put("deptID", deptID);
		queryForObject("ServiceStatsDao.insServiceHits", param);
	}
	

}
