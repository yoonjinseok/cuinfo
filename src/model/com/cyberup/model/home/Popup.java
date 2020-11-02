package com.cyberup.model.home;

import java.util.Date;
import java.util.List;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class Popup extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1311015130011710120L;
	
	private Integer attachUpfileGid = 0;
	private Integer contentTypeId 	= 0;
	private Integer imgUpfileId		= 0;
	private Integer popupHeight	  	= 0;
	private Integer popupLeft 	  	= 0;
	private Integer popupTop	  	= 0;
	private Integer popupWidth 	  	= 0;
	private Integer popupId 	  	= 0;
	private Integer skinId 		  	= 0;	
	
    private String content 	 	 = "";	
    private String modifier 	 = "";
    private String register 	 = "";
    private String showEndDt 	 = "";
    private String showEndTm 	 = "";
    private String showYn 		 = "";
    private String showStartDt 	 = "";
    private String showStartTm 	 = "";
    private String targetLink    = "";
	private String title	 	 = "";
	
	private Date regDate;
	private Date modDate;
	

	public Integer getAttachUpfileGid() {
		return attachUpfileGid;
	}
	public void setAttachUpfileGid(Integer attachUpfileGid) {
		this.attachUpfileGid = attachUpfileGid;
	}
	public Integer getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public Integer getImgUpfileId() {
		return imgUpfileId;
	}
	public void setImgUpfileId(Integer imgUpfileId) {
		this.imgUpfileId = imgUpfileId;
	}
	public Integer getPopupHeight() {
		return popupHeight;
	}
	public void setPopupHeight(Integer popupHeight) {
		this.popupHeight = popupHeight;
	}
	public Integer getPopupLeft() {
		return popupLeft;
	}
	public void setPopupLeft(Integer popupLeft) {
		this.popupLeft = popupLeft;
	}
	public Integer getPopupTop() {
		return popupTop;
	}
	public void setPopupTop(Integer popupTop) {
		this.popupTop = popupTop;
	}
	public Integer getPopupWidth() {
		return popupWidth;
	}
	public void setPopupWidth(Integer popupWidth) {
		this.popupWidth = popupWidth;
	}
	public Integer getPopupId() {
		return popupId;
	}
	public void setPopupId(Integer popupId) {
		if(popupId != null)
			this.popupId = popupId;
	}
	public Integer getSkinId() {
		return skinId;
	}
	public void setSkinId(Integer skinId) {
		this.skinId = skinId;
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
