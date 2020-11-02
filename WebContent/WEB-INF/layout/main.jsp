<%--
/**-----------------------------------------------------------------------
 * Cuinfo Project
 *------------------------------------------------------------------------
 * @Class main.jsp
 * @Description 메인 컨트롤러
 * @author 김세아
 * @since -
 * @version 1.0
 *
 * @Copyright (c) 2019 코테크시스템  All rights reserved.
 *------------------------------------------------------------------------
 * Modification Information
 *------------------------------------------------------------------------
 * 수정일       수정자       수정내용
 * ----------- ---------  -----------------------------------------------
 * -			-			최초생성
 * 2019.03.26 	김세아		[사이버대학 안내]-[교육부 지원사업]-[교육부 지원사업(2018) 성인 학습자 역량 강화 교육콘텐츠 개발 사업 페이지 추가]
 */
--%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%

String gnb = request.getParameter("gnb");
String URL = "/home";
String BodyType = "";

String GnbOn1  	= ""; String GnbOn2   = "";	String GnbOn3 	= ""; String GnbOn4  = ""; String GnbOn5	=	""; String GnbOn6 =	"";
String SnbOn11 	= ""; String SnbOn111 = ""; String SnbOn112 = ""; String SnbOn113 = "";
String SnbOn12 	= ""; String SnbOn121 	= ""; 
String SnbOn13  = ""; String SnbOn131 = ""; String SnbOn132 = ""; String SnbOn133 = ""; String SnbOn134 = ""; String SnbOn135=""; 
String SnbOn14  = ""; String SnbOn141 = ""; String SnbOn142 = ""; 
String SnbOn15  = ""; 
String SnbOn16  = ""; String SnbOn161  = ""; String SnbOn162  = "";

//입학안내
String SnbOn21 	= ""; String SnbOn211 = ""; String SnbOn212 = ""; 
String SnbOn22  = ""; 
String SnbOn23  = "";

//교과과정
String SnbOn31 	= ""; 
String SnbOn32  = ""; String SnbOn321  = ""; String SnbOn322  = ""; 
String SnbOn33 	= "";
String SnbOn34 	= "";

//강의검색
String SnbOn41 	= ""; 
String SnbOn42  = ""; 
String SnbOn43 	= ""; 
String SnbOn44  = ""; 
String SnbOn45  = "";

//정보자료실
String SnbOn51	= ""; 
String SnbOn52	= "";
String SnbOn53	= "";
String SnbOn54	= "";
String SnbOn55	= ""; String SnbOn551	= ""; String SnbOn552	= ""; String SnbOn553	= ""; String SnbOn554	= ""; String SnbOn555	= ""; String SnbOn556	= ""; String SnbOn557	= ""; String SnbOn558	= ""; String SnbOn559	= ""; String SnbOn5510= ""; String SnbOn5511= "";

String Category = "";
String MainTitle= "";
String SubTitle = "";
String TitleImg = "";
String PageID   = "";
String PageClass= "";
String PageUrl 	= "/home/index.main.action";

if(gnb == null){ gnb = "0"; }
int cate_int = Integer.parseInt(gnb);
System.out.println("check gnb ==> " + gnb);
System.out.println("check gnb ==> " + gnb);
System.out.println("check gnb ==> " + gnb);

/************************************************************************************************************/
//사이버대학안내
String GnbName1   = "사이버대학 안내";
//1.사이버대학이란?
String SnbNmae11  = "사이버대학이란?";		String PageUrl11  = "/home/intro/summary.sub.action?gnb=11";
String SnbNmae111 = "소개 및 특징";		String PageUrl111 = "/home/intro/summary.sub.action?gnb=111";
String SnbNmae112 = "학기 및 수업 안내";	String PageUrl112 = "/home/intro/guidenew.sub.action?gnb=112";
String SnbNmae114 = "연혁";	String PageUrl114 = "/home/intro/yearHistory.sub.action?gnb=114";
// String SnbNmae113 = "시간제등록 안내";		String PageUrl113 = "/home/intro/guideTime.sub.action?gnb=113";
//String SnbNmae113 = "시간제등록 안내";		String PageUrl113 = "/home/entr/enterStep_New.sub.action?gnb=211";
//2.대학소개
String SnbNmae12  = "대학 소개";			String PageUrl12  = "/home/intro/overall.sub.action?gnb=12";
String SnbNmae121  = "대학원 소개";		String PageUrl121  = "/home/intro/overallGraduate.sub.action?gnb=121";
//3.학위치득/국가자격증
String SnbNmae13  = "학위취득/국가자격증";	String PageUrl13  = "/home/intro/certificate1.sub.action?gnb=13";
String SnbNmae131 = "사회복지사";			String PageUrl131 = "/home/intro/certificate1.sub.action?gnb=131";
String SnbNmae132 = "보육교사";			String PageUrl132 = "/home/intro/certificate2.sub.action?gnb=132";
String SnbNmae133 = "평생교육사";			String PageUrl133 = "/home/intro/certificate3.sub.action?gnb=133";
String SnbNmae134 = "건강가정사";			String PageUrl134 = "/home/intro/certificate4.sub.action?gnb=134";
String SnbNmae135 = "과목리스트";			String PageUrl135 = "/home/intro/certificate_subjectInfo.sub.action?gnb=135";
//4.진학가이드
String SnbNmae14  = "진학가이드";			String PageUrl14  = "/home/intro/serviceGuide.sub.action?gnb=14";
String SnbNmae141 = "나의 전형 미리보기";	String PageUrl141 = "/home/intro/serviceGuide.sub.action?gnb=141";
String SnbNmae142 = "대학별 문의";			String PageUrl142 = "/home/intro/serviceQuestion.sub.action?gnb=142";
//5.성공수기
String SnbNmae15  = "성공수기";			String PageUrl15  = "/home/intro/successStory.sub.action?gnb=15";
//6.교육부지원 사업
String SnbNmae16  = "교육부지원사업";			String PageUrl16  = "/home/intro/characterization.sub.action?gnb=16";
String SnbNmae161  = "NSC기반 교육과정개편";	String PageUrl161  = "/home/intro/characterization2014.sub.action?gnb=161";
String SnbNmae162  = "선취업·후진학 지원";		String PageUrl162  = "/home/intro/characterization.sub.action?gnb=162";
String SnbNmae163  = "교수학습 우수사례";		String PageUrl163  = "/home/intro/goodCase.sub.action?gnb=163";
String SnbNmae164  = "성인 학습자 역량 강화 교육콘텐츠 개발 사업";		String PageUrl164  = "/home/intro/empowermentDev.sub.action?gnb=164"; //2019.03.26. jsyoon

//String SnbNmae163 = "사업 성과물";			String PageUrl163  = "/home/intro/characterizationResult.sub.action?gnb=163";


if((Integer.toString(cate_int).substring(0,1).equals("1"))){	 
	MainTitle="사이버대학 안내";		GnbOn1 = "on" ;	Category = "/home/intro/summary.sub.action?gnb=11"; PageClass = "sub_intro";
}

if(cate_int == 11) {SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn111="on"; PageUrl = "/home/intro/summary.sub.action?gnb=11";	}
if(cate_int == 111){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn111="on"; PageUrl = "/home/intro/summary.sub.action?gnb=111";	}
if(cate_int == 112){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn112="on"; PageUrl = "/home/intro/guidenew.sub.action?gnb=112";	}
if(cate_int == 113){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn113="on"; PageUrl = "/home/intro/guideTime.sub.action?gnb=113";	}
if(cate_int == 114){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn113="on"; PageUrl = "/home/intro/yearHistory.sub.action?gnb=114";	}
if(cate_int == 12) {SubTitle="대학 소개";				TitleImg="title2";	SnbOn12="on";				 PageUrl = "/home/intro/overall.sub.action?gnb=12";	}
if(cate_int == 121){SubTitle="대학원 소개";			TitleImg="title2";	SnbOn121="on";				 PageUrl = "/home/intro/overallGraduate.sub.action?gnb=121";	}
if(cate_int == 13) {SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn131="on"; PageUrl = "/home/intro/certificate1.sub.action?gnb=131";	}
if(cate_int == 131){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn131="on"; PageUrl = "/home/intro/certificate1.sub.action?gnb=131";	}
if(cate_int == 132){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn132="on"; PageUrl = "/home/intro/certificate2.sub.action?gnb=132";	}
if(cate_int == 133){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn133="on"; PageUrl = "/home/intro/certificate3.sub.action?gnb=133";	}
if(cate_int == 134){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn134="on"; PageUrl = "/home/intro/certificate4.sub.action?gnb=134";	}
if(cate_int == 135){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn135="on"; PageUrl = "/home/intro/certificate_subjectInfo.sub.action?gnb=135";	}
if(cate_int == 14) {SubTitle="진학가이드";			TitleImg="title4";	SnbOn14="on"; SnbOn141="on"; PageUrl = "/home/intro/serviceGuide.sub.action?gnb=14";     	}
if(cate_int == 141){SubTitle="진학가이드";			TitleImg="title4";	SnbOn14="on"; SnbOn141="on"; PageUrl = "/home/intro/serviceGuide.sub.action?gnb=141";     	}
if(cate_int == 142){SubTitle="진학가이드";			TitleImg="title4";	SnbOn14="on"; SnbOn142="on"; PageUrl = "/home/intro/serviceQuestion.sub.action?gnb=142";     	}
if(cate_int == 15) {SubTitle="성공수기";				TitleImg="title5";	SnbOn15="on"; PageUrl = "/home/intro/successStory.sub.action?gnb=15";}
if(cate_int == 16) {SubTitle="교육부지원사업";			TitleImg="title6";	SnbOn16="on"; PageUrl = "/home/intro/characterization.sub.action?gnb=16";}
if(cate_int == 161) {SubTitle="교육부지원사업";			TitleImg="title6";	SnbOn16="on"; SnbOn161="on"; PageUrl = "/home/intro/characterization2014.sub.action?gnb=161";}
if(cate_int == 162) {SubTitle="교육부지원사업";			TitleImg="title6";	SnbOn16="on"; SnbOn162="on"; PageUrl = "/home/intro/characterization.sub.action?gnb=162";}
if(cate_int == 164) {SubTitle="교육부지원사업";			TitleImg="title6";	SnbOn16="on"; SnbOn162="on"; PageUrl = "/home/intro/characterization.sub.action?gnb=164";}

/************************************************************************************************************/
//입학안내
String GnbName2   = "입학안내";
//1.입학 구분 및 절차
String SnbNmae21  = "입학 구분 및 절차";				String PageUrl21  = "/home/entr/enterStep_New.sub.action?gnb=211";
String SnbNmae211 = "신입학/편입학 안내";				String PageUrl211 = "/home/entr/enterStep_New.sub.action?gnb=211";
String SnbNmae212 = "시간제 등록 안내";					String PageUrl212 = "/home/entr/enterStep_Time.sub.action?gnb=212";
//2.모집요강
String SnbNmae22  = "모집요강";					String PageUrl22  = "/home/entr/enterGuide.sub.action?gnb=22";
//3.대학 정보현황
String SnbNmae23  = "대학 정보 현황";				String PageUrl23  = "/home/entr/univStats.sub.action?gnb=23";

if((Integer.toString(cate_int).substring(0,1).equals("2"))){		
	MainTitle="입학안내";	GnbOn2 = "on" ;	Category = "/home/entr/enterStep_New.sub.action?gnb=21"; PageClass = "sub_entr";
}
if(cate_int == 21) {SubTitle="입학 구분 및 절차";		TitleImg="title1";	SnbOn21="on"; SnbOn211="on"; PageUrl = "/home/entr/enterStep_New.sub.action?gnb=211";		}
if(cate_int == 211){SubTitle="입학 구분 및 절차";		TitleImg="title1";	SnbOn21="on"; SnbOn211="on"; PageUrl = "/home/entr/enterStep_New.sub.action?gnb=211";		}
if(cate_int == 212){SubTitle="입학 구분 및 절차";		TitleImg="title1";	SnbOn21="on"; SnbOn212="on"; PageUrl = "/home/entr/enterStep_Time.sub.action?gnb=212";		}
if(cate_int == 22) {SubTitle="모집요강";			TitleImg="title2";	SnbOn22="on";				 PageUrl = "/home/entr/enterGuide.sub.action?gnb=22";		}
if(cate_int == 23) {SubTitle="대학 정보 현황";		TitleImg="title3";	SnbOn23="on";				 PageUrl = "/home/entr/univStats.sub.action?gnb=23";		}


/************************************************************************************************************/
//교과과정
String GnbName3		= "교과과정";
//1.교과과정보기
String SnbNmae31  	= "대학별 학과/교과과정";				String PageUrl31	= "/home/curri/areadept.sub.action?gnb=31";
//2.학과정보
String SnbNmae32  	= "분야별 학과/교과과정";			String PageUrl32	= "/home/curri/navigationMajorArea.sub.action?gnb=32";
String SnbNmae321  	= "학과 내비게이션";			String PageUrl321	= "/home/curri/navigationMajorArea.sub.action?gnb=321";
String SnbNmae322  	= "학과 개설 현황";			String PageUrl322	= "/home/curri/major.sub.action?gnb=322";
//3.전체학과검색
String SnbNmae33  	= "전체교과과정";				String PageUrl33	= "/home/curri/searchMajor.sub.action?gnb=33";
String SnbNmae34  	= "전체학과검색";				String PageUrl34	= "/home/curri/searchMajor.sub.action?gnb=34";

if((Integer.toString(cate_int).substring(0,1).equals("3"))){
	MainTitle="교과과정";		GnbOn3 ="on" ;	Category = "/home/intro/summary.sub.action?gnb=31"; PageClass = "sub_curri";
}
if(cate_int == 31) {SubTitle="교과과정 보기";		TitleImg="title1";	SnbOn31="on"; PageUrl = "/home/curri/curriculum.sub.action?gnb=31";	}
if(cate_int == 32) {SubTitle="학과정보";	TitleImg="title3";	SnbOn32="on"; PageUrl = "/home/curri/navigationMajorArea.sub.action?gnb=32"; SnbOn321="on";}
if(cate_int == 321){SubTitle="학과 내비게이션";	TitleImg="title3";	SnbOn32="on"; PageUrl = "/home/curri/navigationMajorArea.sub.action?gnb=321"; SnbOn321="on";}
if(cate_int == 322){SubTitle="학과 개설 현황";		TitleImg="title3";	SnbOn32="on"; PageUrl = "/home/curri/major.sub.action?gnb=322";	SnbOn322="on";}
if(cate_int == 33) {SubTitle="전체학과검색";		TitleImg="title3";	SnbOn33="on"; PageUrl = "/home/curri/major.sub.action?gnb=33";	}
if(cate_int == 34) {SubTitle="전체학과검색";		TitleImg="title3";	SnbOn33="on"; PageUrl = "/home/curri/major.sub.action?gnb=33";	}


/************************************************************************************************************/
//강의검색
String GnbName4   = "강의검색";
//1.강의명 검색
String SnbNmae41  = "강의명 검색";					String PageUrl41  = "/home/course/courseSearch.sub.action?gnb=41&pageType=1";
//2.학과분야별 검색
//String SnbNmae42  = "학과분야별 검색";					String PageUrl42  = "/home/course/searchByMajorArea.sub.action?gnb=42&pageType=2";
String SnbNmae42  = "학과분야별 검색";					String PageUrl42  = "/home/course/courseSearch.sub.action?gnb=42&pageType=2";
//3.학교별 검색
//String SnbNmae43  = "학교별 검색";					String PageUrl43  = "/home/course/searchByUniv.sub.action?gnb=43&pageType=3";
String SnbNmae43  = "학교별 검색";					String PageUrl43  = "/home/course/courseSearch.sub.action?gnb=43&pageType=3";
//4.학교별 강의 맛보기
String SnbNmae44  = "학교별 강의 맛보기";			String PageUrl44  = "/home/course/sampleCourse.sub.action?gnb=44";
//5.공개강의
String SnbNmae45  = "공개강의";					String PageUrl45  = "/home/course/publicCourse.sub.action?gnb=45";


if((Integer.toString(cate_int).substring(0,1).equals("4"))){
	MainTitle="강의검색";		GnbOn4 = "on" ;	Category = "/home/course/courseSearch.sub.action?gnb=41"; PageClass = "sub_course";
}
if(cate_int == 41) {SubTitle="강의명 검색";		TitleImg="title1";	SnbOn41="on";				 PageUrl = "/home/course/courseSearch.sub.action?gnb=41";		}
if(cate_int == 42) {SubTitle="학과분야별 검색";	TitleImg="title2";	SnbOn42="on";				 PageUrl = "/home/course/searchByMajorArea.sub.action?gnb=42";	}
if(cate_int == 43) {SubTitle="학교별 검색";		TitleImg="title3";	SnbOn43="on";				 PageUrl = "/home/course/searchByUniv.sub.action?gnb=43";		}
if(cate_int == 44) {SubTitle="학교별 강의 맛보기";	TitleImg="title4";	SnbOn44="on";				 PageUrl = "/home/course/searchByUniv.sub.action?gnb=44";		}
if(cate_int == 45) {SubTitle="공개강의";			TitleImg="title5";	SnbOn45="on";				 PageUrl = "/home/course/searchByUniv.sub.action?gnb=45";		}


/************************************************************************************************************/
//정보자료실
String GnbName5   = "정보자료실";
//연구/교육자료
String SnbNmae51  = "연구/교육 자료";				String PageUrl51  = "/home/refer/board.sub.action?gnb=51&gID=153";
//사이버대학 뉴스
String SnbNmae52  = "사이버대학 뉴스";				String PageUrl52  = "/home/refer/boardNews.sub.action?gnb=52";
//공지사항
String SnbNmae53  = "공지사항";					String PageUrl53  = "/home/refer/board.sub.action?gnb=53&gID=154";
//자주하는 질문 답변
String SnbNmae54  = "자주 묻는 질문";			String PageUrl54  = "/home/refer/faq.sub.action?gnb=54&gID=156";
//사이버대학 통계
String SnbNmae55  = "사이버대학 통계";					String PageUrl55  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=univ&sttYear=2019";
String SnbNmae551  = "대학별 현황표";					String PageUrl551  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=univ&sttYear=2019";
String SnbNmae552  = "입학정원 현황";					String PageUrl552  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=entrancePro&sttYear=2019";
String SnbNmae553  = "입학정원 대비 등록률";			String PageUrl553  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=entrance&sttYear=2019";
String SnbNmae554  = "성별 등록생 비율";				String PageUrl554  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=sex&sttYear=2019";
String SnbNmae555  = "연령별 등록생 비율";				String PageUrl555  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=age&sttYear=2019";
String SnbNmae556  = "직업별 등록생 비율";				String PageUrl556  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=job&sttYear=2019";
String SnbNmae557  = "학년도별 원격대학 총 졸업생 수";	String PageUrl557  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=graduate&sttYear=2019";
String SnbNmae558  = "재학생수 현황";					String PageUrl558  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=student&sttYear=2019";
String SnbNmae559  = "시간제등록생 모집 결과";			String PageUrl559  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=time&sttYear=2019";
String SnbNmae5510  = "입학금 및 수업료 현황";			String PageUrl5510  = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=fee&sttYear=2019";

if((Integer.toString(cate_int).substring(0,1).equals("5"))){
	MainTitle="정보자료실";	GnbOn5 = "on" ;	Category = "/home/refer/board.sub.action?gnb=51";PageClass = "sub_refer";
}
if(cate_int == 51) {SubTitle="연구/교육 자료";					TitleImg="title1";	SnbOn51="on";				 PageUrl = "/home/refer/board.sub.action?gnb=51&gID=153";      	}
if(cate_int == 52) {SubTitle="사이버대학뉴스";				TitleImg="title2";	SnbOn52="on";				 PageUrl = "/home/refer/boardNews.sub.action?gnb=52";     	}
if(cate_int == 53) {SubTitle="대학행사 안내";					TitleImg="title3";	SnbOn53="on";				 PageUrl = "/home/refer/boardUniv.sub.action?gnb=53";     	}
if(cate_int == 54) {SubTitle="원격대학 협의회 동정";			TitleImg="title5";	SnbOn54="on";				 PageUrl = "/home/refer/board.sub.action?gnb=55&gID=152";      	}
if(cate_int == 55) {SubTitle="공지사항";						TitleImg="title5";	SnbOn55="on";				 PageUrl = "/home/refer/board.sub.action?gnb=55&gID=155";    	}
if(cate_int == 55) {SubTitle="자주 묻는 질문";				TitleImg="title7";	SnbOn55="on";				 PageUrl = "/home/refer/faq.sub.action?gnb=54&gID=156";		}
if(cate_int == 55) {SubTitle="교과부통계";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55";		}
if(cate_int == 551){SubTitle="대학별 현황표";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=univ";		}
if(cate_int == 552){SubTitle="입학정원 현황";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=entrancePro";		}
if(cate_int == 553){SubTitle="입학정원 대비 등록률";			TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=entrance";		}
if(cate_int == 554){SubTitle="성별 등록생 비율";				TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=sex";		}
if(cate_int == 555){SubTitle="연령별 등록생 비율";				TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=age";		}
if(cate_int == 556){SubTitle="직업별 등록생 비율";				TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=job";		}
if(cate_int == 557){SubTitle="학년도별 원격대학 총 졸업생 수";	TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=graduate";		}
if(cate_int == 558){SubTitle="재학생수 현황";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=student";		}
if(cate_int == 559){SubTitle="시간제등록생 모집 결과";			TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=time";		}
if(cate_int ==5510){SubTitle="입학금 및 수업료 현황";			TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics.sub.action?gnb=55&gubunNm=fee";		}

/************************************************************************************************************/


WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<title>사이버대학 CUInfo</title>
<style type="text/css">
		
		#slideshow {
		    position:relative;
		    height:350px;
		}
		
		#slideshow IMG {
		    position:absolute;
		    top:0;
		    left:0;
		    z-index:8;
		    opacity:0.0;
		}
		
		#slideshow IMG.active {
		    z-index:10;
		    opacity:1.0;
		}
		
		#slideshow IMG.last-active {
		    z-index:9;
		}
		
</style>
		
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" type="text/css" href="/home/css2/main.css" />

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/> 

<script type="text/javascript" src="/home/js2/jquery-1.9.1.min.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery.fadeSliderToggle.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery.popupWindow.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery.form.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/layout.js"></script>    
<script type="text/javascript" language="javascript" src="/home/js/flashinside.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery.yakurotate.min.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/main.js"></script>
<script type="text/javascript" language="javascript" src="/home/mediaplayer/jwplayer.js"></script>

<!-- webtrends -->   
<script language="vbscript" src="/home/js/urldecode.vbs"></script>
<script language="javascript" src="/home/js/cuinfo.net.js"></script>
<!-- webtrends -->	

<!-- 메인이미지 애니메이션 -->
<script type="text/javascript" src="/home/js/jquery.galleriffic.js"></script>
<script type="text/javascript" src="/home/js/jquery.opacityrollover.js"></script>
<script type="text/javascript" src="/home/js/jquery-ui.min-1.8.js"></script>

<!-- 메인이미지 애니메이션 -->

<script>
$(document).ready(function() {
	
	//안드로이드일 경우 depth2 의 링크를 없앤다.
	var appVer = navigator.appVersion;
// 	alert("appVer = " + appVer + "\n" + $("ul[class^=sub]>li>a").size());
// 	alert($("ul[class^=sub]>li>a").size());

	if(appVer.indexOf("Android") > 0){
		$(".ul_depth1>li>a").prop("href","javascript:return false;");

		$("ul[class^=sub]>li>a").each(function(){
			if($(this).siblings().size() > 0)
				$(this).prop("href","javascript:return false;");
		});
		
// 		$("ul[class^=sub]>li>a").prop("href","javascript:return false;");
	}

	//사이버대학+ 버튼
	$("#leftgnb .cyber_gnb .btn a").click(function(){
		
		if($(".cyber_gnb").css("width") != "5px") {
			$(".cyber_gnb").css({"width":"5px"});
			$(".cyber_gnb .btn").css({"left":"5px"});
			$(".cyber_gnb .cyber_menu_div").hide();
			$(".cyber_ul li").hide();
		} else {
			$(".cyber_gnb").css({"width":"158px"});
			$(".cyber_gnb .btn").css({"left":"158px"});
			$(".cyber_gnb .cyber_menu_div").show();
			$(".cyber_ul li").each(function(index){
				setTimeout(function(){
					$(".cyber_ul li:eq("+index+")").show("slow");	
				}, index * 50);
			});
		}
	});
	
	//컨텐츠롤링
	$(".future .roll a").click(function() {	
		
		var num = $(this).index();
		var newLeft =num*-410;
		$(".future .roll a").attr("class","off");
		$(".future .roll a").eq(num).attr("class","on");
		$(".future .img").animate({'left' : newLeft+"px" },300);
	});

	var subnum = "";
	
	//서브메뉴2
	
	$(".ul_depth1 li").mouseenter(function(){
		subnum = $(this).index();
		var arrow_top = 160+(subnum*40);	
		$("#leftgnb .depth2_div ul").hide();	
		$(".depth2_div").css("display","block");
		$("#leftgnb .depth2_div ul.sub"+subnum).fadeIn(300);
		$("#leftgnb .depth2_div .arrow").css("top",arrow_top+"px");
	});
	
	$(".ul_depth1 li").mouseleave(function(){
		subnum = $(this).index();
		var arrow_top = 160+(subnum*40);
// 		$("left#gnb .depth2_div ul").css("display","none");
		$(".depth2_div").hide();
		$("#leftgnb .depth2_div .arrow").css("top",arrow_top+"px");
	});
	
	//메뉴클릭시 하위메뉴 닫기 기능
	$(".ul_depth1 li").click(function(){
		$(".depth2_div").toggle();
	});

	//depth2 클릭 이벤트
	$(".depth2_div ul li").each(function(index){
		$(this).click(function(){
			
			
			/*
			var appVer = navigator.appVersion;
			if(appVer.indexOf("Android") > 0)
				alert("안드로이드 ok");
			else
				alert("안드로이드 no");
			*/
			
			if($(this).find("ul").size() > 0){
				$(this).find("ul").toggle();
				$(".bg_depth3").toggle();
			}
		});
	});
	
	$(".depth2_div").hover(
	function() {
		var arrow_top = 160+(subnum*40);
		$(".depth2_div").css("display","block");
		$("#leftgnb .depth2_div ul.sub"+subnum).css("display","block");
		$("#leftgnb .depth2_div .arrow").css("top",arrow_top+"px");
	},
	function() {
		var arrow_top = 160+(subnum*40);
		$("#leftgnb .depth2_div").children("ul").css("display","none");
		$(".depth2_div").css("display","none");
		//$("#gnb .depth2_div ul.sub"+subnum).css("display","none");
		$("#leftgnb .depth2_div .arrow").css("top",arrow_top+"px");
	}
	);
		
	//서브메뉴3
	$(".depth2_div ul li").hover(
		function() {
			
				$(this).children("a").children("img").attr("src",$(this).children("a").children("img").attr("src").replace("_off","_on"));
				if ($(this).children("a").children("img").attr('src').toString().indexOf('m_d1_7_') != -1){
					$(this).children("a").addClass("onwide");
				}else{
					$(this).children("a").addClass("on");
				}


				if($(this).children("a").next().length > 0) {

					$(this).children("a").next().show();

					if ($(this).children("a").children("img").attr('src').toString().indexOf('m_d1_7_') != -1){

						$(".depth2_div .bg_depth3Wide").css("display","block");

					}else{

						$(".depth2_div .bg_depth3").css("display","block");

					}

					//$(this).children("a").next().slideDown("fast");
				}

				//$(this).children("a").next().slideDown("fast");
			
		},
		function(){
			
				$(this).children("a").children("img").attr("src",$(this).children("a").children("img").attr("src").replace("_on","_off"));
				if ($(this).children("a").children("img").attr('src').toString().indexOf('m_d1_7_') != -1){
					$(this).children("a").removeClass("onwide");
				}else{
					$(this).children("a").removeClass("on");
				}
				if($(this).children("a").next().length > 0) {
					$(this).children("a").next().hide();
					if ($(this).children("a").children("img").attr('src').toString().indexOf('m_d1_7_') != -1){

						$(".depth2_div .bg_depth3Wide").css("display","none");
					}else{

						$(".depth2_div .bg_depth3").css("display","none");
					}
					//$(".depth2_div .bg_depth3").css("display","none");
					//$(this).children("a").next().slideUp("fast");
				}
				//$(this).children("a").next().slideUp("fast");
			
			}
		);
});//end ready

function popupOpen1(){
	
    var popUrl = "/micro/microMain.html";
    var popOption = "width=985px, height=625px, top=100, left=300, resizable=no, scrollbars=no, status=no, toolbar=no";    
    var pop = window.open(popUrl,"",popOption);
    
    if(pop){
    	pop.focus();
    }

    //통계자료
    dcsMultiTrack('DCS.dcssip','www.cuinfo.net','DCS.dcsuri','/micro/microMain.html','DCS.qri','','WT.ti','Offsite Link - 체험관','WT.sp','micro');
}

function showAllMenu()
{
	if($("#sitemap").css("display") == "none")
		$("#sitemap").css("display","block");
	else
		$("#sitemap").css("display","none");
}

function viewDetail(courseId){

	$("#courseId").val(courseId);
	$("#form").attr("method","post");
	$("#form").attr("onsubmit","");
	$("#form").attr("action","/home/course/courseSearchView.sub.action?gnb=41");
	$("#form").submit();
	
}
function showWinlocation(sURL, wname, iWidth, iHeight)
{
     //스크린의 크기
    sw=screen.availWidth;
    sh=screen.availHeight;
    
    //열 창의 포지션
    px=(sw-iWidth)/2;
    py=(sh-iHeight)/2;

	var pop = window.open(sURL, wname, "width="+iWidth+",height="+iHeight+",left="+px+",top="+py+",resizable=yes,scrollbars=yes,location=yes");
	
	if(pop)
		pop.focus();
	
}

//검색
function headerSearch(page)
	{
		var day = new Date(); 
		var y = day.getYear(); 
		if(y<2000)y = y+1900; 
		var mon = day.getMonth() + 1; 
		var date = day.getDate();
		
		if(mon < 10)
			mon = "0" + mon;
		if(date < 10)
			date = "0" + date;
			
		
		var today = y + "" + (mon) + "" +date;
    	var headerText = $("#headerText").val();

		$("#currPage2").val(page);
		
    	//$("body").addClass("main");
    	var headerText = $("#headerText").val();
    	
    	if(headerText == "")
		{
    		alert("검색어를 입력 해주세요");
    		return;
		}
    	
    	//키워드 클릭 수 입력
    	
    	
   		jQuery.post('/home/search/keyword_save.json', 
   				{keyword:headerText,regDT:today}, 
   				function(data) {
   					
   		});
    	/*
   		jQuery.post('/home/search/combineSearch.ajax.action', 
   				$("#headerForm").formSerialize(), 
   				function(data) {
           			$("#container").html(data);
           			//searchGubn 값에 따라 show,hide
           			var searchGubn = $("#searchGubn").val();
           			$("#searchText").text($("#headerText").val());
           			tabClick(searchGubn);
           			$("#searchGubn2").val(searchGubn);
           			document.location.href = "#header";
           			
           			
           			var sort = $("#sort").val();
           			if(sort == "regDate" || sort == ""){
           		    	$(".f_right a:even").attr("class","on");
           		    	$(".f_right a:odd").attr("class","");
           	    	}
           			else{
           		    	$(".f_right a:even").attr("class","");
           		    	$(".f_right a:odd").attr("class","on");
           	    	}
   		});
   		*/
   		//onsubmit 속성을 비워주어야 submit이 된다.
		$("#headerForm").attr("method","post");
		$("#headerForm").attr("onsubmit","");
		$("#headerForm").attr("action","/home/search/combineSearch.search.action");
		$("#headerForm").submit();
	}
	
	
//about cuinfo 팝업
function popAboutCuinfo(){
	var aboutCuinfo = window.open("/home/aboutCuinfo.html","","width=746,height=615,toolbar=no,location=no");
	
	if(aboutCuinfo)
		aboutCuinfo.focus();
}
	
//about kocu 팝업
function popAboutKcou(){
	var aboutKcou = window.open("/home/aboutKcou.html","","width=810,height=615,toolbar=no,location=no,scrollbars=yes");
	
	if(aboutKcou)
		aboutKcou.focus();
}




function getBrowserType(){
	 var agt = navigator.userAgent.toLowerCase();
	 if (agt.indexOf("chrome") != -1) return 'Chrome'; 
	 if (agt.indexOf("opera") != -1) return 'Opera'; 
	 if (agt.indexOf("staroffice") != -1) return 'Star Office'; 
	 if (agt.indexOf("webtv") != -1) return 'WebTV'; 
	 if (agt.indexOf("beonex") != -1) return 'Beonex'; 
	 if (agt.indexOf("chimera") != -1) return 'Chimera'; 
	 if (agt.indexOf("netpositive") != -1) return 'NetPositive'; 
	 if (agt.indexOf("phoenix") != -1) return 'Phoenix'; 
	 if (agt.indexOf("firefox") != -1) return 'Firefox'; 
	 if (agt.indexOf("safari") != -1) return 'Safari'; 
	 if (agt.indexOf("skipstone") != -1) return 'SkipStone'; 
	 if (agt.indexOf("msie") != -1) return 'Internet Explorer';
	 if (agt.indexOf("rv:11.0") != -1) return 'Internet Explorer';
	 if (agt.indexOf("netscape") != -1) return 'Netscape'; 
	 if (agt.indexOf("mozilla/5.0") != -1) return 'Mozilla'; 
}

</script>
</head>
<body>
<div id="right_bg"></div>
<div style="position: relative; width: 1000px; margin: 0 auto; background: #303030;"><a href="/home"><img src="/home/images2/common/tab1_on.gif"/></a><a href="/home/index2.main2.action"><img src="/home/images2/common/tab2_off.gif"/></a></div>

<div id="wrap">
			
	 <div class="right_bg_gr"></div>
	<!-- gnb -->
    <div id="leftgnb">
    	<!-- 1depth menu -->
    	<h1><a href="/home"><img src="/home/images2/common/gnb/h1_logo.png" alt="사이버대학 종합정보 CUinfo" /></a></h1>
        
        <ul class="ul_depth1">
        	<li ><a href="<%=PageUrl11%>"><img src="/home/images2/common/gnb/gnb1.png" alt="사이버대학 안내" /></a></li>
            <li ><a href="<%=PageUrl211%>"><img src="/home/images2/common/gnb/gnb2.png" alt="입학안내" /></a></li>
            <li> <a href="<%=PageUrl322%>"><img src="/home/images2/common/gnb/gnb3.png" alt="교과과정" /></a></li>
            <li> <a href="<%=PageUrl41%>"><img src="/home/images2/common/gnb/gnb4.png" alt="강의 검색" /></a></li>
            <li> <a href="<%=PageUrl51%>"><img src="/home/images2/common/gnb/gnb5.png" alt="정보 자료실" /></a></li>
        </ul>
        
        <div class="search">
        	<form id="headerForm" name="headerForm" action="#" onsubmit="try{headerSearch();}catch(e){alert(e);}return false;"><!-- box_type01 Start -->
	
			<input type="hidden" id="showCnt2" name="showCnt2" value="10" /> 
			<input type="hidden" id="currPage2" name="currPage2" value="1" /> 
			<input type="hidden" id="tabNo" name="tabNo" value="1" /> 
			<input type="hidden" id="sort" name="sort" value="" /> 
			<input type="hidden" id="order" name="order" value="0" /> 
			<input type="hidden" id="searchGubn2" name="searchGubn2" value="0" />
			<input type="hidden" id="searchGubn" name="searchGubn" value="0" />
            	<fieldset class="hdd">검색</fieldset>
                <input type="text" class="keyword" value="SEARCH" id="headerText" name="headerText" onfocus="if(this.value == 'SEARCH') this.value=''"/><input type="image" src="/home/images2/common/search_btn.gif" onclick="javascript:headerSearch();"/>
            </form>
            <a href="javascript:popAboutCuinfo();" class="first"><img src="/home/images2/common/txt_about.png" alt="ABOUT CUINFO" /></a>
            <a href="javascript:popAboutKcou()"><img src="/home/images2/common/txt_kcou.png" alt="유관기관업무협약" /></a>
<%--             <a href="<%=PageUrl114%>"><img src="/home/images2/common/txt_cyber.png" alt="사이버대학연혁" /></a> --%>
            <a href="javascript:showAllMenu();"><img src="/home/images2/common/txt_all.png" alt="전체메뉴" /></a>
            <a href="javascript:bookmark();"><img src="/home/images2/common/txt_bookmark.png" alt="즐겨찾기" /></a>
        </div>
        <!-- 1depth menu -->
        
        <!-- 2depth menu -->
        <div class="depth2_div" style="opacity:0.8;">
        	<div class="arrow"><img src="/home/images2/common/gnb/img_arrow.png" alt=""/></div>
            
            <ul class="sub0">
                <li><a href="<%=PageUrl11%>"><img src="/home/images2/common/gnb/m_d1_1_0_off.png" alt="사이버대학이란?"/></a>
                	<ul>
                        <li><a href="<%=PageUrl11%>"><img src="/home/images2/common/gnb/m_d1_1_1_off.png" alt="소개 및 특징"/></a></li>
                        <li><a href="<%=PageUrl112%>"><img src="/home/images2/common/gnb/m_d1_1_2_off.png" alt="학기 및 수업 안내"/></a></li>
                        <li><a href="<%=PageUrl114%>"><img src="/home/images2/common/gnb/m_d1_1_3_off.png" alt="연혁"/></a></li>
                    </ul>
                </li>
                <li><a href="<%=PageUrl12%>"><img src="/home/images2/common/gnb/m_d1_2_0_off.png" alt="대학 소개"/></a></li>
                
                <li><a href="<%=PageUrl131%>"><img src="/home/images2/common/gnb/m_d1_4_0_off.png" alt="학위취득/국가자격증"/></a>
                	<ul>
                        <li><a href="<%=PageUrl131%>"><img src="/home/images2/common/gnb/m_d1_4_1_off.png" alt="사회복지사"/></a></li>
                        <li><a href="<%=PageUrl132%>"><img src="/home/images2/common/gnb/m_d1_4_2_off.png" alt="보육교사"/></a></li>
                        <li><a href="<%=PageUrl133%>"><img src="/home/images2/common/gnb/m_d1_4_3_off.png" alt="평생교육사"/></a></li>
                    </ul>
                </li>
                <li><a href="<%=PageUrl141%>"><img src="/home/images2/common/gnb/m_d1_5_0_off.png" alt="진학가이드"/></a>
                    <ul>
                        <li><a href="<%=PageUrl141%>"><img src="/home/images2/common/gnb/m_d1_5_1_off.png" alt="나의 전형 미리보기"/></a></li>
                        <li><a href="<%=PageUrl142%>"><img src="/home/images2/common/gnb/m_d1_5_2_off.png" alt="대학별 문의"/></a></li>
                    </ul>
                </li>
                <li><a href="<%=PageUrl15%>"><img src="/home/images2/common/gnb/m_d1_6_0_off.png" alt="성공수기"/></a></li>
                <li><a href="<%=PageUrl16%>"><img src="/home/images2/common/gnb/m_d1_7_0_off.png" alt="교육부지원사업"/></a>
                	<ul>
                        <li><a href="<%=PageUrl163%>"><img src="/home/images2/common/gnb/m_d1_7_6_off.png" alt="우수사례"/></a></li>
                        <li><a href="<%=PageUrl161%>"><img src="/home/images2/common/gnb/m_d1_7_3_off.png" alt="2014"/></a></li>
                        <li><a href="<%=PageUrl162%>"><img src="/home/images2/common/gnb/m_d1_7_4_off.png" alt="2012~2013"/></a></li>
						<%-- 2019.03.25 추가 - jsyoon 요청자 : 한상훈 --%>
						<li><a href="<%=PageUrl164%>"><img src="/home/images2/common/gnb/m_d1_7_7_off.png" alt="교육부 지원사업(2018) 성인 학습자 역량 강화 교육콘텐츠 개발 사업"/></a></li>

                    </ul>
                </li>
            </ul>
            
             <ul class="sub1">
                <li><a href="<%=PageUrl211%>"><img src="/home/images2/common/gnb/m_d2_1_0_off.png" alt="입학 구분 및 절차"/></a>
                	<ul>
                        <li><a href="<%=PageUrl211%>"><img src="/home/images2/common/gnb/m_d2_1_1_off.png" alt="신입학/편입학 안내"/></a></li>
                        <li><a href="<%=PageUrl212%>"><img src="/home/images2/common/gnb/m_d2_1_2_off.png" alt="시간제 등록 안내"/></a></li>
                    </ul>
                </li>
                <li><a href="<%=PageUrl22%>"><img src="/home/images2/common/gnb/m_d2_2_0_off.png" alt="모집요강"/></a></li>
                <li><a href="<%=PageUrl23%>"><img src="/home/images2/common/gnb/m_d2_3_0_off.png" alt="대학 정보 현황"/></a></li>
            </ul>
            
            <ul class="sub2">
                <!--  <li><a href="<%=PageUrl31%>"><img src="/home/images2/common/gnb/m_d3_1_0_off.png" alt="교과과정 보기"/></a></li>-->
                <li><a href="<%=PageUrl322%>"><img src="/home/images2/common/gnb/m_d3_11_0_off.png" alt="대학별 학과/교과과정"/></a></li>
                <li><a href="<%=PageUrl32%>"><img src="/home/images2/common/gnb/m_d3_12_0_off.png" alt="분야별 학과/교과과정"/></a></li>
                <li><a href="<%=PageUrl31%>"><img src="/home/images2/common/gnb/m_d3_13_0_off.png" alt="전체 학과/교과과정"/></a></li>
                <li><a href="<%=PageUrl33%>"><img src="/home/images2/common/gnb/m_d3_3_0_off.png" alt="전체학과검색"/></a></li>
                <!--<li><a href="<%=PageUrl32%>"><img src="/home/images2/common/gnb/m_d3_2_0_off.png" alt="학과 정보"/></a>
                	<ul>
                        <li><a href="<%=PageUrl32%>"><img src="/home/images2/common/gnb/m_d3_2_1_off.png" alt="학과 내비게이션"/></a></li>
                        <li><a href="<%=PageUrl322%>"><img src="/home/images2/common/gnb/m_d3_2_2_off.png" alt="학과 개설 현황"/></a></li>
                    </ul>
                </li>
                <li><a href="<%=PageUrl33%>"><img src="/home/images2/common/gnb/m_d3_3_0_off.png" alt="전체학과검색"/></a></li>-->
            </ul> 
            
            <ul class="sub3">
                <li><a href="<%=PageUrl41%>"><img src="/home/images2/common/gnb/m_d4_1_0_off.png" alt="강의명 검색"/></a></li>
                <li><a href="<%=PageUrl42%>"><img src="/home/images2/common/gnb/m_d4_2_0_off.png" alt="학과분야별 검색"/></a></li>
                <li><a href="<%=PageUrl43%>"><img src="/home/images2/common/gnb/m_d4_3_0_off.png" alt="학교별 검색"/></a></li>
                <li><a href="<%=PageUrl44%>"><img src="/home/images2/common/gnb/m_d4_4_0_off.png" alt="학교별 강의 맛보기"/></a></li>
                <li><a href="<%=PageUrl45%>"><img src="/home/images2/common/gnb/m_d4_5_0_off.png" alt="공개강의"/></a></li>
            </ul>
            
            <ul class="sub4">
                <li><a href="<%=PageUrl51%>"><img src="/home/images2/common/gnb/m_d5_1_0_off.png" alt="연구/교육 자료"/></a></li>
                <li><a href="<%=PageUrl52%>"><img src="/home/images2/common/gnb/m_d5_2_0_off.png" alt="사이버대학 뉴스"/></a></li>
                <li><a href="<%=PageUrl53%>"><img src="/home/images2/common/gnb/m_d5_3_0_off.png" alt="공지사항"/></a></li>
                <li><a href="<%=PageUrl54%>"><img src="/home/images2/common/gnb/m_d5_4_0_off.png" alt="자주 묻는 질문"/></a></li>
                <li><a href="<%=PageUrl55%>"><img src="/home/images2/common/gnb/m_d5_5_0_off.png" alt="사이버대학 통계"/></a></li>
            </ul>
            
            <div class="bg_depth3"></div>
			<div class="bg_depth3Wide"></div>
            
        </div>
        <!-- //2depth menu -->
        
        <!-- 사이버 대학 메뉴 -->
        <div class="cyber_gnb">
        	<div class="cyber_menu_div">
                <h2><a href="#"><img src="/home/images2/common/gnb/h2_txt1.png" alt="우리는 사이버세계로 대학간다" /></a></h2>
                <ul class="cyber_ul">
                    <li style="display: none;"><a href="http://www.kycu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_1.png" alt="건양사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.khcu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_2.png" alt="경희사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.cuk.edu" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_3.png" alt="고려사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.gcu.ac/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_4.png" alt="국제사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.global.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_5.png" alt="글로벌사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.dcu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_6.png" alt="대구사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.scau.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_N01.png" alt="디지털서울문예대학교"/></a></li>
					<li style="display: none;"><a href="http://www.bdu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_9.png" alt="부산디지털대학교"/></a></li>
					<li style="display: none;"><a href="http://www.cufs.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_N02.png" alt="사이버한국외국어대학교"/></a></li>
					<li style="display: none;"><a href="http://www.sdu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_11.png" alt="서울디지털대학교"/></a></li>
					<li style="display: none;"><a href="http://www.iscu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_12.png" alt="서울사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.world.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_N03.png" alt="세계사이버대학"/></a></li>
					<li style="display: none;"><a href="http://portal.sjcu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_13.png" alt="세종사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.kcu.ac/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_14.png" alt="숭실사이버대학교"/></a></li>
					
					<li style="display: none;"><a href="http://www.yncu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_N04.png" alt="영남사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.ycc.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_N05.png" alt="영진사이버대학"/></a></li>
					<li style="display: none;"><a href="http://www.wdu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_18.png" alt="원광디지털대학교"/></a></li>
					<li style="display: none;"><a href="http://www.corea.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_N06.png" alt="한국복지사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.ocu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_15.png" alt="열린사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.hycu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_20.png" alt="한양사이버대학교"/></a></li>
					<li style="display: none;"><a href="http://www.hscu.ac.kr/" target="_blank"><img height="50%" src="/home/images2/common/gnb/m_cy_21.png" alt="화신사이버대학교"/></a></li>
                </ul>
            </div>
        
       		<div class="btn"><a href="#"><img src="/home/images2/common/gnb/btn_cyber.png" alt="사이버 대학" /></a></div>
            
        </div>
        <!-- //사이버 대학 메뉴 -->
        
    </div>
    <!-- //gnb -->
    
    <!-- contents -->
    	  	
           <decorator:body />
            
            
            
           
    <div id="sitemap" style="display:none;">
	<a href="javascript:showAllMenu();" class="_sitemap_close"><img alt="닫기" src="/home/images/new/btn_close.png" /></a>
	<ul><!-- sitemap Start -->
		<li id="sitemap1" class="<%=GnbOn1%>">
			<span><%=GnbName1%></span>
			<div id="gnb_sub1">
				<a class="<%=SnbOn11%>" href="<%=PageUrl11%>"><%=SnbNmae11%></a>
				<div class="sitemap_sub">
					<a href="<%=PageUrl111 %>"><%=SnbNmae111%></a>
					<a href="<%=PageUrl112 %>"><%=SnbNmae112%></a>
					<a href="<%=PageUrl114 %>"><%=SnbNmae114%></a>  
<%-- 					<a href="<%=PageUrl113 %>"><%=SnbNmae113%></a> --%>
				</div>
				<a class="<%=SnbOn12%>" href="<%=PageUrl12%>"><%=SnbNmae12%></a> 
				
				<a class="<%=SnbOn13%>" href="<%=PageUrl13%>"><%=SnbNmae13%></a>
				<div class="sitemap_sub">
					<a href="<%=PageUrl131 %>"><%=SnbNmae131%></a> 
					<a href="<%=PageUrl132 %>"><%=SnbNmae132%></a> 
					<a href="<%=PageUrl133 %>"><%=SnbNmae133%></a> 
					<%-- <a href="<%=PageUrl134 %>"><%=SnbNmae134%></a>--%>
				</div>
				<a class="<%=SnbOn14%>" href="<%=PageUrl14%>"><%=SnbNmae14%></a> 
				<div class="sitemap_sub">
					<a href="<%=PageUrl141 %>"><%=SnbNmae141%></a> 
					<a href="<%=PageUrl142 %>"><%=SnbNmae142%></a>
				</div>
				<a class="<%=SnbOn15%>" href="<%=PageUrl15%>"><%=SnbNmae15%></a>
				<a class="<%=SnbOn16%>" href="<%=PageUrl16%>"><%=SnbNmae16%></a>
					<div class="sitemap_sub">
						<a href="<%=PageUrl163 %>"><%=SnbNmae163%></a> 
						<a href="<%=PageUrl161 %>"><%=SnbNmae161%></a> 
						<a href="<%=PageUrl162 %>"><%=SnbNmae162%></a>
						<a href="<%=PageUrl162 %>"><%=SnbNmae164%></a>
					</div>
			</div>
		</li>
		<li id="sitemap2" class="<%=GnbOn2%>">
			<span><%=GnbName2%></span>
			<div id="gnb_sub2">
				<a class="<%=SnbOn21%>" href="<%=PageUrl21%>"><%=SnbNmae21%></a>
				<div class="sitemap_sub">
					<a href="<%=PageUrl211 %>"><%=SnbNmae211%></a> 
					<a href="<%=PageUrl212 %>"><%=SnbNmae212%></a>
				</div>
				<a class="<%=SnbOn22%>" href="<%=PageUrl22%>"><%=SnbNmae22%></a> 
				<a class="<%=SnbOn23%>" href="<%=PageUrl23%>"><%=SnbNmae23%></a>
			</div>
		</li>
		<li id="sitemap3" class="<%=GnbOn3%>">
			<span><%=GnbName3%></span>
			<div id="gnb_sub3">
				<a class="<%=SnbOn31%>" href="<%=PageUrl322%>"><%=SnbNmae31%></a> 
				<a class="<%=SnbOn32%>" href="<%=PageUrl32%>"><%=SnbNmae32%></a>
				<a class="<%=SnbOn33%>" href="<%=PageUrl31%>"><%=SnbNmae33%></a>
				<a class="<%=SnbOn34%>" href="<%=PageUrl33%>"><%=SnbNmae34%></a>
			</div>
		</li>
		
		<li id="sitemap4" class="<%=GnbOn4%>">
			<span><%=GnbName4%></span>
			<div id="gnb_sub3">
				<a class="<%=SnbOn41%>" href="<%=PageUrl41%>"><%=SnbNmae41%></a>
				<a class="<%=SnbOn42%>" href="<%=PageUrl42%>"><%=SnbNmae42%></a>
				<a class="<%=SnbOn43%>" href="<%=PageUrl43%>"><%=SnbNmae43%></a>
				<a class="<%=SnbOn44%>" href="<%=PageUrl44%>"><%=SnbNmae44%></a>
				<a class="<%=SnbOn45%>" href="<%=PageUrl45%>"><%=SnbNmae45%></a>
			</div>
		</li>
		<li id="sitemap5" class="<%=GnbOn5%>">
			<span><%=GnbName5%></span>
			<div id="gnb_sub4">
				<a class="<%=SnbOn51%>" href="<%=PageUrl51%>"><%=SnbNmae51%></a>
				<a class="<%=SnbOn52%>" href="<%=PageUrl52%>"><%=SnbNmae52%></a>
				<a class="<%=SnbOn53%>" href="<%=PageUrl53%>"><%=SnbNmae53%></a>
				<a class="<%=SnbOn54%>" href="<%=PageUrl54%>"><%=SnbNmae54%></a>
				<a class="<%=SnbOn55%>" href="<%=PageUrl55%>"><%=SnbNmae55%></a>
				<div class="sitemap_sub">
					<a href="<%=PageUrl551%>"><%=SnbNmae551%></a>
					<a href="<%=PageUrl552%>"><%=SnbNmae552%></a>
					<a href="<%=PageUrl553%>"><%=SnbNmae553%></a>
					<a href="<%=PageUrl554%>"><%=SnbNmae554%></a>
					<a href="<%=PageUrl555%>"><%=SnbNmae555%></a>
					<a href="<%=PageUrl556%>"><%=SnbNmae556%></a>
					<a href="<%=PageUrl557%>">학년도별 원격대학 총<br />졸업생수</a>
					<a href="<%=PageUrl558%>"><%=SnbNmae558%></a>
					<a href="<%=PageUrl559%>"><%=SnbNmae559%></a>
					<a href="<%=PageUrl5510%>"><%=SnbNmae5510%></a>
				</div>
			</div>
		</li>
	</ul><!-- sitemap End -->
</div>
</div>
</body>
</html>









