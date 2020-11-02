<%

String gnb = request.getParameter("gnb");
String URL = "/mgr";
String BodyType = "";
String GnbOn1 = ""; String GnbOn2 = ""; String GnbOn3 = ""; String GnbOn4 = ""; String GnbOn5 = ""; String GnbOn6 = ""; String GnbOn7 = "";
String SnbOn11 = ""; String SnbOn12 = ""; String SnbOn13 = "";
String SnbOn21 = ""; String SnbOn22 = ""; String SnbOn23 = ""; String SnbOn24 = ""; String SnbOn25 = "";
String SnbOn31 = ""; String SnbOn32 = ""; String SnbOn33 = "";
String SnbOn41 = ""; String SnbOn42 = ""; String SnbOn43 = ""; String SnbOn44 = ""; String SnbOn45 = "";String SnbOn46 = "";String SnbOn47 = "";
String SnbOn51 = ""; String SnbOn52 = ""; String SnbOn53 = ""; String SnbOn54 = "";
String Category = "";
String MainTitle = "";
String SubTitle = "";
String TitleImg = "";
String PageType = "";
String PageUrl = "/mgr/index.jsp?";

if(gnb == null){ gnb = "0"; }
int cate_int = Integer.parseInt(gnb);



// 학교/학사관리
String GnbName1 = "학교/학사관리";
String SnbNmae11 = "학교정보관리";						String PageUrl11 = "/mgr/univ/univInfoList.jsp?gnb=11";
String SnbNmae12 = "학과정보관리";						String PageUrl12 = "/mgr/univ/majorList.jsp?gnb=12";
String SnbNmae13 = "대학정보현황";						String PageUrl13 = "/mgr/univ/univStats.jsp?gnb=13";

if(cate_int == 11 || cate_int == 12 || cate_int == 13 || cate_int == 14){	 MainTitle="학교/학사관리";	GnbOn1 = "on" ;	PageType = "univ" ;		Category = "/mgr/univ/univInfoList.jsp?gnb=11";}
if(cate_int == 11){	SubTitle="학교정보관리";			SnbOn11="on";		TitleImg="title1";			PageUrl = "/mgr/univ/univInfoList.jsp?gnb=11";	}
if(cate_int == 12){	SubTitle="학과정보관리";			SnbOn12="on";		TitleImg="title2";			PageUrl = "/mgr/univ/majorList.jsp?gnb=12";	}
if(cate_int == 13){	SubTitle="대학정보현황";			SnbOn13="on";		TitleImg="title3";			PageUrl = "/mgr/univ/univStats.jsp?gnb=13";	}



// 강좌메타관리
String GnbName2 = "강좌메타관리";
String SnbNmae21 = "메타수집/승인관리";				String PageUrl21 = "/mgr/course/metaCollectionList.jsp?gnb=21";
String SnbNmae22 = "강좌정보관리";						String PageUrl22 = "/mgr/course/courseList.jsp?gnb=22";
String SnbNmae23 = "DP서버관리";						String PageUrl23 = "/mgr/course/dpServerList.jsp?gnb=23";
String SnbNmae24 = "스케쥴관리";							String PageUrl24 = "/mgr/course/scheduleList.jsp?gnb=24";
String SnbNmae25 = "유통기관관리";						String PageUrl25 = "/mgr/course/ctrOrganModify.jsp?gnb=25";

if(cate_int == 21 || cate_int == 22 || cate_int == 23 || cate_int == 24 || cate_int == 25){	MainTitle="강좌메타관리";	GnbOn2 = "on" ;	 PageType = "course" ;		Category = "/mgr/course/metaCollectionList.jsp?gnb=21";}
if(cate_int == 21){	SubTitle="메타수집/승인관리";	SnbOn21="on";		TitleImg="title1";			PageUrl = "/mgr/course/metaCollectionList.jsp?gnb=21";		}
if(cate_int == 22){	SubTitle="강좌정보관리";			SnbOn22="on";		TitleImg="title2";			PageUrl = "/mgr/course/courseList.jsp?gnb=22"; }
if(cate_int == 23){	SubTitle="DP서버관리";			SnbOn23="on";		TitleImg="title3";			PageUrl = "/mgr/course/dpServerList.jsp?gnb=23";		}
if(cate_int == 24){	SubTitle="스케쥴관리";				SnbOn24="on";		TitleImg="title4";			PageUrl = "/mgr/course/scheduleList.jsp?gnb=24";			}
if(cate_int == 25){	SubTitle="유통기관관리";			SnbOn25="on";		TitleImg="title5";			PageUrl = "/mgr/course/ctrOrganModify.jsp?gnb=25";			}



// 통계현황
String GnbName3 = "통계현황";
String SnbNmae31 = "강좌등록통계";						String PageUrl31 = "/mgr/stats/courseByperiod.jsp?gnb=31";
String SnbNmae32 = "서비스조회수 통계";				String PageUrl32 = "/mgr/stats/hitsCourse.jsp?gnb=32";
String SnbNmae33 = "검색통계";							String PageUrl33 = "/mgr/stats/searchService.jsp?gnb=33";

if(cate_int == 31 || cate_int == 32 || cate_int == 33){	MainTitle="통계현황";		GnbOn3 = "on" ;	 PageType = "stats" ;		Category = "/mgr/stats/courseByperiod.jsp?gnb=31";}
if(cate_int == 31){	SubTitle="강좌등록통계";			SnbOn31="on";		TitleImg="title1";			PageUrl = "/mgr/stats/courseByperiod.jsp?gnb=31";			}
if(cate_int == 32){	SubTitle="서비스조회수 통계";	SnbOn32="on";		TitleImg="title2";			PageUrl = "/mgr/stats/hitsCourse.jsp?gnb=32";				}
if(cate_int == 33){	SubTitle="검색통계";				SnbOn33="on";		TitleImg="title3";			PageUrl = "/mgr/stats/searchService.jsp?gnb=33";		}



//홈페이지관리
String GnbName4 = "홈페이지관리";
String SnbNmae41 = "사이버대학뉴스";					String PageUrl41 = "/mgr/home/newsFeedList.jsp?gnb=41";
String SnbNmae42 = "대학행사안내";						String PageUrl42 = "/mgr/home/boardUnivList.jsp?gnb=42";
String SnbNmae43 = "원격대학협의회동정";				String PageUrl43 = "/mgr/home/boardConferenceList.jsp?gnb=43";
String SnbNmae44 = "연구,교육자료";						String PageUrl44 = "/mgr/home/boardReferenceList.jsp?gnb=44";
String SnbNmae45 = "공지사항";							String PageUrl45 = "/mgr/home/noticeList.jsp?gnb=45";
String SnbNmae46 = "FAQ관리";							String PageUrl46 = "/mgr/home/faqList.jsp?gnb=46";
String SnbNmae47 = "팝업관리";							String PageUrl47 = "/mgr/home/poupList.jsp?gnb=47";

if(cate_int == 41 || cate_int == 42 || cate_int == 43 || cate_int == 44 || cate_int == 45 || cate_int == 46 || cate_int == 47){	MainTitle="홈페이지관리";	GnbOn4 = "on" ;	 PageType = "home" ;		Category = "/mgr/home/newsFeedList.jsp?gnb=41";}
if(cate_int == 41){	SubTitle="사이버대학뉴스";		SnbOn41="on";		TitleImg="title1";			PageUrl = "/mgr/home/newsFeedList.jsp?gnb=41";     	}
if(cate_int == 42){	SubTitle="대학행사안내";			SnbOn42="on";		TitleImg="title2";			PageUrl = "/mgr/home/boardUnivList.jsp?gnb=42";     	}
if(cate_int == 43){	SubTitle="원격대학협의회동정";	SnbOn43="on";		TitleImg="title3";			PageUrl = "/mgr/home/boardConferenceList.jsp?gnb=43";     	}
if(cate_int == 44){	SubTitle="연구,교육자료";			SnbOn44="on";		TitleImg="title4";			PageUrl = "/mgr/home/boardReferenceList.jsp?gnb=44";     	}
if(cate_int == 45){	SubTitle="공지사항";				SnbOn45="on";		TitleImg="title5";			PageUrl = "/mgr/home/noticeList.jsp?gnb=45";     	}
if(cate_int == 46){	SubTitle="FAQ관리";				SnbOn46="on";		TitleImg="title6";			PageUrl = "/mgr/home/faqList.jsp?gnb=46";     	}
if(cate_int == 47){	SubTitle="팝업관리";				SnbOn47="on";		TitleImg="title7";			PageUrl = "/mgr/home/poupList.jsp?gnb=47";		}



//시스템관리
String GnbName5 = "시스템관리";
String SnbNmae51 = "시스템코드관리";					String PageUrl51 = "/mgr/system/codeList.jsp?gnb=51";
String SnbNmae52 = "학과관리";							String PageUrl52 = "/mgr/system/majorCodeList.jsp?gnb=52";
String SnbNmae53 = "학교코드관리";						String PageUrl53 = "/mgr/system/univCodeList.jsp?gnb=53";
String SnbNmae54 = "관리자정보관리";					String PageUrl54 = "/mgr/system/adminList.jsp?gnb=54";

if(cate_int == 51 || cate_int == 52 || cate_int == 53 || cate_int == 54){	 MainTitle="시스템관리"; 	GnbOn5 = "on" ;	 PageType = "system" ;		Category = "/mgr/system/codeList.jsp?gnb=51";}
if(cate_int == 51){	SubTitle="시스템코드관리";		SnbOn51="on";		TitleImg="title1";			PageUrl = "/mgr/system/codeList.jsp?gnb=51";		}
if(cate_int == 52){	SubTitle="학과관리";				SnbOn52="on";		TitleImg="title2";			PageUrl = "/mgr/system/majorCodeList.jsp?gnb=52";			}
if(cate_int == 53){	SubTitle="학교코드관리";			SnbOn53="on";		TitleImg="title3";			PageUrl = "/mgr/system/univCodeList.jsp?gnb=53";			}
if(cate_int == 54){	SubTitle="관리자정보관리";		SnbOn54="on";		TitleImg="title4";			PageUrl = "/mgr/system/adminList.jsp?gnb=54";		}


%>