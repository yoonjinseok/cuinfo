package com.cyberup.framework.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import com.opensymphony.sitemesh.ContentProcessor;
import com.opensymphony.sitemesh.DecoratorSelector;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import com.opensymphony.sitemesh.webapp.SiteMeshWebAppContext;

public class SiteMeshFilterImpl extends SiteMeshFilter {
	Logger logger = Logger.getLogger(this.getClass());
	
	private ContentProcessor contentProcessor;
	private DecoratorSelector decoratorSelector;
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		logger.debug("doFilter start.");
		super.doFilter(arg0, arg1, arg2);
		
		arg1.setContentType("text/html; charset=UTF-8");
		
		logger.debug("contentProcessor : " + contentProcessor);
		logger.debug("decoratorSelector : " + decoratorSelector);
		logger.debug("doFilter end.");
	}

	@Override
	public void destroy() {
		logger.debug("destroy start.");
		super.destroy();
		logger.debug("destroy end.");
	}

	@Override
	public void init(FilterConfig filterConfig) {
		logger.debug("init start.");
		super.init(filterConfig);
		logger.debug("init end.");
	}

	@Override
	protected ContentProcessor initContentProcessor(
			SiteMeshWebAppContext webAppContext) {
		logger.debug("initContentProcessor start.");
		contentProcessor = super.initContentProcessor(webAppContext);
		
		logger.debug("contentProcessor : " + contentProcessor);
		
		return new ContentProcessorImpl(contentProcessor);
	}

	@Override
	protected DecoratorSelector initDecoratorSelector(
			SiteMeshWebAppContext webAppContext) {
		logger.debug("initDecoratorSelector start.");
		decoratorSelector = super.initDecoratorSelector(webAppContext);
		
		logger.debug("decoratorSelector : " + decoratorSelector);
		
		return new DecoratorSelectorImpl(decoratorSelector);
	}
	
	
	
}
