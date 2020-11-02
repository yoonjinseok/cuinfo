package com.cyberup.model.home;

import java.util.Date;
import java.util.List;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class Poup extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1311015130011710120L;
	
	private String imgUpfileId		= "";
	private String attachUpfileId = "";
	private String attachUpfileName = "";
	
	private Integer attachUpfileGid = 0;
	private Integer contentTypeId 	= 0;
	private Integer imgUpfileGid		= 0;
	private Integer poupHeight	  	= 0;
	private Integer poupLeft 	  		= 0;
	private Integer poupTop	  		= 0;
	private Integer poupWidth 	  	= 0;
	private Integer poupNum 	  	= 0;
	private Integer skinId 		  		= 0;
	private String skinName 	 		 = "";	
	private String skinText 	 		 = "";	
	private Integer startHour			= 0;
	private Integer startMin			= 0;
	private Integer endHour			= 0;
	private Integer endMin			= 0;
	
    private String content 	 	 		 = "";	
    private String modifier 		 	 = "";
    private String register 		 		 = "";
    private String showEndDt 	 	 = "";
    private String showEndTm 	 	 = "";
    private String showYn 		 		 = "";
    private String showStartDt 	 	 = "";
    private String showStartTm 		 = "";
    private String targetLink    		 = "";
	private String title	 		   		 = "";
	private String regnm		 		 = "";
	private String modnm		 		 = "";
	private String searchword			 = "";
	private String selectyn				 = "";
	private String selectRadio1		 = "";
	
	
	
	private Date regDate;
	private Date modDate;
	
	private Integer upfileID = 0;
	private Integer upfileGid = 0;

	private String[] upfileSrc;
	
	
	
	public String getAttachUpfileName() {
		return attachUpfileName;
	}
	public void setAttachUpfileName(String attachUpfileName) {
		this.attachUpfileName = attachUpfileName;
	}
	public String getSkinName() {
		return skinName;
	}
	public void setSkinName(String skinName) {
		this.skinName = skinName;
	}
	public String getSkinText() {
		return skinText;
	}
	public void setSkinText(String skinText) {
		this.skinText = skinText;
	}
	public Integer getUpfileID() {
		return upfileID;
	}
	public void setUpfileID(Integer upfileID) {
		if(upfileID != null)
			this.upfileID = upfileID;
	}
	public Integer getUpfileGid() {
		return upfileGid;
	}
	public void setUpfileGid(Integer upfileGid) {
		if(upfileGid != null)
			this.upfileGid = upfileGid;
	}
	public String[] getUpfileSrc() {
		return upfileSrc;
	}
	public void setUpfileSrc(String[] upfileSrc) {
		this.upfileSrc = upfileSrc;
	}
	public Integer getAttachUpfileGid() {
		return attachUpfileGid;
	}
	public void setAttachUpfileGid(Integer attachUpfileGid) {
		if(attachUpfileGid != null)
			this.attachUpfileGid = attachUpfileGid;
	}
	public Integer getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(Integer contentTypeId) {
		if(contentTypeId != null)
			this.contentTypeId = contentTypeId;
	}
	
	public String getImgUpfileId() {
		return imgUpfileId;
	}
	public void setImgUpfileId(String imgUpfileId) {
			this.imgUpfileId = imgUpfileId;
	}
	public String getAttachUpfileId() {
		return attachUpfileId;
	}
	public void setAttachUpfileId(String attachUpfileId) {
			this.attachUpfileId = attachUpfileId;
	}
	public Integer getImgUpfileGid() {
		return imgUpfileGid;
	}
	public void setImgUpfileGid(Integer imgUpfileGid) {
		if(imgUpfileGid != null)
			this.imgUpfileGid = imgUpfileGid;
	}
	public Integer getPoupHeight() {
		return poupHeight;
	}
	public void setPoupHeight(Integer poupHeight) {
		if(poupHeight != null)
			this.poupHeight = poupHeight;
	}
	public Integer getPoupLeft() {
		return poupLeft;
	}
	public void setPoupLeft(Integer poupLeft) {
		if(poupLeft != null)
			this.poupLeft = poupLeft;
	}
	public Integer getPoupTop() {
		return poupTop;
	}
	public void setPoupTop(Integer poupTop) {
		if(poupTop != null)
			this.poupTop = poupTop;
	}
	public Integer getPoupWidth() {
		return poupWidth;
	}
	public void setPoupWidth(Integer poupWidth) {
		if(poupWidth != null)
			this.poupWidth = poupWidth;
	}
	public Integer getPoupNum() {
		return poupNum;
	}
	public void setPoupNum(Integer poupNum) {
		if(poupNum != null)
			this.poupNum = poupNum;
	}
	public Integer getSkinId() {
		return skinId;
	}
	public void setSkinId(Integer skinId) {
		if(skinId != null)
			this.skinId = skinId;
	}
	public Integer getStartHour() {
		return startHour;
	}
	public void setStartHour(Integer startHour) {
		if(startHour != null)
			this.startHour = startHour;
	}
	public Integer getStartMin() {
		return startMin;
	}
	public void setStartMin(Integer startMin) {
		if(startMin != null)
			this.startMin = startMin;
	}
	public Integer getEndHour() {
		return endHour;
	}
	public void setEndHour(Integer endHour) {
		if(endHour != null)
			this.endHour = endHour;
	}
	public Integer getEndMin() {
		return endMin;
	}
	public void setEndMin(Integer endMin) {
		if(endMin != null)
			this.endMin = endMin;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getShowEndDt() {
		return showEndDt;
	}
	public void setShowEndDt(String showEndDt) {
		this.showEndDt = showEndDt;
	}
	public String getShowEndTm() {
		return showEndTm;
	}
	public void setShowEndTm(String showEndTm) {
		this.showEndTm = showEndTm;
	}
	public String getShowYn() {
		return showYn;
	}
	public void setShowYn(String showYn) {
		this.showYn = showYn;
	}
	public String getShowStartDt() {
		return showStartDt;
	}
	public void setShowStartDt(String showStartDt) {
		this.showStartDt = showStartDt;
	}
	public String getShowStartTm() {
		return showStartTm;
	}
	public void setShowStartTm(String showStartTm) {
		this.showStartTm = showStartTm;
	}
	public String getTargetLink() {
		return targetLink;
	}
	public void setTargetLink(String targetLink) {
		this.targetLink = targetLink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegnm() {
		return regnm;
	}
	public void setRegnm(String regnm) {
		this.regnm = regnm;
	}
	public String getModnm() {
		return modnm;
	}
	public void setModnm(String modnm) {
		this.modnm = modnm;
	}
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	public String getSelectyn() {
		return selectyn;
	}
	public void setSelectyn(String selectyn) {
		this.selectyn = selectyn;
	}
	public String getSelectRadio1() {
		return selectRadio1;
	}
	public void setSelectRadio1(String selectRadio1) {
		this.selectRadio1 = selectRadio1;
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
	
	

}
