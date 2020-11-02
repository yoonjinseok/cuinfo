package com.cyberup.framework.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

public interface MapValidator {
	boolean supports(Class<?> clazz);

	public void init(ModelMap modelMap);
	public <T> T validate(Object target, ModelMap modelMap);
	
	boolean hasErrors();
}
