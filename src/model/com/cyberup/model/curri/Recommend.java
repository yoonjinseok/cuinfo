package com.cyberup.model.curri;

import com.cyberup.framework.model.PagingModel;

public class Recommend extends PagingModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7761373201799862257L;
	/**
	 * 
	 */
	
	private long recommendID=0;
	private Integer universityID=0;
	private Integer dataType=0;
	private Integer courseID=0;
	private Integer courseOrder=0;
	private String register="";
	private String regDate="";
	private String modifier="";
	private String modDate="";
	private String title="";
	private String courseIdentifier="";
	
	
	public String getCourseIdentifier() {
		return courseIdentifier;
	}
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getRecommendID() {
		return recommendID;
	}
	public void setRecommendID(long recommendID) {
		this.recommendID = recommendID;
	}
	public Integer getUniversityID() {
		return universityID;
	}
	public void setUniversityID(Integer universityID) {
		this.universityID = universityID;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public Integer getCourseID() {
		return courseID;
	}
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	public Integer getCourseOrder() {
		return courseOrder;
	}
	public void setCourseOrder(Integer courseOrder) {
		this.courseOrder = courseOrder;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
