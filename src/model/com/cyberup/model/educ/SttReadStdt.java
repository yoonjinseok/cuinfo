package com.cyberup.model.educ;

import com.cyberup.framework.model.PagingModel;

public class SttReadStdt extends PagingModel {

	private static final long serialVersionUID = 3718374141389207197L;
	/**
	 * 기   능 : 저원외 재학생 현황(정원외 학생현황)
	 * 
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */

	  
	private long ID = 0 ;
	private String sttUnivID = "";   //대학별 통계 자료아이디
	private String year = "";	//정원년도
	private String industry = "";	//산업체위탁생-재학
	private String soldier = "";	//군위탁생-재학
	private String alien = "";	//재외국민 및 외국인-재학
	private String gradeThree = "";	//3학년 학사 편입학-재학
	private String special = "";	//특수교욱대상자-재학
	private String change = "";	//외국나라이수생-재학
	private String nationalBasic = "";	//국민기초생활-재학
	private String other = "";	//기타-재학
	private String total = "";	//합계-재학
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getSttUnivID() {
		return sttUnivID;
	}
	public void setSttUnivID(String sttUnivID) {
		this.sttUnivID = sttUnivID;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getSoldier() {
		return soldier;
	}
	public void setSoldier(String soldier) {
		this.soldier = soldier;
	}
	public String getAlien() {
		return alien;
	}
	public void setAlien(String alien) {
		this.alien = alien;
	}
	public String getGradeThree() {
		return gradeThree;
	}
	public void setGradeThree(String gradeThree) {
		this.gradeThree = gradeThree;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getNationalBasic() {
		return nationalBasic;
	}
	public void setNationalBasic(String nationalBasic) {
		this.nationalBasic = nationalBasic;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	



	
	
}