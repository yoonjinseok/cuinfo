package com.cyberup.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyberup.model.course.Schedule;
import com.cyberup.service.course.ScheduleService;

@Controller
@RequestMapping("/mgr/course")
public class ManualHarvestController {
	private Logger logger = Logger.getLogger(ManualHarvestController.class);
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private SpHarvester spHarvester;
	@Autowired
	private ResponseHandlerImpl responseHandlerImpl;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@RequestMapping("/manualcollect")
	public String collect(int year, int month, int day, int scheduleId, String type, int interval, ModelMap model) {
		Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.YEAR, year);
    	calendar.set(Calendar.MONTH, month-1);
    	calendar.set(Calendar.DAY_OF_MONTH, day);
		
		Schedule schedule = scheduleService.selectInfo(scheduleId);
		schedule.setHarvestDate(calendar.getTime());
		schedule.setScheduleType(type);
    	schedule.setIntervals(interval);
		
		spHarvester.setHistoryId(-1);
		spHarvester.setResponseHandler(responseHandlerImpl);
		spHarvester.setSchedule(schedule);
		
		new Thread(spHarvester).start();
		
		model.addAttribute("msg", "수집을 시작했습니다.");
		
		return null;
	}
	
	public static void main(String[] args) {
		try {
			//window
			Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
			
			//unix
			//Log4jConfigurer.initLogging("/data/data2/wwwjeus/cuinfo/WEB-INF/classes/spring/app-log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-datasource.xml", "spring/SiteConfig.xml");
			String[] beans = context.getBeanDefinitionNames();
			
			System.out.println("\n### ManualHarvestController START\n");
			for(int i = 0; i < beans.length; i++)
			{
				
				System.out.println(beans[i]);
			}
			
			ManualHarvestController manualHarvestController = context.getBean(ManualHarvestController.class);

			//manualHarvestController.stepbycollect(args[0], args[1], Integer.parseInt(args[2]), args[3], Integer.parseInt(args[4]), new ModelMap());
			
			//20110801 20110513 16 U 1 &
//			manualHarvestController.stepbycollect("20110713", "20110711", 8, "C", 1, new ModelMap());
//			manualHarvestController.stepbycollect("20110713", "20110711", 16, "U", 1, new ModelMap());
			manualHarvestController.stepbycollect("20110726", "20110726", 8, "U", 1, new ModelMap());
			
			
//			manualHarvestController.stepbycollect("20110712", "20110712", 8, "C", 1, new ModelMap());
			
			
			//20120106 20111127 6 C 1 
//			manualHarvestController.stepbycollect("20111231", "20110101", 6, "C", 1, new ModelMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getDiffOfDay(Calendar date1, Calendar date2)
	{
		long Bring = (date1.getTimeInMillis()-date2.getTimeInMillis());
		int days = (int)(Bring / (60*60*24*1000)); // 1/1000초  단위를 날짜로 환산.
		
		return days;
	}
	
	@RequestMapping("/stepbycollect")
	public String stepbycollect(final String sdate, final String edate, final int scheduleId, final String type, final int interval, ModelMap model) {
		
		new Thread(){
			public void run(){
				try {
					Calendar scalendar = Calendar.getInstance();
					scalendar.set(Calendar.YEAR, Integer.parseInt(sdate.substring(0, 4)));
					scalendar.set(Calendar.MONTH, Integer.parseInt(sdate.substring(4, 6))-1);
					scalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(sdate.substring(6)));
					scalendar.add(Calendar.DAY_OF_MONTH, 1);
					
					Calendar ecalendar = Calendar.getInstance();
					ecalendar.set(Calendar.YEAR, Integer.parseInt(edate.substring(0, 4)));
					ecalendar.set(Calendar.MONTH, Integer.parseInt(edate.substring(4, 6))-1);
					ecalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(edate.substring(6)));
					
					int diff = getDiffOfDay(scalendar, ecalendar);
					int count = diff/interval;
					int rest = diff%interval;
					if(rest > 0)
						count++;
					
					int realInterval = interval;
					
					for(int i = 0; i < count; i++)
					{
						if(i > 0)
						{
							scalendar.add(Calendar.DAY_OF_MONTH, -interval);
							
							if(i == count-1 && rest > 0)
								realInterval = rest;
						}
						
						try {
							logger.info("["+simpleDateFormat.format(scalendar.getTime())+":"+realInterval+"]start");
							Schedule schedule = scheduleService.selectInfo(scheduleId);
							schedule.setHarvestDate(scalendar.getTime());
							schedule.setScheduleType(type);
					    	schedule.setIntervals(realInterval);
							
							spHarvester.setHistoryId(-1);
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
			}
		}.start();
		
		model.addAttribute("msg", "수집을 시작했습니다.");
		
		return null;
	}
}
