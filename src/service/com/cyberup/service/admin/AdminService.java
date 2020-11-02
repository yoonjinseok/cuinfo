package com.cyberup.service.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.model.admin.Admin;


@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public List<Admin> selectList(Integer showCnt, Integer currPage, Integer authLevelId, String adminId, String adminName, String adminCompany) {
		return this.adminDao.selectList(showCnt, currPage, authLevelId, adminId, adminName, adminCompany);
	}
	
	public int deleteInfo(String adminId) {
		return this.adminDao.deleteInfo(adminId);
	}
	public Admin selectInfo(String adminId) {
		return this.adminDao.selectInfo(adminId);
	}
	public int updateInfo(Admin admin) {
		return this.adminDao.updateInfo(admin);
	}
	public void insertInfo(Admin admin) {
		this.adminDao.insertInfo(admin);
	}
}
