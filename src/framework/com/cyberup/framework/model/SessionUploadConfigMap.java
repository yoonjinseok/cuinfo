package com.cyberup.framework.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class SessionUploadConfigMap extends BaseObject {
	
	public final static String KEY = "confKey";
	
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4711742821989522476L;
	
	private Map<String, SessionUploadConfig> map = new HashMap<String, SessionUploadConfig>();
	
	public void putConfig(String key, SessionUploadConfig sessionUploadConfig)
	{
		map.put(key, sessionUploadConfig);
	}
	
	public SessionUploadConfig findConfig(String confKey)
	{
		if(confKey == null || "".equals(confKey))
		{
			return sessionUploadConfig.get();
		}
		else
		{
			SessionUploadConfig config = map.get(confKey);
			if(config != null)
				return config;
			else
				return null;
		}
	}
}
