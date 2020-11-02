package com.cyberup.model.admin;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.LoginUser;

public class Menu extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6566958483153619038L;
	
	private String menuId = "";
	private String menuName = "";
	private String groupId = "";
	private String menuPath = "";
	private String useYn = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;

	public String getMenuId(){
		return this.menuId;
	}
	public void setMenuId(String menuId){
		this.menuId = menuId;
	}
	public String getMenuName(){
		return this.menuName;
	}
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}
	public String getGroupId(){
		return this.groupId;
	}
	public void setGroupId(String groupId){
		this.groupId = groupId;
	}
	public String getMenuPath(){
		return this.menuPath;
	}
	public void setMenuPath(String menuPath){
		this.menuPath = menuPath;
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
}
