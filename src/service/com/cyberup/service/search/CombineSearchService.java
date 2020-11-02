package com.cyberup.service.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.search.CombineSearchDao;
import com.cyberup.model.home.CombineSearch;

@Service
@Transactional
public class CombineSearchService {

	@Autowired
	private CombineSearchDao combineSearchDao;
	
	public List selectCourses(CombineSearch combineSearch)
	{
		combineSearch.setSearchGubn(1); 
		
		return combineSearchDao.totalSearch(combineSearch);
	}
	public List selectBoards(CombineSearch combineSearch)
	{
		combineSearch.setSearchGubn(2);
		return combineSearchDao.totalSearch(combineSearch);
	}
	public List selectKeywords()
	{
		return combineSearchDao.selectKeywords();
	}
	public List<CombineSearch> selectBestCourses() 
	{
		return combineSearchDao.selectBestCourses();
	}
	public List selectWeb(CombineSearch combineSearch) 
	{
		combineSearch.setSearchGubn(3);
		return combineSearchDao.totalSearch(combineSearch);
	}
}
