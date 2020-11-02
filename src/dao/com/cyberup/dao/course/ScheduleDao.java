package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Schedule;

@Repository
public class ScheduleDao extends BaseDAO {
	public int updateInfo(Schedule schedule)
	{
		return update("ScheduleDao.updateInfo", schedule);
	}
	public int updateRunningStatus(Integer scheduleId, String runningStatus, String scheduleModifier)
	{
		Map param = new HashMap();
		param.put("scheduleId", scheduleId);
		param.put("runningStatus", runningStatus);
		param.put("scheduleModifier", scheduleModifier);
		
		return update("ScheduleDao.updateRunningStatus", param);
	}

	public Integer insertInfo(Schedule schedule)
	{
		Integer key = (Integer)insert("ScheduleDao.insertInfo", schedule);
		schedule.setScheduleId(key);
		
		return key;
	}

	public List<Schedule> selectHarvestList(String harvestDate)
	{
		Map param = new HashMap();
		param.put("harvestDate", harvestDate);
		
		return queryForList("ScheduleDao.selectHarvestList", param);
	}
	public List<Schedule> selectManualHarvestList(Integer universityId, Integer runHour)
	{
		Map param = new HashMap();
		param.put("universityId", universityId);
		param.put("runHour", runHour);
		
		return queryForList("ScheduleDao.selectManualHarvestList", param);
	}

	public int deleteInfo(Integer scheduleId)
	{
		return delete("ScheduleDao.deleteInfo", scheduleId);
	}

	public Schedule selectInfo(Integer scheduleId)
	{
		return (Schedule)queryForObject("ScheduleDao.selectInfo", scheduleId);
	}
	
	public List<Schedule> selectList(String manualYn, Integer showCnt, Integer currPage, String universityName, String status)
	{
		Map param = new HashMap();
		param.put("manualYn", manualYn);
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("universityName", universityName);
		param.put("status", status);
		
		return queryForList("ScheduleDao.selectList", param);
	}
}
