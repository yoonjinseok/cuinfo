/*
 * Created on 2004. 8. 6.
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cyberup.schedule;

import java.util.Iterator;
import java.util.List;

import net.dcollection.flow.common.OAISchema;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.xpath.XPath;
import org.springframework.stereotype.Component;

import com.cyberup.model.course.Course;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.MetaData;
import com.cyberup.model.course.Schedule;

/**
 * @author BACCHUS * Preferences - Java - Code Style - Code Templates
 */
@Component
public class DemolisherImpl extends ConstructorImpl {
	Logger logger = Logger.getLogger(this.getClass());
	
	protected Iterator getHeaders(Document document) throws Exception
	{
		XPath xpath = XPath.newInstance("/oai:OAI-PMH/oai:ListIdentifiers/oai:header");
		xpath.addNamespace(OAISchema.getOaiXpathNS());

		return xpath.selectNodes(document.getRootElement()).iterator();
	}
	protected String getCourseIdentifier(Element header) throws Exception
	{
		XPath xpath = XPath.newInstance("oai:identifier");
		xpath.addNamespace(OAISchema.getOaiNS());
		xpath.addNamespace(OAISchema.getOaiXpathNS());
		Element element = (Element) xpath.selectSingleNode(header);
		
		return element.getTextTrim();
	}
	public void demolishItem(Document document, DataProvider dataProvider, Schedule schedule) throws Exception 
	{
		init();
		
		this.dataProvider = dataProvider;
		
		Iterator recIter = getHeaders(document);
		
		while (recIter.hasNext()) {
			Element header = (Element) recIter.next();

			String courseIdentifier = getCourseIdentifier(header);
			
			try {
				List<Integer> courseIds = courseService.selectIdsOfIdentifier(dataProvider.getUniversityId(), courseIdentifier, "");
				for(int k = 0; k < courseIds.size(); k++)
				{
					courseService.updateDeleteInfo(courseIds.get(k), "schedule");
				}
				
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
			SpHarvester.collectCnt++;
		}

		return;
	}
	
}