package com.cyberup.dao.home;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.home.NewsFeedModel;

@Repository
public class NewsFeedDao extends BaseDAO{
	
	public List<NewsFeedModel> selectNewsFeedList(NewsFeedModel newsFeedModel)
	{
		return queryForList("NewsFeedDao.selectNewsFeedList",newsFeedModel);
	}
	
	public List<NewsFeedModel> selectNewsFeedList2(NewsFeedModel newsFeedModel)
	{
		return queryForList("NewsFeedDao.selectNewsFeedList2",newsFeedModel);
	}
	
	public int newsFeed_delete(NewsFeedModel newsFeedModel)
	{
		return update("NewsFeedDao.newsFeed_delete",newsFeedModel);
	}
	
	public void newsFeed_insert(NewsFeedModel newsFeedModel)
	{
		insert("NewsFeedDao.newsFeed_insert",newsFeedModel);
	}
	public int isDuplicated(NewsFeedModel newsFeedModel)
	{
		return (Integer)queryForObject("NewsFeedDao.isDuplicated",newsFeedModel);
	}
}
