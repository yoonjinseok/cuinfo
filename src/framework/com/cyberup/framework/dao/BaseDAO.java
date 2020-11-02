package com.cyberup.framework.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.web.context.request.RequestScope;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

/**
 * Base DAO - 모든 DAO는 이 클래스를 상속 받는다 ~ 
 */
public abstract class BaseDAO extends SqlMapClientTemplate {
	@Autowired
	public void setSqlMapClient(SqlMapClient sqlMapClient)
	{
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Resource(name="datasource")
	public void setBaseSource(DataSource dataSource)
	{
		super.setDataSource(dataSource);
	}
}
