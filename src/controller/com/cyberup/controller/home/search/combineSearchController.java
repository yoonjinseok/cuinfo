package com.cyberup.controller.home.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberup.model.home.CombineSearch;
import com.cyberup.model.stats.KeywordStats;
import com.cyberup.service.search.CombineSearchService;
import com.cyberup.service.stats.KeywordStatsService;

@Controller
@RequestMapping("/home/search")
public class combineSearchController {
	
	@Autowired
	private KeywordStatsService keywordService;
	@Autowired
	private CombineSearchService combineSearchService;
	
	@RequestMapping("/combineSearch")
	public String combineSearch(CombineSearch combineSearch,ModelMap model){
		
		String[] headerTextArr = combineSearch.getHeaderText().split(" ");
		
		//검색어 테이블 등록
		Integer gubn = combineSearch.getSearchGubn();
		String headerText = combineSearch.getHeaderText();
		
		System.out.println("gubn1 => " + gubn);
		
		List<CombineSearch> list1 = combineSearchService.selectCourses(combineSearch);
		List<CombineSearch> list2 = combineSearchService.selectBoards(combineSearch);
		List<CombineSearch> list3 = combineSearchService.selectKeywords();
		List<CombineSearch> list4 = combineSearchService.selectBestCourses();
		List<CombineSearch> list5 = combineSearchService.selectWeb(combineSearch);
		
		Integer tCnt = 0;
		if(list1 != null){
			if(list1.size() > 0){
				tCnt += list1.get(0).getTotalCnt2();
				model.addAttribute("tCnt1",list1.get(0).getTotalCnt2());
			}
		}
		if(list2 != null){
			if(list2.size() > 0){
				tCnt += list2.get(0).getTotalCnt2();
				model.addAttribute("tCnt2",list2.get(0).getTotalCnt2());
			}
		}
		if(list3 != null){
			if(list3.size() > 0){
				tCnt += list3.get(0).getTotalCnt2();
				model.addAttribute("tCnt3",list3.get(0).getTotalCnt2());
			}
		}
			
		
		
		System.out.println("tCnt => " + tCnt);
		System.out.println("gubn2 => " + gubn);
				
		model.addAttribute("coursesList",list1);
		model.addAttribute("boardsList",list2);
		model.addAttribute("keywordsList",list3);
		model.addAttribute("bestCourseList",list4);
		model.addAttribute("webList",list5);
		model.addAttribute("gubn",gubn);
		model.addAttribute("tCnt",tCnt);
		model.addAttribute("headerText",headerText);
		
		
		//gubn 의 값에 따라 페이징 처리 가능토록한다.
		if(list1.size() > 0 && gubn == 1)
			CombineSearch.mappPages2(model, combineSearch.getCurrPage2(), combineSearch.getShowCnt2(), list1.get(0));
		else if(list2.size() > 0 && gubn == 2)
			CombineSearch.mappPages2(model, combineSearch.getCurrPage2(), combineSearch.getShowCnt2(), list2.get(0));
		else if(list5.size() > 0 && gubn == 3)
			CombineSearch.mappPages2(model, combineSearch.getCurrPage2(), combineSearch.getShowCnt2(), list5.get(0));
//		else
//			CombineSearch.mappPages2(model, combineSearch.getCurrPage2(), combineSearch.getShowCnt2(), new CombineSearch());
		
		return null;
	}
	
	@RequestMapping(value = "/keyword_save")
	public String save(KeywordStats keywordParam, ModelMap modelMap,
			@RequestParam(required = true) String keyword, String regDT)
	{
		//해당 일자에 등록된 키워드가 있는지 확인 후 로그 정보를 insert 또는 update 한다.
		keywordService.insKeywordHits(keyword,regDT );	
		return null;
	}
	
}
