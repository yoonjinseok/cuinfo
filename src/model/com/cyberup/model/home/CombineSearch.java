package com.cyberup.model.home;

import java.util.Date;

import org.springframework.ui.ModelMap;

import com.cyberup.framework.model.PagingModel;

public class CombineSearch extends PagingModel {

	private String[] headerTextArr;
	
	public String[] getHeaderTextArr() {
		return headerTextArr;
	}

	public void setHeaderTextArr(String[] headerTextArr) {
		this.headerTextArr = headerTextArr;
	}
	
	

	private Integer id = 0;
	private Integer courseId = 0;
	private Integer searchGubn = 0;
	
	private String  courseIdentifier = "";
	private String  title = "";
	private String  mainTitle = "";
	private String  content = "";
	private String  keyword = "";
	
	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}



	private Integer recNum2 = 0;
	private Integer totalCnt2 = 0;
	private Integer showCnt2 = 10;
	private Integer currPage2 = 1;
	
	private Integer clicksCnt = 0;
	
	private String  description ="";
	private String  credit="";
	private String  termSemester="";
	private String  deptName="";
	
	private String subject = "";
	private String url = "";
	private String source = "";
	private String register = "";
	private String baseUrl = "";
	private String type = "";
	private String section = "";
	
	private Integer departmentId = 0;
	private String publicYn = "";
	
	private String sort 	= "";
	private String order 	= "";
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTermSemester() {
		return termSemester;
	}

	public void setTermSemester(String termSemester) {
		this.termSemester = termSemester;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getClicksCnt() {
		return clicksCnt;
	}

	public void setClicksCnt(Integer clicksCnt) {
		if(clicksCnt!=null)
			this.clicksCnt = clicksCnt;
	}

	public final static String CURRENT_PAGE2 = "currPage2";
	public final static String SHOW_CNT2 = "showCnt2";
	public final static String TOTAL_PAGE2 = "totalPage2";
	public final static String TOTAL_CNT2 = "totalCnt2";
	
	public static void mappPages2(ModelMap modelMap, Integer currPage, Integer showCnt, CombineSearch combineSearch)
	{
		modelMap.addAttribute(CURRENT_PAGE2, currPage);
		modelMap.addAttribute(SHOW_CNT2, showCnt);
		modelMap.addAttribute(TOTAL_PAGE2, combineSearch.getTotalCnt2() / showCnt + 1);
		modelMap.addAttribute(TOTAL_CNT2, combineSearch.getTotalCnt2());
	}

	private String  searchDt = "";
	private Integer searchCnt = 1;
	
	private String univName = "";
	private Integer univId = 0;
	private String contName = "";
	private String department = "";
	
	private String manager = "";
	
	
	
	
	
	
	
	public Integer getUnivId() {
		return univId;
	}

	public void setUnivId(Integer univId) {
		if(univId != null)
			this.univId = univId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getSearchDt() {
		return searchDt;
	}

	public void setSearchDt(String searchDt) {
		this.searchDt = searchDt;
	}

	public Integer getSearchCnt() {
		return searchCnt;
	}

	public void setSearchCnt(Integer searchCnt) {
		if(searchCnt != null)
			this.searchCnt = searchCnt;
	}

	public static String getCurrentPage2() {
		return CURRENT_PAGE2;
	}

	public static String getTotalPage2() {
		return TOTAL_PAGE2;
	}

	public Integer getRecNum2() {
		return recNum2;
	}

	public void setRecNum2(Integer recNum2) {
		if(recNum2 != null)
			this.recNum2 = recNum2;
	}

	public Integer getTotalCnt2() {
		return totalCnt2;
	}

	public void setTotalCnt2(Integer totalCnt2) {
		if(totalCnt2 != null)
			this.totalCnt2 = totalCnt2;
	}

	public Integer getShowCnt2() {
		return showCnt2;
	}

	public void setShowCnt2(Integer showCnt2) {
		if(showCnt2 != null)
			this.showCnt2 = showCnt2;
	}

	public Integer getCurrPage2() {
		return currPage2;
	}

	public void setCurrPage2(Integer currPage2) {
		if(currPage2 != null)
			this.currPage2 = currPage2;
	}

	/*
	 * 1:대학게시판, 2:게시판, 3:FAQ
	 * */
	private String  gubn = "";
	
	private String  searchText = "";
	private String  headerText = "";
	
	private String  headerText1 = "";
	private String  headerText2 = "";
	private String  headerText3 = "";

	public String getHeaderText1() {
		return headerText1;
	}

	public void setHeaderText1(String headerText1) {
		this.headerText1 = headerText1;
	}

	public String getHeaderText2() {
		return headerText2;
	}

	public void setHeaderText2(String headerText2) {
		this.headerText2 = headerText2;
	}

	public String getHeaderText3() {
		return headerText3;
	}

	public void setHeaderText3(String headerText3) {
		this.headerText3 = headerText3;
	}



	private Date regDate;

	
	
	
	public Integer getSearchGubn() {
		return searchGubn;
	}

	public void setSearchGubn(Integer searchGubn) {
		if(searchGubn != null)
			this.searchGubn = searchGubn;
	}

	public String getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String headerText) {
		this.headerText = headerText;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if(id != null)
			this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getGubn() {
		return gubn;
	}

	public void setGubn(String gubn) {
		this.gubn = gubn;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getPublicYn() {
		return publicYn;
	}

	public void setPublicYn(String publicYn) {
		this.publicYn = publicYn;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	
	
	
	
}
