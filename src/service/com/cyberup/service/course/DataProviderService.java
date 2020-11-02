package com.cyberup.service.course;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.course.DataProviderDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;


@Service
@Transactional
public class DataProviderService {
	@Autowired
	private DataProviderDao dataProviderDao;

	public DataProvider selectInfo(Integer universityId) {
		return this.dataProviderDao.selectInfo(universityId);
	}
	public int deleteInfo(Integer universityId) {
		return this.dataProviderDao.deleteInfo(universityId);
	}
	public void insertInfo(DataProvider dataProvider) {
		this.dataProviderDao.insertInfo(dataProvider);
	}
	public List<DataProvider> selectList(Integer showCnt, Integer currPage, String universityName, String useYn) {
		return this.dataProviderDao.selectList(showCnt, currPage, universityName, useYn);
	}
	public int updateInfo(DataProvider dataProvider) {
		return this.dataProviderDao.updateInfo(dataProvider);
	}
}
