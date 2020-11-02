package com.cyberup.framework.interceptor;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.DecoratorMapper;
import com.opensymphony.module.sitemesh.Page;
import com.opensymphony.module.sitemesh.mapper.ConfigDecoratorMapper;
import com.opensymphony.module.sitemesh.mapper.ConfigLoader;

public class ConfigDecoratorMapperSpringMvcSupport extends
		ConfigDecoratorMapper {
	private static final Logger logger = Logger.getLogger(ConfigDecoratorMapperSpringMvcSupport.class);        
	private ConfigLoader configLoader = null;         
	
	/** Create new ConfigLoader using '/WEB-INF/decorators.xml' file. */      
	public void init(Config config, Properties properties, DecoratorMapper parent) 
		throws InstantiationException 
	{          
		logger.debug("init()...");          
		super.init(config, properties, parent);          
		
		try {              
			String fileName = properties.getProperty("config", "/WEB-INF/decorators.xml"); 
			logger.debug("config : " + fileName);
			configLoader = new ConfigLoader(fileName, config);          
		}          
		catch (Exception e) {              
			throw new InstantiationException(e.toString());          
		}      
	}        
	
	/** Retrieve {@link com.opensymphony.module.sitemesh.Decorator} based on 'pattern' tag. */      
	public Decorator getDecorator(HttpServletRequest request, Page page) {          
		logger.debug("getDecorator()...");          
		String thisPath = request.getServletPath();          
		logger.debug("\tThisPath: " + thisPath);          
		String requestURI = request.getRequestURI();          
		logger.debug("\t\tGet request URI: " + requestURI);          
		//TODO check indexes          
		thisPath = "/springURITemplate" + requestURI.substring(request.getContextPath().length(), requestURI.length() - 1);          
		logger.debug("\t\t\tThisPath: " + thisPath);
		String name = null;          
		try {              
			name = configLoader.getMappedName(thisPath);          
		} catch (ServletException e) {              
			e.printStackTrace();          
		}          
		logger.debug("\tResolved decorator name: " + name);          
		Decorator result = getNamedDecorator(request, name);          
		logger.debug("Decorator is null ? " + (result == null));          
		result = (result == null)? super.getDecorator(request, page) : result;     
		
		logger.debug("decorator : " + result);
		
		return result;
	}  
}
