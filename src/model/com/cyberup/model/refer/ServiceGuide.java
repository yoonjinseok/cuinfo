package com.cyberup.model.refer;

import java.util.Date;


import com.cyberup.framework.model.PagingModel;

public class ServiceGuide extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1537734791330019630L;
	private Integer guideNo					= 0;
	private String question					= "";
	private String userYn						= "";
	private Integer answerTypeId		= 0;
	private String register					= "";
	private String modifier					= "";
	private Date regDate;
	private Date modDate;
	
	private Integer answerId				= 0;
	private Integer jumpGideNo			= 0;
	private String answer					= "";
	
	private Integer rnum						= 0;
	private Integer selectStep1			= 0;
	private Integer selectStep2			= 0;
	
	
	public Integer getSelectStep1() {
		return selectStep1;
	}

	public void setSelectStep1(Integer selectStep1) {
		this.selectStep1 = selectStep1;
	}

	public Integer getSelectStep2() {
		return selectStep2;
	}

	public void setSelectStep2(Integer selectStep2) {
		this.selectStep2 = selectStep2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUserYn() {
		return userYn;
	}

	public void setUserYn(String userYn) {
		this.userYn = userYn;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getGuideNo() {
		return guideNo;
	}

	public void setGuideNo(Integer guideNo) {
		if(guideNo != null)
			this.guideNo = guideNo;
	}

	public Integer getAnswerTypeId() {
		return answerTypeId;
	}

	public void setAnswerTypeId(Integer answerTypeId) {
		if(answerTypeId != null)
			this.answerTypeId = answerTypeId;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		if(answerId != null)
			this.answerId = answerId;
	}

	public Integer getJumpGideNo() {
		return jumpGideNo;
	}

	public void setJumpGideNo(Integer jumpGideNo) {
		if(jumpGideNo != null)
			this.jumpGideNo = jumpGideNo;
	}

	public Integer getRnum() {
		return rnum;
	}

	public void setRnum(Integer rnum) {
		if(rnum != null)
			this.rnum = rnum;
	}
	
	

	
}
