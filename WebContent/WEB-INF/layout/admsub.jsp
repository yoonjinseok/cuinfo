<%@page import="com.cyberup.model.admin.Authority"%>
<%@page import="java.util.List"%>
<%@page import="com.cyberup.model.admin.Admin"%>
<%@page import="com.cyberup.framework.model.SessionLoginInfo"%>
<%@page import="com.cyberup.framework.model.LoginInfo"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
 
<%

String gnb = request.getParameter("gnb");  
String URL = "/mgr";
String BodyType = "";
String GnbOn1 = ""; String GnbOn2 = ""; String GnbOn3 = ""; String GnbOn4 = ""; String GnbOn5 = ""; String GnbOn6 = ""; String GnbOn7 = "";
String SnbOn11 = ""; String SnbOn12 = ""; String SnbOn13 = "";
String SnbOn21 = ""; String SnbOn22 = ""; String SnbOn23 = ""; String SnbOn24 = ""; String SnbOn25 = ""; String SnbOn26 = "";
String SnbOn31 = ""; String SnbOn32 = ""; String SnbOn33 = ""; String SnbOn34 = ""; String SnbOn35 = "";
String SnbOn41 = ""; String SnbOn42 = ""; String SnbOn43 = ""; String SnbOn44 = ""; String SnbOn45 = "";String SnbOn46 = "";String SnbOn47 = "";
String SnbOn51 = ""; String SnbOn52 = ""; String SnbOn53 = ""; String SnbOn54 = "";
String SnbOn61 = ""; String SnbOn62 = ""; 
String MainCopyBox = "";
String MainCopyText = "";
String Category = ""; 
String MainTitle = ""; 
String SubTitle = "";
String TitleImg = "";
String PageType = "";
String PageUrl = "";

if(gnb == null){ gnb = "0"; }
int cate_int = Integer.parseInt(gnb);

 

// 학교/학사관리

String GnbName1 = "학교/학사관리";
String SnbNmae11 = "학교정보관리";						String PageUrl11 = "/mgr/univ/univInfo.sub.action?gnb=11";
String SnbNmae12 = "학과정보관리";						String PageUrl12 = "/mgr/univ/major.sub.action?gnb=12";
String SnbNmae13 = "대학정보현황";						String PageUrl13 = "/mgr/univ/univStats.sub.action?gnb=13";

if(cate_int == 11 || cate_int == 12 || cate_int == 13 || cate_int == 14){	 
	MainTitle="학교/학사관리";
	GnbOn1 = "on" ;	
	Category = "/mgr/univ/univInfo.sub.action?gnb=11";
	PageType = "univ";
}
if(cate_int == 11){	SubTitle="학교정보관리";			SnbOn11="on";	TitleImg="title1";	PageUrl = "/mgr/univ/univInfo.sub.action?gnb=11";	}
if(cate_int == 12){	SubTitle="학과정보관리";			SnbOn12="on";	TitleImg="title2";	PageUrl = "/mgr/univ/major.sub.action?gnb=12";	}
if(cate_int == 13){	SubTitle="대학정보현황";			SnbOn13="on";	TitleImg="title3";	PageUrl = "/mgr/univ/univStats.sub.action?gnb=13";	}



// 강좌메타관리

String GnbName2 = "강좌메타관리";
String SnbNmae21 = "메타수집/승인관리";				String PageUrl21 = "/mgr/course/metaCollection.sub.action?gnb=21";
String SnbNmae22 = "강좌정보관리";						String PageUrl22 = "/mgr/course/courseMgr.sub.action?gnb=22";
String SnbNmae23 = "DP서버관리";						String PageUrl23 = "/mgr/course/dpServer.sub.action?gnb=23";
String SnbNmae24 = "스케쥴관리";						String PageUrl24 = "/mgr/course/schedule.sub.action?gnb=24";
String SnbNmae25 = "유통기관관리";						String PageUrl25 = "/mgr/course/ctrOrgan.sub.action?gnb=25";
String SnbNmae26 = "수동스케쥴관리";						String PageUrl26 = "/mgr/course/ctrOrgan.sub.action?gnb=26";

if(cate_int == 21 || cate_int == 22 || cate_int == 23 || cate_int == 24 || cate_int == 25 || cate_int == 26){	
	MainTitle="강좌메타관리";	
	GnbOn2 = "on" ;	 
	Category = "/mgr/course/metaCollectionList.jsp?gnb=21";
	PageType = "course" ;
}
if(cate_int == 21){	SubTitle="메타수집/승인관리";		SnbOn21="on";	TitleImg="title1";	PageUrl = "/mgr/course/metaCollection.sub.action?gnb=21";		}
if(cate_int == 22){	SubTitle="강좌정보관리";			SnbOn22="on";	TitleImg="title2";	PageUrl = "/mgr/course/courseMgr.sub.action?gnb=22"; }
if(cate_int == 23){	SubTitle="DP서버관리";			SnbOn23="on";	TitleImg="title3";	PageUrl = "/mgr/course/dpServer.sub.action?gnb=23";		}
if(cate_int == 24){	SubTitle="스케쥴관리";			SnbOn24="on";	TitleImg="title4";	PageUrl = "/mgr/course/scheduleList.jsp?gnb=24";			}
if(cate_int == 25){	SubTitle="유통기관관리";			SnbOn25="on";	TitleImg="title5";	PageUrl = "/mgr/course/ctrOrganModify.jsp?gnb=25";			}
if(cate_int == 26){	SubTitle="수동스케쥴관리";			SnbOn26="on";	TitleImg="title6";	PageUrl = "/mgr/course/manualscheduleList.jsp?gnb=26";			}



// 통계현황
String GnbName3 = "통계현황";
String SnbNmae31 = "강좌등록통계";					String PageUrl31 = "/mgr/stats/courseByPeriod.sub.action?gnb=31";
String SnbNmae32 = "서비스조회수 통계";				String PageUrl32 = "/mgr/stats/courseHits.sub.action?gnb=32";
String SnbNmae33 = "검색통계";						String PageUrl33 = "/mgr/stats/keywordStats.sub.action?gnb=33";
String SnbNmae34 = "사이트 통계";						String PageUrl34 = "/mgr/stats/webtrend.sub.action?gnb=34";

if(cate_int == 31 || cate_int == 32 || cate_int == 33|| cate_int == 34|| cate_int == 35){	
	MainTitle="통계현황";		
	GnbOn3 = "on" ;	 
	Category = "/mgr/stats/courseByPeriod.jsp?gnb=31";
	PageType = "stats" ;
}
if(cate_int == 31){	SubTitle="강좌등록통계";			SnbOn31="on";	TitleImg="title1";	PageUrl = "/mgr/stats/courseByPeriod.sub.action?gnb=31";		}
if(cate_int == 32){	SubTitle="서비스조회수 통계";		SnbOn32="on";	TitleImg="title2";	PageUrl = "/mgr/stats/courseHits.sub.action?gnb=32";			}
if(cate_int == 33){	SubTitle="검색통계";				SnbOn33="on";	TitleImg="title3";	PageUrl = "/mgr/stats/keywordStats.sub.action?gnb=33";			}	
if(cate_int == 34){	SubTitle="사이트 통계";			SnbOn33="on";	TitleImg="title4";	PageUrl = "/mgr/stats/webtrend.sub.action?gnb=34";				}	


//홈페이지관리
String GnbName4 = "홈페이지관리";
String SnbNmae41 = "사이버대학뉴스";					String PageUrl41 = "/mgr/home/newsFeed.sub.action?gnb=41";
String SnbNmae42 = "대학행사안내";					String PageUrl42 = "/mgr/home/boardUniv.sub.action?gnb=42";
String SnbNmae43 = "원격대학협의회동정";				String PageUrl43 = "/mgr/home/board.sub.action?gnb=43&gID=152"; 
String SnbNmae44 = "연구/교육 자료";					String PageUrl44 = "/mgr/home/board.sub.action?gnb=44&gID=153"; 
String SnbNmae45 = "공지사항";						String PageUrl45 = "/mgr/home/board.sub.action?gnb=45&gID=154"; 
String SnbNmae46 = "FAQ관리";						String PageUrl46 = "/mgr/home/faq.sub.action?gnb=46";
String SnbNmae47 = "팝업관리";						String PageUrl47 = "/mgr/home/poup.sub.action?gnb=47";


if(cate_int == 41 || cate_int == 42 || cate_int == 43 || cate_int == 44 || cate_int == 45 || cate_int == 46|| cate_int == 47){	
	MainTitle="홈페이지관리";	
	GnbOn4 = "on" ;	 
	Category = "/mgr/home/newsFeedList.jsp?gnb=41";
	PageType = "home" ;	
}
if(cate_int == 41){	SubTitle="사이버대학뉴스";			SnbOn41="on";	TitleImg="title1";	PageUrl = "/mgr/home/newsFeed.sub.action?gnb=41";     	}
if(cate_int == 42){	SubTitle="대학행사안내";			SnbOn42="on";	TitleImg="title2";	PageUrl = "/mgr/home/boardUniv.sub.action?gnb=42";     	}
if(cate_int == 43){	SubTitle="원격대학협의회동정";		SnbOn43="on";	TitleImg="title3";	PageUrl = "/mgr/home/board.sub.action?gnb=43&gID=152";    	}
if(cate_int == 44){	SubTitle="연구/교육 자료";			SnbOn44="on";	TitleImg="title4";	PageUrl = "/mgr/home/board.sub.action?gnb=44&gID=153";    	}
if(cate_int == 45){	SubTitle="공지사항";				SnbOn45="on";	TitleImg="title5";	PageUrl = "/mgr/home/board.sub.action?gnb=45&gID=154";    	}
if(cate_int == 46){	SubTitle="FAQ관리";				SnbOn46="on";	TitleImg="title6";	PageUrl = "/mgr/home/faq.sub.action?gnb=46";     	}
if(cate_int == 47){	SubTitle="팝업관리";				SnbOn47="on";	TitleImg="title7";	PageUrl = "/mgr/home/poup.sub.action?gnb=47";     	}


//교과부통계관리
String GnbName6 = "교과부통계";
String SnbNmae61 = "대학별통계 문서관리";				String PageUrl61 = "/mgr/educ/univStt.sub.action?gnb=61";
String SnbNmae62 = "통계 문서관리";					String PageUrl62 = "/mgr/educ/statisitics.sub.action?gnb=62";

if(cate_int == 61 || cate_int == 62){	
	MainTitle="교과부통계";		
	GnbOn6 = "on" ;	 
	Category = "/mgr/educ/univStt.sub.action?gnb=61";
	PageType = "educ" ;
}
if(cate_int == 61){	SubTitle="대학별통계 문서관리";		SnbOn61="on";	TitleImg="title1";	PageUrl = "/mgr/educ/univStt.sub.action?gnb=61";			}
if(cate_int == 62){	SubTitle="통계 문서관리";		SnbOn62="on";	TitleImg="title2";	PageUrl = "/mgr/educ/statisitics.sub.action?gnb=62";				}



//시스템관리
String GnbName5 = "시스템관리";
String SnbNmae51 = "시스템코드관리";					String PageUrl51 = "/mgr/system/code.sub.action?gnb=51";
String SnbNmae52 = "학과관리";						String PageUrl52 = "/mgr/system/majorCode.sub.action?gnb=52";
String SnbNmae53 = "학교코드관리";						String PageUrl53 = "/mgr/system/univCode.sub.action?gnb=53";
String SnbNmae54 = "관리자정보관리";					String PageUrl54 = "/mgr/system/admin.sub.action?gnb=54";

if(cate_int == 51 || cate_int == 52 || cate_int == 53 || cate_int == 54){	 
	MainTitle="시스템관리"; 	
	GnbOn5 = "on" ;	 
	Category = "/mgr/system/codeList.jsp?gnb=51";
	PageType = "system";
}
if(cate_int == 51){	SubTitle="시스템코드관리";		SnbOn51="on";	TitleImg="title1";	PageUrl = "/mgr/system/code.sub.action?gnb=51";		}
if(cate_int == 52){	SubTitle="학과관리";			SnbOn52="on";	TitleImg="title2";	PageUrl = "/mgr/system/majorCode.sub.action?gnb=52";			}
if(cate_int == 53){	SubTitle="학교코드관리";		SnbOn53="on";	TitleImg="title3";	PageUrl = "/mgr/system/univCode.sub.action?gnb=53";			}
if(cate_int == 54){	SubTitle="관리자정보관리";		SnbOn54="on";	TitleImg="title4";	PageUrl = "/mgr/system/admin.sub.action?gnb=54";		}

WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

LoginInfo loginInfo = (LoginInfo)session.getAttribute("sessionLoginInfo");
Admin admin = (Admin)loginInfo.currentUser();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<link rel="SHORTCUT ICON" href="http://www.cuinfo.net/favicon.ico" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CUinfo 관리시스템 > <decorator:title /></title>
<!-- 	<script type="text/javascript" src="/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script> -->
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery.form.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/common.js"></script>
	<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script type="text/javascript" language="javascript" src="/js/jquery.tooltip.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/jquery.tooltip.css" />
	<link rel="stylesheet" type="text/css" href="/mgr/css/layout.css" />
	<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
    
    <decorator:head />
    
    <script type="text/javascript" language="javascript">
	function logout()
	{
		jQuery.post('/mgr/user/logout.json', 
				'', 
				function(data) {
        			if(data.errors == true)
        			{
        				eval(data.message);
        			}
        			else
        			{
        				document.location.href = "/mgr";
        			}
			});
	}

	function infoModify()
	{
		showWin('/mgr/user/modify.pop.action', 'infomodify', 800, 500);
	}
	
	$(document).ready(function(){
		applyListStyle();
	});
	
	function excelUpload()
	{
		var pop = window.open("/mgr/excel.jsp","excel","width=800,height=600,scrollbars=yes,toolbar=no,location=no,status=yes");
		
		if(pop)
			pop.focus();
		
	}
	
	
	
	</script>
	
</head>
<body id="<%=PageType%>">
	<div id="header"><!-- Header Start -->
	<h1><a href="<%=URL%>/main.sub.action"><img src="/mgr/images/layout/header_logo.gif" alt="CUinfo 관리시스템" /></a></h1>

		<ul class="header_link">
			<li><b><%=loginInfo.currentUser().getUserName() %></b>님 좋은 하루 되세요! 
				     <%if(((Admin)loginInfo.currentUser()).getAuthLevelId().toString().equals("3") && !"0".equals( ((Admin)loginInfo.currentUser()).getSttFileCnt())) { %> &nbsp;&nbsp;미등록 교과부 통계  <b> <%=((Admin)loginInfo.currentUser()).getSttFileCnt()%></b> 개 <%} %></li>
			<li><a href="javascript:logout();"><img src="/mgr/images/btn/logout.gif" alt="로그아웃" /></a></li>
			<li><a href="javascript:infoModify();"><img src="/mgr/images/btn/modify.gif" alt="정보수정" /></a></li>
			<li>&nbsp;&nbsp;<a href="javascript:excelUpload();">&nbsp;</a></li>
		</ul>

		<ul id="gnb"><!-- Gnb Start -->
			<%
			List<Authority> menus = null;
			for(int i = 1; i <= admin.getAuthGroups().size(); i++)
			{
				menus = admin.getAllowMenus(admin.getAuthGroups().get(i-1).getGroupId());

				%>
				<li id="gnb<%=menus.get(0).getMenuId().toString().substring(1,2) %>" class="<%
					if(i == 1) out.println(GnbOn1); 
					if(i == 2) out.println(GnbOn2);
					if(i == 3) out.println(GnbOn3);
					if(i == 4) out.println(GnbOn4);
					if(i == 5) out.println(GnbOn5);
					if(i == 6) out.println(GnbOn6);
				%>">
					<a href="<%=menus.get(0).getMenuPath()%>" onmouseover="javascript:gnb_on(<%=menus.get(0).getMenuId().toString().substring(1,2)%>);"><%
						if(i == 1) out.println(GnbName1); 
						if(i == 2) out.println(GnbName2);
						if(i == 3) out.println(GnbName3);
						if(i == 4) out.println(GnbName4);
						if(i == 5) out.println(GnbName5);
						if(i == 6) out.println(GnbName6);
					%></a>
					<div id="gnb_sub<%=menus.get(0).getMenuId().toString().substring(1,2) %>" <%if(((Admin)loginInfo.currentUser()).getAuthLevelId().toString().equals("3") && "6".equals(menus.get(0).getMenuId().toString().substring(1,2))) { %> style="left:245px;" <%} %>>
						 
						<%
						for(int k = 1; k <= menus.size(); k++)
						{
							%>
							<a href="<%=menus.get(k-1).getMenuPath()%>" class="<%=(menus.get(k-1).getMenuId().endsWith(String.valueOf(cate_int)))?"on":""%>"><%=menus.get(k-1).getMenuName()%></a>
							<%
						}
						%>
					</div>
				</li>
				<%
			}
			%>
		</ul><!-- banner_tab01 End -->
		
		<div class="logo_link"><!-- logo_link Start -->
			<a href="/home/index.main.action" target="_blank">CU info</a> |  <a href="http://www.kocw.net" target="_blank">KOCW</a>  |  <a href="http://www.riss.kr/" target="_blank">RISS</a>
		</div><!-- logo_link End -->
		
	</div><!-- Header End -->
	
	<%
	if(gnb != null && !"0".equals(gnb))
	{
	%>
	<div id="container"><!-- container Start -->

	<div id="snb">
		<h2><%=MainTitle%></h2>
		<ul>		
			<%
			if(gnb != null && !"0".equals(gnb))
			{
				List<Authority> submenus = admin.getAllowMenus("M" + gnb.substring(0, 1));
				for(int k = 1; k <= submenus.size(); k++)
				{
					%>
					<li id="snb<%=submenus.get(k-1).getMenuId().toString().substring(2,3) %>" class="<%=(submenus.get(k-1).getMenuId().endsWith(String.valueOf(cate_int)))?"on":""%>"><a href="<%=submenus.get(k-1).getMenuPath()%>"><%=submenus.get(k-1).getMenuName()%></a></li>
					<%
				}
			}
			%>
		</ul>
	</div>


	<div id="contents"><!-- Contents End -->
	<%
	} 
	%>
	
    <div id=content-area>
    <!----  START OF :: 컨텐츠 영역 ---->
    <decorator:body />
    <!----  END OF :: 컨텐츠 영역 ---->
    </div>
    
    <%
	if(gnb != null && !"0".equals(gnb))
	{ 
	%>
    </div>
    </div>
    <%
	} 
	%>

	<%@ include file="/mgr/include/footer.jsp" %>

</body>
</html>