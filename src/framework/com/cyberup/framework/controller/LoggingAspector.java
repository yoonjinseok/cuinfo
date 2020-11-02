package com.cyberup.framework.controller;

import java.util.Locale;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;

public class LoggingAspector {

	public Object loggingAdvice(ProceedingJoinPoint pjp) throws Throwable{
		Logger.getLogger(this.getClass()).debug("advice "+pjp.toShortString()+"");
		Logger.getLogger(this.getClass()).debug("args[");
		Object[] args = pjp.getArgs();
		if(args != null)
		{
			for(int i = 0; i < args.length; i++)
			{
				Logger.getLogger(this.getClass()).debug("arg["+i+"]" + (args[i] != null?ToStringBuilder.reflectionToString(args[i], ToStringStyle.MULTI_LINE_STYLE):"null"));
			}
		}
		Logger.getLogger(this.getClass()).debug("]");
		
		StopWatch stopWatch = new StopWatch();
		
		Object retVal = null;
		try {
			stopWatch.start();
			retVal = pjp.proceed();
			
			return retVal;
		} finally {
			stopWatch.stop();
			Logger.getLogger(this.getClass()).debug("["+pjp.toShortString()+"] execute time : "+stopWatch.getTotalTimeMillis()+" millisec");
			Logger.getLogger(this.getClass()).debug("["+pjp.toShortString()+"] return value : " + (retVal != null?ToStringBuilder.reflectionToString(retVal, ToStringStyle.MULTI_LINE_STYLE):"null"));
		}
	}
	   
}
