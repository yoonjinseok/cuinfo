package com.cyberup.model.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.UserDegree;

public class Admin extends PagingModel implements LoginUser {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2172695484345143861L;

	private Integer universityId = 0;
	private String universityName = "";
	
	private String adminId = "";
	private String adminName = "";
	private String adminPwd = "";
	private String adminPwd2 = "";
	private Integer authLevelId = 0;
	private String authLevelName;
	private String adminCompany = "";
	private String adminDepart = "";
	private String adminPosition = "";
	private String adminDuty = "";
	private String adminPhone = "";
	private String adminEmail = "";
	private String adminDesc = "";
	private String useYn = "";
	private String register = "";
	private String registerName = "";
	private Date regDate;
	private String modifier = "";
	private String modifierName = "";
	private Date modDate;
	private String acceptIp = "";
	private String remoteAddr = "";
	
	private List<Authority> authGroups;
	private List<Authority> authMenus;
	
	//학교 담당자 미처리 교과부 통계파일 수
	private String sttFileCnt;
	
	public Integer getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Integer universityId) {
		if(universityId != null)
			this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getAdminId(){
		return this.adminId;
	}
	public void setAdminId(String adminId){
		this.adminId = adminId;
	}
	public String getAdminName(){
		return this.adminName;
	}
	public void setAdminName(String adminName){
		this.adminName = adminName;
	}
	public String getAdminPwd(){
		return this.adminPwd;
	}
	public void setAdminPwd(String adminPwd){
		this.adminPwd = adminPwd;
	}
	public String getAdminPwd2() {
		return adminPwd2;
	}
	public void setAdminPwd2(String adminPwd2) {
		this.adminPwd2 = adminPwd2;
	}
	public Integer getAuthLevelId(){
		return this.authLevelId;
	}
	public boolean isUniversityOper()
	{
		if(this.authLevelId == 3)
			return true;
		else
			return false;
	}
	public void setAuthLevelId(Integer authLevelId){
		if(authLevelId != null)
			this.authLevelId = authLevelId;
	}
	public String getAuthLevelName() {
		return authLevelName;
	}
	public void setAuthLevelName(String authLevelName) {
		this.authLevelName = authLevelName;
	}
	public String getAdminCompany(){
		return this.adminCompany;
	}
	public void setAdminCompany(String adminCompany){
		this.adminCompany = adminCompany;
	}
	public String getAdminDepart(){
		return this.adminDepart;
	}
	public void setAdminDepart(String adminDepart){
		this.adminDepart = adminDepart;
	}
	public String getAdminPosition(){
		return this.adminPosition;
	}
	public void setAdminPosition(String adminPosition){
		this.adminPosition = adminPosition;
	}
	public String getAdminDuty(){
		return this.adminDuty;
	}
	public void setAdminDuty(String adminDuty){
		this.adminDuty = adminDuty;
	}
	public String getAdminPhone(){
		return this.adminPhone;
	}
	public void setAdminPhone(String adminPhone){
		this.adminPhone = adminPhone;
	}
	public String getAdminEmail(){
		return this.adminEmail;
	}
	public void setAdminEmail(String adminEmail){
		this.adminEmail = adminEmail;
	}
	public String getAdminDesc(){
		return this.adminDesc;
	}
	public void setAdminDesc(String adminDesc){
		this.adminDesc = adminDesc;
	}
	public String getUseYn(){
		return this.useYn;
	}
	public void setUseYn(String useYn){
		this.useYn = useYn;
	}
	public String getRegister(){
		return this.register;
	}
	public void setRegister(String register){
		this.register = register;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getModifierName() {
		return modifierName;
	}
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
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
	public String getAcceptIp() {
		return acceptIp;
	}
	public void setAcceptIp(String acceptIp) {
		this.acceptIp = acceptIp;
	}
	public String getRemoteAddr() {
		return remoteAddr;
	}
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	
	public List<Authority> getAuthGroups() {
		return authGroups;
	}
	public void setAuthGroups(List<Authority> authGroups) {
		this.authGroups = authGroups;
	}
	public List<Authority> getAuthMenus() {
		return authMenus;
	}
	public void setAuthMenus(List<Authority> authMenus) {
		this.authMenus = authMenus;
	}
	
	public boolean allowGroup(String groupId)
	{
		for(int i = 0; authGroups!= null && i < authGroups.size(); i++)
		{
			if(authGroups.get(i).getGroupId().equals(groupId))
				return true;
		}
		
		return false;
	}
	public boolean allowMenu(String menuId)
	{
		for(int i = 0; authMenus!= null && i < authMenus.size(); i++)
		{
			if(authMenus.get(i).getMenuId().equals(menuId))
				return true;
		}
		
		return false;
	}
	public List<Authority> getAllowMenus(String groupId)
	{
		List<Authority> list = new ArrayList<Authority>();
		
		for(int i = 0; authMenus!= null && i < authMenus.size(); i++)
		{
			if(authMenus.get(i).getGroupId().equals(groupId))
				list.add(authMenus.get(i));
		}
		
		return list;
	}
	
	public String getUserId() {
		return this.adminId;
	}
	public String getUserName() {
		return this.adminName;
	}
	public String getUserDegree() {
		return UserDegree.ADMIN.getValue();
	}
	public String getUserLocale() {
		return "ko";
	}
	public String getSttFileCnt() {
		return sttFileCnt;
	}
	public void setSttFileCnt(String sttFileCnt) {
		this.sttFileCnt = sttFileCnt;
	}
	
	
}
