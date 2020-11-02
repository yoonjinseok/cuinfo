package com.cyberup.service.common;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.common.HomeMainDao;
import com.cyberup.dao.common.NewHomeMainDao;
import com.cyberup.dao.course.CourseSearchDao;

@Service
@Transactional
public class HomeMainService {
	
	@Autowired
	private HomeMainDao homeMainDao;

	@Autowired
	private NewHomeMainDao newHomeMainDao;

	public List adminList() {return newHomeMainDao.selectAdminCount(); }
	public List newsList(){
		return homeMainDao.newsList();
	}
	public List eventList(){
		return homeMainDao.eventList();
	}
	public List noticeList(){
		return homeMainDao.noticeList();
	}
	public List conferenceList(){
		return homeMainDao.conferenceList();
	}
	public List univCourseList(){
		return homeMainDao.univCourseList();
	}
	public List univPublicList(){
		return homeMainDao.univPublicList();
	}
	public List publicCoureList(){
		return homeMainDao.publicCoureList();
	}
	public List sampleList(){
		return homeMainDao.sampleList();
	}
	
	public List univCourseList_tmp(){
		return homeMainDao.univCourseList_tmp();
	}
	public List univCourseList_tmp2(){
		return homeMainDao.univCourseList_tmp2();
	}
	
	public List getRecommendLink(String menuId){
		return homeMainDao.getRecommendLink(menuId);
	}
	
	public List getFacebookInfo(){
		return homeMainDao.getFacebookInfo();
	}
	
	
	

}
