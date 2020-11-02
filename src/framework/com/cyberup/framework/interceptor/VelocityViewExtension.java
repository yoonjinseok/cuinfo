package com.cyberup.framework.interceptor;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;

public class VelocityViewExtension extends VelocityToolboxView {
	@Override
	protected Template getTemplate(String name) throws Exception {
		Logger.getLogger(this.getClass()).debug("getTemplate("+name+")");
		
		name = name.substring(0, name.indexOf(".")) + ".vm";
		Logger.getLogger(this.getClass()).debug("finding template : "+name);
		
		return super.getTemplate(name);
	}

}
