package com.cyberup.service.admin;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.dao.PessimisticLockingFailureException;

@Aspect
public class ConcurrentOperationExecutor {

	@Pointcut("execution(* com.lgcns.ikep.unit.member.service.AopTest.abs(..))")
	public void sayPointcut(){}

	@Before("sayPointcut()")
	public void mannerBeforeAdvice(){
		Logger.getLogger(this.getClass()).debug("mannerBeforeAdvice");
	}

	@AfterReturning("sayPointcut()")
	public void mannerAfterAdvice(){
		Logger.getLogger(this.getClass()).debug("mannerAfterAdvice");
	}
	   
}
