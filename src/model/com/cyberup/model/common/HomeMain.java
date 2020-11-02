package com.cyberup.model.common;

import java.util.Date;

import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.course.CourseSearch;

public class HomeMain extends CourseSearch{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4742531064097095116L;

	private Date newsRegDate;
	private Date regDate;
	private Date regDate1;
	private Date regDate2;
	
	private String univName = "";
	private String newsTitle = "";
	private String title = "";
	private String mainTitle = "";
	private String subTitle = "";
	private String eventSdt = "";
	private String eventEdt = "";
	private String boardContent = "";
	private String email = "";
	private String regID = "";
	private String regName = "";
	private String newYN = "";
	private String coreSlogan = "";
	private String newsLink = "";
	private String courseIdentifier = "";
	private String fulltitle = "";
	
	private Integer recNum = 0;
	private Integer newsId = 0;
	private Integer boardUnivId = 0;
	private Integer universityId = 0;
	private Integer totalCnt = 0;
	private Integer boardID = 0;
	private Integer typeID = 0;
	private Integer upfileGid = 0;
	private Integer hitsCount = 0;
	private Integer mod = 0;
	private Integer courseId = 0;
	private Integer publicImgUpfileId = 0;
	
	private Integer logoUpfileGid = 0;
	
	private Integer rdmCnt =0;
	
	private String  thumbNailUri = "";
	private String  thumbNailUriYN = "";
	private String 	contName = "";
	
	private String menuName="";
	private String url="";
	
	private String prevUri="";
	
	
	public String getPrevUri() {
		return prevUri;
	}

	public void setPrevUri(String prevUri) {
		this.prevUri = prevUri;
	}

	public String getThumbNailUri() {
		return thumbNailUri;
	}

	public void setThumbNailUri(String thumbNailUri) {
		this.thumbNailUri = thumbNailUri;
	}

	public String getThumbNailUriYN() {
		return thumbNailUriYN;
	}

	public void setThumbNailUriYN(String thumbNailUriYN) {
		this.thumbNailUriYN = thumbNailUriYN;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public Integer getRdmCnt() {
		return rdmCnt;
	}

	public void setRdmCnt(Integer rdmCnt) {
		if(rdmCnt != null)
			this.rdmCnt = rdmCnt;
	}

	public Integer getLogoUpfileGid() {
		return logoUpfileGid;
	}

	public void setLogoUpfileGid(Integer logoUpfileGid) {
		if(logoUpfileGid != null)
			this.logoUpfileGid = logoUpfileGid;
	}

	public Integer getPublicImgUpfileId() {
		return publicImgUpfileId;
	}

	public void setPublicImgUpfileId(Integer publicImgUpfileId) {
		this.publicImgUpfileId = publicImgUpfileId;
	}

	//더 보기를 클릭했을경우의 변수.
	//1: 사이버대학뉴스, 2:대학행사안내, 3:협의회동정, 4:공지사항
	private Integer gubn = 0;

	
	public String getCourseIdentifier() {
		return courseIdentifier;
	}

	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		if(courseId != null)
			this.courseId = courseId;
	}

	public String getNewsLink() {
		return newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public Integer getMod() {
		return mod;
	}

	public void setMod(Integer mod) {
		if(mod != null)
			this.mod = mod;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Date getNewsRegDate() {
		return newsRegDate;
	}

	public void setNewsRegDate(Date newsRegDate) {
		this.newsRegDate = newsRegDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getRegDate1() {
		return regDate1;
	}

	public void setRegDate1(Date regDate1) {
		this.regDate1 = regDate1;
	}

	public Date getRegDate2() {
		return regDate2;
	}

	public void setRegDate2(Date regDate2) {
		this.regDate2 = regDate2;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEventSdt() {
		return eventSdt;
	}

	public void setEventSdt(String eventSdt) {
		this.eventSdt = eventSdt;
	}

	public String getEventEdt() {
		return eventEdt;
	}

	public void setEventEdt(String eventEdt) {
		this.eventEdt = eventEdt;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegID() {
		return regID;
	}

	public void setRegID(String regID) {
		this.regID = regID;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getNewYN() {
		return newYN;
	}

	public void setNewYN(String newYN) {
		this.newYN = newYN;
	}

	public String getCoreSlogan() {
		return coreSlogan;
	}

	public void setCoreSlogan(String coreSlogan) {
		this.coreSlogan = coreSlogan;
	}

	public Integer getRecNum() {
		return recNum;
	}

	public void setRecNum(Integer recNum) {
		if(recNum != null)
			this.recNum = recNum;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		if(newsId != null)
			this.newsId = newsId;
	}

	public Integer getBoardUnivId() {
		return boardUnivId;
	}

	public void setBoardUnivId(Integer boardUnivId) {
		if(boardUnivId != null)
			this.boardUnivId = boardUnivId;
	}

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer universityId) {
		if(universityId != null)
			this.universityId = universityId;
	}

	public Integer getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(Integer totalCnt) {
		if(totalCnt != null)
			this.totalCnt = totalCnt;
	}

	public Integer getBoardID() {
		return boardID;
	}

	public void setBoardID(Integer boardID) {
		if(boardID != null)
			this.boardID = boardID;
	}

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		if(typeID != null)
			this.typeID = typeID;
	}

	public Integer getUpfileGid() {
		return upfileGid;
	}

	public void setUpfileGid(Integer upfileGid) {
		if(upfileGid != null)
			this.upfileGid = upfileGid;
	}

	public Integer getHitsCount() {
		return hitsCount;
	}

	public void setHitsCount(Integer hitsCount) {
		if(hitsCount != null)
			this.hitsCount = hitsCount;
	}

	public Integer getGubn() {
		return gubn;
	}

	public void setGubn(Integer gubn) {
		if(gubn != null)
			this.gubn = gubn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFulltitle() {
		return fulltitle;
	}

	public void setFulltitle(String fulltitle) {
		this.fulltitle = fulltitle;
	}
	
}
