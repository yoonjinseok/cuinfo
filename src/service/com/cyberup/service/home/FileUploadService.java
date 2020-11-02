package com.cyberup.service.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.home.FileUploadDao;
import com.cyberup.model.home.FileUpload;


@Service
@Transactional
public class FileUploadService {
	@Autowired
	private FileUploadDao fileUploadDao;

	public List<FileUpload> selectList(Integer upfileGid) {
		return this.fileUploadDao.selectList(upfileGid);
	}
	public int deleteInfo(Integer upfileId) {
		return this.fileUploadDao.deleteInfo(upfileId);
	}
	public int deleteList(Integer upfileGid) {
		return this.fileUploadDao.deleteList(upfileGid);
	}
	public FileUpload selectInfo(Integer upfileId) {
		return this.fileUploadDao.selectInfo(upfileId);
	}
	public Integer selectGroupKey()
	{
		return this.fileUploadDao.selectGroupKey();
	}
	public Integer insertInfo(FileUpload courseFileUpload) {
		return this.fileUploadDao.insertInfo(courseFileUpload);
	}
	public Integer selectUploadCount(String fileName) {
		return this.fileUploadDao.selectUploadCount(fileName);
	}
}
