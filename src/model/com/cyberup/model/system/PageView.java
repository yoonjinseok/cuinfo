package com.cyberup.model.system;

import java.util.Date;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;

public class PageView  extends PagingModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770041900075663256L;
	private Integer pageviewId = 0;
	private String page = "";
	private String regDate = "";
	private String accessor = "";
	private Integer httpCode = 0;
	private Integer bytes = 0;
	public Integer getPageviewId() {
		return pageviewId;
	}
	public void setPageviewId(Integer pageviewId) {
		this.pageviewId = pageviewId;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getAccessor() {
		return accessor;
	}
	public void setAccessor(String accessor) {
		this.accessor = accessor;
	}
	public Integer getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}
	public Integer getBytes() {
		return bytes;
	}
	public void setBytes(Integer bytes) {
		this.bytes = bytes;
	}
	
	
	
}
