package com.cyberup.framework.controller;

import java.beans.PropertyEditorSupport;

import javax.xml.datatype.DatatypeConstants;

import org.apache.log4j.Logger;

public class IntPropertyEditor extends PropertyEditorSupport{
	public String getAsText() {   
		
		Logger.getLogger(this.getClass()).debug("getAsText()");
		
        Integer value = (Integer) getValue();   
        if (value.intValue() == DatatypeConstants.FIELD_UNDEFINED) {   
            return "0";
        } else {   
            return value.toString();   
        }   
    }   
    public void setAsText(String value) {   
    	Logger.getLogger(this.getClass()).debug("setAsText("+value+")");
    	
        if (value != null && value.length() > 0) {   
            setValue(Integer.valueOf(value));   
        } else {   
            setValue(null);   
        }   
    }
	@Override
	public Object getSource() {
		Logger.getLogger(this.getClass()).debug("getSource");
		return super.getSource();
	}
	@Override
	public void setSource(Object source) {
		Logger.getLogger(this.getClass()).debug("setSource("+source+")");
		super.setSource(source);
	}
	@Override
	public void setValue(Object value) {
		Logger.getLogger(this.getClass()).debug("setValue");
		super.setValue(value);
	}
	@Override
	public Object getValue() {
		Logger.getLogger(this.getClass()).debug("getValue");
		return super.getValue();
	}
	@Override
	public String[] getTags() {
		Logger.getLogger(this.getClass()).debug("getTags");
		return super.getTags();
	}
}
