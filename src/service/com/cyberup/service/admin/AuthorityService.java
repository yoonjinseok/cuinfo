package com.cyberup.service.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.admin.AuthorityDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.admin.Authority;


@Service
@Transactional
public class AuthorityService {
	@Autowired
	private AuthorityDao authorityDao;

	public void insertInfo(Authority authority) {
		this.authorityDao.insertInfo(authority);
	}
	public int deleteInfo(Integer authLevelId, String menuId) {
		return this.authorityDao.deleteInfo(authLevelId, menuId);
	}
	public List<Authority> selectList(String useYn, Integer authLevelId) {
		return this.authorityDao.selectList(useYn, authLevelId);
	}
	public List<Authority> selectGroupList(String useYn, Integer authLevelId) {
		return this.authorityDao.selectGroupList(useYn, authLevelId);
	}
	public Authority selectInfo(Integer authLevelId, String menuId) {
		return this.authorityDao.selectInfo(authLevelId, menuId);
	}
}
