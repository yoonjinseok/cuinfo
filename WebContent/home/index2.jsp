<%


String gnb = request.getParameter("gnb");
String URL = "/home";
String BodyType = "";
String GnbOn1 = ""; String GnbOn2 = ""; String GnbOn3 = ""; String GnbOn4 = "";
String SnbOn11 = ""; String SnbOn12 = ""; String SnbOn13 = ""; String SnbOn14 = ""; String SnbOn15 = "";
String SnbOn21 = ""; String SnbOn22 = ""; String SnbOn23 = "";
String SnbOn31 = ""; String SnbOn32 = ""; String SnbOn33 = ""; String SnbOn34 = ""; String SnbOn35 = "";
String SnbOn41 = ""; String SnbOn42 = ""; String SnbOn43 = ""; String SnbOn44 = ""; String SnbOn45 = ""; String SnbOn46 = ""; String SnbOn47 = "";
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
String SnbNmae45 = "공지사항";								String PageUrl45 = "/home/refer/noticeList.jsp?gnb=45";
String SnbNmae46 = "서비스길라잡이";						String PageUrl46 = "/home/refer/serviceGuide.jsp?gnb=46";
String SnbNmae47 = "자주하는 질문답변";					String PageUrl47 = "/home/refer/faqList.jsp?gnb=47";

if(cate_int == 41 || cate_int == 42 || cate_int == 43 || cate_int == 44 || cate_int == 45 || cate_int == 46 || cate_int == 47){	MainTitle="정보자료실";	GnbOn4 = "on" ;	PageType = "refer" ;		Category = "/home/refer/boardNewsList.jsp?gnb=41";}
if(cate_int == 41){	SubTitle="사이버대학뉴스";			TitleImg="title1";			SnbOn41="on";		PageUrl = "/home/refer/boardNewsList.jsp?gnb=41";     	}
if(cate_int == 42){	SubTitle="대학행사안내";				TitleImg="title2";			SnbOn42="on";		PageUrl = "/home/refer/boardUnivList.jsp?gnb=42";     	}
if(cate_int == 43){	SubTitle="원격대학협의회동정";		TitleImg="title3";			SnbOn43="on";		PageUrl = "/home/refer/boardConferenceList.jsp?gnb=43";     	}
if(cate_int == 44){	SubTitle="연구/교육자료";				TitleImg="title4";			SnbOn44="on";		PageUrl = "/home/refer/boardReferenceList.jsp?gnb=44";     	}
if(cate_int == 45){	SubTitle="공지사항";					TitleImg="title5";			SnbOn45="on";		PageUrl = "/home/refer/noticeList.jsp?gnb=45";     	}
if(cate_int == 46){	SubTitle="서비스길라잡이";			TitleImg="title6";			SnbOn46="on";		PageUrl = "/home/refer/serviceGuide.jsp?gnb=46";     	}
if(cate_int == 47){	SubTitle="자주하는 질문답변";		TitleImg="title7";			SnbOn47="on";		PageUrl = "/home/refer/faqList.jsp?gnb=47";		}


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>사이버대학 종합 정보</title>
	<link rel="stylesheet" type="text/css" href="<%=URL%>/css/layout.css" />
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/jquery.popupWindow.js"></script>
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/jquery.fadeSliderToggle.js"></script>
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/common.js"></script>
	
	   <script type="text/javascript" language="javascript">
    
    //onload 함수.
    window.onload = function(){
    	
    	$("#gnb li").find("div").hide();
    	$("li[id^=gnb] a").each(forEachMouseover);
    	$("div[id^=gnb_sub]").each(forEachMouseleave);
    	
    };
    
    function forEachMouseleave()
    {
    	$(this).mouseleave(function(){
    		$(this).slideUp("fast");
    	});
    }
    
    function forEachMouseover()
    {
    	$(this).mouseenter(function(){
    		$(this).parent().find("div").slideDown("fast",function(){
    			$("#gnb div:not(:animated)").slideUp("fast");
    		});
    	});
    }
    
    //검색
	function headerSearch()
	{
		alert("검색");
		
	}
    
    </script>
    
    
	
	<script type="text/javascript" language="javascript">
		
		
	</script>
	
</head>
<body class="main">
<div id="header"><!-- Header Start -->
	<h1><a href="<%=URL%>/index.jsp?">CUinfo</a></h1>

	<div id="header_link"><!-- top_link Start -->
		<ul class="header_link">
			<li class="link1"><a href="#">About CUinfo</a></li>
			<li class="link2"><a class="_sitemap_open" href="#">Site Map</a></li>
			<li class="link3"><a href="#">전체메뉴</a></li>
			<li class="link4"><a href="#">즐겨찾기</a></li>
			<li class="link5"><a href="#">KOCW</a></li>
			<li class="link6"><a href="#">RISS</a></li>
		</ul>
	</div><!-- top_link End -->

	<form action="#"><!-- box_type01 Start -->
		<fieldset class="top_search">
			<select	id="select-1" style="width:145px;" >
				<option value="">통합검색</option>
			</select>
			<input type="text" size="20" title="검색어입력"/><a class="btn" href="/home/search/combineSearch.jsp">검색</a>
		</fieldset>
	</form><!-- box_type01 End -->


	<div id="gnb">
		<ul><!-- banner_tab01 Start -->
			<li id="gnb1">
				<a href="<%=PageUrl11%>" onmouseover="javascript:gnb_on(1);"><%=GnbName1%></a>
				<div id="gnb_sub1">
					<a class="<%=SnbOn11%>" href="<%=PageUrl11%>"><%=SnbNmae11%></a>
					<a class="<%=SnbOn12%>" href="<%=PageUrl12%>"><%=SnbNmae12%></a>
					<a class="<%=SnbOn13%>" href="<%=PageUrl13%>"><%=SnbNmae13%></a>
					<a class="<%=SnbOn14%>" href="<%=PageUrl14%>"><%=SnbNmae14%></a>
					<a class="<%=SnbOn15%>" href="<%=PageUrl15%>"><%=SnbNmae15%></a>
				</div>
			</li>
			<li id="gnb2">
				<a href="<%=PageUrl21%>" onmouseover="javascript:gnb_on(2);"><%=GnbName2%></a>
				<div id="gnb_sub2">
					<a class="<%=SnbOn21%>" href="<%=PageUrl21%>"><%=SnbNmae21%></a>
					<a class="<%=SnbOn22%>" href="<%=PageUrl22%>"><%=SnbNmae22%></a>
					<a class="<%=SnbOn23%>" href="<%=PageUrl23%>"><%=SnbNmae23%></a>
				</div>
			</li>
			<li id="gnb3">
				<a href="<%=PageUrl31%>" onmouseover="javascript:gnb_on(3);"><%=GnbName3%></a>
				<div id="gnb_sub3">
					<a class="<%=SnbOn31%>" href="<%=PageUrl31%>"><%=SnbNmae31%></a>
					<a class="<%=SnbOn32%>" href="<%=PageUrl32%>"><%=SnbNmae32%></a>
					<a class="<%=SnbOn33%>" href="<%=PageUrl33%>"><%=SnbNmae33%></a>
					<a class="<%=SnbOn34%>" href="<%=PageUrl34%>"><%=SnbNmae34%></a>
					<a class="<%=SnbOn35%>" href="<%=PageUrl35%>"><%=SnbNmae35%></a>
				</div>
			</li>
			<li id="gnb4">
				<a href="<%=PageUrl41%>" onmouseover="javascript:gnb_on(4);"><%=GnbName4%></a>
				<div id="gnb_sub4">
					<a class="<%=SnbOn41%>" href="<%=PageUrl41%>"><%=SnbNmae41%></a>
					<a class="<%=SnbOn42%>" href="<%=PageUrl42%>"><%=SnbNmae42%></a>
					<a class="<%=SnbOn43%>" href="<%=PageUrl43%>"><%=SnbNmae43%></a>
					<a class="<%=SnbOn44%>" href="<%=PageUrl44%>"><%=SnbNmae44%></a>
					<a class="<%=SnbOn45%>" href="<%=PageUrl45%>"><%=SnbNmae45%></a>
					<a class="<%=SnbOn46%>" href="<%=PageUrl46%>"><%=SnbNmae46%></a>
					<a class="<%=SnbOn47%>" href="<%=PageUrl47%>"><%=SnbNmae47%></a>
				</div>
			</li>
		</ul><!-- banner_tab01 End -->
	</div>


</div><!-- Header End -->







</body>
</html>