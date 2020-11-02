package com.cyberup.service.curri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.curri.RecommendDao;
import com.cyberup.model.curri.Recommend;

@Service
@Transactional
public class RecommendService {
	@Autowired
	private RecommendDao recommendDao;
	
	public List<Recommend> recommendLectureList(Recommend recommend) {
		return recommendDao.recommendLectureList(recommend);
	}
	
	public List<Recommend> sampleLectureList(Recommend recommend) {
		return this.recommendDao.sampleLectureList(recommend);
	}
	
}
