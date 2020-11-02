package com.cyberup.framework.interceptor;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.opensymphony.module.sitemesh.SitemeshBuffer;
import com.opensymphony.sitemesh.Content;
import com.opensymphony.sitemesh.ContentProcessor;
import com.opensymphony.sitemesh.SiteMeshContext;

public class ContentProcessorImpl implements ContentProcessor {
	private Logger logger = Logger.getLogger(this.getClass());
	
	private ContentProcessor contentProcessor;
	
	public ContentProcessorImpl(ContentProcessor contentProcessor)
	{
		this.contentProcessor = contentProcessor;
	}
	
	public Content build(SitemeshBuffer buffer, SiteMeshContext context) throws IOException
	{
		Content content = contentProcessor.build(buffer, context);
		
		logger.debug("content( "+buffer+", "+context+") : " + content);
		
		return content;
	}

	public boolean handles(SiteMeshContext arg0) {
		boolean handle = contentProcessor.handles(arg0);
		
		logger.debug("handle("+arg0+" : "+arg0.getContentType()+") : " + handle);
		
		return handle;
	}

	public boolean handles(String arg0) {
		boolean handle = contentProcessor.handles(arg0);
		
		logger.debug("handle("+arg0+") : " + handle);
		
		
		return handle;
	}

}
