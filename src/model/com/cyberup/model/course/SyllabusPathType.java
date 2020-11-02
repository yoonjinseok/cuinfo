package com.cyberup.model.course;

 
public enum SyllabusPathType {
	URI("1", "URI"), CONTENT("2", "직접작성"), FILE("3","파일첨부");
	
	private String value;
	private String name;

	private SyllabusPathType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static SyllabusPathType parse(String value) {
		SyllabusPathType[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
