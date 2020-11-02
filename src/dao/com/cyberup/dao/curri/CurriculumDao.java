package com.cyberup.dao.curri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.curri.Curriculum;
import com.cyberup.model.home.Board;

@Repository
public class CurriculumDao extends BaseDAO {
	
	public List selectDeptList(Curriculum curriculum){
		return queryForList("CurriculumDao.selectDeptList",curriculum);
	}
	
	public List selectDeptDetailList(Curriculum curriculum){
		return queryForList("CurriculumDao.selectDeptDetailList",curriculum);
	}
	
	public List selectCurriculumList(Curriculum curriculum){
		
		//커리큘럼 리스트를 가져오도록 변경 필요 [변경시 주석 삭제]
		return queryForList("CurriculumDao.selectCurriculumList",curriculum);
	}
	
	public List selectClassifyList(){
		return queryForList("CurriculumDao.selectClassifyList");
	}
	
	public List deptUnivList(Curriculum curriculum){
		return queryForList("CurriculumDao.deptUnivList");
	}
	
	public List selectUnivList(Curriculum curriculum){
		return queryForList("CurriculumDao.selectUnivList",curriculum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Board selectInfo(long boardID)
	{
		return (Board)queryForObject("CurriculumDao.selectInfo", boardID);
	}

	public int deleteInfo(long boardID)
	{
		return delete("CurriculumDao.deleteInfo", boardID);
	}

	public void insertInfo(Board board)
	{
		insert("CurriculumDao.insertInfo", board);
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

		return queryForList("CurriculumDao.selectList", param);
	}

	public int updateInfo(Board board)
	{
		return update("CurriculumDao.updateInfo", board);
	}
	
	public int updateHitsCount(Board board)
	{
		return update("CurriculumDao.updateHitsCount", board);
	}
	
	public int initFileBoard(Integer fileGid)
	{
		return update("CurriculumDao.initFileBoard", fileGid);
	}
	
	/*
	 * 파일 데이터 입력 처리  
	 
	public int selectSEQ_FILE_GID()
	{
		return (Integer) queryForObject("CurriculumDao.selectSEQ_FILE_GID");
	}
	
	
	public  List<Board> selectFileList(Integer upfileGid)
	{
		return queryForList("CurriculumDao.selectFileList", upfileGid);
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
		insert("CurriculumDao.insertUploadFile", param);
	}
	
	public int deleteFileInfo(Integer file_Gid, Integer file_Id)
	{
		Map param = new HashMap();
		param.put("file_Gid", file_Gid);
		param.put("file_Id", file_Id);
		return delete("CurriculumDao.deleteFileInfo", param);
	}
	
	public int deleteAllFileInfo(Integer file_Gid)
	{
		return delete("CurriculumDao.deleteAllFileInfo", file_Gid);
	}


	public Board selectFileInfo(Integer file_Gid, Integer file_Id)
	{
		Map param = new HashMap();
		param.put("file_Gid", file_Gid);
		param.put("file_Id", file_Id);
		return (Board)queryForObject("CurriculumDao.selectFileInfo", param);
	}*/
}
