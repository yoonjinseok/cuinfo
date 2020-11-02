package com.cyberup.dao.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.home.Poup;

@Repository
public class PoupDao extends BaseDAO {
	
	public Poup infopoup(Integer poupNum)
	{
		System.out.println("PoupDaq poupNum : " + poupNum);
		return (Poup)queryForObject("PoupDao.infopoup", poupNum);
	}

	public int deletepoup(Integer poupNum)
	{
		return delete("PoupDao.deletepoup", poupNum);
	}

	public void insertpoup(Poup Poup)
	{
		insert("PoupDao.insertpoup", Poup);
	}

	public List<Poup> selectPoupShowList()
	{
		Map param = new HashMap();
		param.put("showYn", "Y");
		return queryForList("PoupDao.selectPoupShowList", param);
	}
	
	public List<Poup> selectpouplist(Integer showCnt, Integer currPage, String searchword, String selectYn, String selectRadio1)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("searchword", searchword);
		param.put("selectYn", selectYn);		
		param.put("selectRadio1", selectRadio1);
		return queryForList("PoupDao.selectpouplist", param);
	}

	public int updatepoup(Poup dataProvider)
	{
		return update("PoupDao.updatepoup", dataProvider);
	}
	
	public int initFileBoard1(Integer fileGid)
	{
		return update("PoupDao.initFileBoard1", fileGid);
	}
	public int initFileBoard2(Integer fileGid)
	{
		return update("PoupDao.initFileBoard2", fileGid);
	}
}
