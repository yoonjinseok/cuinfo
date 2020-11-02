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
import com.cyberup.model.system.ReptDept;
import com.cyberup.model.univ.UnivDept;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.service.system.ReptClassificationService;
import com.cyberup.service.system.ReptDeptService;
import com.cyberup.service.system.UnivCodeService;
import com.cyberup.service.univ.UnivDeptService;
import com.ibatis.sqlmap.engine.mapping.sql.dynamic.elements.IsNotNullTagHandler;

@Controller
@RequestMapping("/mgr/univ")
public class MajorMgrController {

	@Autowired
	private SiteConfiguration siteConfiguration;
	
	private MapValidator majorUpdateValidator;
	private MapValidator majorInsertValidator;
	
	@Autowired
	private ReptClassificationService reptClassificationService;
	@Autowired
	private ReptDeptService reptDeptService;
	@Autowired
	private UnivDeptService univDeptService;
	@Autowired
	private UnivCodeService univCodeService;
		
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@Resource(name="majorUpdateValidator")
	public void setMajorUpdateValidator(MapValidator majorUpdateValidator) {
		this.majorUpdateValidator = majorUpdateValidator;
	}	
	@Resource(name="majorInsertValidator")
	public void setMajorInsertValidator(MapValidator majorInsertValidator) {
		this.majorInsertValidator = majorInsertValidator;
	}	
	
	@RequestMapping("/major")
	public String major(ModelMap model, ServletRequest request) {
		
		Logger.getLogger(this.getClass()).debug("request_getParameter : " +request.getParameter("univDeptIdName") );
		
		model.addAttribute("adminInfo", (Admin)loginInfoProvider.get().currentUser());
		model.addAttribute("univDeptIdName", request.getParameter("univDeptIdName"));
		model.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","","3", "1", "1", "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/major_list", method = RequestMethod.POST)
	public String list(UnivDept univDeptParam, ModelMap modelMap, 
					@RequestParam(required=true) 
						String radioUnivDept, String univDeptIdName, 
						String radioUniversity, String universityIdName) {
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		
		Logger.getLogger(this.getClass()).debug("univDeptIdName : " + univDeptIdName);
		Logger.getLogger(this.getClass()).debug("admin.getUniversityId() : " + admin.getUniversityId());

		
		char c;
		if(!univDeptIdName.equals("")){
			if(radioUnivDept.equals("Y")){
				univDeptParam.setDeptName(univDeptIdName);
			} else {
				univDeptParam.setUnivDeptName(univDeptIdName);		
			}
		}
		
		if(!universityIdName.equals(""))
		{
			if(radioUniversity.equals("Y"))
			{
				univDeptParam.setUniversityId(0);
				univDeptParam.setUniversityName(universityIdName);
			}
			else 
			{
				for(int i = 0 ; i < universityIdName.length() ; i++){
					c = universityIdName.charAt(i);
					if(c < 48 || c > 59)
						return null;
				}
				
				univDeptParam.setUniversityId(Integer.parseInt(universityIdName));
				univDeptParam.setUniversityName("");	
			}
		}
		
		if(admin.getAuthLevelId() == 3){
			univDeptParam.setUniversityId(admin.getUniversityId());
			univDeptParam.setUniversityName("");
		}
		
		List<UnivDept> list = univDeptService.selectList(univDeptParam.getShowCnt(), univDeptParam.getCurrPage(), 
													univDeptParam.getUniversityId(), univDeptParam.getUniversityName(), 
													univDeptParam.getUnivDeptId(), univDeptParam.getUnivDeptName(), 
													univDeptParam.getDeptId(), univDeptParam.getDeptName(),
													univDeptParam.getDeptAllName(),
													univDeptParam.getClassifyId(), univDeptParam.getLocalId(),
													"1", "1", "2",
													univDeptParam.getUseYn(),admin.getAuthLevelId());
		
		
		modelMap.addAttribute("univDeptList", list );

		if(list.size() > 0)
			PagingModel.mappPages(modelMap, univDeptParam.getCurrPage(), univDeptParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, univDeptParam.getCurrPage(), univDeptParam.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/major_modify")
	public String modify(UnivDept univDeptParam, ModelMap modelMap)
	{
		
		modelMap.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","", "3", "1", "1", "Y"));
		
		UnivDept univDept = univDeptService.selectInfo(univDeptParam.getUnivDeptId(), univDeptParam.getUniversityId());
		
		modelMap.addAttribute("univDeptList",univDept);
		
		return null;
	}
	
	@RequestMapping(value = "/major_update", method = RequestMethod.POST)
	public String update(UnivDept univDeptParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		majorUpdateValidator.validate(univDeptParam, modelMap);
		
		if(majorUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univDeptParam.setModifier(login.getUserId());
		
		univDeptService.updateInfo(univDeptParam);
		
		//학과명 변경시 해당대학 , 학과코드에 해당하는 강좌의 학과명도 변경
		univDeptService.updateUnivDeptName(univDeptParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/major_write")
	public String write(ModelMap modelMap) {
		
		Admin admin = (Admin)loginInfoProvider.get().currentUser();
		
		modelMap.addAttribute("adminInfo", admin);
		
		if(admin.getAuthLevelId() == 3)	
			modelMap.addAttribute("univCodeInfo", univCodeService.selectInfo(admin.getUniversityId()));
		
		modelMap.addAttribute("reptClassifyList", reptClassificationService.selectList(1000,1,"","","3", "1", "1", "Y"));
		return null;
	}
	
	@RequestMapping(value = "/major_write_select", method = RequestMethod.POST)
	public String list(ReptDept reptDeptParam, ModelMap modelMap) {
		
		Logger.getLogger(this.getClass()).debug("modify() start");
		
		List<ReptDept> list = reptDeptService.selectList(1000, 1, "", "", reptDeptParam.getClassifyId(), "1", "2", "1","Y");
		modelMap.addAttribute("reptDeptList", list );
		
		Logger.getLogger(this.getClass()).debug("modify() end");
		return null;
	}
	
	@RequestMapping(value = "/major_save", method = RequestMethod.POST)
	public String save(UnivDept univDeptParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		majorInsertValidator.validate(univDeptParam, modelMap);
		
		if(majorInsertValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univDeptParam.setRegister(login.getUserId());
		
		univDeptService.insertInfo(univDeptParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/major_delete", method = RequestMethod.POST)
	public String delete(UnivDept univDeptParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		univDeptService.deleteInfo(univDeptParam.getUnivDeptId(), univDeptParam.getUniversityId());
		
		sessionStatus.setComplete();
		
		return null;
	}
}
