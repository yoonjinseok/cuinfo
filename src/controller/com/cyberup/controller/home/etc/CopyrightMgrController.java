package com.cyberup.controller.home.etc;


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
import com.cyberup.model.footer.Copyright;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.footer.CopyrightService;
import com.cyberup.service.admin.AuthorityService;
import com.ibatis.sqlmap.engine.mapping.sql.dynamic.elements.IsNotNullTagHandler;

@Controller
@RequestMapping("/home/etc")
public class CopyrightMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private CopyrightService copyrightService;

	private MapValidator copyrightInsertValidator;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@Resource(name="copyrightInsertValidator")
	public void setCopyrightInsertValidator(MapValidator copyrightInsertValidator){
		this.copyrightInsertValidator = copyrightInsertValidator;
	}	
			
	@RequestMapping("/copyright")
	public String copyright(ModelMap model, ServletRequest request) {
		return null;
	}
	
	@RequestMapping(value = "/copyright_save", method = RequestMethod.POST)
	public String save(Copyright copyrightParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		Logger.getLogger(this.getClass()).debug("save() start");
		copyrightParam.setBusinessKind(10);
		copyrightParam.setTypeKind(51);
		copyrightParam.setChannelKind(37);
		copyrightParam.setCustomorKind(27);
		copyrightParam.setRequestKind(27);
		copyrightParam.setIntimeKind(40);
		copyrightParam.setContentKind(67);
		copyrightParam.setStatus(1);
		
		copyrightInsertValidator.validate(copyrightParam, modelMap);
		
		if(copyrightInsertValidator.hasErrors())
			return null;
		
		copyrightService.insertInfo(copyrightParam);
		
		Logger.getLogger(this.getClass()).debug("save() end");
		
		sessionStatus.setComplete();
		
		return null;
	}
}
