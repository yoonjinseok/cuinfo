package com.cyberup.dao.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.home.BoardUniv;

@Repository
public class BoardUnivDao extends BaseDAO {
	
	public BoardUniv selectInfo(long boardID)
	{
		return (BoardUniv)queryForObject("BoardUnivDao.selectInfo", boardID);
	}

	public int deleteInfo(long boardID)
	{
		return delete("BoardUnivDao.deleteInfo", boardID);
	}

	public void insertInfo(BoardUniv board)
	{
		insert("BoardUnivDao.insertInfo", board);
	}		

	public List<BoardUniv> selectList(Integer showCnt, Integer currPage,String gubunID, String searchTitle, 
						String searchContent, String searchRegID, String searchRegName, String univID, Integer eventState)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("gubunID", gubunID);
		param.put("searchTitle", searchTitle);
		param.put("searchContent", searchContent);
		param.put("searchRegID", searchRegID);
		param.put("searchRegName", searchRegName);
		param.put("univID", univID);
		param.put("eventState", eventState);
		
		return queryForList("BoardUnivDao.selectList", param);
	}

	public int updateInfo(BoardUniv board)
	{
		return update("BoardUnivDao.updateInfo", board);
	}
	
	public int updateHitsCount(BoardUniv board)
	{
		return update("BoardUnivDao.updateHitsCount", board);
	}
	
	
	public int initFileBoard(Integer fileGid)
	{
		return update("BoardUnivDao.initFileBoard", fileGid);
	}	

}
