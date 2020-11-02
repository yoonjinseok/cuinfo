package com.cyberup.model.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jdom.Element;

import com.cyberup.util.HtmlUtils;

public class Lecture extends MetaData {
	private Logger logger = Logger.getLogger(Lecture.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 3126924300764677396L;
	
	private Integer lectureId = 0;
	private String[] lectureIds;
	private Integer courseId = 0;
	private String lectureIdentifier = "";
	private String master = "";
	private String title = "";
	private String keyword = "";
	private Integer orders = 0;
	private Integer groups = 0;
	private String movLocation = "";
	private String register = "";
	private Date regDate;
	private String modifier = "";
	private Date modDate;
	
	private String subtitle = "";
	private String description = "";
	
	private List<Material> lecFileList = new ArrayList<Material>();
	
	public void init()
	{
	}
	public boolean checkStatus()
	{
		if(!isValid())
		{
			Logger.getLogger(this.getClass()).debug("lecture valid : " + isValid());
			
			return false;
		}
		
		for(int i = 0; i < lecFileList.size(); i++)
		{
			if(!lecFileList.get(i).isValid())
			{
				Logger.getLogger(this.getClass()).debug("lecFile valid : " + lecFileList.get(i).isValid());
				
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public void mapping(MetaDic metaDic, Element element) {
		checkMata(metaDic, element);
		
		if(metaDic.getElement().equals("lecIdentifier"))
			this.lectureIdentifier = element.getTextTrim();
		else if(metaDic.getElement().equals("title"))
			this.title = element.getTextTrim();
		else if(metaDic.getElement().equals("keyword"))
		{
			if(StringUtils.isEmpty(element.getTextTrim()))
				element.setText(this.title);
			
			this.keyword = element.getTextTrim();
		}
		else if(metaDic.getElement().equals("orders"))
			this.orders = Integer.parseInt(element.getTextTrim());
		else if(metaDic.getElement().equals("groups"))
			this.groups = Integer.parseInt(element.getTextTrim());
	}

	public Integer getLectureId(){
		return this.lectureId;
	}
	public void setLectureId(Integer lectureId){
		if(lectureId != null)
			this.lectureId = lectureId;
	}
	public String[] getLectureIds() {
		return lectureIds;
	}
	public void setLectureIds(String[] lectureIds) {
		this.lectureIds = lectureIds;
	}
	public Integer getCourseId(){
		return this.courseId;
	}
	public void setCourseId(Integer courseId){
		if(courseId != null)
			this.courseId = courseId;
	}
	public String getLectureIdentifier(){
		return this.lectureIdentifier;
	}
	public void setLectureIdentifier(String lectureIdentifier){
		this.lectureIdentifier = lectureIdentifier;
	}
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription(int max, String pad)
	{
		return HtmlUtils.substring(this.description, max, pad);
	}
	public String getKeyword(){
		return this.keyword;
	}
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
	public Integer getOrders(){
		return this.orders;
	}
	public void setOrders(Integer orders){
		if(orders != null)
			this.orders = orders;
	}
	public Integer getGroups(){
		return this.groups;
	}
	public void setGroups(Integer groups){
		if(groups != null)
			this.groups = groups;
	}
	public String getRegister(){
		return this.register;
	}
	public void setRegister(String register){
		this.register = register;
	}
	public Date getRegDate(){
		return this.regDate;
	}
	public void setRegDate(Date regDate){
		this.regDate = regDate;
	}
	public String getModifier(){
		return this.modifier;
	}
	public void setModifier(String modifier){
		this.modifier = modifier;
	}
	public Date getModDate(){
		return this.modDate;
	}
	public void setModDate(Date modDate){
		this.modDate = modDate;
	}

	public List<Material> getLecFileList() {
		return lecFileList;
	}

	public void setLecFileList(List<Material> lecFileList) {
		this.lecFileList = lecFileList;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public String getMovLocation() {
		return movLocation;
	}
	public void setMovLocation(String movLocation) {
		this.movLocation = movLocation;
	}
}
