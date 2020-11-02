package com.cyberup.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.admin.Authority;

@Repository
public class AuthorityDao extends BaseDAO {

	public void insertInfo(Authority authority)
	{
		insert("AuthorityDao.insertInfo", authority);
	}

	public int deleteInfo(Integer authLevelId, String menuId)
	{
		Map param = new HashMap();
		param.put("authLevelId", authLevelId);
		param.put("menuId", menuId);

		return delete("AuthorityDao.deleteInfo", param);
	}

	public List<Authority> selectList(String useYn, Integer authLevelId)
	{
		Map param = new HashMap();
		param.put("useYn", useYn);
		param.put("authLevelId", authLevelId);

		return queryForList("AuthorityDao.selectList", param);
	}

	public List<Authority> selectGroupList(String useYn, Integer authLevelId)
	{
		Map param = new HashMap();
		param.put("useYn", useYn);
		param.put("authLevelId", authLevelId);

		return queryForList("AuthorityDao.selectGroupList", param);
	}

	public Authority selectInfo(Integer authLevelId, String menuId)
	{
		Map param = new HashMap();
		param.put("authLevelId", authLevelId);
		param.put("menuId", menuId);

		return (Authority)queryForObject("AuthorityDao.selectInfo", param);
	}
}
