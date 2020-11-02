package com.cyberup.controller.mgr.univ;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.IntPropertyEditor;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;

import com.cyberup.model.admin.Admin;
import com.cyberup.model.univ.AcademyinfoLink;

import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.service.common.DeadLinkCheckService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.univ.AcademyinfoLinkService;

@Controller
@RequestMapping("/mgr/univ")
public class UnivStatsMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator univStatsUpdateValidator;
	
	@Autowired
	private CodeService codeService;
	@Autowired
	private AcademyinfoLinkService academyinfoLinkService; 
	@Autowired
	private DeadLinkCheckService deadLinkCheckService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@Resource(name="univStatsUpdateValidator")
	public void setUnivStatsUpdateValidator(MapValidator univStatsUpdateValidator) {
		this.univStatsUpdateValidator = univStatsUpdateValidator;
	}
	
	@RequestMapping("/univStats")
	public String univStats(ModelMap model) {
				
		model.addAttribute(codeService.selectList(84, "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/univStats_deadLinkCheck", method = RequestMethod.POST)
	public String deadLinkCheck(AcademyinfoLink academyinfoLinkParam, ModelMap modelMap, SessionStatus sessionStatus){
		
		Logger.getLogger(this.getClass()).debug("deadLinkCheck() start");
		
		deadLinkCheckService.AcademyDeadLinkCheck(0);
		
		sessionStatus.setComplete();
		
		Logger.getLogger(this.getClass()).debug("deadLinkCheck() end");
		return null;
	}
	
	@RequestMapping(value = "/univStats_list", method = RequestMethod.POST)
	public String list(AcademyinfoLink academyinfoLinkParam, ModelMap modelMap) {
		
		List<AcademyinfoLink> list = academyinfoLinkService.selectList(academyinfoLinkParam.getShowCnt(), academyinfoLinkParam.getCurrPage(), academyinfoLinkParam.getInfoGubunId(), academyinfoLinkParam.getInfoName(), academyinfoLinkParam.getUseYn());
		modelMap.addAttribute("academyinfoLinkList", list );
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, academyinfoLinkParam.getCurrPage(), academyinfoLinkParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, academyinfoLinkParam.getCurrPage(), academyinfoLinkParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/univStats_modify")
	public String modify(AcademyinfoLink academyinfoLinkParam, ModelMap modelMap)
	{
		Logger.getLogger(this.getClass()).debug("modify() start");
		
		modelMap.addAttribute(codeService.selectList(84, "Y"));
		
		AcademyinfoLink academyinfoLink = academyinfoLinkService.selectInfo(academyinfoLinkParam.getInfoId());
		
		modelMap.addAttribute("academyinfoLinkList", academyinfoLink);
		
		Logger.getLogger(this.getClass()).debug("modify() end");
		
		return null;
	}
	
	@RequestMapping(value = "/univStats_update", method = RequestMethod.POST)
	public String update(AcademyinfoLink academyinfoLinkParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		univStatsUpdateValidator.validate(academyinfoLinkParam, modelMap);
		
		if(univStatsUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		academyinfoLinkParam.setModifier(login.getUserId());
		
		academyinfoLinkService.updateInfo(academyinfoLinkParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/univStats_write")
	public String write(ModelMap modelMap) {
		
		modelMap.addAttribute(codeService.selectList(84, "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/univStats_save", method = RequestMethod.POST)
	public String save(AcademyinfoLink academyinfoLinkParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		univStatsUpdateValidator.validate(academyinfoLinkParam, modelMap);
		
		if(univStatsUpdateValidator.hasErrors())
			return null;
			
		LoginUser login = loginInfoProvider.get().currentUser();
		
		academyinfoLinkParam.setRegister(login.getUserId());
		
		academyinfoLinkService.insertInfo(academyinfoLinkParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/univStats_delete", method = RequestMethod.POST)
	public String delete(AcademyinfoLink academyinfoLinkParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		academyinfoLinkService.deleteInfo(academyinfoLinkParam.getInfoId());
		sessionStatus.setComplete();
		
		return null;
	}
}
