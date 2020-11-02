package com.cyberup.dao.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.system.UnivCode;

@Repository
public class UnivCodeDao extends BaseDAO {
	public Integer insertInfo(UnivCode univCode)
	{
		Integer universityId = (Integer)insert("UnivCodeDao.insertInfo", univCode);
		univCode.setUniversityId(universityId);
		
		return universityId;
	}

	public UnivCode selectInfo(Integer universityId)
	{
		return (UnivCode)queryForObject("UnivCodeDao.selectInfo", universityId);
	}

	public List<UnivCode> selectList(Integer showCnt, Integer currPage, String useYn, String univName, Integer gubunId, String installDataProvider)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("useYn", useYn);
		param.put("univName", univName);
		param.put("gubunId", gubunId);
		param.put("installDataProvider", installDataProvider);
		
		return queryForList("UnivCodeDao.selectList", param);
	}
	
	public List<UnivCode> mgrSelectList(Integer showCnt, Integer currPage, String useYn, String univName, Integer gubunId, Integer localId, String selectRadio1, String searchWord)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("useYn", useYn);
		param.put("univName", univName);
		param.put("gubunId", gubunId);
		param.put("localId", localId);
		param.put("selectRadio1", selectRadio1);
		param.put("searchWord", searchWord);
		
		return queryForList("UnivCodeDao.mgrSelectList", param);
	}

	public int deleteInfo(Integer universityId)
	{
		return delete("UnivCodeDao.deleteInfo", universityId);
	}

	public int updateInfo(UnivCode univCode)
	{
		return update("UnivCodeDao.updateInfo", univCode);
	}
}
