package com.cyberup.service.home;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.model.admin.Admin;

import com.cyberup.model.home.BoardUniv;
import com.cyberup.dao.home.BoardUnivDao;

@Service
@Transactional
public class BoardUnivService {
	@Autowired
	private BoardUnivDao boardUnivDao;

	public BoardUniv selectInfo(long boardID) {
		return this.boardUnivDao.selectInfo(boardID);
	}
	Map param = new HashMap();

	public List<BoardUniv> selectList(Integer showCnt, Integer currPage,String gubunID, String searchTitle, String searchContent, 
						String searchRegID, String searchRegName,String univID, Integer eventState)
	{
		return this.boardUnivDao.selectList(showCnt, currPage, gubunID, searchTitle, searchContent,searchRegID, searchRegName,univID,eventState );
	}

	public int deleteInfo(long boardID) {
		return this.boardUnivDao.deleteInfo(boardID);
	}
	public void insertInfo(BoardUniv board) {
		this.boardUnivDao.insertInfo(board);
	}			
	public int updateInfo(BoardUniv board) {
		return this.boardUnivDao.updateInfo(board);
	}
	public int updateHitsCount(BoardUniv board) {
		return this.boardUnivDao.updateHitsCount(board);
	}
	
	public int initFileBoard(Integer fileGid) {
		return this.boardUnivDao.initFileBoard(fileGid);
	}

}
