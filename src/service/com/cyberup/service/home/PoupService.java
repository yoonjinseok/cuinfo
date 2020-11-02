package com.cyberup.service.home;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.home.PoupDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.home.Poup;



@Service
@Transactional
public class PoupService {
	@Autowired
	private PoupDao poupDao;
	
	@SuppressWarnings("unchecked")
	public Poup infopoup(Integer poupNum) {
		System.out.println("PoupService poupNum : " + poupNum);
		return this.poupDao.infopoup(poupNum);
	}
	public int deletepoup(Integer poupNum) {
		return this.poupDao.deletepoup(poupNum);
	}
	public void insertpoup(Poup poup) {
		this.poupDao.insertpoup(poup);
	}
	@SuppressWarnings("unchecked")
	public List<Poup> selectpouplist(Integer showCnt, Integer currPage, String searchword, String selectyn, String selectRadio1) {
		return this.poupDao.selectpouplist(showCnt, currPage, searchword, selectyn, selectRadio1);
	}
	@SuppressWarnings("unchecked")
	public List<Poup> selectPoupShowList() {
		return this.poupDao.selectPoupShowList();
	}
	
	public int updatepoup(Poup poup) {
		return this.poupDao.updatepoup(poup);
	}
	public int initFileBoard1(Integer fileGid) {
		return this.poupDao.initFileBoard1(fileGid);
	}
	public int initFileBoard2(Integer fileGid) {
		return this.poupDao.initFileBoard2(fileGid);
	}
}
