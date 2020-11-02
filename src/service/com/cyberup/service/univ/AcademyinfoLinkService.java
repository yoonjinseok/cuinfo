package com.cyberup.service.univ;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.model.univ.AcademyinfoLink;
import com.cyberup.dao.univ.AcademyinfoLinkDao;

@Service
@Transactional
public class AcademyinfoLinkService {
	@Autowired
	private AcademyinfoLinkDao academyinfoLinkDao;
	
	
	public List<AcademyinfoLink> selectList(Integer showCnt, Integer currPage, Integer infoGubunId, String infoName, String useYn) {
		return this.academyinfoLinkDao.selectList(showCnt, currPage, infoGubunId, infoName, useYn);
	}
	
	public List<AcademyinfoLink> selectViewList() {
		return this.academyinfoLinkDao.selectViewList();
	}
	public AcademyinfoLink selectInfo(Integer infoId) {
		return this.academyinfoLinkDao.selectInfo(infoId);
	}
	public int deleteInfo(Integer infoId) {
		return this.academyinfoLinkDao.deleteInfo(infoId);
	}
	public void insertInfo(AcademyinfoLink academyinfoLink) {
		this.academyinfoLinkDao.insertInfo(academyinfoLink);
	}
	public int updateInfo(AcademyinfoLink academyinfoLink) {
		return this.academyinfoLinkDao.updateInfo(academyinfoLink);
	}
}
