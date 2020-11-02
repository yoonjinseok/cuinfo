package com.cyberup.model.home;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class Board extends PagingModel {


	private static final long serialVersionUID = 6629787210198387762L;
	/**
	 * 기   능 : 일반 게시판  
	 * 작성자 : 오성애
	 * 작성일 : 2011-10-04
	 */
	
	private String searchText = "";
	
	
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	private long boardID = 0 ;
	private String gubunID = "";
	private String title   = "";
	private String typeID  = ""; 		//글쓰기 타입
	private String boardContent = "";
	private Integer upfileGid = 0;
	private String email = "";
	private Integer hitsCount = 0;
	private String regName = "";
	private String regID = "";
	private Date regDate;
	private String modName = "";
	private String modID = "";
	private Date modDate;
	private String adminEmail = ""; 	//관리자 이메일
	private String newYN = "";			//신규글인지 여부 
	
	private String[] upfileSrc;

	public long getBoardID() {
		return boardID;
	}
	public void setBoardID(long boardID) {
		this.boardID = boardID;
	}
	public String getGubunID() {
		return gubunID;
	}
	public void setGubunID(String gubunID) {
		this.gubunID = gubunID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title != null)
			this.title = title;
	}
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		if(boardContent != null)
			this.boardContent = boardContent;
	}
	public Integer getUpfileGid() {
		return upfileGid;
	}
	public void setUpfileGid(Integer upfileGid) {
		if(upfileGid != null)
			this.upfileGid = upfileGid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email != null)
			this.email = email;
	}
	public Integer getHitsCount() {
		return hitsCount;
	}
	public void setHitsCount(Integer hitsCount) {
		this.hitsCount = hitsCount;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {		
		this.regName = regName;
	}
	public String getRegID() {
		return regID;
	}
	public void setRegID(String regID) {
		this.regID = regID;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getModName() {
		return modName;
	}
	public void setModName(String modName) {
		this.modName = modName;
	}
	public String getModID() {
		return modID;
	}
	public void setModID(String modID) {
		this.modID = modID;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
		
	public String getNewYN() {
		return newYN;
	}
	public void setNewYN(String newYN) {
		this.newYN = newYN;
	}
	public String[] getUpfileSrc() {
		return upfileSrc;
	}
	public void setUpfileSrc(String[] upfileSrc) {
		this.upfileSrc = upfileSrc;
	}
	
	
}