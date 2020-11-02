package com.cyberup.service.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.home.NewsFeedDao;
import com.cyberup.model.home.NewsFeedModel;

@Service
@Transactional
public class NewsFeedService {
	
	@Autowired
	private NewsFeedDao newsFeedDao;

	public List selectNewsFeedList(NewsFeedModel newsFeedModel)
	{
		return newsFeedDao.selectNewsFeedList(newsFeedModel);
	}
	
	public List selectNewsFeedList2(NewsFeedModel newsFeedModel)
	{
		return newsFeedDao.selectNewsFeedList2(newsFeedModel);
	}
	
	public int newsFeed_delete(NewsFeedModel newsFeedModel)
	{
		return newsFeedDao.newsFeed_delete(newsFeedModel);
	}
	
	public void newsFeed_insert(NewsFeedModel newsFeedModel)
	{
		newsFeedDao.newsFeed_insert(newsFeedModel);
	}
	public int isDuplicated(NewsFeedModel newsFeedModel)
	{
		return newsFeedDao.isDuplicated(newsFeedModel);
	}
}
