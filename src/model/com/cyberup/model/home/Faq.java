package com.cyberup.model.home;

import java.util.Date;
import java.util.List;

import com.cyberup.framework.model.PagingModel;

public class Faq extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3103905275824166964L;

	private Integer universityId = 0;
	private String universityName;
	private String orgId = "";
	private String protocolVer = "";
	private String delimiter = "";
	private String dateFormat = "";
	private String repositoryIdentifier = "";
	private String allowallYn = "";
	private String dpName = "";
	private String dpUrl = "";
	private String adminName = "";

	private String useYn = "";

	private Date modDate;
	private Date regDate;
	
	private List<?>   selectSection;

	private String adminEmail   = "";
	private String answer 		= "";
	private String faqContent	= "";
	private String faqWriter	= "";	
	private String modifier		= "";
	private String modifierName	= "";
	private String question 	= "";
	private String register 	= "";	
	private String registerName	= "";	
	private String searchCon1	= "";
	private String searchCon2	= "";

	private String sectionName  = "";
	private String selectRadio1	= "";
	private String selectRadio2	= "";	
	
	
	
	private Integer faqId 		= 0;
	private Integer faqOrder 	= 0;	
	private Integer fileListCnt = 0;
	
	private Integer hitsCnt 	= 0;
	private Integer sectionId 	= 0;
	
	private Integer upfileGid = 0;
	private String[] upfileSrc;
	
	private String univName = "";
	private String univFaqLink = "";
	
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public String getUnivFaqLink() {
		return univFaqLink;
	}
	public void setUnivFaqLink(String univFaqLink) {
		this.univFaqLink = univFaqLink;
	}
	public Integer getFileListCnt() {
		return fileListCnt;
	}
	public void setFileListCnt(Integer fileListCnt) {
		this.fileListCnt = fileListCnt;
	}
	public Integer getUpfileGid() {
		return upfileGid;
	}
	public void setUpfileGid(Integer upfileGid) {
		this.upfileGid = upfileGid;
	}
	public String[] getUpfileSrc() {
		return upfileSrc;
	}
	public void setUpfileSrc(String[] upfileSrc) {
		this.upfileSrc = upfileSrc;
	}
	public String getSearchCon1() {
		return searchCon1;
	}
	public void setSearchCon1(String searchCon1) {
		this.searchCon1 = searchCon1;
	}
	public String getSearchCon2() {
		return searchCon2;
	}
	public void setSearchCon2(String searchCon2) {
		this.searchCon2 = searchCon2;
	}
	public String getModifierName() {
		return modifierName;
	}
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public List<?> getSelectSection() {
		return selectSection;
	}
	public void setSelectSection(List<?> selectSection) {
		this.selectSection = selectSection;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getFaqWriter() {
		return faqWriter;
	}
	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}
	public String getSelectRadio1() {
		return selectRadio1;
	}
	public void setSelectRadio1(String selectRadio1) {
		this.selectRadio1 = selectRadio1;
	}
	public String getSelectRadio2() {
		return selectRadio2;
	}
	public void setSelectRadio2(String selectRadio2) {
		this.selectRadio2 = selectRadio2;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public Integer getFaqId() {
		return faqId;
	}
	public void setFaqId(Integer faqId) {
		if(faqId != null)
			this.faqId = faqId;
	}
	public Integer getFaqOrder() {
		return faqOrder;
	}
	public void setFaqOrder(Integer faqOrder) {
		this.faqOrder = faqOrder;
	}
	public Integer getHitsCnt() {
		return hitsCnt;
	}
	public void setHitsCnt(Integer hitsCnt) {
		this.hitsCnt = hitsCnt;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}





	


	
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
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public Integer getUniversityId() {
		return universityId;
	} 
	public void setUniversityId(Integer universityId) {
		if(universityId != null)
			this.universityId = universityId;
	}
}
