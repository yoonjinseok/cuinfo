package com.cyberup.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.course.History;
import com.cyberup.model.course.RunningStatus;
import com.cyberup.model.course.Schedule;
import com.cyberup.model.course.ScheduleType;
import com.cyberup.service.course.HistoryService;
import com.cyberup.service.course.ScheduleService;
import com.cyberup.util.DateFormatter;

public class ManualHandler extends QuartzJobBean {
	private Logger logger = Logger.getLogger(ManualHandler.class);
	
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

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("/workspace/cyberup/src/conf/spring/batch-log4j.xml");
			
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
	
	public void stepbycollect(Schedule schedule) {
		try {
			Calendar scalendar = Calendar.getInstance();
			scalendar.setTime(schedule.getEndDate());
			scalendar.add(Calendar.DAY_OF_MONTH, 1);
			
			Calendar ecalendar = Calendar.getInstance();
			ecalendar.setTime(schedule.getStartDate());
			
			int diff = getDiffOfDay(scalendar, ecalendar);
			int count = diff/schedule.getIntervals();
			int rest = diff%schedule.getIntervals();
			if(rest > 0)
				count++;
			
			int realInterval = schedule.getIntervals();
			
			for(int i = 0; i < count; i++)
			{
				if(!scheduleService.selectInfo(schedule.getScheduleId()).getStatus().equals("Y"))
					break;
				
				if(i > 0)
				{
					scalendar.add(Calendar.DAY_OF_MONTH, -schedule.getIntervals());
					
					if(i == count-1 && rest > 0)
						realInterval = rest;
				}
				
				try {
					logger.info("["+simpleDateFormat.format(scalendar.getTime())+":"+realInterval+"]start");
					schedule.setHarvestDate(scalendar.getTime());
			    	schedule.setIntervals(realInterval);
					
					int historyId = saveHistory(schedule);
					spHarvester.setHistoryId(historyId);
					
					
			    	spHarvester.setResponseHandler(responseHandlerImpl);
			    	spHarvester.setSchedule(schedule);
					
			    	spHarvester.run();
					
					logger.info("["+simpleDateFormat.format(scalendar.getTime())+":"+realInterval+"]end");
				} catch (Exception e) {
					logger.error("["+simpleDateFormat.format(scalendar.getTime())+":"+realInterval+"]" + e.getMessage(), e);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		scheduleService.updateRunningStatus(schedule.getScheduleId(), RunningStatus.COMPLETE.getValue(), "batch");
	
	}
	
	private int getDiffOfDay(Calendar date1, Calendar date2)
	{
		long Bring = (date1.getTimeInMillis()-date2.getTimeInMillis());
		int days = (int)(Bring / (60*60*24*1000)); // 1/1000초  단위를 날짜로 환산.
		
		return days;
	}
	
	private int saveHistory(Schedule schedule)
	{
		History history = new History();
		history.setStartDate(new Date());
		history.setScheduleId(schedule.getScheduleId());
		history.setScheduleType(schedule.getScheduleType());
		history.setScheduleSdate(new DateFormatter("yyyyMMdd").print(schedule.getHarvestSdate(), Locale.getDefault()));
		history.setScheduleEdate(new DateFormatter("yyyyMMdd").print(schedule.getHarvestEdate(), Locale.getDefault()));
		
		return historyService.insertInfo(history);
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		try {
			logger.info("executeInternal start");
			
			List<Schedule> list = scheduleService.selectManualHarvestList(0, 0);
			
			if(list.size() > 0)
			{
				for(int i = 0; i < list.size(); i++)
				{
					Schedule schedule = list.get(i);
					
					scheduleService.updateRunningStatus(schedule.getScheduleId(), RunningStatus.LOADING.getValue(), "batch");
					
					stepbycollect(schedule);
				}
			}
			
			logger.info("executeInternal end");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
