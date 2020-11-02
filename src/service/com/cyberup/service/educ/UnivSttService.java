package com.cyberup.service.educ;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.cyberup.dao.educ.UnivSttDao;
import com.cyberup.model.educ.UnivStt;
import com.cyberup.model.home.FileUpload;

@Service
@Transactional
public class UnivSttService {
	@Autowired
	private UnivSttDao univSttDao;

	public UnivStt selectInfo(UnivStt univSttParm) {
		return this.univSttDao.selectInfo(univSttParm);
	}
	
	public List<UnivStt> selectList(Integer showCnt, Integer currPage, String termState, String sttName, Date sttRegDate, String putState, Integer universityID)
	{
		return this.univSttDao.selectList(showCnt, currPage, termState, sttName, sttRegDate, putState, universityID );
	}
	
	public int selectSttFileCnt(Integer universityID)
	{
		return this.univSttDao.selectSttFileCnt(universityID );
	}

	public int deleteInfo(long univSttID) {
		return this.univSttDao.deleteInfo(univSttID);
	}
	public void insertInfo(UnivStt univStt) {
		this.univSttDao.insertInfo(univStt);
	}			
	public int updateInfo(UnivStt univStt) {
		return this.univSttDao.updateInfo(univStt);
	}
	
	public int updateFailInfo(UnivStt univStt) {
		return this.univSttDao.updateFailInfo(univStt);
	}
	public int upUploadSt(long sttUnivID) {
		return this.univSttDao.upUploadSt(sttUnivID);
	}
	
	public int initFileBoard(Integer fileGid) {
		return this.univSttDao.initFileBoard(fileGid);
	}

	public List<UnivStt> selectUnivList(Integer gubunId, long sttID)
	{
		return this.univSttDao.selectUnivList(gubunId, sttID);
	}
	
	public int upPutState(String sstUnivIDs) {
		return this.univSttDao.upPutState(sstUnivIDs);
	}
	
	public List<FileUpload> selUnivDown(String sstUnivIDs, String sttID) 
	{
		return this.univSttDao.selUnivDown(sstUnivIDs, sttID);
	}
	/************** univ_stt_id seq 번호를 가져옴 **************/
	public Integer selectSEQ_STT_UNIVERSITY(){
		return univSttDao.selectSEQ_STT_UNIVERSITY();
	}
	
	public int updateSttGatherStateY(String sttID) {
		return this.univSttDao.updateSttGatherStateY(sttID);
	}
	
	
	public String excelUpload(String fileUrl, long sttUnivID, ModelMap modelMap, String forNum) {
		
		return this.univSttDao.excelUpload(fileUrl, sttUnivID, modelMap, forNum);
	}
	
	public List<FileUpload> selSttFileDown(String fileGid) {
		
		return this.univSttDao.selSttFileDown(fileGid);
	}
	/*파일
	public int selectSEQ_FILE_GID()
	{
		return this.univSttDao.selectSEQ_FILE_GID();
	}	
	public void insertUploadFile(Integer file_Gid, String source_file, String file_name, String file_size, String file_path, String reg_id)
	{
		this.univSttDao.insertUploadFile(file_Gid, source_file, file_name, file_size, file_path, reg_id);
	}
	
	public List<UnivSttDao> selectFileList(Integer upfileGid)
	{
		return this.univSttDao.selectFileList(upfileGid);
	}

	public int deleteFileInfo(Integer file_Gid, Integer file_Id)
	{
		return this.univSttDao.deleteFileInfo(file_Gid,file_Id);
	}
	public int deleteAllFileInfo(Integer file_Gid)
	{
		return this.univSttDao.deleteAllFileInfo(file_Gid);
	}
	public UnivSttDao selectFileInfo(Integer file_Gid, Integer file_Id)
	{
		return this.univSttDao.selectFileInfo(file_Gid,file_Id);
	}*/
}
