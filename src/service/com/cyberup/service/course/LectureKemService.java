package com.cyberup.service.course;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.LectureKemDao;
import com.cyberup.dao.course.LectureKemLongDao;
import com.cyberup.dao.course.MetaDicDao;
import com.cyberup.model.course.CollectionType;
import com.cyberup.model.course.Lecture;
import com.cyberup.model.course.Material;
import com.cyberup.model.course.MetaDic;
import common.Logger;


@Service
@Transactional
public class LectureKemService {
	private Logger logger = Logger.getLogger(LectureKemService.class);
	
	@Autowired
	private LectureKemDao lectureKemDao;
	@Autowired
	private LectureKemLongDao lectureKemLongDao;
	@Autowired
	private MetaDicDao metaDicDao;

	public int deleteInfo(Integer collTypeId, Integer lectureId, Integer metadicId) {
		return this.lectureKemDao.deleteInfo(collTypeId, lectureId, metadicId);
	}
	public int deleteList(Integer lectureId, String collType, Integer collTypeId)
	{
		return this.lectureKemDao.deleteList(lectureId, collType, collTypeId);
	}
	public void insertInfo(Integer lectureId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		if("Y".equals(metaDicDao.selectInfo(metadicId).getLongYn()))
			this.lectureKemLongDao.insertInfo(lectureId, collTypeId, metadicId, kemVal);
		else
			this.lectureKemDao.insertInfo(lectureId, collTypeId, metadicId, kemVal);
	}
	public void updateInfo(Integer lectureId, Integer collTypeId, Integer metadicId, String kemVal)
	{
		if("Y".equals(metaDicDao.selectInfo(metadicId).getLongYn()))
			this.lectureKemLongDao.updateInfo(lectureId, collTypeId, metadicId, kemVal);
		else
			this.lectureKemDao.updateInfo(lectureId, collTypeId, metadicId, kemVal);
	}
	public void construct(Integer lectureId, Integer collTypeId, Lecture lecture)
	{
		List<MetaDic> list = metaDicDao.selectList(CollectionType.LECTURE.getValue());
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getElement().equals("regDate")
					|| list.get(i).getElement().equals("modDate")
					|| list.get(i).getElement().equals("delDate"))
				continue;
			
			Object val = "";
			try {
				Method method = lecture.getClass().getMethod("get" + StringUtils.capitalize(list.get(i).getElement()));
				val = method.invoke(lecture);
			} catch (Exception e) {
				if(list.get(i).getElement().equals("lecIdentifier"))
					val = lecture.getLectureIdentifier();
				else
					logger.error(list.get(i).getElement() + "("+val+") : " + e.getMessage(), e);
			}
			
			if("Y".equals(list.get(i).getLongYn()))
				this.lectureKemLongDao.insertInfo(lectureId, collTypeId, list.get(i).getMetadicId(), String.valueOf(val));
			else
				this.lectureKemDao.insertInfo(lectureId, collTypeId, list.get(i).getMetadicId(), String.valueOf(val));
		}
	}
	
	public void construct(Integer lectureId, Integer collTypeId, Material material)
	{
		List<MetaDic> list = metaDicDao.selectList(CollectionType.LECFILE.getValue());
		for(int i = 0; i < list.size(); i++)
		{
			Object val = "";
			try {
				Method method = material.getClass().getMethod("get" + StringUtils.capitalize(list.get(i).getElement()));
				val = method.invoke(material);
			} catch (Exception e) {
				if(list.get(i).getElement().equals("fileId"))
					val = material.getAttfileIdentifier();
				else if(list.get(i).getElement().startsWith("fileLocation"))
					val = material.getLocation();
				else if(list.get(i).getElement().startsWith("fileDesc"))
					val = material.getTitle();
				else
					logger.error(list.get(i).getElement() + "("+val+") : " + e.getMessage(), e);
			}
			
			if("Y".equals(list.get(i).getLongYn()))
				this.lectureKemLongDao.insertInfo(lectureId, collTypeId, list.get(i).getMetadicId(), String.valueOf(val));
			else
				this.lectureKemDao.insertInfo(lectureId, collTypeId, list.get(i).getMetadicId(), String.valueOf(val));
		}
	}
	
	public void demolish(Integer lectureId, String collType, Integer collTypeId)
	{
		this.lectureKemDao.deleteList(lectureId, collType, collTypeId);
		
		this.lectureKemLongDao.deleteList(lectureId, collType, collTypeId);
	}
	public void demolishByCourseId(Integer courseId)
	{
		this.lectureKemDao.deleteListByCourseId(courseId);
		
		this.lectureKemLongDao.deleteListByCourseId(courseId);
	}
	
	public void deleteNotIn(Integer lectureId, String collType, String[] collTypeIds)
	{
		this.lectureKemDao.deleteNotIn(lectureId, collType, collTypeIds);
		
		this.lectureKemLongDao.deleteNotIn(lectureId, collType, collTypeIds);
	}
}
