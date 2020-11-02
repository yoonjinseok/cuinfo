package com.cyberup.controller.mgr.system;

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
import com.cyberup.model.system.ReptDept;
import com.cyberup.model.system.ReptClassification;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.ReptClassificationService;
import com.cyberup.service.system.ReptDeptService;

@Controller
@RequestMapping("/mgr/system")
public class MajorAreaMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator majorAreaUpdateValidator;
	
	@Autowired
	private ReptClassificationService reptClassificationService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@Resource(name="majorAreaUpdateValidator")
	public void setMajorAreaUpdateValidator(MapValidator majorAreaUpdateValidator) {
		this.majorAreaUpdateValidator = majorAreaUpdateValidator;
	}	
	
	@RequestMapping("/majorArea")
	public String majorArea(ModelMap model) {
		
		
		return null;
	}
	
	@RequestMapping(value = "/majorArea_list", method = RequestMethod.POST)
	public String list(ReptClassification reptClassificationParam, ModelMap modelMap,
						String radioClassify, String classifyIdName) {
		char c;
		if(!classifyIdName.equals(""))
		{
			if(radioClassify.equals("Y"))
			{
				reptClassificationParam.setClassifyId("0");
				reptClassificationParam.setClassifyName(classifyIdName);
			}
			else 
			{
				for(int i = 0 ; i < classifyIdName.length() ; i++){
					c = classifyIdName.charAt(i);
					if(c < 48 || c > 59)
						return null;
				}
				
				reptClassificationParam.setClassifyId(classifyIdName);
				reptClassificationParam.setClassifyName("");	
			}
		}
		
		Logger.getLogger(this.getClass()).debug("classifyIdName : " +classifyIdName );
		
		List<ReptClassification> list = reptClassificationService.selectList(reptClassificationParam.getShowCnt(), reptClassificationParam.getCurrPage(), reptClassificationParam.getClassifyId(), reptClassificationParam.getClassifyName(), 
																			"1", "2", "1", reptClassificationParam.getUseYn());
		modelMap.addAttribute("reptClassificationList", list );
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, reptClassificationParam.getCurrPage(), reptClassificationParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, reptClassificationParam.getCurrPage(), reptClassificationParam.getShowCnt(), new PagingModel());
		
		Logger.getLogger(this.getClass()).debug("modify() end");
		return null;
	}
	
	@RequestMapping(value = "/majorArea_modify")
	public String modify(ReptClassification reptClassificationParam, ModelMap modelMap)
	{
		
		ReptClassification reptClassification = reptClassificationService.selectInfo(reptClassificationParam.getClassifyId());
		
		modelMap.addAttribute("reptClassificationList", reptClassification);
		
		return null;
	}
	
	@RequestMapping(value = "/majorArea_update", method = RequestMethod.POST)
	public String update(ReptClassification reptClassificationParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		majorAreaUpdateValidator.validate(reptClassificationParam, modelMap);
		
		if(majorAreaUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		reptClassificationParam.setModifier(login.getUserId());
		
		reptClassificationService.updateInfo(reptClassificationParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/majorArea_write")
	public String write(ModelMap modelMap) {
		
		return null;
	}
	

	@RequestMapping(value = "/majorArea_save", method = RequestMethod.POST)
	public String save(ReptClassification reptClassificationParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		Logger.getLogger(this.getClass()).debug("save() start");
		majorAreaUpdateValidator.validate(reptClassificationParam, modelMap);
		
		if(majorAreaUpdateValidator.hasErrors())
			return null;
			
		LoginUser login = loginInfoProvider.get().currentUser();
		
		reptClassificationParam.setRegister(login.getUserId());
		
		Logger.getLogger(this.getClass()).debug("save() 1");
		
		reptClassificationService.insertInfo(reptClassificationParam);
		
		Logger.getLogger(this.getClass()).debug("save() end");
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/majorArea_delete", method = RequestMethod.POST)
	public String delete(ReptClassification reptClassificationParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		reptClassificationService.deleteInfo(reptClassificationParam.getClassifyId());
			
		sessionStatus.setComplete();
		
		return null;
		
	}
}
