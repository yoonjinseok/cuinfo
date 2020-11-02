package com.cyberup.framework.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseObject implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -4539779017153901362L;
	
	/*
	 * 2012년 고도화 웹트렌즈 전달 변수 공통으로 사용하기 위하여 변수 정의(지갑인)
	 */
	private String sip="";
	private String uri="";
	private String qri="";
	private String sp="";
	
	private String sip1="";
	private String uri1="";
	private String qri1="";
	private String sp1="";
	private String sip2="";
	private String uri2="";
	private String qri2="";
	private String sp2="";
	private String sip3="";
	private String uri3="";
	private String qri3="";
	private String sp3="";

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public String getSip() {
		return sip;
	}

	public void setSip(String sip) {
		this.sip = sip;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getQri() {
		return qri;
	}

	public void setQri(String qri) {
		this.qri = qri;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public String getSip1() {
		return sip1;
	}

	public void setSip1(String sip1) {
		this.sip1 = sip1;
	}

	public String getUri1() {
		return uri1;
	}

	public void setUri1(String uri1) {
		this.uri1 = uri1;
	}

	public String getQri1() {
		return qri1;
	}

	public void setQri1(String qri1) {
		this.qri1 = qri1;
	}

	public String getSp1() {
		return sp1;
	}

	public void setSp1(String sp1) {
		this.sp1 = sp1;
	}

	public String getSip2() {
		return sip2;
	}

	public void setSip2(String sip2) {
		this.sip2 = sip2;
	}

	public String getUri2() {
		return uri2;
	}

	public void setUri2(String uri2) {
		this.uri2 = uri2;
	}

	public String getQri2() {
		return qri2;
	}

	public void setQri2(String qri2) {
		this.qri2 = qri2;
	}

	public String getSp2() {
		return sp2;
	}

	public void setSp2(String sp2) {
		this.sp2 = sp2;
	}

	public String getSip3() {
		return sip3;
	}

	public void setSip3(String sip3) {
		this.sip3 = sip3;
	}

	public String getUri3() {
		return uri3;
	}

	public void setUri3(String uri3) {
		this.uri3 = uri3;
	}

	public String getQri3() {
		return qri3;
	}

	public void setQri3(String qri3) {
		this.qri3 = qri3;
	}

	public String getSp3() {
		return sp3;
	}

	public void setSp3(String sp3) {
		this.sp3 = sp3;
	}

}
