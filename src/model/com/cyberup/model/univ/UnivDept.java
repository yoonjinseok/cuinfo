package com.cyberup.model.univ;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class UnivDept  extends PagingModel  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4166508513574759721L;
	private String univDeptId = "";
	private String  univDeptName = "";
	private Integer universityId = 0;
	private String  universityName = "";
	private String deptId = "";
	private String  deptName = "";
	private String classifyId = "";
	private String  classifyName = "";
	private String univDeptDesc = "";
	private String useYn = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;
	private Integer localId = 0;
	private Integer clicksCnt = 0;
	
	private String  deptAllName = "";
	
	private String searchCon1 = "";
	private String searchCon2 = "";
	private String searchCon3 = "";

	private String popularYn="";
	private String recommendYn="";
	
	public String getSearchCon3() {
		return searchCon3;
	}
	public void setSearchCon3(String searchCon3) {
		this.searchCon3 = searchCon3;
	}
	public String getDeptAllName() {
		return deptAllName;
	}
	public void setDeptAllName(String deptAllName) {
		this.deptAllName = deptAllName;
	}
	public Integer getClicksCnt() {
		return clicksCnt;
	}
	public void setClicksCnt(Integer clicksCnt) {
		if(clicksCnt != null)
			this.clicksCnt = clicksCnt;
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
	public String getUnivDeptName() {
		return univDeptName;
	}
	public void setUnivDeptName(String univDeptName) {
		this.univDeptName = univDeptName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getUnivDeptDesc() {
		return univDeptDesc;
	}
	public void setUnivDeptDesc(String univDeptDesc) {
		this.univDeptDesc = univDeptDesc;
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
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getUnivDeptId() {
		return univDeptId;
	}
	public void setUnivDeptId(String univDeptId) {
			this.univDeptId = univDeptId;
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
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
			this.classifyId = classifyId;
	}
	public Integer getLocalId() {
		return localId;
	}
	public void setLocalId(Integer localId) {
		if(localId != null)
			this.localId = localId;
	}
	public String getPopularYn() {
		return popularYn;
	}
	public void setPopularYn(String popularYn) {
		this.popularYn = popularYn;
	}
	public String getRecommendYn() {
		return recommendYn;
	}
	public void setRecommendYn(String recommendYn) {
		this.recommendYn = recommendYn;
	}
	
}
