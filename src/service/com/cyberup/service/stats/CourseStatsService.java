package com.cyberup.service.stats;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cyberup.model.stats.CourseStats;
import com.cyberup.dao.stats.CourseStatsDao;

@Service
@Transactional
public class CourseStatsService {
	
	@Autowired
	private CourseStatsDao courseStatsDao;

	public List<CourseStats> selectPeriodList(CourseStats courseState)
	{
		return this.courseStatsDao.selectPeriodList(courseState);
	}
	public List<CourseStats> selectUnivList(CourseStats courseState)
	{
		return this.courseStatsDao.selectUnivList(courseState);
	}
	public List<CourseStats> selectClassDeptList(CourseStats courseState)
	{
		return this.courseStatsDao.selectClassDeptList(courseState);
	}
}
