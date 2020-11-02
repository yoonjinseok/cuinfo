package com.cyberup.model.course;

 
public enum CourseStatus {
	READY("D", "승인대기"), MODIFY("R", "수정요청"), RESUMMARY("M", "재수집")
	, COMMIT("C", "수정완료"), APPROVE("A", "승인"), TRANSREQUEST("T", "이관요청")
	, TRANSFER("S", "이관완료"), HOLD("E", "서비스중지");
	
	private String value;
	private String name;

	private CourseStatus(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static CourseStatus parse(String value) {
		CourseStatus[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
