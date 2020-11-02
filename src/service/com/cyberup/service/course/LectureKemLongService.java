package com.cyberup.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.LectureKemLongDao;


@Service
@Transactional
public class LectureKemLongService {
	@Autowired
	private LectureKemLongDao lectureKemLongDao;

	public int deleteInfo(Integer collTypeId, Integer lectureId, Integer metadicId) {
		return this.lectureKemLongDao.deleteInfo(collTypeId, lectureId, metadicId);
	}
	public int deleteList(Integer lectureId, String collType, Integer collTypeId)
	{
		return this.lectureKemLongDao.deleteList(lectureId, collType, collTypeId);
	}
	public void insertInfo(Integer lectureId, Integer collTypeId, Integer metadicId, String kemVal) {
		this.lectureKemLongDao.insertInfo(lectureId, collTypeId, metadicId, kemVal);
	}
}
