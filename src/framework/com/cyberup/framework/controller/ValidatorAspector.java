package com.cyberup.framework.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.ui.ModelMap;

public class ValidatorAspector {

	public Object validatePointcut(ProceedingJoinPoint pjp) throws Throwable{
		((MapValidator)pjp.getTarget()).init((ModelMap)pjp.getArgs()[1]);
		Object retVal = pjp.proceed();
		return retVal;
	}

	/*
	@Before("validatePointcut()")
	public void validateBeforeAdvice(){
		Logger.getLogger(this.getClass()).debug("validateBeforeAdvice");
	}

	@AfterReturning("validatePointcut()")
	public void validateAfterAdvice(){
		Logger.getLogger(this.getClass()).debug("validateAfterAdvice");
	}
	*/
	   
}
