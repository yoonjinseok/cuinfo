package com.cyberup.schedule.kocw;

/***************************************************************************************************
 * $Id: SPHarvester.java, v 1.0 2003/10/24 revision : 2003/11/12 Copyright (C) 2003 TriGem Infonet,
 * Inc. All rights reserved.
 **************************************************************************************************/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.kocw.core.metadata.kem.Classification;
import net.kocw.core.metadata.kem.Description;
import net.kocw.core.metadata.kem.General;
import net.kocw.core.metadata.kem.Kem;
import net.kocw.core.metadata.kem.Kind;
import net.kocw.core.metadata.kem.LifeCycle;
import net.kocw.core.metadata.kem.MetaMetadata;
import net.kocw.core.metadata.kem.Relation;
import net.kocw.core.metadata.kem.Rights;
import net.kocw.core.metadata.kem.RightsHolder;
import net.kocw.core.metadata.kem.TaxonPath;
import net.kocw.core.metadata.kem.Technical;
import net.kocw.core.metadata.service.MetadataService;
import net.kocw.core.taxonomy.service.TaxonomyService;
import net.kocw.core.taxonomy.vo.SyllabusTaxon;
import net.kocw.core.taxonomy.vo.SyllabusTaxonomy;
import net.kocw.core.taxonomy.vo.Taxonomy;
import net.kocw.management.University;
import net.kocw.management.service.UniversityService;
import net.kocw.tools.batch.excel.CourseSet;
import net.kocw.util.VCard;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cyberup.model.course.Course;
import com.cyberup.model.course.CourseStatus;
import com.cyberup.model.course.CourseType;
import com.cyberup.model.course.Lecture;
import com.cyberup.model.course.Material;
import com.cyberup.model.course.SyllabusPathType;
import com.cyberup.service.course.CourseService;
import com.cyberup.util.DateFormatter;

@Component
public class KocwDistributor {
    protected Logger logger = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    protected CourseService courseService;
    
    protected TaxonomyService taxonomyService;
    protected MetadataService metadataService;
    protected UniversityService universityService;
    
    protected Date startDate;
    protected Date endDate;
    
    public final static int BUSINESSTYPECODE = 21;
    public final static int BUSINESSTYPECODE_CONFERENCE = 22;
    public final static int BUSINESSTYPECODE_NONTECH = 23;
    public final static int COLLECT_TYPE_CODE = 10;
    public final static String CCLID = "by-nd";
    public final static String usid = "cuinfo";
    public final static int ORGANIZATIONID = 1102;
    public final static String META_SOURCE = "KEMv3.0";
    public final static String CATALOG = "CUINFO";
    public final static String CATALOGCOURSE = "CUCOURSE";
    public final static String CATALOGLECTURE = "CULECTURE";
    public final static String BLANK_FORMAT = "text/";
    public final static String COURSE_VIEW_URI = "http://www.kocw.net/home/search/kemView.do?kemId=";
    public final static int STATUS_CODE_READY = 1;
    public final static int STATUS_CODE_MODREQ = 2;
    public final static int STATUS_CODE_MODCOM = 3;
    public final static int STATUS_CODE_PAUSEREQ = 4;
    public final static int STATUS_CODE_PAUSECOM = 5;
    public final static int STATUS_CODE_TRASCOM = 6;
    
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	protected void init()
	{
		ApplicationContext context = new GenericXmlApplicationContext(new String[] {
				"spring/kocw/beans-services.xml",
				"spring/kocw/beans-jdbc-dao.xml",
				"spring/kocw/beans-datasource.xml" });
		
		taxonomyService = (TaxonomyService)context.getBean(TaxonomyService.class);
		metadataService = (MetadataService)context.getBean(MetadataService.class);
		universityService = (UniversityService)context.getBean(UniversityService.class);
	}
	
	public static void main(String[] args) {
		
	}
	
	private VCard createVCard(String university, String name, String secName)
	{
		VCard entity = new VCard();
		entity.setFullName(name);
		entity.setEnglishName(secName);
		entity.setOrganization(university);
		entity.setVersion("3.0");
		
		return entity;
	}
	
	private SyllabusTaxonomy getTaxonomy(String classification) throws Exception
	{
		SyllabusTaxonomy syllabusTaxonomy = null;
		
		Taxonomy taxonomy = taxonomyService.findByOriginCode(classification);
		
		if(taxonomy != null)
		{
			List<Taxonomy> taxonomys = taxonomyService.findAllsById(String.valueOf(taxonomy.getId()));
			if(taxonomys != null && taxonomys.size() >= 3)
			{
				syllabusTaxonomy = new SyllabusTaxonomy();
				
				for(int j = 0; j < taxonomys.size(); j++)
				{
					SyllabusTaxon syllabusTaxon = new SyllabusTaxon();
					syllabusTaxon.setId(taxonomys.get(j).getId());
					syllabusTaxon.setName(taxonomys.get(j).getKoName());
					
					if(j == 0)
						syllabusTaxonomy.setLevel3Taxon(syllabusTaxon);
					else if(j == 1)
						syllabusTaxonomy.setLevel2Taxon(syllabusTaxon);
					else if(j == 2)
					{
						syllabusTaxonomy.setLevel1Taxon(syllabusTaxon);
						break;
					}
				}
			}
		}
		
		return syllabusTaxonomy;
	}
	
	private SyllabusTaxonomy getEtcTaxonomy()
	{
		SyllabusTaxonomy syllabusTaxonomy = null;
		
		List<Taxonomy> taxonomys = taxonomyService.findAllsByKonameForAll("기타");
		if(taxonomys != null && taxonomys.size() >= 3)
		{
			syllabusTaxonomy = new SyllabusTaxonomy();
			
			for(int j = 0; j < taxonomys.size(); j++)
			{
				SyllabusTaxon syllabusTaxon = new SyllabusTaxon();
				syllabusTaxon.setId(taxonomys.get(j).getId());
				syllabusTaxon.setName(taxonomys.get(j).getKoName());
				
				if(j == 0)
					syllabusTaxonomy.setLevel3Taxon(syllabusTaxon);
				else if(j == 1)
					syllabusTaxonomy.setLevel2Taxon(syllabusTaxon);
				else if(j == 2)
				{
					syllabusTaxonomy.setLevel1Taxon(syllabusTaxon);
					break;
				}
			}
		}
		
		return syllabusTaxonomy;
	}
	

	private Classification getClassification() throws Exception
	{
		Classification classification = new Classification();
		TaxonPath taxonPath = new TaxonPath();
		taxonPath.setSource("ko", CATALOG);
		
		SyllabusTaxonomy syllabusTaxonomy = getEtcTaxonomy();
		
		taxonPath.addTaxon(String.valueOf(syllabusTaxonomy.getLevel3Taxon().getId()), 
				"ko", syllabusTaxonomy.getLevel1Taxon().getName() + "/" + 
				syllabusTaxonomy.getLevel2Taxon().getName() + "/" + 
				syllabusTaxonomy.getLevel3Taxon().getName());
		classification.addTaxonPath(taxonPath);
		
		return classification;
	}
	
	private void settingKeywords(General general, String lang, String keywords)
	{
		String[] keywordsArray = null;
		if (keywords == null) {
			keywordsArray = null;
		} else {
			keywordsArray = keywords.split(",");
		}
		for (int i = 0; keywordsArray != null && i < keywordsArray.length; i++) {
			general.addKeyword(lang, keywordsArray[i].trim());
		}
	}
	
	protected String makeCourseMetadataSource(int courseId)
	{
		return CATALOG + CATALOGCOURSE + courseId;
	}
	protected String makeLectureMetadataSource(int lectureId)
	{
		return CATALOG + CATALOGLECTURE + lectureId;
	}
	
	private int getBusinessTypeCode(String type, String coursePath)
	{
		if(!StringUtils.isEmpty(coursePath))
		{
			if(type.equals(CourseType.CONFERENCE.getValue()))
				return BUSINESSTYPECODE_CONFERENCE;
			else
				return BUSINESSTYPECODE;
		}
		else
			return BUSINESSTYPECODE_NONTECH;
	}
	
	protected CourseSet createKem(Course course) throws Exception
	{
		String langKo = course.getLanguage().substring(0, 2).toLowerCase();
		
		Kem kem = new Kem();
		kem.setCourse_id(course.getCourseId());
		University university = findUniversity(course.getUniversityName());
		if(university != null)
			kem.setUniversity_id(university.getId());
		else
		{
			kem.setUniversity_id(createUniversity(course.getUniversityName(), "2"));
		}

		// general
		General general = new General();
		general.addIdentifier(CATALOG, makeCourseMetadataSource(course.getCourseId()));
		general.putTitle(langKo, course.getTitle());
		general.addSubTitle(langKo, course.getSubtitle()); 
		general.addLanguage(langKo);
		
		Description description = new Description();
		description.put(langKo, course.getDescription());
		general.addDescription(description);

		settingKeywords(general, langKo, course.getKeyword());

		kem.setGeneral(general);

		// metaMetadata
		MetaMetadata metaMetadata = new MetaMetadata();
		metaMetadata.addIdentifier(CATALOG, makeCourseMetadataSource(course.getCourseId()));
		
		LifeCycle lifeCycle = new LifeCycle();
		
		kem.setRights(new Rights());
		settingContributors(kem.getRights(), metaMetadata, lifeCycle, course.getUniversityName(), course.getRegDate(), course.getManager(), course.getManager(), "");
		
		kem.setMetaMetadata(metaMetadata);
		kem.setLifeCycle(lifeCycle);
		
		kem.setBusinessTypeCode(getBusinessTypeCode(StringUtils.defaultString(course.getType(),"0"), ""));

		// technical
		Technical technical = new Technical();
		technical.addLocation("");
		technical.addFormat("text/");
		kem.setTechnical(technical);

		// classification
		Classification classification = getClassification();

		kem.addClassification(classification);
       
	    // 국내외 구분
		kem.setIsDomestic("Y"); 
		 
		//강좌언어  
		kem.setLanguage_code(langKo); 
		kem.setCollectTypeCode(COLLECT_TYPE_CODE);
		try {
			kem.setCredit(Integer.parseInt(course.getCredit()));
		} catch (Exception e) {}
		kem.setDeptName(course.getDepartment());
		kem.setStartDate(course.getSvcStart());
		kem.setEndDate(course.getSvcEnd());
		kem.setPublicYn("N");
		kem.setServiceYn(StringUtils.defaultString(course.getPublicYn(),"N"));
		kem.setGrants(StringUtils.defaultString(course.getPublicYn(),"N"));
		kem.setRequireGubn("");
		kem.setMobilePath("");
		
		if(!StringUtils.isEmpty(course.getPlanLocation()) && course.getSyllabusPathType().equals(SyllabusPathType.URI.getValue()))
		{
			Relation planRelation = new Relation();
			planRelation.setKind(new Kind(META_SOURCE, "ispartof"));
			planRelation.setResource(META_SOURCE, course.getPlanLocation(), langKo, "강의계획서");
	    	kem.addRelation(planRelation);
		}
		
		CourseSet courseSet = new CourseSet(kem);
		courseSet.setCcl(!StringUtils.isEmpty(course.getRights())?course.getRights().toLowerCase():CCLID);
		courseSet.setTerm(course.getTermYear() + "년" + " " + course.getTermSemesterName());
		courseSet.setLectures(createLectures(course.getManager(), course.getType(), course.getUniversityName(), "Y", 
				langKo, course.getRegDate(), 
				classification, course.getLectureList()));

		return courseSet;
	}
	
	private void addRelations(String langKo, Kem kem, List<Material> materials)
	{
		for(int j = 0; j < materials.size(); j++)
	    {
			if(!StringUtils.isEmpty(materials.get(j).getLocation()))
			{
				Relation relation = new Relation();
		    	relation.setKind(new Kind(META_SOURCE, "isreferencedby"));
		    	relation.setResource(META_SOURCE, materials.get(j).getLocation(), langKo, StringUtils.defaultString(materials.get(j).getTitle()));
		    	
		    	kem.addRelation(relation);
			}
	    }
	}
	
	private void settingContributors(Rights rights, MetaMetadata metaMetadata, LifeCycle lifeCycle, 
			String universityName, Date regDate, 
			String righter, String manager, String master)
	{
		if(!StringUtils.isEmpty(righter))
		{
			RightsHolder rightsHolder = new RightsHolder();
			rightsHolder.setDate(new net.kocw.core.metadata.kem.Date(new DateFormatter("yyyy-MM-dd").print(regDate, Locale.getDefault())));
			rightsHolder.setEntity(righter);
			rights.addRightsHolder(rightsHolder);
		}
		
		if(!StringUtils.isEmpty(manager))
		{
			metaMetadata.addContribute(META_SOURCE, "creator",
					new DateFormatter("yyyy-MM-dd").print(regDate, Locale.getDefault()), 
					createVCard(universityName, manager, manager).format());
			lifeCycle.addContribute(META_SOURCE, "subject matter expert",
					new DateFormatter("yyyy-MM-dd").print(regDate, Locale.getDefault()), 
					createVCard(universityName, manager, manager).format());
		}
		
		if(!StringUtils.isEmpty(manager))
		{
			lifeCycle.addContribute(META_SOURCE, "author",
					new DateFormatter("yyyy-MM-dd").print(regDate, Locale.getDefault()), 
					createVCard(universityName, manager, manager).format());
		}
		
		if(!StringUtils.isEmpty(master))
		{
			lifeCycle.addContribute(META_SOURCE, "subject matter expert",
					new DateFormatter("yyyy-MM-dd").print(regDate, Locale.getDefault()), 
					createVCard(universityName, master, master).format());
		}
		
		if(!StringUtils.isEmpty(universityName))
		{
			lifeCycle.addContribute(META_SOURCE, "initiator",
					new DateFormatter("yyyy-MM-dd").print(regDate, Locale.getDefault()), 
					createVCard(universityName, universityName, universityName).format());
		}
	}
	
	private List createLectures(String righter, String type, String universityName, String isDomestic, String langKo, Date regDate,
			Classification classification, 
			List<Lecture> lectures) {

		List lectureMap = new ArrayList();

		for (int i = 0; i < lectures.size(); i++) 
		{
			Lecture lecture = (Lecture) lectures
					.get(i);

			Kem kem = new Kem();

			// general
			General general = new General();
			general.addIdentifier(CATALOG, makeLectureMetadataSource(lecture.getLectureId()));
			general.putTitle(langKo, lecture.getTitle());
			if(!StringUtils.isEmpty(lecture.getSubtitle()))
				general.addSubTitle(langKo, lecture.getSubtitle()); 
			general.addLanguage(StringUtils.defaultString(langKo).toLowerCase());

			Description description = new Description();
			description.put(langKo, lecture.getDescription());
			general.addDescription(description);
			
			//insert keywords to lecture!!
			general.addKeyword(langKo, lecture.getKeyword());
			
			kem.setGeneral(general);

			// metaMetadata
			MetaMetadata metaMetadata = new MetaMetadata();
			metaMetadata.addIdentifier(CATALOG, makeLectureMetadataSource(lecture.getLectureId()));
			
			kem.setRights(new Rights());
			LifeCycle lifeCycle = new LifeCycle();
			settingContributors(kem.getRights(), metaMetadata, lifeCycle, universityName, regDate, righter, "", lecture.getMaster());
			
			kem.setMetaMetadata(metaMetadata);
			kem.setLifeCycle(lifeCycle);

			// classification
			kem.addClassification(classification);
			
			String addFormat = null; 
			Technical technical = new Technical();
			technical.addLocation(lecture.getMovLocation()); 
			
			if(!StringUtils.isEmpty(lecture.getMovLocation()))
			{
				if(lecture.getMovLocation().indexOf("kocw") < 0){ 
					addFormat = "text/html";
				}else{ 
					addFormat = "application/";
				}
			}
			else
			{
				addFormat = "text/";
			}
			
			technical.addFormat(addFormat);
			//technical.addFormat("text/html");
			kem.setTechnical(technical); 
			 
			 // 국내외 구분
			kem.setIsDomestic(isDomestic); 
			 
			//강좌언어  
			kem.setLanguage_code(langKo); 
			 
			// 강좌유형 
			kem.setBusinessTypeCode(getBusinessTypeCode(type, lecture.getMovLocation())); 
			 
			//차시유형 
			if(lecture.getOrders() > 1){ 
				kem.setLearningResourceTypeCode(5);
			}else{ 
				kem.setLearningResourceTypeCode(2);
			}
			 
			//course_info : lecture_group_order 
		    kem.setLectureGroupOrder(lecture.getGroups());
		    
		    addRelations(langKo, kem, lecture.getLecFileList());
			
			// lectureMap.put(new Integer(i), kem);
			lectureMap.add(kem);
		}

		return lectureMap;
	}
	
	private List<CourseSet> selectDistList(Date startDate, Date endDate)
	{
		List<CourseSet> kems = new ArrayList<CourseSet>();
		
		List<Integer> courses = courseService.selectDistList(
				new DateFormatter("yyyy-MM-dd").print(startDate, Locale.getDefault()), 
				new DateFormatter("yyyy-MM-dd").print(endDate, Locale.getDefault()));
		
		for(int i = 0; i < courses.size(); i++)
		{
			Course course = courseService.getCourseInfo(courses.get(i));
			
			try {
				kems.add(createKem(course));
			} catch (Exception e) {
				logger.error(course.getCourseId() +" || "+ e.getMessage(), e);
			}
		}
		
		return kems;
	}
	
	private University findUniversity(String universityName)
	{
		List<University> list = universityService.findByKeyword("", "", universityName, 1, 1, 1);
		return list.get(0);
	}
	private int createUniversity(String universityName, String estDiv)
	{
		University university = new University();
		university.setName(universityName);
		university.setEstDiv(estDiv);
		return universityService.createUniversity(university);
	}
	
	public List<Kem> selectKemList(String metadataSource) throws Exception
	{
		if(metadataService == null)
			init();
		
		return metadataService.findBySrcId(metadataSource);
	}
	
	public int updateStatusCode(int kemId, int statusCode) throws Exception
	{
		if(metadataService == null)
			init();
		
		return metadataService.updateStatusCode(kemId, statusCode);
	}
	
	public void demolish(Kem kem)
	{
		if(metadataService == null)
			init();
		
		try {
			metadataService.removeCourse(new String[]{String.valueOf(kem.getKemId())});
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void demolish(int kemId)
	{
		if(metadataService == null)
			init();
		
		try {
			metadataService.removeCourse(new String[]{String.valueOf(kemId)});
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void run()
	{
		init();
		
		List<CourseSet> kems = selectDistList(startDate, endDate);
		
		for(int i = 0; i < kems.size(); i++)
		{
			try {
				CourseSet set = kems.get(i);
				
				String metadataSource = set.getCourse().getGeneral().getIdentifier(CATALOG);
				List<Kem> kemList = selectKemList(metadataSource);
				if(kemList != null)
				{
					for(int k = 0; k < kemList.size(); k++)
					{
						switch (kemList.get(k).getStatusCode()) {
						case STATUS_CODE_READY:
						case STATUS_CODE_PAUSECOM:
							demolish(Integer.parseInt(kemList.get(k).getKemId()));
							break;

						case STATUS_CODE_MODREQ:
						case STATUS_CODE_MODCOM:
							updateStatusCode(Integer.parseInt(kemList.get(k).getKemId()), STATUS_CODE_PAUSEREQ);
							break;
						
						case STATUS_CODE_PAUSEREQ:
							break;
						
						case STATUS_CODE_TRASCOM:
							updateStatusCode(Integer.parseInt(kemList.get(k).getKemId()), STATUS_CODE_PAUSEREQ);
							break;

						default:
							break;
						}
					}
				}
				
				metadataService.createForCourseSet(CATALOG, set, usid, ORGANIZATIONID);
				
				courseService.updateStatus(set.getCourse().getCourse_id(), CourseStatus.TRANSFER.getValue(), "kocwscheduler");
				
				logger.info("course id : " + set.getCourse().getCourse_id() + " distribute success.");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
		}
	}
}