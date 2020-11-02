package com.cyberup.framework.interceptor;

import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cyberup.util.DateFormatter;
import com.cyberup.util.HtmlUtils;


public class VelocityToolsInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//11.12.27 LJH. 기능 사용하지 않음으로 주석처리함. 
		//return super.preHandle(request, response, handler);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Logger.getLogger(this.getClass()).debug("tools mapping start.");
		
		if(modelAndView == null)
			return;
		
		modelAndView.getModelMap().addAttribute("dateformatter", new DateFormatter("yyyy/MM/dd"));
		modelAndView.getModelMap().addAttribute("datetimeformatter", new DateFormatter("yyyy/MM/dd HH:mm:ss"));
		modelAndView.getModelMap().addAttribute("timeformatter", new DateFormatter("HH:mm:ss"));
		modelAndView.getModelMap().addAttribute("locale", Locale.getDefault());
		
		modelAndView.getModelMap().addAttribute("stringUtils", new StringUtils());
		modelAndView.getModelMap().addAttribute("htmlUtils", new HtmlUtils());
		
		super.postHandle(request, response, handler, modelAndView);
		
		Logger.getLogger(this.getClass()).debug("request parameter mapping start.");
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements())
		{
			String name = names.nextElement();
			
			if(modelAndView.getModelMap().get(name) == null)
				modelAndView.getModelMap().addAttribute(name, request.getParameter(name));
		}
		
		log(modelAndView.getModelMap());
	}
	
	private void log(ModelMap modelMap)
	{
//		if(Logger.getLogger(this.getClass()).isDebugEnabled())
//			Logger.getLogger(this.getClass()).debug("modelMap : " + modelMap);
	}
}
