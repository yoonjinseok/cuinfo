package com.cyberup.service.home;

/*
import java.util.Date;
import com.cyberup.dao.admin.AdminDao;
import com.cyberup.model.admin.Admin;
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.home.FaqDao;
import com.cyberup.model.home.Faq;

@Service
@Transactional
public class FaqService {
	@Autowired
	private FaqDao faqDao;
	
	@SuppressWarnings("unchecked")
	public List selectSection() {
		return this.faqDao.selectSection();
	}
	public Faq selectInfo(Integer faqId) {
		return this.faqDao.selectInfo(faqId);
	}
	public int deleteInfo(Integer faqId) {
		return this.faqDao.deleteInfo(faqId);
	}
	public void insertInfo(Faq faq) {
		this.faqDao.insertInfo(faq);
	}
	@SuppressWarnings("unchecked")
	public List<Faq> selectList(Integer showCnt, Integer currPage, Integer sectionId, String faqContent, String faqWriter, String selectRadio1, String selectRadio2, String searchCon1,String searchCon2) {
		return this.faqDao.selectList(showCnt, currPage, sectionId, faqContent, faqWriter, selectRadio1, selectRadio2, searchCon1, searchCon2);
	}
	public int updateHitsCount(Integer faqId) {
		return this.faqDao.updateHitsCount(faqId);
	}
	public int updateInfo(Faq faq) {
		return this.faqDao.updateInfo(faq);
	}
	public int initFileBoard(Integer fileGid) {
		return this.faqDao.initFileBoard(fileGid);
	}
	public List univFaqList() {
		return this.faqDao.univFaqList();
	}
}
