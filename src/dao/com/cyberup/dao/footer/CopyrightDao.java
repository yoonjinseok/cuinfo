package com.cyberup.dao.footer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.footer.Copyright;

@Repository
public class CopyrightDao extends BaseDAO {
	@Resource(name="datasource")
	public void setBaseSource(DataSource dataSource)
	{
		super.setDataSource(dataSource);
	}
	public void insertInfo(Copyright copyright)
	{
		Copyright cpy = (Copyright)queryForObject("CopyrightDao.selectSeqId", 0);
		
		copyright.setId(cpy.getId());
		copyright.setRef(cpy.getId());
		
		insert("CopyrightDao.insertInfo", copyright);
		insert("CopyrightDao.insertUrlInfo", copyright);
		
	}
}
