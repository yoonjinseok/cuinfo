package com.cyberup.schedule;

/***************************************************************************************************
 * $Id: SPHarvester.java, v 1.0 2003/10/24 revision : 2003/11/12 Copyright (C) 2003 TriGem Infonet,
 * Inc. All rights reserved.
 **************************************************************************************************/

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Schedule;
import com.cyberup.model.course.ScheduleType;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.util.HtmlUtils;

@Component
public class DpSpComparor {

    protected Logger logger = Logger.getLogger(this.getClass().getName());
    
    private Integer universityId;
    private Date startDate;
    private Date endDate;
    private ResponseHandler responseHandler;
    private HSSFSheet hssfSheet;
    
	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setResponseHandler(ResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	public void setHssfSheet(HSSFSheet hssfSheet) {
		this.hssfSheet = hssfSheet;
	}



	@Autowired
    private DataProviderService dataProviderService;
	@Autowired
	private CourseService courseService;
    
    private String getGranularity(String dpUrl)
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
        	Logger.getLogger(DpSpComparor.class).error(e.getMessage(), e);
        }
        
        return prefix;
    }
    
    private String getFormatDate(String granularity, Date date)
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
    
    private Map settingParameter(DataProvider dataProvider, String scheduleType, String resumptionToken)
    {
    	Map<String,String> param = new HashMap<String, String>();
    	
    	param.put(CallMetadata.PARAM_RESUMPTION_TOKEN, resumptionToken);
        
        param.put(CallMetadata.PARAM_MODE,scheduleType);
        if (scheduleType.equals(ScheduleType.DELETE.getValue())) 
        	param.put(CallMetadata.PARAM_VERB, "ListIdentifiers");
        else
        	param.put(CallMetadata.PARAM_VERB, "ListRecords");
        
        String granularity = getGranularity(dataProvider.getDpUrl());
        param.put(CallMetadata.PARAM_FROM, getFormatDate(granularity, startDate));
        param.put(CallMetadata.PARAM_UNTIL, getFormatDate(granularity, endDate));
        
        // DP에서 설정한 metadataFormats 사용.
        String prefix = getMetadataPrefix(responseHandler.getJavaEncoding(), dataProvider.getDpUrl());
        param.put(CallMetadata.PARAM_METADATA_PREFIX, prefix);
        
        return param;
    }

	// harvesting
    public void run() {

    	Map<String,String> param = null;
    		
        try {
            DataProvider dataProvider = dataProviderService.selectInfo(universityId);
            
            param = settingParameter(dataProvider, ScheduleType.CREATE.getValue(), "");
//            int regCnt = getOAIMetaCnt(dataProvider, param);
//        	logger.info("callMetadata.get reg totalCnt : " + regCnt);
        	
        	param = settingParameter(dataProvider, ScheduleType.UPDATE.getValue(), "");
//        	int modCnt = getOAIMetaCnt(dataProvider, param);
//        	logger.info("callMetadata.get mod totalCnt : " + modCnt);
        	
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        	Map<String, BigDecimal> courseCnt = courseService.selectHarvestCnt(universityId, simpleDateFormat.format(startDate), simpleDateFormat.format(endDate));
//        	logger.info("course totalCnt : " + courseCnt);
        	
//        	writeExcelRow(regCnt, modCnt, courseCnt.get("REGCNT").intValue(), courseCnt.get("MODCNT").intValue());
        }
        catch( Exception e ) {
            logger.error(e.getMessage(), e);
        }
        finally {
        }
    }


    private void writeExcelRow(int regCnt, int modCnt, int courseRegCnt, int courseModCnt)
    {
    	HSSFRow row = hssfSheet.createRow(hssfSheet.getLastRowNum() + 1);
    	row.createCell(0, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(regCnt);
    	row.createCell(1, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(modCnt);
    	row.createCell(2, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(courseRegCnt);
    	row.createCell(3, HSSFCell.CELL_TYPE_NUMERIC).setCellValue(courseModCnt);
    }
    
    public static int getTotalCntOfListRecords(Document document) throws Exception
    {
    	Element error = document.getRootElement().getChild("error", OAISchema.getOaiNS());
        if (error != null) {
            if (error.getAttributeValue("code").equals("noRecordsMatch"))
            	return 0;
            else
            {
            	return -1;
            }
        }
        else
        {
        	XPath xpath = XPath.newInstance("/oai:OAI-PMH/oai:ListRecords/oai:record/oai:header/oai:totalCnt");
            xpath.addNamespace(OAISchema.getOaiXpathNS());

            Element rtEle = (Element)xpath.selectSingleNode(document.getRootElement());
            if (rtEle.getTextTrim().length() != 0) {
                return Integer.parseInt(rtEle.getTextTrim());
            }
            else
            	return 0;
        }
    }

    private String getLogMessage(Exception e) {

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