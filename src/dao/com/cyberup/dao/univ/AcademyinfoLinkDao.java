package com.cyberup.dao.univ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.univ.AcademyinfoLink;

@Repository
public class AcademyinfoLinkDao extends BaseDAO {
	
	public List<AcademyinfoLink> selectList(Integer showCnt, Integer currPage, Integer infoGubunId, String infoName, String useYn)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("infoGubunId", infoGubunId);
		param.put("infoName", infoName);
		param.put("useYn", useYn);

		return queryForList("AcademyinfoLinkDao.selectList", param);
		
	}
	
	public List<AcademyinfoLink> selectViewList()
	{
		return queryForList("AcademyinfoLinkDao.selectViewList");
	}
	
	public AcademyinfoLink selectInfo(Integer infoId)
	{
		return (AcademyinfoLink)queryForObject("AcademyinfoLinkDao.selectInfo", infoId);
	}
	
	public int deleteInfo(Integer infoId)
	{
		return delete("AcademyinfoLinkDao.deleteInfo", infoId);
	}
	
	public void insertInfo(AcademyinfoLink academyinfoLink)
	{
		insert("AcademyinfoLinkDao.insertInfo", academyinfoLink);
	}
	
	public int updateInfo(AcademyinfoLink academyinfoLink)
	{
		return update("AcademyinfoLinkDao.updateInfo", academyinfoLink);
	}
	
	public int updateDeadlink(Integer infoId, Integer deadlinkErrCode)
	{
		Map param = new HashMap();
		param.put("infoId", infoId);
		param.put("deadlinkErrCode", deadlinkErrCode);
		
		return update("AcademyinfoLinkDao.updateDeadlink", param);
	}
	
}
