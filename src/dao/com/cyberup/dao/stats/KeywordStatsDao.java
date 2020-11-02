package com.cyberup.dao.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.stats.KeywordStats;

@Repository
public class KeywordStatsDao extends BaseDAO {
	

	public List<KeywordStats> selectList(KeywordStats keywordParam)
	{
			
		return queryForList("KeywordStatsDao.selectList", keywordParam);
	}
	
	public void insKeywordHits(String keyword, String regDT)
	{
		Map param = new HashMap();
		param.put("keyword", keyword);
		param.put("regDT", regDT);
		
		queryForObject("KeywordStatsDao.insKeywordHits", param);
	}

}
