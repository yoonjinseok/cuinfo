package com.cyberup.model.common;

import com.cyberup.model.course.CourseSearch;

import java.util.Date;

public class NewHomeMain extends CourseSearch{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4742531064097095116L;

	private Integer cnt = 0;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public Integer getCnt() {
		return cnt;
	}

	@Override
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
}
