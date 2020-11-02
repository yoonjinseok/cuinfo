package com.cyberup.dao.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.stats.CourseStats;

@Repository
public class CourseStatsDao extends BaseDAO {

	public List<CourseStats> selectPeriodList(CourseStats courseState)
	{

		return queryForList("CourseStatsDao.selectPeriodList",courseState );
	}
	
	public List<CourseStats> selectUnivList(CourseStats courseState)
	{
		
		return queryForList("CourseStatsDao.selectUnivList", courseState);
	}
	
	public List<CourseStats> selectClassDeptList(CourseStats courseState)
	{		
		return queryForList("CourseStatsDao.selectClassDeptList", courseState);
	}
}
