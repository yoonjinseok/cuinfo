package com.cyberup.service.stats;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cyberup.model.stats.ServiceStats;
import com.cyberup.dao.stats.ServiceStatsDao;

@Service
@Transactional
public class ServiceStatsService {
	
	@Autowired
	private ServiceStatsDao serviceStatsDao;

	public List<ServiceStats> selectCourseList(ServiceStats serviceParam)
	{
		return this.serviceStatsDao.selectCourseList(serviceParam);
	}
	
	public List<ServiceStats> selectUnivList(ServiceStats serviceParam )
	{
		return this.serviceStatsDao.selectUnivList(serviceParam);
	}
	public List<ServiceStats> selectDeptList(ServiceStats serviceParam)
	{
		return this.serviceStatsDao.selectDeptList(serviceParam);
	}
	public void insCourseHits(String courseID, String univID, String deptID) {
		this.serviceStatsDao.insCourseHits(courseID,univID,deptID );
	}
	public void insServiceHits(String univID, String deptID) {
		this.serviceStatsDao.insServiceHits(univID,deptID);
	}
}
