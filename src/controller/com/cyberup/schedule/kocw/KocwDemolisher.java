package com.cyberup.schedule.kocw;

/***************************************************************************************************
 * $Id: SPHarvester.java, v 1.0 2003/10/24 revision : 2003/11/12 Copyright (C) 2003 TriGem Infonet,
 * Inc. All rights reserved.
 **************************************************************************************************/

import java.util.List;
import java.util.Locale;

import net.kocw.core.metadata.kem.Kem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.util.DateFormatter;

@Component
public class KocwDemolisher extends KocwDistributor {
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-datasource.xml ");
			String[] beans = context.getBeanDefinitionNames();
			for(int i = 0; i < beans.length; i++)
			{
				System.out.println(beans[i]);
			}
			
			KocwDemolisher kocwDemolisher = context.getBean(KocwDemolisher.class);
			
			kocwDemolisher.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		init();
		
		List<Integer> courses = courseService.selectDistDelList(
				new DateFormatter("yyyy-MM-dd").print(startDate, Locale.getDefault()), 
				new DateFormatter("yyyy-MM-dd").print(endDate, Locale.getDefault()));
		
		for(int i = 0; i < courses.size(); i++)
		{
			try {
				List<Kem> kemList = selectKemList(makeCourseMetadataSource(courses.get(i)));
				if(kemList != null)
				{
					for(int k = 0; k < kemList.size(); k++)
					{
						switch (kemList.get(k).getStatusCode()) {
						case STATUS_CODE_READY:
						case STATUS_CODE_PAUSECOM:
							demolish(Integer.parseInt(kemList.get(k).getKemId()));
							break;

						case STATUS_CODE_MODREQ:
						case STATUS_CODE_MODCOM:
							updateStatusCode(Integer.parseInt(kemList.get(k).getKemId()), STATUS_CODE_PAUSEREQ);
							break;
						
						case STATUS_CODE_PAUSEREQ:
							break;
						
						case STATUS_CODE_TRASCOM:
							updateStatusCode(Integer.parseInt(kemList.get(k).getKemId()), STATUS_CODE_PAUSEREQ);
							break;

						default:
							break;
						}
						
						logger.info("course id : " + courses.get(i) + " demolish success.");
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
		}
	}
}