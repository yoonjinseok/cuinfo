package com.cyberup.service.stats;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cyberup.model.stats.KeywordStats;
import com.cyberup.model.stats.ServiceStats;
import com.cyberup.dao.stats.KeywordStatsDao;

@Service
@Transactional
public class KeywordStatsService {
	
	@Autowired
	private KeywordStatsDao searchStatsDao;

	public List<KeywordStats> selectList(KeywordStats keywordParam)	{
		return this.searchStatsDao.selectList(keywordParam);
	}
	
	public void insKeywordHits(String keyword, String regDT) {
		this.searchStatsDao.insKeywordHits(keyword,regDT );
	}

}
