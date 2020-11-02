package com.cyberup.service.course;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.CourseDao;
import com.cyberup.dao.course.LectureDao;
import com.cyberup.model.course.Lecture;
import com.cyberup.model.course.RelationType;
import com.cyberup.model.course.ScheduleType;


@Service
@Transactional
public class LectureService {
	private Logger logger = Logger.getLogger(LectureService.class);
	
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private LectureDao lectureDao;
	@Autowired
	private LectureKemService lectureKemService;
	@Autowired
	private MaterialService materialService;

	public int updateInfo(Lecture lecture) {
		return this.lectureDao.updateInfo(lecture);
	}
	public int updateLocation(Integer lectureId, String location) {
		return this.lectureDao.updateLocation(lectureId, location);
	}
	public void insertInfo(Lecture lecture) {
		this.lectureDao.insertInfo(lecture);
	}
	public int deleteInfo(Integer lectureId, Integer courseId, String lectureIdentifier) {
		return this.lectureDao.deleteInfo(lectureId, courseId, lectureIdentifier);
	}
	public List<Lecture> selectListOfUniv(Integer universityId) {
		return this.lectureDao.selectListOfUniv(universityId);
	}
	public Lecture selectInfo(Integer lectureId, Integer courseId, String lectureIdentifier) {
		return this.lectureDao.selectInfo(lectureId, courseId, lectureIdentifier);
	}
	public List<Lecture> selectList(Integer courseId)
	{
		return this.lectureDao.selectList(courseId);
	}
	public List<Lecture> getLectureList(Integer courseId)
	{
		List<Lecture> lectures = this.lectureDao.selectList(courseId);
		
		for(int i = 0; i < lectures.size(); i++)
		{
			lectures.get(i).setLecFileList(materialService.selectList(RelationType.LECTURE.getValue(), lectures.get(i).getLectureId()));
		}
		
		return lectures;
	}
	
	public Lecture getLectureInfo(Integer courseId, Integer lectureId)
	{
		Lecture lecture = this.lectureDao.selectInfo(lectureId, 0, "");
		
		lecture.setLecFileList(materialService.selectList(RelationType.LECTURE.getValue(), lecture.getLectureId()));
		
		return lecture;
	}
	public Integer construct(Lecture lecture)
	{
		Integer lectureId = lectureDao.selectKey();
		
		construct(lectureId, lecture);
		
		return lectureId;
	}
	public void reconstruct(Integer lectureId, Lecture lecture)
	{
		demolish(lecture.getCourseId(), lectureId, "");
		
		construct(lectureId, lecture);
	}
	
	public void construct(Integer lectureId, Lecture lecture)
	{
		this.courseDao.updateModDate(lecture.getCourseId(), lecture.getModifier());
		logger.info("course updateModDated");
		
		lecture.setLectureId(lectureId);
		lectureDao.insertInfo(lecture);
		logger.info("lecture inserted");
		
		lectureKemService.construct(lectureId, lectureId, lecture);
		logger.info("lectureKem constructed");
		
		for(int i = 0; i < lecture.getLecFileList().size(); i++)
		{
			lecture.getLecFileList().get(i).setRelationType(RelationType.LECTURE.getValue());
			lecture.getLecFileList().get(i).setRelationId(lectureId);
			materialService.constructInfo(lecture.getLecFileList().get(i));
			logger.info("lecture file("+i+") constructed");
		}
	}
	
	public void synchronize(Date harvestSdate, Date harvestEdate, Lecture lecture)
	{
		Lecture preLecture = lectureDao.selectInfo(0, lecture.getCourseId(), lecture.getLectureIdentifier());
		
		if(lecture.getScheduleType(harvestSdate, harvestEdate).equals(ScheduleType.CREATE.getValue())
				|| lecture.getScheduleType(harvestSdate, harvestEdate).equals(ScheduleType.UPDATE.getValue()))
		{
			if(preLecture == null)
				construct(lecture);
			else
			{
				demolish(preLecture.getCourseId(), preLecture.getLectureId(), preLecture.getLectureIdentifier());
				
				construct(lecture);
			}
			return;
		}
		else if(lecture.getScheduleType(harvestSdate, harvestEdate).equals(ScheduleType.DELETE.getValue()))
		{
			demolish(preLecture.getCourseId(), preLecture.getLectureId(), preLecture.getLectureIdentifier());
			return;
		}
		
		return;
	}
	
	public void demolish(Integer courseId, Integer lectureId, String lectureIdentifier)
	{
		lectureDao.deleteInfo(lectureId, courseId, lectureIdentifier);
		lectureKemService.demolish(lectureId, "", 0);
		
		materialService.deleteInfo(0, RelationType.LECTURE.getValue(), lectureId, "");
		
		return;
	}
	public void demolish(Integer courseId)
	{
		lectureKemService.demolishByCourseId(courseId);
		
		materialService.deleteListByCourseId(RelationType.LECTURE.getValue(), courseId);
		
		lectureDao.deleteListByCourseId(courseId);
		
		return;
	}
}
