package com.cyberup.schedule;

/***************************************************************************************************
 * $Id: SPHarvester.java, v 1.0 2003/10/24 revision : 2003/11/12 Copyright (C) 2003 TriGem Infonet,
 * Inc. All rights reserved.
 **************************************************************************************************/

import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import net.dcollection.common.Utils;
import net.dcollection.flow.common.Configure;
import net.dcollection.flow.common.OAISchema;
import net.dcollection.flow.manager.bean.BizHarvestBean;
import net.dcollection.flow.manager.bean.FTHistBean;
import net.dcollection.flow.manager.bean.FTJobBean;
import net.dcollection.flow.manager.dao.FTHistDAO;
import net.dcollection.flow.manager.dao.FTJobDAO;
import net.dcollection.flow.sp.ListMetadataFormats;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.SOAPException;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.InitBinder;

import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.History;
import com.cyberup.model.course.HistoryResult;
import com.cyberup.model.course.Schedule;
import com.cyberup.model.course.ScheduleType;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.service.course.HistoryService;
import com.cyberup.service.course.ScheduleService;
import com.cyberup.util.DateFormatter;
import com.cyberup.util.HtmlUtils;

@Component
public class SpHarvester implements Runnable {

    protected Logger logger = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    private ScheduleService scheduleService;
    
    protected Schedule schedule;
    protected int historyId;
    protected ResponseHandler responseHandler;
    
    public static int collectCnt = 0;
    
    
    public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public void setResponseHandler(ResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	@Autowired
	protected DataProviderService dataProviderService;
	@Autowired
	protected HistoryService historyService;
	@Autowired
	protected CourseService courseService;
    
	protected String getGranularity(String dpUrl)
    {
    	String granularity = "yyyy-MM-ddTHH:mm:ssZ";
        try{
        	CallMetadata callMetadata = new CallMetadata(dpUrl);
        	callMetadata.setJavaEncoding(responseHandler.getJavaEncoding());
        	
        	Map param = new HashMap();
        	param.put(CallMetadata.PARAM_VERB, "Identify");
        	
        	System.out.println("dpUrl : " + dpUrl);
        	System.out.println("param : " + param);
            String formatsXML = callMetadata.get(param);
            
            Document formatsDoc = OAISchema.getBuilder().build(new StringReader(formatsXML));
            Element formatsEle = formatsDoc.getRootElement();
            XPath formatsXpath = 
            	XPath.newInstance("string(/oai:OAI-PMH/oai:Identify/oai:granularity)");
            formatsXpath.addNamespace(OAISchema.getOaiXpathNS());
            formatsXpath.addNamespace(OAISchema.getXsiNS());
            granularity = (String)formatsXpath.selectSingleNode(formatsEle);
        }catch(Exception e){
        	e.printStackTrace();
        	logger.error(e.getMessage(), e);
        }
        
        return granularity;
    }
    
    public static String getMetadataPrefix(String javaEncoding, String dpUrl)
    {
    	String prefix = "KEM3.1";
        try{
        	CallMetadata callMetadata = new CallMetadata(dpUrl);
        	callMetadata.setJavaEncoding(javaEncoding);
        	
        	Map param = new HashMap();
        	param.put(CallMetadata.PARAM_VERB, "ListMetadataFormats");
        	
        	System.out.println("param : " + param);
        	
            String formatsXML = callMetadata.get(param);
            
            Document formatsDoc = OAISchema.getBuilder().build(new StringReader(formatsXML));
            Element formatsEle = formatsDoc.getRootElement();
            XPath formatsXpath = 
            	XPath.newInstance("string(/oai:OAI-PMH/oai:ListMetadataFormats/oai:metadataFormat/oai:metadataPrefix)");
            formatsXpath.addNamespace(OAISchema.getOaiXpathNS());
            formatsXpath.addNamespace(OAISchema.getXsiNS());
            //Element metadataPrefix = (Element)formatsXpath.selectSingleNode(formatsEle);
            //String prefix = metadataPrefix.getTextTrim();
            prefix = (String)formatsXpath.selectSingleNode(formatsEle);
        }catch(Exception e){
        	Logger.getLogger(SpHarvester.class).error(e.getMessage(), e);
        }
        
        return prefix;
    }
    
    protected String getFormatDate(String granularity, Date date)
    {
    	SimpleDateFormat simpleDateFormat = null;
    		
    	switch (granularity.length()) {
            case 8:
            case 10:
            case 14:
            	simpleDateFormat = new SimpleDateFormat(granularity);
                return simpleDateFormat.format(date);
            case 20:
            	simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                return simpleDateFormat.format(date) + "T" + timeFormat.format(date) + "Z";
            default:
                return null;
        }
    }
    
    protected Map settingParameter(DataProvider dataProvider, String resumptionToken)
    {
    	Map<String,String> param = new HashMap<String, String>();
    	
    	param.put(CallMetadata.PARAM_RESUMPTION_TOKEN, resumptionToken);
        //param.put(CallMetadata.PARAM_PAGE_SIZE, String.valueOf(CallMetadata.DEFAULT_PAGE_SIZE));
        //param.put(CallMetadata.PARAM_PAGE_NUM, "1");
        
        param.put(CallMetadata.PARAM_MODE, schedule.getScheduleType());
        if (schedule.getScheduleType().equals(ScheduleType.DELETE.getValue())) 
        	param.put(CallMetadata.PARAM_VERB, "ListIdentifiers");
        else
        	param.put(CallMetadata.PARAM_VERB, "ListRecords");
        
        String granularity = getGranularity(dataProvider.getDpUrl());
        param.put(CallMetadata.PARAM_FROM, getFormatDate(granularity, schedule.getHarvestSdate()));
        param.put(CallMetadata.PARAM_UNTIL, getFormatDate(granularity, schedule.getHarvestEdate()));
        
        // DP에서 설정한 metadataFormats 사용.
        String prefix = getMetadataPrefix(responseHandler.getJavaEncoding(), dataProvider.getDpUrl());
        param.put(CallMetadata.PARAM_METADATA_PREFIX, prefix);
        
        return param;
    }
    
    public static void main(String[] args) {
		new SpHarvester().test();
	}
    
    public void test()
    {
    	try {
    		Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
    		
    		
    		DataProvider dataProvider = new DataProvider();
        	dataProvider.setDpUrl("http://220.117.241.76:8081/WebService/ItemHandler");
        	System.out.println("1");
        	
        	Calendar calendar = Calendar.getInstance();
        	calendar.set(Calendar.YEAR, 2012);
        	calendar.set(Calendar.MONTH, 7);
        	calendar.set(Calendar.DAY_OF_MONTH, 9);
        	
        	System.out.println("2");
        	
        	schedule = new Schedule();
        	schedule.setScheduleType(ScheduleType.CREATE.getValue());
        	schedule.setHarvestDate(calendar.getTime());
        	schedule.setIntervals(1);
        	
        	System.out.println("3");
        	
        	responseHandler = new ResponseHandlerImpl();
        	
        	Map<String,String> param = settingParameter(dataProvider, "");
        	
        	System.out.println("4");

        	System.out.println("param : " + param);
            CallMetadata callMetadata = new CallMetadata(dataProvider.getDpUrl());
            
            
            //param.put("set", "sdfds");
            //System.out.println("param : " + param);
            
            String xml = callMetadata.get(param);
            
            System.out.println("xml start : " + xml.substring(0, 1000));
            System.out.println("xml end : " + xml.substring(xml.length()-1000, xml.length()));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	// harvesting
    public void run() {
    	
    	collectCnt = 0;

    	Map<String,String> param = null;
    		
        try {
            DataProvider dataProvider = dataProviderService.selectInfo(schedule.getUniversityId());
            
            logger.info("before settingParameter");
            param = settingParameter(dataProvider, "");
            logger.info("param : " + param);
            logger.info("after settingParameter");

            CallMetadata callMetadata = new CallMetadata(dataProvider.getDpUrl());
            callMetadata.setJavaEncoding(responseHandler.getJavaEncoding());
            
            while(true && checkScheduleStatus(param, collectCnt)) {
                try {
                	logger.info("callMetadata.get param : " + param);
                	String xml = callMetadata.get(param);
                	logger.debug("xml start : " + HtmlUtils.substring(xml, 1000, "..."));
                	if(xml.length() > 1000)
                		logger.debug("xml end : " + xml.substring(xml.length()-1000, xml.length()));
                	
                	try {
                		if (responseHandler.getJavaEncoding().equals("8859_1"))
                            xml = new String(xml.getBytes("8859_1"), "euc-kr");
                		
                        Document document = OAISchema.getBuilder().build(new StringReader(xml));

                        if(isError(param, document, collectCnt))
                        	break;

                        if (schedule.getScheduleType().equals(ScheduleType.CREATE.getValue()))
                        {
                        	responseHandler.constructDB(document, dataProvider, schedule);
                        }
                        else if(schedule.getScheduleType().equals(ScheduleType.UPDATE.getValue()))
                        {
                        	responseHandler.synchronizeDB(document, dataProvider, schedule);
                        }
                        else if(schedule.getScheduleType().equals(ScheduleType.DELETE.getValue()))
                        {
                        	responseHandler.demolishDB(document, dataProvider, schedule);
                        }

                        if(!existNextPage(param, document))
                        {
                        	updateHistory(collectCnt, HistoryResult.SUCCESS.getValue(), "");
                        	break;
                        }
                        else
                        {
                        	logger.info("exist next page : " + param);
                        }
                    
					} catch (CallMetadata.SoapException soapException) {
                        logger.error(soapException.getMessage(), soapException);
                        writeErrorHist(collectCnt, 
                        		param.get(CallMetadata.PARAM_RESUMPTION_TOKEN), 
                        		soapException.getMessage());
                        break;
					}
                }
                catch( SOAPException e ) {
                    logger.error(e.getMessage(), e);
                    writeErrorHist(collectCnt, 
                    		param.get(CallMetadata.PARAM_RESUMPTION_TOKEN), 
                    		getLogMessage(e));
                    break;
                }
            } // while loop

            logger.info("schedule : " + schedule + " is completed.");
        }
        catch( Exception e ) {
            logger.error(e.getMessage(), e);
            writeErrorHist(collectCnt, param.get(CallMetadata.PARAM_RESUMPTION_TOKEN), getLogMessage(e));
        }
        finally {
        }
    }
    
    private void updateHistory(int collectCnt, String result, String errorReason)
    {
    	if(errorReason != null && errorReason.length() > 1000)
			errorReason = errorReason.substring(0, 900) + "...";
    	
    	History history = new History();
    	history.setHistoryId(historyId);
		history.setEndDate(new Date());
		history.setCollectCnt(collectCnt);
		history.setResult(result);
		history.setErrorReason(errorReason);
		
		historyService.updateInfo(history);
    }
    
    protected boolean checkScheduleStatus(Map<String, String> param, int totalCnt)
    {
    	if(!scheduleService.selectInfo(schedule.getScheduleId()).getStatus().equals("Y"))
    	{
    		writeErrorHist(totalCnt, 
    				param.get(CallMetadata.PARAM_RESUMPTION_TOKEN), 
            		"강제종료");
    		return false;
    	}
    	else
    		return true;
    }
    
    protected boolean isError(Map<String, String> param, Document document, int totalCnt)
    {
    	Element error = document.getRootElement().getChild("error", OAISchema.getOaiNS());
        if (error != null) {
            if (error.getAttributeValue("code").equals("noRecordsMatch"))
                updateHistory(totalCnt, HistoryResult.SUCCESS.getValue(), "");
            else
                writeErrorHist(totalCnt, 
                		param.get(CallMetadata.PARAM_RESUMPTION_TOKEN), 
                		error.getAttributeValue("code") + " : " + error.getTextTrim());

            return true;
        }

        error = document.getRootElement().getChild("error");
        
        System.out.println("\n\nError = " + error + "\n\n");
        System.out.println("\n\nError1 = " + document + "\n\n");
        
        if (error != null) {
        	writeErrorHist(totalCnt, 
        			param.get(CallMetadata.PARAM_RESUMPTION_TOKEN), 
            		error.getAttributeValue("code") + " : " + error.getTextTrim());

            return true;
        }
        
        return false;
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

    private void writeErrorHist(int totalCnt, String resumptionToken, String message) {

        updateHistory(totalCnt, HistoryResult.FAIL.getValue(), "resumption token : " + resumptionToken + " page error : " + message);
    }

    protected String getLogMessage(Exception e) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);

        try {
            return sw.toString().length() > 1500?sw.toString().substring(0, 1500):sw.toString();
        }
        finally {
            pw.close();
        }
    }
}