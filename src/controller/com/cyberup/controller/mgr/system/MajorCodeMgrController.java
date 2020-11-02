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
import com.cyberup.model.univ.AcademyinfoLink;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.ReptClassificationService;
import com.cyberup.service.system.ReptDeptService;

@Controller
@RequestMapping("/mgr/system")
public class MajorCodeMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator majorCodeUpdateValidator;
	
	@Autowired
	private ReptDeptService reptDeptService;
	@Autowired
	private ReptClassificationService reptClassificationService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@Resource(name="majorCodeUpdateValidator")
	public void setMajorCodeUpdateValidator(MapValidator majorCodeUpdateValidator) {
		this.majorCodeUpdateValidator = majorCodeUpdateValidator;
	}	
	
	@RequestMapping("/majorCode")
	public String majorCode(ModelMap model) {
	
		model.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","","3", "1", "1", "Y"));
		return null;
	}
	
	@RequestMapping(value = "/majorCode_list", method = RequestMethod.POST)
	public String list(ReptDept reptDeptParam, ModelMap modelMap) {
		
		List<ReptDept> list = reptDeptService.selectList(reptDeptParam.getShowCnt(), reptDeptParam.getCurrPage(), reptDeptParam.getDeptId(), reptDeptParam.getDeptName(), reptDeptParam.getClassifyId(), 
														"1", "2", "1", reptDeptParam.getUseYn());
		modelMap.addAttribute("reptDeptList", list );
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, reptDeptParam.getCurrPage(), reptDeptParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, reptDeptParam.getCurrPage(), reptDeptParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/majorCode_modify")
	public String modify(ReptDept reptDeptParam, ModelMap modelMap)
	{
		
		modelMap.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","","3", "1", "1", "Y"));
		
		ReptDept reptDept = reptDeptService.selectInfo(reptDeptParam.getDeptId());
		
		modelMap.addAttribute("reptDeptList", reptDept);
		
		return null;
	}
	
	@RequestMapping(value = "/majorCode_update", method = RequestMethod.POST)
	public String update(ReptDept reptDeptParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		majorCodeUpdateValidator.validate(reptDeptParam, modelMap);
		
		if(majorCodeUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		reptDeptParam.setModifier(login.getUserId());
		
		reptDeptService.updateInfo(reptDeptParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/majorCode_write")
	public String write(ModelMap modelMap) {
		
		modelMap.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","","3", "1", "1", "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/majorCode_save", method = RequestMethod.POST)
	public String save(ReptDept reptDeptParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		majorCodeUpdateValidator.validate(reptDeptParam, modelMap);
		
		if(majorCodeUpdateValidator.hasErrors())
			return null;
			
		LoginUser login = loginInfoProvider.get().currentUser();
		
		reptDeptParam.setRegister(login.getUserId());
		
		reptDeptService.insertInfo(reptDeptParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/majorCode_delete", method = RequestMethod.POST)
	public String delete(ReptDept reptDeptParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		reptDeptService.deleteInfo(reptDeptParam.getDeptId());
		
		sessionStatus.setComplete();
		
		return null;
	}
}
