package com.cyberup.framework.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.cyberup.framework.controller.AbstractValidator;
import com.cyberup.util.JsonUtils;

public class DisplayMappingJSONView extends MappingJacksonJsonView {
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(model != null && model.get(AbstractValidator.HAS_ERRORS) == null)
			model.put(AbstractValidator.HAS_ERRORS, false);
		
		ObjectMapper objectMapper = new ObjectMapper();        
		// Make introspector that uses both JAXB and Jackson annotations.       
		AnnotationIntrospector primary = new JaxbAnnotationIntrospector();       
		AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();       
		AnnotationIntrospector introspector = new AnnotationIntrospector.Pair(primary, secondary);              
		// Configure deserialization       
		objectMapper.getDeserializationConfig().setAnnotationIntrospector(introspector);       
		objectMapper.getDeserializationConfig().enable(org.codehaus.jackson.map.DeserializationConfig.Feature.USE_ANNOTATIONS);       
		objectMapper.getDeserializationConfig().disable(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);       
		objectMapper.getDeserializationConfig().disable(org.codehaus.jackson.map.DeserializationConfig.Feature.AUTO_DETECT_CREATORS);       
		objectMapper.getDeserializationConfig().disable(org.codehaus.jackson.map.DeserializationConfig.Feature.AUTO_DETECT_FIELDS);       
		objectMapper.getDeserializationConfig().disable(org.codehaus.jackson.map.DeserializationConfig.Feature.AUTO_DETECT_SETTERS);        
		// Configure serialization       
		objectMapper.getSerializationConfig().enable(Feature.USE_ANNOTATIONS);       
		objectMapper.getSerializationConfig().disable(Feature.FAIL_ON_EMPTY_BEANS);       
		objectMapper.getSerializationConfig().disable(Feature.AUTO_DETECT_FIELDS);       
		objectMapper.getSerializationConfig().disable(Feature.AUTO_DETECT_GETTERS);       
		objectMapper.getSerializationConfig().disable(Feature.AUTO_DETECT_IS_GETTERS);       
		objectMapper.getSerializationConfig().setAnnotationIntrospector(introspector);
		
		super.setObjectMapper(objectMapper);
		
		super.renderMergedOutputModel(model, request, response);
	}
}
