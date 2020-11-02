package com.cyberup.model.educ;

import java.util.Date;

import com.cyberup.framework.model.PagingModel;

public class UnivStt extends PagingModel {

	private static final long serialVersionUID = 8921549823942369451L;
	/**
	 * 기   능 : 대학별 통계자료 등록  
	 * 작성자 : 배진국
	 * 작성일 : 2012-10-31
	 */
	
	private long sttUnivID = 0 ;
	private Integer universityID = 0;   //대학아이디
	private Integer upfileGid = 0;
	private String uploadState  = "";
	private Date regDate;
	private String register = "";
	private String registerNM = "";
	private Date modDate;
	private String modifier = ""; 	
	private String modifierNM = ""; 	
	private Integer sttID = 0; 	
	private String putState = "";
	
	private Integer upfileID = 0;
	private String srcFileName = ""; 	//저장된 파일이름
	private String orgFileName = ""; 	//원래 파일명
	private String fileSize = "";   	//파일 사이즈
	private String filePath ="";
	
	private String univName = "";	//대학명
	private String gubunId = "";	//대학구분
	private String newYN = "";	    //새로추가한 여부
	private String sstUnivIDs = "";	//선택한대학아이디 
	private String termState = ""; //정기/비정기상태
	private String sttName = ""; //파일명
	private Date sttRegDate;	//양식파일 등록일	
	private String gatherState;	//수집상태
	private String deadline = "";	//마감일
	private String isEnd = "";	//마감일

	private String[] upfileSrc;
	
	public String getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}
	public long getSttUnivID() {
		return sttUnivID;
	}
	public void setSttUnivID(long sttUnivID) {
		this.sttUnivID = sttUnivID;
	}
	public Integer getUniversityID() {
		return universityID;
	}
	public void setUniversityID(Integer universityID) {
		if(universityID != null)
			this.universityID = universityID;
	}	
	public String getUploadState() {
		return uploadState;
	}
	public void setUploadState(String uploadState) {
		this.uploadState = uploadState;
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
	public Integer getSttID() {
		return sttID;
	}
	public void setSttID(Integer sttID) {
		if(sttID != null)
			this.sttID = sttID;
	}
	public String getPutState() {
		return putState;
	}
	public void setPutState(String putState) {
		this.putState = putState;
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

	
	
	public String getSstUnivIDs() {
		return sstUnivIDs;
	}
	public void setSstUnivIDs(String sstUnivIDs) {
		this.sstUnivIDs = sstUnivIDs;
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
	public String getNewYN() {
		return newYN;
	}
	public void setNewYN(String newYN) {
		this.newYN = newYN;
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
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public String getGubunId() {
		return gubunId;
	}
	public void setGubunId(String gubunId) {
		this.gubunId = gubunId;
	}
	public String getTermState() {
		return termState;
	}
	public void setTermState(String termState) {
		this.termState = termState;
	}
	public String getSttName() {
		return sttName;
	}
	public void setSttName(String sttName) {
		this.sttName = sttName;
	}
	public Date getSttRegDate() {
		return sttRegDate;
	}
	public void setSttRegDate(Date sttRegDate) {
		this.sttRegDate = sttRegDate;
	}	
	public String getGatherState() {
		return gatherState;
	}
	public void setGatherState(String gatherState) {
		this.gatherState = gatherState;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
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