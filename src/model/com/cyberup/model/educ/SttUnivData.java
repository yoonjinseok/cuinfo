package com.cyberup.model.educ;

import com.cyberup.framework.model.PagingModel;

public class SttUnivData extends PagingModel {

	private static final long serialVersionUID = 3718374141389207197L;
	/**
	 * 기   능 : 대학별 현황표(일반현황)
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */
	  
	private long ID = 0 ;
	private String sttUnivID = "";   //대학아이디
	private String studentInCnt = "";	//입학정원수
	private String formationCnt  = ""; //편제정원수
	private String instMainagent = ""; //설치주체
	private String universityName = ""; //대학명
	private String chariman = ""; //이사장
	private String principal = ""; //총장---
	private String firstOpen = ""; //최초개교
	private String supOpen = ""; //개교--
	private String sameCorp = ""; //비고
	private String sttUnivId = ""; //대학별 통계 자료아이디
	
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
	public String getStudentInCnt() {
		return studentInCnt;
	}
	public void setStudentInCnt(String studentInCnt) {
		this.studentInCnt = studentInCnt;
	}
	public String getFormationCnt() {
		return formationCnt;
	}
	public void setFormationCnt(String formationCnt) {
		this.formationCnt = formationCnt;
	}
	public String getInstMainagent() {
		return instMainagent;
	}
	public void setInstMainagent(String instMainagent) {
		this.instMainagent = instMainagent;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getChariman() {
		return chariman;
	}
	public void setChariman(String chariman) {
		this.chariman = chariman;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getFirstOpen() {
		return firstOpen;
	}
	public void setFirstOpen(String firstOpen) {
		this.firstOpen = firstOpen;
	}
	public String getSupOpen() {
		return supOpen;
	}
	public void setSupOpen(String supOpen) {
		this.supOpen = supOpen;
	}
	public String getSameCorp() {
		return sameCorp;
	}
	public void setSameCorp(String sameCorp) {
		this.sameCorp = sameCorp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSttUnivId() {
		return sttUnivId;
	}
	public void setSttUnivId(String sttUnivId) {
		this.sttUnivId = sttUnivId;
	}
	 
	



	
	
}