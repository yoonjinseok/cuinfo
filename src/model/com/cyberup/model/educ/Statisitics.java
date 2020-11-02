package com.cyberup.model.educ;

import java.util.Date;

import com.cyberup.framework.model.PagingModel;

public class Statisitics extends PagingModel {

	private static final long serialVersionUID = -6847751863705361016L;
	/**
	 * 기   능 : 통계자료관리  
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */
	
	private long sttID = 0 ;
	private String termState = "";			//정기유형여부
	private String sttYear = "";			//수집 년도
	private String sttMonth  = "";			//수집 분기 		
	private String deadline = "";			//마감일
	private String sttName = "";			//통계명
	private String gatherState = "";		//수집상태
	private Integer upfileGid = 0;			//통계파일그룹아이디
	private String declare = "";			//설명
	private String useYN = "";				//사용여부
	private Date regDate;					//등록일
	private String register = "";			//등록자아이디
	private String registerNM = "";			//등록자명
	private Date modDate;					//수정일
	private String modifier = ""; 			//수정자아이디	
	private String modifierNM = "";			//수정자명
	private String newYN = "";				//최신정보여부
	private Integer gubunID = 0;			//대학유형구분
	
	private Integer upfileID = 0;
	private String srcFileName = ""; 	//저장된 파일이름
	private String orgFileName = ""; 	//원래 파일명
	private String fileSize = "";   	//파일 사이즈
	private String filePath = "";
	
	private String[] upfileSrc;

	public long getSttID() {
		return sttID;
	}
	public void setSttID(long sttID) {
		this.sttID = sttID;
	}
	public String getTermState() {
		return termState;
	}
	public void setTermState(String termState) {
		this.termState = termState;
	}
	public String getSttYear() {
		return sttYear;
	}
	public void setSttYear(String sttYear) {
		this.sttYear = sttYear;
	}
	public String getSttMonth() {
		return sttMonth;
	}
	public void setSttMonth(String sttMonth) {
		this.sttMonth = sttMonth;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getSttName() {
		return sttName;
	}
	public void setSttName(String sttName) {
		this.sttName = sttName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getGatherState() {
		return gatherState;
	}
	public void setGatherState(String gatherState) {
		this.gatherState = gatherState;
	}
	public String getDeclare() {
		return declare;
	}
	public void setDeclare(String declare) {
		this.declare = declare;
	}
	public String getUseYN() {
		return useYN;
	}	
	public String getNewYN() {
		return newYN;
	}
	public void setNewYN(String newYN) {
		this.newYN = newYN;
	}
	public void setUseYN(String useYN) {
		this.useYN = useYN;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}	
	public String getRegisterNM() {
		return registerNM;
	}
	public void setRegisterNM(String registerNM) {
		this.registerNM = registerNM;
	}
	public String getModifierNM() {
		return modifierNM;
	}
	public void setModifierNM(String modifierNM) {
		this.modifierNM = modifierNM;
	}
	public String getSrcFileName() {
		return srcFileName;
	}
	public void setSrcFileName(String srcFileName) {
		//if(srcFileName != null)
			this.srcFileName = srcFileName;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		if(orgFileName != null)
			this.orgFileName = orgFileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getGubunID() {
		return gubunID;
	}
	public void setGubunID(Integer gubunID) {
		this.gubunID = gubunID;
	}
	public Integer getUpfileGid() {
		return upfileGid;
	}
	public void setUpfileGid(Integer upfileGid) {
		if(upfileGid != null)
			this.upfileGid = upfileGid;
	}
	public Integer getUpfileID() {
		return upfileID;
	}
	public void setUpfileID(Integer upfileID) {
		if(upfileID != null)
			this.upfileID = upfileID;
	}
	public String[] getUpfileSrc() {
		return upfileSrc;
	}
	public void setUpfileSrc(String[] upfileSrc) {
		this.upfileSrc = upfileSrc;
	}

	
	
}