package com.cyberup.framework.controller;

import java.util.Locale;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.ui.ModelMap;

import com.cyberup.util.DateFormatter;

public class ControllerAspector {

	public Object methodAdvice(ProceedingJoinPoint pjp) throws Throwable{
		
		Object retVal = null;
		try {
			
			preProcess(pjp);
			
			retVal = pjp.proceed();
			
			postProcess(pjp);
			
			return retVal;
		} finally {
		}
	}
	
	private void preProcess(ProceedingJoinPoint pjp)
	{
		
	}
	
	private void postProcess(ProceedingJoinPoint pjp)
	{
		
	}
	
	public static void main(String[] args) {
		DateFormatter dateFormatter = new DateFormatter("HH:mm:ss");
		dateFormatter.setPattern("yyyy-MM-dd");
		System.out.println("print : " + dateFormatter.print(null, Locale.getDefault()));
	}
	   
}
