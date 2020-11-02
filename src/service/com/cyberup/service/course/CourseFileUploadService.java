package com.cyberup.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.CourseFileUploadDao;
import com.cyberup.model.course.CourseFileUpload;


@Service
@Transactional
public class CourseFileUploadService {
	@Autowired
	private CourseFileUploadDao courseFileUploadDao;

	public int deleteInfo(Integer upfileId) {
		return this.courseFileUploadDao.deleteInfo(upfileId);
	}
	public CourseFileUpload selectInfo(Integer upfileId) {
		return this.courseFileUploadDao.selectInfo(upfileId);
	}
	public Integer insertInfo(CourseFileUpload courseFileUpload) {
		return this.courseFileUploadDao.insertInfo(courseFileUpload);
	}
}
