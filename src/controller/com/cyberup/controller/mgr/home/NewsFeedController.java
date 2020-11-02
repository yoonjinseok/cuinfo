package com.cyberup.controller.mgr.home;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.home.NewsFeedModel;
import com.cyberup.service.home.NewsFeedService;


/*************************************************************
 * 
 * 기   능 : 게시판(CU_BOARD)관련 기능 구현 (사이버대학뉴스) 
 * 작성자 : 이종호 
 * 작성일 : 2011-10-18
 * 
 **************************************************************/

@Controller
@RequestMapping("/mgr/home")
public class NewsFeedController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		/* register appropriate date editor */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	} 
	
	@Autowired
	private NewsFeedService newsFeedService;

	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@RequestMapping("/newsFeed")
	public String newsFeed(ModelMap modelMap) {
		return null;
	}
	@RequestMapping(value = "/newsFeed_list", method = RequestMethod.POST)
	public String newsFeedList(NewsFeedModel newsFeedModel, ModelMap modelMap) {
		
		List<NewsFeedModel> list = newsFeedService.selectNewsFeedList(newsFeedModel);
		
		//univInfoList 리턴
		modelMap.addAttribute("newsFeedList",list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, newsFeedModel.getCurrPage(), newsFeedModel.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, newsFeedModel.getCurrPage(), newsFeedModel.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	@RequestMapping(value = "/newsFeed_list2", method = RequestMethod.POST)
	public String newsFeedList2(NewsFeedModel newsFeedModel, ModelMap modelMap) {
		
		List<NewsFeedModel> list = newsFeedService.selectNewsFeedList2(newsFeedModel);
		
		//univInfoList 리턴
		modelMap.addAttribute("newsFeedList",list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, newsFeedModel.getCurrPage(), newsFeedModel.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, newsFeedModel.getCurrPage(), newsFeedModel.getShowCnt(), new PagingModel());
		
		return "/mgr/home/newsFeed_list.vm";
	}
	
	
	//newsFeed_delete
	@RequestMapping(value = "/newsFeed_delete", method = RequestMethod.POST)
	public String newsFeed_delete(NewsFeedModel newsFeedModel, ModelMap modelMap){
		//param 객체에 로그인되어있는 사람의 id 를 셋팅.
		LoginUser login = loginInfoProvider.get().currentUser();
		
		newsFeedModel.setModifier(login.getUserId());

		newsFeedService.newsFeed_delete(newsFeedModel);
		
		return null;
	}
	
	//뉴스등록화면
	@RequestMapping(value = "/newsFeed_write")
	public String newsFeed_write(ModelMap modelMap){
		return null;
	}
	
	@RequestMapping(value = "/newsFeed_insert", method = RequestMethod.POST)
	public String newsFeed_insert(NewsFeedModel newsFeedModel, ModelMap modelMap){
		
		//System.out.println("\n\nnewsFeed_insert start");
		LoginUser login = loginInfoProvider.get().currentUser();
		//수동등록의 경우 제목,링크,게시물등록일 만 있다.
		newsFeedService.newsFeed_insert(newsFeedModel);
		
		return null;
	}
}
