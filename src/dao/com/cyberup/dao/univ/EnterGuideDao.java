package com.cyberup.dao.univ;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.univ.Univ;

@Repository
public class EnterGuideDao extends BaseDAO{

	public List<Univ> selectEnterGuideList(Univ univ)
	{
		return queryForList("EnterGuideDao.selectEnterGuideList",univ);
	}
	
	public List<Univ> selectEnterGuideList2(Univ univ)
	{
		return queryForList("EnterGuideDao.selectEnterGuideList2",univ);
	}
	

}
