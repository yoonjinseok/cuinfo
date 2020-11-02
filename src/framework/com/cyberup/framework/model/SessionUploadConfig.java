package com.cyberup.framework.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class SessionUploadConfig extends BaseObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4889612782754290730L;
	
	private Long maxSize = 0L;
	private String acceptExts;
	private String uploadRootDir;
	private String uploadDir;
	private String uploadSubectory;
	
	public Long getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(Long maxSize) {
		if(maxSize != null)
			this.maxSize = maxSize;
	}
	public String getAcceptExts() {
		return acceptExts;
	}
	public boolean isValidExtension(String extension)
	{
		if(this.acceptExts.toLowerCase().contains(extension.toLowerCase()))
			return true;
		else
			return false;
	}
	public void setAcceptExts(String acceptExts) {
		this.acceptExts = acceptExts.toLowerCase();
	}
	public String getUploadRootDir() {
		return uploadRootDir;
	}
	public void setUploadRootDir(String uploadRootDir) {
		this.uploadRootDir = uploadRootDir;
	}
	public String getUploadDir() {
		return uploadDir;
	}
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	public String getUploadSubectory() {
		return uploadSubectory;
	}
	public void setUploadSubectory(String uploadSubectory) {
		this.uploadSubectory = uploadSubectory;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
