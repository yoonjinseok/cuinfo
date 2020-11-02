package com.cyberup.controller.mgr.system;

import java.util.List;

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
import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.UnivCodeService;

@Controller
@RequestMapping("/mgr/system")
public class UnivCodeSearchController {
	@Autowired
	private UnivCodeService univCodeService;
	@Autowired
	private CodeService codeService;
	
	@RequestMapping("/univCodeSearch")
	public String univCodeSearch(ModelMap model) {
		
		model.addAttribute(codeService.selectList(50, "Y"));
		
		return null;
	}

	@RequestMapping(value = "/univCodeSearch_list", method = RequestMethod.POST)
	public String list(UnivCode univCodeParam, ModelMap modelMap) {
		
		List<UnivCode> list = univCodeService.selectList(univCodeParam.getShowCnt(), univCodeParam.getCurrPage(), "Y", univCodeParam.getUnivName(), univCodeParam.getGubunId(), univCodeParam.getInstallDataProvider());
		modelMap.addAttribute(list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, univCodeParam.getCurrPage(), univCodeParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, univCodeParam.getCurrPage(), univCodeParam.getShowCnt(), new PagingModel());
		
		return null;
	}
}
