package com.cyberup.util;

import java.util.Date;
import java.util.Locale;

public class DateFormatter extends org.springframework.format.datetime.DateFormatter {

	public DateFormatter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateFormatter(String pattern) {
		super(pattern);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String print(Date date, Locale locale) {
		if(date != null)
			return super.print(date, locale);
		else
			return "";
	}
	
}
