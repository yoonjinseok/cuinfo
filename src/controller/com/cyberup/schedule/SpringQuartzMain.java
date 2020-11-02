package com.cyberup.schedule;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class SpringQuartzMain {
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("/workspace/cyberup/src/conf/spring/batch-log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-appbatch.xml");
			String[] beans = context.getBeanDefinitionNames();
			for(int i = 0; i < beans.length; i++)
			{
				System.out.println(beans[i]);
			}
			
			Logger.getLogger(SpringQuartzMain.class).debug("spring quartz main container started");
		} catch (Exception e) {
			e.printStackTrace();
			
			Logger.getLogger(SpringQuartzMain.class).debug("spring quartz main container ended");
		}
	}

}
