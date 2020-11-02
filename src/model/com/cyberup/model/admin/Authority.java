package com.cyberup.model.admin;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.LoginUser;

public class Authority extends Menu {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8503432495569183950L;

	private Integer authLevelId = 0;
	private String menuId = "";
	private String authYn = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;

	public Integer getAuthLevelId(){
		return this.authLevelId;
	}
	public void setAuthLevelId(Integer authLevelId){
		if(authLevelId != null)
			this.authLevelId = authLevelId;
	}
	public String getMenuId(){
		return this.menuId;
	}
	public void setMenuId(String menuId){
		this.menuId = menuId;
	}
	public String getAuthYn(){
		return this.authYn;
	}
	public void setAuthYn(String authYn){
		this.authYn = authYn;
	}
	public String getRegister(){
		return this.register;
	}
	public void setRegister(String register){
		this.register = register;
	}
	public Date getRegDate(){
		return this.regDate;
	}
	public void setRegDate(Date regDate){
		this.regDate = regDate;
	}
	public String getModifier(){
		return this.modifier;
	}
	public void setModifier(String modifier){
		this.modifier = modifier;
	}
	public Date getModDate(){
		return this.modDate;
	}
	public void setModDate(Date modDate){
		this.modDate = modDate;
	}
	
}
