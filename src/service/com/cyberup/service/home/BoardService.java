package com.cyberup.service.home;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.model.admin.Admin;

import com.cyberup.model.home.Board;
import com.cyberup.dao.home.BoardDao;

@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	public Board selectInfo(long boardID) {
		return this.boardDao.selectInfo(boardID);
	}
	
	public List<Board> selectList(Integer showCnt, Integer currPage,String gubunID, String title, String boardContent, String regID, String regName)
	{
		return this.boardDao.selectList(showCnt, currPage, gubunID, title, boardContent,regID, regName );
	}

	public int deleteInfo(long boardID) {
		return this.boardDao.deleteInfo(boardID);
	}
	public void insertInfo(Board board) {
		this.boardDao.insertInfo(board);
	}			
	public int updateInfo(Board board) {
		return this.boardDao.updateInfo(board);
	}
	public int updateHitsCount(Board board) {
		return this.boardDao.updateHitsCount(board);
	}
	
	
	public int initFileBoard(Integer fileGid) {
		return this.boardDao.initFileBoard(fileGid);
	}

	/*파일
	public int selectSEQ_FILE_GID()
	{
		return this.boardDao.selectSEQ_FILE_GID();
	}	
	public void insertUploadFile(Integer file_Gid, String source_file, String file_name, String file_size, String file_path, String reg_id)
	{
		this.boardDao.insertUploadFile(file_Gid, source_file, file_name, file_size, file_path, reg_id);
	}
	
	public List<Board> selectFileList(Integer upfileGid)
	{
		return this.boardDao.selectFileList(upfileGid);
	}

	public int deleteFileInfo(Integer file_Gid, Integer file_Id)
	{
		return this.boardDao.deleteFileInfo(file_Gid,file_Id);
	}
	public int deleteAllFileInfo(Integer file_Gid)
	{
		return this.boardDao.deleteAllFileInfo(file_Gid);
	}
	public Board selectFileInfo(Integer file_Gid, Integer file_Id)
	{
		return this.boardDao.selectFileInfo(file_Gid,file_Id);
	}*/
}
