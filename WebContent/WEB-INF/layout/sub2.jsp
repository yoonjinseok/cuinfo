<%@page contentType="text/html;charset=utf-8"%>
<%@page import="com.cyberup.framework.model.SessionLoginInfo"%>
<%@page import="com.cyberup.framework.model.LoginInfo"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<%

String gnb = request.getParameter("gnb");
String pattern = "^[0-9]*$";
System.out.println("gnb.matches(pattern) = " + !gnb.matches(pattern));
if(!gnb.matches(pattern)){
	out.print("<script>alert('비정상적인 접근 방법입니다.\n이전화면으로 이동합니다.');</script>");
	out.print("<script>history.back();</script>");
}
	
	
String URL = "/home";
String BodyType = "";

String GnbOn1  	= ""; String GnbOn2   = "";	String GnbOn3 	= ""; String GnbOn4  = ""; String GnbOn5	=	""; String GnbOn6 =	"";
String SnbOn11 	= ""; String SnbOn111 = ""; String SnbOn112 = ""; String SnbOn113 = ""; String SnbOn114 = "";
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
String SnbOn56 ="";
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
String GnbName1   = "사이버대학원안내";
//1.사이버대학이란?
String SnbNmae11  = "사이버대학원이란?";		String PageUrl11  = "/home/intro/summaryGrad.sub2.action?gnb=11";
String SnbNmae111 = "소개 및 특징";		String PageUrl111 = "/home/intro/summaryGrad.sub2.action?gnb=111";
String SnbNmae112 = "학기 및 수업 안내";	String PageUrl112 = "/home/intro/guideGrad.sub2.action?gnb=112";

//2.대학소개

String SnbNmae121  = "대학원 소개";		String PageUrl121  = "/home/intro/overallGraduate.sub2.action?gnb=121";
//3.학위치득/국가자격증
String SnbNmae13  = "화상세미나안내";	String PageUrl13  = "/home/intro/seminarGrad.sub2.action?gnb=13";

//4.진학가이드
String SnbNmae14  = "사이버 논문 지도";			String PageUrl14  = "/home/intro/cyberPaperGrad.sub2.action?gnb=14";
String SnbNmae141 = "나의 전형 미리보기";	String PageUrl141 = "/home/intro/serviceGuide.sub2.action?gnb=141";
String SnbNmae142 = "대학별 문의";			String PageUrl142 = "/home/intro/serviceQuestion.sub2.action?gnb=142";
//5.성공수기
String SnbNmae15  = "성공수기";			String PageUrl15  = "/home/intro/successStory.sub2.action?gnb=15";
//6.교육부지원 사업
String SnbNmae16  = "교육부지원사업";			String PageUrl16  = "/home/intro/characterization.sub2.action?gnb=16";
String SnbNmae161  = "NSC기반 교육과정개편";	String PageUrl161  = "/home/intro/characterization2014.sub2.action?gnb=161";
String SnbNmae162  = "선취업·후진학 지원";		String PageUrl162  = "/home/intro/characterization.sub2.action?gnb=162";
//String SnbNmae163 = "사업 성과물";			String PageUrl163  = "/home/intro/characterizationResult.sub2.action?gnb=163";


if((Integer.toString(cate_int).substring(0,1).equals("1"))){	 
	MainTitle="사이버대학원안내";		GnbOn1 = "on" ;	Category = "/home/intro/summaryGrad.sub2.action?gnb=11"; PageClass = "sub_intro";
}

if(cate_int == 11) {SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn111="on"; PageUrl = "/home/intro/summaryGrad.sub2.action?gnb=11";	}
if(cate_int == 111){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn111="on"; PageUrl = "/home/intro/summaryGrad.sub2.action?gnb=111";	}
if(cate_int == 112){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn112="on"; PageUrl = "/home/intro/guideGrad.sub2.action?gnb=112";	}
if(cate_int == 113){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn113="on"; PageUrl = "/home/intro/guideTime.sub2.action?gnb=113";	}
if(cate_int == 114){SubTitle="사이버대학이란?";		TitleImg="title1";	SnbOn11="on"; SnbOn113="on"; PageUrl = "/home/intro/yearHistory.sub2.action?gnb=114";	}
if(cate_int == 12) {SubTitle="대학 소개";				TitleImg="title2";	SnbOn12="on";				 PageUrl = "/home/intro/overall.sub2.action?gnb=12";	}
if(cate_int == 121){SubTitle="대학원 소개";			TitleImg="title2";	SnbOn121="on";				 PageUrl = "/home/intro/overallGraduate.sub2.action?gnb=121";	}
if(cate_int == 13) {SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn131="on"; PageUrl = "/home/intro/certificate1.sub2.action?gnb=131";	}
if(cate_int == 131){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn131="on"; PageUrl = "/home/intro/certificate1.sub2.action?gnb=131";	}
if(cate_int == 132){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn132="on"; PageUrl = "/home/intro/certificate2.sub2.action?gnb=132";	}
if(cate_int == 133){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn133="on"; PageUrl = "/home/intro/certificate3.sub2.action?gnb=133";	}
if(cate_int == 134){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn134="on"; PageUrl = "/home/intro/certificate4.sub2.action?gnb=134";	}
if(cate_int == 135){SubTitle="학위취득/국가자격증";	TitleImg="title3";	SnbOn13="on"; SnbOn135="on"; PageUrl = "/home/intro/certificate_subjectInfo.sub2.action?gnb=135";	}
if(cate_int == 14) {SubTitle="진학가이드";			TitleImg="title4";	SnbOn14="on"; SnbOn141="on"; PageUrl = "/home/intro/serviceGuide.sub2.action?gnb=14";     	}
if(cate_int == 141){SubTitle="진학가이드";			TitleImg="title4";	SnbOn14="on"; SnbOn141="on"; PageUrl = "/home/intro/serviceGuide.sub2.action?gnb=141";     	}
if(cate_int == 142){SubTitle="진학가이드";			TitleImg="title4";	SnbOn14="on"; SnbOn142="on"; PageUrl = "/home/intro/serviceQuestion.sub2.action?gnb=142";     	}
if(cate_int == 15) {SubTitle="성공수기";				TitleImg="title5";	SnbOn15="on"; PageUrl = "/home/intro/successStory.sub2.action?gnb=15";}
if(cate_int == 16) {SubTitle="교육부지원사업";			TitleImg="title6";	SnbOn16="on"; PageUrl = "/home/intro/characterization.sub2.action?gnb=16";}
if(cate_int == 161) {SubTitle="교육부지원사업";			TitleImg="title6";	SnbOn16="on"; SnbOn161="on"; PageUrl = "/home/intro/characterization2014.sub2.action?gnb=161";}
if(cate_int == 162) {SubTitle="교육부지원사업";			TitleImg="title6";	SnbOn16="on"; SnbOn162="on"; PageUrl = "/home/intro/characterization.sub2.action?gnb=162";}


/************************************************************************************************************/
//입학안내
String GnbName2   = "입학안내";
//1.입학 구분 및 절차
String SnbNmae21  = "입학 구분 및 절차";				String PageUrl21  = "/home/entr/enterStep_New.sub2.action?gnb=211";
String SnbNmae211 = "신입학/편입학 안내";				String PageUrl211 = "/home/entr/enterStep_New.sub2.action?gnb=211";
String SnbNmae212 = "시간제 등록 안내";					String PageUrl212 = "/home/entr/enterStep_Time.sub2.action?gnb=212";
//2.모집요강
String SnbNmae22  = "모집요강";					String PageUrl22  = "/home/entr/enterGuide2.sub2.action?gnb=22";
//3.대학원 정보현황
String SnbNmae23  = "대학원 정보 현황";				String PageUrl23  = "/home/entr/univStats2.sub2.action?gnb=23";

if((Integer.toString(cate_int).substring(0,1).equals("2"))){		
	MainTitle="입학안내";	GnbOn2 = "on" ;	Category = "/home/entr/enterStep_New.sub2.action?gnb=21"; PageClass = "sub_entr";
}
if(cate_int == 21) {SubTitle="입학 구분 및 절차";		TitleImg="title1";	SnbOn21="on"; SnbOn211="on"; PageUrl = "/home/entr/enterStep_New.sub2.action?gnb=211";		}
if(cate_int == 211){SubTitle="입학 구분 및 절차";		TitleImg="title1";	SnbOn21="on"; SnbOn211="on"; PageUrl = "/home/entr/enterStep_New.sub2.action?gnb=211";		}
if(cate_int == 212){SubTitle="입학 구분 및 절차";		TitleImg="title1";	SnbOn21="on"; SnbOn212="on"; PageUrl = "/home/entr/enterStep_Time.sub2.action?gnb=212";		}
if(cate_int == 22) {SubTitle="모집요강";			TitleImg="title2";	SnbOn22="on";				 PageUrl = "/home/entr/enterGuide.sub2.action?gnb=22";		}
if(cate_int == 23) {SubTitle="대학 정보 현황";		TitleImg="title3";	SnbOn23="on";				 PageUrl = "/home/entr/univStats2.sub2.action?gnb=23";		}


/************************************************************************************************************/
//교과과정
String GnbName3		= "교과과정";
//1.교과과정보기
String SnbNmae31  	= "교과과정 보기";				String PageUrl31	= "/home/curri/major2.sub2.action?gnb=31";
//2.학과정보
String SnbNmae32  	= "분야별 학과/교과과정";			String PageUrl32	= "/home/curri/navigationMajorAreaGrad.sub2.action?gnb=32";
String SnbNmae321  	= "학과 내비게이션";			String PageUrl321	= "/home/curri/navigationMajorAreaGrad.sub2.action?gnb=321";
String SnbNmae322  	= "학과 개설 현황";			String PageUrl322	= "/home/curri/major2.sub2.action?gnb=322";
//3.전체학과검색
String SnbNmae33  	= "전체교과과정";				String PageUrl33	= "/home/curri/searchMajor.sub2.action?gnb=33";
String SnbNmae34  	= "전체학과검색";				String PageUrl34	= "/home/curri/searchMajor.sub2.action?gnb=34";

if((Integer.toString(cate_int).substring(0,1).equals("3"))){
	MainTitle="교과과정";		GnbOn3 ="on" ;	Category = "/home/intro/summary.sub2.action?gnb=31"; PageClass = "sub_curri";
}
if(cate_int == 31) {SubTitle="교과과정 보기";		TitleImg="title1";	SnbOn31="on"; PageUrl = "/home/curri/curriculum.sub2.action?gnb=31";	}
if(cate_int == 32) {SubTitle="학과정보";	TitleImg="title3";	SnbOn32="on"; PageUrl = "/home/curri/navigationMajorAreaGrad.sub2.action?gnb=32"; SnbOn321="on";}
if(cate_int == 321){SubTitle="학과 내비게이션";	TitleImg="title3";	SnbOn32="on"; PageUrl = "/home/curri/navigationMajorAreaGrad.sub2.action?gnb=321"; SnbOn321="on";}
if(cate_int == 322){SubTitle="학과 개설 현황";		TitleImg="title3";	SnbOn32="on"; PageUrl = "/home/curri/major.sub2.action?gnb=322";	SnbOn322="on";}
if(cate_int == 33) {SubTitle="전체학과검색";		TitleImg="title3";	SnbOn33="on"; PageUrl = "/home/curri/major.sub2.action?gnb=33";	}
if(cate_int == 34) {SubTitle="전체학과검색";		TitleImg="title3";	SnbOn33="on"; PageUrl = "/home/curri/major.sub2.action?gnb=33";	}


/************************************************************************************************************/
//강의검색
String GnbName4   = "강의검색";
//1.강의명 검색
String SnbNmae41  = "강의명 검색";					String PageUrl41  = "/home/course/courseSearch2.sub2.action?gnb=41&pageType=1";
//2.학과분야별 검색
//String SnbNmae42  = "학과분야별 검색";					String PageUrl42  = "/home/course/searchByMajorArea.sub2.action?gnb=42&pageType=2";
String SnbNmae42  = "학과분야별 검색";					String PageUrl42  = "/home/course/courseSearch2.sub2.action?gnb=42&pageType=2";
//3.학교별 검색
//String SnbNmae43  = "학교별 검색";					String PageUrl43  = "/home/course/searchByUniv.sub2.action?gnb=43&pageType=3";
String SnbNmae43  = "대학원별 검색";					String PageUrl43  = "/home/course/courseSearch2.sub2.action?gnb=43&pageType=3";
//4.학교별 강의 맛보기
String SnbNmae44  = "대학원별 강의 맛보기";			String PageUrl44  = "/home/course/sampleCourse2.sub2.action?gnb=44";
//5.공개강의
String SnbNmae45  = "공개강의";					String PageUrl45  = "/home/course/publicCourse.sub2.action?gnb=45";


if((Integer.toString(cate_int).substring(0,1).equals("4"))){
	MainTitle="강의검색";		GnbOn4 = "on" ;	Category = "/home/course/courseSearch2.sub2.action?gnb=41"; PageClass = "sub_course";
}
if(cate_int == 41) {SubTitle="강의명 검색";		TitleImg="title1";	SnbOn41="on";				 PageUrl = "/home/course/courseSearch2.sub2.action?gnb=41";		}
if(cate_int == 42) {SubTitle="학과분야별 검색";	TitleImg="title2";	SnbOn42="on";				 PageUrl = "/home/course/searchByMajorArea.sub2.action?gnb=42";	}
if(cate_int == 43) {SubTitle="학교별 검색";		TitleImg="title3";	SnbOn43="on";				 PageUrl = "/home/course/searchByUniv.sub2.action?gnb=43";		}
if(cate_int == 44) {SubTitle="학교별 강의 맛보기";	TitleImg="title4";	SnbOn44="on";				 PageUrl = "/home/course/searchByUniv.sub2.action?gnb=44";		}
if(cate_int == 45) {SubTitle="공개강의";			TitleImg="title5";	SnbOn45="on";				 PageUrl = "/home/course/searchByUniv.sub2.action?gnb=45";		}


/************************************************************************************************************/
//정보자료실
String GnbName5   = "정보자료실";
//연구/교육자료
String SnbNmae51  = "연구/교육 자료";				String PageUrl51  = "/home/refer/board.sub2.action?gnb=51&gID=153";
//사이버대학 뉴스
String SnbNmae52  = "사이버대학 뉴스";				String PageUrl52  = "/home/refer/boardNews.sub2.action?gnb=52";
//공지사항
String SnbNmae53  = "공지사항";					String PageUrl53  = "/home/refer/board.sub2.action?gnb=53&gID=154";
//자주하는 질문 답변
String SnbNmae54  = "자주 묻는 질문";			String PageUrl54  = "/home/refer/faq.sub2.action?gnb=54&gID=156";
//사이버대학 통계
String SnbNmae55  = "사이버대학원 통계";					String PageUrl55  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=univ&sttYear=2019";
String SnbNmae551  = "대학별 현황표";					String PageUrl551  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=univ&sttYear=2019";
String SnbNmae552  = "입학정원 현황";					String PageUrl552  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=entrancePro&sttYear=2019";
String SnbNmae553  = "입학정원 대비 등록률";			String PageUrl553  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=entrance&sttYear=2019";
String SnbNmae554  = "성별 등록생 비율";				String PageUrl554  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=sex&sttYear=2019";
String SnbNmae555  = "연령별 등록생 비율";				String PageUrl555  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=age&sttYear=2019";
String SnbNmae556  = "직업별 등록생 비율";				String PageUrl556  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=job&sttYear=2019";
String SnbNmae557  = "학년도별 원격대학 총 졸업생 수";	String PageUrl557  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=graduate&sttYear=2019";
String SnbNmae558  = "재학생수 현황";					String PageUrl558  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=student&sttYear=2019";
String SnbNmae559  = "시간제등록생 모집 결과";			String PageUrl559  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=time&sttYear=2019";
String SnbNmae5510  = "입학금 및 수업료 현황";			String PageUrl5510  = "/home/eudc/statistics2.sub2.action?gnb=55&gubun1=2&gubunNm=fee&sttYear=2019";

if((Integer.toString(cate_int).substring(0,1).equals("5"))){
	MainTitle="정보자료실";	GnbOn5 = "on" ;	Category = "/home/refer/board.sub2.action?gnb=51";PageClass = "sub_refer";
}
if(cate_int == 51) {SubTitle="연구/교육 자료";					TitleImg="title1";	SnbOn51="on";				 PageUrl = "/home/refer/board.sub2.action?gnb=51&gID=153";      	}
if(cate_int == 52) {SubTitle="사이버대학뉴스";				TitleImg="title2";	SnbOn52="on";				 PageUrl = "/home/refer/boardNews.sub2.action?gnb=52";     	}
if(cate_int == 53) {SubTitle="대학행사 안내";					TitleImg="title3";	SnbOn53="on";				 PageUrl = "/home/refer/boardUniv.sub2.action?gnb=53";     	}
if(cate_int == 54) {SubTitle="원격대학 협의회 동정";			TitleImg="title5";	SnbOn54="on";				 PageUrl = "/home/refer/board.sub2.action?gnb=55&gID=152";      	}
if(cate_int == 55) {SubTitle="공지사항";						TitleImg="title5";	SnbOn55="on";				 PageUrl = "/home/refer/board.sub2.action?gnb=55&gID=155";    	}
if(cate_int == 55) {SubTitle="자주 묻는 질문";				TitleImg="title7";	SnbOn55="on";				 PageUrl = "/home/refer/faq.sub2.action?gnb=54&gID=156";		}
if(cate_int == 55) {SubTitle="교과부통계";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55";		}
if(cate_int == 551){SubTitle="대학별 현황표";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=univ";		}
if(cate_int == 552){SubTitle="입학정원 현황";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=entrancePro";		}
if(cate_int == 553){SubTitle="입학정원 대비 등록률";			TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=entrance";		}
if(cate_int == 554){SubTitle="성별 등록생 비율";				TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=sex";		}
if(cate_int == 555){SubTitle="연령별 등록생 비율";				TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=age";		}
if(cate_int == 556){SubTitle="직업별 등록생 비율";				TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=job";		}
if(cate_int == 557){SubTitle="학년도별 원격대학 총 졸업생 수";	TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=graduate";		}
if(cate_int == 558){SubTitle="재학생수 현황";					TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=student";		}
if(cate_int == 559){SubTitle="시간제등록생 모집 결과";			TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=time";		}
if(cate_int ==5510){SubTitle="입학금 및 수업료 현황";			TitleImg="h3_edu_fac";	SnbOn55="on";			 PageUrl = "/home/eudc/statistics2.sub2.action?gnb=55&gubunNm=fee";		}

/************************************************************************************************************/



WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

LoginInfo loginInfo = (LoginInfo)session.getAttribute("sessionLoginInfo");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<link rel="SHORTCUT ICON" href="http://www.cuinfo.net/favicon.ico" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Description" content="CUinfo 사이버 대학 종합정보 서비스" />
<meta name="Keywords" content="사이버 대학, 사이버대학 포털, 사이버 대학 종합정보 서비스" />
<meta name="Author" content="KERIS" />
<title>CUinfo > <%=MainTitle %> > <decorator:title	default="사이버대학포탈" /></title>
<script type="text/javascript" language="javascript" src="/home/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery.fadeSliderToggle.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery.popupWindow.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/jquery.form.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/home/js/layout.js"></script>
<script type="text/javascript" language="javascript" src="/home/mediaplayer/jwplayer.js"></script>
<script type="text/javascript" language="javascript" src="/home/mediaplayer/swfobject.js"></script>

<script type="text/javascript" src="/home/js/jquery.galleriffic.js"></script>
<script type="text/javascript" src="/home/js/jquery.opacityrollover.js"></script>
<script type="text/javascript" src="/home/js/jquery-ui.min-1.8.js"></script>

<!-- 웹트렌즈 -->
<script language="vbscript" 	src="/home/js/urldecode.vbs"></script>
<script language="javascript" 	src="/home/js/cuinfo.net.js"></script>
<link rel="stylesheet" type="text/css" href="/home/css2/main2.css" />

<link rel="stylesheet" type="text/css" href="/home/css/layout.css" />


<script type="text/javascript" language="javascript">
$(document).ready(function() {
	//안드로이드일 경우 depth2 의 링크를 없앤다.
	var appVer = navigator.appVersion;
	
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
			$(".cyber_gnb").css({"width":"5px"});
			$(".cyber_gnb .btn").css({"left":"5px"});
			$(".cyber_gnb .cyber_menu_div").hide();
			$(".cyber_ul li").hide();
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
		alert("11");
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

	$(".depth2_div ul li").each(function(index){
		$(this).click(function(){
// 			alert($(this).find("ul").size());
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
				$(this).children("a").addClass("on");
				if($(this).children("a").next().length > 0) {
					
					$(this).children("a").next().show();
					$(".depth2_div .bg_depth3").css("display","block");
					//$(this).children("a").next().slideDown("fast");
				}
				
				//$(this).children("a").next().slideDown("fast");
			
		},
		function(){
			
				$(this).children("a").children("img").attr("src",$(this).children("a").children("img").attr("src").replace("_on","_off"));
				$(this).children("a").removeClass("on");
				if($(this).children("a").next().length > 0) {
					$(this).children("a").next().hide();
					$(".depth2_div .bg_depth3").css("display","none");
					//$(this).children("a").next().slideUp("fast");
				}
				//$(this).children("a").next().slideUp("fast");
			
			}
		);


	
	 var lastScrollY = 150;
	 var diffY =  Math.max(document.documentElement.scrollTop, document.body.scrollTop) + 150;

	 $(window).scroll(function(){

		  var diffTop =  Math.max(document.documentElement.scrollTop, document.body.scrollTop) + 150;
		
		  if (diffY != lastScrollY) {
		  	   percent = .10 * (diffY - lastScrollY);
			   if (percent > 0) {
			    	percent = Math.ceil(percent);
			   } else {
			    	percent = Math.floor(percent);
			   }
			   
			   diffTop = parseInt($("#quick").offset().top) + percent ;
			
			   lastScrollY = lastScrollY + percent ;
		  }
		
		  $("#quick").stop();
		  $("#quick").animate({"top": diffTop}, 500);
	 });
});   
    //onload 함수.
    window.onload = function(){
    	
	   	$("#gnb li").find("div").hide();
    	$("#gnb li[id^=gnb] a").each(forEachMouseover);
    	$("#gnb div[id^=gnb_sub]").each(forEachMouseleave);
    	$("#gnb li[id^=gnb]").each(forEachMouseleave1);
    	
    	//$("#searchGubn").show();
    	//$("#sitemap").toggle(function(){alert("1");},function(){"2"});
    	
    };
    
    function showAllMenu()
    {
    	$("#sitemap").toggle();
    	
    }
    
    function forEachMouseleave1()
    {
    	$(this).mouseleave(function(){
    		//$(this).find("div").slideUp("fast");
    		$(this).find("div").hide();
    	});
    }
    function forEachMouseleave()
    {
    	$(this).mouseleave(function(){
    		//$(this).slideUp("fast");
    		$(this).hide();
    	});
    }
    
    function forEachMouseover()
    {
    	$(this).mouseenter(function(){
    		$(this).parent().find("div").slideDown("normal",function(){
    			//$("#gnb div:not(:animated)").slideUp("fast");
    			$("#gnb div:not(:animated)").hide();
    		});
    	});
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
  	//통합검색
  	/*
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
    		//20120905 메인화면에서 바로왓을경우 목록보기가 되지 않음으로 수정
    		//alert("검색어를 입력 해주세요");
    		history.back();
    		return;
		}
    	
    	//키워드 클릭 수 입력
    	
   		jQuery.post('/home/search/keyword_save.ajax.action', 
   				{keyword:headerText,regDT:today}, 
   				function(data) {
   					
   		});
    	
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
	}
	*/

	//통합검색
	function headerSearch(page){
		
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
    	
    	//키워드 클릭 수 입력
    	
    	/*
   		jQuery.post('/home/search/keyword_save.ajax.action', 
   				{keyword:headerText}, 
   				function(data) {
   		});
    	*/

   		//onsubmit 속성을 비워주어야 submit이 된다.
		$("#headerForm").attr("method","post");
		$("#headerForm").attr("onsubmit","");
		$("#headerForm").attr("action","/home/search/combineSearch.search.action");
		$("#headerForm").submit();
		
   		
	}
    
	 function tabClick(no)
	    {
	    	var searchGubn2 = $("#searchGubn2").val();
	    	
	    	//탭변경후 보던 페이지와 다를경우 검색 페이징을 숨기고 검색을 실행한다.
	    	if(no != searchGubn2){
	    		$("#pg2").hide();
	    		headerSearch(1);
	    	}
	    	
	    	$("div[id^=showDiv]").hide();
	    	$("#searchGubnTab li").find("a").removeClass();
	    	$("#searchGubn option:eq("+no+")").attr("selected","selected");
			switch(parseInt(no))
			{
				case 0:
					//$("#tCnt").text(parseInt($("#searchListCnt1").text()) + parseInt($("#searchListCnt2").text()) + parseInt($("#searchListCnt3").text()));
					$("div[id^=showDiv]").show();
					$("#pg2").hide();
					$("#searchGubnTab li:nth-child(1)").find("a").addClass("on");
					break;
				case 1:
					$("#showDiv1").show();
					$("#tCnt").text($("#searchListCnt1").text());
					$("#searchGubnTab li:nth-child(2)").find("a").addClass("on");
					break;
				case 2:
					$("#showDiv2").show();
					$("#tCnt").text($("#searchListCnt2").text());
					$("#searchGubnTab li:nth-child(3)").find("a").addClass("on");
					break;
				case 3:
					$("#showDiv3").show();
					$("#tCnt").text($("#searchListCnt3").text());
					$("#searchGubnTab li:nth-child(4)").find("a").addClass("on");
					break;
			}
	    	
	    }
    
    function viewDetail1(courseId,courseIdentifier, title)
	{
    	var currpage = $("#currPage2").val();
    	var tabno = $("#tabNo").val();
    	
    	//alert(currpage + ":" + tabno);
    	
    	
    	var headerText = $("#headerText").val();
    	document.location.href = '/home/course/viewDetail_header.sub.action?gnb=31&courseId='+courseId+'&courseIdentifier='+courseIdentifier+'&gnb=31&text='+escape(encodeURIComponent(headerText))+'&hideText='+escape(encodeURIComponent(title))+"&currPage="+currpage+"&tabNo="+tabno;
	}

    function viewDetail2(gubn,id)
	{
    	var headerText = $("#headerText").val();
    	
    	switch(parseInt(gubn))
    	{
	    	case 1:
	    		document.location.href = '/home/refer/boardUniv_view_header.sub.action?boardID='+id+'&gnb=42&searchText='+escape(encodeURIComponent(headerText));
	    		break;
	    	case 2:
	    		document.location.href = '/home/refer/board_view_header.sub.action?boardID='+id+'&gnb=45&searchText='+escape(encodeURIComponent(headerText))+'&gID=154';
	    		break;
	    	case 3:
	    		document.location.href = '/home/refer/faq_list_header.sub.action?faqContent='+escape(encodeURIComponent(headerText))+'&gnb=47&gID=156&selectRadio1=3';
	    		break;
    	}
	}
    
    function viewMore(no)
    {
    	tabClick(no);
    	$("#searchGubn").val(no);
    	headerSearch(1);
    }
    
	function setRecordCnt2(totalCnt, currPage, totalPage, showCnt)
	{
		$("#cPage").text(currPage);
		$("#tPage").text(totalPage);
		setPaging2($("#pg2"), totalCnt, showCnt, currPage);
	}
	
	function clickKeyword(keyword)
	{
		//alert(keyword);
		$("#headerText").val(keyword);
		headerSearch(1);
	}
	
	function viewMoreCourse()
	{
		document.location.href = "/home/course/recommendByUniv.sub.action?gnb=35";
	}
    function bestCourseClick( title )
    {
    	$("#headerText").val(title);
    	headerSearch(1);
    }
    function chgSort(str)
    {
    	var sort = $("#sort").val(); 
    	
    	if(sort == str)
    		chgOrder();
    	else
    		$("#order").val("1");
    	
    	var sort = $("#sort").val(); 
    	$("#sort").val(str);
    	
    	if(sort != str)
    		headerSearch(1);
    }
    
    function chgOrder()
    {
    	var order = $("#order").val();
    	
    	if(order == "0")
    		$("#order").val("1");
    	if(order == "1")
    		$("#order").val("0");
    	headerSearch(1);
    }

    function selectSearchGubn(){
		$("#searchGubn").toggle();
    }
    
    function selectSearchGubnItem(no){
    	$("#searchGubn").toggle();
		if(no == 0)
			$(".sel_title").text("통합검색");
		else if(no == 1)
			$(".sel_title").text("강의검색");
		else if(no == 2)
			$(".sel_title").text("게시물검색");
		else if(no == 3)
			$(".sel_title").text("웹문서");
		
		$("#searchGubn2").val(no);
    }
    
  //about cuinfo 팝업
    function popAboutCuinfo(){
		var aboutCuinfo = window.open("/home/aboutCuinfo.html","","width=750,height=600,toolbar=no,location=no");
		
		if(aboutCuinfo)
			aboutCuinfo.focus();
    }
  
  //about kcou 팝업
	function popAboutKcou(){
		var aboutKcou = window.open("/home/aboutKcou.html","","width=810,height=615,toolbar=no,location=no,scrollbars=yes");
		
		if(aboutKcou)
			aboutKcou.focus();
	}

  </script>

<decorator:head />
</head>

<body id="newLayout" class="<%=PageClass%>">

<!-- top -->
<div style="position: relative; width: 1006px; margin: 0 auto;"><a href="/home"><img src="/home/images2/common/tab1_off.gif"/></a><a href="/home/index2.main2.action"><img src="/home/images2/common/tab2_on.gif"/></a></div>

<div id="container"><!-- container Start --> <!-- left -->
<div id="leftgnb">
    	<!-- 1depth menu -->
    	<h1><a href="/home/index2.main2.action"><img src="/home/images3/common/gnb/h1_logo.png" alt="사이버대학 종합정보 CUinfo"  /></a></h1>
        
        <ul class="ul_depth1">
        	<li ><a href="<%=PageUrl11%>"><img src="/home/images3/common/gnb/gnb1.png" alt="사이버대학원 안내" /></a></li>
            <li ><a href="<%=PageUrl211%>"><img src="/home/images3/common/gnb/gnb2.png" alt="입학안내" /></a></li>
            <li> <a href="<%=PageUrl322%>"><img src="/home/images3/common/gnb/gnb3.png" alt="교과과정" /></a></li>
            <li> <a href="<%=PageUrl41%>"><img src="/home/images3/common/gnb/gnb4.png" alt="강의 검색" /></a></li>
            <li> <a href="<%=PageUrl51%>"><img src="/home/images3/common/gnb/gnb5.png" alt="정보 자료실" /></a></li>
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
                <input type="text" class="keyword" value="SEARCH" id="headerText" name="headerText" onFocus="if(this.value == 'SEARCH') this.value=''"/><input type="image" src="/home/images3/common/search_btn.gif" onclick="javascript:headerSearch();"/>
            </form>
            <a href="javascript:popAboutCuinfo();" class="first"><img src="/home/images3/common/txt_about.png" alt="ABOUT CUINFO" /></a>
            <a href="javascript:popAboutKcou()"><img src="/home/images3/common/txt_kcou.png" alt="유관기관업무협약" /></a>
            <a href="javascript:showAllMenu();"><img src="/home/images3/common/txt_all.png" alt="전체메뉴" /></a>
            <a href="javascript:bookmark();"><img src="/home/images3/common/txt_bookmark.png" alt="즐겨찾기" /></a>
        </div>
        <!-- 1depth menu -->
        
         <!-- 2depth menu -->
        <!-- 2depth menu -->
        <div class="depth2_div" style="opacity:0.8;">
        	<div class="arrow"><img src="/home/images3/common/gnb/img_arrow.png" alt=""/></div>
            
            <ul class="sub0">
                <li><a href="<%=PageUrl11%>"><img src="/home/images3/common/gnb/m_d1_1_0_off.png" alt="사이버대학원이란?"/></a>
                	<ul>
                        <li><a href="<%=PageUrl11%>"><img src="/home/images3/common/gnb/m_d1_1_1_off.png" alt="소개 및 특징"/></a></li>
                        <li><a href="<%=PageUrl112%>"><img src="/home/images3/common/gnb/m_d1_1_2_off.png" alt="학기 및 수업 안내"/></a></li>
                    </ul>
                </li>
                <li><a href="<%=PageUrl121%>"><img src="/home/images3/common/gnb/m_d1_2_0_off.png" alt="사이버대학원 소개"/></a></li>
                <li><a href="<%=PageUrl13%>"><img src="/home/images3/common/gnb/m_d1_3_0_off.png" alt="화상세미나"/></a></li>
                <li><a href="<%=PageUrl14%>"><img src="/home/images3/common/gnb/m_d1_4_0_off.png" alt="사이버논문 지도/작성"/></a></li>
                
            </ul>
            
             <ul class="sub1">
                <li><a href="<%=PageUrl22%>"><img src="/home/images3/common/gnb/m_d2_2_0_off.png" alt="모집요강"/></a></li>
                <li><a href="<%=PageUrl23%>"><img src="/home/images3/common/gnb/m_d2_3_0_off.png" alt="대학원 정보 현황"/></a></li>
            </ul>
            
            <ul class="sub2">
                <li><a href="<%=PageUrl31%>"><img src="/home/images3/common/gnb/m_d3_1_0_off.png" alt="교과과정보기"/></a></li>
                <li><a href="<%=PageUrl32%>"><img src="/home/images3/common/gnb/m_d3_2_0_off.png" alt="분야별 학과/교과과정"/></a></li>
            </ul> 
            
            <ul class="sub3">
                <li><a href="<%=PageUrl41%>"><img src="/home/images3/common/gnb/m_d4_1_0_off.png" alt="강의명 검색"/></a></li>
                <li><a href="<%=PageUrl43%>"><img src="/home/images3/common/gnb/m_d4_3_0_off.png" alt="학교별 검색"/></a></li>
                <li><a href="<%=PageUrl44%>"><img src="/home/images3/common/gnb/m_d4_4_0_off.png" alt="강의맛보기"/></a></li>
            </ul>
            
            <ul class="sub4">
                <li><a href="<%=PageUrl51%>"><img src="/home/images3/common/gnb/m_d5_1_0_off.png" alt="연구/교육 자료"/></a></li>
                <li><a href="<%=PageUrl52%>"><img src="/home/images3/common/gnb/m_d5_2_0_off.png" alt="사이버대학 뉴스"/></a></li>
                <li><a href="<%=PageUrl53%>"><img src="/home/images3/common/gnb/m_d5_3_0_off.png" alt="공지사항"/></a></li>
                <li><a href="<%=PageUrl54%>"><img src="/home/images3/common/gnb/m_d5_4_0_off.png" alt="자주 묻는 질문"/></a></li>
                <li><a href="<%=PageUrl55%>"><img src="/home/images3/common/gnb/m_d5_5_0_off.png" alt="사이버대학 통계"/></a></li>
            </ul>
            
            <div class="bg_depth3"></div>
            
        </div>
        <!-- //2depth menu -->
        
        <!-- 사이버 대학 메뉴 -->
        <div class="cyber_gnb">
        	<div class="cyber_menu_div">
                <h2><a href="#"><img src="/home/images2/common/gnb/h2_txt1.png" alt="우리는 사이버세계로 대학간다" /></a></h2>
                
               <ul class="cyber_ul">
                    <li style="display: none;"><a href="http://grad.khcu.ac.kr/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_1.png" alt="경희사이버대학원"/></a></li>
					<li style="display: none;"><a href="http://grad.cuk.edu/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_2.png" alt="고려사이버대학원"/></a></li>
					<li style="display: none;"><a href="https://grad.dcu.ac.kr/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_3.png" alt="대구사이버대학원"/></a></li>
					<li style="display: none;"><a href="http://grad.bdu.ac.kr/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_4.png" alt="부산디지털대학원"/></a></li>
					<li style="display: none;"><a href="http://grad.cufs.ac.kr/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_5.png" alt="사이버한국외국어대학원"/></a></li>
					<li style="display: none;"><a href="http://grad.iscu.ac.kr/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_6.png" alt="서울사이버대학원"/></a></li>
					<li style="display: none;"><a href="http://graduate.sjcu.ac.kr/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_7.png" alt="세종사이버대학원"/></a></li>
					<li style="display: none;"><a href="http://www.wdu.ac.kr/graduateS/main.do" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_8.png" alt="원광디지털대학원"/></a></li>
					<li style="display: none;"><a href="http://gs.hycu.ac.kr/" target="_blank"><img height="50%" src="/home/images3/common/gnb/m_cy_9.png" alt="한양사이버대학원"/></a></li>
                </ul>
            </div>
        
       		<div class="btn"><a href="#"><img src="/home/images3/common/gnb/btn_cyber.png" alt="사이버 대학원" /></a></div>
            
        </div>
        <!-- //사이버 대학 메뉴 -->
        
    </div>
	
<div id="contents"><!-- Contents End --> <!----  START OF :: 컨텐츠 영역 ---->
<%@ include file="/home/common/quick.jsp"%>
<decorator:body /> <!----  END OF :: 컨텐츠 영역 ---->
 <%@ include file="/home/common/recommend.jsp"%>
 <div id="subfooter">
            	<h2><a href="http://www.kcou.org/" onClick="dcsMultiTrack('DCS.dcssip','www.kcou.org','DCS.dcsuri','/','DCS.qry','','WT.ti','Offsite Link - kcou','WT.sp','kcou')"><img src="/home/images2/common/h2_foot.png" alt="한국원격대학협의회" /></a></h2>
                
                <div class="footer_m">
                	<a target="_blank" href="http://www.kcou.org/common/Content.aspx?CUMENUCODE=000000011672" onClick="dcsMultiTrack('DCS.dcssip','www.kcou.org','DCS.dcsuri','/common/Content.aspx','DCS.qry','CUMENUCODE=000000011672','WT.ti','Offsite Link - kcou','WT.sp','kcou')"><img src="/home/images2/common/txt_foot1.png" alt="기관소개" /></a>
                    <a target="_blank" href="/home/etc/copyright.main.action"><img src="/home/images2/common/txt_foot2.png" alt="저작권 신고" /></a>
                    <a target="_blank" href="http://www.kcou.org/common/Content.aspx?CUMENUCODE=000000011701" onClick="dcsMultiTrack('DCS.dcssip','www.kcou.org','DCS.dcsuri','/common/Content.aspx','DCS.qry','CUMENUCODE=000000011701','WT.ti','Offsite Link - kcou','WT.sp','kcou')"><img src="/home/images2/common/txt_foot3.png" alt="찾아오시는 길" /></a>
                    <p class="juso"><img src="/home/images2/common/txt_juso1.png" alt="[110-858] 서울특별시 종로구삼봉로 81 위브파빌리온 924호 TEL : 02.723-6574~5 FAX : 02.723-6541" /></p>
                    <p class="copyright"><img src="/home/images2/common/txt_copyright.png" alt="COPYRIGHT (R) SINCE 2014 한국원격대학협의회.  ALL RIGHT RESERVED." /></p>
                </div>
                
                <div class="footer_r">
                	<a target="_blank" class="f_right" href="http://www.keris.or.kr/" onClick="dcsMultiTrack('DCS.dcssip','www.keris.or.kr','DCS.dcsuri','/','DCS.qry','','WT.ti','Offsite Link - keris','WT.sp','keris')"><img src="/home/images2/common/keris_cp.png" alt="" /></a>
                	<a target="_blank" class="f_right" href="http://www.moe.go.kr/main.do" onClick="dcsMultiTrack('DCS.dcssip','www.moe.go.kr','DCS.dcsuri','/main.do','DCS.qry','','WT.ti','Offsite Link - moe','WT.sp','moe')"><img src="/home/images2/common/edu_cp.png" alt="" /></a>
                </div>
                
            </div>

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
				</div>
				<a class="<%=SnbOn121%>" href="<%=PageUrl121%>"><%=SnbNmae121%></a> 
				
				<a class="<%=SnbOn13%>" href="<%=PageUrl13%>"><%=SnbNmae13%></a>
				<a class="<%=SnbOn14%>" href="<%=PageUrl14%>"><%=SnbNmae14%></a> 
			</div>
		</li>
		<li id="sitemap2" class="<%=GnbOn2%>">
			<span><%=GnbName2%></span>
			<div id="gnb_sub2">
				<a class="<%=SnbOn22%>" href="<%=PageUrl22%>"><%=SnbNmae22%></a> 
				<a class="<%=SnbOn23%>" href="<%=PageUrl23%>"><%=SnbNmae23%></a>
			</div>
		</li>
		<li id="sitemap3" class="<%=GnbOn3%>">
			<span><%=GnbName3%></span>
			<div id="gnb_sub3">
				<a class="<%=SnbOn31%>" href="<%=PageUrl322%>"><%=SnbNmae31%></a>
				<a class="<%=SnbOn32%>" href="<%=PageUrl321%>"><%=SnbNmae32%></a>  

			</div>
		</li>
		
		<li id="sitemap4" class="<%=GnbOn4%>">
			<span><%=GnbName4%></span>
			<div id="gnb_sub3">
				<a class="<%=SnbOn41%>" href="<%=PageUrl41%>"><%=SnbNmae41%></a>
				<a class="<%=SnbOn43%>" href="<%=PageUrl43%>"><%=SnbNmae43%></a>
				<a class="<%=SnbOn44%>" href="<%=PageUrl44%>"><%=SnbNmae44%></a>
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
					<a href="<%=PageUrl5510%>"><%=SnbNmae5510%></a>
				</div>
			</div>
		</li>
	</ul><!-- sitemap End -->

</div>
</div>

<!-- Contents Section End --></div>
<!-- container End -->


</body>
</html>