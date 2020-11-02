package com.cyberup.controller.mgr.home;


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
import com.cyberup.model.home.FileUpload;
import com.cyberup.model.home.Poup;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.service.home.PoupService;
import com.cyberup.service.home.PoupSkinService;
import com.cyberup.service.system.CodeService;
import com.cyberup.util.FileDeletor;

@Controller
@RequestMapping("/mgr/home")
public class PoupMgrController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private PoupService poupService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private PoupSkinService poupSkinService;
	
	private MapValidator poupUpdateValidator;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;	

	@Inject
	private Provider<SessionUploadConfigMap> sessionUploadConfigMap;
	
	@Resource(name="poupUpdateValidator")
	public void setDpServerUpdateValidator(MapValidator poupUpdateValidator) {
		this.poupUpdateValidator = poupUpdateValidator;
	}
	
	
	/**
	 *  팝업 검색 Layer 
	 **/	
	@RequestMapping("/poup")
	public String poup(ModelMap model) {
		Logger.getLogger(this.getClass()).debug("팝업 검색 Layer");
		
		return null;
	}

	/**
	 *  팝업 리스트 호출
	 **/	
	@RequestMapping(value = "/poup_list", method = RequestMethod.POST)
	public String list(Poup poupParam, ModelMap modelMap) {
		Logger.getLogger(this.getClass()).debug("팝업 리스트 호출");
		
		List<Poup> list = poupService.selectpouplist(poupParam.getShowCnt(), poupParam.getCurrPage(), poupParam.getSearchword(), poupParam.getSelectyn(), poupParam.getSelectRadio1());
				
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, poupParam.getCurrPage(), poupParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, poupParam.getCurrPage(), poupParam.getShowCnt(), new PagingModel());
		
		modelMap.addAttribute(list);
		
		return null;
	}
	
	private void putAttfileConfig()
	{
		SessionUploadConfig sessionUploadConfig = new SessionUploadConfig();
		sessionUploadConfig.setAcceptExts("hwp,doc,docx,xls,xlsx,ppt,pptx,jpg,jpeg,gif,png,pdf");
		sessionUploadConfig.setMaxSize((long)1024 * 1024 * 200);
		sessionUploadConfig.setUploadDir(siteConfiguration.getFilePath() + "Poup" + File.separator);
		sessionUploadConfig.setUploadRootDir(siteConfiguration.getUploadRootPath());
		sessionUploadConfig.setUploadSubectory(new DateFormatter("yyyy/MM").print(new Date(),
				Locale.getDefault()));
		
		sessionUploadConfigMap.get().putConfig("att", sessionUploadConfig);	
	}
	
	/**
	 *  팝업 등록화면 호출
	 **/
	@RequestMapping(value = "/poup_write")
	public String write(Poup poupParam, ModelMap modelMap) { 
		Logger.getLogger(this.getClass()).debug("팝업 등록화면 호출");
		
		putAttfileConfig();
			
		modelMap.addAttribute("loginInfo",loginInfoProvider.get().currentUser());	//loginInfo
		
		modelMap.addAttribute("codeList", codeService.selectList(159, "Y"));
		
		return null;
	}
	
	/**
	 *  팝업 등록화면 저장
	 **/
	@RequestMapping(value = "/poup_save", method = RequestMethod.POST)
	public String save(HttpSession session, Poup poupParam, ModelMap modelMap, SessionStatus sessionStatus) {
		Logger.getLogger(this.getClass()).debug("팝업 등록화면 저장");
		
		poupUpdateValidator.validate(poupParam, modelMap);
		
		if(poupUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		poupParam.setRegister(login.getUserId());
		
		if(poupParam.getUpfileSrc() != null && poupParam.getUpfileSrc().length > 0)
		{
			poupParam.setAttachUpfileGid(fileUploadService.selectGroupKey());
			
			for(int i = 0; i < poupParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(poupParam.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(poupParam.getUpfileSrc()[i] + "OriginalFilename");
				
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(poupParam.getAttachUpfileGid());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(login.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(poupParam.getUpfileSrc()[i]);
				fileUploadService.insertInfo(fileUpload);
			}
		}
		
		poupService.insertpoup(poupParam);
		
		sessionStatus.setComplete();
		
		return null;
	}

	/**
	 *  팝업 수정화면 호출
	 **/	
	@RequestMapping(value = "/poup_modify")
	public String modify(Poup poupParam, ModelMap modelMap){
		Logger.getLogger(this.getClass()).debug("팝업 수정화면 호출");
		
		Poup poup = poupService.infopoup(poupParam.getPoupNum());
		
		modelMap.addAttribute(poup);		
		modelMap.addAttribute("loginInfo",loginInfoProvider.get().currentUser());	 //loginInfo

		if(poup.getAttachUpfileGid() > 0)
		{
			modelMap.addAttribute("fileList", fileUploadService.selectList(poup.getAttachUpfileGid()));
		}

		putAttfileConfig();
		
		modelMap.addAttribute("codeList", codeService.selectList(159, "Y"));
		
		return null;
	}		
	
	/**
	 *  팝업 수정화면 저장
	 **/	
	@RequestMapping(value = "/poup_update", method = RequestMethod.POST)
	public String update(HttpSession session, Poup poupParam, ModelMap modelMap, SessionStatus sessionStatus) {
		Logger.getLogger(this.getClass()).debug("팝업수정화면저장");
		
		poupUpdateValidator.validate(poupParam, modelMap);
		
		if(poupUpdateValidator.hasErrors())
			return null;
		
		LoginUser login = loginInfoProvider.get().currentUser();
		poupParam.setModifier(login.getUserId());
		
		if(poupParam.getUpfileSrc() != null && poupParam.getUpfileSrc().length > 0)
		{
			if(poupParam.getAttachUpfileGid() == 0)
				poupParam.setAttachUpfileGid(fileUploadService.selectGroupKey());
			
			for(int i = 0; i < poupParam.getUpfileSrc().length; i++)
			{
				String path = (String)session.getAttribute(poupParam.getUpfileSrc()[i]);
				String original = (String)session.getAttribute(poupParam.getUpfileSrc()[i] + "OriginalFilename");
				
				FileUpload fileUpload = new FileUpload();
				fileUpload.setUpfileGid(poupParam.getAttachUpfileGid());
				fileUpload.setUpfileFilename(original);
				fileUpload.setUpfilePath(path);
				fileUpload.setUpfileRegister(login.getUserId());
				fileUpload.setUpfileSize(new File(path).length());
				fileUpload.setUpfileSource(poupParam.getUpfileSrc()[i]);
				fileUploadService.insertInfo(fileUpload);
			}
		}
		
		Logger.getLogger(this.getClass()).debug("팝업수정화면저장끝");
		
		poupService.updatepoup(poupParam);
	
		sessionStatus.setComplete();
		
		return null;
	}

	/**
	 *  팝업 삭제
	 **/	
	@RequestMapping(value = "/poup_delete")
	public String delete(Poup poupParam, ModelMap modelMap) {
		Logger.getLogger(this.getClass()).debug("팝업 삭제");
		
		if(poupParam.getAttachUpfileGid() > 0)
		{
			List<FileUpload> files = fileUploadService.selectList(poupParam.getAttachUpfileGid());
			for(int i = 0; i < files.size(); i++)
			{
				new FileDeletor(new File(files.get(i).getUpfilePath())).start();
			}
			
			fileUploadService.deleteList(poupParam.getAttachUpfileGid());
		}
		
		//글 삭제 
		poupService.deletepoup(poupParam.getPoupNum());
		
		return null;
	}
}
