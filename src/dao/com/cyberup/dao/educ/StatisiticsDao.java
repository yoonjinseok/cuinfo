package com.cyberup.dao.educ;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.educ.Statisitics;
import com.cyberup.util.DateFormatter;

@Repository
public class StatisiticsDao extends BaseDAO {
	
	public Statisitics selectInfo(long statisiticsID)
	{
		return (Statisitics)queryForObject("StatisiticsDao.selectInfo", statisiticsID);
	}
	
	public Integer isUpCheck(Statisitics statisitics)
	{
		return (Integer)queryForObject("StatisiticsDao.isUpCheck", statisitics);
	}

	public int deleteInfo(long statisiticsID)
	{
		return delete("StatisiticsDao.deleteInfo", statisiticsID);
	}

	public void insertInfo(Statisitics statisitics)
	{
		insert("StatisiticsDao.insertInfo", statisitics);
	}		

	public List<Statisitics> selectList(Integer showCnt, Integer currPage,String termState, String sttName, Date regDate, String gatherState)
	{
		Map param = new HashMap();
		String regDateStr = "";
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("termState", termState);
		param.put("sttName", sttName);
		param.put("regDate", new DateFormatter("yyyy-MM-dd").print(regDate, Locale.getDefault()));
		param.put("gatherState", gatherState);

		return queryForList("StatisiticsDao.selectList", param);
	}

	public int updateInfo(Statisitics statisitics)
	{
		return update("StatisiticsDao.updateInfo", statisitics);
	}
	
	public int initFileBoard(Integer fileGid)
	{
		return update("StatisiticsDao.initFileBoard", fileGid);
	}
	
	
	public int upGatherStateN(long sttID) {
		return update("StatisiticsDao.upGatherStateN", sttID);
	}
	
	public List<Map> seleStatisticsctList(String gubunNm, String sttYear, String sttMonth, String gubunID)
	{
		Map param = new HashMap();
		String regDateStr = "";
		param.put("gubunNm", gubunNm);
		param.put("sttYear", sttYear);
		param.put("sttMonth", sttMonth);
		param.put("gubunID", gubunID);
		param.put("gubun1", 1);
		
		return queryForList("StatisiticsDao.seleStatisticsctList_" + gubunNm, param);
	}
	
	public List<Map> seleStatisticsctYearList()
	{
		return queryForList("StatisiticsDao.seleStatisticsctYearList");
	}
	/*
	 * 파일 데이터 입력 처리  
	 
	public int selectSEQ_FILE_GID()
	{
		return (Integer) queryForObject("StatisiticsDao.selectSEQ_FILE_GID");
	}
	
	
	public  List<Statisitics> selectFileList(Integer upfileGid)
	{
		return queryForList("StatisiticsDao.selectFileList", upfileGid);
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
		insert("StatisiticsDao.insertUploadFile", param);
	}
	
	public int deleteFileInfo(Integer file_Gid, Integer file_Id)
	{
		Map param = new HashMap();
		param.put("file_Gid", file_Gid);
		param.put("file_Id", file_Id);
		return delete("StatisiticsDao.deleteFileInfo", param);
	}
	
	public int deleteAllFileInfo(Integer file_Gid)
	{
		return delete("StatisiticsDao.deleteAllFileInfo", file_Gid);
	}


	public Statisitics selectFileInfo(Integer file_Gid, Integer file_Id)
	{
		Map param = new HashMap();
		param.put("file_Gid", file_Gid);
		param.put("file_Id", file_Id);
		return (Statisitics)queryForObject("StatisiticsDao.selectFileInfo", param);
	}*/
}
