package com.cyberup.framework.controller;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.cyberup.framework.conf.Messaging;
import com.cyberup.framework.model.LoginInfo;

public abstract class AbstractValidator implements MapValidator {
	
	public final static String HAS_ERRORS = "errors";
	
	private ModelMap modelMap;
	
	@Inject
	protected Provider<LoginInfo> loginInfoProvider;
	
	@Autowired
	protected Messaging messaging;
	
	public void init(ModelMap modelMap)
	{
		this.modelMap = modelMap;
		
		this.modelMap.clear();
		modelMap.addAttribute(HAS_ERRORS, false);
		
		Logger.getLogger(this.getClass()).debug("init() : " + modelMap);
	}
	
	public void setErrors(boolean hasErrors)
	{
		modelMap.addAttribute(HAS_ERRORS, hasErrors);
		
		Logger.getLogger(this.getClass()).debug("setErrors : " + hasErrors);
	}
	
	public boolean hasErrors()
	{
		if(modelMap == null)
			throw new IllegalStateException("invoke init() method in validate()!!");
		
		Boolean hasErrors = (Boolean)modelMap.get(HAS_ERRORS);
		
		if(hasErrors == null || !hasErrors)
			return false;
		else
			return true;
	}
	
	

}
