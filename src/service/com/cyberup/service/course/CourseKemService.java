package com.cyberup.service.course;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.CourseKemDao;
import com.cyberup.dao.course.CourseKemLongDao;
import com.cyberup.dao.course.MetaDicDao;
import com.cyberup.model.course.CollectionType;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.MetaDic;
import common.Logger;


@Service
@Transactional
public class CourseKemService {
	private Logger logger = Logger.getLogger(CourseKemService.class);
	
	@Autowired
	private CourseKemDao courseKemDao;
	@Autowired
	private CourseKemLongDao courseKemLongDao;
	@Autowired
	private MetaDicDao metaDicDao;

	public void insertInfo(Integer courseId, Integer collTypeId, Integer metadicId, String kemVal) {
		if("Y".equals(metaDicDao.selectInfo(metadicId).getLongYn()))
			this.courseKemLongDao.insertInfo(courseId, collTypeId, metadicId, kemVal);
		else
			this.courseKemDao.insertInfo(courseId, collTypeId, metadicId, kemVal);
	}
	public int deleteInfo(Integer courseId, Integer collTypeId, Integer metadicId) {
		return this.courseKemDao.deleteInfo(courseId, collTypeId, metadicId);
	}
	public int deleteList(Integer courseId, String collType, Integer collTypeId) {
		return this.courseKemDao.deleteList(courseId, collType, collTypeId);
	}
	
	public void updateInfo(Integer courseId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		if("Y".equals(metaDicDao.selectInfo(metadicId).getLongYn()))
			this.courseKemLongDao.updateInfo(courseId, collTypeId, metadicId, kemVal);
		else
			this.courseKemDao.updateInfo(courseId, collTypeId, metadicId, kemVal);
	}
	
	public void construct(Integer courseId, Integer collTypeId, Course course)
	{
		List<MetaDic> list = metaDicDao.selectList(CollectionType.COURSE.getValue());
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getElement().equals("regDate")
					|| list.get(i).getElement().equals("modDate")
					|| list.get(i).getElement().equals("delDate"))
				continue;
			
			Object val = "";
			try {
				Method method = course.getClass().getMethod("get" + StringUtils.capitalize(list.get(i).getElement()));
				val = method.invoke(course);
			} catch (Exception e) {
				if(list.get(i).getElement().equals("identifier"))
					val = course.getCourseIdentifier();
				else if(list.get(i).getElement().equals("grantAll"))
					val = course.getPublicYn();
				else if(list.get(i).getElement().startsWith("departmentcode"))
					val = course.getDepartmentId();
				else if(list.get(i).getElement().startsWith("grad"))
					val = course.getGradYear();
				else if(list.get(i).getElement().startsWith("gradth"))
					val = course.getGradSemester();
				else if(list.get(i).getElement().startsWith("termyear"))
					val = course.getTermYear();
				else if(list.get(i).getElement().startsWith("termth"))
					val = course.getTermSemester();
				else if(list.get(i).getElement().startsWith("startdate"))
					val = course.getSvcStart();
				else if(list.get(i).getElement().startsWith("enddate"))
					val = course.getSvcEnd();
				else
					logger.error(list.get(i).getElement() + "("+val+") : " + e.getMessage(), e);
			}
			
			if("Y".equals(list.get(i).getLongYn()))
				this.courseKemLongDao.insertInfo(courseId, collTypeId, list.get(i).getMetadicId(), String.valueOf(val));
			else
				this.courseKemDao.insertInfo(courseId, collTypeId, list.get(i).getMetadicId(), String.valueOf(val));
		}
	}
	
	public void demolish(Integer courseId, String collType, Integer collTypeId)
	{
		this.courseKemDao.deleteList(courseId, collType, collTypeId);
		
		this.courseKemLongDao.deleteList(courseId, collType, collTypeId);
	}
	
	public void deleteNotIn(Integer courseId, String collType, String[] collTypeIds)
	{
		this.courseKemDao.deleteNotIn(courseId, collType, collTypeIds);
		
		this.courseKemLongDao.deleteNotIn(courseId, collType, collTypeIds);
	}
}
