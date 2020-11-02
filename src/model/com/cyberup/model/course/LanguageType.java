package com.cyberup.model.course;

 
public enum LanguageType {
	KOR("KO", "한글"), ENG("EN", "영어"), JPN("JA", "일본어"), CHINESE("ZH", "중국어");
	
	private String value;
	private String name;

	private LanguageType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static LanguageType parse(String value) {
		LanguageType[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
