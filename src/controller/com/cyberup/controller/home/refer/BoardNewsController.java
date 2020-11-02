package com.cyberup.controller.home.refer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.home.NewsFeedModel;
import com.cyberup.service.home.NewsFeedService;

@Controller
@RequestMapping("/home/refer")
public class BoardNewsController {
	
	@Autowired
	private NewsFeedService newsFeedService;
	
	@RequestMapping("/boardNews")
	public String newsFeed(ModelMap modelMap) {
		return null;
	}
	@RequestMapping(value = "/boardNews_list", method = RequestMethod.POST)
	public String newsFeedList(NewsFeedModel newsFeedModel, ModelMap modelMap) {
		
		List<NewsFeedModel> list = newsFeedService.selectNewsFeedList(newsFeedModel);
		
		//newsFeedList 리턴
		modelMap.addAttribute("boardNews_list",list);
		
		if(list.size() > 0)
			PagingModel.mappPages(modelMap, newsFeedModel.getCurrPage(), newsFeedModel.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(modelMap, newsFeedModel.getCurrPage(), newsFeedModel.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	
}
