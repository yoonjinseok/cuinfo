package com.cyberup.framework.model;

import java.util.ArrayList;
import java.util.List;
 
public enum UserDegree {
	ADMIN("A", "운영자"), MEMBER("M", "회원");
	
	private String value;
	private String name;

	private UserDegree(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static UserDegree parse(String value) {
		UserDegree[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
