package com.cyberup.dao.stats;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.course.Course;
import com.cyberup.model.stats.Stats;

@Repository
public class StatsDao extends BaseDAO {

	public String getToday(){
		return (String)queryForObject("StatsDao.getToday");
	}
	
	public String getPassday(){
		return (String)queryForObject("StatsDao.getPassday");
	}
	
	public Stats selectSumStaticsOfUniversity(String universityId, String startDate, String endDate)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		return (Stats)queryForObject("StatsDao.selectSumStaticsOfUniversity", param);
	}
	
	public Map selectManageStaticsOfUniversity(String universityId)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		return (Map)queryForObject("StatsDao.selectManageStaticsOfUniversity", param);
	}
	
	public List selectCourseByPeriod(Stats stats){
		return queryForList("StatsDao.selectCourseByPeriod_list",stats);
	}
	
	public List selectCourseByUniv_list(Stats stats){
		return queryForList("StatsDao.selectCourseByUniv_list",stats);
	}
	
	public List selectCourseByCCL_list(Stats stats){
		return queryForList("StatsDao.selectCourseByCCL_list",stats);
	}
	
	public List courseByGrant_list(Stats stats){
		return queryForList("StatsDao.courseByGrant_list",stats);
	}
	
	public List courseByType_list(Stats stats){
		return queryForList("StatsDao.courseByType_list",stats);
	}
	
	
}
