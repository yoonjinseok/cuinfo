package com.cyberup.model.stats;

import java.sql.Date;
import com.cyberup.framework.model.PagingModel;

public class CourseStats extends PagingModel{
	

	private static final long serialVersionUID = 151239052403620602L;
	
	private int rank = 0;
	private String regDT = "" ;
	private String univName = "";
	private String univID = "";
	private String className = "";
	private String classID = "";
	private int regCnt = 0;
	private int serviceCnt = 0;
	private int noServiceCnt = 0;
	private double serviceRate = 0;
	private int serviceTotalCnt = 0;	
	private int noServiceTotalCnt = 0;
	private int regTotalCnt = 0;
	
	private String searchPublicFlag = ""; // 공개강의 여부
	private String searchTasterFlag = ""; //맛보기 강좌만(Y면 맛보기 강좌만 검색)
	private String searchPassFlag = "";  // 지난강의 포함 여부(Y면 포함)
	
	private String searchSDT = "";
	private String searchEDT = "";
	private String rdUniv = "";
	private String searchValue1 = "";
	private String rdDept = "";
	private String searchValue2 = "";
	private String sortString = "";
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getRegDT() {
		return regDT;
	}
	public void setRegDT(String regDT) {
		this.regDT = regDT;
	}
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public String getUnivID() {
		return univID;
	}
	public void setUnivID(String univID) {
		this.univID = univID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	
	
	public int getRegCnt() {
		return regCnt;
	}
	public void setRegCnt(int regCnt) {
		this.regCnt = regCnt;
	}
	public int getServiceCnt() {
		return serviceCnt;
	}
	public void setServiceCnt(int serviceCnt) {
		this.serviceCnt = serviceCnt;
	}
	public int getNoServiceCnt() {
		return noServiceCnt;
	}
	public void setNoServiceCnt(int noServiceCnt) {
		this.noServiceCnt = noServiceCnt;
	}
	public double getServiceRate() {
		return serviceRate;
	}
	public void setServiceRate(double serviceRate) {
		this.serviceRate = serviceRate;
	}
	public int getServiceTotalCnt() {
		return serviceTotalCnt;
	}
	public void setServiceTotalCnt(int serviceTotalCnt) {
		this.serviceTotalCnt = serviceTotalCnt;
	}
	public int getNoServiceTotalCnt() {
		return noServiceTotalCnt;
	}
	public void setNoServiceTotalCnt(int noServiceTotalCnt) {
		this.noServiceTotalCnt = noServiceTotalCnt;
	}
	
	public int getRegTotalCnt() {
		return regTotalCnt;
	}
	public void setRegTotalCnt(int regTotalCnt) {
		this.regTotalCnt = regTotalCnt;
	}
	public String getSearchPublicFlag() {
		return searchPublicFlag;
	}
	public void setSearchPublicFlag(String searchPublicFlag) {
		this.searchPublicFlag = searchPublicFlag;
	}
	public String getSearchTasterFlag() {
		return searchTasterFlag;
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
	public String getRdUniv() {
		return rdUniv;
	}
	public void setRdUniv(String rdUniv) {
		this.rdUniv = rdUniv;
	}
	public String getSearchValue1() {
		return searchValue1;
	}
	public void setSearchValue1(String searchValue1) {
		this.searchValue1 = searchValue1;
	}
	public String getRdDept() {
		return rdDept;
	}
	public void setRdDept(String rdDept) {
		this.rdDept = rdDept;
	}
	public String getSearchValue2() {
		return searchValue2;
	}
	public void setSearchValue2(String searchValue2) {
		this.searchValue2 = searchValue2;
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
