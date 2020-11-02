package com.cyberup.model.course;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;

public class Organization extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3734556872563644561L;
	
	private String orgId = "";
	private String orgName = "";
	private String adminName = "";
	private String adminEmail = "";
	private String adminTelno = "";
	private String etc = "";
	private String orgRegister = "";
	private Date orgRegdate;
	private String orgModifier = "";
	private Date orgModdate;
	private String catalogName = "";

	public String getOrgId(){
		return this.orgId;
	}
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	public String getOrgName(){
		return this.orgName;
	}
	public void setOrgName(String orgName){
		this.orgName = orgName;
	}
	public String getAdminName(){
		return this.adminName;
	}
	public void setAdminName(String adminName){
		this.adminName = adminName;
	}
	public String getAdminEmail(){
		return this.adminEmail;
	}
	public void setAdminEmail(String adminEmail){
		this.adminEmail = adminEmail;
	}
	public String getAdminTelno(){
		return this.adminTelno;
	}
	public void setAdminTelno(String adminTelno){
		this.adminTelno = adminTelno;
	}
	public String getEtc(){
		return this.etc;
	}
	public void setEtc(String etc){
		this.etc = etc;
	}
	public String getOrgRegister(){
		return this.orgRegister;
	}
	public void setOrgRegister(String orgRegister){
		this.orgRegister = orgRegister;
	}
	public Date getOrgRegdate(){
		return this.orgRegdate;
	}
	public void setOrgRegdate(Date orgRegdate){
		this.orgRegdate = orgRegdate;
	}
	public String getOrgModifier(){
		return this.orgModifier;
	}
	public void setOrgModifier(String orgModifier){
		this.orgModifier = orgModifier;
	}
	public Date getOrgModdate(){
		return this.orgModdate;
	}
	public void setOrgModdate(Date orgModdate){
		this.orgModdate = orgModdate;
	}
	public String getCatalogName(){
		return this.catalogName;
	}
	public void setCatalogName(String catalogName){
		this.catalogName = catalogName;
	}
}
