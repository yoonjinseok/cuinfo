package com.cyberup.framework.controller;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.cyberup.framework.conf.Messaging;

public class ExceptionResolver extends SimpleMappingExceptionResolver {
	@Autowired
	private MailSender mailSender;
	@Autowired
	private SimpleMailMessage errorNotifyMessage;
	@Autowired
	protected Messaging messaging;
	
	private Properties priorityExpMappings;
	private Map priorityNSMappings;

	public void setPriorityExceptionMappings(Properties  priorityExpMappings){
		this.priorityExpMappings = priorityExpMappings;
	}
	
	public void setPriorityNotificationServicesMappings (Map priorityNSMappings){
		this.priorityNSMappings = priorityNSMappings;
	}
	
	private boolean isAlert(String uri)
	{
		if(uri.endsWith(".xml")
				|| uri.endsWith(".json")
				|| uri.contains(".do."))
			return true;
		else
			return false;
	}
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,  HttpServletResponse response, Object handler, Exception ex) {
		Logger.getLogger(this.getClass()).warn("An Exception has occured in the application", ex);
	    sendNotification(ex);
	    
	    if(isAlert(request.getRequestURL().toString()))
	    {
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.getModelMap().addAttribute(AbstractValidator.HAS_ERRORS, true);
	    	
	    	if(ex instanceof MultipartException)
	    		modelAndView.getModelMap().addAttribute("message", "alert(\""+ex.getMessage()+"\");");
	    	else if(ex instanceof BindException)
	    	{
	    		modelAndView.getModelMap().addAttribute("message", "alert(\"입력형식이 맞지 않습니다.\");$(\"#"+((BindException)ex).getBindingResult().getFieldErrors().get(((BindException)ex).getBindingResult().getFieldErrorCount()-1).getField()+"\").focus();");
	    	}
	    	else
	    		modelAndView.getModelMap().addAttribute("message", "alert(\""+messaging.getMessage("comSystemException", new String[]{
	    				ex.getMessage() != null?
	    						ex.getMessage()
	    						.replaceAll("\"", "'")
	    						.substring(0, 
	    								ex.getMessage().length() > 30?30:ex.getMessage().length())
	    					:ex.getMessage()})+"\");");
	    	
	    	return modelAndView;
	    }
	    else
	    {
	    	request.setAttribute("exceptionCode", getExceptionCode(ex));
	    	request.setAttribute("exceptionMsg", StringUtils.replace(extractErrorMessage(ex), "\n", "<br/>"));
	    	return super.doResolveException(request, response, handler, ex);
	    }
	}
	
	private String getExceptionCode(Exception e)
	{
		Throwable throwable = e.getCause();
		while (throwable != null && throwable.getCause() != null) {
			throwable = throwable.getCause();
		}
		
		if(throwable != null)
			return throwable.getMessage();
		else
			return "null";
	}

	private void sendNotification(Exception exception) {
		/*errorNotifyMessage.setText("Application Message - " + exception.getMessage() + " : \n" + extractErrorMessage(exception)); 
		mailSender.send(errorNotifyMessage);*/
	}
	
	private String extractErrorMessage(Exception exception)
	{
		StringBuffer msg = new StringBuffer();
		
		StackTraceElement[] elements = exception.getStackTrace();
		for(int i = 0; elements != null && i < elements.length && i <= 5; i++)
		{
			msg.append(elements[i].toString() + "\n");
		}
		if(elements != null && elements.length > 5)
			msg.append("...");
		
		return msg.toString();
	}
}
