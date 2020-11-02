/*****************************************************************************
 *  작성내용 : '자주하는 질문 답변' - 사용자 페이지  Controller
 *  작성일    : 2011.11.04
 *  작성자    : 최상혁 
 *  수정내용 : 
 *  수정일    :  
 *  수정자    :
 *****************************************************************************/

package com.cyberup.controller.home.refer;




import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.model.home.Faq;
import com.cyberup.model.home.FileUpload;
import com.cyberup.service.home.FaqService;
import com.cyberup.service.home.FileUploadService;
import com.cyberup.service.system.CodeService;

@Controller
@RequestMapping("/home/refer")
public class FaqController {

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
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
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
	public String faq(ModelMap model, String gID, String gnb) {
		//Logger.getLogger(this.getClass()).debug("FAQ 검색 Layer");
		
		model.addAttribute("univFaqList", faqService.univFaqList());
		
		return null;
	}

	/**
	 *  FAQ 리스트 호출
	 **/	
	@RequestMapping(value = "/faq_list", method = RequestMethod.POST)
	public String list(Faq faqParam, ModelMap modelMap) {
		//Logger.getLogger(this.getClass()).debug("FAQ 리스트 호출");
		
		List<Faq> list = faqService.selectList(faqParam.getShowCnt(), faqParam.getCurrPage(), faqParam.getSectionId(), faqParam.getFaqContent(), faqParam.getFaqWriter(), faqParam.getSelectRadio1(), faqParam.getSelectRadio2(), faqParam.getSearchCon1(), faqParam.getSearchCon2());
	
		//textarea의 엔터 값(\n)을 태그의 <br/>로 전환
		for(int i=0; i < list.size();i++ ){
			if(StringUtils.hasLength(list.get(i).getAnswer())){
				list.get(i).setAnswer((list.get(i).getAnswer()).replace("\n","<br/>"));
			}else{
				Logger.getLogger(this.getClass()).debug("["+i +"번째]"+list.get(i).getUpfileGid() + "/" + StringUtils.hasLength(list.get(i).getAnswer()) +"]");
				if(list.get(i).getUpfileGid() != null && list.get(i).getUpfileGid() != 0){
					List<FileUpload> listArr = fileUploadService.selectList(list.get(i).getUpfileGid());
					list.get(i).setSelectSection(listArr);
					if(list.get(i).getSelectSection().size()>0){
						Logger.getLogger(this.getClass()).debug(list.get(i).getSelectSection().get(0));
					}
				}
			}
		}
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, faqParam.getCurrPage(), faqParam.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, faqParam.getCurrPage(), faqParam.getShowCnt(), new PagingModel());
		
		modelMap.addAttribute(list);												//faqList
		
		return null;
	}
	
	/**
	 *  FAQ 리스트 호출
	 **/	
	@RequestMapping(value = "/faq_list_header")
	public String list_header(Faq faqParam, ModelMap modelMap) {
		System.out.println("faqParam.getFaqContent() = " + faqParam.getFaqContent());
		
		try {
			System.out.println("faqParam.getFaqContent() = " + URLDecoder.decode(faqParam.getFaqContent(),"UTF-8"));
			modelMap.addAttribute("searchText",URLDecoder.decode(faqParam.getFaqContent(),"UTF-8"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "/home/refer/faq.vm";
	}

	
	@RequestMapping(value = "/faq_cnt")
	public String updateHitsCount(Faq faqParam, ModelMap modelMap,@RequestParam(required = true) Integer faqId){
		//Logger.getLogger(this.getClass()).debug("FAQ 클릭 카운트");
		
		//카운트 증가
		faqService.updateHitsCount(faqId);
		//list(faqParam, modelMap);

		return "home/refer/faq_list";
	}		
	
	
	
	/**
	 *  FAQ 첨부이미지 호출
	 **/	
	@RequestMapping(value = "/faq_img")
	public String faqImgList(Faq faqParam, ModelMap modelMap,@RequestParam(required = true) Integer fileGid) {
		//Logger.getLogger(this.getClass()).debug("FAQ 이미지 호출");

		List<FileUpload> list = fileUploadService.selectList(fileGid);
		modelMap.addAttribute("faqImgList",list);												//faqImgList
		
		return "home/refer/faq_img";
	}
		
	/**
	 *  FAQ 첨부파일 호출
	 **/	
	@RequestMapping(value = "/faq_file")
	public String faqFileList(Faq faqParam, ModelMap modelMap,@RequestParam(required = true) Integer fileGid) {
		//Logger.getLogger(this.getClass()).debug("FAQ 첨부파일 호출");

		//파일 리스트를 가져온다.
		List<FileUpload> fileList = fileUploadService.selectList(fileGid);
		modelMap.addAttribute("fileList", fileList);							     //fileList
		modelMap.addAttribute("upFileGid",fileGid);						  			 //upFileGid
		
		return null;
	}

	/**
	 *  원격대학 인증,역량진단 결과보고서 작성을 위한 문의 화면 전환
	 **/
	@RequestMapping("/popupNew_write")
	public String popupNew_write(ModelMap model, String gID, String gnb) {
		//Logger.getLogger(this.getClass()).debug("FAQ 검색 Layer");

		//model.addAttribute("univFaqList", faqService.univFaqList());

		return null;
	}
}
