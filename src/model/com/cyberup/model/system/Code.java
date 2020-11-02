package com.cyberup.model.system;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class Code  extends PagingModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770041900075663256L;
	private Integer codeId = 0;
	private String codeGroup = "";
	private String codeGroupName = "";
	private String codeName = "";
	private String codeValue = "";
	private Integer codeOrder = 0;
	private String codeDesc = "";
	private String useYn = "";
	private String codeRegister = "";
	private Date codeRegdate;
	private String codeModifier = "";
	private Date codeModdate;
	
	private Integer groupOrder = 0;
	private String groupOrderName = "";
	
	
	public Integer getGroupOrder() {
		return groupOrder;
	}
	public void setGroupOrder(Integer groupOrder) {
		if(groupOrder != null)
			this.groupOrder = groupOrder;
	}
	public String getGroupOrderName() {
		return groupOrderName;
	}
	public void setGroupOrderName(String groupOrderName) {
		this.groupOrderName = groupOrderName;
	}
	public Integer getCodeId(){
		return this.codeId;
	}
	public void setCodeId(Integer codeId){
		if(codeId != null)
			this.codeId = codeId;
	}
	public String getCodeGroup(){
		return this.codeGroup;
	}
	public void setCodeGroup(String codeGroup){
		this.codeGroup = codeGroup;
	}
	public String getCodeGroupName() {
		return codeGroupName;
	}
	public void setCodeGroupName(String codeGroupName) {
		this.codeGroupName = codeGroupName;
	}
	public String getCodeName(){
		return this.codeName;
	}
	public void setCodeName(String codeName){
		this.codeName = codeName;
	}
	public String getCodeValue(){
		return this.codeValue;
	}
	public void setCodeValue(String codeValue){
		this.codeValue = codeValue;
	}
	public Integer getCodeOrder(){
		return this.codeOrder;
	}
	public void setCodeOrder(Integer codeOrder){
		if(codeOrder != null)
			this.codeOrder = codeOrder;
	}
	public String getCodeDesc(){
		return this.codeDesc;
	}
	public void setCodeDesc(String codeDesc){
		this.codeDesc = codeDesc;
	}
	public String getUseYn(){
		return this.useYn;
	}
	public void setUseYn(String useYn){
		this.useYn = useYn;
	}
	public String getCodeRegister(){
		return this.codeRegister;
	}
	public void setCodeRegister(String codeRegister){
		this.codeRegister = codeRegister;
	}
	public Date getCodeRegdate(){
		return this.codeRegdate;
	}
	public void setCodeRegdate(Date codeRegdate){
		this.codeRegdate = codeRegdate;
	}
	public String getCodeModifier(){
		return this.codeModifier;
	}
	public void setCodeModifier(String codeModifier){
		this.codeModifier = codeModifier;
	}
	public Date getCodeModdate(){
		return this.codeModdate;
	}
	public void setCodeModdate(Date codeModdate){
		this.codeModdate = codeModdate;
	}
}
