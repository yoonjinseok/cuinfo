package com.cyberup.framework.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Base DAO - 모든 DAO는 이 클래스를 상속 받는다 ~ 
 */
public abstract class NewBaseDAO extends SqlMapClientTemplate {
	@Autowired
	public void setSqlMapClient(SqlMapClient sqlMapClient)
	{
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Resource(name="datasource2")
	public void setBaseSource(DataSource dataSource)
	{
		super.setDataSource(dataSource);
	}
}
