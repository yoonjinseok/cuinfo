package com.cyberup.model.educ;

import com.cyberup.framework.model.PagingModel;

public class SttPartTime extends PagingModel {

	private static final long serialVersionUID = 3718374141389207197L;
	/**
	 * 기   능 : 시간제 등록생 모집결과 (모집단위별 시간제 등록생 현황)
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */

	  
	private long ID = 0 ;
	private String sttUnivID = "";   //대학별 통계 자료아이디
	private String recruitmentCnt = "";	//모집인원
	private String registerCnt = "";	//등록자수
	private String registerRate = "";	//등록율
	private String creditCost = "";	//학점당수업료
	private String lectureCnt = "";	//강좌수
	private String applicationCnt = "";	//수강신청자수
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
	public String getRecruitmentCnt() {
		return recruitmentCnt;
	}
	public void setRecruitmentCnt(String recruitmentCnt) {
		this.recruitmentCnt = recruitmentCnt;
	}
	public String getRegisterCnt() {
		return registerCnt;
	}
	public void setRegisterCnt(String registerCnt) {
		this.registerCnt = registerCnt;
	}
	public String getRegisterRate() {
		return registerRate;
	}
	public void setRegisterRate(String registerRate) {
		this.registerRate = registerRate;
	}
	public String getCreditCost() {
		return creditCost;
	}
	public void setCreditCost(String creditCost) {
		this.creditCost = creditCost;
	}
	public String getLectureCnt() {
		return lectureCnt;
	}
	public void setLectureCnt(String lectureCnt) {
		this.lectureCnt = lectureCnt;
	}
	public String getApplicationCnt() {
		return applicationCnt;
	}
	public void setApplicationCnt(String applicationCnt) {
		this.applicationCnt = applicationCnt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 
	



	
	
}