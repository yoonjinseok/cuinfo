package com.cyberup.dao.refer;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.refer.ServiceGuide;


@Repository
public class ServiceGuideDao extends BaseDAO {
	
	public List<ServiceGuide> selectQuestionInfo(ServiceGuide serviceGuide)
	{
		return queryForList("ServiceGuideDao.selectQuestionInfo", serviceGuide);
	}
	
	public List<ServiceGuide> selectAnswerGuideList(Integer guideNo)
	{
		return queryForList("ServiceGuideDao.selectAnswerGuideList", guideNo);
	}
	
	public String selectQuestionEnd(ServiceGuide serviceGuide)
	{
		return (String)queryForObject("ServiceGuideDao.selectQuestionEnd", serviceGuide);
	}
	
}
