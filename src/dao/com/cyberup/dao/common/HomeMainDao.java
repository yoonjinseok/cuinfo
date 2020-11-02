package com.cyberup.dao.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;

@Repository
public class HomeMainDao extends BaseDAO {
	
	//뉴스목록
	public List newsList(){
		return queryForList("HomeMainDao.newsList");
	}
	//대학행사
	public List eventList(){
		return queryForList("HomeMainDao.eventList");
	}
	//협의회
	public List conferenceList(){
		return queryForList("HomeMainDao.conferenceList");
	}
	//공지사항
	public List noticeList(){
		return queryForList("HomeMainDao.noticeList");
	}
	//대학별강의,학교소개 리스트
	public List univCourseList(){
		return queryForList("HomeMainDao.univCourseList");
	}
	//맛보기강의
	public List univPublicList(){
		return queryForList("HomeMainDao.univPublicList");
	}
	
	//공개강의
	public List publicCoureList(){
		return queryForList("HomeMainDao.publicCoureList");
	}
	
	//강의맛보기
	public List sampleList(){
		return queryForList("HomeMainDao.sampleList");
	}
	
	
	
	//임시 대학별 추천강의
	public List univCourseList_tmp(){
		return queryForList("HomeMainDao.univCourseList_tmp");
	}
	//임시 맛보기 강의
	public List univCourseList_tmp2(){
		return queryForList("HomeMainDao.univCourseList_tmp2");
	}
	
	//추천링크
	public List getRecommendLink(String menuId){
		String upmenuId = (String)queryForObject("HomeMainDao.getRecommendUpmenuId",menuId);
			
		if(upmenuId != null) {
			String[] upmenuIds = upmenuId.split(",");
			System.out.println("upmenuIds ==> " + upmenuIds);
			HashMap hmap = new HashMap();
			hmap.put("upmenuIds", upmenuIds);
			
			return queryForList("HomeMainDao.getRecommendLink",hmap);			
		} else {
			return new ArrayList();
		}
	}
	
	//페이스북 정보
	@SuppressWarnings("rawtypes")
	public List getFacebookInfo(){
		return queryForList("HomeMainDao.getFacebookInfo");
	}
	
	
}
