package com.cyberup.model.univ;

import com.cyberup.framework.model.PagingModel;

public class SendMail extends PagingModel{
	
	private static final long serialVersionUID = -6237468693320527553L;
	
	private String title="";			//제목
	private String writer="";		//작성자
	private String fromAddr="";	//발신자 메일 주소
	private String univEmail="";		//수신자 메일 주소
	private String kerisAddr="";	//KERIS 담당자 메일 주소
	private String content="";		//내용
	private String univName="";
	
	
	
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFromAddr() {
		return fromAddr;
	}
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}
	public String getUnivEmail() {
		return univEmail;
	}
	public void setUnivEmail(String univEmail) {
		this.univEmail = univEmail;
	}
	public String getKerisAddr() {
		return kerisAddr;
	}
	public void setKerisAddr(String kerisAddr) {
		this.kerisAddr = kerisAddr;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
