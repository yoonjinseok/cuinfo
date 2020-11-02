package com.cyberup.service.stats;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.stats.StatsDao;
import com.cyberup.dao.system.CodeDao;
import com.cyberup.model.stats.Stats;
import com.cyberup.model.system.Code;


@Service
@Transactional
public class StatsService {
	@Autowired
	private StatsDao statsDao;

	public String getToday(){
		return statsDao.getToday();
	}
	
	public String getPassday(){
		return statsDao.getPassday();
	}
	
	public Stats selectSumStaticsOfUniversity(String universityId, String startDate, String endDate)
	{
		return this.statsDao.selectSumStaticsOfUniversity(universityId, startDate, endDate);
	}
	public Map selectManageStaticsOfUniversity(String universityId)
	{
		return this.statsDao.selectManageStaticsOfUniversity(universityId);
	}
	
	public List selectCourseByPeriod(Stats stats){
		return statsDao.selectCourseByPeriod(stats);
	}
	
	public List selectCourseByUniv_list(Stats stats){
		return statsDao.selectCourseByUniv_list(stats);
	}
	
	public List selectCourseByCCL_list(Stats stats){
		return statsDao.selectCourseByCCL_list(stats);
	}
	
	public List courseByGrant_list(Stats stats){
		return statsDao.courseByGrant_list(stats);
	}
	
	public List courseByType_list(Stats stats){
		return statsDao.courseByType_list(stats);
	}
}
