package com.cyberup.controller.home.eudc;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import net.sf.cglib.core.Local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberup.service.educ.StatisiticsService;
import com.cyberup.util.DateFormatter;

/*************************************************************
 * 
 * 기   능 : 사이버대학 통계 기능실현
 * 작성자 : 배진국 
 * 작성일 : 2011-11-11
 * 
 **************************************************************/
@Controller
@RequestMapping("/home/eudc")

public class StatisticsController {

	@Autowired
	private StatisiticsService statisiticsService;	
	
	@RequestMapping("/statistics")
	public String board(ModelMap model, String gubunNm) {
		
		
		if(gubunNm == null || "".equals(gubunNm))
			model.put("gubunNm", "univ");
			//model.put("gubunNm", "age");
		else
			model.put("gubunNm", gubunNm);
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("gubunNm :: '" + gubunNm + "'");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		
		
		List<Map> yearList = statisiticsService.seleStatisticsctYearList();	
		if(yearList == null || yearList.size() == 0)
		{
			DateFormatter df = new DateFormatter("yyyy");
			Map map = new HashMap();
			map.put("STT_YEAR", df.print(new Date(), Locale.getDefault()));
			map.put("STT_YEAR", "2016");
			yearList.add(map);
			
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆1☆☆☆☆☆☆☆☆☆☆☆☆");
			System.out.println(map.get("STT_YEAR"));
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆1☆☆☆☆☆☆☆☆☆☆☆☆");
		}
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆2☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out.println(yearList);
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆2☆☆☆☆☆☆☆☆☆☆☆☆");
		model.put("yearList", yearList);

		return null;
	}
	
	@RequestMapping("/statistics2")
	public String board2(ModelMap model, String gubunNm) {
		if(gubunNm == null || "".equals(gubunNm))
			model.put("gubunNm", "univ");
			//model.put("gubunNm", "age");
		else
			model.put("gubunNm", gubunNm);
		
		List<Map> yearList = statisiticsService.seleStatisticsctYearList();	
		if(yearList == null || yearList.size() == 0)
		{
			DateFormatter df = new DateFormatter("yyyy");
			Map map = new HashMap();
			map.put("STT_YEAR", df.print(new Date(), Locale.getDefault()));
			yearList.add(map);
		}
		model.put("yearList", yearList);

		return null;
	}
	
	
	
	/************** 교과부 통계 리스트 **************/
	@RequestMapping(value = "/statistics_list", method = RequestMethod.POST)
	public String list(ModelMap modelMap,
				@RequestParam(required = true) String gubunNm, String sttYear, String sttMonth, String gubunID) {
		
		List<Map> list;
		if("univ".equals(gubunNm)) {
			/*
			 * LIST1 START
			 */
			list = statisiticsService.seleStatisticsctList(gubunNm, sttYear, sttMonth, "51,52");
			
			for (int j = 0; j < list.size(); j++) {
				TreeMap tmap1 = new TreeMap();
				TreeMap tmap2 = new TreeMap();
				HashMap hmap = (HashMap)list.get(j);
				String chairman = (String)hmap.get("CHARIMAN");
				String principal = (String)hmap.get("PRINCIPAL");
				
//				System.out.println("chairMan["+j+"] = " + chairMan);
				if(chairman != null){
					String[] chairmanArr = chairman.split(";");
					for (int i = 0; i < chairmanArr.length; i++) {
						if(!chairmanArr[i].equals("") && chairmanArr[i].length() > 4){
							String year = chairmanArr[i].substring(0,4); 
							String name = chairmanArr[i].substring(4);
							
//							System.out.println("year["+j+"] = " + year);
//							System.out.println("name["+j+"] = " + name);
							
							tmap1.put(year, name);
						}
					}//end for
					
				}
//				System.out.println("tmap["+j+"]" + tmap);
//				System.out.println("tmap["+j+"]" + tmap.get("2013"));
//				System.out.println("Cmap = " +tmap);
				if(principal != null){
					String[] principalArr = principal.split(";");
					for (int i = 0; i < principalArr.length; i++) {
						if(!principalArr[i].equals("") && principalArr[i].length() > 4){
							String year = principalArr[i].substring(0,4); 
							String name = principalArr[i].substring(4);
							tmap2.put(year, name);
						}
					}
				}
				
				list.get(j).put("chairman", tmap1);
				list.get(j).put("principal", tmap2);
			}
			/*
			 * LIST1 END
			 */
			
			/*
			 * LIST2 START
			 */
			List<Map> list2 = statisiticsService.seleStatisticsctList(gubunNm, sttYear, sttMonth, "163");		
			
			for (int j = 0; j < list2.size(); j++) {
				TreeMap tmap1 = new TreeMap();
				TreeMap tmap2 = new TreeMap();
				HashMap hmap = (HashMap)list2.get(j);
				String chairman = (String)hmap.get("CHARIMAN");
				String principal = (String)hmap.get("PRINCIPAL");
				
//				System.out.println("chairMan["+j+"] = " + chairMan);
				if(chairman != null){
					String[] chairmanArr = chairman.split(";");
					for (int i = 0; i < chairmanArr.length; i++) {
						if(!chairmanArr[i].equals("") && chairmanArr[i].length() > 5){
							String year = chairmanArr[i].substring(0,4); 
							String name = chairmanArr[i].substring(4);
							
//							System.out.println("year["+j+"] = " + year);
//							System.out.println("name["+j+"] = " + name);
							
							tmap1.put(year, name);
						}
					}//end for
					
				}
//				System.out.println("tmap["+j+"]" + tmap);
//				System.out.println("tmap["+j+"]" + tmap.get("2013"));
//				System.out.println("Cmap = " +tmap);
				if(principal != null){
					String[] principalArr = principal.split(";");
					for (int i = 0; i < principalArr.length; i++) {
						if(!principalArr[i].equals("") && principalArr[i].length() > 5){
							String year = principalArr[i].substring(0,4); 
							String name = principalArr[i].substring(4);
							tmap2.put(year, name);
						}
					}
				}
				
				list2.get(j).put("chairman", tmap1);
				list2.get(j).put("principal", tmap2);
			}
			/*
			 * LIST2 END
			 */
			modelMap.addAttribute("statisiticsList", list);
			modelMap.addAttribute("statisiticsList2", list2);
		} else if("student".equals(gubunNm))
		{
			list = statisiticsService.seleStatisticsctList(gubunNm, sttYear, sttMonth, gubunID);		
			modelMap.addAttribute("statisiticsList", list);
			List<Map> list2 = statisiticsService.seleStatisticsctList(gubunNm + "_job", sttYear, sttMonth, gubunID);		
			modelMap.addAttribute("statisiticsList2", list2);
		}
		else {
			list = statisiticsService.seleStatisticsctList(gubunNm, sttYear, sttMonth, gubunID);		
			modelMap.addAttribute("statisiticsList", list);
		}	
		
		modelMap.addAttribute("gubunNm", gubunNm);
		
//		if(list == null || list.size() == 0 || ("univ".equals(gubunNm) && list.size() == 1))
//			return "/home/eudc/statistics_list";
//		else
			return "/home/eudc/statistics_list_" + gubunNm;
	}
	
	/************** 교과부 통계 리스트2 **************/
	@RequestMapping(value = "/statistics_list2", method = RequestMethod.POST)
	public String list2(ModelMap modelMap,
			@RequestParam(required = true) String gubunNm, String sttYear, String sttMonth, String gubunID) {
		
		List<Map> list = statisiticsService.seleStatisticsctList(gubunNm, sttYear, sttMonth, gubunID);		
		modelMap.addAttribute("statisiticsList", list);
		modelMap.addAttribute("gubunNm", gubunNm);
		
		return "/home/eudc/statistics_list_" + gubunNm + "2";
	}
	
}
