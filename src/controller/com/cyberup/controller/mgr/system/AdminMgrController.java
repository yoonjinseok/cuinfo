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
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

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
import org.springframework.web.bind.annotation.RequestParam;
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
import com.cyberup.model.system.Code;
import com.cyberup.model.system.ReptDept;
import com.cyberup.model.univ.UnivDept;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.ibatis.sqlmap.engine.mapping.sql.dynamic.elements.IsNotNullTagHandler;

@Controller
@RequestMapping("/mgr/system")
public class AdminMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator adminUpdateValidator;
	
	private MapValidator adminInsertValidator;
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private CodeService codeService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@Resource(name="adminUpdateValidator")
	public void setAdminUpdateValidator(MapValidator adminUpdateValidator) {
		this.adminUpdateValidator = adminUpdateValidator;
	}	
	
	@Resource(name="adminInsertValidator")
	public void setAdminInsertValidator(MapValidator adminInsertValidator) {
		this.adminInsertValidator = adminInsertValidator;
	}	
	
	@RequestMapping("/admin")
	public String admin(ModelMap model) {
		
		model.addAttribute("codeList", codeService.selectList(1, "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/admin_list", method = RequestMethod.POST)
	public String list(Admin adminParam, ModelMap modelMap,
						String radioAdmin, String adminIdName) {
		
		if(!adminIdName.equals("")){
			
			if(radioAdmin.equals("A")) {
				
				adminParam.setAdminId("");
				adminParam.setAdminName(adminIdName);
				adminParam.setAdminCompany("");
				
			} else if(radioAdmin.equals("B")) {
				
				adminParam.setAdminId(adminIdName);
				adminParam.setAdminName("");
				adminParam.setAdminCompany("");
				
			} else {
				
				adminParam.setAdminId("");
				adminParam.setAdminName("");
				adminParam.setAdminCompany(adminIdName);
				
			}
		}	
		
		List<Admin> list = adminService.selectList(adminParam.getShowCnt(), adminParam.getCurrPage(), 
				adminParam.getAuthLevelId(), adminParam.getAdminId(), adminParam.getAdminName(), adminParam.getAdminCompany());
		modelMap.addAttribute("adminList", list );
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, adminParam.getCurrPage(), adminParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, adminParam.getCurrPage(), adminParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/admin_modify")
	public String modify(Admin adminParam, ModelMap modelMap)
	{
		modelMap.addAttribute("codeList", codeService.selectList(1, "Y"));
		
		Admin admin = adminService.selectInfo(adminParam.getAdminId());
		
		modelMap.addAttribute("adminList", admin);
		modelMap.addAttribute("hideValue", admin.getAdminPwd());
		
		return null;
	}
	
	@RequestMapping(value = "/admin_update", method = RequestMethod.POST)
	public String update(Admin adminParam, ModelMap modelMap, SessionStatus sessionStatus, String hideValue) {
			
		adminUpdateValidator.validate(adminParam, modelMap);
		
		if(adminUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		adminParam.setModifier(login.getUserId());
		if(!adminParam.getAdminPwd().equals(""))
			adminParam.setAdminPwd(EncryptorMd5.encode(EncryptorMd5.encrypt(adminParam.getAdminPwd())));
		adminService.updateInfo(adminParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/admin_write")
	public String write(ModelMap modelMap) {
		
		modelMap.addAttribute("codeList", codeService.selectList(1, "Y"));
		return null;
	}
	
	@RequestMapping(value = "/admin_save", method = RequestMethod.POST)
	public String save(Admin adminParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		adminInsertValidator.validate(adminParam, modelMap);
		
		if(adminInsertValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		adminParam.setRegister(login.getUserId());
		adminParam.setAdminPwd(EncryptorMd5.encode(EncryptorMd5.encrypt(adminParam.getAdminPwd())));
		adminService.insertInfo(adminParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
		
	@RequestMapping(value = "/admin_delete", method = RequestMethod.POST)
	public String delete(Admin adminParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		adminService.deleteInfo(adminParam.getAdminId());
		
		sessionStatus.setComplete();
		
		return null;
	}
}
