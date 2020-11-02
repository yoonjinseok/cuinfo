package com.cyberup.model.course;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class Schedule extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1095410570254510196L;
	
	private Integer scheduleId = 0;
	private String orgId = "";
	private Integer universityId = 0;
	private String universityName = "";
	private Date startDate;
	private Date harvestDate;
	private Date endDate;
	private String scheduleType = "";
	private Integer intervals = 0;
	private Integer runHour = 0;
	private String status = "";
	private String manualYn = "N";
	private String runningStatus = RunningStatus.READY.getValue();
	private String scheduleRegister = "";
	private Date scheduleRegdate;
	private String scheduleModifier = "";
	private Date scheduleModdate;
	
	public Date getHarvestSdate()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(harvestDate);
		cal.add(Calendar.DAY_OF_MONTH, -intervals);
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
	public Date getHarvestEdate()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(harvestDate);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return cal.getTime();
	}

	public Integer getScheduleId(){
		return this.scheduleId;
	}
	public void setScheduleId(Integer scheduleId){
		if(scheduleId != null)
			this.scheduleId = scheduleId;
	}
	public String getOrgId(){
		return this.orgId;
	}
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	public Integer getUniversityId(){
		return this.universityId;
	}
	public void setUniversityId(Integer universityId){
		if(universityId != null)
			this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Date getStartDate(){
		return this.startDate;
	}
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	public Date getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(Date harvestDate) {
		this.harvestDate = harvestDate;
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
		if(this.scheduleType != null && !this.scheduleType.equals(""))
			return ScheduleType.parse(this.scheduleType).getName();
		else
			return "";
	}
	public void setScheduleType(String scheduleType){
		this.scheduleType = scheduleType;
	}
	public Integer getIntervals(){
		return this.intervals;
	}
	public void setIntervals(Integer intervals){
		if(intervals != null)
			this.intervals = intervals;
	}
	public Integer getRunHour(){
		return this.runHour;
	}
	public void setRunHour(Integer runHour){
		if(runHour != null)
			this.runHour = runHour;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getManualYn() {
		return manualYn;
	}

	public void setManualYn(String manualYn) {
		this.manualYn = manualYn;
	}

	public String getRunningStatus() {
		return runningStatus;
	}
	public String getRunningStatusNm()
	{
		if(StringUtils.isEmpty(this.runningStatus))
			return "";
		else
			return RunningStatus.parse(this.runningStatus).getName();
	}

	public void setRunningStatus(String runningStatus) {
		this.runningStatus = runningStatus;
	}

	public String getScheduleRegister(){
		return this.scheduleRegister;
	}
	public void setScheduleRegister(String scheduleRegister){
		this.scheduleRegister = scheduleRegister;
	}
	public Date getScheduleRegdate(){
		return this.scheduleRegdate;
	}
	public void setScheduleRegdate(Date scheduleRegdate){
		this.scheduleRegdate = scheduleRegdate;
	}
	public String getScheduleModifier(){
		return this.scheduleModifier;
	}
	public void setScheduleModifier(String scheduleModifier){
		this.scheduleModifier = scheduleModifier;
	}
	public Date getScheduleModdate(){
		return this.scheduleModdate;
	}
	public void setScheduleModdate(Date scheduleModdate){
		this.scheduleModdate = scheduleModdate;
	}
}
