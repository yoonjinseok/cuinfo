package com.cyberup.model.stats;

import com.cyberup.framework.model.PagingModel;

public class ServiceStats extends PagingModel {
	

	private static final long serialVersionUID = -7835358937909400369L;
	
	private int serviceRank=0;
	private String courseName = "";
	private String univName = "";
	private String deptName = "";
	private String className = "";
	
	private int hitsTotalCnt = 0;
	private int hitsCnt = 0;
	private double hitsRate = 0;
	
	private String searchPublicFlag = ""; // 공개강의 여부
	private String searchTasterFlag = ""; //맛보기 강좌만(Y면 맛보기 강좌만 검색)
	private String searchPassFlag = "";  // 지난강의 포함 여부(Y면 포함)
	
	private String searchSDT = "";
	private String searchEDT = "";
	
	private String searchUnivName = "";
	private String searchUnivID = "";
	private String searchDeptName = "";
	private String searchDeptID = "";

	private String sortString = "";
	
	public int getServiceRank() {
		return serviceRank;
	}
	public void setServiceRank(int serviceRank) {
		this.serviceRank = serviceRank;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getHitsTotalCnt() {
		return hitsTotalCnt;
	}
	public void setHitsTotalCnt(int hitsTotalCnt) {
		this.hitsTotalCnt = hitsTotalCnt;
	}
	public int getHitsCnt() {
		return hitsCnt;
	}
	public void setHitsCnt(int hitsCnt) {
		this.hitsCnt = hitsCnt;
	}
	public double getHitsRate() {
		return hitsRate;
	}
	public void setHitsRate(double hitsRate) {
		this.hitsRate = hitsRate;
	}
	public String getSearchTasterFlag() {
		return searchTasterFlag;
	}	
	public String getSearchPublicFlag() {
		return searchPublicFlag;
	}
	public void setSearchPublicFlag(String searchPublicFlag) {
		this.searchPublicFlag = searchPublicFlag;
	}

	public void setSearchTasterFlag(String searchTasterFlag) {
		this.searchTasterFlag = searchTasterFlag;
	}
	public String getSearchPassFlag() {
		return searchPassFlag;
	}
	public void setSearchPassFlag(String searchPassFlag) {
		this.searchPassFlag = searchPassFlag;
	}
	public String getSearchSDT() {
		return searchSDT;
	}
	public void setSearchSDT(String searchSDT) {
		this.searchSDT = searchSDT;
	}
	public String getSearchEDT() {
		return searchEDT;
	}
	public void setSearchEDT(String searchEDT) {
		this.searchEDT = searchEDT;
	}
	public String getSearchUnivName() {
		return searchUnivName;
	}
	public void setSearchUnivName(String searchUnivName) {
		this.searchUnivName = searchUnivName;
	}
	public String getSearchUnivID() {
		return searchUnivID;
	}
	public void setSearchUnivID(String searchUnivID) {
		this.searchUnivID = searchUnivID;
	}
	public String getSearchDeptName() {
		return searchDeptName;
	}
	public void setSearchDeptName(String searchDeptName) {
		this.searchDeptName = searchDeptName;
	}
	public String getSearchDeptID() {
		return searchDeptID;
	}
	public void setSearchDeptID(String searchDeptID) {
		this.searchDeptID = searchDeptID;
	}
	
	public String getSortString() {
		return sortString;
	}
	public void setSortString(String sortString) {
		this.sortString = sortString;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
