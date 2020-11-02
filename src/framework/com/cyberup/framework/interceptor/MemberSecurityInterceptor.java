package com.cyberup.framework.interceptor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cyberup.framework.model.LoginInfo;


public class MemberSecurityInterceptor extends HandlerInterceptorAdapter {
	private List<String> excepAuth;
	private String loginUri;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider; 
	
	public void setExcepAuth(List<String> excepAuth)
	{
		this.excepAuth = excepAuth;
	}
	
	public void setLoginUri(String loginUri)
	{
		this.loginUri = loginUri;
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		
		System.out.println(this.getClass().getName() + " preHandle");
		
		Logger.getLogger(this.getClass()).debug("uri : " + uri);
		Logger.getLogger(this.getClass()).debug("excepAuth : " + excepAuth);
		Logger.getLogger(this.getClass()).debug("loginUri : " + loginUri);
		
		if(excepAuth != null)
		{
			if(PatternMatchUtils.simpleMatch(excepAuth.toArray(new String[]{}), uri))
				return true;
		}
		
		if (loginInfoProvider.get().isLoggedIn()) {
			Logger.getLogger(this.getClass()).debug("isLoggedIn");
			return true;
		}
		else {
			Logger.getLogger(this.getClass()).debug("is not LoggedIn");
			response.sendRedirect(request.getContextPath() + this.loginUri);
			return false;
		}
	}
}
