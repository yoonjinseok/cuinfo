package com.cyberup.model.course;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;

public class CourseFileUpload extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1748280365849699757L;
	
	private Integer upfileId = 0;
	private String upfilePath = "";
	private Long upfileSize = 0L;
	private String upfileFilename = "";
	private String upfileSource = "";
	private String upfileRegister = "";
	private Date upfileRegdate;

	public Integer getUpfileId(){
		return this.upfileId;
	}
	public void setUpfileId(Integer upfileId){
		if(upfileId != null)
			this.upfileId = upfileId;
	}
	public String getUpfilePath(){
		return this.upfilePath;
	}
	public void setUpfilePath(String upfilePath){
		this.upfilePath = upfilePath;
	}
	public Long getUpfileSize(){
		return this.upfileSize;
	}
	public void setUpfileSize(Long upfileSize){
		if(upfileSize != null)
			this.upfileSize = upfileSize;
	}
	public String getUpfileFilename(){
		return this.upfileFilename;
	}
	public void setUpfileFilename(String upfileFilename){
		this.upfileFilename = upfileFilename;
	}
	public String getUpfileSource(){
		return this.upfileSource;
	}
	public void setUpfileSource(String upfileSource){
		this.upfileSource = upfileSource;
	}
	public String getUpfileRegister(){
		return this.upfileRegister;
	}
	public void setUpfileRegister(String upfileRegister){
		this.upfileRegister = upfileRegister;
	}
	public Date getUpfileRegdate(){
		return this.upfileRegdate;
	}
	public void setUpfileRegdate(Date upfileRegdate){
		this.upfileRegdate = upfileRegdate;
	}
}
