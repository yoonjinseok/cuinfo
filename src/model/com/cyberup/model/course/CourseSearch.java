package com.cyberup.model.course;

import java.util.Date;

import com.cyberup.framework.model.PagingModel;

/**
 * @author Administrator
 *
 */
public class CourseSearch extends PagingModel  {
	private static final long serialVersionUID = -2224769739210613913L;
	
	private String[] courseIds;
	private String rights = "";
	private String language = "";
	private String manager = "";
	private String prevuri = "";
	private String prevthumbnail = "";
	private String isPrev = "";
	private Integer gradYear = 0;
	private Integer gradSemester = 0;
	private String[] svcStatuses;
	private String svcStatusAll = "";
	private String delYn = "N";
	private String modStartDate = "";
	private String modEndDate = "";
	private String deletor = "";
	private Date delDate;
	private String isLock = "N";
	private String isTemp = "N";
	private String planLocation = "";
	private String syllabusType = "";
	private String subtitle = "";
	private String assessment = "";
	
	private Integer publicCurrPage = 1;
	
	private String univSampleLink = "";
	private String isDetail = "N";
	private Integer mod = 0;
	private Integer id1 = 0;
	private Integer id2 = 0;
	private Integer id3 = 0;
	private Integer logoUpfileGid = 0;
	private Integer startCount = 0;
	private String  thumbNailUri = "";
	private String  thumbNailUriYN = "";
	private String  univdeptId = "";
	private String 	univdeptName = "";
	private Integer universityId = 0;
	private String 	deptId = "";
	private String 	univId = "";
	private String 	univdeptDesc = "";
	private String 	useYn = "";
	private String 	register = "";
	private Date 	regDate;
	private String 	modifier = "";
	private String 	modDate = "";
	private String 	deptName = "";
	private Integer classifyId = 0;
	private Integer classifyId2 = 9999;
	private String 	classifyDesc = "";
	private String 	deptOrder = "";
	private String 	classifyName = "";
	private String 	classifyOrder = "";
	private Integer cnt = 0;
	private Integer rn = 0;
	private Integer rn1 = 0;
	private Integer totalCnt = 0;
	
	private String 	yearName = "";
	
	private String 	gubn1 = "";
	private String 	gubn2 = "";
	
	
	
	public String getUnivId() {
		return univId;
	}

	public void setUnivId(String univId) {
		this.univId = univId;
	}

	public String getGubn1() {
		return gubn1;
	}

	public void setGubn1(String gubn1) {
		this.gubn1 = gubn1;
	}

	public String getGubn2() {
		return gubn2;
	}

	public void setGubn2(String gubn2) {
		this.gubn2 = gubn2;
	}

	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}

	public Integer getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(Integer totalCnt) {
		if(totalCnt != null)
			this.totalCnt = totalCnt;
	}

	private Integer	courseId = 0;
	private String 	courseIdentifier = "";
	private String 	publicYn = "";
	private String 	title = "";
	private String 	keyword = "";
	private String 	departmentId = "";
	private String 	department = "";
	private Integer	termYear = 0;
	private String 	termSemester = "";
	private String 	svcStart = "";
	private String 	svcEnd = "";
	private String 	svcStatus = "";
	private String 	statusMemo = "";
	private String 	prepublicYn = "";
	private String 	preStatus = "";
	
	private Integer techId = 0;
	private Integer lectureId = 0;
	private String 	resourceYype = "";
	private String 	format = "";
	private String 	techSize = "";
	private String 	location = "";
	private String 	duration = "";
	
	private Integer	contributorId = 0;
	private String 	contIdentifier = "";
	private String 	contRole = "";
	private String 	contName = "";
	
	private String 	description = "";
	private String 	secdescription = "";
	private String 	mainTitle = "";
	private String 	subTitle = "";
	private String 	univName = "";
	private Integer recNum = 0;
	private String credit = "";
	private Integer clicksCnt = 0;
	
	private String 	grad = "";
	private String 	attfileId = "";
	private String 	attfile1 = "";
	private String 	attfile2 = "";
	private String 	universityName = "";
	
	private Integer orders = 0;
	private Integer groups = 0;
	private String type = "";
	private String contributor = "";
	private String data = "";
	private String secsubtitle = "";
	private String overYn = "";
	private String movLocation = "";
	
	private String attfileIdTitle1 = "";
	private String attfileIdTitle2 = "";
	private String resourceType = "";
	private Integer select = 0;
	private String  text = "";
	private String  hidetext = "";
	private String 	sdate = "";
	private String 	edate = "";
	
	private String  text1 = "";
	private String  text2 = "";
	private String  text3 = "";
	
	private String  select1 = "title";
	private String  select2 = "manager";
	private String  select3 = "univName";
	
	private String 	terms1 = "";
	private String 	terms2 = "";
	private String 	terms3 = "";
	
	private String 	odby = "desc";
	private String 	odbykey = "regdate";
	
	private Integer checkbox1 = 0;
	private Integer checkbox2 = 0;
	private Integer checkbox3 = 0;
	private Integer checkbox5 = 0;
	private Integer dataCnt = 0;
	
	//maintitle
	private String text01 = "";
	private String text02 = "";
	private String text03 = "";
	private String text04 = "";
	private String text05 = "";
	private String text06 = "";
	private String text07 = "";
	private String text08 = "";
	private String text09 = "";
	private String text10 = "";

	//description
	private String text11 = "";
	private String text12 = "";
	private String text13 = "";
	private String text14 = "";
	private String text15 = "";
	private String text16 = "";
	private String text17 = "";
	private String text18 = "";
	private String text19 = "";
	private String text20 = "";
	
	//keyword
	private String text21 = "";
	private String text22 = "";
	private String text23 = "";
	private String text24 = "";
	private String text25 = "";
	private String text26 = "";
	private String text27 = "";
	private String text28 = "";
	private String text29 = "";
	private String text30 = "";
	
	private String linkurl = "";
	private String univDeptUrl = "";
	
	public String getUnivDeptUrl() {
		return univDeptUrl;
	}

	public void setUnivDeptUrl(String univDeptUrl) {
		this.univDeptUrl = univDeptUrl;
	}

	private Integer currPageForPublic = 1;
	
	
	
	public Integer getCurrPageForPublic() {
		return currPageForPublic;
	}

	public void setCurrPageForPublic(Integer currPageForPublic) {
		if(currPageForPublic != null)
			this.currPageForPublic = currPageForPublic;
	}

	public String getMovLocation() {
		return movLocation;
	}

	public void setMovLocation(String movLocation) {
		this.movLocation = movLocation;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	public Integer getPublicCurrPage() {
		return publicCurrPage;
	}

	public void setPublicCurrPage(Integer publicCurrPage) {
		if(publicCurrPage != null)
			this.publicCurrPage = publicCurrPage;
	}
	
	public String getUnivSampleLink() {
		return univSampleLink;
	}

	public void setUnivSampleLink(String univSampleLink) {
		this.univSampleLink = univSampleLink;
	}

	
	
	public String getIsDetail() {
		return isDetail;
	}

	public void setIsDetail(String isDetail) {
		if(isDetail != null)
			this.isDetail = isDetail;
	}
	
	private String  univHomePage = "";
	
	public String getUnivHomePage() {
		return univHomePage;
	}

	public void setUnivHomePage(String univHomePage) {
		this.univHomePage = univHomePage;
	}

	private String  univdeptlink = "";

	public String getUnivdeptlink() {
		return univdeptlink;
	}

	public void setUnivdeptlink(String univdeptlink) {
		this.univdeptlink = univdeptlink;
	}
	
	public Integer getStartCount() {
		return startCount;
	}

	public void setStartCount(Integer startCount) {
		this.startCount = startCount;
	}

	public Integer getLogoUpfileGid() {
		return logoUpfileGid;
	}

	public void setLogoUpfileGid(Integer logoUpfileGid) {
		if(logoUpfileGid != null)
			this.logoUpfileGid = logoUpfileGid;
	}

	public String getThumbNailUriYN() {
		return thumbNailUriYN;
	}

	public void setThumbNailUriYN(String thumbNailUriYN) {
		this.thumbNailUriYN = thumbNailUriYN;
	}

	public String getThumbNailUri() {
		return thumbNailUri;
	}

	public void setThumbNailUri(String thumbNailUri) {
		this.thumbNailUri = thumbNailUri;
	}

	public Integer getId3() {
		return id3;
	}

	public void setId3(Integer id3) {
		if(id3 != null)
			this.id3 = id3;
	}

	public Integer getId1() {
		return id1;
	}

	public void setId1(Integer id1) {
		if(id1 != null)
			this.id1 = id1;
	}

	public Integer getId2() {
		return id2;
	}

	public void setId2(Integer id2) {
		if(id2 != null)
			this.id2 = id2;
	}

	public Integer getMod() {
		return mod;
	}

	public void setMod(Integer mod) {
		if(mod != null)
			this.mod = mod;
	}
	
	private String regDt = "";
	
	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	
	

	//검색조건으로 사용되는 변수들

	public Integer getDataCnt() {
		return dataCnt;
	}

	public void setDataCnt(Integer dataCnt) {
		if(dataCnt != null)
			this.dataCnt = dataCnt;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getAttfileIdTitle1() {
		return attfileIdTitle1;
	}

	public void setAttfileIdTitle1(String attfileIdTitle1) {
		this.attfileIdTitle1 = attfileIdTitle1;
	}

	public String getAttfileIdTitle2() {
		return attfileIdTitle2;
	}

	public void setAttfileIdTitle2(String attfileIdTitle2) {
		this.attfileIdTitle2 = attfileIdTitle2;
	}

	public String getAttfile1() {
		return attfile1;
	}

	public void setAttfile1(String attfile1) {
		this.attfile1 = attfile1;
	}

	public String getAttfile2() {
		return attfile2;
	}

	public void setAttfile2(String attfile2) {
		this.attfile2 = attfile2;
	}

	private String  gubunId = "";
	
	/*
	 * 학교목록 조회 옵션.
	 * 1 : 학교별 검색
	 * 2 : 학교별 맛보기 강의
	 * 3 : 학교별 추천강의
	 * */
	private Integer univListType = 0;
	
	
	/* 1: 공개강의
	 * 2: 맛보기강의
	 * 3: 과거 강의정보 보기 
	 * */
	private Integer radio = 0;
	
	/* 1: 강의자명
	 * 2: 교수자명
	 * 3: 학교명
	 * 4: 강의설명
	 * 5: 키워드
	 * */
	
	
	public String getHidetext() {
		return hidetext;
	}

	public void setHidetext(String hidetext) {
		this.hidetext = hidetext;
	}
	
	
	//검색구분 = 1:강의명검색, 2:학과분야별검색, 3:학교별검색
	private String pageType = "1";
	
	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		if(pageType != null)
			this.pageType = pageType;
	}

	public Integer getCheckbox5() {
		return checkbox5;
	}

	public void setCheckbox5(Integer checkbox5) {
		if(checkbox5 != null)
			this.checkbox5 = checkbox5;
	}

	public String getOverYn() {
		return overYn;
	}

	public void setOverYn(String overYn) {
		this.overYn = overYn;
	}	
	
	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		if(orders != null)
			this.orders = orders;
	}

	public Integer getGroups() {
		return groups;
	}

	public void setGroups(Integer groups) {
		if(groups != null)
			this.groups = groups;
	}
	private String  url = "";
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCheckbox1() {
		return checkbox1;
	}

	public void setCheckbox1(Integer checkbox1) {
		if(checkbox1 != null);
			this.checkbox1 = checkbox1;
	}

	public Integer getCheckbox2() {
		return checkbox2;
	}

	public void setCheckbox2(Integer checkbox2) {
		if(checkbox2 != null)
			this.checkbox2 = checkbox2;
	}

	public Integer getCheckbox3() {
		return checkbox3;
	}

	public void setCheckbox3(Integer checkbox3) {
		if(checkbox3 != null)
			this.checkbox3 = checkbox3;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		if(text1.indexOf("<") < 0 && text1.indexOf(">") < 0)
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		if(text2.indexOf("<") < 0 && text2.indexOf(">") < 0)
		this.text2 = text2;
	}

	public String getText3() {
		return text3;
	}

	public void setText3(String text3) {
		if(text3.indexOf("<") < 0 && text3.indexOf(">") < 0)
		this.text3 = text3;
	}


	public String getSelect1() {
		return select1;
	}

	public void setSelect1(String select1) {
		if(select1 != null)
			this.select1 = select1;
	}

	public String getSelect2() {
		return select2;
	}

	public void setSelect2(String select2) {
		if(select2 != null)
			this.select2 = select2;
	}

	public String getSelect3() {
		return select3;
	}

	public void setSelect3(String select3) {
		if(select3 != null)
			this.select3 = select3;
	}

	public String getTerms1() {
		return terms1;
	}

	public void setTerms1(String terms1) {
		this.terms1 = terms1;
	}

	public String getTerms2() {
		return terms2;
	}

	public void setTerms2(String terms2) {
		this.terms2 = terms2;
	}

	public String getTerms3() {
		return terms3;
	}

	public void setTerms3(String terms3) {
		this.terms3 = terms3;
	}

	public String getOdby() {
		return odby;
	}

	public void setOdby(String odby) {
		this.odby = odby;
	}

	public String getOdbykey() {
		return odbykey;
	}

	public void setOdbykey(String odbykey) {
		if(odbykey != null)
			this.odbykey = odbykey;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if(text.indexOf("<") < 0 && text.indexOf(">") < 0)
		this.text = text;
	}

	public Integer getSelect() {
		return select;
	}

	public void setSelect(Integer select) {
		if(select != null)
			this.select = select;
	}

	public Integer getRadio() {
		return radio;
	}

	public void setRadio(Integer radio) {
		if(radio != null)
			this.radio = radio;
	}

	public String getGubunId() {
		return gubunId;
	}

	public void setGubunId(String gubunId) {
		this.gubunId = gubunId;
	}
	
	public Integer getUnivListType() {
		return univListType;
	}

	public void setUnivListType(Integer univListType) {
		if(univListType != null)
			this.univListType = univListType;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSecsubtitle() {
		return secsubtitle;
	}

	public void setSecsubtitle(String secsubtitle) {
		this.secsubtitle = secsubtitle;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getAttfileId() {
		return attfileId;
	}

	public void setAttfileId(String attfileId) {
		this.attfileId = attfileId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSecdescription() {
		return secdescription;
	}

	public void setSecdescription(String secdescription) {
		this.secdescription = secdescription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getClicksCnt() {
		return clicksCnt;
	}

	public void setClicksCnt(Integer clicksCnt) {
		if(clicksCnt != null)
			this.clicksCnt = clicksCnt;
	}

	
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public Integer getRecNum() {
		return recNum;
	}
	public void setRecNum(Integer recNum) {
		if(recNum != null)
			this.recNum = recNum;
	}
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public Integer getContributorId() {
		return contributorId;
	}
	public void setContributorId(Integer contributorId) {
		if(contributorId != null)
			this.contributorId = contributorId;
	}
	public String getContIdentifier() {
		return contIdentifier;
	}
	public void setContIdentifier(String contIdentifier) {
		this.contIdentifier = contIdentifier;
	}
	public String getContRole() {
		return contRole;
	}
	public void setContRole(String contRole) {
		this.contRole = contRole;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
	public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Integer getTechId() {
		return techId;
	}
	public void setTechId(Integer techId) {
		if(techId != null)
			this.techId = techId;
	}
	public Integer getLectureId() {
		return lectureId;
	}
	public void setLectureId(Integer lectureId) {
		if(lectureId != null)
			this.lectureId = lectureId;
	}
	public String getResourceYype() {
		return resourceYype;
	}
	public void setResourceYype(String resourceYype) {
		this.resourceYype = resourceYype;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getTechSize() {
		return techSize;
	}
	public void setTechSize(String techSize) {
		this.techSize = techSize;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		if(courseId != null)
			this.courseId = courseId;
	}
	public String getCourseIdentifier() {
		return courseIdentifier;
	}
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier;
	}
	public String getPublicYn() {
		return publicYn;
	}
	public void setPublicYn(String publicYn) {
		this.publicYn = publicYn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getTermYear() {
		return termYear;
	}
	public void setTermYear(Integer termYear) {
		if(termYear != null)
			this.termYear = termYear;
	}
	public String getTermSemester() {
		return termSemester;
	}
	public void setTermSemester(String termSemester) {
		this.termSemester = termSemester;
	}
	public String getSvcStart() {
		return svcStart;
	}
	public void setSvcStart(String svcStart) {
		this.svcStart = svcStart;
	}
	public String getSvcEnd() {
		return svcEnd;
	}
	public void setSvcEnd(String svcEnd) {
		this.svcEnd = svcEnd;
	}
	public String getSvcStatus() {
		return svcStatus;
	}
	public void setSvcStatus(String svcStatus) {
		this.svcStatus = svcStatus;
	}
	public String getStatusMemo() {
		return statusMemo;
	}
	public void setStatusMemo(String statusMemo) {
		this.statusMemo = statusMemo;
	}
	public String getPrepublicYn() {
		return prepublicYn;
	}
	public void setPrepublicYn(String prepublicYn) {
		this.prepublicYn = prepublicYn;
	}
	public String getPreStatus() {
		return preStatus;
	}
	public void setPreStatus(String preStatus) {
		this.preStatus = preStatus;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		if(cnt != null)
			this.cnt = cnt;
	}
	public String getUnivdeptId() {
		return univdeptId;
	}
	public void setUnivdeptId(String univdeptId) {
		this.univdeptId = univdeptId;
	}
	public String getUnivdeptName() {
		return univdeptName;
	}
	public void setUnivdeptName(String univdeptName) {
		this.univdeptName = univdeptName;
	}
	public Integer getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Integer universityId) {
		if(universityId != null)
			this.universityId = universityId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getUnivdeptDesc() {
		return univdeptDesc;
	}
	public void setUnivdeptDesc(String univdeptDesc) {
		this.univdeptDesc = univdeptDesc;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
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
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(Integer classifyId) {
		if(classifyId != null)
			this.classifyId = classifyId;
	}
	public Integer getClassifyId2() {
		return classifyId2;
	}

	public void setClassifyId2(Integer classifyId2) {
		this.classifyId2 = classifyId2;
	}

	public String getClassifyDesc() {
		return classifyDesc;
	}
	public void setClassifyDesc(String classifyDesc) {
		this.classifyDesc = classifyDesc;
	}
	public String getDeptOrder() {
		return deptOrder;
	}
	public void setDeptOrder(String deptOrder) {
		this.deptOrder = deptOrder;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getClassifyOrder() {
		return classifyOrder;
	}
	public void setClassifyOrder(String classifyOrder) {
		this.classifyOrder = classifyOrder;
	}
	

	
	public String getText11() {
		return text11;
	}

	public void setText11(String text11) {
		this.text11 = text11;
	}

	public String getText12() {
		return text12;
	}

	public void setText12(String text12) {
		this.text12 = text12;
	}

	public String getText13() {
		return text13;
	}

	public void setText13(String text13) {
		this.text13 = text13;
	}

	public String getText14() {
		return text14;
	}

	public void setText14(String text14) {
		this.text14 = text14;
	}

	public String getText15() {
		return text15;
	}

	public void setText15(String text15) {
		this.text15 = text15;
	}

	public String getText16() {
		return text16;
	}

	public void setText16(String text16) {
		this.text16 = text16;
	}

	public String getText17() {
		return text17;
	}

	public void setText17(String text17) {
		this.text17 = text17;
	}

	public String getText18() {
		return text18;
	}

	public void setText18(String text18) {
		this.text18 = text18;
	}

	public String getText19() {
		return text19;
	}

	public void setText19(String text19) {
		this.text19 = text19;
	}

	public String getText20() {
		return text20;
	}

	public void setText20(String text20) {
		this.text20 = text20;
	}

	public String getText21() {
		return text21;
	}

	public void setText21(String text21) {
		this.text21 = text21;
	}

	public String getText22() {
		return text22;
	}

	public void setText22(String text22) {
		this.text22 = text22;
	}

	public String getText23() {
		return text23;
	}

	public void setText23(String text23) {
		this.text23 = text23;
	}

	public String getText24() {
		return text24;
	}

	public void setText24(String text24) {
		this.text24 = text24;
	}

	public String getText25() {
		return text25;
	}

	public void setText25(String text25) {
		this.text25 = text25;
	}

	public String getText26() {
		return text26;
	}

	public void setText26(String text26) {
		this.text26 = text26;
	}

	public String getText27() {
		return text27;
	}

	public void setText27(String text27) {
		this.text27 = text27;
	}

	public String getText28() {
		return text28;
	}

	public void setText28(String text28) {
		this.text28 = text28;
	}

	public String getText29() {
		return text29;
	}

	public void setText29(String text29) {
		this.text29 = text29;
	}

	public String getText30() {
		return text30;
	}

	public void setText30(String text30) {
		this.text30 = text30;
	}

	public String getText01() {
		return text01;
	}

	public void setText01(String text01) {
		this.text01 = text01;
	}

	public String getText02() {
		return text02;
	}

	public void setText02(String text02) {
		this.text02 = text02;
	}

	public String getText03() {
		return text03;
	}

	public void setText03(String text03) {
		this.text03 = text03;
	}

	public String getText04() {
		return text04;
	}

	public void setText04(String text04) {
		this.text04 = text04;
	}

	public String getText05() {
		return text05;
	}

	public void setText05(String text05) {
		this.text05 = text05;
	}

	public String getText06() {
		return text06;
	}

	public void setText06(String text06) {
		this.text06 = text06;
	}

	public String getText07() {
		return text07;
	}

	public void setText07(String text07) {
		this.text07 = text07;
	}

	public String getText08() {
		return text08;
	}

	public void setText08(String text08) {
		this.text08 = text08;
	}

	public String getText09() {
		return text09;
	}

	public void setText09(String text09) {
		this.text09 = text09;
	}

	public String getText10() {
		return text10;
	}

	public void setText10(String text10) {
		this.text10 = text10;
	}

	public String[] getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(String[] courseIds) {
		this.courseIds = courseIds;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
		this.gradYear = gradYear;
	}

	public Integer getGradSemester() {
		return gradSemester;
	}

	public void setGradSemester(Integer gradSemester) {
		this.gradSemester = gradSemester;
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

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
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

	public void setSyllabusType(String syllabusType) {
		this.syllabusType = syllabusType;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		if(rn != null)
			this.rn = rn;
	}

	public Integer getRn1() {
		return rn1;
	}

	public void setRn1(Integer rn1) {
		if(rn1 != null)
			this.rn1 = rn1;
	}
	
	
	
}
