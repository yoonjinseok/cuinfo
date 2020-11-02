package com.cyberup.controller.mgr.course;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.controller.mgr.common.FileUploadController;
import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.model.course.DataProvider;
import com.cyberup.service.course.DataProviderService;

@Controller
@RequestMapping("/mgr/course")
public class DpServerMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private FileUploadController fileUploadController;
	
	private MapValidator dpServerUpdateValidator;
	private MapValidator dpServerSaveValidator;
	@Autowired
	private DataProviderService dataProviderService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@Resource(name="dpServerUpdateValidator")
	public void setDpServerUpdateValidator(MapValidator dpServerUpdateValidator) {
		this.dpServerUpdateValidator = dpServerUpdateValidator;
	}
	
	@Resource(name="dpServerSaveValidator")
	public void setDpServerSaveValidator(MapValidator dpServerSaveValidator) {
		this.dpServerSaveValidator = dpServerSaveValidator;
	}


	@RequestMapping("/dpServer")
	public String dpServer(ModelMap model) {
		return null;
	}
	
	@RequestMapping(value = "/dpServer_list", method = RequestMethod.POST)
	public String list(DataProvider dataProviderParam, ModelMap modelMap) {
		
		List<DataProvider> list = dataProviderService.selectList(dataProviderParam.getShowCnt(), dataProviderParam.getCurrPage(), dataProviderParam.getUniversityName(), dataProviderParam.getUseYn());
		modelMap.addAttribute(list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, dataProviderParam.getCurrPage(), dataProviderParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, dataProviderParam.getCurrPage(), dataProviderParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/dpServer_modify")
	public String modify(DataProvider dataProviderParam, ModelMap modelMap)
	{
		DataProvider dataProvider = dataProviderService.selectInfo(dataProviderParam.getUniversityId());
		
		modelMap.addAttribute(dataProvider);
		
		return null;
	}
	
	@RequestMapping(value = "/dpServer_update", method = RequestMethod.POST)
	public String update(DataProvider dataProviderParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		dpServerUpdateValidator.validate(dataProviderParam, modelMap);
		
		if(dpServerUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		dataProviderParam.setDpModifier(login.getUserId());
		
		dataProviderService.updateInfo(dataProviderParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/dpServer_write")
	public String write(ModelMap modelMap) {
	
		sessionUploadConfig.get().setAcceptExts("doc,pptx,ppt");
		sessionUploadConfig.get().setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.get().setUploadDir(siteConfiguration.getFilePath());
		sessionUploadConfig.get().setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.get().setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(), Locale.getDefault()));
		
		return null;
	}
	
	@RequestMapping(value = "dpServer_filedelete")
	public String filedelete(DataProvider dataProviderParam, ModelMap modelMap)
	{
		// getFile Source Info
		// invoke fileUploadController.delete();
		fileUploadController.delete("source file path");
		
		return null;
	}
	
	@RequestMapping(value = "dpServer_filedownload")
	public String filedownload(HttpServletRequest request, HttpServletResponse response, DataProvider dataProviderParam, ModelMap modelMap) throws Exception
	{
		// getFile Source Info
		// invoke fileUploadController.download();
		fileUploadController.download(request, response, "source file path", "original file name");
		
		return null;
	}
	
	
	@RequestMapping(value = "/dpServer_save", method = RequestMethod.POST)
	public String save(DataProvider dataProviderParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		dpServerSaveValidator.validate(dataProviderParam, modelMap);
		
		if(dpServerSaveValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		dataProviderParam.setDpRegister(login.getUserId());
		
		dataProviderService.insertInfo(dataProviderParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
}
