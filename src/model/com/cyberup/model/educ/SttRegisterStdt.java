package com.cyberup.model.educ;

import com.cyberup.framework.model.PagingModel;

public class SttRegisterStdt extends PagingModel {

	private static final long serialVersionUID = 3718374141389207197L;
	/**
	 * 기   능 : 입학정원 현황, 입학 정원 대비 등록율(정원내학생등록상황)
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */

	private long ID = 0 ;
	private String studentInCnt = "";   //입학정원수
	private String sttClass = "";	//학년
	private String studentRegisterCnt  = ""; //등록생
	private String sttUnivId = ""; //대학별 통계 자료아이디
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getStudentInCnt() {
		return studentInCnt;
	}
	public void setStudentInCnt(String studentInCnt) {
		this.studentInCnt = studentInCnt;
	}
	public String getSttClass() {
		return sttClass;
	}
	public void setSttClass(String sttClass) {
		this.sttClass = sttClass;
	}
	public String getStudentRegisterCnt() {
		return studentRegisterCnt;
	}
	public void setStudentRegisterCnt(String studentRegisterCnt) {
		this.studentRegisterCnt = studentRegisterCnt;
	}
	public String getSttUnivId() {
		return sttUnivId;
	}
	public void setSttUnivId(String sttUnivId) {
		this.sttUnivId = sttUnivId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	 
	



	
	
}