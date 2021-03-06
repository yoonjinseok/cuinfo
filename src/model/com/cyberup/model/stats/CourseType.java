package com.cyberup.model.stats;
 
public enum CourseType {
	REGULAR("R", "정규"), IRREGULAR("D", "비정규"), CONFERENCE("F","컨퍼런스");
	
	private String value;
	private String name;

	private CourseType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static CourseType parse(String value) {
		CourseType[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
