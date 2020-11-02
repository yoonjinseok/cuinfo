package com.cyberup.model.course;

import java.util.Date;

import com.cyberup.framework.model.PagingModel;

public class DataProvider extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3103905275824166964L;
	private Integer universityId = 0;
	private String universityName = "";
	private String orgId = "";
	private String protocolVer = "";
	private String delimiter = "";
	private String dateFormat = "";
	private String repositoryIdentifier = "";
	private String allowallYn = "";
	private String dpName = "";
	private String dpUrl = "";
	private String adminName = "";
	private String adminEmail = "";
	private String useYn = "";
	private String autoYn = "";
	private String dpRegister = "";
	private String dpRegisterName = "";
	private Date dpRegdate;
	private String dpModifier = "";
	private String dpModifierName = "";
	private Date dpModdate;
	
	public String getOrgId(){
		return this.orgId;
	}
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	public String getProtocolVer(){
		return this.protocolVer;
	}
	public void setProtocolVer(String protocolVer){
		this.protocolVer = protocolVer;
	}
	public String getDelimiter(){
		return this.delimiter;
	}
	public void setDelimiter(String delimiter){
		this.delimiter = delimiter;
	}
	public String getDateFormat(){
		return this.dateFormat;
	}
	public void setDateFormat(String dateFormat){
		this.dateFormat = dateFormat;
	}
	public String getRepositoryIdentifier(){
		return this.repositoryIdentifier;
	}
	public void setRepositoryIdentifier(String repositoryIdentifier){
		this.repositoryIdentifier = repositoryIdentifier;
	}
	public String getAllowallYn(){
		return this.allowallYn;
	}
	public void setAllowallYn(String allowallYn){
		this.allowallYn = allowallYn;
	}
	public String getDpName(){
		return this.dpName;
	}
	public void setDpName(String dpName){
		this.dpName = dpName;
	}
	public String getDpUrl(){
		return this.dpUrl;
	}
	public String getDpUrl(int max, String pad)
	{
		if(this.dpUrl != null)
		{
			if(this.dpUrl.length() > max)
			{
				return this.dpUrl.substring(0, max) + pad;
			}
			else 
				return this.dpUrl;
		}
		else
			return null;
	}
	public void setDpUrl(String dpUrl){
		this.dpUrl = dpUrl;
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
	public String getUseYn(){
		return this.useYn;
	}
	public void setUseYn(String useYn){
		this.useYn = useYn;
	}
	public String getAutoYn() {
		return autoYn;
	}
	public void setAutoYn(String autoYn) {
		this.autoYn = autoYn;
	}
	public String getDpRegister(){
		return this.dpRegister;
	}
	public void setDpRegister(String dpRegister){
		this.dpRegister = dpRegister;
	}
	public Date getDpRegdate(){
		return this.dpRegdate;
	}
	public void setDpRegdate(Date dpRegdate){
		this.dpRegdate = dpRegdate;
	}
	public String getDpModifier(){
		return this.dpModifier;
	}
	public void setDpModifier(String dpModifier){
		this.dpModifier = dpModifier;
	}
	public Date getDpModdate(){
		return this.dpModdate;
	}
	public void setDpModdate(Date dpModdate){
		this.dpModdate = dpModdate;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getDpRegisterName() {
		return dpRegisterName;
	}
	public void setDpRegisterName(String dpRegisterName) {
		this.dpRegisterName = dpRegisterName;
	}
	public String getDpModifierName() {
		return dpModifierName;
	}
	public void setDpModifierName(String dpModifierName) {
		this.dpModifierName = dpModifierName;
	}
	public Integer getUniversityId() {
		return universityId;
	} 
	public void setUniversityId(Integer universityId) {
		if(universityId != null)
			this.universityId = universityId;
	}
}
