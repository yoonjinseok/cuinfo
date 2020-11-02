package com.cyberup.service.course;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.MaterialDao;
import com.cyberup.model.course.CollectionType;
import com.cyberup.model.course.Material;


@Service
@Transactional
public class MaterialService {
	@Autowired
	private MaterialDao materialDao;
	@Autowired
	private LectureKemService lectureKemService;
	@Autowired
	private CourseKemService courseKemService;

	public List<Material> selectListOfUniv(Integer universityId) {
		return this.materialDao.selectListOfUniv(universityId);
	}
	public Material selectInfo(Integer attfileId, String relationType, Integer relationId, String attfileIdentifier) {
		return this.materialDao.selectInfo(attfileId, relationType, relationId, attfileIdentifier);
	}
	public List<Material> selectList(String relationType, Integer relationId)
	{
		return this.materialDao.selectList(relationType, relationId);
	}
	public int demolishNotIn(String relationType, Integer relationId, List<Material> materials)
	{
		StringBuffer attfileIds = new StringBuffer();
		for(int i = 0; i < materials.size(); i++)
		{
			if(materials.get(i).getAttfileId() > 0)
			{
				if(attfileIds.length() > 0)
					attfileIds.append(",");
				attfileIds.append(materials.get(i).getAttfileId());
			}
		}
		
		return demolishNotIn(relationType, relationId, StringUtils.split(attfileIds.toString(), ","));
	} 
	
	public int demolishNotIn(String relationType, Integer relationId, String[] attfileIds)
	{
		lectureKemService.deleteNotIn(relationId, CollectionType.CONTRIBUTOR.getValue(), attfileIds);
		
		return this.materialDao.deleteNotIn(relationType, relationId, attfileIds);
	}
	public int demolishInfo(Integer attfileId, String relationType, Integer relationId, String attfileIdentifier) {
		lectureKemService.demolish(relationId, CollectionType.CONTRIBUTOR.getValue(), attfileId);
		
		return this.materialDao.deleteInfo(attfileId, relationType, relationId, attfileIdentifier);
	}
	public int deleteInfo(Integer attfileId, String relationType, Integer relationId, String attfileIdentifier) {
		return this.materialDao.deleteInfo(attfileId, relationType, relationId, attfileIdentifier);
	}
	public int deleteListByCourseId(String relationType, Integer courseId) {
		return this.materialDao.deleteListByCourseId(relationType, courseId);
	}
	public Integer constructInfo(Material material) {
		Integer attfileId = this.materialDao.insertInfo(material);
		
		lectureKemService.construct(material.getRelationId(), attfileId, material);
		
		return attfileId;
	}
	public int updateInfo(Material material) {
		return this.materialDao.updateInfo(material);
	}
}
