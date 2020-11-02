package com.cyberup.model.course;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jdom.Element;

public class Course extends MetaData {
	private Logger logger = Logger.getLogger(Course.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 4030850461147355348L;
	
	private String filepath = "";
	private File file = null;
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private Integer courseId = 0;
	private String[] courseIds;
	private String courseIdentifier = "";
	private Integer universityId = 0;
	private String universityName = "";
	private String publicYn = "";
	private String type = "";
	private String rights = "";
	private String language = "";
	private String manager = "";
	private String title = "";
	private String keyword = "";
	private String prevuri = "";
	private String prevthumbnail = "";
	private String isPrev = "";
	private String departmentId = "";
	private String department = "";
	private Integer termYear = 0;
	private String termSemester = "";
	private Integer gradYear = 0;
	private Integer gradSemester = 0;
	private String svcStart = "";
	private String svcEnd = "";
	
	private String svcStatus = "";
	private String[] svcStatuses;
	private String svcStatusAll = "";
	
	private String delYn = "N";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;
	private String regStartDate = "";
	private String regEndDate = "";
	private String modStartDate = "";
	private String modEndDate = "";
	private String deletor = "";
	private Date delDate;
	private String isLock = "N";
	private String isTemp = "N";
	
	private String planLocation = "";
	private String syllabusType = "";
	private String subtitle = "";
	private String credit = "";
	private String assessment = "";
	private String description = "";
	
	public String getRegStartDate() {
		return regStartDate;
	}

	public void setRegStartDate(String regStartDate) {
		this.regStartDate = regStartDate;
	}

	public String getRegEndDate() {
		return regEndDate;
	}

	public void setRegEndDate(String regEndDate) {
		this.regEndDate = regEndDate;
	}

	private List<Lecture> lectureList = new ArrayList();
	
	private String termYearStart = "";
	private String termYearEnd = "";
	
	private String searchField = "";
	private String searchValue = "";
	
	public void init(int universityId, String modifier)
	{
		this.universityId = universityId;
		this.svcStatus = CourseStatus.APPROVE.getValue();
		this.register = modifier;
		this.modifier = modifier;
	}
	
	public void checkStatus()
	{
		if(!isValid())
		{
			this.svcStatus = CourseStatus.READY.getValue();
			
			Logger.getLogger(this.getClass()).debug("course valid : " + isValid());
			
			return;
		}
			
		for(int i = 0; i < lectureList.size(); i++)
		{
			if(!lectureList.get(i).checkStatus())
			{
				this.svcStatus = CourseStatus.READY.getValue();
				
				Logger.getLogger(this.getClass()).debug("lectureList valid : " + lectureList.get(i).checkStatus());
				
				return;
			}
		}
		
		this.svcStatus = CourseStatus.APPROVE.getValue();
		
		Logger.getLogger(this.getClass()).debug("final meta valid : " + this.svcStatus);
	}
	
	public void mapping(MetaDic metaDic, Element element)
	{
		checkMata(metaDic, element);
		
		if(metaDic.getElement().equals("identifier"))
			this.courseIdentifier = element.getTextTrim();
		else if(metaDic.getElement().equals("grantAll"))
			this.publicYn = element.getTextTrim();
		else if(metaDic.getElement().equals("title"))
			this.title = element.getTextTrim();
		else if(metaDic.getElement().equals("keyword"))
		{
			if(StringUtils.isEmpty(element.getTextTrim()))
				element.setText(this.title);
			
			this.keyword = element.getTextTrim();
		}
		else if(metaDic.getElement().equals("departmentcode"))
			this.departmentId = element.getTextTrim();
		else if(metaDic.getElement().equals("department"))
			this.department = element.getTextTrim();
		else if(metaDic.getElement().equals("grad"))
		{
			try {
				this.gradYear = Integer.parseInt(element.getTextTrim());
			} catch (Exception e) {}
		}
		else if(metaDic.getElement().equals("gradth"))
		{
			try {
				this.gradSemester = Integer.parseInt(element.getTextTrim());
			} catch (Exception e) {}
		}
		else if(metaDic.getElement().equals("termyear"))
		{
			try {
				this.termYear = Integer.parseInt(element.getTextTrim());
			} catch (Exception e) {
				element.setText(String.valueOf(new Date().getYear() + 1900));
				this.termYear = Integer.parseInt(element.getTextTrim());
			}
		}
		else if(metaDic.getElement().equals("termth"))
		{
			this.termSemester = element.getTextTrim();
		}
		else if(metaDic.getElement().equals("startdate"))
			this.svcStart = getSvcDate(element.getTextTrim());
		else if(metaDic.getElement().equals("enddate"))
			this.svcEnd = getSvcDate(element.getTextTrim());
		else if(metaDic.getElement().equals("language"))
			this.language = element.getTextTrim().toUpperCase();
		else
		{
			try {
				Field clsField = this.getClass().getDeclaredField(metaDic.getElement());
				clsField.set(this, element.getTextTrim());
			} catch (Exception e) {
				if(!metaDic.getElement().equals("regDate")
						&& !metaDic.getElement().equals("modDate")
						&& !metaDic.getElement().equals("delDate"))
					logger.warn(metaDic.getElement() + "("+element.getTextTrim()+") => " +e.getMessage(), e);
			}
		}
	}
	
	private String getSvcDate(String date)
	{
		date = StringUtils.remove(date, "-");
		date = StringUtils.remove(date, "/");
		date = StringUtils.remove(date, ":");
		
		if(date.length() > 8)
			return date.substring(0, 8);
		else
			return date;
	}
	
	public Integer getCourseId(){
		return this.courseId;
	}
	public void setCourseId(Integer courseId){
		if(courseId != null)
			this.courseId = courseId;
	}

	public String[] getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(String[] courseIds) {
		this.courseIds = courseIds;
	}

	public String getCourseIdentifier(){
		return this.courseIdentifier;
	}
	public String getCourseIdentifierOfStrip()
	{
		return stripIdPrefix(this.courseIdentifier);
	}
	public void setCourseIdentifier(String courseIdentifier){
		this.courseIdentifier = courseIdentifier;
	}
	public Integer getUniversityId(){
		return this.universityId;
	}
	public void setUniversityId(Integer universityId){
		if(universityId != null)
			this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getPublicYn(){
		return this.publicYn;
	}
	public void setPublicYn(String publicYn){
		this.publicYn = publicYn;
	}
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getKeyword(){
		return this.keyword;
	}
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
	public String getDepartmentId(){
		return this.departmentId;
	}
	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}
	public String getDepartment(){
		return this.department;
	}
	public void setDepartment(String department){
		this.department = department;
	}
	public Integer getTermYear(){
		return this.termYear;
	}
	public String getTermYearName() {
		if(this.termYear > 0)
			return this.termYear + "년";
		else
			return "-";
	}
	public void setTermYear(Integer termYear){
		if(termYear != null)
			this.termYear = termYear;
	}
	public String getTermSemester(){
		return this.termSemester;
	}
	public String getTermSemesterName()
	{
		logger.debug("this.termSemester : |" + this.termSemester + "|");
		if(!StringUtils.isEmpty(this.termSemester))
			return SemesterType.parse(String.valueOf(Integer.parseInt(this.termSemester))).getName();
		else
			return "";
	}
	public void setTermSemester(String termSemester){
		this.termSemester = termSemester;
	}
	public String getSvcStart(){
		return this.svcStart;
	}
	public void setSvcStart(String svcStart){
		this.svcStart = svcStart;
	}
	public String getSvcEnd(){
		return this.svcEnd;
	}
	public void setSvcEnd(String svcEnd){
		this.svcEnd = svcEnd;
	}
	public String getSvcStatus(){
		return this.svcStatus;
	}
	public String getSvcStatusName()
	{
		if(!StringUtils.isEmpty(this.svcStatus))
			return CourseStatus.parse(this.svcStatus).getName();
		else
			return "";
	}
	public void setSvcStatus(String svcStatus){
		this.svcStatus = svcStatus;
	}
	public String[] getSvcStatuses() {
		return svcStatuses;
	}

	public void setSvcStatuses(String[] svcStatuses) {
		this.svcStatuses = svcStatuses;
	}

	public String getSvcStatusAll() {
		return svcStatusAll;
	}

	public void setSvcStatusAll(String svcStatusAll) {
		this.svcStatusAll = svcStatusAll;
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

	public String getModStartDate() {
		return modStartDate;
	}

	public void setModStartDate(String modStartDate) {
		this.modStartDate = modStartDate;
	}

	public String getModEndDate() {
		return modEndDate;
	}

	public void setModEndDate(String modEndDate) {
		this.modEndDate = modEndDate;
	}

	public List<Lecture> getLectureList() {
		return lectureList;
	}

	public void setLectureList(List<Lecture> lectureList) {
		this.lectureList = lectureList;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getLanguage() {
		return language;
	}
	public String getLanguageName()
	{
		if(!StringUtils.isEmpty(this.language))
			return LanguageType.parse(this.language).getName();
		else
			return "";
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTermYearStart() {
		return termYearStart;
	}

	public void setTermYearStart(String termYearStart) {
		this.termYearStart = termYearStart;
	}

	public String getTermYearEnd() {
		return termYearEnd;
	}

	public void setTermYearEnd(String termYearEnd) {
		this.termYearEnd = termYearEnd;
	}

	public String getType() {
		return type;
	}
	public String getTypeName()
	{
		if(!StringUtils.isEmpty(this.type))
			return CourseType.parse(this.type).getName();
		else
			return "";
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPrevuri() {
		return prevuri;
	}

	public void setPrevuri(String prevuri) {
		this.prevuri = prevuri;
	}

	public String getPrevthumbnail() {
		return prevthumbnail;
	}

	public void setPrevthumbnail(String prevthumbnail) {
		this.prevthumbnail = prevthumbnail;
	}

	public String getIsPrev() {
		return isPrev;
	}

	public void setIsPrev(String isPrev) {
		this.isPrev = isPrev;
	}

	public Integer getGradYear() {
		return gradYear;
	}

	public void setGradYear(Integer gradYear) {
		if(gradYear != null)
			this.gradYear = gradYear;
	}

	public Integer getGradSemester() {
		return gradSemester;
	}
	public String getGradSemesterName()
	{
		return SemesterType.parse(String.valueOf(this.gradSemester)).getName();
	}

	public void setGradSemester(Integer gradSemester) {
		if(gradSemester != null)
			this.gradSemester = gradSemester;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDeletor() {
		return deletor;
	}

	public void setDeletor(String deletor) {
		this.deletor = deletor;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	public String getIsTemp() {
		return isTemp;
	}

	public void setIsTemp(String isTemp) {
		this.isTemp = isTemp;
	}

	public String getPlanLocation() {
		return planLocation;
	}

	public void setPlanLocation(String planLocation) {
		this.planLocation = planLocation;
	}

	public String getSyllabusType() {
		return syllabusType;
	}
	public String getSyllabusPathType()
	{
		if(StringUtils.isEmpty(this.planLocation))
			return SyllabusPathType.URI.getValue();
		else if(!this.planLocation.startsWith("http://"))
			return SyllabusPathType.CONTENT.getValue();
		else 
			return SyllabusPathType.URI.getValue();	
	}

	public void setSyllabusType(String syllabusType) {
		this.syllabusType = syllabusType;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
