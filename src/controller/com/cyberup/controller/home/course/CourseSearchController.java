package com.cyberup.controller.home.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyberup.framework.model.PagingModel;
import com.cyberup.model.course.CourseSearch;
import com.cyberup.model.univ.Univ;
import com.cyberup.service.course.CourseSearchService;
import com.cyberup.service.stats.ServiceStatsService;
import com.cyberup.service.system.CodeService;
import com.cyberup.service.system.ReptDeptService;
import com.cyberup.service.univ.UnivService;
import com.verity.logger.Logger;

@Controller
@RequestMapping("/home/course")
public class CourseSearchController {
	
	@Autowired
	private UnivService univService;
	//@Autowired
	//private CourseService courseService;
	@Autowired
	private CourseSearchService courseSearchService;
	@Autowired
	private ServiceStatsService statsService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private ReptDeptService reptDeptService;
	
	//강의명검색 시작.
	//검색시마다 페이시가 새로 로딩되도록 하기위해
	//검색조건에 해당하는 변수들을 model 에 setting 이 필요하다.
	@RequestMapping("/courseSearch")
	public String courseSearch(CourseSearch courseSearch,ModelMap model, Integer totalSearch, Integer checkbox4) throws Exception{
		model.addAttribute("param", courseSearch);

		
		String pageType = courseSearch.getPageType();
		
		//강의검색 페이지를 통합하며 pageType 을 두어 구분된 로직을 사용하도록 한다.
		if("1".equals(pageType)){
			model.addAttribute("publicList",courseSearchService.searchOpenCourse_thumnail(courseSearch));
		}else if("2".equals(pageType)){
			model.addAttribute("univdeptNameList",courseSearchService.univDeptList(courseSearch));		//학과분야별검색에서 사용할 학과리스트
		}else if("3".equals(pageType)){
			model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));//학교별 검색에서 사용할 학교리스트
		}
		
		//화면에서 넘어온 검색정보를 재사용하기 위해 courseSearch 를 모델에 넣어준다.
		
		//상세검색에서 사용할 연도 리스트
		model.addAttribute("getYearList",courseSearchService.getYearList());
		
		//검색어를 공백기준으로 배열로 만들어 3개까지 파라미터로 셋팅 
		String[] textArr = courseSearch.getText().split(" ");
		
		for (int i = 0; i < textArr.length; i++) {
			if(i==0)
				courseSearch.setText(textArr[0]);
			if(i==1)
				courseSearch.setText2(textArr[1]);
			if(i==2)
				courseSearch.setText3(textArr[2]);
		}
		
		// 상세검색일때 공개강의값 변경
		if(totalSearch == null)
			totalSearch = 1;		
		if(checkbox4 == null)
			checkbox4 = 0;		
		if(totalSearch == 2)
			courseSearch.setCheckbox1(checkbox4);
		
		//전체강의목록
		List<CourseSearch> list = courseSearchService.searchOpenCourse(courseSearch);
		
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("allList",list);
		
		/*
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",courseSearch.getText()));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",courseSearch.getText()));
		 * */
		
		
		if(list.size() > 0)
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), new PagingModel());
		
		return null;
	}
	// 강의명 검색 끝
	
	
	//대학원 강의명 검색
	@RequestMapping("/courseSearch2")
	public String courseSearch2(CourseSearch courseSearch,ModelMap model, Integer totalSearch, Integer checkbox4, Univ univ, String gubn1, String gubn2) throws Exception{
		model.addAttribute("param", courseSearch);
		//model.put("param", univ);
		System.out.println("여기부터");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println(courseSearch);
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		
		String pageType = courseSearch.getPageType();
		
		//강의검색 페이지를 통합하며 pageType 을 두어 구분된 로직을 사용하도록 한다.
		if("1".equals(pageType)){
			//model.addAttribute("publicList",courseSearchService.searchOpenCourse_thumnail(courseSearch));
		}else if("2".equals(pageType)){
			model.addAttribute("univdeptNameList",courseSearchService.univDeptList(courseSearch));		//학과분야별검색에서 사용할 학과리스트
		}else if("3".equals(pageType)){
			//model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));//학교별 검색에서 사용할 학교리스트
			model.addAttribute("univList",univService.selectGraduateUnivList(univ));
			
			if(univ.getUniversity_id() != 0)
				model.addAttribute("university_id",univ.getUniversity_id());
			
		}
		
		//화면에서 넘어온 검색정보를 재사용하기 위해 courseSearch 를 모델에 넣어준다.
		
		//상세검색에서 사용할 연도 리스트
		model.addAttribute("getYearList",courseSearchService.getYearList());
		
		model.addAttribute("graduateList",univService.graduateList(gubn1));
		
		//검색어를 공백기준으로 배열로 만들어 3개까지 파라미터로 셋팅 
		String[] textArr = courseSearch.getText().split(" ");
		
		for (int i = 0; i < textArr.length; i++) {
			if(i==0)
				courseSearch.setText(textArr[0]);
			if(i==1)
				courseSearch.setText2(textArr[1]);
			if(i==2)
				courseSearch.setText3(textArr[2]);
		}
		
		// 상세검색일때 공개강의값 변경
		if(totalSearch == null)
			totalSearch = 1;		
		if(checkbox4 == null)
			checkbox4 = 0;		
		if(totalSearch == 2)
			courseSearch.setCheckbox1(checkbox4);
		
		//전체강의목록
		List<CourseSearch> list = courseSearchService.searchOpenCourse2(courseSearch);
		
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("allList",list);
		
		/*
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",courseSearch.getText()));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",courseSearch.getText()));
		 * */
		
		
		if(list.size() > 0)
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), new PagingModel());
		
		return null;
	}
	// 강의명 검색 끝

	/**2012 고도화 로직 변경.
	 * @param courseSearch
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/courseSearchView")
	public String viewDetail(CourseSearch courseSearch,ModelMap model)throws Exception{
		
		//강좌클릭수 증가
		statsService.insCourseHits(courseSearch.getCourseId()+"",courseSearch.getUniversityId()+"", courseSearch.getDepartmentId()+"");
		
		//상세검색에서 사용할 연도 리스트
		model.addAttribute("getYearList",courseSearchService.getYearList());
		
		//검색조건 관련 재사용 
		model.addAttribute("param", courseSearch);
		
		//상세보기시 강좌명으로 공개강의및 학위논문을 검새하여 보여준다.
		
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",courseSearch.getHidetext()));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",courseSearch.getHidetext()));
		
		
		
		
		
		CourseSearch cs = courseSearchService.selectCourseInfo(courseSearch);
		model.addAttribute("viewInfo",cs);
		model.addAttribute("viewList",courseSearchService.selectLectureList(courseSearch));
		
		
		return null;	
	}
	
	
	@RequestMapping("/courseSearchId")
	public String viewDetailId(CourseSearch courseSearch,ModelMap model)throws Exception{
		
		model.addAttribute("viewList",courseSearchService.selectCourseId(courseSearch));
		
		return null;	
	}
	
	@RequestMapping("/courseSearch2View")
	public String viewDetail2(CourseSearch courseSearch,ModelMap model)throws Exception{
		
		//강좌클릭수 증가
		statsService.insCourseHits(courseSearch.getCourseId()+"",courseSearch.getUniversityId()+"", courseSearch.getDepartmentId()+"");
		
		//상세검색에서 사용할 연도 리스트
		model.addAttribute("getYearList",courseSearchService.getYearList());
		
		//검색조건 관련 재사용 
		model.addAttribute("param", courseSearch);
		
		//상세보기시 강좌명으로 공개강의및 학위논문을 검새하여 보여준다.
		
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",courseSearch.getHidetext()));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",courseSearch.getHidetext()));
		
		
		
		CourseSearch cs = courseSearchService.selectCourseInfo(courseSearch);
		model.addAttribute("viewInfo",cs);
		model.addAttribute("viewList",courseSearchService.selectLectureList(courseSearch));
		
		
		return null;	
	}
	
	@RequestMapping("/courseSearch3View")
	public String viewDetail3(CourseSearch courseSearch,ModelMap model)throws Exception{
		
		
		//강좌클릭수 증가
		//statsService.insCourseHits(courseSearch.getCourseId()+"",courseSearch.getUniversityId()+"", courseSearch.getDepartmentId()+"");
		
		
		//상세검색에서 사용할 연도 리스트
		model.addAttribute("getYearList",courseSearchService.getYearList());
		
		
		//검색조건 관련 재사용 
		model.addAttribute("param", courseSearch);
		
		
		//상세보기시 강좌명으로 공개강의및 학위논문을 검새하여 보여준다.
		
		
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",courseSearch.getHidetext()));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",courseSearch.getHidetext()));
		
		String courseId = (String)courseSearchService.selectCourseId(courseSearch);
		
		System.out.println(courseId);
		
		if(courseId != null){
			System.out.println(courseId);
			CourseSearch cs = courseSearchService.selectCourseInfo3(courseId);
			model.addAttribute("viewInfo",cs);
			model.addAttribute("viewList",courseSearchService.selectLectureList3(courseId));
			statsService.insCourseHits(courseId+"",courseSearch.getUnivId()+"", courseSearch.getDeptId()+"");
		}

		return null;	
	}
	
	@RequestMapping("/univList")
	public String univList(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));
		return null;
	}
	@RequestMapping("/univList2")
	public String univList2(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("univList2",courseSearchService.selectUnivList2(courseSearch));
		return null;
	}
	
	@RequestMapping("/rollUpList")
	public String rollUpList(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("rollUpList",courseSearchService.rollUpList(courseSearch));
		return null;
	}
	
	
	@RequestMapping("/rollUpListForPublic")
	public String rollUpListForPublic(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("rollUpListForPublic",courseSearchService.rollUpListForPublic(courseSearch));
		return null;
	}
	
	@RequestMapping("/publicList")
	public String searchByMagorArea_public(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("publicList",courseSearchService.searchOpenCourse_thumnail(courseSearch));
		return null;
	}
	
	@RequestMapping("/allList")
	public String searchByMagorArea_all(CourseSearch courseSearch,ModelMap model, Integer totalSearch, Integer checkbox4) {
		String[] textArr = courseSearch.getText().split(" ");
		
		//검색어를 공백기준으로 배열로 만들어 3개까지 파라미터로 셋팅 
		
		for (int i = 0; i < textArr.length; i++) {
			if(i==0)
				courseSearch.setText(textArr[0]);
			if(i==1)
				courseSearch.setText2(textArr[1]);
			if(i==2)
				courseSearch.setText3(textArr[2]);
		}
		//combineSearch.setTextArr(textArr);
		
		// 상세검색일때 공개강의값 변경
		if(totalSearch == null)
			totalSearch = 1;		
		if(checkbox4 == null)
			checkbox4 = 0;		
		if(totalSearch == 2)
			courseSearch.setCheckbox1(checkbox4);
		//---------------------------------
		
		List<CourseSearch> list = courseSearchService.searchOpenCourse(courseSearch);
		model.addAttribute("allList",list);
		
		if(list.size() > 0)
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), new PagingModel());
				
		return null;
	}
	
	//2012고도화 추가 메뉴 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/sampleCourse")
	public String sampleCourse(CourseSearch courseSearch,ModelMap model){
		model.addAttribute("univList2",courseSearchService.selectUnivList2(courseSearch));
		return null;	
	}
	
	@RequestMapping("/sampleCourse2")
	public String sampleCourse2(CourseSearch courseSearch,ModelMap model, Univ univ){
		model.addAttribute("univList",univService.selectGraduateUnivList(univ));
		//model.addAttribute("list",courseSearchService.selectUnivList2(courseSearch));
		return null;	
	}
	
	@RequestMapping("/publicCourse")
	public String publicCourse(CourseSearch courseSearch,ModelMap model){

		if(courseSearch.getCheckbox3() == 0)
			courseSearch.setCheckbox3(3);
		
		model.addAttribute("param", courseSearch);
		

		//상세검색에서 사용할 연도 리스트
		model.addAttribute("getYearList",courseSearchService.getYearList());
		
		//상위학과분야별로 들어갈 리스트
		model.addAttribute("univdeptNameList",courseSearchService.univDeptListForPublic(courseSearch));
		
		
		//대학별로 들어갈 리스트
		model.addAttribute("univList",courseSearchService.selectUnivListForPublic(courseSearch));
		
		//연도별로 들어갈 리스트
		model.addAttribute("yearList",courseSearchService.selectYearListForPublic(courseSearch));
		
		//검색어를 공백기준으로 배열로 만들어 3개까지 파라미터로 셋팅 
		String[] textArr = courseSearch.getText().split(" ");
		
		for (int i = 0; i < textArr.length; i++) {
			if(i==0)
				courseSearch.setText(textArr[0]);
			if(i==1)
				courseSearch.setText2(textArr[1]);
			if(i==2)
				courseSearch.setText3(textArr[2]);
		}
		
		List<CourseSearch> list = courseSearchService.selectPublicCourseList(courseSearch);
		model.addAttribute("publicCourseList", list);
		
		if(list.size() > 0)
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), list.get(0));
		else
			PagingModel.mappPages(model, courseSearch.getCurrPage(), courseSearch.getShowCnt(), new PagingModel());
		
		return null;	
	}
	
	@RequestMapping("/publicCourseList")
	public String publicCourseList(CourseSearch courseSearch,ModelMap modelMap){
		return null;	
	}
	
	@RequestMapping("/deptNameView")
	public String deptNameView(CourseSearch courseSearch,ModelMap model, Integer ViewType) {
		
		if(ViewType == 1){
			if(courseSearch.getDeptId() == null || courseSearch.getDeptId().equals(""))
				System.out.println("deptNameView Error1 : " + courseSearch.getDeptId());
			else 
				model.addAttribute("reptDeptInfo", reptDeptService.selectInfo(courseSearch.getDeptId()));
		}
		
		if(ViewType == 2){
			if(courseSearch.getUniversityId() == null || courseSearch.getUniversityId() == 0)
				System.out.println("deptNameView Error1 : " + courseSearch.getUniversityId());
			else 
				model.addAttribute("univInfo", univService.selectUnivInfo(courseSearch.getUniversityId()));
					
		}
		String rtnText ="";
		
		rtnText = courseSearch.getText();
		if(StringUtils.hasLength(courseSearch.getText1()))
			rtnText = courseSearch.getText1();

		if(StringUtils.hasLength(courseSearch.getText2()))
			rtnText = rtnText + "' ,'" + courseSearch.getText2();
		
		if(StringUtils.hasLength(courseSearch.getText3()))
			rtnText = rtnText + "' ,'" + courseSearch.getText3();
		
		model.addAttribute("searchText", rtnText);
		return null;
	}
	
	//kocw 공개강의 검색
	@RequestMapping("/kocwApiSearch_K")
	public String kocwApiSearch_K(CourseSearch courseSearch,ModelMap model) throws Exception{
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K", courseSearch.getText()));
		return null;
	}
	
	//학위논문 검색
	@RequestMapping("/kocwApiSearch_A")
	public String kocwApiSearch_A(CourseSearch courseSearch,ModelMap model) throws Exception {
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",courseSearch.getText()));
		System.out.println("\n\n ##kocwApiSearch_A end");
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@RequestMapping("/viewInfo")
	public String searchByMagorView_info(CourseSearch courseSearch,ModelMap model) {
		
		CourseSearch cs = courseSearchService.searchByMagorView_info(courseSearch.getCourseId(), courseSearch.getCourseIdentifier());
		model.addAttribute("univdeptName_list",courseSearchService.univDeptList());
		model.addAttribute("view_info",cs);
		
		//강좌클릭수 증가
		statsService.insCourseHits(cs.getCourseId()+"", cs.getRegDt()+"", cs.getUniversityId()+"", cs.getDepartmentId()+"");
		
		return null;
	}
	
	@RequestMapping("/viewList")
	public String searchByMagorView_list(CourseSearch courseSearch,ModelMap model) {
		Integer courseId = courseSearch.getCourseId();
		model.addAttribute("view_list",courseSearchService.searchByMagorView_list(courseId));
		CourseSearch cs = courseSearchService.searchByMagorView_info(courseSearch.getCourseId(), courseSearch.getCourseIdentifier());
		model.addAttribute("PublicYn",cs.getPublicYn());
		
		return null;
	}
	
	//통합검색을 통하여 강의를 검색할경우.
	@RequestMapping("/viewDetail_header")
	public String searchByMagorView_info_Course(CourseSearch courseSearch,ModelMap model, String hideText, String currPage, String tabNo) {
		
		
		//통합검색에서 사용자가 보고있던 탭과 페이지 번호를 셋팅
		//목록을 눌렀을경우 다시 사용자가 보던 탭의 페이지로 이동하는건 구조를 변경해야할듯...................
		
		System.out.println("currPage => " + currPage);
		System.out.println("tabNo => " + tabNo);

		String text1 = "";
		String text2 = "";
		System.out.println("\n\n==================================================");
		try {
			text1 = URLDecoder.decode(courseSearch.getText(),"UTF-8");
			text2 = URLDecoder.decode(hideText,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("==================================================\n\n");
		
		
		model.addAttribute("univdeptName_list",courseSearchService.univDeptList());
		model.addAttribute("view_info",courseSearchService.searchByMagorView_info(courseSearch.getCourseId(), courseSearch.getCourseIdentifier()));
		try {
		model.addAttribute("searchText",text1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer courseId = courseSearch.getCourseId();
		model.addAttribute("view_list",courseSearchService.searchByMagorView_list(courseId));
		model.addAttribute("hideText", text2);
		
		//model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",courseSearch.getText()));
		//model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",courseSearch.getText()));
		
		return "/home/course/courseSearch_header.vm";
	}
	
	
	
	@RequestMapping("/kocwApiSearch_K_univ")
	public String kocwApiSearch_K_univ(CourseSearch courseSearch,ModelMap model, String hideText) throws Exception{
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch_univ("K", hideText));
		return "/home/course/kocwApiSearch_K";
	}
	
	@RequestMapping("/kocwApiSearch_A_univ")
	public String kocwApiSearch_A_univ(CourseSearch courseSearch,ModelMap model, String hideText) throws Exception {
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",hideText));
		System.out.println("\n\n ##kocwApiSearch_A end");
		return "/home/course/kocwApiSearch_A";
	}
	
	
	
	//학과분야별검색 시작. 
	@RequestMapping("/searchByMajorArea")
	public String searchByMagorArea(CourseSearch courseSearch,ModelMap model) throws Exception{
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("univdeptName_list",courseSearchService.univDeptList());
		
		//국가공인자격증안내 에서 과목명 클릭후 검색창으로 넘어갈경우 vm 에 과목명을 쓰도록한다.
		model.addAttribute("text",courseSearch.getText());
		
		String deptId = courseSearch.getDeptId();
		String deptName = courseSearch.getDeptName();
		Integer classifyId = courseSearch.getClassifyId();
		
		model.addAttribute("deptId",deptId);
		model.addAttribute("deptName",deptName);
		
		//기본 kocw 공개강의, 학위논문
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));

		return null;
	}
	// 학과분야별검색 끝. 
	
	//학교별검색 시작.
	@RequestMapping("/searchByUniv")
	public String searchByUniv(CourseSearch courseSearch,ModelMap model) throws Exception{
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));
		
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		return null;
	}
	
	@RequestMapping("/searchByUniv_list")
	public String searchByUniv_list(CourseSearch courseSearch,ModelMap model) throws Exception {
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));

		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		return null;
	}
	//학교별검색 끝.
	
	//고급검색 시작.
	@RequestMapping("/detailSearch")
	public String detailSearch(CourseSearch courseSearch,ModelMap model) throws Exception {
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("getYearList",courseSearchService.getYearList());
		
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		return null;
	}
	//고급검색 끝.
	
	
	
	//학교별 맛보기강의 시작.
	@RequestMapping("/tasterLectureByUniv")
	public String tasterLectureByUniv(CourseSearch courseSearch,ModelMap model) throws Exception {
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));

		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		return null;
	}
	
	@RequestMapping("/tasterLectureByUniv_list")
	public String tasterLectureByUniv_list(CourseSearch courseSearch,ModelMap model) throws Exception {
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));
		
		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		return null;
	}
	//학교별 맛보기강의 끝.

	
	//학교별 추천강의 시작.
	@RequestMapping("/recommendByUniv")
	public String recommendByUniv(CourseSearch courseSearch,ModelMap model) throws Exception {
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));

		model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		return null;
	}
	
	//학교별 추천강의 끝.

	@RequestMapping("/viewDetail1_header")
	public String viewDetail1_header(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));

		//model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		//model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		
		CourseSearch cs = courseSearchService.searchByMagorView_info(courseSearch.getCourseId(), courseSearch.getCourseIdentifier());
		model.addAttribute("univdeptName_list",courseSearchService.univDeptList());
		model.addAttribute("view_info",cs);
		
		//강좌클릭수 증가
		statsService.insCourseHits(cs.getCourseId()+"", cs.getRegDt()+"", cs.getUniversityId()+"", cs.getDepartmentId()+"");
		Integer courseId = cs.getCourseId();
		model.addAttribute("view_list",courseSearchService.searchByMagorView_list(courseId));
		
		return "/home/course/recommendByUniv_header.vm";
	}
	
	@RequestMapping("/viewDetail2_header")
	public String viewDetail2_header(CourseSearch courseSearch,ModelMap model) {
		model.addAttribute("showCntList",codeService.selectList(88, "Y"));
		model.addAttribute("univList",courseSearchService.selectUnivList(courseSearch));
		
		//model.addAttribute("kocwApiSearch_K",courseSearchService.kocwApiSearch("K",""));
		//model.addAttribute("kocwApiSearch_A",courseSearchService.kocwApiSearch("T",""));
		
		CourseSearch cs = courseSearchService.searchByMagorView_info(courseSearch.getCourseId(), courseSearch.getCourseIdentifier());
		model.addAttribute("univdeptName_list",courseSearchService.univDeptList());
		model.addAttribute("view_info",cs);
		
		//강좌클릭수 증가
		statsService.insCourseHits(cs.getCourseId()+"", cs.getRegDt()+"", cs.getUniversityId()+"", cs.getDepartmentId()+"");
		Integer courseId = cs.getCourseId();
		model.addAttribute("view_list",courseSearchService.searchByMagorView_list(courseId));
		
		return "/home/course/tasterLectureByUniv_header.vm";
	}
	
	*/
	
	
	
}
