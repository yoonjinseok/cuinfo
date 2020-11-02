package com.cyberup.dao.curri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.curri.Recommend;

@Repository
public class RecommendDao extends BaseDAO {
	
	public List<Recommend> recommendLectureList(Recommend recommend) {
		return queryForList("RecommendDao.recommendLectureList", recommend);
	}
	
	public List<Recommend> sampleLectureList(Recommend recommend) {
		return queryForList("RecommendDao.sampleLectureList", recommend);
	}
	
}
