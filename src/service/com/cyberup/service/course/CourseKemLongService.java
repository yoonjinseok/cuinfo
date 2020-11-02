package com.cyberup.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.CourseKemLongDao;


@Service
@Transactional
public class CourseKemLongService {
	@Autowired
	private CourseKemLongDao courseKemLongDao;

	public int deleteInfo(Integer courseId, Integer collTypeId, Integer metadicId) {
		return this.courseKemLongDao.deleteInfo(courseId, collTypeId, metadicId);
	}
	public int deleteList(Integer courseId, String collType, Integer collTypeId) {
		return this.courseKemLongDao.deleteList(courseId, collType, collTypeId);
	}
	public void insertInfo(Integer courseId, Integer collTypeId, Integer metadicId, String kemVal) {
		this.courseKemLongDao.insertInfo(courseId, collTypeId, metadicId, kemVal);
	}
}
