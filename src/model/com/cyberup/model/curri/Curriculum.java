package com.cyberup.model.curri;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class Curriculum extends PagingModel {

	private static final long serialVersionUID = 7118473722167025051L;
	/**
	 * 기   능: 교과과정  
	 * 작성자 : 이종호
	 * 작성일 : 2012-10-31
	 */

	private Integer rn1 = 1;
	private Integer rn2 = 1;
	
	private String text = "";
	private String classifyId = "";
	private String classifyName = "";
	private String deptId = "";
	private String deptName = "";
	
	private String universityId = "";
	private String univdeptId = "";
	private String univdeptName = "";
	private String univName = "";
	private String universityName = "";
	private String univHomePage = "";
	private String linkurl = "";
	
	//커리큘럼페이지에서 사용할 변수
	private String grad = "";
	private Integer rn = 0;
	private Integer cnt = 0;
	private String courseId1 = "";
	private String title1 = "";
	private String credit1 = "";
	private String courseId2 = "";
	private String title2 = "";
	private String credit2 = "";
	private String termYear = "";
	
	private Integer gubn = 1;

	public Integer getGubn() {
		return gubn;
	}
	public void setGubn(Integer gubn) {
		if(gubn != null)
			this.gubn = gubn;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTermYear() {
		return termYear;
	}
	public void setTermYear(String termYear) {
		this.termYear = termYear;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public Integer getRn() {
		return rn;
	}
	public void setRn(Integer rn) {
		this.rn = rn;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
			this.grad = grad;
	}
	public String getCourseId1() {
		return courseId1;
	}
	public void setCourseId1(String courseId1) {
		this.courseId1 = courseId1;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getCredit1() {
		return credit1;
	}
	public void setCredit1(String credit1) {
		this.credit1 = credit1;
	}
	public String getCourseId2() {
		return courseId2;
	}
	public void setCourseId2(String courseId2) {
		this.courseId2 = courseId2;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getCredit2() {
		return credit2;
	}
	public void setCredit2(String credit2) {
		this.credit2 = credit2;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public String getUnivdeptId() {
		return univdeptId;
	}
	public void setUnivdeptId(String univdeptId) {
		this.univdeptId = univdeptId;
	}
	public String getUnivdeptName() {
		return univdeptName;
	}
	public void setUnivdeptName(String univdeptName) {
		this.univdeptName = univdeptName;
	}
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public Integer getRn1() {
		return rn1;
	}
	public void setRn1(Integer rn1) {
		this.rn1 = rn1;
	}
	public Integer getRn2() {
		return rn2;
	}
	public void setRn2(Integer rn2) {
		this.rn2 = rn2;
	}
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUnivHomePage() {
		return univHomePage;
	}
	public void setUnivHomePage(String univHomePage) {
		this.univHomePage = univHomePage;
	}
	
	
	

}