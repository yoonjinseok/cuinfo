package com.cyberup.framework.controller;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailSender extends JavaMailSenderImpl {
	private Logger logger = Logger.getLogger(MailSender.class);
	
	private JavaMailSenderImpl javaMailSender;

	public JavaMailSenderImpl getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		logger.debug("setJavaMailSender(" + javaMailSender + ")");
		logger.debug("setJavaMailSender(" + javaMailSender.getJavaMailProperties() + ")");
		
		this.javaMailSender = javaMailSender;
	}
	
}
