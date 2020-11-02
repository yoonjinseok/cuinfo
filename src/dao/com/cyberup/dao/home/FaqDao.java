package com.cyberup.dao.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.home.Faq;

@Repository
public class FaqDao extends BaseDAO {
	
	@SuppressWarnings("unchecked")
	public List selectSection()
	{
		return queryForList("FaqDao.selectSection");
	}
	
	public Faq selectInfo(Integer faqId)
	{
		return (Faq)queryForObject("FaqDao.selectInfo", faqId);
	}

	public int deleteInfo(Integer faqId)
	{
		return delete("FaqDao.deleteInfo", faqId);
	}

	public void insertInfo(Faq faq)
	{
		insert("FaqDao.insertInfo", faq);
	}

	@SuppressWarnings("unchecked")
	public List selectList(Integer showCnt, Integer currPage, Integer sectionId, String faqContent, String faqWriter, String selectRadio1, String selectRadio2,String searchCon1,String searchCon2)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("sectionId", sectionId);
		param.put("faqContent", faqContent);
		param.put("faqWriter", faqWriter);		
		param.put("selectRadio1", selectRadio1);
		param.put("selectRadio2", selectRadio2);
		param.put("searchCon1", searchCon1);
		param.put("searchCon2", searchCon2);		
		return queryForList("FaqDao.selectList", param);
	}

	public int updateInfo(Faq faq)
	{
		return update("FaqDao.updateInfo", faq);
	}
	public int updateHitsCount(Integer faqId)
	{
		return update("FaqDao.updateHitsCount", faqId);
	}
	
	public int initFileBoard(Integer fileGid)
	{
		return update("FaqDao.initFileBoard", fileGid);
	}	
	public List univFaqList()
	{
		return queryForList("FaqDao.univFaqList");
	}
}
