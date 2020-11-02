package com.cyberup.model.system;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class UnivCode extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6278478966871376409L;
	
	private Integer universityId = 0;
	private String univName = "";
	private Integer gubunId = 0;
	private String gubunName;
	private String academyId = "";
	private String univAddress = "";
	private String univHomepage = "";
	private String useYn = "";
	private String register = "";
	private String registerName = ""; 
	private Date regDate;
	private String modifier = "";
	private String modifierName = "";
	private Date modDate;
	private Integer localId = 0;
	private String localName = "";
	private String selectRadio1 = "";
	private String searchWord = "";

	private String installDataProvider = "";
	

	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSelectRadio1() {
		return selectRadio1;
	}
	public void setSelectRadio1(String selectRadio1) {
		this.selectRadio1 = selectRadio1;
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
	public Integer getLocalId() {
		return localId;
	}
	public void setLocalId(Integer localId) {
		this.localId = localId;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public Integer getUniversityId(){
		return this.universityId;
	}
	public void setUniversityId(Integer universityId){
		if(universityId != null)
			this.universityId = universityId;
	}
	public String getUnivName(){
		return this.univName;
	}
	public void setUnivName(String univName){
		this.univName = univName;
	}
	public Integer getGubunId(){
		return this.gubunId;
	}
	public void setGubunId(Integer gubunId){
		if(gubunId != null)
			this.gubunId = gubunId;
	}
	public String getGubunName() {
		return gubunName;
	}
	public void setGubunName(String gubunName) {
		this.gubunName = gubunName;
	}
	public String getAcademyId(){
		return this.academyId;
	}
	public void setAcademyId(String academyId){
		this.academyId = academyId;
	}
	public String getUnivAddress() {
		return univAddress;
	}
	public void setUnivAddress(String univAddress) {
		this.univAddress = univAddress;
	}
	public String getUnivHomepage() {
		return univHomepage;
	}
	public void setUnivHomepage(String univHomepage) {
		this.univHomepage = univHomepage;
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
	public String getInstallDataProvider() {
		return installDataProvider;
	}
	public void setInstallDataProvider(String installDataProvider) {
		this.installDataProvider = installDataProvider;
	}
}
