package com.cyberup.model.course;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class History extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7471514244334701328L;
	
	private Integer historyId = 0;
	private Integer scheduleId = 0;
	private Date startDate;
	private Date endDate;
	private String scheduleType = "";
	private String scheduleSdate = "";
	private String scheduleEdate = "";
	private Integer collectCnt = 0;
	private String result = "";
	private String errorReason = "";
	private Date historyRegdate;
	private Date historyModdate;

	public Integer getHistoryId(){
		return this.historyId;
	}
	public void setHistoryId(Integer historyId){
		if(historyId != null)
			this.historyId = historyId;
	}
	public Integer getScheduleId(){
		return this.scheduleId;
	}
	public void setScheduleId(Integer scheduleId){
		if(scheduleId != null)
			this.scheduleId = scheduleId;
	}
	public Date getStartDate(){
		return this.startDate;
	}
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	public Date getEndDate(){
		return this.endDate;
	}
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
	public String getScheduleType(){
		return this.scheduleType;
	}
	public String getScheduleTypeName()
	{
		if(this.scheduleType != null && !"".equals(this.scheduleType))
		{
			return ScheduleType.parse(this.scheduleType).getName();
		}
		else
			return "";
	}
	public void setScheduleType(String scheduleType){
		this.scheduleType = scheduleType;
	}
	public String getScheduleSdate(){
		return this.scheduleSdate;
	}
	public void setScheduleSdate(String scheduleSdate){
		this.scheduleSdate = scheduleSdate;
	}
	public String getScheduleEdate(){
		return this.scheduleEdate;
	}
	public void setScheduleEdate(String scheduleEdate){
		this.scheduleEdate = scheduleEdate;
	}
	public Integer getCollectCnt(){
		return this.collectCnt;
	}
	public void setCollectCnt(Integer collectCnt){
		if(collectCnt != null)
			this.collectCnt = collectCnt;
	}
	public String getResult(){
		return this.result;
	}
	public String getResultName()
	{
		if(this.result != null && !"".equals(this.result))
			return HistoryResult.parse(this.result).getName();
		else
			return "수집중";
	}
	public void setResult(String result){
		this.result = result;
	}
	public String getErrorReason(){
		return this.errorReason;
	}
	public void setErrorReason(String errorReason){
		this.errorReason = errorReason;
	}
	public Date getHistoryRegdate(){
		return this.historyRegdate;
	}
	public void setHistoryRegdate(Date historyRegdate){
		this.historyRegdate = historyRegdate;
	}
	public Date getHistoryModdate(){
		return this.historyModdate;
	}
	public void setHistoryModdate(Date historyModdate){
		this.historyModdate = historyModdate;
	}
}
