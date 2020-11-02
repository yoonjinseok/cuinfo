package com.cyberup.schedule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.dcollection.flow.common.OAISchema;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.soap.SOAPException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.ScheduleType;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.service.course.LectureService;
import com.cyberup.util.DateFormatter;
import com.cyberup.util.HtmlUtils;

@Component
public class ExcelLoader {
	private Logger logger = Logger.getLogger(ExcelLoader.class);
	
	@Autowired
	protected DataProviderService dataProviderService;
	
	private HSSFWorkbook hssfWorkbook;
    private HSSFSheet sheet;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("src/conf/spring/batch-log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-datasource.xml", "spring/SiteConfig.xml");
			String[] beans = context.getBeanDefinitionNames();
			for(int i = 0; i < beans.length; i++)
			{
				System.out.println(beans[i]);
			}
			
			ExcelLoader excelLoader = context.getBean(ExcelLoader.class);
			
			excelLoader.execute(14);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void execute(int universityId)
	{
		try {
			DataProvider dataProvider = dataProviderService.selectInfo(universityId);
			
			File file = new File("/"+dataProvider.getUniversityName()+".xls");
			FileInputStream fileInputStream = new FileInputStream(file);
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
			
			int rownum = sheet.getLastRowNum();
			HSSFRow row = null;
			for(int i = 0; i < rownum; i++)
			{
				row = sheet.getRow(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}
}
