package com.cyberup.controller.mgr.course;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.controller.mgr.common.FileUploadController;
import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.CourseStatus;
import com.cyberup.model.course.CourseType;
import com.cyberup.model.course.LanguageType;
import com.cyberup.model.course.Lecture;
import com.cyberup.model.course.Material;
import com.cyberup.model.course.RelationType;
import com.cyberup.model.course.SemesterType;
import com.cyberup.model.course.SyllabusPathType;
import com.cyberup.model.home.FileUpload;
import com.cyberup.schedule.MetaCollector;
import com.cyberup.schedule.ResponseHandler;
import com.cyberup.service.course.CourseService;
import com.cyberup.service.course.LectureService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.util.DateFormatter;

@Controller
@RequestMapping("/mgr/course")
public class MetaCollectionController {
	@Autowired
	protected SiteConfiguration siteConfiguration;
	@Autowired
	protected ApplicationContext applicationContext;
	
	@Autowired
	protected CourseService courseService;
	@Autowired
	protected LectureService lectureService;
	@Autowired
	protected FileUploadService fileUploadService;
	
	@Autowired
	protected MapValidator metaCollectionUpdateValidator;
	@Autowired
	protected MapValidator metaCollectionLectureUpdateValidator;

	@Inject
	protected Provider<LoginInfo> loginInfoProvider;
	@Inject
	protected Provider<SessionUploadConfigMap> sessionUploadConfigMap;
	
	@Autowired
	protected FileUploadController fileUploadController;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		/* register appropriate date editor */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Resource(name="metaCollectionUpdateValidator")
	public void setMetaCollectionUpdateValidator(MapValidator metaCollectionUpdateValidator) {
		this.metaCollectionUpdateValidator = metaCollectionUpdateValidator;
	}

	@Resource(name="metaCollectionLectureUpdateValidator")
	public void setMetaCollectionLectureUpdateValidator(MapValidator metaCollectionLectureUpdateValidator) {
		this.metaCollectionLectureUpdateValidator = metaCollectionLectureUpdateValidator;
	}

	@RequestMapping("/metaCollection")
	public String metaCollection(ModelMap model) {
		
		model.addAttribute("courseStatusList", CourseStatus.values());
		model.addAttribute("courseTypeList", CourseType.values());
		
		List<CourseStatus> statusList = new ArrayList<CourseStatus>();
		CourseStatus[] statuses = CourseStatus.values();
		for(int i = 0; i < statuses.length; i++)
		{
			if(!statuses[i].getValue().equals(CourseStatus.RESUMMARY.getValue()))
			{
				statusList.add(statuses[i]);
			}
		}
		model.addAttribute("courseStatusManageList", statusList);
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_ccl")
	public String ccl(Course courseParam, ModelMap modelMap)
	{
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_list", method = RequestMethod.POST)
	public String list(Course courseParam, ModelMap modelMap) {
		
		List<CourseStatus> statusList = new ArrayList<CourseStatus>();
		CourseStatus[] statuses = CourseStatus.values();
		for(int i = 0; i < statuses.length; i++)
		{
			if(!statuses[i].getValue().equals(CourseStatus.RESUMMARY.getValue()))
			{
				statusList.add(statuses[i]);
			}
		}
		modelMap.addAttribute("courseStatusList", statusList);
		
		/*
		List<Course> list = courseService.selectList(courseParam.getSorting(), courseParam.getAscending(), courseParam.getShowCnt(), courseParam.getCurrPage(), courseParam.getModStartDate(), courseParam.getModEndDate(), courseParam.getSvcStatus(), courseParam.getUniversityName(), courseParam.getDepartment(), 
				courseParam.getIsPrev(), courseParam.getPublicYn(), courseParam.getTermYearStart(), courseParam.getTermYearEnd(), courseParam.getType(), courseParam.getSearchField(), courseParam.getSearchValue());
		 * */
		List<Course> list = courseService.selectList(courseParam);
		modelMap.addAttribute("courseList", list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, courseParam.getCurrPage(), courseParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, courseParam.getCurrPage(), courseParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_updatestatusAll")
	public String updatestatusAll(Course courseParam, ModelMap modelMap)
	{
		LoginUser login = loginInfoProvider.get().currentUser();
		
		List<Course> list = courseService.selectList(0, 0, 100000, 1, courseParam.getModStartDate(), courseParam.getModEndDate(), courseParam.getSvcStatus(), courseParam.getUniversityName(), courseParam.getDepartment(), 
				courseParam.getIsPrev(), courseParam.getPublicYn(), courseParam.getTermYearStart(), courseParam.getTermYearEnd(), courseParam.getType(), courseParam.getSearchField(), courseParam.getSearchValue());
		if(list.size() > 0)
		{
			for(int i = 0; i < list.size(); i++)
			{
				if(!list.get(i).getSvcStatus().equals(courseParam.getSvcStatusAll()))
				{
					courseService.updateStatus(list.get(i).getCourseId(), courseParam.getSvcStatusAll(), login.getUserId());
				}
			}
		}
		
		return null;
	}
	
	private boolean existUpdateStatus(String courses, String svcStatusesOne, String[] statusInfo)
	{
		int inx = svcStatusesOne.indexOf("|");
		statusInfo[0] = svcStatusesOne.substring(0, inx);
		statusInfo[1] = svcStatusesOne.substring(inx + 1);
		
		if(courses.indexOf(statusInfo[0]) >= 0)
			return true;
		else
			return false;
	}
	
	@RequestMapping(value = "/metaCollection_updatestatus")
	public String updatestatus(Course courseParam, ModelMap modelMap)
	{
		LoginUser login = loginInfoProvider.get().currentUser();
		
		String[] courseIds = courseParam.getCourseIds();
		
		if(courseIds != null)
		{
			String courses = StringUtils.join(courseIds, ",");
			if(courseParam.getSvcStatuses() != null)
			{
				Course course = null;
				for(int i = 0; i < courseParam.getSvcStatuses().length; i++)
				{
					String[] statusInfo = new String[2];
					if(existUpdateStatus(courses, courseParam.getSvcStatuses()[i], statusInfo))
					{
						course = courseService.selectInfo(Integer.parseInt(statusInfo[0]));
						
						if(!course.getSvcStatus().equals(statusInfo[1]))
						{
							courseService.updateStatus(Integer.parseInt(statusInfo[0]), statusInfo[1], login.getUserId());
						}
					}
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("src/conf/spring/log4j.xml");
			
			ApplicationContext context = new GenericXmlApplicationContext("spring/cyberup-context-datasource.xml ");
			String[] beans = context.getBeanDefinitionNames();
			for(int i = 0; i < beans.length; i++)
			{
				System.out.println(beans[i]);
			}
			
			CourseService courseService = context.getBean(CourseService.class);
			System.out.println(courseService.getCourseInfo(285));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/metaCollection_checkLock")
	public String checkLock(HttpSession session, Course courseParam, ModelMap modelMap)
	{
		Course course = courseService.selectInfo(courseParam.getCourseId());
		
		session.setAttribute("lockCourse", "N");
		
		if("Y".equals(course.getIsLock()))
		{
			modelMap.addAttribute("isLock", course.getIsLock());
			List<Integer> ids = courseService.selectIdsOfIdentifier(course.getUniversityId(), course.getCourseIdentifier(), "Y");
			if(ids.size() > 0)
			{
				modelMap.addAttribute("tempCourseId", ids.get(0));
				session.setAttribute("lockCourse", "Y");
			}
			else
				modelMap.addAttribute("tempCourseId", "");
		}
		else
		{
			modelMap.addAttribute("isLock", "N");
		}
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_read")
	public String read(Course courseParam, ModelMap modelMap)
	{
		Course course = courseService.selectInfo(courseParam.getCourseId());
		
		modelMap.addAttribute("course", course);
		
		modelMap.addAttribute("uploadUrl", siteConfiguration.getUploadUrl() + courseParam.getCourseId());
		
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_confirm", method = RequestMethod.POST)
	public String confirm(Course courseParam, 
			ModelMap modelMap, SessionStatus sessionStatus) {
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		Course course = courseService.selectInfo(courseParam.getCourseId());
		List<Integer> ids = courseService.selectIdsOfIdentifier(course.getUniversityId(), course.getCourseIdentifier(), "");
		
		for(int i = 0; i < ids.size(); i++)
		{
			if(ids.get(i).intValue() == courseParam.getCourseId().intValue())
			{
				courseService.updateIsLock(courseParam.getCourseId(), "N", login.getUserId());
			}
			else
			{
				courseService.updateDeleteInfo(ids.get(i), login.getUserId());
			}
		}
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_updateService", method = RequestMethod.POST)
	public String updateService(Course courseParam, 
			ModelMap modelMap, SessionStatus sessionStatus) {
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		courseService.updateStatus(courseParam.getCourseId(), CourseStatus.TRANSREQUEST.getValue(), login.getUserId());
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	private void putSyllabusConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("hwp,doc,docx,xls,xlsx,ppt,pptx,pdf");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 100);
		sessionUploadConfig.setUploadDir(siteConfiguration.getMetaUploadPath());
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory("T");
		
		sessionUploadConfigMap.get().putConfig("syllabus", sessionUploadConfig);
	}
	private void putPrevThumbnailConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("gif,jpg,jpeg,png,bmp");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 10);
		sessionUploadConfig.setUploadDir(siteConfiguration.getMetaUploadPath());
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory("T");
		
		sessionUploadConfigMap.get().putConfig("prevImg", sessionUploadConfig);
	}
	
	@RequestMapping(value = "/metaCollection_write")
	public String write(HttpSession session, Course courseParam, ModelMap modelMap)
	{
		Admin login = (Admin)loginInfoProvider.get().currentUser();
		
		modelMap.addAttribute("languageTypeList", LanguageType.values());
		modelMap.addAttribute("semesterTypeList", SemesterType.values());
		modelMap.addAttribute("courseTypeList", CourseType.values());
		
		List<CourseStatus> statusList = new ArrayList<CourseStatus>();
		CourseStatus[] statuses = CourseStatus.values();
		for(int i = 0; i < statuses.length; i++)
		{
			if(!statuses[i].getValue().equals(CourseStatus.RESUMMARY.getValue()))
			{
				statusList.add(statuses[i]);
			}
		}
		modelMap.addAttribute("courseStatusList", statusList);
		
		putPrevThumbnailConfig();
		putSyllabusConfig();
		
		session.setAttribute("lockCourse", "N");

		modelMap.addAttribute("login", login);
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, HttpSession session, 
			Course courseParam, 
			ModelMap modelMap, SessionStatus sessionStatus) {
		
		metaCollectionUpdateValidator.validate(courseParam, modelMap);
		
		if(metaCollectionUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		Integer courseId = courseService.selectKey();
		
		if(courseParam.getSyllabusType().equals(SyllabusPathType.FILE.getValue()))
		{
			if(!StringUtils.isEmpty(courseParam.getPlanLocation()))
			{
				mappingSyllabus(session, courseParam, courseId, login.getUserId());
			}
		}
		
		if(!StringUtils.isEmpty(courseParam.getPrevthumbnail())
				&& !courseParam.getPrevthumbnail().startsWith("http://"))
		{
			mappingThumbnail(session, courseParam, courseId, login.getUserId());
		}
		
		courseParam.setRegister(login.getUserId());
		
		courseService.constructCourse(courseId, courseParam);
		
		sessionStatus.setComplete();
		
		modelMap.put("courseId", courseId);
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_modify")
	public String modify(HttpSession session, Course courseParam, ModelMap modelMap)
	{
		Course course = courseService.selectInfo(courseParam.getCourseId());
		
		modelMap.addAttribute("course", course);
		
		write(session, courseParam, modelMap);
		
		modelMap.addAttribute("courseStatusList", CourseStatus.values());
		
		return null;
	}
	
	private void putKocwfileConfig(int courseId)
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("mp4,mp3,hwp,doc,docx,xls,xlsx,ppt,pptx,pdf");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 1000);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadDir(siteConfiguration.getKocwUploadPath());
		sessionUploadConfig.setUploadSubectory(courseId + File.separator + new DateFormatter("yyyyMMddHHmmss").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
	}
	
	@RequestMapping(value = "/metaCollection_kocwfilewrite")
	public String kocwfilewrite(HttpSession session, Course courseParam, ModelMap modelMap)
	{
		Course course = courseService.getCourseInfo(courseParam.getCourseId());
		
		modelMap.addAttribute("course", course);
		
		putKocwfileConfig(course.getCourseId());
		
		modelMap.addAttribute("returnPage", "/mgr/course/metaCollection_kocwfilewrite.pop.action?courseId="+courseParam.getCourseId());
		 
		return null;
	}
	
	private void mappingSyllabus(HttpSession session, Course courseParam, Integer courseId, String userId)
	{
		SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig("syllabus");
		File folder = new File(sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + String.valueOf(courseId.intValue()));
		folder.mkdirs();
		
		String path = (String)session.getAttribute(courseParam.getPlanLocation());
		File src = new File(path);
		File dest = new File(folder, courseParam.getPlanLocation());
		src.renameTo(dest);
		
		String original = (String)session.getAttribute(courseParam.getPlanLocation() + "OriginalFilename");
		
		FileUpload fileUpload = new FileUpload();
		fileUpload.setUpfileFilename(original);
		fileUpload.setUpfilePath(dest.getPath());
		fileUpload.setUpfileRegister(userId);
		fileUpload.setUpfileSize(dest.length());
		fileUpload.setUpfileSource(courseParam.getPlanLocation());
		int upfileId = fileUploadService.insertInfo(fileUpload);
		
		courseParam.setPlanLocation(siteConfiguration.getServerUrl() + siteConfiguration.getServerContext() + "/mgr/common/file_download_id.do.action?upfileId=" + upfileId);
	}
	private void mappingThumbnail(HttpSession session, Course courseParam, Integer courseId, String userId)
	{
		SessionUploadConfig sessionUploadConfig = sessionUploadConfigMap.get().findConfig("prevImg");
		File folder = new File(sessionUploadConfig.getUploadRootDir() + sessionUploadConfig.getUploadDir() + String.valueOf(courseId.intValue()));
		folder.mkdirs();
		
		String path = (String)session.getAttribute(courseParam.getPrevthumbnail());
		File src = new File(path);
		File dest = new File(folder, courseParam.getPrevthumbnail());
		src.renameTo(dest);
		
		String original = (String)session.getAttribute(courseParam.getPrevthumbnail() + "OriginalFilename");
		
		FileUpload fileUpload = new FileUpload();
		fileUpload.setUpfileFilename(original);
		fileUpload.setUpfilePath(dest.getPath());
		fileUpload.setUpfileRegister(userId);
		fileUpload.setUpfileSize(dest.length());
		fileUpload.setUpfileSource(courseParam.getPrevthumbnail());
		int upfileId = fileUploadService.insertInfo(fileUpload);
		
		courseParam.setPrevthumbnail(siteConfiguration.getServerUrl() + siteConfiguration.getServerContext() + "/mgr/common/file_download_id.do.action?upfileId=" + upfileId);
	}
	
	@RequestMapping(value = "/metaCollection_update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session, 
			final Course courseParam, Material planFileParam, 
			ModelMap modelMap, SessionStatus sessionStatus) {
		
		metaCollectionUpdateValidator.validate(courseParam, modelMap);
		
		if(metaCollectionUpdateValidator.hasErrors())
			return null;
		
		final LoginUser login = loginInfoProvider.get().currentUser();
		
		if(courseParam.getSvcStatus().equals(CourseStatus.RESUMMARY.getValue()))
		{
			new Thread(new Runnable() {
				
				public void run() {
					courseService.updateStatus(courseParam.getCourseId(), courseParam.getSvcStatus(), login.getUserId());
					
					Course course = courseService.selectInfo(courseParam.getCourseId());
					
					MetaCollector metaCollector = applicationContext.getBean(MetaCollector.class);
					ResponseHandler responseHandler = (ResponseHandler)applicationContext.getBean("responseHandlerImpl");
					metaCollector.setModifier(login.getUserId());
					metaCollector.setPreCourse(course);
					metaCollector.setResponseHandler(responseHandler);
					
					metaCollector.run();
				}
			}).start();
		}
		else
		{
			if(courseParam.getSyllabusType().equals(SyllabusPathType.FILE.getValue()))
			{
				if(!StringUtils.isEmpty(courseParam.getPlanLocation()))
				{
					mappingSyllabus(session, courseParam, courseParam.getCourseId(), login.getUserId());
				}
			}
			
			if(!StringUtils.isEmpty(courseParam.getPrevthumbnail())
					&& !courseParam.getPrevthumbnail().startsWith("http://"))
			{
				mappingThumbnail(session, courseParam, courseParam.getCourseId(), login.getUserId());
			}
			
			courseParam.setRegister(login.getUserId());
			courseParam.setModifier(login.getUserId());
			
			courseParam.setIsLock("Y");
			courseParam.setIsTemp("N");
			courseService.synchronizeCourse(courseParam);
		}
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_delete", method = RequestMethod.POST)
	public String delete(Course courseParam, ModelMap modelMap, SessionStatus sessionStatus) {
		LoginUser login = loginInfoProvider.get().currentUser();
		
		courseService.updateDeleteInfo(courseParam.getCourseId(), login.getUserId());
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_lecturelist", method = RequestMethod.POST)
	public String lecturelist(Lecture lectureParam, ModelMap modelMap) {
		
		List<Lecture> list = lectureService.selectList(lectureParam.getCourseId());
		
		modelMap.addAttribute(list);
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_lectureread")
	public String lectureread(Lecture lectureParam, ModelMap modelMap)
	{
		lecturemodify(lectureParam, modelMap);
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_lecturemodify")
	public String lecturemodify(Lecture lectureParam, ModelMap modelMap)
	{
		modelMap.addAttribute("course", courseService.selectInfo(lectureParam.getCourseId()));
		
		Lecture lecture = lectureService.getLectureInfo(lectureParam.getCourseId(), lectureParam.getLectureId());
		
		modelMap.addAttribute(lecture);
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_lecturewrite")
	public String lecturewrite(Lecture lectureParam, ModelMap modelMap)
	{
		modelMap.addAttribute("course", courseService.selectInfo(lectureParam.getCourseId()));
		
		return null;
	}
	
	private List<Material> mappingMaterials(String relationType, Integer relationId, HttpServletRequest request)
	{
		List<Material> materials = new ArrayList<Material>();
		
		String[] fileTitle = request.getParameterValues("fileTitle");
		if(fileTitle != null)
		for(int i = 0; i < fileTitle.length; i++)
		{
			if(!fileTitle[i].equals(""))
			{
				Material file = new Material();
				file.setRelationType(relationType);
				file.setRelationId(relationId);
				try {
					file.setAttfileId(Integer.parseInt(request.getParameterValues("fileId")[i]));
				} catch (NumberFormatException numberFormatException) {}
				file.setTitle(fileTitle[i]);
				try {
					file.setLocation(request.getParameterValues("fileLocation")[i]);
				} catch (Exception e) {}
				
				materials.add(file);
			}
		}
		
		return materials;
	}
	
	@RequestMapping(value = "/metaCollection_lectureupdate", method = RequestMethod.POST)
	public String lectureupdate(HttpServletRequest request, 
			Lecture lectureParam,
			ModelMap modelMap, SessionStatus sessionStatus)
	{
		metaCollectionLectureUpdateValidator.validate(lectureParam, modelMap);
		
		if(metaCollectionLectureUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		lectureParam.setRegister(login.getUserId());
		lectureParam.setModifier(login.getUserId());
		
		lectureParam.setLecFileList(mappingMaterials(RelationType.LECTURE.getValue(), lectureParam.getLectureId(), request));
		
		lectureService.reconstruct(lectureParam.getLectureId(), lectureParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_lecturesave", method = RequestMethod.POST)
	public String lecturesave(HttpServletRequest request, 
			Lecture lectureParam, 
			ModelMap modelMap, SessionStatus sessionStatus)
	{
		metaCollectionLectureUpdateValidator.validate(lectureParam, modelMap);
		
		if(metaCollectionLectureUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		lectureParam.setRegister(login.getUserId());
		
		lectureParam.setLecFileList(mappingMaterials(RelationType.LECTURE.getValue(), 0, request));
		
		Integer lectureId = lectureService.construct(lectureParam);
		
		modelMap.put("lectureId", lectureId);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_lecturedelete", method = RequestMethod.POST)
	public String lecturedelete(Lecture lectureParam, ModelMap modelMap, SessionStatus sessionStatus) {
		LoginUser login = loginInfoProvider.get().currentUser();
		
		lectureService.demolish(lectureParam.getCourseId(), lectureParam.getLectureId(), "");
		
		courseService.updateModDate(lectureParam.getCourseId(), login.getUserId());
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/metaCollection_lecturedeletes", method = RequestMethod.POST)
	public String lecturedeletes(Lecture lectureParam, ModelMap modelMap, SessionStatus sessionStatus) {
		LoginUser login = loginInfoProvider.get().currentUser();
		
		if(lectureParam.getLectureIds() != null && lectureParam.getLectureIds().length > 0)
		{
			for(int i = 0; i < lectureParam.getLectureIds().length; i++)
			{
				lectureService.demolish(lectureParam.getCourseId(), Integer.parseInt(lectureParam.getLectureIds()[i]), "");
			}
			
			courseService.updateModDate(lectureParam.getCourseId(), login.getUserId());
		}
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/checkRecommend")
	@ResponseBody
	public List checkRecommend(Integer courseId, Integer type) {
		List list = courseService.checkRecommend(courseId, type);
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/insertRecommend")
	@ResponseBody
	public Integer insertRecommend(Integer courseId, Integer type) {
		return courseService.insertRecommend(courseId, type);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/deleteRecommend")
	@ResponseBody
	public Integer deletekRecommend(Integer courseId, Integer type) {
		return courseService.deleteRecommend(courseId, type);
		
	}
}
