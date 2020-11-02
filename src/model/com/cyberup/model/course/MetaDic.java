package com.cyberup.model.course;

import com.cyberup.framework.model.BaseObject;

public class MetaDic extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 166435516139231562L;
	
	private Integer metadicId = 0;
	private String collType = "";
	private String element = "";
	private String elementName = "";
	private String elementDesc = "";
	private String mandatoryYn = "";
	private String defaultVal = "";
	private String recommendYn = "";
	private String repeatYn = "";
	private Integer dispOrder = 0;
	private String inputType = "";
	private String inputRule = "";
	private String langYn = "";
	private String longYn = "";

	public Integer getMetadicId(){
		return this.metadicId;
	}
	public void setMetadicId(Integer metadicId){
		if(metadicId != null)
			this.metadicId = metadicId;
	}
	public String getCollType(){
		return this.collType;
	}
	public void setCollType(String collType){
		this.collType = collType;
	}
	public String getElement(){
		return this.element;
	}
	public void setElement(String element){
		this.element = element;
	}
	public String getElementName(){
		return this.elementName;
	}
	public void setElementName(String elementName){
		this.elementName = elementName;
	}
	public String getElementDesc(){
		return this.elementDesc;
	}
	public void setElementDesc(String elementDesc){
		this.elementDesc = elementDesc;
	}
	public String getMandatoryYn(){
		return this.mandatoryYn;
	}
	public void setMandatoryYn(String mandatoryYn){
		this.mandatoryYn = mandatoryYn;
	}
	public String getDefaultVal(){
		return this.defaultVal;
	}
	public void setDefaultVal(String defaultVal){
		this.defaultVal = defaultVal;
	}
	public String getRecommendYn(){
		return this.recommendYn;
	}
	public void setRecommendYn(String recommendYn){
		this.recommendYn = recommendYn;
	}
	public String getRepeatYn(){
		return this.repeatYn;
	}
	public void setRepeatYn(String repeatYn){
		this.repeatYn = repeatYn;
	}
	public Integer getDispOrder(){
		return this.dispOrder;
	}
	public void setDispOrder(Integer dispOrder){
		if(dispOrder != null)
			this.dispOrder = dispOrder;
	}
	public String getInputType(){
		return this.inputType;
	}
	public void setInputType(String inputType){
		this.inputType = inputType;
	}
	public String getInputRule(){
		return this.inputRule;
	}
	public void setInputRule(String inputRule){
		this.inputRule = inputRule;
	}
	public String getLangYn(){
		return this.langYn;
	}
	public void setLangYn(String langYn){
		this.langYn = langYn;
	}
	public String getLongYn(){
		return this.longYn;
	}
	public void setLongYn(String longYn){
		this.longYn = longYn;
	}
}
