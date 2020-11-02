package com.cyberup.model.common;

import java.util.Date;

import org.apache.tomcat.util.modeler.BaseModelMBean;

import com.cyberup.framework.model.PagingModel;

public class DeadLinkCheckModel extends PagingModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3360631946772312793L;
	
	private Integer link_id = 0;
	private Integer university_id = 0;
	private Integer linkGubun_id = 0;
	private String link_name = "";
	private String link_url = "";
	private Integer link_order = 0;
	private String deadlink_err_code = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;
	
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		if(link_id != null)
			this.link_id = link_id;
	}
	public Integer getUniversity_id() {
		return university_id;
	}
	public void setUniversity_id(Integer university_id) {
		if(university_id != null)
			this.university_id = university_id;
	}
	public Integer getLinkGubun_id() {
		return linkGubun_id;
	}
	public void setLinkGubun_id(Integer linkGubun_id) {
		if(linkGubun_id != null)
			this.linkGubun_id = linkGubun_id;
	}
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public Integer getLink_order() {
		return link_order;
	}
	public void setLink_order(Integer link_order) {
		if(link_order != null)
			this.link_order = link_order;
	}
	public String getDeadlink_err_code() {
		return deadlink_err_code;
	}
	public void setDeadlink_err_code(String deadlink_err_code) {
		this.deadlink_err_code = deadlink_err_code;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
