package com.cyberup.model.course;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.cyberup.framework.model.BaseObject;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.util.DateFormatter;

public abstract class MetaData extends PagingModel {	
	private boolean valid = true;
	
	private String regDate;
	private String modDate;
	private String delDate;

	/**
	 * 
	 */
	private static final long serialVersionUID = -9129883661177563884L;
	
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public static String stripIdPrefix(String courseIdentifier)
	{
		StringBuffer identifier = new StringBuffer();
		
		String[] tokens = StringUtils.split(courseIdentifier, "|");
		
		if(tokens.length > 3)
		{
			for(int i = 3; i < tokens.length; i++)
			{
				if(identifier.length() > 0)
					identifier.append("|");
				
				identifier.append(tokens[i]);
			}
			
			return identifier.toString();
		}
		else
			return courseIdentifier;
		
	}
	public static boolean checkMandatory(MetaDic metaDic, Element element)
	{
		if(element == null)
		{
			if(metaDic.getMandatoryYn().equals("Y"))
			{
				element = new Element(metaDic.getElement());
				element.setText(metaDic.getDefaultVal() != null?metaDic.getDefaultVal():"");
				
				return false;
			}
			else
			{
				element = new Element(metaDic.getElement());
				element.setText(metaDic.getDefaultVal() != null?metaDic.getDefaultVal():"");
			}
		}
		else
		{
			if(element.getTextTrim().equals(""))
			{
				if(metaDic.getMandatoryYn().equals("Y"))
				{
					element.setText(metaDic.getDefaultVal() != null?metaDic.getDefaultVal():"");
					return false;
				}
				else
				{
					element.setText(metaDic.getDefaultVal() != null?metaDic.getDefaultVal():"");
				}
			}
		}
		
		return true;
	}
	
	private void setMetaDate(MetaDic metaDic, Element element)
	{
		if(metaDic.getElement().equals("regDate"))
			this.regDate = getDateString(element.getTextTrim());
		else if(metaDic.getElement().equals("modDate"))
			this.modDate = getDateString(element.getTextTrim());
		else if(metaDic.getElement().equals("delDate"))
			this.delDate = getDateString(element.getTextTrim());
	}
	private String getDateString(Date date)
	{
		return new DateFormatter("yyyyMMdd").print(date, Locale.getDefault());
	}
	private String getDateString(String date)
	{
		int inx = date.indexOf(" ");
		if(inx >= 0)
			return date.substring(0, inx).replaceAll("-", "");
		else
			return date;
	}
	
	public String getScheduleType(Date harvestSdate, Date harvestEdate)
	{
		if(this.delDate.compareTo(getDateString(harvestSdate)) >= 0
				&& getDateString(harvestEdate).compareTo(this.delDate) <= 0)
			return ScheduleType.DELETE.getValue();
		else if(this.regDate.compareTo(getDateString(harvestSdate)) >= 0
				&& getDateString(harvestEdate).compareTo(this.regDate) <= 0)
			return ScheduleType.CREATE.getValue();
		else if(this.modDate.compareTo(getDateString(harvestSdate)) >= 0
				&& getDateString(harvestEdate).compareTo(this.modDate) <= 0)
			return ScheduleType.UPDATE.getValue();
		else
			return "";
	}
	
	protected boolean checkMata(MetaDic metaDic, Element element)
	{
		setMetaDate(metaDic, element);
		
		if(checkMandatory(metaDic, element))
		{
			return true;
		}
		else
		{
			this.valid = false;
			return false;
		}
	}
	public abstract void mapping(MetaDic metaDic, Element element);

}
