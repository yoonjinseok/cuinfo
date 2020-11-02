package com.cyberup.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.course.History;
import com.cyberup.model.course.Schedule;
import com.cyberup.model.course.ScheduleType;
import com.cyberup.service.course.HistoryService;
import com.cyberup.service.course.ScheduleService;
import com.cyberup.util.DateFormatter;
import common.Logger;

public class SpHandler extends QuartzJobBean {
	private Logger logger = Logger.getLogger(SpHandler.class);
	
	private ScheduleService scheduleService;
	private HistoryService historyService;
	private ResponseHandlerImpl responseHandlerImpl;
	private SpHarvester spHarvester;
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public void setResponseHandlerImpl(ResponseHandlerImpl responseHandlerImpl) {
		this.responseHandlerImpl = responseHandlerImpl;
	}

	public void setSpHarvester(SpHarvester spHarvester) {
		this.spHarvester = spHarvester;
	}

	private Date harvestDate;
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-batch.xml", "spring/cyberup-context-datasource.xml", "spring/SiteConfig.xml");
			String[] beans = context.getBeanDefinitionNames();
			for(int i = 0; i < beans.length; i++)
			{
				System.out.println(beans[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public void manual()
	{
		
		Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.YEAR, 2011);
    	calendar.set(Calendar.MONTH, 9);
    	calendar.set(Calendar.DAY_OF_MONTH, 29);
		
		Schedule schedule = scheduleService.selectInfo(16);
		schedule.setHarvestDate(calendar.getTime());
		schedule.setScheduleType(ScheduleType.CREATE.getValue());
    	schedule.setIntervals(120);
		
		spHarvester.setHistoryId(-1);
		spHarvester.setResponseHandler(responseHandlerImpl);
		spHarvester.setSchedule(schedule);
		
		new Thread(spHarvester).start();
	}
	*/
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		try {
			logger.info("executeInternal start");
			
			harvestDate = new Date();
			
			List<Schedule> list = scheduleService.selectHarvestList(new DateFormatter("yyyyMMdd").print(harvestDate, Locale.getDefault()));
			
			if(list.size() > 0)
			{
				for(int i = 0; i < list.size(); i++)
				{
					Schedule schedule = list.get(i);
					schedule.setHarvestDate(harvestDate);
					
					int historyId = saveHistory(schedule);
					
					spHarvester.setHistoryId(historyId);
					spHarvester.setResponseHandler(responseHandlerImpl);
					spHarvester.setSchedule(schedule);
					
					spHarvester.run();
				}
			}
			
			logger.info("executeInternal end");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private int saveHistory(Schedule schedule)
	{
		History history = new History();
		history.setStartDate(harvestDate);
		history.setScheduleId(schedule.getScheduleId());
		history.setScheduleType(schedule.getScheduleType());
		history.setScheduleSdate(new DateFormatter("yyyyMMdd").print(schedule.getHarvestSdate(), Locale.getDefault()));
		history.setScheduleEdate(new DateFormatter("yyyyMMdd").print(schedule.getHarvestEdate(), Locale.getDefault()));
		
		return historyService.insertInfo(history);
	}
}
