package com.cyberup.controller.mgr;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.model.admin.Admin;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;

@Controller
@RequestMapping("/mgr")
public class MainController {
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@RequestMapping("/main")
	public String main(ModelMap model) {
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		
		if(admin.getAuthMenus().size() > 0)
			return "redirect:" + admin.getAuthMenus().get(0).getMenuPath();
		else
			return null;
	}
}
