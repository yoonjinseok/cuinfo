package com.cyberup.service.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.HistoryDao;
import com.cyberup.dao.course.ScheduleDao;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Schedule;


@Service
@Transactional
public class HistoryService {
	@Autowired
	private HistoryDao historyDao;

	public Integer insertInfo(History history) {
		return this.historyDao.insertInfo(history);
	}
	public History selectInfo(Integer historyId) {
		return this.historyDao.selectInfo(historyId);
	}
	public int deleteInfo(Integer historyId) {
		return this.historyDao.deleteInfo(historyId);
	}
	public int updateInfo(History history) {
		return this.historyDao.updateInfo(history);
	}
	public List<History> selectList(Integer showCnt, Integer currPage, Integer scheduleId)
	{
		return this.historyDao.selectList(showCnt, currPage, scheduleId);
	}
}
