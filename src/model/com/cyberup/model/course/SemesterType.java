package com.cyberup.model.course;

 
public enum SemesterType {
	TH1("1", "1학기"), TH2("2", "2학기"), SUMMERTIME("3", "여름계절"), WINTERTIME("4", "겨울계절"), ETC("0", "기타");
	 
	private String value;
	private String name;

	private SemesterType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static SemesterType parse(String value) {
		SemesterType[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
