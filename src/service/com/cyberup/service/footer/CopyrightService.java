package com.cyberup.service.footer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.footer.CopyrightDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.footer.Copyright;

@Service
@Transactional
public class CopyrightService {
	@Autowired
	private CopyrightDao copyrightDao;
	
	public void insertInfo(Copyright copyright) {
		this.copyrightDao.insertInfo(copyright);
	}
	
}
