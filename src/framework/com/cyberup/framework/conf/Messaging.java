package com.cyberup.framework.conf;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Messaging implements MessageSourceAware {
	@Autowired
	private HttpServletRequest request;
	
	@Inject
	private LocaleResolver localeResolver;

	private MessageSource messageSource;
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage(String code, Object[] args, String defaultMessage)
	{
		return messageSource.getMessage(code, args, defaultMessage, localeResolver.resolveLocale(request));
	}

	public String getMessage(String code, Object[] args)
	{
		return messageSource.getMessage(code, args, localeResolver.resolveLocale(request));
	}

}
