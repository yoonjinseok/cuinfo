package com.cyberup.dao.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.home.Board;

@Repository
public class BoardDao extends BaseDAO {
	
	public Board selectInfo(long boardID)
	{
		return (Board)queryForObject("BoardDao.selectInfo", boardID);
	}

	public int deleteInfo(long boardID)
	{
		return delete("BoardDao.deleteInfo", boardID);
	}

	public void insertInfo(Board board)
	{
		insert("BoardDao.insertInfo", board);
	}		

	public List<Board> selectList(Integer showCnt, Integer currPage,String gubunID, String title, String boardContent, String regID, String regName)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("gubunID", gubunID);
		param.put("searchTitle", title);
		param.put("searchContent", boardContent);
		param.put("searchRegID", regID);
		param.put("searchRegName", regName);

		return queryForList("BoardDao.selectList", param);
	}

	public int updateInfo(Board board)
	{
		return update("BoardDao.updateInfo", board);
	}
	
	public int updateHitsCount(Board board)
	{
		return update("BoardDao.updateHitsCount", board);
	}
	
	public int initFileBoard(Integer fileGid)
	{
		return update("BoardDao.initFileBoard", fileGid);
	}
	
	/*
	 * 파일 데이터 입력 처리  
	 
	public int selectSEQ_FILE_GID()
	{
		return (Integer) queryForObject("BoardDao.selectSEQ_FILE_GID");
	}
	
	
	public  List<Board> selectFileList(Integer upfileGid)
	{
		return queryForList("BoardDao.selectFileList", upfileGid);
	}
	
		
	public void insertUploadFile(Integer file_Gid, String source_file, String file_name, String file_size, String file_path, String reg_id)
	{
		Map param = new HashMap();
		param.put("file_Gid", file_Gid);
		param.put("source_file", source_file);
		param.put("file_name", file_name);
		param.put("file_size", file_size);
		param.put("file_path", file_path);
		param.put("reg_id", reg_id);	
		insert("BoardDao.insertUploadFile", param);
	}
	
	public int deleteFileInfo(Integer file_Gid, Integer file_Id)
	{
		Map param = new HashMap();
		param.put("file_Gid", file_Gid);
		param.put("file_Id", file_Id);
		return delete("BoardDao.deleteFileInfo", param);
	}
	
	public int deleteAllFileInfo(Integer file_Gid)
	{
		return delete("BoardDao.deleteAllFileInfo", file_Gid);
	}


	public Board selectFileInfo(Integer file_Gid, Integer file_Id)
	{
		Map param = new HashMap();
		param.put("file_Gid", file_Gid);
		param.put("file_Id", file_Id);
		return (Board)queryForObject("BoardDao.selectFileInfo", param);
	}*/
}
