package com.cyberup.controller.mgr.user;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.service.educ.UnivSttService;

@Controller
@RequestMapping("/mgr/user")
public class AdminLoginController {
	private MapValidator adminLoginValidator;
	private MapValidator adminUpdateSecondValidator;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private UnivSttService univSttService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@Resource(name="adminLoginValidator")
	public void setAdminLoginValidator(MapValidator adminLoginValidator) {
		this.adminLoginValidator = adminLoginValidator;
	}
	@Resource(name="adminUpdateSecondValidator")
	public void setAdminUpdateSecondValidator(MapValidator adminUpdateSecondValidator) {
		this.adminUpdateSecondValidator = adminUpdateSecondValidator;
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model) {
		return null;
	}
	
	private Admin reloadAdminInfo(String adminId)
	{
		Admin admin = adminService.selectInfo(adminId);
		
		admin.setAuthGroups(authorityService.selectGroupList("Y", admin.getAuthLevelId()));
		admin.setAuthMenus(authorityService.selectList("Y", admin.getAuthLevelId()));
		
		return admin;
	}
	
	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public String loginAction(Admin adminParam, ModelMap modelMap, SessionStatus sessionStatus, HttpServletRequest request) {
		adminParam.setRemoteAddr(request.getRemoteAddr());
		
		Admin admin = adminLoginValidator.validate(adminParam, modelMap);
		
		if(adminLoginValidator.hasErrors())
			return null;
		
		admin.setAuthGroups(authorityService.selectGroupList("Y", admin.getAuthLevelId()));
		admin.setAuthMenus(authorityService.selectList("Y", admin.getAuthLevelId()));
		
		int sttFileCnt = univSttService.selectSttFileCnt(admin.getUniversityId());
		admin.setSttFileCnt(sttFileCnt + "");
		
		loginInfoProvider.get().save(admin);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(ModelMap model, SessionStatus sessionStatus)
	{
		if(loginInfoProvider.get().isLoggedIn())
			loginInfoProvider.get().remove();
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping("/modify")
	public String modify(ModelMap model)
	{
		model.addAttribute(loginInfoProvider.get().currentUser());
		
		Admin admin = adminService.selectInfo(loginInfoProvider.get().currentUser().getUserId());
		model.addAttribute(admin);
		
		return "/mgr/user/userInfo_modify";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Admin adminParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		adminUpdateSecondValidator.validate(adminParam, modelMap);
		
		if(adminUpdateSecondValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		adminParam.setAdminId(login.getUserId());
		
		if(!adminParam.getAdminPwd().equals(""))
			adminParam.setAdminPwd(EncryptorMd5.encode(EncryptorMd5.encrypt(adminParam.getAdminPwd())));
		
		adminParam.setModifier(login.getUserId());
		
		adminService.updateInfo(adminParam);
		
		loginInfoProvider.get().save(reloadAdminInfo(login.getUserId()));
		
		sessionStatus.setComplete();
		
		return null;
	}
}
