package com.cyberup.framework.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.sitemesh.Content;
import com.opensymphony.sitemesh.Decorator;
import com.opensymphony.sitemesh.DecoratorSelector;
import com.opensymphony.sitemesh.SiteMeshContext;

public class DecoratorSelectorImpl implements DecoratorSelector {
	private Logger logger = Logger.getLogger(this.getClass());
	
	private DecoratorSelector decoratorSelector;
	
	public DecoratorSelectorImpl(DecoratorSelector decoratorSelector)
	{
		this.decoratorSelector = decoratorSelector;
	}

	public Decorator selectDecorator(Content arg0, SiteMeshContext arg1) {
		Decorator decorator = decoratorSelector.selectDecorator(arg0, arg1);
		
		logger.debug("decorator : " + decorator);
		
		return decorator;
	}

}
