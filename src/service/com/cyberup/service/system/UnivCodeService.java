package com.cyberup.service.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.course.DataProviderDao;
import com.cyberup.dao.system.UnivCodeDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.system.UnivCode;


@Service
@Transactional
public class UnivCodeService {
	@Autowired
	private UnivCodeDao univCodeDao;

	public Integer insertInfo(UnivCode univCode) {
		return this.univCodeDao.insertInfo(univCode);
	}
	public UnivCode selectInfo(Integer universityId) {
		return this.univCodeDao.selectInfo(universityId);
	}
	public List<UnivCode> selectList(Integer showCnt, Integer currPage, String useYn, String univName, Integer gubunId, String installDataProvider) {
		return this.univCodeDao.selectList(showCnt, currPage, useYn, univName, gubunId, installDataProvider);
	}
	public List<UnivCode> mgrSelectList(Integer showCnt, Integer currPage, String useYn, String univName, Integer gubunId, Integer localId, String selectRadio1, String searchWord) {
		return this.univCodeDao.mgrSelectList(showCnt, currPage, useYn, univName, gubunId,localId,selectRadio1,searchWord);
	}
	public int deleteInfo(Integer universityId) {
		return this.univCodeDao.deleteInfo(universityId);
	}
	public int updateInfo(UnivCode univCode) {
		return this.univCodeDao.updateInfo(univCode);
	}
}
