package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Schedule;

@Repository
public class HistoryDao extends BaseDAO {
	public Integer insertInfo(History history)
	{
		Integer key = (Integer)insert("HistoryDao.insertInfo", history);
		history.setHistoryId(key);
		
		return key;
	}

	public History selectInfo(Integer historyId)
	{
		return (History)queryForObject("HistoryDao.selectInfo", historyId);
	}
	
	public List<History> selectList(Integer showCnt, Integer currPage, Integer scheduleId)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("scheduleId", scheduleId);
		
		return queryForList("HistoryDao.selectList", param);
	}

	public int deleteInfo(Integer historyId)
	{
		return delete("HistoryDao.deleteInfo", historyId);
	}

	public int updateInfo(History history)
	{
		return update("HistoryDao.updateInfo", history);
	}
}
