package com.cyberup.model.course;

 
public enum CollectionType {
	COURSE("C", "강좌"), LECTURE("L", "강의")
	, COURSEFILE("F","강좌관련자료")
	, LECFILE("I","강의관련자료"), CONTRIBUTOR("B","기여자정보");
	
	private String value;
	private String name;

	private CollectionType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static CollectionType parse(String value) {
		CollectionType[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
