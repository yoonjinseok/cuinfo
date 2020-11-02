package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;

@Repository
public class DataProviderDao extends BaseDAO {
	public DataProvider selectInfo(Integer universityId)
	{
		return (DataProvider)queryForObject("DataProviderDao.selectInfo", universityId);
	}

	public int deleteInfo(Integer universityId)
	{
		return delete("DataProviderDao.deleteInfo", universityId);
	}

	public void insertInfo(DataProvider dataProvider)
	{
		insert("DataProviderDao.insertInfo", dataProvider);
	}

	public List<DataProvider> selectList(Integer showCnt, Integer currPage, String universityName, String useYn)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("universityName", universityName);
		param.put("useYn", useYn);
		
		return queryForList("DataProviderDao.selectList", param);
	}

	public int updateInfo(DataProvider dataProvider)
	{
		return update("DataProviderDao.updateInfo", dataProvider);
	}
}
