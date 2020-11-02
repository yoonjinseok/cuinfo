package com.cyberup.model.system;

import java.util.Date;
import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class ServiceGuide extends PagingModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8710283270336221505L;
	private Integer guide_no 			= 0;
	private String question				= "";
	private String answer_result		= "";
	private Integer answer_yes		= 0;
	private Integer answer_no			= 0;
	private String register				= "";
	private Date reg_date;
	private String modifier				="";
	private Date mod_date	;
	private String useYn				="";
	
	
	public Integer getGuide_no() {
		return guide_no;
	}
	public void setGuide_no(Integer guide_no) {
		this.guide_no = guide_no;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer_result() {
		return answer_result;
	}
	public void setAnswer_result(String answer_result) {
		this.answer_result = answer_result;
	}
	public Integer getAnswer_yes() {
		return answer_yes;
	}
	public void setAnswer_yes(Integer answer_yes) {
		this.answer_yes = answer_yes;
	}
	public Integer getAnswer_no() {
		return answer_no;
	}
	public void setAnswer_no(Integer answer_no) {
		this.answer_no = answer_no;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	
	
}
