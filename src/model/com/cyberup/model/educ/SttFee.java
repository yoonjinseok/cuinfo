package com.cyberup.model.educ;

import com.cyberup.framework.model.PagingModel;

public class SttFee extends PagingModel {

	private static final long serialVersionUID = 3718374141389207197L;
	/**
	 * 기   능 : 입학금 및 수업료 현황(입학금 및 수업료 현황)
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */

	  
	private long ID = 0 ;
	private String sttUnivID = "";   //대학별 통계 자료아이디
	private String applicationFee = "";	//전형료
	private String entranceFre = "";	//입학금
	private String credit = "";	//학점당
	private String trainingFee = "";	//실습비
	private String other = "";	//기타
	private String tuition = "";	//등록급
	private String hike = "";	//인상률
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
	public String getApplicationFee() {
		return applicationFee;
	}
	public void setApplicationFee(String applicationFee) {
		this.applicationFee = applicationFee;
	}
	public String getEntranceFre() {
		return entranceFre;
	}
	public void setEntranceFre(String entranceFre) {
		this.entranceFre = entranceFre;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTrainingFee() {
		return trainingFee;
	}
	public void setTrainingFee(String trainingFee) {
		this.trainingFee = trainingFee;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	public String getHike() {
		return hike;
	}
	public void setHike(String hike) {
		this.hike = hike;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	  
	



	
	
}