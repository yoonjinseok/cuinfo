package com.cyberup.model.educ;

import com.cyberup.framework.model.PagingModel;

public class SttTeacherData extends PagingModel {

	private static final long serialVersionUID = 3718374141389207197L;
	/**
	 * 기   능 : 재학생수 현황 (전임교원 확보 현황)
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */

	  
	private long ID = 0 ;
	private String sttUnivID = "";   //대학별 통계 자료아이디
	private String studentInCnt = "";	//정원내학생수
	private String studentOutCnt = "";	//정원외학생수
	private String studentHourCnt = "";	//시간제등록생수
	private String studentCollegeCnt = "";	//대학원 학생정원
	private String sttTotalCnt = "";	//합계
	
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
	public String getStudentOutCnt() {
		return studentOutCnt;
	}
	public void setStudentOutCnt(String studentOutCnt) {
		this.studentOutCnt = studentOutCnt;
	}
	public String getStudentHourCnt() {
		return studentHourCnt;
	}
	public void setStudentHourCnt(String studentHourCnt) {
		this.studentHourCnt = studentHourCnt;
	}
	public String getStudentCollegeCnt() {
		return studentCollegeCnt;
	}
	public void setStudentCollegeCnt(String studentCollegeCnt) {
		this.studentCollegeCnt = studentCollegeCnt;
	}	
	public String getSttTotalCnt() {
		return sttTotalCnt;
	}
	public void setSttTotalCnt(String sttTotalCnt) {
		this.sttTotalCnt = sttTotalCnt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}