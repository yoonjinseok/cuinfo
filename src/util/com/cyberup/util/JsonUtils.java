package com.cyberup.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.springframework.validation.BindingResult;

public class JsonUtils {
	public static String makeJSON(Object o)
	{
		try {
			StringWriter writer = new StringWriter();
			
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
			
			Object value = o;
			if(o instanceof Map)
				value = filterModel((Map)o);
			
			JsonGenerator generator =
					objectMapper.getJsonFactory().createJsonGenerator(writer);
			objectMapper.writeValue(generator, value);
			
			return writer.toString();
		} catch (Exception e) {
			Logger.getLogger(JsonUtils.class).debug(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public static Object filterModel(Map<String, Object> model) {
		Map<String, Object> result = new HashMap<String, Object>(model.size());
		Set<String> renderedAttributes = model.keySet();
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (!(entry.getValue() instanceof BindingResult) && renderedAttributes.contains(entry.getKey())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
}
