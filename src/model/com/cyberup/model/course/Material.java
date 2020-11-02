package com.cyberup.model.course;

import java.lang.reflect.Field;

import org.jdom.Element;

import common.Logger;

public class Material extends MetaData {
	private Logger logger = Logger.getLogger(Material.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1265573129449283633L;
	
	private Integer attfileId = 0;
	private String attfileIdentifier = "";
	private Integer relationId = 0;
	private String relationType = "";
	private String title = "";
	private String location = "";
	private Integer upfileId = 0;
	
	@Override
	public void mapping(MetaDic metaDic, Element element) {
		checkMata(metaDic, element);
		
		if(metaDic.getElement().equals("fileId"))
			this.attfileIdentifier = element.getTextTrim();
		else if(metaDic.getElement().equals("fileLocation"))
			this.location = element.getTextTrim();
		else if(metaDic.getElement().equals("fileDesc"))
			this.title = element.getTextTrim();
		else
		{
			try {
				Field clsField = this.getClass().getDeclaredField(metaDic.getElement());
				clsField.set(this, element.getTextTrim());
			} catch (Exception e) {
				logger.warn(metaDic.getElement() + "("+element.getTextTrim()+") => " +e.getMessage(), e);
			}
		}
	}

	public Integer getAttfileId(){
		return this.attfileId;
	}
	public void setAttfileId(Integer attfileId){
		if(attfileId != null)
			this.attfileId = attfileId;
	}
	public String getAttfileIdentifier(){
		return this.attfileIdentifier;
	}
	public void setAttfileIdentifier(String attfileIdentifier){
		this.attfileIdentifier = attfileIdentifier;
	}
	public Integer getRelationId() {
		return relationId;
	}

	public void setRelationId(Integer relationId) {
		if(relationId != null)
			this.relationId = relationId;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getLocation(){
		return this.location;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public Integer getUpfileId(){
		return this.upfileId;
	}
	public void setUpfileId(Integer upfileId){
		if(upfileId != null)
			this.upfileId = upfileId;
	}
}
