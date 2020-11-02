package com.cyberup.schedule;

/***************************************************************************************************
 * $Id: SPHarvester.java, v 1.0 2003/10/24 revision : 2003/11/12 Copyright (C) 2003 TriGem Infonet,
 * Inc. All rights reserved.
 **************************************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.system.PageView;
import com.cyberup.service.system.PageViewService;

@Component
public class PageViewConstructor {
	
	private final static int BATCH_SIZE = 50000;

    protected Logger logger = Logger.getLogger(this.getClass());
    
    static Pattern accessLogPattern = Pattern.compile(getAccessLogRegex(),Pattern.CASE_INSENSITIVE
            | Pattern.DOTALL);
    
	@Autowired
    private PageViewService pageViewService;
	
	static String getAccessLogRegex()
    {
        String regex1 = " ([\\d.]+)";                         // Client IP
        String regex2 = " (\\S+)";                             // -
        String regex3 = " (\\S+)";                             // - 
        String regex4 = "^\\[([\\d.]+\\s[\\d:]+)\\]"; // Date  \\[([\\w:/]+\\s[+\\-]\\d{4})\\]
        String regex5 = " \"(.+?)\"";                       // request method and url 
        String regex6 = " (\\d{3})";                           // HTTP code
        String regex7 = " (\\d+|(.+?))";                     // Number of bytes (\\d+|(.+?))
        String regex8 = " \"([^\"]+|(.+?))\"";                 // Referer
        String regex9 = " \"([^\"]+|(.+?))\"";                // Agent

        return regex4+regex1+regex5+regex6+regex7;
    }
	
	public static void main(String[] args) {
		try {
			//window
			Log4jConfigurer.initLogging("src/conf/spring/batch-log4j.xml");
			
			//unix
			//Log4jConfigurer.initLogging("/data/data2/wwwjeus/cuinfo/WEB-INF/classes/spring/app-log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-datasource.xml", "spring/SiteConfig.xml");
			String[] beans = context.getBeanDefinitionNames();
			
			System.out.println("\n### ManualHarvestController START\n");
			for(int i = 0; i < beans.length; i++)
			{
				
				System.out.println(beans[i]);
			}
			
			PageViewConstructor pageViewConstructor = context.getBean(PageViewConstructor.class);
			
			File dir = new File("C:/Documents and Settings/Administrator/My Documents/cuinfo_accesslog");
			File[] files = dir.listFiles();
			for(int i = 0; i < files.length; i++)
			{
				if(files[i].getName().startsWith("access_201204")
						|| files[i].getName().startsWith("access_201205")
						|| files[i].getName().startsWith("access_201206")
						|| files[i].getName().startsWith("access_201207"))
				pageViewConstructor.construct(files[i]);
			}
			
		} catch (Exception e) {
			Logger.getLogger(PageViewConstructor.class).error(e.getMessage(), e);
		}
	}
	
	public void construct(File logFile)
	{
		try {
			logger.info("construct file : " + logFile.getPath());
			BufferedReader reader = new BufferedReader(new FileReader(logFile));
			String log = null;
			PageView pageView = null;
			List<PageView> pageViewList = new ArrayList<PageView>();
			int inx = 0;
			while((log = reader.readLine()) != null)
			{
				pageViewList.add(parse(log));
				
				if(pageViewList.size() > BATCH_SIZE)
				{
					logger.info("batch start : " + pageViewList.size());
					
					try {
						pageViewService.insertBatch(pageViewList);
						
						logger.info("batch end : " + pageViewList.size());
					} catch (Exception e) {
						logger.error(logFile.getPath() + "("+inx+") " + e.getMessage(), e);
					}
					
					pageViewList.clear();
					pageViewList = null;
					pageViewList = new ArrayList<PageView>();
					
					inx++;
				}
			}
			
			if(pageViewList.size() > 0)
			{
				logger.info("batch start : " + pageViewList.size());
				
				try {
					pageViewService.insertBatch(pageViewList);
					
					logger.info("batch end : " + pageViewList.size());
				} catch (Exception e) {
					logger.error(logFile.getPath() + "("+inx+") " + e.getMessage(), e);
				}
				
				
				pageViewList.clear();
				pageViewList = null;
			}
			
			logFile.renameTo(new File(logFile.getPath() + "/success_" + logFile.getName()));
			logger.info("construct file success : " + logFile.getPath());
		} catch (Exception e) {
			logger.error(logFile.getPath() + " " + e.getMessage(), e);
		}
	}
	
	public PageView parse(String log)
	{
		logger.debug("log : " + log);
		
		PageView pageView = new PageView();
		
		 Matcher accessLogEntryMatcher = accessLogPattern.matcher(log);
		 
		 if(!accessLogEntryMatcher.matches())
         {
			 logger.info("" + log +" : couldn't be parsed");
         }
         else
         {
        	 pageView.setRegDate(accessLogEntryMatcher.group(1));
        	 pageView.setAccessor(accessLogEntryMatcher.group(2));
        	 pageView.setPage(accessLogEntryMatcher.group(3).substring(accessLogEntryMatcher.group(3).indexOf(" ") + 1));
        	 pageView.setHttpCode(Integer.parseInt(accessLogEntryMatcher.group(4)));
        	 pageView.setBytes(Integer.parseInt(StringUtils.remove(accessLogEntryMatcher.group(5),"ms")));
        	 
        	 logger.debug("page view : " + pageView);
         }
		
		return pageView;
	}
}