package com.cyberup.controller.mgr.stats;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.cyberup.controller.mgr.common.FileUploadController;
import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MapValidator;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;

import com.cyberup.model.stats.KeywordStats;
import com.cyberup.service.stats.KeywordStatsService;


/*************************************************************
 * 
 * 기   능 : 키워드 통계(CU_LOG_SEARCHS) 
 * 작성자 : 오성애 
 * 작성일 : 2011-10-18
 * 
 **************************************************************/
@Controller
@RequestMapping("/mgr/stats")
public class KeywordStatsMgrController {
	
	@Autowired
	private KeywordStatsService keywordService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@RequestMapping("/keywordStats")
	public String keywordStats(ModelMap model) {
		return null;
	}

	/************** 검색서비스 통계 **************/
	@RequestMapping(value = "/keywordStats_list", method = RequestMethod.POST)
	public String list(KeywordStats keywordParam, ModelMap modelMap,
			@RequestParam(required = true) String sortValue, String sortType) {
		//정렬 지정
		String odby = "";		
		if (!sortValue.equals("0")){
			odby = "ORDER BY " + sortValue;
			if (!sortType.equals("0")){
				odby = odby + " " +  sortType;	
			}
		}else{
			odby = "ORDER BY hitsCnt DESC";
		}		
		keywordParam.setSortString(odby);
		
		keywordParam.setSearchSDT(keywordParam.getSearchSDT().replace("-", ""));
		keywordParam.setSearchEDT(keywordParam.getSearchEDT().replace("-", ""));
		
		List<KeywordStats> list = keywordService.selectList(keywordParam);
		modelMap.addAttribute("keywordList", list);


		if (list.size() > 0){
			modelMap.addAttribute("keywordTotal", list.get(0).getHitsTotalCnt());
			
			PagingModel.mappPages(modelMap, keywordParam.getCurrPage(),
					keywordParam.getShowCnt(), list.get(0));
		}else{
			modelMap.addAttribute("keywordTotal", 0);
		
			PagingModel.mappPages(modelMap, keywordParam.getCurrPage(),
					keywordParam.getShowCnt(), new PagingModel());
		}
		return null;
	}

	/**************  키워드 클릭 수 입력  **************/
	@RequestMapping(value = "/keyword_save")
	public String save(KeywordStats keywordParam, ModelMap modelMap,
			@RequestParam(required = true) String keyword, String regDT)
	{

		System.out.println("keyword ==> "+ keyword);
		System.out.println("regDT ==> " + regDT);
		
		//해당 일자에 등록된 키워드가 있는지 확인 후 로그 정보를 insert 또는 update 한다.
		keywordService.insKeywordHits(keyword,regDT );	
		
		return null;
	}
			
}
