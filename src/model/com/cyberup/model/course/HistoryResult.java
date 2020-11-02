package com.cyberup.model.course;

import java.util.ArrayList;
import java.util.List;
 
public enum HistoryResult {
	SUCCESS("S", "성공"), FAIL("E", "실패");
	
	private String value;
	private String name;

	private HistoryResult(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static HistoryResult parse(String value) {
		HistoryResult[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
