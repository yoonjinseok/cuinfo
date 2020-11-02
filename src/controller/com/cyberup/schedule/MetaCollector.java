/*
 * Created on 2004. 8. 6.
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cyberup.schedule;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import net.dcollection.flow.common.OAISchema;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

import com.cyberup.model.course.Course;
import com.cyberup.model.course.CourseStatus;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.MetaData;
import com.cyberup.service.course.DataProviderService;

/**
 * @author BACCHUS * Preferences - Java - Code Style - Code Templates
 */
@Component
public class MetaCollector extends ConstructorImpl implements Runnable {
	Logger logger = Logger.getLogger(this.getClass());
	
	private Course preCourse;
	private String modifier;
	
	@Autowired
	private DataProviderService dataProviderService;
	
	private ResponseHandler responseHandler;
	
	public void setPreCourse(Course preCourse) {
		this.preCourse = preCourse;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public void setResponseHandler(ResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	public void init()
	{
		super.init();
		
		dataProvider = dataProviderService.selectInfo(preCourse.getUniversityId());
	}
	
	public void run() {
		try {
			init();
			
			CallMetadata callMetadata = new CallMetadata(dataProvider.getDpUrl());
	        callMetadata.setJavaEncoding(responseHandler.getJavaEncoding());
	        
	        String xml = callMetadata.get(settingParameter(dataProvider, ""));
	        
	        if (responseHandler.getJavaEncoding().equals("8859_1"))
                xml = new String(xml.getBytes("8859_1"), "euc-kr");
	        
	        System.out.println("xml : " + xml);
    		
            Document document = OAISchema.getBuilder().build(new StringReader(xml));
            
            if(isError(document))
            	return;
            
            Element record = getRecord(document);
            
            Course course = mapping(record, this.modifier);
            
            // 서비스 테이블 반영
            courseService.reconstruct(preCourse, course, CourseStatus.COMMIT.getValue());
            
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(e.getMessage(), e);
		}
        
	}
	
	protected Element getRecord(Document document) throws Exception
	{
		XPath xpath = XPath.newInstance("/oai:OAI-PMH/oai:GetRecord/oai:record");
		xpath.addNamespace(OAISchema.getOaiXpathNS());

		return (Element)xpath.selectSingleNode(document.getRootElement());
	}
	
	private boolean isError(Document document)
    {
    	Element error = document.getRootElement().getChild("error", OAISchema.getOaiNS());
        if (error != null) {
            if (error.getAttributeValue("code").equals("noRecordsMatch"))
                logger.warn("course id : "+preCourse.getCourseId()+" is noRecordsMatch");
            else
            	logger.warn("course id : "+preCourse.getCourseId()+" is soap error(code : "+error.getAttributeValue("code")+", message : "+error.getTextTrim()+").");

            return true;
        }

        error = document.getRootElement().getChild("error");
        if (error != null) {
        	logger.warn("course id : "+preCourse.getCourseId()+" is soap error(code : "+error.getAttributeValue("code")+", message : "+error.getTextTrim()+").");

            return true;
        }
        
        return false;
    }
	
	private Map settingParameter(DataProvider dataProvider, String resumptionToken)
    {
    	Map<String,String> param = new HashMap<String, String>();
    	
    	param.put(CallMetadata.PARAM_RESUMPTION_TOKEN, resumptionToken);
        
    	param.put(CallMetadata.PARAM_VERB, "GetRecord");
        
        // DP에서 설정한 metadataFormats 사용.
        String prefix = SpHarvester.getMetadataPrefix(responseHandler.getJavaEncoding(), dataProvider.getDpUrl());
        param.put(CallMetadata.PARAM_METADATA_PREFIX, prefix);
        
        param.put(CallMetadata.PARAM_IDENTIFIER, preCourse.getCourseIdentifier());
        
        return param;
    }
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-datasource.xml", "spring/SiteConfig.xml");
			String[] beans = context.getBeanDefinitionNames();
			for(int i = 0; i < beans.length; i++)
			{
				System.out.println(beans[i]);
			}
			
			Course preCourse = new Course();
			preCourse.setCourseId(18);
			preCourse.setCourseIdentifier("17|2011|02|201203SA0100520120301");
			preCourse.setUniversityId(8);
			
			MetaCollector metaCollector = context.getBean(MetaCollector.class);
			metaCollector.setModifier("modifier");
			metaCollector.setPreCourse(preCourse);
			metaCollector.setResponseHandler(context.getBean(ResponseHandlerImpl.class));
			
			metaCollector.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}