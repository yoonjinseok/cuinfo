package com.cyberup.service.univ;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.univ.UnivDeptDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.univ.UnivDept;


@Service
@Transactional
public class UnivDeptService {
	@Autowired
	private UnivDeptDao univDeptDao;
	
	public UnivDept selectInfo(String univDeptId, Integer universityId) {
		return this.univDeptDao.selectInfo(univDeptId, universityId);
	}
	public int deleteInfo(String univDeptId, Integer universityId) {
		return this.univDeptDao.deleteInfo(univDeptId, universityId);
	}
	public void insertInfo(UnivDept univDept) {
		this.univDeptDao.insertInfo(univDept);
	}
	public List<UnivDept> selectList(Integer showCnt, Integer currPage, 
									Integer universityId, String universityName, 
									String univDeptId, String univDeptName, 
									String deptId, String deptName, 
									String deptAllName, 
									String classifyId, Integer localId, 
									String searchCon1, String searchCon2, String searchCon3,
									String useYn,Integer authLevelId) 
	{
		return this.univDeptDao.selectList(showCnt, currPage, 
										universityId, universityName, 
										univDeptId, univDeptName, 
										deptId, deptName, 
										deptAllName,
										classifyId, localId, 
										searchCon1, searchCon2, searchCon3,
										useYn,authLevelId);
	}
	public int updateInfo(UnivDept univDept) {
		return this.univDeptDao.updateInfo(univDept);
	}
	public int updateUnivDeptName(UnivDept univDept) {
		return this.univDeptDao.updateUnivDeptName(univDept);
	}
	
}
