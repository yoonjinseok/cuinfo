package com.cyberup.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.ScheduleDao;
import com.cyberup.model.course.Schedule;


@Service
@Transactional
public class ScheduleService {
	@Autowired
	private ScheduleDao scheduleDao;

	public int updateInfo(Schedule schedule) {
		return this.scheduleDao.updateInfo(schedule);
	}
	public int updateRunningStatus(Integer scheduleId, String runningStatus, String scheduleModifier)
	{
		return this.scheduleDao.updateRunningStatus(scheduleId, runningStatus, scheduleModifier);
	}
	public Integer insertInfo(Schedule schedule) {
		return this.scheduleDao.insertInfo(schedule);
	}
	public List<Schedule> selectHarvestList(String harvestDate) {
		return this.scheduleDao.selectHarvestList(harvestDate);
	}
	public List<Schedule> selectManualHarvestList(Integer universityId, Integer runHour) {
		return this.scheduleDao.selectManualHarvestList(universityId, runHour);
	}
	public int deleteInfo(Integer scheduleId) {
		return this.scheduleDao.deleteInfo(scheduleId);
	}
	public Schedule selectInfo(Integer scheduleId) {
		return this.scheduleDao.selectInfo(scheduleId);
	}
	public List<Schedule> selectList(String manualYn, Integer showCnt, Integer currPage, String universityName, String status)
	{
		return this.scheduleDao.selectList(manualYn, showCnt, currPage, universityName, status);
	}
}
