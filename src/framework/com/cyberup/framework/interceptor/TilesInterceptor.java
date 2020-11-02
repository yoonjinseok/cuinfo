package com.cyberup.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.springbyexample.web.servlet.view.tiles2.TilesUrlBasedViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class TilesInterceptor extends HandlerInterceptorAdapter {
	private String member;
	private String admin;

	public void setMember(String member) {
		this.member = member;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Autowired
	private TilesUrlBasedViewResolver tilesViewResolver;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		
		String uri = request.getRequestURI();
		
		Logger.getLogger(this.getClass()).debug("uri : " + uri);
		
		int inx = uri.lastIndexOf(".");
		
		if(inx >= 0)
		{
			String tile = uri.substring(inx + 1);
			
			String[] paths = null;
			String zone = null;
			if(PatternMatchUtils.simpleMatch(member, uri))
			{
				paths = StringUtils.delimitedListToStringArray(member, "/");
				zone = paths[paths.length -2];
			}
			else if(PatternMatchUtils.simpleMatch(admin, uri))
			{
				paths = StringUtils.delimitedListToStringArray(admin, "/");
				zone = paths[paths.length -2];
			}
			
			Logger.getLogger(this.getClass()).debug("zone,title : " + zone + "," + tile);
			
			if(container.isValidDefinition("." + zone+tile, request, response))
			{
				tilesViewResolver.setTilesDefinitionName(zone+tile);
				Logger.getLogger(this.getClass()).debug("setTilesDefinitionName("+zone+tile+")");
			}
			else if(container.isValidDefinition("." + tile, request, response))
			{
				tilesViewResolver.setTilesDefinitionName(tile);
				Logger.getLogger(this.getClass()).debug("setTilesDefinitionName("+tile+")");
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		if(PatternMatchUtils.simpleMatch("*/action/member/*", "/app/action/member/login/form.pop"))
			System.out.println("match");
		else
			System.out.println("not match");
	}
}
