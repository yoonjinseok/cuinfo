package com.cyberup.model.educ;

import com.cyberup.framework.model.PagingModel;

public class SttAge extends PagingModel {

	private static final long serialVersionUID = -7887388214907401716L;
	/**
	 * 기   능 : 연령별 등록생 비율(연령별 성별별 분포현황)
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */	
	private long ID = 0 ;
	private String sttUnivID = "";   //대학별 통계 자료아이디
	private String age10 = "";	//10대
	private String age20Initial = "";	//20대초
	private String age20After = "";	//20대후
	private String age30 = "";	//30대
	private String age40 = "";	//40대
	private String age50 = "";	//50대
	private String age60 = "";	//60대
	private String ageTotal = "";	//합계
	private String sexG = "";	//성별 여
	private String sexM = "";	//성별 남
	private String univName = ""; //학교명
	private String sttYear = ""; //수집년도
	
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
	public String getAge10() {
		return age10;
	}
	public void setAge10(String age10) {
		this.age10 = age10;
	}
	public String getAge20Initial() {
		return age20Initial;
	}
	public void setAge20Initial(String age20Initial) {
		this.age20Initial = age20Initial;
	}
	public String getAge20After() {
		return age20After;
	}
	public void setAge20After(String age20After) {
		this.age20After = age20After;
	}
	public String getAge30() {
		return age30;
	}
	public void setAge30(String age30) {
		this.age30 = age30;
	}
	public String getAge40() {
		return age40;
	}
	public void setAge40(String age40) {
		this.age40 = age40;
	}
	public String getAge50() {
		return age50;
	}
	public void setAge50(String age50) {
		this.age50 = age50;
	}
	public String getAge60() {
		return age60;
	}
	public void setAge60(String age60) {
		this.age60 = age60;
	}
	public String getAgeTotal() {
		return ageTotal;
	}
	public void setAgeTotal(String ageTotal) {
		this.ageTotal = ageTotal;
	}
	public String getSexG() {
		return sexG;
	}
	public void setSexG(String sexG) {
		this.sexG = sexG;
	}
	public String getSexM() {
		return sexM;
	}
	public void setSexM(String sexM) {
		this.sexM = sexM;
	}
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public String getSttYear() {
		return sttYear;
	}
	public void setSttYear(String sttYear) {
		this.sttYear = sttYear;
	}


	
	 
	



	
	
}