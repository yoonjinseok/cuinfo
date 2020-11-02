package com.cyberup.schedule;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import oracle.xdb.RealInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Log4jConfigurer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.framework.model.SessionUploadProgress;
import com.cyberup.model.course.Schedule;
import com.cyberup.model.course.ScheduleType;
import com.cyberup.service.course.ScheduleService;
import com.cyberup.util.FileDeletor;
import com.cyberup.util.FileUtil;

@Controller
@RequestMapping("/mgr/course")
public class DpSpCompareController {
	private Logger logger = Logger.getLogger(DpSpCompareController.class);
	
	@Autowired
	private DpSpComparor dpSpComparor;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private ResponseHandlerImpl responseHandlerImpl;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		try {
			//window
			Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
			
			//unix
			//Log4jConfigurer.initLogging("/data/data2/wwwjeus/cuinfo/WEB-INF/classes/spring/app-log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-realdatasource.xml", "spring/SiteConfig.xml");
			String[] beans = context.getBeanDefinitionNames();
			
			System.out.println("\n### ManualHarvestController START\n");
			for(int i = 0; i < beans.length; i++)
			{
				
				System.out.println(beans[i]);
			}
			
			DpSpCompareController dpSpCompareController = context.getBean(DpSpCompareController.class);

			//manualHarvestController.stepbycollect(args[0], args[1], Integer.parseInt(args[2]), args[3], Integer.parseInt(args[4]), new ModelMap());
			
			//20110801 20110513 16 U 1 &
			dpSpCompareController.compare("20110909", "20110712", 8, 1, new ModelMap());
			//manualHarvestController.stepbycollect("20110713", "20110711", 16, "U", 1, new ModelMap());
			//manualHarvestController.stepbycollect("20111230", "20110501", 15, "C", 5, new ModelMap());
			
			
			//manualHarvestController.stepbycollect("20110712", "20110712", 8, "C", 1, new ModelMap());
			
			
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
	
	@RequestMapping("/compare")
	public String compare(final String sdate, final String edate, final int scheduleId, final int interval, ModelMap model) {
		
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
					int count = diff/interval + 1;
					int rest = diff%interval;
					
					int realInterval = interval;
					
					HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
					HSSFSheet sheet = hssfWorkbook.createSheet();
					HSSFRow row = sheet.createRow(0);
					row.createCell(0, HSSFCell.CELL_TYPE_STRING).setCellValue("메타등록건");
					row.createCell(1, HSSFCell.CELL_TYPE_STRING).setCellValue("메타수정건");
					row.createCell(2, HSSFCell.CELL_TYPE_STRING).setCellValue("기등록건");
					row.createCell(3, HSSFCell.CELL_TYPE_STRING).setCellValue("기수정건");
					
					for(int i = 0; i < count; i++)
					{
						if(i > 0)
						{
							scalendar.add(Calendar.DAY_OF_MONTH, -interval);
							
							if(i == count-1)
								realInterval = rest;
						}
						
						try {
							logger.info("["+simpleDateFormat.format(scalendar.getTime())+":"+realInterval+"]start");
							Schedule schedule = scheduleService.selectInfo(scheduleId);
							schedule.setHarvestDate(scalendar.getTime());
					    	schedule.setIntervals(realInterval);
							
					    	dpSpComparor.setResponseHandler(responseHandlerImpl);
					    	dpSpComparor.setUniversityId(schedule.getUniversityId());
					    	dpSpComparor.setStartDate(schedule.getHarvestSdate());
					    	dpSpComparor.setEndDate(schedule.getHarvestEdate());
					    	
					    	dpSpComparor.setHssfSheet(sheet);
							
					    	dpSpComparor.run();
							
							logger.info("["+simpleDateFormat.format(scalendar.getTime())+":"+realInterval+"]end");
						} catch (Exception e) {
							logger.error("["+simpleDateFormat.format(scalendar.getTime())+":"+realInterval+"]" + e.getMessage(), e);
						}
					}
					
					FileOutputStream fileOut = new FileOutputStream("/메타유통현황.xls");
					hssfWorkbook.write(fileOut);

				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}.start();
		
		model.addAttribute("msg", "수집을 시작했습니다.");
		
		return null;
	}
}
