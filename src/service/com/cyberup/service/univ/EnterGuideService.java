package com.cyberup.service.univ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.univ.EnterGuideDao;
import com.cyberup.model.univ.Univ;

@Service
@Transactional
public class EnterGuideService {
	
	@Autowired
	private EnterGuideDao enterGuideDao;
	
	public List<Univ> selectEnterGuideList(Univ univ)
	{
		return this.enterGuideDao.selectEnterGuideList(univ);
	}
	
	public List<Univ> selectEnterGuideList2(Univ univ)
	{
		return this.enterGuideDao.selectEnterGuideList2(univ);
	}
	
	
}
