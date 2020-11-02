package com.cyberup.service.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.MetaDicDao;
import com.cyberup.model.course.MetaDic;


@Service
@Transactional
public class MetaDicService {
	@Autowired
	private MetaDicDao metaDicDao;
	
	public List<MetaDic> selectList(String collType)
	{
		return metaDicDao.selectList(collType);
	}
	public int deleteInfo(Integer metadicId) {
		return this.metaDicDao.deleteInfo(metadicId);
	}
	public int updateInfo(MetaDic metaDic) {
		return this.metaDicDao.updateInfo(metaDic);
	}
	public Integer insertInfo(MetaDic metaDic) {
		return this.metaDicDao.insertInfo(metaDic);
	}
	public MetaDic selectInfo(Integer metadicId) {
		return this.metaDicDao.selectInfo(metadicId);
	}
}
