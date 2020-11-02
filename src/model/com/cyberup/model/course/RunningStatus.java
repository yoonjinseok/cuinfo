package com.cyberup.model.course;

 
public enum RunningStatus {
	READY("R", "등록"), LOADING("L", "수집중"), COMPLETE("C","완료");
	
	private String value;
	private String name;

	private RunningStatus(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static RunningStatus parse(String value) {
		RunningStatus[] lists = values();
		for(int i = 0; i < lists.length; i++)
		{
			if(lists[i].value.equals(value))
				return lists[i];
		}
		
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
