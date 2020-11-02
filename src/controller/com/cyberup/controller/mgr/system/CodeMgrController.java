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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.encrypt.EncryptorMd5;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.system.Code;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.UnivCodeService;

@Controller
@RequestMapping("/mgr/system")
public class CodeMgrController {
	private MapValidator codeUpdateValidator;
	private MapValidator codeDeleteValidator;
	@Autowired
	private CodeService codeService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@Resource(name="codeUpdateValidator")
	public void setCodeUpdateValidator(MapValidator codeUpdateValidator) {
		this.codeUpdateValidator = codeUpdateValidator;
	}
	@Resource(name="codeDeleteValidator")
	public void setCodeDeleteValidator(MapValidator codeDeleteValidator) {
		this.codeDeleteValidator = codeDeleteValidator;
	}
	
	@RequestMapping("/code")
	public String univCodeMgt(ModelMap model) {
		return null;
	}

	@RequestMapping(value = "/code_list", method = RequestMethod.POST)
	public String list(Code codeParam, ModelMap modelMap,
			@RequestParam(required=true) 
			String radioCodeGroup, String codeGroupIdName, 
			String radioCode, String codeIdName) {
		
		char c;
		if(!codeGroupIdName.equals("")){
			if(radioCodeGroup.equals("Y"))
			{
				codeParam.setCodeGroup("");
				codeParam.setCodeGroupName(codeGroupIdName);
			}
			else 
			{
				for(int i = 0 ; i < codeGroupIdName.length() ; i++){
					c = codeGroupIdName.charAt(i);
					if(c < 48 || c > 59)
						return null;
				}
				
			
				codeParam.setCodeGroup(codeGroupIdName);
				codeParam.setCodeGroupName("");	

			}
		}
		if(!codeIdName.equals(""))
		{
			if(radioCode.equals("Y"))
			{
				codeParam.setCodeId(0);
				codeParam.setCodeName(codeIdName);
			}
			else 
			{
				for(int i = 0 ; i < codeIdName.length() ; i++){
					c = codeIdName.charAt(i);
					if(c < 48 || c > 59)
						return null;
				}
				
				codeParam.setCodeId(Integer.parseInt(codeIdName));
				codeParam.setCodeName("");	
			}
		}
		
		List<Code> list = codeService.selectViewList(codeParam.getShowCnt(), codeParam.getCurrPage(), 
				codeParam.getCodeId(), codeParam.getCodeName(), codeParam.getCodeGroup(), codeParam.getCodeGroupName(), codeParam.getUseYn());
		modelMap.addAttribute("codeList", list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, codeParam.getCurrPage(), codeParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, codeParam.getCurrPage(), codeParam.getShowCnt(), new PagingModel());
	
		return null;
	}
	
	@RequestMapping(value = "/code_modify")
	public String modify(Code codeParam, ModelMap modelMap)
	{
		Code code = codeService.selectInfo(codeParam.getCodeId());
		
		modelMap.addAttribute("codeList", code);
		
		return null;
	}
	
	@RequestMapping(value = "/code_update", method = RequestMethod.POST)
	public String update(Code codeParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		codeUpdateValidator.validate(codeParam, modelMap);
		
		if(codeUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		codeParam.setCodeModifier(login.getUserId());
		
		codeService.updateInfo(codeParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	@RequestMapping(value = "/code_write")
	public String write(Code codeParam, ModelMap modelMap) {
		
		List<Code> list = codeService.selectGroupList("Y");
		modelMap.addAttribute("codeGroupList", list);
		
		return null;
	}
	
	@RequestMapping(value = "/code_save", method = RequestMethod.POST)
	public String save(Code codeParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		codeUpdateValidator.validate(codeParam, modelMap);
		
		if(codeUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		
		codeParam.setCodeRegister(login.getUserId());
		
		codeService.insertInfo(codeParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	

	
	@RequestMapping(value = "/code_delete", method = RequestMethod.POST)
	public String delete(Code codeParam, ModelMap modelMap, SessionStatus sessionStatus) {
		
		codeDeleteValidator.validate(codeParam, modelMap);
		
		if(codeDeleteValidator.hasErrors())
			return null;
		
		codeService.deleteInfo(codeParam.getCodeId());
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	/**row 데이터 추출 기능
	 * 20140918 김재현
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping("/selectTableData")
	public Integer selectTableData(ModelMap model, String query) {
		System.out.println("selectTable");
		System.out.println(query);
		List list = codeService.selectTableData(query);
		return null;
	}
	
	@RequestMapping("/insertTableData")
	public Integer insertTableData(ModelMap model, String insertquery) {
		System.out.println("insertTable");
		System.out.println(insertquery);	
		codeService.insertTableData(insertquery);
		return null;
	}
	
	@RequestMapping("/updateTableData")
	public Integer updateTableData(ModelMap model, String updatequery) {
		System.out.println("updateTable");
		System.out.println(updatequery);	
		codeService.insertTableData(updatequery);
		return null;
	}
	
	@RequestMapping("/deleteTableData")
	public Integer deleteTableData(ModelMap model, String deletequery) {
		System.out.println("deleteTable");
		System.out.println(deletequery);	
		codeService.insertTableData(deletequery);
		return null;
	}
	
	@RequestMapping("/downloadTableData")
	public Integer createTableData(ModelMap model, String query) {
		String filePath= codeService.createTableData(query);
		model.addAttribute("filePath", filePath);
		return null;
	}
}
