package com.cyberup.controller.mgr.stats;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.LoginUser;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.course.CourseStatus;
import com.cyberup.model.course.CourseType;
import com.cyberup.model.stats.CourseStats;
import com.cyberup.model.stats.Stats;
import com.cyberup.service.stats.CourseStatsService;
import com.cyberup.service.stats.StatsService;


/*************************************************************
 * 
 * 기   능 : 강좌 등록  통계(CU_LOG_SEARCHS) 
 * 작성자 : 오성애 
 * 작성일 : 2011-10-19
 * 
 **************************************************************/
@Controller
@RequestMapping("/mgr/stats")
public class CourseStatsMgrController {
	
	@Autowired
	private StatsService statsService;
	
	@Autowired
	private CourseStatsService courseService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	
	/************** 기간별 강좌 등록통계 **************/
	//기간별통계화면
	@RequestMapping("/courseByPeriod")
	public String courseByPeriod(ModelMap model) {
		model.addAttribute("login", loginInfoProvider.get().currentUser());
		
		model.addAttribute("statusCodeList", CourseStatus.values());//http://localhost:8088/mgr/stats/courseByPeriod.sub.action?gnb=31
		model.addAttribute("typeCodeList", CourseType.values());//http://localhost:8088/mgr/stats/courseByPeriod.sub.action?gnb=31

		model.addAttribute("today",statsService.getToday());		//현재의 날짜를 리턴
		model.addAttribute("passday",statsService.getPassday()); 	//6개월전의 날짜를 리턴
		
		return null;
	}
	//리스트,차트 결과값
	@RequestMapping("/courseByPeriod_list")
	public String courseByPeriod_list(ModelMap model,Stats stats) {
		
		List<Stats> list = statsService.selectCourseByPeriod(stats);
		model.addAttribute("statsList",list);
		
		if(list.size() > 0)
			PagingModel.mappPages(model, stats.getCurrPage(), stats.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, stats.getCurrPage(), stats.getShowCnt(), new PagingModel());
		
		return null;
	}

	//학교별통계화면
	@RequestMapping("/courseByUniv")
	public String courseByUniv(ModelMap model) {
		courseByPeriod(model);
		
		return null;
	}
	
	//리스트,차트 결과값
	@RequestMapping("/courseByUniv_list")
	public String courseByUniv_list(ModelMap model,Stats stats) {
		/*
		 * 대학별로 리스트를 만들기 위하여 조회내용을 컬럼별로 리스트를 분리하여 화면에서 사용하도록 한다.
		 * */
		List<Stats> list = statsService.selectCourseByUniv_list(stats);
		model.addAttribute("statsList",list);
		
		/*
		 * 차트를 표현하기위하여 항목별로 리스트를 만들어 VIEW에 담는다.
		 * */
		List univList = new ArrayList();
		List totalList = new ArrayList();
		List serviceList = new ArrayList();
		List vodList = new ArrayList();
		List fileList = new ArrayList();
		
		for (int i = 0; i < list.size(); i++) {
			univList.add(list.get(i).getUnivName());
			totalList.add(list.get(i).getTotalCnt());
			serviceList.add(list.get(i).getServiceCnt());
			vodList.add(list.get(i).getVodCnt());
			fileList.add(list.get(i).getFileCnt());
		}
		
		model.addAttribute("univList",univList);
		model.addAttribute("totalList",totalList);
		model.addAttribute("serviceList",serviceList);
		model.addAttribute("vodList",vodList);
		model.addAttribute("fileList",fileList);
		
		
		if(list.size() > 0)
			PagingModel.mappPages(model, stats.getCurrPage(), stats.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, stats.getCurrPage(), stats.getShowCnt(), new PagingModel());
		
		return null;
	}
	
	
	/*
	 
	 
	@RequestMapping(value = "/courseByPeriod_list", method = RequestMethod.POST)
	public String courseByPeriod_list(CourseStats courseParam, ModelMap modelMap,
			@RequestParam(required = true) String sortValue, String sortType) {
		//정렬 지정
		String odby = "";		
		if (!sortValue.equals("0")){
			odby = "ORDER BY " + sortValue;
			if (!sortType.equals("0")){
				odby = odby + " " +  sortType;	
			}
		}else{
			odby = "ORDER BY regDT";
		}		
		courseParam.setSortString(odby);
		
		courseParam.setSearchSDT(courseParam.getSearchSDT().replace("-", ""));
		courseParam.setSearchEDT(courseParam.getSearchEDT().replace("-", ""));
		
		List<CourseStats> list = courseService.selectPeriodList(courseParam);
		modelMap.addAttribute("courseList", list);
				

		if(list.size()>0){
			modelMap.addAttribute("regTotalCnt", list.get(0).getRegTotalCnt());
			modelMap.addAttribute("serviceTotalCnt", list.get(0).getServiceTotalCnt());
			modelMap.addAttribute("noServiceTotalCnt", list.get(0).getNoServiceTotalCnt());
		
			PagingModel.mappPages(modelMap, courseParam.getCurrPage(),
					courseParam.getShowCnt(), list.get(0));
		}else{
			modelMap.addAttribute("regTotalCnt", 0);
			modelMap.addAttribute("serviceTotalCnt", 0);
			modelMap.addAttribute("noServiceTotalCnt", 0);
			
			PagingModel.mappPages(modelMap, courseParam.getCurrPage(),
					courseParam.getShowCnt(), new PagingModel());
		}
		return null;
	}
	 * */

	
	/************** 학교별 강좌 등록통계 **************/
	
	/*
	@RequestMapping("/courseByUniv")
	public String courseByUniv(ModelMap model) {
		return null;
	}
	@RequestMapping(value = "/courseByUniv_list", method = RequestMethod.POST)
	public String selectUnivList(CourseStats courseParam, ModelMap modelMap,
			@RequestParam(required = true) String sortValue, String sortType) {
		
		//정렬 지정
		String odby = "";		
		if (!sortValue.equals("0")){
			odby = "ORDER BY " + sortValue;
			if (!sortType.equals("0")){
				odby = odby + " " +  sortType;	
			}
		}else{
			odby = "ORDER BY regCnt DESC";
		}		
		courseParam.setSortString(odby);
		
		courseParam.setSearchSDT(courseParam.getSearchSDT().replace("-", ""));
		courseParam.setSearchEDT(courseParam.getSearchEDT().replace("-", ""));
		
		
		
		List<CourseStats> list = courseService.selectUnivList(courseParam);
		modelMap.addAttribute("courseList", list);
		
		if(list.size()>0){
			modelMap.addAttribute("totalCnt", list.get(0).getTotalCnt());
			modelMap.addAttribute("regTotalCnt", list.get(0).getRegTotalCnt());
			modelMap.addAttribute("serviceTotalCnt", list.get(0).getServiceTotalCnt());
			modelMap.addAttribute("noServiceTotalCnt", list.get(0).getNoServiceTotalCnt());
		}else{
			modelMap.addAttribute("totalCnt", 0);
			modelMap.addAttribute("regTotalCnt", 0);
			modelMap.addAttribute("serviceTotalCnt", 0);
			modelMap.addAttribute("noServiceTotalCnt", 0);
		}
		return null;
	}
	
	//챠트용

	@RequestMapping(value = "/courseByUniv_chart")
	public String selectUnivChart(CourseStats courseParam, ModelMap modelMap) {
		
		
		courseParam.setSearchSDT(courseParam.getSearchSDT().replace("-", ""));
		courseParam.setSearchEDT(courseParam.getSearchEDT().replace("-", ""));
	
		
		List<CourseStats> list = courseService.selectUnivList(courseParam);
		modelMap.addAttribute("courseList", list);
		
		System.out.println("**************"+ list.size());
		
		return null;
	}
	 * */
	
	/************** 학과분야별 강좌 등록통계 **************/
	@RequestMapping("/courseByClass")
	public String courseByClass(ModelMap model) {
		return null;
	}
	@RequestMapping(value = "/courseByClass_list", method = RequestMethod.POST)
	public String selectClassList(CourseStats courseParam, ModelMap modelMap,
			@RequestParam(required = true) String sortValue, String sortType) {
		
		//정렬 지정
		String odby = "";		
		if (!sortValue.equals("0")){
			odby = "ORDER BY " + sortValue;
			if (!sortType.equals("0")){
				odby = odby + " " +  sortType;	
			}
		}else{
			odby = "ORDER BY rank ";
		}		
		courseParam.setSortString(odby);

		courseParam.setSearchSDT(courseParam.getSearchSDT().replace("-", ""));
		courseParam.setSearchEDT(courseParam.getSearchEDT().replace("-", ""));
		
		List<CourseStats> list = courseService.selectClassDeptList(courseParam);
		modelMap.addAttribute("courseList", list);
		
		if(list.size()>0){
			modelMap.addAttribute("totalCnt", list.get(0).getTotalCnt());
			modelMap.addAttribute("regTotalCnt", list.get(0).getRegTotalCnt());
			modelMap.addAttribute("serviceTotalCnt", list.get(0).getServiceTotalCnt());
			modelMap.addAttribute("noServiceTotalCnt", list.get(0).getNoServiceTotalCnt());
		}else{
			modelMap.addAttribute("totalCnt", 0);
			modelMap.addAttribute("regTotalCnt", 0);
			modelMap.addAttribute("serviceTotalCnt", 0);
			modelMap.addAttribute("noServiceTotalCnt", 0);
		}
		return null;
	}
	
	//chart용
	@RequestMapping(value = "/courseByClass_chart")
	public String selectClassDeptChart(CourseStats courseParam, ModelMap modelMap)  {

		
		courseParam.setSearchSDT(courseParam.getSearchSDT().replace("-", ""));
		courseParam.setSearchEDT(courseParam.getSearchEDT().replace("-", ""));
		
		List<CourseStats> list = courseService.selectClassDeptList(courseParam);
		modelMap.addAttribute("courseList", list);
		

		return null;
	}
			
	@RequestMapping("/webtrend")
	public String webtrends(ModelMap model) {
		LoginUser loginUser = loginInfoProvider.get().currentUser();
		String userId = loginUser.getUserId();
		model.addAttribute("userId", userId);
		return null;
	}

}
