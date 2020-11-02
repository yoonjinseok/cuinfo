package com.cyberup.service.system;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.system.ReptDeptDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.ReptDept;

@Service
@Transactional
public class ReptDeptService {

	@Autowired
	private ReptDeptDao reptDeptDao;
	
	public List<ReptDept> selectList(Integer showCnt, Integer currPage, String deptId, String deptName, String classifyId, 
									String searchCon1, String searchCon2, String searchCon3, String useYn) {
		Logger.getLogger(this.getClass()).debug("searchCon1 :" + searchCon1);
		Logger.getLogger(this.getClass()).debug("searchCon2 :" + searchCon2);
		return this.reptDeptDao.selectList(showCnt, currPage, deptId, deptName, classifyId, 
										searchCon1, searchCon2, searchCon3, useYn);
	}
	public ReptDept selectInfo(String deptId) {
		return this.reptDeptDao.selectInfo(deptId);
	}
	public int deleteInfo(String deptId) {
		return this.reptDeptDao.deleteInfo(deptId);
	}
	public void insertInfo(ReptDept reptDept) {
		this.reptDeptDao.insertInfo(reptDept);
	}
	public int updateInfo(ReptDept reptDept) {
		System.out.println("\n\n " + Integer.toString(Integer.parseInt(reptDept.getDeptId())));
		
		return this.reptDeptDao.updateInfo(reptDept);
	}
	
}
