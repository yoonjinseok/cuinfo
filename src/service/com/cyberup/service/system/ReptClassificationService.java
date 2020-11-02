package com.cyberup.service.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.system.ReptClassificationDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.ReptClassification;


@Service
@Transactional
public class ReptClassificationService {

	@Autowired
	private ReptClassificationDao reptClassificationDao;
	
	public List<ReptClassification> selectList(Integer showCnt, Integer currPage, String classifyId, String classifyName, 
												String searchCon1, String searchCon2, String searchCon3, String useYn) {
		return this.reptClassificationDao.selectList(showCnt, currPage, classifyId, classifyName, 
												searchCon1, searchCon2, searchCon3, useYn);
	}
	public List<ReptClassification> selectViewList(String useYn) {
		return this.reptClassificationDao.selectViewList(useYn);
	}
	public ReptClassification selectInfo(String classifyId) {
		return this.reptClassificationDao.selectInfo(classifyId);
	}
	public int deleteInfo(String classifyId) {
		return this.reptClassificationDao.deleteInfo(classifyId);
	}
	public void insertInfo(ReptClassification reptClassification) {
		this.reptClassificationDao.insertInfo(reptClassification);
	}
	public int updateInfo(ReptClassification reptClassification) {
		for(int i = 1; i<5; i++)		
			System.out.println("\n\n " + Integer.toString(Integer.parseInt(reptClassification.getClassifyId())));
		
		return this.reptClassificationDao.updateInfo(reptClassification);
	}
	
}
