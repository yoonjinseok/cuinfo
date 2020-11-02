package com.cyberup.framework.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

public class BeanSqlParameterSource extends BeanPropertySqlParameterSource {
	private Map<String, String> propertyMap;
	private Object object;
	
	public BeanSqlParameterSource(Object object) {
		super(object);
		this.propertyMap = new HashMap<String, String>();
		
		this.object = object;
	}
	
	public BeanSqlParameterSource(Object object, Map<String, String> propertyMap) {
		super(object);
		this.propertyMap = propertyMap;
	}

	public BeanSqlParameterSource map(String paramName, String mappedPropertyName) {
		propertyMap.put(paramName, mappedPropertyName);
		return this;
	}

	public Object getValue(String paramName) throws IllegalArgumentException {
		String mappedPropertyName = this.propertyMap.get(paramName);
		return mappedPropertyName != null ? super.getValue(mappedPropertyName) : super.getValue(paramName);
	}

	public String[] getReadablePropertyNames() {
		String[] propertyNames = super.getReadablePropertyNames();
		String[] mappedPropertyNames = new String[propertyNames.length];
		System.arraycopy(propertyNames, 0, mappedPropertyNames, 0, propertyNames.length);
		int idx = propertyNames.length;
		for(Iterator<String> it = propertyMap.keySet().iterator(); it.hasNext(); ) {
			mappedPropertyNames[idx++] = it.next();
		}
		return mappedPropertyNames;
	}

	public int getSqlType(String paramName) {
		String mappedPropertyName = this.propertyMap.get(paramName);
		return (mappedPropertyName == null) ? 
				super.getSqlType(paramName) : super.getSqlType(mappedPropertyName);
	}
	
	public Object getObject()
	{
		return this.object;
	}
}
