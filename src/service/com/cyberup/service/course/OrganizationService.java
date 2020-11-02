package com.cyberup.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.course.HistoryDao;
import com.cyberup.dao.course.OrganizationDao;
import com.cyberup.dao.course.ScheduleDao;
import com.cyberup.model.course.History;
import com.cyberup.model.course.Organization;
import com.cyberup.model.course.Schedule;


@Service
@Transactional
public class OrganizationService {
	@Autowired
	private OrganizationDao organizationDao;

	public int deleteInfo(String orgId) {
		return this.organizationDao.deleteInfo(orgId);
	}
	public void insertInfo(Organization organization) {
		this.organizationDao.insertInfo(organization);
	}
	public int updateInfo(Organization organization) {
		return this.organizationDao.updateInfo(organization);
	}
	public Organization selectInfo(String orgId) {
		return this.organizationDao.selectInfo(orgId);
	}
}
