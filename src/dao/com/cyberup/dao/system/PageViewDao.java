package com.cyberup.dao.system;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.Code;
import com.cyberup.model.system.PageView;

@Repository
public class PageViewDao extends BaseDAO {
	public void insertInfo(PageView pageView)
	{
		insert("PageViewDao.insertInfo", pageView);
	}
	
	public void insertBatch(List<PageView> pageViewList) throws SQLException
	{
		getSqlMapClient().startBatch();
		
		for(int i = 0; i < pageViewList.size(); i++)
		{
			insert("PageViewDao.insertInfo", pageViewList.get(i));
		}
		
		getSqlMapClient().executeBatch();
	}
}
