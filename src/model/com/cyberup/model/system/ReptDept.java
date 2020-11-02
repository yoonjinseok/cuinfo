package com.cyberup.model.system;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class ReptDept  extends PagingModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3690755745139878777L;
	private String deptId = "";
	private String  deptName = "";
	private String classifyId = "";
	private String classifyName = "";
	private String  classifyDesc = "";
	private Integer deptOrder = 0;
	private String  useYn = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;
	private Integer deptLinkCnt = 0;
	private Integer clicksCnt = 0;
	
	private String searchCon1="";
	private String searchCon2="";
	private String searchCon3="";
		
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
	public String getSearchCon3() {
		return searchCon3;
	}
	public void setSearchCon3(String searchCon3) {
		this.searchCon3 = searchCon3;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getClassifyDesc() {
		return classifyDesc;
	}
	public void setClassifyDesc(String classifyDesc) {
		this.classifyDesc = classifyDesc;
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
	public Integer getDeptOrder() {
		return deptOrder;
	}
	public void setDeptOrder(Integer deptOrder) {
		if(deptOrder != null)
			this.deptOrder = deptOrder;
	}
	public Integer getDeptLinkCnt() {
		return deptLinkCnt;
	}
	public void setDeptLinkCnt(Integer deptLinkCnt) {
		if(deptLinkCnt != null)
			this.deptLinkCnt = deptLinkCnt;
	}
}
