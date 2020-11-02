package com.cyberup.framework.interceptor;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;

public class AjaxMultipartResolver extends CommonsMultipartResolver {
	@Autowired
	protected SiteConfiguration siteConfiguration;
	
	private long maxUploadSize;
	@Autowired
	private AjaxProgressListener pListener;
	@Resource(name="ajaxProgressListener")
	public void setAjaxProgressListener(AjaxProgressListener ajaxProgressListener) {
		this.pListener = ajaxProgressListener;
		
//		getFileUpload().setProgressListener(this.pListener);
		
		System.out.println("setProgressListener("+this.pListener+") success.");
	}
	
	@Inject
	private Provider<SessionUploadConfigMap> sessionUploadConfigMap;
	
	public void setProgressListener(AjaxProgressListener p){
		this.pListener = p;
	}
	public AjaxProgressListener getProgressListener(){
		return this.pListener;
	}
	@Override
	public void setMaxUploadSize(long maxUploadSize)
	{
		this.maxUploadSize = maxUploadSize;
		super.setMaxUploadSize(maxUploadSize);
	}
	
	@Override
	protected String determineEncoding(HttpServletRequest request) {
		if(getDefaultEncoding() != null)
			return getDefaultEncoding();
		else 
			return super.determineEncoding(request);
	}
	
	protected FileUpload newFileUpload(FileItemFactory fileItemFactory) {
		FileUpload fu = super.newFileUpload(fileItemFactory);
		if (this.pListener != null){
//			fu.setProgressListener(this.pListener);
		}
		
		return fu;
	}
	
	private void applyValidFile(SessionUploadConfig sessionUploadConfig) throws MultipartException
	{
		if(sessionUploadConfig.getMaxSize() != 0)
		{
			super.setMaxUploadSize(sessionUploadConfig.getMaxSize());
		}
		else
		{
			super.setMaxUploadSize(maxUploadSize);
		}
	}
	
	private void putDefaultImgConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("gif,jpg,jpeg,png,bmp");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 10);
		sessionUploadConfig.setUploadDir(siteConfiguration.getImgPath());
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory("");
		
		sessionUploadConfigMap.get().putConfig("img", sessionUploadConfig);
	}
	private boolean isEditorImage(HttpServletRequest request)
	{
		if(request.getParameter(SessionUploadConfigMap.KEY) != null && request.getParameter(SessionUploadConfigMap.KEY).equals("img"))
			return true;
		else
			return false;
	}
	private boolean isNoneConfig(String confKey)
	{
		if(sessionUploadConfigMap.get().findConfig(confKey) == null)
			return true;
		else
			return false;
	}

	public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request){
		Logger.getLogger(this.getClass()).debug("query string : " + request.getQueryString());
		
		if(isEditorImage(request))
		{
			if(isNoneConfig("img"))
				putDefaultImgConfig();
		}
		
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements())
		{
			String name = (String)names.nextElement();
			Logger.getLogger(this.getClass()).debug(name + "=>" + request.getParameter(name));
		}
		
		applyValidFile(sessionUploadConfigMap.get().findConfig(request.getParameter(SessionUploadConfigMap.KEY)));
		
		return super.resolveMultipart(request);
	}
}
