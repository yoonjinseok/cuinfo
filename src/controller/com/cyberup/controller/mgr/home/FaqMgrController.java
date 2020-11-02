package com.cyberup.controller.mgr.home;

/*
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import com.cyberup.controller.mgr.common.FileUploadController;
import com.cyberup.framework.controller.IntPropertyEditor;
import com.cyberup.model.system.UnivCode;
import com.cyberup.service.admin.AdminService;
import com.cyberup.service.admin.AuthorityService;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.service.course.DataProviderService;
import com.cyberup.framework.conf.SiteConfiguration;
import javax.servlet.http.HttpServletRequest;
*/

/*
 * 	@Autowired
 * 	private SiteConfiguration siteConfiguration;
 * 	private MapValidator dpServerUpdateValidator;
 * 	@Autowired
 * 	private DataProviderService dataProviderService;
 * 	@Inject
 * 	private Provider<SessionUploadConfig> sessionUploadConfig;
 *  list.get(0).setSelectSection(faqService.selectSection());
 *  Logger.getLogger(this.getClass()).debug("select : " + list.get(0).getSelectSection().size() );
 *  Logger.getLogger(this.getClass()).debug("write in");
 * 	sessionUploadConfig.get().setAcceptExts("doc,pptx,ppt");
 *	sessionUploadConfig.get().setMaxSize((long)1024 * 1024 * 200);
 *	sessionUploadConfig.get().setUploadDir(siteConfiguration.getFilePath());
 *	sessionUploadConfig.get().setUploadRootDir(siteConfiguration.getUploadRootPath());
 *	sessionUploadConfig.get().setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(), Locale.getDefault()));
 */

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadConfigMap;
import com.cyberup.model.home.Faq;
import com.cyberup.model.home.FileUpload;
import com.cyberup.service.home.FaqService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.service.system.CodeService;
import com.cyberup.util.FileDeletor;

@Controller
@RequestMapping("/mgr/home")
public class FaqMgrController {

	private MapValidator faqUpdateValidator;
	
	@Autowired
	private FaqService faqService;
	
	@Autowired
	private CodeService codeService;    	
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private SiteConfiguration siteConfiguration;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;	
	@Inject
	protected Provider<SessionUploadConfigMap> sessionUploadConfigMap;
	
	/**
	 *  FAQ 유효성 검사
	 **/
	@Resource(name="faqUpdateValidator")
	public void setDpServerUpdateValidator(MapValidator faqUpdateValidator) {
		//Logger.getLogger(this.getClass()).debug("FAQ 유효성 검사");
		this.faqUpdateValidator = faqUpdateValidator;
	}
	
	/**
	 *  FAQ 검색 Layer 
	 **/	
	@RequestMapping("/faq")
	public String faq(ModelMap model) {
		//Logger.getLogger(this.getClass()).debug("FAQ 검색 Layer");
		model.addAttribute(codeService.selectList(44, "Y"));						//codeList
		return null;
	}

	/**
	 *  FAQ 리스트 호출
	 **/	
	@RequestMapping(value = "/faq_list", method = RequestMethod.POST)
	public String list(Faq faqParam, ModelMap modelMap) {
		//Logger.getLogger(this.getClass()).debug("FAQ 리스트 호출");
		
		List<Faq> list = faqService.selectList(faqParam.getShowCnt(), faqParam.getCurrPage(), faqParam.getSectionId(), faqParam.getFaqContent(), faqParam.getFaqWriter(), faqParam.getSelectRadio1(), faqParam.getSelectRadio2(), faqParam.getSearchCon1(), faqParam.getSearchCon2());
				
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, faqParam.getCurrPage(), faqParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, faqParam.getCurrPage(), faqParam.getShowCnt(), new PagingModel());
		
		modelMap.addAttribute(list);												//faqList
		
		return null;
	}
	
	/**
	 *  FAQ 등록화면 호출
	 **/
	@RequestMapping(value = "/faq_write")
	public String write(Faq faqParam, ModelMap modelMap) { 

		modelMap.addAttribute(codeService.selectList(44, "Y"));						//codeList
		modelMap.addAttribute("loginInfo",loginInfoProvider.get().currentUser());	//loginInfo
		
		return null;
	}
	
	/**
	 *  FAQ 등록화면 저장
	 **/
	@RequestMapping(value = "/faq_save", method = RequestMethod.POST)
	public String save(HttpSession session, Faq faqParam, ModelMap modelMap, SessionStatus sessionStatus) {
		//Logger.getLogger(this.getClass()).debug("FAQ 등록화면 저장");
		faqUpdateValidator.validate(faqParam, modelMap);
		
		if(faqUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		faqParam.setRegister(login.getUserId());
		faqService.insertInfo(faqParam);
		
		sessionStatus.setComplete();
		
		return null;
	}
	
	/**
	 *  FAQ 수정화면 호출
	 **/	
	@RequestMapping(value = "/faq_modify")
	public String modify(Faq faqParam, ModelMap modelMap){
		//Logger.getLogger(this.getClass()).debug("FAQ 수정화면 호출");
		
		Faq faq = faqService.selectInfo(faqParam.getFaqId());
		
		modelMap.addAttribute(faq);													 //faqList
		modelMap.addAttribute(codeService.selectList(44, "Y")); 					 //codeList
		modelMap.addAttribute("loginInfo",loginInfoProvider.get().currentUser());	 //loginInfo
		
		Logger.getLogger(this.getClass()).debug("파일 gid" + faq.getUpfileGid());
							      //fileList
		modelMap.addAttribute("upFileGid",faq.getUpfileGid());						  //upFileGid
		
		//카운트 증가
		//faqService.updateHitsCount(faq);
		
		return null;
	}		
	
	/**
	 *  FAQ 수정화면 저장
	 **/	
	@RequestMapping(value = "/faq_update", method = RequestMethod.POST)
	public String update(HttpSession session, Faq faqParam, ModelMap modelMap, SessionStatus sessionStatus) {
		//Logger.getLogger(this.getClass()).debug("FAQ 수정화면 저장");
		
		faqUpdateValidator.validate(faqParam, modelMap);
		
		if(faqUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		faqParam.setModifier(login.getUserId());
		faqService.updateInfo(faqParam);
	
		sessionStatus.setComplete();
		
		return null;
	}

	/**
	 *  FAQ 삭제
	 **/	
	@RequestMapping(value = "/faq_delete")
	public String delete(Faq faqParam, ModelMap modelMap,Integer fileGid, Integer faqId) {
		
		//글 삭제 
		faqService.deleteInfo(faqId);
		System.out.println("4");
		
		return null;
	}
}
