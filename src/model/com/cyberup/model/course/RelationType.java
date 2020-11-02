package com.cyberup.model.course;

 
public enum RelationType {
	COURSE("C", "강좌"), LECTURE("L", "강의");
	
	private String value;
	private String name;

	private RelationType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static RelationType parse(String value) {
		RelationType[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
