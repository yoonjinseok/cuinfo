package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.CourseFileUpload;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Schedule;

@Repository
public class CourseFileUploadDao extends BaseDAO {
	public int deleteInfo(Integer upfileId)
	{
		return delete("CourseFileUploadDao.deleteInfo", upfileId);
	}

	public CourseFileUpload selectInfo(Integer upfileId)
	{
		return (CourseFileUpload)queryForObject("CourseFileUploadDao.selectInfo", upfileId);
	}

	public Integer insertInfo(CourseFileUpload courseFileUpload)
	{
		Integer key = (Integer)insert("CourseFileUploadDao.insertInfo", courseFileUpload);
		courseFileUpload.setUpfileId(key);
		
		return key;
	}
}
