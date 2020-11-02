package com.cyberup.framework.conf;

import org.springframework.stereotype.Component;

import com.cyberup.framework.model.BaseObject;

public class SiteConfiguration extends BaseObject{
	/**
	 *
	 */
	private static final long serialVersionUID = 8475705762906204698L;
	private String serverUrl;
	private String serverContext;
	private String encryptKey;
	private String uploadRootPath;
	private String filePath;
	private String imgPath;
	private String metaUploadPath;
	private String kocwUploadPath;
	private String webContentPath;
	private String managerEmail;
	private String streamExts;
	private String uploadUrl;
	private String streamServer;
	private Integer streamPort;
	private String streamUserid;
	private String streamPassword;
	private String streamUploadDir;
	private String streamRemoteAddr;
	private String fileServer;
	private Integer fileServerPort;
	private String fileServerUserid;
	private String fileServerPassword;
	private String fileServerUploadDir;
	private String fileServerRemoteAddr;
	
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getServerContext() {
		return serverContext;
	}
	public void setServerContext(String serverContext) {
		this.serverContext = serverContext;
	}
	public String getEncryptKey() {
		return encryptKey;
	}
	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}
	public String getUploadRootPath() {
		return uploadRootPath;
	}
	public void setUploadRootPath(String uploadRootPath) {
		this.uploadRootPath = uploadRootPath;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getMetaUploadPath() {
		return metaUploadPath;
	}
	public void setMetaUploadPath(String metaUploadPath) {
		this.metaUploadPath = metaUploadPath;
	}
	public String getWebContentPath() {
		return webContentPath;
	}
	public void setWebContentPath(String webContentPath) {
		this.webContentPath = webContentPath;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getKocwUploadPath() {
		return kocwUploadPath;
	}
	public void setKocwUploadPath(String kocwUploadPath) {
		this.kocwUploadPath = kocwUploadPath;
	}
	public String getStreamExts() {
		return streamExts;
	}
	public void setStreamExts(String streamExts) {
		this.streamExts = streamExts;
	}
	public String getUploadUrl() {
		return uploadUrl;
	}
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}
	public String getStreamServer() {
		return streamServer;
	}
	public void setStreamServer(String streamServer) {
		this.streamServer = streamServer;
	}
	public Integer getStreamPort() {
		return streamPort;
	}
	public void setStreamPort(Integer streamPort) {
		this.streamPort = streamPort;
	}
	public String getStreamUserid() {
		return streamUserid;
	}
	public void setStreamUserid(String streamUserid) {
		this.streamUserid = streamUserid;
	}
	public String getStreamPassword() {
		return streamPassword;
	}
	public void setStreamPassword(String streamPassword) {
		this.streamPassword = streamPassword;
	}
	public String getStreamUploadDir() {
		return streamUploadDir;
	}
	public void setStreamUploadDir(String streamUploadDir) {
		this.streamUploadDir = streamUploadDir;
	}
	public String getStreamRemoteAddr() {
		return streamRemoteAddr;
	}
	public void setStreamRemoteAddr(String streamRemoteAddr) {
		this.streamRemoteAddr = streamRemoteAddr;
	}
	public String getFileServer() {
		return fileServer;
	}
	public void setFileServer(String fileServer) {
		this.fileServer = fileServer;
	}
	public Integer getFileServerPort() {
		return fileServerPort;
	}
	public void setFileServerPort(Integer fileServerPort) {
		this.fileServerPort = fileServerPort;
	}
	public String getFileServerUserid() {
		return fileServerUserid;
	}
	public void setFileServerUserid(String fileServerUserid) {
		this.fileServerUserid = fileServerUserid;
	}
	public String getFileServerPassword() {
		return fileServerPassword;
	}
	public void setFileServerPassword(String fileServerPassword) {
		this.fileServerPassword = fileServerPassword;
	}
	public String getFileServerUploadDir() {
		return fileServerUploadDir;
	}
	public void setFileServerUploadDir(String fileServerUploadDir) {
		this.fileServerUploadDir = fileServerUploadDir;
	}
	public String getFileServerRemoteAddr() {
		return fileServerRemoteAddr;
	}
	public void setFileServerRemoteAddr(String fileServerRemoteAddr) {
		this.fileServerRemoteAddr = fileServerRemoteAddr;
	}
	
}
