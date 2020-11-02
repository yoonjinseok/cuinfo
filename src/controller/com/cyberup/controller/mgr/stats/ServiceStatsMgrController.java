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

import com.cyberup.model.stats.ServiceStats;
import com.cyberup.service.stats.ServiceStatsService;


/*************************************************************
 * 
 * 기   능 : 서비스 조회수 통계(CU_LOG_COURSE_CLICKS, CU_LOG_UNIV_CLICKS) 
 * 작성자 : 오성애 
 * 작성일 : 2011-10-18
 * 
 **************************************************************/
@Controller
@RequestMapping("/mgr/stats")
public class ServiceStatsMgrController {
	
	@Autowired
	private ServiceStatsService statsService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	@RequestMapping("/courseHits")
	public String courseHits(ModelMap model) {
		return null;
	}

	/************** 강좌 클릭 리스트 **************/
	@RequestMapping(value = "/courseHits_list", method = RequestMethod.POST)
	public String courselist(ServiceStats serviceParam, ModelMap modelMap,
			@RequestParam(required = true) String sortValue, String sortType) {
		
		//정렬 지정
		String odby = "";		
		if (!sortValue.equals("0")){
			odby = "ORDER BY " + sortValue;
			if (!sortType.equals("0")){
				odby = odby + " " +  sortType;	
			}
		}else{
			odby = "ORDER BY courseName";
		}		
		serviceParam.setSortString(odby);

		serviceParam.setSearchSDT(serviceParam.getSearchSDT().replace("-", ""));
		serviceParam.setSearchEDT(serviceParam.getSearchEDT().replace("-", ""));

		List<ServiceStats> list = statsService.selectCourseList(serviceParam);
		modelMap.addAttribute("hitsList", list);
		
		
		
		if (list.size() > 0){
			modelMap.addAttribute("hitsTotal", list.get(0).getHitsTotalCnt());	
			PagingModel.mappPages(modelMap, serviceParam.getCurrPage(),
					serviceParam.getShowCnt(), list.get(0));
		}else{
			modelMap.addAttribute("hitsTotal", 0);
			PagingModel.mappPages(modelMap, serviceParam.getCurrPage(),
					serviceParam.getShowCnt(), new PagingModel());
		}
		return null;
	}

	@RequestMapping("/univHits")
	public String univHits(ModelMap model) {
		return null;
	}
	
	/************** 학교 클릭 리스트 **************/
	@RequestMapping(value = "/univHits_list", method = RequestMethod.POST)
	public String univList(ServiceStats serviceParam, ModelMap modelMap,
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
		serviceParam.setSortString(odby);
		
		serviceParam.setSearchSDT(serviceParam.getSearchSDT().replace("-", ""));
		serviceParam.setSearchEDT(serviceParam.getSearchEDT().replace("-", ""));

		List<ServiceStats> list = statsService.selectUnivList(serviceParam);
		modelMap.addAttribute("hitsList", list);		
	
		
		if (list.size() > 0){
			modelMap.addAttribute("hitsTotal", list.get(0).getHitsTotalCnt());
			modelMap.addAttribute("totalCnt", list.get(0).getTotalCnt());
		}else{
			modelMap.addAttribute("hitsTotal", 0);
			modelMap.addAttribute("totalCnt", 0);
		}
		return null;
	}
	
	/************** 학교 클릭 리스트 **************/
	@RequestMapping(value = "/univHits_chart")
	public String univChart(ServiceStats serviceParam, ModelMap modelMap) {
		
		serviceParam.setSearchSDT(serviceParam.getSearchSDT().replace("-", ""));
		serviceParam.setSearchEDT(serviceParam.getSearchEDT().replace("-", ""));

		List<ServiceStats> list = statsService.selectUnivList(serviceParam);
		modelMap.addAttribute("hitsList", list);	
	
		
		return null;
	}
	
	
	/************** 학과 클릭 리스트 **************/
	@RequestMapping("/deptHits")
	public String deptHits(ModelMap model) {
		return null;
	}

	@RequestMapping(value = "/deptHits_list", method = RequestMethod.POST)
	public String deptList(ServiceStats serviceParam, ModelMap modelMap,
			@RequestParam(required = true) String sortValue, String sortType) {

		//정렬 지정
		String odby = "";		
		if (!sortValue.equals("0")){
			odby = "ORDER BY " + sortValue;
			if (!sortType.equals("0")){
				odby = odby + " " +  sortType;	
			}
		}else{
			odby = "ORDER BY CLASSIFY_ORDER, DEPT_ORDER";
		}
		serviceParam.setSortString(odby);
		
		serviceParam.setSearchSDT(serviceParam.getSearchSDT().replace("-", ""));
		serviceParam.setSearchEDT(serviceParam.getSearchEDT().replace("-", ""));
		
		List<ServiceStats> list = statsService.selectDeptList(serviceParam);
		modelMap.addAttribute("hitsList", list);
		
		if (list.size() > 0){
			modelMap.addAttribute("hitsTotal", list.get(0).getHitsTotalCnt());
			
			PagingModel.mappPages(modelMap, serviceParam.getCurrPage(),
					serviceParam.getShowCnt(), list.get(0));
		}else{
			modelMap.addAttribute("hitsTotal", 0);
		
			PagingModel.mappPages(modelMap, serviceParam.getCurrPage(),
					serviceParam.getShowCnt(), new PagingModel());
		}
		return null;
	}
	
	/**************  강좌 클릭 수 입력  **************/
	@RequestMapping(value = "/courseHit_save")
	public String course_save(ServiceStats serviceParam, ModelMap modelMap,
			@RequestParam(required = true)String courseID, String regDT, String univID, String deptID)
	{

		//해당 일자에 등록된 키워드가 있는지 확인 후 로그 정보를 insert 또는 update 한다.
		statsService.insCourseHits(courseID, univID, deptID);	
		
		return null;
	}

	/**************  학교, 학과  클릭 수 입력  **************/
	@RequestMapping(value = "/service_save")
	public String service_save(ServiceStats serviceParam, ModelMap modelMap,
			@RequestParam(required = true)String regDT,String univID, String deptID)
	{

		//해당 일자에 등록된 키워드가 있는지 확인 후 로그 정보를 insert 또는 update 한다.
		statsService.insServiceHits(univID, deptID);	
		
		return null;
	}
}
