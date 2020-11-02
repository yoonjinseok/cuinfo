package com.cyberup.schedule;

import java.io.File;
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
import com.cyberup.service.course.DataProviderService;
import com.cyberup.util.DateFormatter;
import com.cyberup.util.HtmlUtils;

@Component
public class ExcelDownloader {
	private Logger logger = Logger.getLogger(ExcelDownloader.class);
	
	@Autowired
	protected DataProviderService dataProviderService;
	
	private HSSFWorkbook hssfWorkbook;
    private HSSFSheet courseSheet;
    private HSSFSheet lectureSheet;
    
    public int collectCnt = 0;
	
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
			
			ExcelDownloader excelDownloader = context.getBean(ExcelDownloader.class);
			
			excelDownloader.init();
			
			Date fromDate = new Date();
			fromDate.setYear(2011-1900);
			fromDate.setMonth(7);
			fromDate.setDate(4);
			Date toDate = new Date();
			toDate.setMonth(7);
			toDate.setDate(4);
			
			/*fromDate.setYear(2001-1900);
			fromDate.setMonth(6);
			fromDate.setDate(13);*/
			
			/*Date fromDate = new Date();
			fromDate.setMonth(6);
			fromDate.setDate(10);
			Date toDate = new Date();
			toDate.setMonth(6);
			toDate.setDate(12);*/
			
			excelDownloader.execute(14, ScheduleType.CREATE.getValue(), getHarvestSdate(fromDate), getHarvestEdate(toDate), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws Exception
	{
		
		logger.debug("init start");
		
		hssfWorkbook = new HSSFWorkbook();
		courseSheet = hssfWorkbook.createSheet("강좌 메타데이터 작성 양식");
		HSSFRow row = courseSheet.createRow(0);
		row.createCell(0, HSSFCell.CELL_TYPE_STRING).setCellValue("대학코드");
		row.createCell(1, HSSFCell.CELL_TYPE_STRING).setCellValue("Course Identifier");
		row.createCell(2, HSSFCell.CELL_TYPE_STRING).setCellValue("학과명");
		row.createCell(3, HSSFCell.CELL_TYPE_STRING).setCellValue("학과코드");
		row.createCell(4, HSSFCell.CELL_TYPE_STRING).setCellValue("개설년도");
		row.createCell(5, HSSFCell.CELL_TYPE_STRING).setCellValue("학기");
		row.createCell(6, HSSFCell.CELL_TYPE_STRING).setCellValue("교수자");
		row.createCell(7, HSSFCell.CELL_TYPE_STRING).setCellValue("인정학점");
		row.createCell(8, HSSFCell.CELL_TYPE_STRING).setCellValue("언어");
		row.createCell(9, HSSFCell.CELL_TYPE_STRING).setCellValue("강좌명");
		row.createCell(10, HSSFCell.CELL_TYPE_STRING).setCellValue("강좌설명");
		row.createCell(11, HSSFCell.CELL_TYPE_STRING).setCellValue("개설일");
		row.createCell(12, HSSFCell.CELL_TYPE_STRING).setCellValue("종료일");
		
		lectureSheet = hssfWorkbook.createSheet("강의 메타데이터 작성 양식");
		HSSFRow lecrow = lectureSheet.createRow(0);
		lecrow.createCell(0, HSSFCell.CELL_TYPE_STRING).setCellValue("차시");
		lecrow.createCell(1, HSSFCell.CELL_TYPE_STRING).setCellValue("번호");
		lecrow.createCell(2, HSSFCell.CELL_TYPE_STRING).setCellValue("Course Identifier");
		lecrow.createCell(3, HSSFCell.CELL_TYPE_STRING).setCellValue("Lecture Identifier");
		lecrow.createCell(4, HSSFCell.CELL_TYPE_STRING).setCellValue("강의명");
		lecrow.createCell(5, HSSFCell.CELL_TYPE_STRING).setCellValue("강의설명(선택사항)");
		
		logger.debug("init success");
	}
	
	public void execute(int universityId, String scheduleType, Calendar from, Calendar to, int intervals)
	{
		try {
			Calendar scalendar = Calendar.getInstance();
			scalendar.setTime(to.getTime());
			scalendar.set(Calendar.HOUR_OF_DAY, 0);
			scalendar.set(Calendar.MINUTE, 0);
			scalendar.set(Calendar.SECOND, 0);
			
			scalendar.add(Calendar.DAY_OF_MONTH, -intervals+1);
			
			DataProvider dataProvider = dataProviderService.selectInfo(universityId);
			
			int diff = getDiffOfDay(to, from);
			int count = diff/intervals;
			int rest = diff%intervals;
			if(rest > 0)
				count++;
			
			logger.debug("from : "+new DateFormatter().print(from.getTime(), Locale.getDefault())+", to : "+new DateFormatter().print(to.getTime(), Locale.getDefault())+", count : " + count);
			
			int realInterval = intervals;
			
			for(int i = 0; i < count; i++)
			{
				if(i > 0)
				{
					if(i == count-1 && rest > 0)
						realInterval = rest;
					
					scalendar.add(Calendar.DAY_OF_MONTH, -realInterval);
					to.add(Calendar.DAY_OF_MONTH, -intervals);
				}
				
				try {
					logger.info("["+simpleDateFormat.format(to.getTime())+":"+realInterval+"]start");
					
					run(dataProvider, scheduleType, scalendar.getTime(), to.getTime());
					
					logger.info("["+simpleDateFormat.format(to.getTime())+":"+realInterval+"]end");
				} catch (Exception e) {
					logger.error("["+simpleDateFormat.format(to.getTime())+":"+realInterval+"]" + e.getMessage(), e);
				}
			}
			
			File file = new File("/"+dataProvider.getUniversityName()+".xls");
			FileOutputStream fileOut = new FileOutputStream(file, false);
			hssfWorkbook.write(fileOut);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}
	
	protected Map settingParameter(DataProvider dataProvider, String scheduleType, String resumptionToken, Date sdate, Date edate)
    {
    	Map<String,String> param = new HashMap<String, String>();
    	
    	param.put(CallMetadata.PARAM_RESUMPTION_TOKEN, resumptionToken);
        //param.put(CallMetadata.PARAM_PAGE_SIZE, String.valueOf(CallMetadata.DEFAULT_PAGE_SIZE));
        //param.put(CallMetadata.PARAM_PAGE_NUM, "1");
        
        param.put(CallMetadata.PARAM_MODE, scheduleType);
        if (scheduleType.equals(ScheduleType.DELETE.getValue())) 
        	param.put(CallMetadata.PARAM_VERB, "ListIdentifiers");
        else
        	param.put(CallMetadata.PARAM_VERB, "ListRecords");
        
        param.put(CallMetadata.PARAM_FROM, getFormatDate(sdate));
        param.put(CallMetadata.PARAM_UNTIL, getFormatDate(edate));
        
        // DP에서 설정한 metadataFormats 사용.
        param.put(CallMetadata.PARAM_METADATA_PREFIX, "KEM3.1");
        
        return param;
    }
	protected String getFormatDate(Date date)
    {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    	return simpleDateFormat.format(date);
    }
	
	public void run(DataProvider dataProvider, String scheduleType, Date sdate, Date edate) {
    	
    	collectCnt = 0;

    	Map<String,String> param = null;
    		
        try {
            logger.info("before settingParameter");
            param = settingParameter(dataProvider, scheduleType, "", sdate, edate);
            logger.info("param : " + param);
            logger.info("after settingParameter");

            CallMetadata callMetadata = new CallMetadata(dataProvider.getDpUrl());
            callMetadata.setJavaEncoding("8859_1");
            
            while(true) {
                try {
                	logger.info("callMetadata.get param : " + param);
                	String xml = callMetadata.get(param);
                	xml = new String(xml.getBytes("8859_1"), "euc-kr");
                	
                	logger.debug("xml start : " + HtmlUtils.substring(xml, 1000, "..."));
                	if(xml.length() > 1000)
                		logger.debug("xml end : " + xml.substring(xml.length()-1000, xml.length()));
                	
                	try {
                        Document document = OAISchema.getBuilder().build(new StringReader(xml));

                        if(isError(param, document, collectCnt))
                        	break;

                        parseXML(dataProvider.getUniversityId(), document);

                        if(!existNextPage(param, document))
                        {
                        	break;
                        }
                        else
                        {
                        	logger.info("exist next page : " + param);
                        }
                    
					} catch (CallMetadata.SoapException soapException) {
                        logger.error(soapException.getMessage(), soapException);
                        break;
					}
                }
                catch( SOAPException e ) {
                    logger.error(e.getMessage(), e);
                    break;
                }
            } // while loop
        }
        catch( Exception e ) {
            logger.error(e.getMessage(), e);
        }
        finally {
        }
    }
	
	protected Iterator getRecords(Document document) throws Exception
	{
		XPath xpath = XPath.newInstance("/oai:OAI-PMH/oai:ListRecords/oai:record");
		xpath.addNamespace(OAISchema.getOaiXpathNS());

		return xpath.selectNodes(document.getRootElement()).iterator();
	}
	
	private boolean alreadyIdentifier(String identifier)
	{
		for(int i = 0; i < courseSheet.getLastRowNum(); i++)
		{
			if(courseSheet.getRow(i).getCell(1).getStringCellValue().equals(identifier))
				return true;
		}
		return false;
	}
	public void parseXML(int universityId, Document document) throws Exception
	{
		Iterator recIter = getRecords(document);
		
		XPath xpath = null;
		Element element = null;
		String[] elements = {"universityId", "identifier","department","departmentcode","termyear","termth","contributor","credit","language","title","description","startdate","enddate"};
		String[] lecelements = {"groups", "orders","identifier","lecIdentifier","title","description"};
		for (int i = 0; recIter.hasNext(); i++) {
			Element recEle = (Element) recIter.next();
			
			xpath = XPath.newInstance("oai:metadata/oai:course/oai:identifier");
			xpath.addNamespace(OAISchema.getOaiNS());
			xpath.addNamespace(OAISchema.getOaiXpathNS());
			element = (Element) xpath.selectSingleNode(recEle);
			if(element == null)
				element = new Element("identifier");
			if(alreadyIdentifier(element.getTextTrim()))
				continue;
			
			HSSFRow row = courseSheet.createRow(courseSheet.getLastRowNum()+1);
			
			for(int k = 0; k < elements.length; k++)
			{
				if(elements[k].equals("universityId")
						|| elements[k].equals("contributor"))
				{
					if(elements[k].equals("universityId"))
					{
						row.createCell(k, HSSFCell.CELL_TYPE_STRING).setCellValue(universityId);
					}
					else if(elements[k].equals("contributor"))
					{
						xpath = XPath.newInstance("oai:metadata/oai:course/oai:contributorList/oai:contributor");
						xpath.addNamespace(OAISchema.getOaiNS());
						xpath.addNamespace(OAISchema.getOaiXpathNS());
						List list = xpath.selectNodes(recEle);
						if(list != null && list.size() > 0)
						{
							Element contributorElement = (Element)list.get(0);
							
							xpath = XPath.newInstance("oai:" + elements[k]);
							xpath.addNamespace(OAISchema.getOaiNS());
							xpath.addNamespace(OAISchema.getOaiXpathNS());
							element = (Element) xpath.selectSingleNode(contributorElement);
							if(element == null)
								element = new Element(elements[k]);
						}
						else
						{
							element = new Element(elements[k]);
						}
						
						row.createCell(k, HSSFCell.CELL_TYPE_STRING).setCellValue(element.getTextTrim());
					}
				}
				else
				{
					xpath = XPath.newInstance("oai:metadata/oai:course/oai:" + elements[k]);
					xpath.addNamespace(OAISchema.getOaiNS());
					xpath.addNamespace(OAISchema.getOaiXpathNS());
					element = (Element) xpath.selectSingleNode(recEle);
					if(element == null)
						element = new Element(elements[k]);
						
					row.createCell(k, HSSFCell.CELL_TYPE_STRING).setCellValue(element.getTextTrim());
				}
			}
			
			
			xpath = XPath.newInstance("oai:metadata/oai:course/oai:lectureList/oai:lecture");
			xpath.addNamespace(OAISchema.getOaiNS());
			xpath.addNamespace(OAISchema.getOaiXpathNS());
			List list = xpath.selectNodes(recEle);
			if(list != null)
			{
				for(int c = 0; c < list.size(); c++)
				{
					HSSFRow lecrow = lectureSheet.createRow(lectureSheet.getLastRowNum()+1);
					
					Element lectureElement = (Element)list.get(c);
					
					for(int k = 0; k < lecelements.length; k++)
					{
						xpath = XPath.newInstance("oai:" + lecelements[k]);
						xpath.addNamespace(OAISchema.getOaiNS());
						xpath.addNamespace(OAISchema.getOaiXpathNS());
						element = (Element) xpath.selectSingleNode(lectureElement);
						if(element == null)
							element = new Element(lecelements[k]);
						
						lecrow.createCell(k, HSSFCell.CELL_TYPE_STRING).setCellValue(element.getTextTrim());
					}
				}
			}
		}
	}
	
	protected boolean existNextPage(Map<String,String> param, Document document) throws Exception
    {
        XPath xpath = null;
        if(param.get(CallMetadata.PARAM_VERB).equals("ListIdentifiers"))
        {
        	xpath = XPath.newInstance("/oai:OAI-PMH/oai:ListIdentifiers/oai:resumptionToken");
            xpath.addNamespace(OAISchema.getOaiXpathNS());
        }
        else
        {
        	xpath = XPath.newInstance("/oai:OAI-PMH/oai:ListRecords/oai:resumptionToken");
            xpath.addNamespace(OAISchema.getOaiXpathNS());
        }

        Element rtEle = (Element)xpath.selectSingleNode(document.getRootElement());
        if (rtEle.getTextTrim().length() != 0) {
        	param.put(CallMetadata.PARAM_RESUMPTION_TOKEN, rtEle.getTextTrim());
            return true;
        }
        else
        	return false;
    }
	
	protected boolean isError(Map<String, String> param, Document document, int totalCnt)
    {
    	Element error = document.getRootElement().getChild("error", OAISchema.getOaiNS());
        if (error != null) {

            return true;
        }

        error = document.getRootElement().getChild("error");
        
        System.out.println("\n\nError = " + error + "\n\n");
        System.out.println("\n\nError1 = " + document + "\n\n");
        
        if (error != null) {
            return true;
        }
        
        return false;
    }
	
	private int getDiffOfDay(Calendar date1, Calendar date2)
	{
		long Bring = (date1.getTimeInMillis()-date2.getTimeInMillis());
		int days = (int)(Bring / (60*60*24*1000))+1; // 1/1000초  단위를 날짜로 환산.
		
		return days;
	}
	
	public static Calendar getHarvestSdate(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return cal;
	}
	
	public static Calendar getHarvestEdate(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return cal;
	}
}
