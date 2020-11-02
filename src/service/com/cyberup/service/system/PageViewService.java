package com.cyberup.service.system;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.system.PageViewDao;
import com.cyberup.model.system.PageView;


@Service
@Transactional
public class PageViewService {
	@Autowired
	private PageViewDao pageViewDao;

	public void insertInfo(PageView pageView) {
		this.pageViewDao.insertInfo(pageView);
	}
	
	public void insertBatch(List<PageView> pageViewList) throws SQLException
	{
		this.pageViewDao.insertBatch(pageViewList);
	}

}
