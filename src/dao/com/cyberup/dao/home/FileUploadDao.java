package com.cyberup.dao.home;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.home.FileUpload;

@Repository
public class FileUploadDao extends BaseDAO {
	public List<FileUpload> selectList(Integer upfileGid)
	{
		return queryForList("FileUploadDao.selectList", upfileGid);
	}
	
	public int deleteInfo(Integer upfileId)
	{
		return delete("FileUploadDao.deleteInfo", upfileId);
	}
	public int deleteList(Integer upfileGid)
	{
		return delete("FileUploadDao.deleteList", upfileGid);
	}

	public FileUpload selectInfo(Integer upfileId)
	{
		return (FileUpload)queryForObject("FileUploadDao.selectInfo", upfileId);
	}

	public Integer selectGroupKey()
	{
		return (Integer)queryForObject("FileUploadDao.selectGroupKey");
	}
	public Integer insertInfo(FileUpload fileUpload)
	{
		Integer key = (Integer)insert("FileUploadDao.insertInfo", fileUpload);
		fileUpload.setUpfileId(key);
		
		return key;
	}
	public Integer selectUploadCount(String fileName)
	{
		return (Integer)queryForObject("FileUploadDao.selectUploadCount",fileName);
	}
}
