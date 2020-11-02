package com.cyberup.dao.univ;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.univ.Univ;

@Repository
public class UnivDao extends BaseDAO{

	public List<Univ> selectUnivList(Integer rowNum)
	{
		return queryForList("UnivDao.selectUnivList", rowNum);
	}
	
	public List<Univ> selectUnivList2(Integer rowNum)
	{
		return queryForList("UnivDao.selectUnivList2", rowNum);
	}
	
	public List<Univ> selectUnivInfoList(Univ univ)
	{
		
		return queryForList("UnivDao.selectUnivInfoList",univ);
	}
	public List<Univ> selectGraduateUnivList(Univ univ)
	{
		
		return queryForList("UnivDao.selectGraduateUnivList",univ);
	}
	
	public String selectKerisEmail() {
		return (String)queryForObject("UnivDao.selectKerisEmail");
	}
	
	public Univ selectUnivInfo(Integer universityId)
	{
		return (Univ)queryForObject("UnivDao.selectUnivInfo",universityId);
	}
	
	public String[] selectChairmanInfo(Integer universityId) {
		String chairman = (String)queryForObject("UnivDao.selectChairmanInfo", universityId);
		String[] chairmanList = null;
		if(chairman != null) {
			chairmanList = chairman.split(";");
		}
		 return chairmanList;
	}
	public int updateChairmanInfo(Univ univ) {
		return update("UnivDao.updateChairmanInfo", univ);
	}
	public String[] selectPrincipalInfo(Integer universityId) {
		String principal = (String)queryForObject("UnivDao.selectPrincipalInfo", universityId);
		String[] principalList = null;
		if(principal != null) {
			principalList = principal.split(";");
		}
		return principalList;
	}
	public int updatePrincipalInfo(Univ univ) {
		return update("UnivDao.updatePrincipalInfo", univ);
	}
	
	public List<Univ> selectUnivLinkList(Integer universityId)
	{
		return queryForList("UnivDao.selectUnivLinkList",universityId);
	}
	
	public int modifyUnivInfo(Univ univ)
	{
		return update("UnivDao.updateUnivInfo",univ);
	}
	
	public int modifyUnivInfo_file(Univ univ)
	{
		return update("UnivDao.modifyUnivInfo_file",univ);
	}
	
	public Univ selectUnivLinkInfo(Integer link_id)
	{
		return (Univ)queryForObject("UnivDao.selectUnivLinkInfo",link_id);
	}
	
	public Univ selectUnivOverallInfo(Integer universityId)
	{
		return (Univ)queryForObject("UnivDao.selectUnivOverallInfo",universityId);
	}
	
	
	
	//링크정보 수정
	public int modifyLinkInfo(Univ univ)
	{
		return update("UnivDao.updateLinkInfo",univ);
	}
	
	//링크정보 입력
	public void insertLinkInfo(Univ univ)
	{
		insert("UnivDao.insertLinkInfo",univ);
	}
	
	
	public Univ selectUnivOptionInfo(Integer university_id)
	{
		return (Univ)queryForObject("UnivDao.selectUnivOptionInfo",university_id);
	}
	
	public int modifyUnivOption(Univ univ)
	{
		return update("UnivDao.modifyUnivOption",univ);
	}
	
	public int modifyUnivOption_file(Univ univ)
	{
		return update("UnivDao.modifyUnivOption",univ);
	}
	
	public void insertUnivOption(Univ univ)
	{
		insert("UnivDao.insertUnivOption",univ);
	}
	
	public Univ selectUnivOption(Integer university_id)
	{
		//return (Univ)queryForObject("UnivDao.selectUnivOption",university_id);
		
		return null;
	}
	
	
	public int updateUnivOverallInfo(Univ univ)
	{
		return update("UnivDao.updateUnivOverallInfo",univ);
	}

	public void insertUnivOverallInfo(Univ univ)
	{
		insert("UnivDao.insertUnivOverallInfo",univ);
	}
	
	public int initFileOverall(Univ univ)
	{
		return update("UnivDao.initFileOverall", univ);
	}
	public int initFileOption(Integer fileIndex, Univ univ)
	{
			
		Map param = new HashMap();
		param.put("University_id", univ.getUniversity_id());
		param.put("fileIndex", fileIndex);
		
		if(fileIndex == 0)
			param.put("updateGid", univ.getGreeting_img_upfile_id() );
		if(fileIndex == 1)
			param.put("updateGid", univ.getVision_img_upfile_id() );
		if(fileIndex == 2)
			param.put("updateGid", univ.getLocation_img_upfile_id() );
		if(fileIndex == 3)
			param.put("updateGid", univ.getPublic_img_upfile_id() );
		
		return update("UnivDao.initFileOption", univ);
	}
	public int initFileDefault(Integer fileIndex, Univ univ)
	{
		
		Map param = new HashMap();
		param.put("University_id", univ.getUniversity_id());
		param.put("fileIndex", fileIndex);
		if(fileIndex == 0)
			param.put("updateGid", univ.getLogo_upfile_gid() );
		if(fileIndex == 1)
			param.put("updateGid", univ.getVideo_img_upfile_gid() );
		if(fileIndex == 2)
			param.put("updateGid", univ.getVideo_upfile_gid() );
		
		return update("UnivDao.initFileDefault", univ);
	}
	public Univ selectUnivTotalInfo(Univ univ)
	{
		return (Univ)queryForObject("UnivDao.selectUnivTotalInfo",univ);
	}
	public List selectUnivLinkSchool(Univ univ)
	{
		return queryForList("UnivDao.selectUnivLinkSchool",univ);
	}
	public List selectUnivLinkGraduate(Univ univ)
	{
		return queryForList("UnivDao.selectUnivLinkGraduate",univ);
	}
	public List selectUnivLinkEntrance(Univ univ)
	{
		return queryForList("UnivDao.selectUnivLinkEntrance",univ);
	}
	public List selectUnivLinkAttached(Univ univ)
	{
		return queryForList("UnivDao.selectUnivLinkAttached",univ);
	}
	public List selectUnivDept(Univ univ)
	{
		return queryForList("UnivDao.selectUnivDept",univ);
	}
	public List selectMajorList(Univ univ) {
		return queryForList("UnivDao.selectMajorList", univ);
	}
	
	//성공수기
	public String selectSuccessStory(Univ univ) {
		return (String)queryForObject("UnivDao.selectSuccessStory", univ);
	}
	public String selectSuccessLink(Univ univ) {
		return (String)queryForObject("UnivDao.selectSuccessLink", univ);
	}
	
	//대학구분값
	public String getGetGubunId(String adminId) {
		return (String)queryForObject("UnivDao.getGubunId", adminId);
	}
	
	public List graduateList(String univName) {
		return queryForList("UnivDao.graduateList" , univName);
	}
	
}
