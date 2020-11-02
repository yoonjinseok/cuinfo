package com.cyberup.service.univ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.univ.UnivDao;
import com.cyberup.model.univ.Univ;

@Service
@Transactional
public class UnivService {
	
	@Autowired
	private UnivDao univDao;
	
	public List<Univ> selectUnivList(Integer rowNum)
	{
		return this.univDao.selectUnivList(rowNum);
	}
	
	public List<Univ> selectUnivList2(Integer rowNum)
	{
		return this.univDao.selectUnivList2(rowNum);
	}
	
	public List<Univ> selectUnivInfoList(Univ univ)
	{
		return this.univDao.selectUnivInfoList(univ);
	}
	public List<Univ> selectGraduateUnivList(Univ univ)
	{
		return this.univDao.selectGraduateUnivList(univ);
	}
	public String selectKerisEmail() {
		return (String)this.univDao.selectKerisEmail();
	}
	
	public List<Univ> selectUnivDept(Univ univ)
	{
		return this.univDao.selectUnivDept(univ);
	}
	
	public Univ selectUnivInfo(Integer universityId)
	{
		return (Univ)this.univDao.selectUnivInfo(universityId);
	}
	
	public String[] selectChairmanInfo(Integer universityId) {
		return (String[])this.univDao.selectChairmanInfo(universityId);
	}
	public int updateChairmanInfo(Univ univ) {
		return this.univDao.updateChairmanInfo(univ);
	}
	public String[] selectPrincipalInfo(Integer universityId) {
		return (String[])this.univDao.selectPrincipalInfo(universityId);
	}
	public int updatePrincipalInfo(Univ univ) {
		return this.univDao.updatePrincipalInfo(univ);
	}
	
	public List<Univ> selectUnivLinkList(Integer universityId)
	{
		return this.univDao.selectUnivLinkList(universityId);
	}
	
	public int modifyUnivInfo(Univ univ)
	{
		return this.univDao.modifyUnivInfo(univ);
	}
	
	public int modifyUnivInfo_file(Univ univ)
	{
		return this.univDao.modifyUnivInfo_file(univ);
	}
	
	public Univ selectUnivLinkInfo(Integer link_id)
	{
		return (Univ)this.univDao.selectUnivLinkInfo(link_id);
	}
	
	public int modifyLinkInfo(Univ univ)
	{
		
		Integer link_id = univ.getLink_id();
		
		//새로등록할경우
		if(link_id == 0)
		{
			this.univDao.insertLinkInfo(univ);
			
			return 0;
		}
		//수정할경우
		else
		{
			return this.univDao.modifyLinkInfo(univ);	
		}
		
		
		
	}
	
	public int updateUnivOption(Univ univ)
	{
		Integer university_id = univ.getUniversity_id();
		
		//새로등록할경우
		if(university_id == 0)
		{
			this.univDao.insertUnivOption(univ);
			
			return 0;
		}
		//수정할경우
		else
		{
			return this.univDao.modifyUnivOption(univ);	
		}
		
	}
	
	public int updateUnivOption_file(Univ univ)
	{
		Integer university_id = univ.getUniversity_id();
		
		//새로등록할경우
		if(university_id == 0)
		{
			this.univDao.insertUnivOption(univ);
			
			return 0;
		}
		//수정할경우
		else
		{
			return this.univDao.modifyUnivOption(univ);	
		}
		
	}
	
	public Univ selectUnivOptionInfo(Integer university_id)
	{
		
		return this.univDao.selectUnivOptionInfo(university_id);
	}
	
	public Univ selectUnivOverallInfo(Integer universityId)
	{
		return this.univDao.selectUnivOverallInfo(universityId);
	}
	
	public int updateUnivOverallInfo(Univ univ)
	{
		Integer university_id = univ.getUniversity_id();
		
		//새로등록할경우
		if(university_id == 0)
		{
			this.univDao.insertUnivOverallInfo(univ);
			
			return 0;
		}
		//수정할경우
		else
		{
			return this.univDao.updateUnivOverallInfo(univ);	
		}
		
	}
	
	public int initFileOverall(Univ univ) {
		return this.univDao.initFileOverall(univ);
	}
	public int initFileOption(Integer fileIndex, Univ univ) {
		return this.univDao.initFileOption(fileIndex, univ);
	}
	public int initFileDefault(Integer fileIndex, Univ univ) {
		return this.univDao.initFileDefault(fileIndex, univ);
	}
	
	// 사용자단, 사이버 대학안내에서 사용. 
	public Univ selectUnivTotalInfo(Univ univ)
	{
		return this.univDao.selectUnivTotalInfo(univ);
	}
	public List selectUnivLinkSchool(Univ univ)
	{
		return this.univDao.selectUnivLinkSchool(univ);
	}
	public List selectUnivLinkGraduate(Univ univ)
	{
		return this.univDao.selectUnivLinkGraduate(univ);
	}
	public List selectUnivLinkEntrance(Univ univ)
	{
		return this.univDao.selectUnivLinkEntrance(univ);
	}
	public List selectUnivLinkAttached(Univ univ)
	{
		return this.univDao.selectUnivLinkAttached(univ);
	}
	public List selectMajorList(Univ univ) {
		return this.univDao.selectMajorList(univ);
	}
	
	//성공수기
	public String selectSuccessStory(Univ univ) {
		return this.univDao.selectSuccessStory(univ);
	}
	public String selectSuccessLink(Univ univ) {
		return this.univDao.selectSuccessLink(univ);
	}
	
	//대학구분값
	public String getGetGubunId(String adminId) {
		return this.univDao.getGetGubunId(adminId);
	}
	
	public List graduateList(String univName){
		return this.univDao.graduateList(univName);
	}
}