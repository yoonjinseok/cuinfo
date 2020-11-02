package com.cyberup.model.course;

 
public enum ScheduleType {
	CREATE("C", "등록수집"), UPDATE("U", "수정수집"), DELETE("D","삭제수집");
	
	private String value;
	private String name;

	private ScheduleType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static ScheduleType parse(String value) {
		ScheduleType[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
