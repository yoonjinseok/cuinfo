package com.cyberup.service.curri;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.curri.CurriculumDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.curri.Curriculum;

import com.cyberup.model.home.Board;

@Service
@Transactional
public class CurriculumService {
	@Autowired
	private CurriculumDao curriculumDao;

	
	
	public List selectDeptList(Curriculum curriculum) {
		return this.curriculumDao.selectDeptList(curriculum);
	}
	
	public List selectDeptDetailList(Curriculum curriculum) {
		return this.curriculumDao.selectDeptDetailList(curriculum);
	}
	
	public List selectCurriculumList(Curriculum curriculum) {
		return this.curriculumDao.selectCurriculumList(curriculum);
	}
	
	public List selectClassifyList() {
		return this.curriculumDao.selectClassifyList();
	}
	
	public List deptUnivList(Curriculum curriculum) {
		return this.curriculumDao.deptUnivList(curriculum);
	}
	
	
	public List selectUnivList(Curriculum curriculum) {
		return this.curriculumDao.selectUnivList(curriculum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Board selectInfo(long boardID) {
		return this.curriculumDao.selectInfo(boardID);
	}
	
	public List<Board> selectList(Integer showCnt, Integer currPage,String gubunID, String title, String boardContent, String regID, String regName)
	{
		return this.curriculumDao.selectList(showCnt, currPage, gubunID, title, boardContent,regID, regName );
	}

	public int deleteInfo(long boardID) {
		return this.curriculumDao.deleteInfo(boardID);
	}
	public void insertInfo(Board board) {
		this.curriculumDao.insertInfo(board);
	}			
	public int updateInfo(Board board) {
		return this.curriculumDao.updateInfo(board);
	}
	public int updateHitsCount(Board board) {
		return this.curriculumDao.updateHitsCount(board);
	}
	
	
	public int initFileBoard(Integer fileGid) {
		return this.curriculumDao.initFileBoard(fileGid);
	}

	/*파일
	public int selectSEQ_FILE_GID()
	{
		return this.curriculumDao.selectSEQ_FILE_GID();
	}	
	public void insertUploadFile(Integer file_Gid, String source_file, String file_name, String file_size, String file_path, String reg_id)
	{
		this.curriculumDao.insertUploadFile(file_Gid, source_file, file_name, file_size, file_path, reg_id);
	}
	
	public List<Board> selectFileList(Integer upfileGid)
	{
		return this.curriculumDao.selectFileList(upfileGid);
	}

	public int deleteFileInfo(Integer file_Gid, Integer file_Id)
	{
		return this.curriculumDao.deleteFileInfo(file_Gid,file_Id);
	}
	public int deleteAllFileInfo(Integer file_Gid)
	{
		return this.curriculumDao.deleteAllFileInfo(file_Gid);
	}
	public Board selectFileInfo(Integer file_Gid, Integer file_Id)
	{
		return this.curriculumDao.selectFileInfo(file_Gid,file_Id);
	}*/
}
