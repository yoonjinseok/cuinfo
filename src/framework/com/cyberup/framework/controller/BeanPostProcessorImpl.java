package com.cyberup.framework.controller;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {

	/*
	 * (non-Javadoc)
	 * @seeorg.springframework.beans.factory.config.BeanPostProcessor#
	 * postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * @seeorg.springframework.beans.factory.config.BeanPostProcessor#
	 * postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AnnotationMethodHandlerAdapter) {
			AnnotationMethodHandlerAdapter adapter = (AnnotationMethodHandlerAdapter) bean;
			// Preventing Double Form Submission 를 위한 설정
			// 사용자가 같은 버튼을 여러번 클릭하는 경우와 같이, 여러 thread가 동시에 Session에 접근할 수도 있기
			// 때문에 반드시 AnnotationMethodHandlerAdapter의 synchronizeOnSession 속성을
			// true로 설정
			adapter.setSynchronizeOnSession(true);
		}
		return bean;
	}

}
