package com.cyberup.model.system;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class ReptClassification  extends PagingModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1083071228031233871L;
	private String classifyId = "";
	private String  classifyName = "";
	private Integer classifyOrder = 0;
	private String  useYn = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;
	private String deptNameList = "";
		
	private String searchCon1="";
	private String searchCon2="";
	private String searchCon3="";
	
	
	public String getDeptNameList() {
		return deptNameList;
	}
	public void setDeptNameList(String deptNameList) {
		this.deptNameList = deptNameList;
	}
	public String getSearchCon3() {
		return searchCon3;
	}
	public void setSearchCon3(String searchCon3) {
		this.searchCon3 = searchCon3;
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
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
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
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
			this.classifyId = classifyId;
	}
	public Integer getClassifyOrder() {
		return classifyOrder;
	}
	public void setClassifyOrder(Integer classifyOrder) {
		if(classifyOrder != null)
			this.classifyOrder = classifyOrder;
	}
	
	
}
