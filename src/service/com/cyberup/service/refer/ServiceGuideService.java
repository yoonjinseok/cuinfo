package com.cyberup.service.refer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.refer.ServiceGuideDao;
import com.cyberup.model.refer.ServiceGuide;
import com.ms.asp.Server;

@Service
@Transactional
public class ServiceGuideService {
	@Autowired
	private ServiceGuideDao serviceGuideDao;

	
	public List<ServiceGuide> selectQuestionInfo(ServiceGuide serviceGuide)
	{
		return this.serviceGuideDao.selectQuestionInfo(serviceGuide);
	}
	
	public List<ServiceGuide> selectAnswerGuideList(Integer guideNo)
	{
		return this.serviceGuideDao.selectAnswerGuideList(guideNo);
	}
	
	public String selectQuestionEnd(ServiceGuide serviceGuide){
		return this.serviceGuideDao.selectQuestionEnd(serviceGuide);
	}

}
