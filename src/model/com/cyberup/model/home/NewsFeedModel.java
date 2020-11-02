package com.cyberup.model.home;

import java.util.Date;

import com.cyberup.framework.model.PagingModel;

public class NewsFeedModel extends PagingModel  {
	
	private Integer newsId = 0;
	private String 	newsTitle = "";
	private String 	newsDesc = "";
	private String 	newsLink = "";
	private String 	showYn = "";
	private Date 	regDate;
	private String 	modifier = "";
	private Date 	modDate;
	private String 	newYN = "";
	
	public String getNewYN() {
		return newYN;
	}
	public void setNewYN(String newYN) {
		this.newYN = newYN;
	}
	private String 	radio = "";
	private String 	text = "";
	
	private Date newsRegDate;
	
	
	
	public Date getNewsRegDate() {
		return newsRegDate;
	}
	public void setNewsRegDate(Date newsRegDate) {
		this.newsRegDate = newsRegDate;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	private String[] checkbox;
	
	public Integer getNewsId() {
		return newsId;
	}
	public String[] getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
	public void setNewsId(Integer newsId) {
		if(newsId != null)
			this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsDesc() {
		return newsDesc;
	}
	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getShowYn() {
		return showYn;
	}
	public void setShowYn(String showYn) {
		this.showYn = showYn;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	
	
	
	
}
