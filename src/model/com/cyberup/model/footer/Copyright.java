package com.cyberup.model.footer;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class Copyright extends PagingModel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7639552639859453472L;
	private Integer id = 0;
	private Integer ref = 0;
	private Integer businessKind = 0;
	private Integer typeKind = 0;
	private Integer channelKind = 0;
	private Integer customorKind = 0;
	private Integer requestKind = 0;
	private Integer intimeKind = 0;
	private Integer contentKind = 0;
	private Integer position = 0;
	private String 	qSubject ="";
	private String 	qContents ="";
	
	private String 	kId ="";
	private String 	name ="";
	private String 	email ="";
	private String 	telno ="";
	private String 	telno1 ="";
	private String 	telno2 ="";
	private String 	telno3 ="";
	
	private Date 	requestDate;
	private Integer	status =0;
	private String 	telChk ="";
	
	private String url = "";
	
	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		if(position != null)
			this.position = position;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getqSubject() {
		return qSubject;
	}
	public void setqSubject(String qSubject) {
		this.qSubject = qSubject;
	}
	public String getqContents() {
		return qContents;
	}
	public void setqContents(String qContents) {
		this.qContents = qContents;
	}
	public String getkId() {
		return kId;
	}
	public void setkId(String kId) {
		this.kId = kId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getTelno1() {
		return telno1;
	}
	public void setTelno1(String telno1) {
		this.telno1 = telno1;
	}
	public String getTelno2() {
		return telno2;
	}
	public void setTelno2(String telno2) {
		this.telno2 = telno2;
	}
	public String getTelno3() {
		return telno3;
	}
	public void setTelno3(String telno3) {
		this.telno3 = telno3;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getTelChk() {
		return telChk;
	}
	public void setTelChk(String telChk) {
		this.telChk = telChk;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id != null)
			this.id = id;
	}
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		if(ref != null)
			this.ref = ref;
	}
	public Integer getBusinessKind() {
		return businessKind;
	}
	public void setBusinessKind(Integer businessKind) {
		if(businessKind != null)
		this.businessKind = businessKind;
	}
	public Integer getTypeKind() {
		return typeKind;
	}
	public void setTypeKind(Integer typeKind) {
		if(typeKind != null)
			this.typeKind = typeKind;
	}
	public Integer getChannelKind() {
		return channelKind;
	}
	public void setChannelKind(Integer channelKind) {
		if(channelKind != null)
			this.channelKind = channelKind;
	}
	public Integer getCustomorKind() {
		return customorKind;
	}
	public void setCustomorKind(Integer customorKind) {
		if(customorKind != null)
			this.customorKind = customorKind;
	}
	public Integer getRequestKind() {
		return requestKind;
	}
	public void setRequestKind(Integer requestKind) {
		if(requestKind != null)
			this.requestKind = requestKind;
	}
	public Integer getIntimeKind() {
		return intimeKind;
	}
	public void setIntimeKind(Integer intimeKind) {
		if(intimeKind != null)
			this.intimeKind = intimeKind;
	}
	public Integer getContentKind() {
		return contentKind;
	}
	public void setContentKind(Integer contentKind) {
		if(contentKind != null)
			this.contentKind = contentKind;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		if(status != null)
			this.status = status;
	}
	
	
	
}
