package com.cyberup.model.univ;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class AcademyinfoLink   extends PagingModel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5394860830480724977L;
	private Integer infoId = 0;
	private String infoName = "";
	private Integer infoGubunId = 0;
	private String infoGubunName = "";
	private String infoUrlpattern = "";
	private Integer infoOrder = 0;
	private String useYn = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;
	private String deadlinkErrCode = "";
	
	
	public String getDeadlinkErrCode() {
		return deadlinkErrCode;
	}
	public void setDeadlinkErrCode(String deadlinkErrCode) {
		this.deadlinkErrCode = deadlinkErrCode;
	}
	public String getInfoGubunName() {
		return infoGubunName;
	}
	public void setInfoGubunName(String infoGubunName) {
		this.infoGubunName = infoGubunName;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getInfoUrlpattern() {
		return infoUrlpattern;
	}
	public void setInfoUrlpattern(String infoUrlpattern) {
		this.infoUrlpattern = infoUrlpattern;
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
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		if(infoId != null)
			this.infoId = infoId;
	}
	public Integer getInfoGubunId() {
		return infoGubunId;
	}
	public void setInfoGubunId(Integer infoGubunId) {
		if(infoGubunId != null)
			this.infoGubunId = infoGubunId;
	}
	public Integer getInfoOrder() {
		return infoOrder;
	}
	public void setInfoOrder(Integer infoOrder) {
		if(infoOrder != null)
			this.infoOrder = infoOrder;
	}
}
