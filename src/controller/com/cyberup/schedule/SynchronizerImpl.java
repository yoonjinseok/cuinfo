/*
 * Created on 2004. 8. 6.
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cyberup.schedule;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.stereotype.Component;

import com.cyberup.model.course.Course;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Schedule;

/**
 * @author BACCHUS * Preferences - Java - Code Style - Code Templates
 */
@Component
public class SynchronizerImpl extends ConstructorImpl {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	public void synchronizeItem(Document document, DataProvider dataProvider, Schedule schedule) throws Exception 
	{
		init();
		
		this.dataProvider = dataProvider;
		
		Iterator recIter = getRecords(document);
		
		while (recIter.hasNext()) {
			Element recEle = (Element) recIter.next();

			Course course = mapping(recEle, "schedule");
			
			// 중복 체크
			List<Integer> courseIds = courseService.selectIdsOfIdentifier(dataProvider.getUniversityId(), course.getCourseIdentifier(), "");
			if(courseIds.size() > 0)
			{
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
			else
			{
				try {
					courseService.construct(course);
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
			
			SpHarvester.collectCnt++;
		}

		return;
	}
	
}