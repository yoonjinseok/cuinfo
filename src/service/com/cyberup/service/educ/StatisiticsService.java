package com.cyberup.service.educ;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.educ.StatisiticsDao;
import com.cyberup.model.educ.Statisitics;

@Service
@Transactional
public class StatisiticsService {
	@Autowired
	private StatisiticsDao statisiticsDao;

	public Statisitics selectInfo(long statisiticsID) {
		return this.statisiticsDao.selectInfo(statisiticsID);
	}
	
	public Integer isUpCheck(Statisitics statisitics) {
		return this.statisiticsDao.isUpCheck(statisitics);
	}
	
	public List<Statisitics> selectList(Integer showCnt, Integer currPage, String termState, String sttName, Date regDate, String gatherState)
	{
		return this.statisiticsDao.selectList(showCnt, currPage, termState, sttName, regDate, gatherState );
	}

	public int deleteInfo(long statisiticsID) {
		return this.statisiticsDao.deleteInfo(statisiticsID);
	}
	public void insertInfo(Statisitics statisitics) {
		this.statisiticsDao.insertInfo(statisitics);
	}			
	public int updateInfo(Statisitics statisitics) {
		return this.statisiticsDao.updateInfo(statisitics);
	}
	
	public int initFileBoard(Integer fileGid) {
		return this.statisiticsDao.initFileBoard(fileGid);
	}
	
	public int upGatherStateN(long sttID) {
		return this.statisiticsDao.upGatherStateN(sttID);
	}

	public List<Map> seleStatisticsctList(String gubunNm, String sttYear, String sttMonth, String gubunID)
	{
		return this.statisiticsDao.seleStatisticsctList(gubunNm, sttYear, sttMonth, gubunID);
	}
	
	public List<Map> seleStatisticsctYearList()
	{
		return this.statisiticsDao.seleStatisticsctYearList();
	}
}
