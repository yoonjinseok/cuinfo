<%


String gnb = request.getParameter("gnb");
String URL = "/home";
String BodyType = "";
String GnbOn1 = ""; String GnbOn2 = ""; String GnbOn3 = ""; String GnbOn4 = "";
String SnbOn11 = ""; String SnbOn12 = ""; String SnbOn13 = ""; String SnbOn14 = ""; String SnbOn15 = "";
String SnbOn21 = ""; String SnbOn22 = ""; String SnbOn23 = "";
String SnbOn31 = ""; String SnbOn32 = ""; String SnbOn33 = ""; String SnbOn34 = ""; String SnbOn35 = "";
String SnbOn41 = ""; String SnbOn42 = ""; String SnbOn43 = ""; String SnbOn44 = ""; String SnbOn45 = "";String SnbOn46 = "";String SnbOn47 = "";
String Category = "";
String MainTitle = "";
String SubTitle = "";
String TitleImg = "";
String PageID = "";
String PageType = "";
String PageUrl = "/home/index.jsp?";


if(gnb == null){ gnb = "0"; }
int cate_int = Integer.parseInt(gnb);


String GnbName1 = "사이버대학안내";
String SnbNmae11 = "사이버대학이란?";						String PageUrl11 = "/home/intro/summary.jsp?gnb=11";
String SnbNmae12 = "대학소개";								String PageUrl12 = "/home/intro/overall.jsp?gnb=12";
String SnbNmae13 = "학과 네비게이션";						String PageUrl13 = "/home/intro/navigationMajorArea.jsp?gnb=13";
String SnbNmae14 = "전체 학과검색";							String PageUrl14 = "/home/intro/searchMajor.jsp?gnb=14";
String SnbNmae15 = "국가공인자격증안내";					String PageUrl15 = "/home/intro/certificate1.jsp?gnb=15";

if(cate_int == 11 || cate_int == 12 || cate_int == 13 || cate_int == 14 || cate_int == 15){	 MainTitle="사이버대학안내";		GnbOn1 = "on" ;	PageType = "intro" ;		Category = "/home/intro/summary.jsp?gnb=11";}
if(cate_int == 11){	SubTitle="사이버대학이란?";			TitleImg="title1";			SnbOn11="on";		PageUrl = "/home/intro/summary.jsp?gnb=11";	}
if(cate_int == 12){	SubTitle="대학소개";					TitleImg="title2";			SnbOn12="on";		PageUrl = "/home/intro/overall.jsp?gnb=12";	}
if(cate_int == 13){	SubTitle="학과 네비게이션";			TitleImg="title3";			SnbOn13="on";		PageUrl = "/home/intro/navigationMajorArea.jsp?gnb=13";	}
if(cate_int == 14){	SubTitle="전체 학과검색";				TitleImg="title4";			SnbOn14="on";		PageUrl = "/home/intro/searchMajor.jsp?gnb=14";	}
if(cate_int == 15){	SubTitle="국가공인자격증안내";		TitleImg="title5";			SnbOn15="on";		PageUrl = "/home/intro/certificate1.jsp?gnb=15";	}


String GnbName2 = "입학안내";
String SnbNmae21 = "입학절차안내";							String PageUrl21 = "/home/entr/enterStep_New.jsp?gnb=21";
String SnbNmae22 = "모집요강";								String PageUrl22 = "/home/entr/enterGuide.jsp?gnb=22";
String SnbNmae23 = "대학정보현황";							String PageUrl23 = "/home/entr/univStats.jsp?gnb=23";

if(cate_int == 21 || cate_int == 22 || cate_int == 23){	MainTitle="입학안내";	GnbOn2 = "on" ;		PageType = "entr" ;		Category = "/home/entr/enterStep_New.jsp?gnb=21";}
if(cate_int == 21){	SubTitle="입학절차안내";				TitleImg="title1";			SnbOn21="on";		PageUrl = "/home/entr/enterStep_New.jsp?gnb=21";		}
if(cate_int == 22){	SubTitle="모집요강";					TitleImg="title2";			SnbOn22="on";		PageUrl = "/home/entr/enterGuide.jsp?gnb=22";		}
if(cate_int == 23){	SubTitle="대학정보현황";				TitleImg="title3";			SnbOn23="on";		PageUrl = "/home/entr/univStats.jsp?gnb=23";		}


String GnbName3 = "강의검색";
String SnbNmae31 = "학과분야별검색";						String PageUrl31 = "/home/course/searchByMajorArea.jsp?gnb=31";
String SnbNmae32 = "학교별검색";								String PageUrl32 = "/home/course/searchByUniv.jsp?gnb=32";
String SnbNmae33 = "고급검색";								String PageUrl33 = "/home/course/detailSearch.jsp?gnb=33";
String SnbNmae34 = "대학별맛보기강의";					String PageUrl34 = "/home/course/tasterLectureByUniv.jsp?gnb=34";
String SnbNmae35 = "대학별추천강의";						String PageUrl35 = "/home/course/recommendByUniv.jsp?gnb=35";

if(cate_int == 31 || cate_int == 32 || cate_int == 33 || cate_int == 34 || cate_int == 35){	MainTitle="강의검색";		GnbOn3 = "on" ;	PageType = "course" ;		Category = "/home/course/searchByMajorArea.jsp?gnb=31";}
if(cate_int == 31){	SubTitle="학과분야별검색";			TitleImg="title1";			SnbOn31="on";		PageUrl = "/home/course/searchByMajorArea.jsp?gnb=31";			}
if(cate_int == 32){	SubTitle="학교별검색";					TitleImg="title2";			SnbOn32="on";		PageUrl = "/home/course/searchByUniv.jsp?gnb=32";				}
if(cate_int == 33){	SubTitle="고급검색";					TitleImg="title3";			SnbOn33="on";		PageUrl = "/home/course/detailSearch.jsp?gnb=33";		}
if(cate_int == 34){	SubTitle="대학별맛보기강의";		TitleImg="title4";			SnbOn34="on";		PageUrl = "/home/course/tasterLectureByUniv.jsp?gnb=34";		}
if(cate_int == 35){	SubTitle="대학별추천강의";			TitleImg="title5";			SnbOn35="on";		PageUrl = "/home/course/recommendByUniv.jsp?gnb=35";		}


String GnbName4 = "정보자료실";
String SnbNmae41 = "사이버대학뉴스";						String PageUrl41 = "/home/refer/boardNewsList.jsp?gnb=41";
String SnbNmae42 = "대학행사안내";							String PageUrl42 = "/home/refer/boardUnivList.jsp?gnb=42";
String SnbNmae43 = "원격대학협의회동정";					String PageUrl43 = "/home/refer/boardConferenceList.jsp?gnb=43";
String SnbNmae44 = "연구/교육자료";						String PageUrl44 = "/home/refer/boardReferenceList.jsp?gnb=44";
String SnbNmae45 = "서비스길라잡이";						String PageUrl45 = "/home/refer/serviceGuide1.jsp?gnb=45";
String SnbNmae46 = "자주하는 질문답변";					String PageUrl46 = "/home/refer/faqList.jsp?gnb=46";

if(cate_int == 41 || cate_int == 42 || cate_int == 43 || cate_int == 44 || cate_int == 45 || cate_int == 46){	MainTitle="정보자료실";	GnbOn4 = "on" ;	PageType = "refer" ;		Category = "/home/refer/boardNewsList.jsp?gnb=41";}
if(cate_int == 41){	SubTitle="사이버대학뉴스";			TitleImg="title1";			SnbOn41="on";		PageUrl = "/home/refer/boardNewsList.jsp?gnb=41";     	}
if(cate_int == 42){	SubTitle="대학행사안내";				TitleImg="title2";			SnbOn42="on";		PageUrl = "/home/refer/boardUnivList.jsp?gnb=42";     	}
if(cate_int == 43){	SubTitle="원격대학협의회동정";		TitleImg="title3";			SnbOn43="on";		PageUrl = "/home/refer/boardConferenceList.jsp?gnb=43";     	}
if(cate_int == 44){	SubTitle="연구/교육자료";				TitleImg="title4";			SnbOn44="on";		PageUrl = "/home/refer/boardReferenceList.jsp?gnb=44";     	}
if(cate_int == 45){	SubTitle="서비스길라잡이";			TitleImg="title5";			SnbOn45="on";		PageUrl = "/home/refer/serviceGuide1.jsp?gnb=45";     	}
if(cate_int == 46){	SubTitle="자주하는 질문답변";		TitleImg="title6";			SnbOn46="on";		PageUrl = "/home/refer/faqList.jsp?gnb=46";		}


%>