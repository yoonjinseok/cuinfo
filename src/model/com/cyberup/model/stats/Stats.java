package com.cyberup.model.stats;

import org.apache.commons.lang.StringUtils;

import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.course.CourseType;

public class Stats extends PagingModel {

	private static final long serialVersionUID = 465169783029958656L;
	private String regDate = ""; 
	private Integer totalCnt = 0; 
	private Integer serviceCnt = 0; 
	private Integer vodCnt = 0; 
	private Integer fileCnt = 0;
	
	private String startDate = "";	//수집시작일 
	private String endDate = "";	//수집종료일
	private String univName = "";	//학교명
	private String deptName = "";	//학과명
	private String type = "";		//강의유형
	private String publicYN = "";	//공개범위
	private String termYear = "";	//개설년도
	
	private String svcStats = "";
	private String termYearStart = "";
	private String termYearEnd = "";
	private String svcStatus = "";
	private String grants = "";
	private Integer pageGubn = 1;	//년도별, 년월별 구분값
	
	private String universityName = "";
	private String departmentName = "";
	
	private String rowName = "";
	
	private String rights = "";
	
	public String getRights() {
		return rights;
	}
	public String getRightsName()
	{
		try {
			if(!StringUtils.isEmpty(this.rights))
				//return RightType.parse(this.rights).getName();
				return "";
			else
				return "";
		} catch (Exception e) {
			return this.rights;
		}
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getRowName() {
		return rowName;
	}
	public void setRowName(String rowName) {
		this.rowName = rowName;
	}
	
	public Integer getPageGubn() {
		return pageGubn;
	}
	public void setPageGubn(Integer pageGubn) {
		if(pageGubn != null)
			this.pageGubn = pageGubn;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getGrants() {
		return grants;
	}
	public String getGrantsName()
	{
		try {
			if(!StringUtils.isEmpty(this.grants))
				//return GrantType.parse(this.grants).getName();
				return "";
			else
				return "";
		} catch (Exception e) {
			return this.grants;
		}
	}
	public void setGrants(String grants) {
		this.grants = grants;
	}
	public String getSvcStatus() {
		return svcStatus;
	}
	public void setSvcStatus(String svcStatus) {
		this.svcStatus = svcStatus;
	}
	public String getTermYearStart() {
		return termYearStart;
	}
	public void setTermYearStart(String termYearStart) {
		this.termYearStart = termYearStart;
	}
	public String getTermYearEnd() {
		return termYearEnd;
	}
	public void setTermYearEnd(String termYearEnd) {
		this.termYearEnd = termYearEnd;
	}
	public String getSvcStats() {
		return svcStats;
	}
	public void setSvcStats(String svcStats) {
		this.svcStats = svcStats;
	}
	public String getTermYear() {
		return termYear;
	}
	public void setTermYear(String termYear) {
		this.termYear = termYear;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getType() {
		return type;
	}
	public String getTypeName()
	{
		try {
			if(!StringUtils.isEmpty(this.type))
				return CourseType.parse(this.type).getName();
			else
				return "";
		} catch (Exception e) {
			return this.type;
		}
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPublicYN() {
		return publicYN;
	}
	public String getPublicName()
	{
		try {
			if(!StringUtils.isEmpty(this.publicYN))
				//return GrantType.parse(this.publicYN).getName();
				return "";
			else
				return "";
		} catch (Exception e) {
			return this.publicYN;
		}
	}
	public void setPublicYN(String publicYN) {
		this.publicYN = publicYN;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Integer getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(Integer totalCnt) {
		if(totalCnt != null)
			this.totalCnt = totalCnt;
	}
	public Integer getServiceCnt() {
		return serviceCnt;
	}
	public void setServiceCnt(Integer serviceCnt) {
		if(serviceCnt != null)
			this.serviceCnt = serviceCnt;
	}
	public Integer getVodCnt() {
		return vodCnt;
	}
	public void setVodCnt(Integer vodCnt) {
		if(vodCnt != null)
			this.vodCnt = vodCnt;
	}
	public Integer getFileCnt() {
		return fileCnt;
	}
	public void setFileCnt(Integer fileCnt) {
		if(fileCnt != null)
			this.fileCnt = fileCnt;
	}
	
	
	

}
