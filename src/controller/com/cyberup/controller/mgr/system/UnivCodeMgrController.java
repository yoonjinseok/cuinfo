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
public class UnivCodeMgrController {
	private MapValidator univCodeUpdateValidator;
	@Autowired
	private UnivCodeService univCodeService;
	@Autowired
	private CodeService codeService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@Resource(name="univCodeUpdateValidator")
	public void setUnivCodeUpdateValidator(MapValidator univCodeUpdateValidator) {
		this.univCodeUpdateValidator = univCodeUpdateValidator;
	}
	

	
	
	@RequestMapping(value = "/univCode")
	public String univCodelist(UnivCode univCodeParam, ModelMap modelMap) {
		modelMap.addAttribute(codeService.selectList(50, "Y"));
		modelMap.addAttribute("codeList2",codeService.selectList(67, "Y"));
		
		return null;
	}
			
	@RequestMapping(value = "/univCode_list", method = RequestMethod.POST)
	public String mgrList(UnivCode univCodeParam, ModelMap modelMap) {
		List<UnivCode> list = univCodeService.mgrSelectList(univCodeParam.getShowCnt(), univCodeParam.getCurrPage(), univCodeParam.getUseYn(), univCodeParam.getUnivName(), univCodeParam.getGubunId(), univCodeParam.getLocalId(), univCodeParam.getSelectRadio1(), univCodeParam.getSearchWord());
		modelMap.addAttribute(list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, univCodeParam.getCurrPage(), univCodeParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, univCodeParam.getCurrPage(), univCodeParam.getShowCnt(), new PagingModel());
		return null;
	}
		
	@RequestMapping(value = "/univCode_modify")
	public String mgrModify(UnivCode univCodeParam, ModelMap modelMap)
	{
		UnivCode univCode = univCodeService.selectInfo(univCodeParam.getUniversityId());
		
		modelMap.addAttribute(univCode);
		modelMap.addAttribute(codeService.selectList(50, "Y"));
		modelMap.addAttribute("codeList2",codeService.selectList(67, "Y"));		
		
		return null;
	}
	
	@RequestMapping(value = "/univCode_update", method = RequestMethod.POST)
	public String mgrUpdate(UnivCode univCodeParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		univCodeUpdateValidator.validate(univCodeParam, modelMap);
		
		if(univCodeUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univCodeParam.setModifier(login.getUserId());
		
		univCodeService.updateInfo(univCodeParam);
		
		sessionStatus.setComplete();
		
		return "mgr/system/univCode_list";
	}
	
	
	

	@RequestMapping(value = "/univCode_write")
	public String write(ModelMap modelMap) {
		
		modelMap.addAttribute(codeService.selectList(50, "Y"));
		modelMap.addAttribute("codeList2",codeService.selectList(67, "Y"));

		return null;
	}
	
	@RequestMapping(value = "/univCode_save", method = RequestMethod.POST)
	public String save(UnivCode univCodeParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		univCodeUpdateValidator.validate(univCodeParam, modelMap);
		
		if(univCodeUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univCodeParam.setRegister(login.getUserId());
		
		univCodeService.insertInfo(univCodeParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/univCode_delete", method = RequestMethod.POST)
	public String delete(UnivCode univCodeParam, ModelMap modelMap, SessionStatus sessionStatus) {
	 	
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univCodeParam.setRegister(login.getUserId());
		
		univCodeService.deleteInfo(univCodeParam.getUniversityId());
		
		sessionStatus.setComplete();
		
		return "mgr/system/univCode_list";
	}
	
	@RequestMapping(value = "/univCodeMgt_modify")
	public String modify(UnivCode univCodeParam, ModelMap modelMap)
	{
		UnivCode univCode = univCodeService.selectInfo(univCodeParam.getUniversityId());
		
		modelMap.addAttribute(univCode);
		modelMap.addAttribute(codeService.selectList(50, "Y"));
		
		return null;
	}
	
	
	@RequestMapping("/univCodeMgt")
	public String univCodeMgt(ModelMap model) {
		
		model.addAttribute(codeService.selectList(50, "Y"));
		
		return null;
	}
	
	@RequestMapping(value = "/univCodeMgt_list", method = RequestMethod.POST)
	public String list(UnivCode univCodeParam, ModelMap modelMap) {
		
		List<UnivCode> list = univCodeService.selectList(univCodeParam.getShowCnt(), univCodeParam.getCurrPage(), univCodeParam.getUseYn(), univCodeParam.getUnivName(), univCodeParam.getGubunId(), "");
		modelMap.addAttribute(list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, univCodeParam.getCurrPage(), univCodeParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, univCodeParam.getCurrPage(), univCodeParam.getShowCnt(), new PagingModel());
		
		return null;
	}


	
	@RequestMapping(value = "/univCodeMgt_update", method = RequestMethod.POST)
	public String update(UnivCode univCodeParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		univCodeUpdateValidator.validate(univCodeParam, modelMap);
		
		if(univCodeUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		univCodeParam.setModifier(login.getUserId());
		
		univCodeService.updateInfo(univCodeParam);
		
		sessionStatus.setComplete();
		
		return null;
	}

		
	
	
}
