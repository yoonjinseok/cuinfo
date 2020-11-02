/*
 * Created on 2004. 8. 6.
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cyberup.schedule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.dcollection.flow.common.OAISchema;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyberup.model.course.CollectionType;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Lecture;
import com.cyberup.model.course.Material;
import com.cyberup.model.course.MetaDic;
import com.cyberup.model.course.Schedule;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.MetaDicService;

/**
 * @author BACCHUS * Preferences - Java - Code Style - Code Templates
 */
@Component
public class ConstructorImpl {
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	protected CourseService courseService;
	@Autowired
	protected MetaDicService metaDicService;
	
	private List<MetaDic> courseMeta;
	private List<MetaDic> lectureMeta;
	private List<MetaDic> lectureFileMeta;
	private List<MetaDic> contributorMeta;
	
	protected DataProvider dataProvider;
	
	protected void init()
	{
		courseMeta = metaDicService.selectList(CollectionType.COURSE.getValue());
		lectureMeta = metaDicService.selectList(CollectionType.LECTURE.getValue());
		lectureFileMeta = metaDicService.selectList(CollectionType.LECFILE.getValue());
		contributorMeta = metaDicService.selectList(CollectionType.CONTRIBUTOR.getValue());
	}
	
	protected Iterator getRecords(Document document) throws Exception
	{
		XPath xpath = XPath.newInstance("/oai:OAI-PMH/oai:ListRecords/oai:record");
		xpath.addNamespace(OAISchema.getOaiXpathNS());

		return xpath.selectNodes(document.getRootElement()).iterator();
	}
	
	public void constructItem(Document document, DataProvider dataProvider, Schedule schedule) throws Exception 
	{
		init();
		
		this.dataProvider = dataProvider;
		
		Logger.getLogger(this.getClass()).info("construct document(collectCnt : "+SpHarvester.collectCnt+") : " + document);
		
		Iterator recIter = getRecords(document);
		
		for (int i = 0; recIter.hasNext(); i++) {
			Element recEle = (Element) recIter.next();
			
			Logger.getLogger(this.getClass()).info("construct record(collectCnt : "+SpHarvester.collectCnt+" inx : "+i+") : " + recEle);

			Course course = mapping(recEle, "schedule");
			Logger.getLogger(this.getClass()).info("construct mapping(collectCnt : "+SpHarvester.collectCnt+" inx : "+i+") : mapping success");
			
			// 중복 체크
			List<Integer> courseIds = courseService.selectIdsOfIdentifier(dataProvider.getUniversityId(), course.getCourseIdentifier(), "");
			Logger.getLogger(this.getClass()).info("construct preCourse(collectCnt : "+SpHarvester.collectCnt+" inx : "+i+") : get precourse");
			if(courseIds.size() == 0)
			{
				try {
					logger.info(course.toString() + " construct start(collectCnt : "+SpHarvester.collectCnt+" inx : "+i+")");
					// 서비스 테이블 반영
					courseService.construct(course); 
					
					logger.info(course.getCourseIdentifier() + " constructed(collectCnt : "+SpHarvester.collectCnt+" inx : "+i+")");
				} catch (Exception e) {
					logger.error("course error(collectCnt : "+SpHarvester.collectCnt+" inx : "+i+") : "+course+" construct error \n" + e.getMessage(), e);
				}
			}
			else
			{
				logger.info("course exist(collectCnt : "+SpHarvester.collectCnt+" inx : "+i+") : "+ course.getCourseIdentifier() + " already exist");
				try {
					if(courseIds.size() > 1)
						courseService.demolish(courseIds.get(1));
					
					Course preCourse = courseService.selectInfo(courseIds.get(0));
					
					if(StringUtils.isEmpty(preCourse.getIsLock()) || preCourse.getIsLock().equals("N"))
					{
						courseService.synchronize(schedule.getHarvestSdate()
								, schedule.getHarvestEdate(), 
								preCourse, 
								course);
					}
					else
					{
						course.setIsTemp("Y");
						courseService.construct(course);
					}
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
			
			SpHarvester.collectCnt++;
		}

		return;
	}
	
	protected Course mapping(Element record, String modifier) throws Exception
	{
		Course course = new Course();
		course.init(dataProvider.getUniversityId(), modifier);
		
		XPath xpath = null;
		MetaDic metaDic = null;
		for(int i = 0; i < courseMeta.size(); i++)
		{
			metaDic = courseMeta.get(i);
			xpath = XPath.newInstance("oai:metadata/oai:course/oai:" + metaDic.getElement());
			xpath.addNamespace(OAISchema.getOaiNS());
			xpath.addNamespace(OAISchema.getOaiXpathNS());
			Element element = (Element) xpath.selectSingleNode(record);
			if(element == null)
				element = new Element(metaDic.getElement());
			
			course.mapping(metaDic, element);
		}
		
		xpath = XPath.newInstance("oai:metadata/oai:course/oai:contributorList/oai:contributor");
		xpath.addNamespace(OAISchema.getOaiNS());
		xpath.addNamespace(OAISchema.getOaiXpathNS());
		List elements = xpath.selectNodes(record);
		if(elements != null)
		{
			for(int c = 0; c < elements.size(); c++)
			{
				Element contributorElement = (Element)elements.get(c);
				
				String role = null;
				String contributor = null;
				for(int i = 0; i < contributorMeta.size(); i++)
				{
					metaDic = contributorMeta.get(i);
					xpath = XPath.newInstance("oai:" + metaDic.getElement());
					xpath.addNamespace(OAISchema.getOaiNS());
					xpath.addNamespace(OAISchema.getOaiXpathNS());
					Element element = (Element) xpath.selectSingleNode(contributorElement);
					if(element == null)
						element = new Element(metaDic.getElement());
					
					if(metaDic.getElement().equals("role"))
						role = element.getTextTrim();
					else if(metaDic.getElement().equals("contributor"))
						contributor = element.getTextTrim();
					
					if(!StringUtils.isEmpty(contributor))
					{
						if(role.equals("A") 
							|| role.equals("R")
							|| role.equals("M"))
							course.setManager(contributor);
					}
				}
			}
		}
		
		List<Lecture> lectureList = new ArrayList();
		xpath = XPath.newInstance("oai:metadata/oai:course/oai:lectureList/oai:lecture");
		xpath.addNamespace(OAISchema.getOaiNS());
		xpath.addNamespace(OAISchema.getOaiXpathNS());
		elements = xpath.selectNodes(record);
		if(elements != null)
		{
			for(int c = 0; c < elements.size(); c++)
			{
				Element lectureElement = (Element)elements.get(c);
				
				Lecture lecture = new Lecture();
				lecture.init();
				for(int i = 0; i < lectureMeta.size(); i++)
				{
					metaDic = lectureMeta.get(i);
					xpath = XPath.newInstance("oai:" + metaDic.getElement());
					xpath.addNamespace(OAISchema.getOaiNS());
					xpath.addNamespace(OAISchema.getOaiXpathNS());
					Element element = (Element) xpath.selectSingleNode(lectureElement);
					if(element == null)
						element = new Element(metaDic.getElement());
					
					lecture.mapping(metaDic, element);
				}
				
				List<Material> lecFileList = new ArrayList();
				xpath = XPath.newInstance("oai:lecFileList/oai:lecFile");
				xpath.addNamespace(OAISchema.getOaiNS());
				xpath.addNamespace(OAISchema.getOaiXpathNS());
				List fileElements = xpath.selectNodes(lectureElement);
				if(fileElements != null)
				{
					for(int f = 0; f < fileElements.size(); f++)
					{
						Element lecFileElement = (Element)fileElements.get(f);
						
						Material lecFile = new Material();
						for(int i = 0; i < lectureFileMeta.size(); i++)
						{
							metaDic = lectureFileMeta.get(i);
							xpath = XPath.newInstance("oai:" + metaDic.getElement());
							xpath.addNamespace(OAISchema.getOaiNS());
							xpath.addNamespace(OAISchema.getOaiXpathNS());
							Element element = (Element) xpath.selectSingleNode(lecFileElement);
							if(element == null)
								element = new Element(metaDic.getElement());
							
							lecFile.mapping(metaDic, element);
						}
						lecFileList.add(lecFile);
					}
				}
				lecture.setLecFileList(lecFileList);
				
				xpath = XPath.newInstance("oai:lecContributorList/oai:lecContributor");
				xpath.addNamespace(OAISchema.getOaiNS());
				xpath.addNamespace(OAISchema.getOaiXpathNS());
				List contributorElements = xpath.selectNodes(lectureElement);
				if(contributorElements != null)
				{
					for(int f = 0; f < contributorElements.size(); f++)
					{
						Element lecContributorElement = (Element)contributorElements.get(f);
						
						String role = null;
						String contributor = null;
						for(int i = 0; i < contributorMeta.size(); i++)
						{
							metaDic = contributorMeta.get(i);
							xpath = XPath.newInstance("oai:" + metaDic.getElement());
							xpath.addNamespace(OAISchema.getOaiNS());
							xpath.addNamespace(OAISchema.getOaiXpathNS());
							Element element = (Element) xpath.selectSingleNode(lecContributorElement);
							if(element == null)
								element = new Element(metaDic.getElement());
							
							if(metaDic.getElement().equals("role"))
								role = element.getTextTrim();
							else if(metaDic.getElement().equals("contributor"))
								contributor = element.getTextTrim();
							
							if(!StringUtils.isEmpty(contributor))
							{
								if(role.equals("A") 
									|| role.equals("R")
									|| role.equals("M"))
									lecture.setMaster(contributor);
							}
						}
					}
				}
				
				lectureList.add(lecture);
			}
		}
		course.setLectureList(lectureList);
		
		course.checkStatus();
		
		return course;
	}
}