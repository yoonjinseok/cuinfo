package com.cyberup.framework.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

/**
 * Base DAO - 모든 DAO는 이 클래스를 상속 받는다 ~ 
 */
public class JdbcBaseDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	@Autowired
	protected void setSqlMapClient(SqlMapClient sqlMapClient)
	{
		this.sqlMapClientTemplate = new SqlMapClientTemplate(dataSource, sqlMapClient);
	}
	
	@Resource(name="kocwDatasource")
	protected void setDataSource(DataSource dataSource)
	{
		init(dataSource);
	}
	
	private void init(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	protected JdbcTemplate getJdbcTemplate()
	{
		return this.jdbcTemplate;
	}
	
	protected String getSql(String id, Object param)
	{
		ExtendedSqlMapClient extended = (ExtendedSqlMapClient)sqlMapClientTemplate.getSqlMapClient();
		MappedStatement stmt = extended.getMappedStatement(id);

		SessionScope sessionScope = new SessionScope();
		StatementScope statementScope = new StatementScope(sessionScope);
		stmt.initRequest(statementScope);

		String sql = stmt.getSql().getSql(statementScope, param);
		
		Logger.getLogger(this.getClass()).debug("JDBCSQL(" + id + ") : " + sql);
		
		return sql;
	}
	
	public int queryForInt(String sql_id, Map<String, ?> args) throws DataAccessException {
		return getJdbcTemplate().queryForInt(getSql(sql_id, args), args);
	}

	public int queryForInt(String sql_id, BeanSqlParameterSource args) throws DataAccessException {
		return getJdbcTemplate().queryForInt(getSql(sql_id, args.getObject()), args);
	}

	public int queryForInt(String sql_id, Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForInt(getSql(sql_id, args), args);
	}

	public long queryForLong(String sql_id, Map<String, ?> args) throws DataAccessException {
		return getJdbcTemplate().queryForLong(getSql(sql_id, args), args);
	}

	public long queryForLong(String sql_id, BeanSqlParameterSource args) throws DataAccessException {
		return getJdbcTemplate().queryForLong(getSql(sql_id, args.getObject()), args);
	}

	public long queryForLong(String sql_id, Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForLong(getSql(sql_id, args), args);
	}

	public <T> T queryForObject(String sql_id, Class<T> requiredType, Map<String, ?> args) throws DataAccessException {
		return getJdbcTemplate().queryForObject(getSql(sql_id, args), requiredType, args);
	}

	public <T> T queryForObject(String sql_id, Class<T> requiredType, BeanSqlParameterSource args)
			throws DataAccessException {
		return getJdbcTemplate().queryForObject(getSql(sql_id, args.getObject()), requiredType, args);
	}

	public <T> T queryForObject(String sql_id, Class<T> requiredType, Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForObject(getSql(sql_id, args), requiredType, args);
	}

	public <T> T queryForObject(String sql_id, RowMapper<T> rm, Map<String, ?> args) throws DataAccessException {
		return getJdbcTemplate().queryForObject(getSql(sql_id, args), rm, args);
	}

	public <T> T queryForObject(String sql_id, RowMapper<T> rm, BeanSqlParameterSource args)
			throws DataAccessException {
		return getJdbcTemplate().queryForObject(getSql(sql_id, args.getObject()), rm, args);
	}

	public <T> T queryForObject(String sql_id, RowMapper<T> rm, Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForObject(getSql(sql_id, args), rm, args);
	}

	public <T> List<T> queryForList(String sql_id, RowMapper<T> rm, Map<String, ?> args) throws DataAccessException {
		return getJdbcTemplate().query(getSql(sql_id, args), rm, args);
	}

	public <T> List<T> queryForList(String sql_id, RowMapper<T> rm, BeanSqlParameterSource args)
			throws DataAccessException {
		return getJdbcTemplate().query(getSql(sql_id, args.getObject()), rm, args);
	}

	public <T> List<T> queryForList(String sql_id, RowMapper<T> rm, Object... args) throws DataAccessException {
		return getJdbcTemplate().query(getSql(sql_id, args), rm, args);
	}

	public int update(String sql_id, Map<String, ?> args) throws DataAccessException {
		return getJdbcTemplate().update(getSql(sql_id, args), args);
	}

	public int update(String sql_id, BeanSqlParameterSource args) throws DataAccessException {
		return getJdbcTemplate().update(getSql(sql_id, args.getObject()), args);
	}

	public int update(String sql_id, Object ... args) throws DataAccessException {
		return getJdbcTemplate().update(getSql(sql_id, args), args);
	}
}
