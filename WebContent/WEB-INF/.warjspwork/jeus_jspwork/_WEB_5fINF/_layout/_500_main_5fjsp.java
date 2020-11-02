package jeus_jspwork._WEB_5fINF._layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class _500_main_5fjsp extends jeus.servlet.jsp.HttpJspBase {

  public final String[] __jeusGetIncludedJspFiles() {
    return new String[] {
      "/home/include/footer_main.jsp"
    };
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws ServletException, IOException {

    JspFactory	_jspxFactory = null;
    PageContext	pageContext = null;
    HttpSession	session = null;
    ServletContext	application = null;
    ServletConfig	config = null;
    JspWriter	out = null;
    Object		page = this;
    String		_value = null;

    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      pageContext = _jspxFactory.getPageContext(this, request, response, "", true, 8192, true);
      session = pageContext.getSession();
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();

      response.setContentType("text/html;charset=utf-8");

      out.write(_jspx_template0);
      out.write(_jspx_template1);
      out.write(_jspx_template2);
      out.write(_jspx_template3);
      out.write(_jspx_template4);
      // jsp code [from=(6,3);to=(107,1)]
      
      
      String gnb = request.getParameter("gnb");
      String URL = "/home";
      String BodyType = "";
      String GnbOn1  	= ""; String GnbOn2   = "";	String GnbOn3 	= ""; String GnbOn4  = "";
      String SnbOn11 	= ""; String SnbOn111 = ""; String SnbOn112 = "";String SnbOn113 = "";
      
      String SnbOn12 = ""; String SnbOn13 = ""; String SnbOn14 = ""; String SnbOn15 = ""; String SnbOn151 = ""; String SnbOn152 = ""; String SnbOn153 = ""; String SnbOn154 = ""; String SnbOn16 = "";
      String SnbOn21 	= ""; String SnbOn211 = ""; String SnbOn212 = ""; String SnbOn22 = ""; String SnbOn23 = "";
      String SnbOn31 	= ""; String SnbOn32  = ""; String SnbOn33 	= "";
      String SnbOn41 	= ""; String SnbOn42  = ""; String SnbOn43 	= ""; String SnbOn44 = ""; String SnbOn45 = "";String SnbOn46 = "";String SnbOn47 = "";
      String Category = "";
      String MainTitle= "";
      String SubTitle = "";
      String TitleImg = "";
      String PageID   = "";
      String PageType = "";
      String PageUrl 	= "/home/index.main.action";
      
      if(gnb == null){ gnb = "0"; }
      int cate_int = Integer.parseInt(gnb);
      
      
      String GnbName1   = "사이버대학안내";
      String SnbNmae11  = "사이버대학이란?";				String PageUrl11  = "/home/intro/summary.sub.action?gnb=11";
      String SnbNmae111 = "개요 및 특징";				String PageUrl111 = "/home/intro/summary.sub.action?gnb=111";
      String SnbNmae112 = "신입생/편입생 안내";			String PageUrl112 = "/home/intro/guidenew.sub.action?gnb=112";
      String SnbNmae113 = "시간제등록 안내";			String PageUrl113 = "/home/intro/guideTime.sub.action?gnb=113";
      String SnbNmae12  = "대학소개";					String PageUrl12  = "/home/intro/overall.sub.action?gnb=12";
      String SnbNmae13  = "학과 내비게이션";				String PageUrl13  = "/home/intro/navigationMajorArea.sub.action?gnb=13";
      String SnbNmae14  = "전체 학과 검색";				String PageUrl14  = "/home/intro/searchMajor.sub.action?gnb=14";
      String SnbNmae15  = "국가자격증(학위취득)";			String PageUrl15  = "/home/intro/certificate1.sub.action?gnb=15";
      String SnbNmae151 = "사회복지사";					String PageUrl151 = "/home/intro/certificate1.sub.action?gnb=151";
      String SnbNmae152 = "보육교사";					String PageUrl152 = "/home/intro/certificate2.sub.action?gnb=152";
      String SnbNmae153 = "평생교육사";					String PageUrl153 = "/home/intro/certificate3.sub.action?gnb=153";
      String SnbNmae154 = "건강가정사";					String PageUrl154 = "/home/intro/certificate4.sub.action?gnb=154";
      String SnbNmae16  = "길라잡이";					String PageUrl16  = "/home/refer/serviceGuide.sub.action?gnb=16";
      
      
      if(cate_int == 11 || cate_int == 111 || cate_int == 112 || cate_int == 113 || cate_int == 12 || cate_int == 13 || cate_int == 14 || cate_int == 15|| cate_int == 151|| cate_int == 152|| cate_int == 153|| cate_int == 154){	 MainTitle="사이버대학안내";		GnbOn1 = "on" ;	PageType = "intro" ;		Category = "/home/intro/summary.sub.action?gnb=11";}
      if(cate_int == 11) {SubTitle="사이버대학이란?";	TitleImg="title1";	SnbOn11="on"; SnbOn111="on"; PageUrl = "/home/intro/summary.sub.action?gnb=11";	}
      if(cate_int == 111){SubTitle="사이버대학이란?";	TitleImg="title1";	SnbOn11="on"; SnbOn111="on"; PageUrl = "/home/intro/summary.sub.action?gnb=111";	}
      if(cate_int == 112){SubTitle="사이버대학이란?";	TitleImg="title1";	SnbOn11="on"; SnbOn112="on"; PageUrl = "/home/intro/guidenew.sub.action?gnb=112";	}
      if(cate_int == 113){SubTitle="사이버대학이란?";	TitleImg="title1";	SnbOn11="on"; SnbOn113="on"; PageUrl = "/home/intro/guideTime.sub.action?gnb=113";	}
      if(cate_int == 12) {SubTitle="대학소개";			TitleImg="title2";	SnbOn12="on";				 PageUrl = "/home/intro/overall.sub.action?gnb=12";	}
      if(cate_int == 13) {SubTitle="학과 내비게이션";		TitleImg="title3";	SnbOn13="on";				 PageUrl = "/home/intro/navigationMajorArea.sub.action?gnb=13";	}
      if(cate_int == 14) {SubTitle="전체 학과검색";		TitleImg="title4";	SnbOn14="on";				 PageUrl = "/home/intro/searchMajor.sub.action?gnb=14";	}
      if(cate_int == 15) {SubTitle="국가자격증(학위취득)";	TitleImg="title5";	SnbOn15="on"; SnbOn151="on"; PageUrl = "/home/intro/certificate1.sub.action?gnb=151";	}
      if(cate_int == 151){SubTitle="국가자격증(학위취득)";	TitleImg="title5";	SnbOn15="on"; SnbOn151="on"; PageUrl = "/home/intro/certificate1.sub.action?gnb=151";	}
      if(cate_int == 152){SubTitle="국가자격증(학위취득)";	TitleImg="title5";	SnbOn15="on"; SnbOn152="on"; PageUrl = "/home/intro/certificate2.sub.action?gnb=152";	}
      if(cate_int == 153){SubTitle="국가자격증(학위취득)";	TitleImg="title5";	SnbOn15="on"; SnbOn153="on"; PageUrl = "/home/intro/certificate3.sub.action?gnb=153";	}
      if(cate_int == 154){SubTitle="국가자격증(학위취득)";	TitleImg="title5";	SnbOn15="on"; SnbOn154="on"; PageUrl = "/home/intro/certificate4.sub.action?gnb=154";	}
      if(cate_int == 16) {SubTitle="서비스 길라잡이";	TitleImg="title6";	SnbOn16="on";				 PageUrl = "/home/refer/serviceGuide.sub.action?gnb=16";     	}
      
      
      String GnbName2   = "입학 안내";
      String SnbNmae21  = "입학절차 안내";				String PageUrl21  = "/home/entr/enterStep_New.sub.action?gnb=211";
      String SnbNmae211 = "신입학/편입학";				String PageUrl211 = "/home/entr/enterStep_New.sub.action?gnb=211";
      String SnbNmae212 = "시간제 등록";					String PageUrl212 = "/home/entr/enterStep_Time.sub.action?gnb=212";
      String SnbNmae22  = "모집 요강";					String PageUrl22  = "/home/entr/enterGuide.sub.action?gnb=22";
      String SnbNmae23  = "대학 정보현황";				String PageUrl23  = "/home/entr/univStats.sub.action?gnb=23";
      
      if(cate_int == 21 || cate_int == 211 || cate_int == 212 || cate_int == 22 || cate_int == 23){	MainTitle="입학 안내";	GnbOn2 = "on" ;		PageType = "entr" ;		Category = "/home/entr/enterStep_New.sub.action?gnb=21";}
      if(cate_int == 21) {SubTitle="입학 절차안내";		TitleImg="title1";	SnbOn21="on"; SnbOn211="on"; PageUrl = "/home/entr/enterStep_New.sub.action?gnb=21";		}
      if(cate_int == 211){SubTitle="입학 절차안내";		TitleImg="title1";	SnbOn21="on"; SnbOn211="on"; PageUrl = "/home/entr/enterStep_New.sub.action?gnb=21";		}
      if(cate_int == 212){SubTitle="입학 절차안내";		TitleImg="title1";	SnbOn21="on"; SnbOn212="on"; PageUrl = "/home/entr/enterStep_Time.sub.action?gnb=21";		}
      if(cate_int == 22) {SubTitle="모집 요강";			TitleImg="title2";	SnbOn22="on";				 PageUrl = "/home/entr/enterGuide.sub.action?gnb=22";		}
      if(cate_int == 23) {SubTitle="대학정보 현황";		TitleImg="title3";	SnbOn23="on";				 PageUrl = "/home/entr/univStats.sub.action?gnb=23";		}
      
      
      String GnbName3   = "강의 검색";
      String SnbNmae31  = "강의명 검색";					String PageUrl31  = "/home/course/courseSearch.sub.action?gnb=31";
      String SnbNmae32  = "학과분야별 검색";				String PageUrl32  = "/home/course/searchByMajorArea.sub.action?gnb=32";
      String SnbNmae33  = "학교별 검색";					String PageUrl33  = "/home/course/searchByUniv.sub.action?gnb=33";
      
      
      if(cate_int == 31 || cate_int == 32 || cate_int == 33 ){	MainTitle="강의검색";		GnbOn3 = "on" ;	PageType = "course" ;		Category = "/home/course/courseSearch.sub.action?gnb=31";}
      if(cate_int == 31) {SubTitle="강의명 검색";		TitleImg="title1";	SnbOn31="on";				 PageUrl = "/home/course/courseSearch.sub.action?gnb=31";		}
      if(cate_int == 32) {SubTitle="학과분야별 검색";		TitleImg="title2";	SnbOn32="on";				 PageUrl = "/home/course/searchByMajorArea.sub.action?gnb=32";			}
      if(cate_int == 33) {SubTitle="학교별 검색";		TitleImg="title3";	SnbOn33="on";				 PageUrl = "/home/course/searchByUniv.sub.action?gnb=33";				}
      
      
      String GnbName4   = "정보 자료실";
      String SnbNmae41  = "연구/교육 자료";				String PageUrl41  = "/home/refer/board.sub.action?gnb=41&gID=153";
      String SnbNmae42  = "사이버대학 뉴스";				String PageUrl42  = "/home/refer/boardNews.sub.action?gnb=42";
      String SnbNmae43  = "대학행사 안내";				String PageUrl43  = "/home/refer/boardUniv.sub.action?gnb=43";
      String SnbNmae44  = "원격대학 협의회 동정";			String PageUrl44  = "/home/refer/board.sub.action?gnb=44&gID=152"; 
      String SnbNmae45  = "공지 사항";					String PageUrl45  = "/home/refer/board.sub.action?gnb=45&gID=154"; 
      String SnbNmae47  = "자주하는 질문답변";			String PageUrl47  = "/home/refer/faq.sub.action?gnb=47&gID=156";
      
      if(cate_int == 41 || cate_int == 42 || cate_int == 43 || cate_int == 44 || cate_int == 45 || cate_int == 46 || cate_int == 47){	MainTitle="정보자료실";	GnbOn4 = "on" ;	PageType = "refer" ;		Category = "/home/refer/board.sub.action?gnb=41";}
      if(cate_int == 41) {SubTitle="연구/교육자료";		TitleImg="title1";	SnbOn41="on";				 PageUrl = "/home/refer/board.sub.action?gnb=41&gID=153";      	}
      if(cate_int == 42) {SubTitle="사이버 대학뉴스";	TitleImg="title2";	SnbOn42="on";				 PageUrl = "/home/refer/boardNews.sub.action?gnb=42";     	}
      if(cate_int == 43) {SubTitle="대학행사 안내";		TitleImg="title3";	SnbOn43="on";				 PageUrl = "/home/refer/boardUniv.sub.action?gnb=43";     	}
      if(cate_int == 44) {SubTitle="원격대학 협의회 동정";	TitleImg="title4";	SnbOn44="on";				 PageUrl = "/home/refer/board.sub.action?gnb=44&gID=152";      	}
      if(cate_int == 45) {SubTitle="공지사항";			TitleImg="title5";	SnbOn45="on";				 PageUrl = "/home/refer/board.sub.action?gnb=45&gID=154";    	}
      if(cate_int == 47) {SubTitle="자주하는 질문답변";	TitleImg="title7";	SnbOn47="on";				 PageUrl = "/home/refer/faq.sub.action?gnb=47&gID=156";		}
      
      WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
      

      out.write(_jspx_template5);
      // ----  decorator:title ---- invoke //
      if (_jspx_th_decorator_title_0_fn(pageContext, null)) return;


      out.write(_jspx_template6);
      out.write(_jspx_template7);
      // ----  decorator:head ---- invoke //
      if (_jspx_th_decorator_head_0_fn(pageContext, null)) return;


      out.write(_jspx_template8);
      // jsp code [from=(422,17);to=(422,26)]
      out.print(PageUrl11);

      out.write(_jspx_template9);
      // jsp code [from=(422,33);to=(422,41)]
      out.print(GnbName1);

      out.write(_jspx_template10);
      // jsp code [from=(424,19);to=(424,26)]
      out.print(SnbOn11);

      out.write(_jspx_template11);
      // jsp code [from=(424,39);to=(424,48)]
      out.print(PageUrl11);

      out.write(_jspx_template12);
      // jsp code [from=(424,55);to=(424,64)]
      out.print(SnbNmae11);

      out.write(_jspx_template13);
      // jsp code [from=(425,19);to=(425,26)]
      out.print(SnbOn12);

      out.write(_jspx_template14);
      // jsp code [from=(425,39);to=(425,48)]
      out.print(PageUrl12);

      out.write(_jspx_template15);
      // jsp code [from=(425,55);to=(425,64)]
      out.print(SnbNmae12);

      out.write(_jspx_template16);
      // jsp code [from=(426,19);to=(426,26)]
      out.print(SnbOn13);

      out.write(_jspx_template17);
      // jsp code [from=(426,39);to=(426,48)]
      out.print(PageUrl13);

      out.write(_jspx_template18);
      // jsp code [from=(426,55);to=(426,64)]
      out.print(SnbNmae13);

      out.write(_jspx_template19);
      // jsp code [from=(427,19);to=(427,26)]
      out.print(SnbOn14);

      out.write(_jspx_template20);
      // jsp code [from=(427,39);to=(427,48)]
      out.print(PageUrl14);

      out.write(_jspx_template21);
      // jsp code [from=(427,55);to=(427,64)]
      out.print(SnbNmae14);

      out.write(_jspx_template22);
      // jsp code [from=(428,19);to=(428,26)]
      out.print(SnbOn15);

      out.write(_jspx_template23);
      // jsp code [from=(428,39);to=(428,48)]
      out.print(PageUrl15);

      out.write(_jspx_template24);
      // jsp code [from=(428,55);to=(428,64)]
      out.print(SnbNmae15);

      out.write(_jspx_template25);
      // jsp code [from=(429,19);to=(429,26)]
      out.print(SnbOn16);

      out.write(_jspx_template26);
      // jsp code [from=(429,39);to=(429,48)]
      out.print(PageUrl16);

      out.write(_jspx_template27);
      // jsp code [from=(429,55);to=(429,64)]
      out.print(SnbNmae16);

      out.write(_jspx_template28);
      // jsp code [from=(433,17);to=(433,26)]
      out.print(PageUrl21);

      out.write(_jspx_template29);
      // jsp code [from=(433,33);to=(433,41)]
      out.print(GnbName2);

      out.write(_jspx_template30);
      // jsp code [from=(435,19);to=(435,26)]
      out.print(SnbOn21);

      out.write(_jspx_template31);
      // jsp code [from=(435,39);to=(435,48)]
      out.print(PageUrl21);

      out.write(_jspx_template32);
      // jsp code [from=(435,55);to=(435,64)]
      out.print(SnbNmae21);

      out.write(_jspx_template33);
      // jsp code [from=(436,19);to=(436,26)]
      out.print(SnbOn22);

      out.write(_jspx_template34);
      // jsp code [from=(436,39);to=(436,48)]
      out.print(PageUrl22);

      out.write(_jspx_template35);
      // jsp code [from=(436,55);to=(436,64)]
      out.print(SnbNmae22);

      out.write(_jspx_template36);
      // jsp code [from=(437,19);to=(437,26)]
      out.print(SnbOn23);

      out.write(_jspx_template37);
      // jsp code [from=(437,39);to=(437,48)]
      out.print(PageUrl23);

      out.write(_jspx_template38);
      // jsp code [from=(437,55);to=(437,64)]
      out.print(SnbNmae23);

      out.write(_jspx_template39);
      // jsp code [from=(441,17);to=(441,26)]
      out.print(PageUrl31);

      out.write(_jspx_template40);
      // jsp code [from=(441,33);to=(441,41)]
      out.print(GnbName3);

      out.write(_jspx_template41);
      // jsp code [from=(443,19);to=(443,26)]
      out.print(SnbOn31);

      out.write(_jspx_template42);
      // jsp code [from=(443,39);to=(443,48)]
      out.print(PageUrl31);

      out.write(_jspx_template43);
      // jsp code [from=(443,55);to=(443,64)]
      out.print(SnbNmae31);

      out.write(_jspx_template44);
      // jsp code [from=(444,19);to=(444,26)]
      out.print(SnbOn32);

      out.write(_jspx_template45);
      // jsp code [from=(444,39);to=(444,48)]
      out.print(PageUrl32);

      out.write(_jspx_template46);
      // jsp code [from=(444,55);to=(444,64)]
      out.print(SnbNmae32);

      out.write(_jspx_template47);
      // jsp code [from=(445,19);to=(445,26)]
      out.print(SnbOn33);

      out.write(_jspx_template48);
      // jsp code [from=(445,39);to=(445,48)]
      out.print(PageUrl33);

      out.write(_jspx_template49);
      // jsp code [from=(445,55);to=(445,64)]
      out.print(SnbNmae33);

      out.write(_jspx_template50);
      // jsp code [from=(449,17);to=(449,26)]
      out.print(PageUrl41);

      out.write(_jspx_template51);
      // jsp code [from=(449,33);to=(449,41)]
      out.print(GnbName4);

      out.write(_jspx_template52);
      // jsp code [from=(451,19);to=(451,26)]
      out.print(SnbOn41);

      out.write(_jspx_template53);
      // jsp code [from=(451,39);to=(451,48)]
      out.print(PageUrl41);

      out.write(_jspx_template54);
      // jsp code [from=(451,55);to=(451,64)]
      out.print(SnbNmae41);

      out.write(_jspx_template55);
      // jsp code [from=(452,19);to=(452,26)]
      out.print(SnbOn42);

      out.write(_jspx_template56);
      // jsp code [from=(452,39);to=(452,48)]
      out.print(PageUrl42);

      out.write(_jspx_template57);
      // jsp code [from=(452,55);to=(452,64)]
      out.print(SnbNmae42);

      out.write(_jspx_template58);
      // jsp code [from=(453,19);to=(453,26)]
      out.print(SnbOn43);

      out.write(_jspx_template59);
      // jsp code [from=(453,39);to=(453,48)]
      out.print(PageUrl43);

      out.write(_jspx_template60);
      // jsp code [from=(453,55);to=(453,64)]
      out.print(SnbNmae43);

      out.write(_jspx_template61);
      // jsp code [from=(454,19);to=(454,26)]
      out.print(SnbOn44);

      out.write(_jspx_template62);
      // jsp code [from=(454,39);to=(454,48)]
      out.print(PageUrl44);

      out.write(_jspx_template63);
      // jsp code [from=(454,55);to=(454,64)]
      out.print(SnbNmae44);

      out.write(_jspx_template64);
      // jsp code [from=(455,19);to=(455,26)]
      out.print(SnbOn45);

      out.write(_jspx_template65);
      // jsp code [from=(455,39);to=(455,48)]
      out.print(PageUrl45);

      out.write(_jspx_template66);
      // jsp code [from=(455,55);to=(455,64)]
      out.print(SnbNmae45);

      out.write(_jspx_template67);
      // jsp code [from=(456,19);to=(456,26)]
      out.print(SnbOn47);

      out.write(_jspx_template68);
      // jsp code [from=(456,39);to=(456,48)]
      out.print(PageUrl47);

      out.write(_jspx_template69);
      // jsp code [from=(456,55);to=(456,64)]
      out.print(SnbNmae47);

      out.write(_jspx_template70);
      // jsp code [from=(464,32);to=(464,38)]
      out.print(GnbOn1);

      out.write(_jspx_template71);
      // jsp code [from=(465,14);to=(465,22)]
      out.print(GnbName1);

      out.write(_jspx_template72);
      // jsp code [from=(467,19);to=(467,26)]
      out.print(SnbOn11);

      out.write(_jspx_template73);
      // jsp code [from=(467,39);to=(467,48)]
      out.print(PageUrl11);

      out.write(_jspx_template74);
      // jsp code [from=(467,55);to=(467,64)]
      out.print(SnbNmae11);

      out.write(_jspx_template75);
      // jsp code [from=(469,19);to=(469,30)]
      out.print(PageUrl111 );

      out.write(_jspx_template76);
      // jsp code [from=(470,19);to=(470,30)]
      out.print(PageUrl112 );

      out.write(_jspx_template77);
      // jsp code [from=(471,19);to=(471,30)]
      out.print(PageUrl113 );

      out.write(_jspx_template78);
      // jsp code [from=(473,19);to=(473,26)]
      out.print(SnbOn12);

      out.write(_jspx_template79);
      // jsp code [from=(473,39);to=(473,48)]
      out.print(PageUrl12);

      out.write(_jspx_template80);
      // jsp code [from=(473,55);to=(473,64)]
      out.print(SnbNmae12);

      out.write(_jspx_template81);
      // jsp code [from=(474,19);to=(474,26)]
      out.print(SnbOn13);

      out.write(_jspx_template82);
      // jsp code [from=(474,39);to=(474,48)]
      out.print(PageUrl13);

      out.write(_jspx_template83);
      // jsp code [from=(474,55);to=(474,64)]
      out.print(SnbNmae13);

      out.write(_jspx_template84);
      // jsp code [from=(475,19);to=(475,26)]
      out.print(SnbOn14);

      out.write(_jspx_template85);
      // jsp code [from=(475,39);to=(475,48)]
      out.print(PageUrl14);

      out.write(_jspx_template86);
      // jsp code [from=(475,55);to=(475,64)]
      out.print(SnbNmae14);

      out.write(_jspx_template87);
      // jsp code [from=(476,19);to=(476,26)]
      out.print(SnbOn15);

      out.write(_jspx_template88);
      // jsp code [from=(476,39);to=(476,48)]
      out.print(PageUrl15);

      out.write(_jspx_template89);
      // jsp code [from=(476,55);to=(476,64)]
      out.print(SnbNmae15);

      out.write(_jspx_template90);
      // jsp code [from=(478,19);to=(478,30)]
      out.print(PageUrl151 );

      out.write(_jspx_template91);
      // jsp code [from=(479,19);to=(479,30)]
      out.print(PageUrl152 );

      out.write(_jspx_template92);
      // jsp code [from=(480,19);to=(480,30)]
      out.print(PageUrl153 );

      out.write(_jspx_template93);
      // jsp code [from=(481,19);to=(481,30)]
      out.print(PageUrl154 );

      out.write(_jspx_template94);
      // jsp code [from=(483,19);to=(483,26)]
      out.print(SnbOn16);

      out.write(_jspx_template95);
      // jsp code [from=(483,39);to=(483,48)]
      out.print(PageUrl16);

      out.write(_jspx_template96);
      // jsp code [from=(483,55);to=(483,64)]
      out.print(SnbNmae16);

      out.write(_jspx_template97);
      // jsp code [from=(486,32);to=(486,38)]
      out.print(GnbOn2);

      out.write(_jspx_template98);
      // jsp code [from=(487,14);to=(487,22)]
      out.print(GnbName2);

      out.write(_jspx_template99);
      // jsp code [from=(489,19);to=(489,26)]
      out.print(SnbOn21);

      out.write(_jspx_template100);
      // jsp code [from=(489,39);to=(489,48)]
      out.print(PageUrl21);

      out.write(_jspx_template101);
      // jsp code [from=(489,55);to=(489,64)]
      out.print(SnbNmae21);

      out.write(_jspx_template102);
      // jsp code [from=(491,19);to=(491,30)]
      out.print(PageUrl211 );

      out.write(_jspx_template103);
      // jsp code [from=(492,19);to=(492,30)]
      out.print(PageUrl212 );

      out.write(_jspx_template104);
      // jsp code [from=(495,19);to=(495,26)]
      out.print(SnbOn22);

      out.write(_jspx_template105);
      // jsp code [from=(495,39);to=(495,48)]
      out.print(PageUrl22);

      out.write(_jspx_template106);
      // jsp code [from=(495,55);to=(495,64)]
      out.print(SnbNmae22);

      out.write(_jspx_template107);
      // jsp code [from=(496,19);to=(496,26)]
      out.print(SnbOn23);

      out.write(_jspx_template108);
      // jsp code [from=(496,39);to=(496,48)]
      out.print(PageUrl23);

      out.write(_jspx_template109);
      // jsp code [from=(496,55);to=(496,64)]
      out.print(SnbNmae23);

      out.write(_jspx_template110);
      // jsp code [from=(499,32);to=(499,38)]
      out.print(GnbOn3);

      out.write(_jspx_template111);
      // jsp code [from=(500,14);to=(500,22)]
      out.print(GnbName3);

      out.write(_jspx_template112);
      // jsp code [from=(502,19);to=(502,26)]
      out.print(SnbOn31);

      out.write(_jspx_template113);
      // jsp code [from=(502,39);to=(502,48)]
      out.print(PageUrl31);

      out.write(_jspx_template114);
      // jsp code [from=(502,55);to=(502,64)]
      out.print(SnbNmae31);

      out.write(_jspx_template115);
      // jsp code [from=(503,19);to=(503,26)]
      out.print(SnbOn32);

      out.write(_jspx_template116);
      // jsp code [from=(503,39);to=(503,48)]
      out.print(PageUrl32);

      out.write(_jspx_template117);
      // jsp code [from=(503,55);to=(503,64)]
      out.print(SnbNmae32);

      out.write(_jspx_template118);
      // jsp code [from=(504,19);to=(504,26)]
      out.print(SnbOn33);

      out.write(_jspx_template119);
      // jsp code [from=(504,39);to=(504,48)]
      out.print(PageUrl33);

      out.write(_jspx_template120);
      // jsp code [from=(504,55);to=(504,64)]
      out.print(SnbNmae33);

      out.write(_jspx_template121);
      // jsp code [from=(507,32);to=(507,38)]
      out.print(GnbOn4);

      out.write(_jspx_template122);
      // jsp code [from=(508,14);to=(508,22)]
      out.print(GnbName4);

      out.write(_jspx_template123);
      // jsp code [from=(510,19);to=(510,26)]
      out.print(SnbOn41);

      out.write(_jspx_template124);
      // jsp code [from=(510,39);to=(510,48)]
      out.print(PageUrl41);

      out.write(_jspx_template125);
      // jsp code [from=(510,55);to=(510,64)]
      out.print(SnbNmae41);

      out.write(_jspx_template126);
      // jsp code [from=(511,19);to=(511,26)]
      out.print(SnbOn42);

      out.write(_jspx_template127);
      // jsp code [from=(511,39);to=(511,48)]
      out.print(PageUrl42);

      out.write(_jspx_template128);
      // jsp code [from=(511,55);to=(511,64)]
      out.print(SnbNmae42);

      out.write(_jspx_template129);
      // jsp code [from=(512,19);to=(512,26)]
      out.print(SnbOn43);

      out.write(_jspx_template130);
      // jsp code [from=(512,39);to=(512,48)]
      out.print(PageUrl43);

      out.write(_jspx_template131);
      // jsp code [from=(512,55);to=(512,64)]
      out.print(SnbNmae43);

      out.write(_jspx_template132);
      // jsp code [from=(513,19);to=(513,26)]
      out.print(SnbOn44);

      out.write(_jspx_template133);
      // jsp code [from=(513,39);to=(513,48)]
      out.print(PageUrl44);

      out.write(_jspx_template134);
      // jsp code [from=(513,55);to=(513,64)]
      out.print(SnbNmae44);

      out.write(_jspx_template135);
      // jsp code [from=(514,19);to=(514,26)]
      out.print(SnbOn45);

      out.write(_jspx_template136);
      // jsp code [from=(514,39);to=(514,48)]
      out.print(PageUrl45);

      out.write(_jspx_template137);
      // jsp code [from=(514,55);to=(514,64)]
      out.print(SnbNmae45);

      out.write(_jspx_template138);
      // jsp code [from=(515,19);to=(515,26)]
      out.print(SnbOn47);

      out.write(_jspx_template139);
      // jsp code [from=(515,39);to=(515,48)]
      out.print(PageUrl47);

      out.write(_jspx_template140);
      // jsp code [from=(515,55);to=(515,64)]
      out.print(SnbNmae47);

      out.write(_jspx_template141);
      // ----  decorator:body ---- invoke //
      if (_jspx_th_decorator_body_0_fn(pageContext, null)) return;


      out.write(_jspx_template142);
      out.write(_jspx_template143);
      out.write(_jspx_template144);

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)) {
        if (out.getBufferSize() != 0) {
          try {
            out.clear();
          } catch (Exception _exc) { }
        }
        pageContext.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(pageContext);
    }
  }
  private boolean _jspx_th_decorator_title_0_fn(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag _jspx_parentTag) throws Throwable {
    JspWriter	out = pageContext.getOut();
    HttpSession session = pageContext.getSession();
    ServletContext application = pageContext.getServletContext();
    HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

    // ----  decorator:title ---- //
    com.opensymphony.module.sitemesh.taglib.decorator.TitleTag _jspx_th_decorator_title_0 = new com.opensymphony.module.sitemesh.taglib.decorator.TitleTag();
    _jspx_th_decorator_title_0.setPageContext(pageContext);
    _jspx_th_decorator_title_0.setDefault("사이버대학포탈");
    try {
      int _jspx_eval_decorator_title_0 = _jspx_th_decorator_title_0.doStartTag();

      if (_jspx_th_decorator_title_0.doEndTag() == Tag.SKIP_PAGE)
        return true;
    } finally {
      _jspx_th_decorator_title_0.release();
    }
    return false;
  }

  private boolean _jspx_th_decorator_head_0_fn(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag _jspx_parentTag) throws Throwable {
    JspWriter	out = pageContext.getOut();
    HttpSession session = pageContext.getSession();
    ServletContext application = pageContext.getServletContext();
    HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

    // ----  decorator:head ---- //
    com.opensymphony.module.sitemesh.taglib.decorator.HeadTag _jspx_th_decorator_head_0 = new com.opensymphony.module.sitemesh.taglib.decorator.HeadTag();
    _jspx_th_decorator_head_0.setPageContext(pageContext);
    try {
      int _jspx_eval_decorator_head_0 = _jspx_th_decorator_head_0.doStartTag();

      if (_jspx_th_decorator_head_0.doEndTag() == Tag.SKIP_PAGE)
        return true;
    } finally {
      _jspx_th_decorator_head_0.release();
    }
    return false;
  }

  private boolean _jspx_th_decorator_body_0_fn(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag _jspx_parentTag) throws Throwable {
    JspWriter	out = pageContext.getOut();
    HttpSession session = pageContext.getSession();
    ServletContext application = pageContext.getServletContext();
    HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

    // ----  decorator:body ---- //
    com.opensymphony.module.sitemesh.taglib.decorator.BodyTag _jspx_th_decorator_body_0 = new com.opensymphony.module.sitemesh.taglib.decorator.BodyTag();
    _jspx_th_decorator_body_0.setPageContext(pageContext);
    try {
      int _jspx_eval_decorator_body_0 = _jspx_th_decorator_body_0.doStartTag();

      if (_jspx_th_decorator_body_0.doEndTag() == Tag.SKIP_PAGE)
        return true;
    } finally {
      _jspx_th_decorator_body_0.release();
    }
    return false;
  }

  private final static String _jspx_template0 = "\r\n";
  private final static String _jspx_template1 = "\r\n";
  private final static String _jspx_template2 = "\r\n";
  private final static String _jspx_template3 = "\r\n";
  private final static String _jspx_template4 = "\r\n";
  private final static String _jspx_template5 = "\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n<head>\r\n    <link rel=\"SHORTCUT ICON\" href=\"http://www.cuinfo.net/favicon.ico\" />\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n    <title>";
  private final static String _jspx_template6 = "</title>\r\n    \r\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"/home/css/layout.css\" />\r\n    <script type=\"text/javascript\" language=\"javascript\" src=\"/home/js/jquery-1.4.4.min.js\"></script>\r\n    <script type=\"text/javascript\" language=\"javascript\" src=\"/home/js/jquery.fadeSliderToggle.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/home/js/jquery.popupWindow.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/home/js/jquery.form.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/home/js/common.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/home/js/layout.js\"></script>    \r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/home/js/flashinside.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/home/mediaplayer/jwplayer.js\"></script>    \r\n\t<script type=\"text/javascript\" language=\"javascript\">\r\n    \r\n    //onload 함수.\r\n    window.onload = function(){\r\n    \t\r\n    \t$(\"#gnb li\").find(\"div\").hide();\r\n    \t$(\"li[id^=gnb] a\").each(forEachMouseover);\r\n    \t$(\"div[id^=gnb_sub]\").each(forEachMouseleave);\r\n    \t$(\"li[id^=gnb]\").each(forEachMouseleave1);\r\n    \t\r\n    \t//플래쉬 호출\r\n    \t//Flash2('flash','movie/main.swf','910','245','#ffffff','transparent');\r\n    \t\r\n    };\r\n    \r\n    function forEachMouseleave1()\r\n    {\r\n    \t$(this).mouseleave(function(){\r\n    \t\t$(this).find(\"div\").slideUp(\"fast\");\r\n    \t});\r\n    }\r\n    \r\n    function forEachMouseleave()\r\n    {\r\n    \t$(this).mouseleave(function(){\r\n    \t\t$(this).slideUp(\"fast\");\r\n    \t});\r\n    }\r\n    \r\n    function forEachMouseover()\r\n    {\r\n    \t$(this).mouseenter(function(){\r\n    \t\t$(this).parent().find(\"div\").slideDown(\"fast\",function(){\r\n    \t\t\t$(\"#gnb div:not(:animated)\").slideUp(\"fast\");\r\n    \t\t});\r\n    \t});\r\n    \t\r\n    \t\r\n    }\r\n    \r\n    //검색\r\n\tfunction headerSearch(page)\r\n\t{\r\n\t\tvar day = new Date(); \r\n\t\tvar y = day.getYear(); \r\n\t\tif(y<2000)y = y+1900; \r\n\t\tvar mon = day.getMonth() + 1; \r\n\t\tvar date = day.getDate();\r\n\t\t\r\n\t\tif(mon < 10)\r\n\t\t\tmon = \"0\" + mon;\r\n\t\tif(date < 10)\r\n\t\t\tdate = \"0\" + date;\r\n\t\t\t\r\n\t\t\r\n\t\tvar today = y + \"\" + (mon) + \"\" +date;\r\n    \tvar headerText = $(\"#headerText\").val();\r\n\r\n\t\t$(\"#currPage2\").val(page);\r\n\t\t\r\n    \t//$(\"body\").addClass(\"main\");\r\n    \tvar headerText = $(\"#headerText\").val();\r\n    \t\r\n    \tif(headerText == \"\")\r\n\t\t{\r\n    \t\talert(\"검색어를 입력 해주세요\");\r\n    \t\treturn;\r\n\t\t}\r\n    \t\r\n    \t//키워드 클릭 수 입력\r\n    \t\r\n    \t\r\n   \t\tjQuery.post('/home/search/keyword_save.ajax.action', \r\n   \t\t\t\t{keyword:headerText,regDT:today}, \r\n   \t\t\t\tfunction(data) {\r\n   \t\t\t\t\t\r\n   \t\t});\r\n    \t\r\n   \t\tjQuery.post('/home/search/combineSearch.ajax.action', \r\n   \t\t\t\t$(\"#headerForm\").formSerialize(), \r\n   \t\t\t\tfunction(data) {\r\n           \t\t\t$(\"#container\").html(data);\r\n           \t\t\t//searchGubn 값에 따라 show,hide\r\n           \t\t\tvar searchGubn = $(\"#searchGubn\").val();\r\n           \t\t\t$(\"#searchText\").text($(\"#headerText\").val());\r\n           \t\t\ttabClick(searchGubn);\r\n           \t\t\t$(\"#searchGubn2\").val(searchGubn);\r\n           \t\t\tdocument.location.href = \"#header\";\r\n           \t\t\t\r\n           \t\t\t\r\n           \t\t\tvar sort = $(\"#sort\").val();\r\n           \t\t\tif(sort == \"regDate\" || sort == \"\"){\r\n           \t\t    \t$(\".f_right a:even\").attr(\"class\",\"on\");\r\n           \t\t    \t$(\".f_right a:odd\").attr(\"class\",\"\");\r\n           \t    \t}\r\n           \t\t\telse{\r\n           \t\t    \t$(\".f_right a:even\").attr(\"class\",\"\");\r\n           \t\t    \t$(\".f_right a:odd\").attr(\"class\",\"on\");\r\n           \t    \t}\r\n   \t\t});\r\n\t}\r\n    \r\n    function tabClick(no)\r\n    {\r\n    \tvar searchGubn2 = $(\"#searchGubn2\").val();\r\n    \t\r\n    \t//탭변경후 보던 페이지와 다를경우 검색 페이징을 숨기고 검색을 실행한다.\r\n    \tif(no != searchGubn2){\r\n    \t\t$(\"#pg2\").hide();\r\n    \t\theaderSearch(1);\r\n    \t}\r\n    \t\r\n    \t$(\"div[id^=showDiv]\").hide();\r\n    \t$(\"#searchGubnTab li\").find(\"a\").removeClass();\r\n    \t$(\"#searchGubn option:eq(\"+no+\")\").attr(\"selected\",\"selected\");\r\n\t\tswitch(parseInt(no))\r\n\t\t{\r\n\t\t\tcase 0:\r\n\t\t\t\t//$(\"#tCnt\").text(parseInt($(\"#searchListCnt1\").text()) + parseInt($(\"#searchListCnt2\").text()) + parseInt($(\"#searchListCnt3\").text()));";
  private final static String _jspx_template7 = "\r\n\t\t\t\t$(\"div[id^=showDiv]\").show();\r\n\t\t\t\t$(\"#pg2\").hide();\r\n\t\t\t\t$(\"#searchGubnTab li:nth-child(1)\").find(\"a\").addClass(\"on\");\r\n\t\t\t\tbreak;\r\n\t\t\tcase 1:\r\n\t\t\t\t$(\"#showDiv1\").show();\r\n\t\t\t\t$(\"#tCnt\").text($(\"#searchListCnt1\").text());\r\n\t\t\t\t$(\"#searchGubnTab li:nth-child(2)\").find(\"a\").addClass(\"on\");\r\n\t\t\t\tbreak;\r\n\t\t\tcase 2:\r\n\t\t\t\t$(\"#showDiv2\").show();\r\n\t\t\t\t$(\"#tCnt\").text($(\"#searchListCnt2\").text());\r\n\t\t\t\t$(\"#searchGubnTab li:nth-child(3)\").find(\"a\").addClass(\"on\");\r\n\t\t\t\tbreak;\r\n\t\t\tcase 3:\r\n\t\t\t\t$(\"#showDiv3\").show();\r\n\t\t\t\t$(\"#tCnt\").text($(\"#searchListCnt3\").text());\r\n\t\t\t\t$(\"#searchGubnTab li:nth-child(4)\").find(\"a\").addClass(\"on\");\r\n\t\t\t\tbreak;\r\n\t\t}\r\n    \t\r\n    }\r\n    \r\n    function viewDetail1(courseId,courseIdentifier, title)\r\n\t{\r\n    \t\r\n    \tvar headerText = $(\"#headerText\").val();\r\n    \t\r\n    \t//alert(headerText + \":\" + title);\r\n    \t\r\n    \tdocument.location.href = '/home/course/viewDetail_header.sub.action?gnb=31&courseId='+courseId+'&courseIdentifier='+courseIdentifier+'&gnb=31&text='+escape(encodeURIComponent(headerText))+'&hideText='+escape(encodeURIComponent(title));\r\n    \t\r\n    \t\r\n\t}\r\n\r\n    function viewDetail2(gubn,id)\r\n\t{\r\n    \t\r\n    \tvar headerText = $(\"#headerText\").val();\r\n    \t\r\n    \tswitch(parseInt(gubn))\r\n    \t{\r\n\t    \tcase 1:\r\n\t    \t\tdocument.location.href = '/home/refer/boardUniv_view_header.sub.action?boardID='+id+'&gnb=42&searchText='+escape(encodeURIComponent(headerText));\r\n\t    \t\tbreak;\r\n\t    \tcase 2:\r\n\t    \t\tdocument.location.href = '/home/refer/board_view_header.sub.action?boardID='+id+'&gnb=45&searchText='+escape(encodeURIComponent(headerText))+'&gID=154';\r\n\t    \t\tbreak;\r\n\t    \tcase 3:\r\n\t    \t\tdocument.location.href = '/home/refer/faq_list_header.sub.action?faqContent='+escape(encodeURIComponent(headerText))+'&gnb=47&gID=156&selectRadio1=3';\r\n\t    \t\tbreak;\r\n    \t}\r\n    \t\r\n\t}\r\n\t\r\n    function viewMore(no)\r\n    {\r\n    \ttabClick(no);\r\n    \t$(\"#searchGubn\").val(no);\r\n    \theaderSearch(1);\r\n    }\r\n    \r\n\tfunction setRecordCnt2(totalCnt, currPage, totalPage, showCnt)\r\n\t{\r\n\t\t$(\"#cPage\").text(currPage);\r\n\t\t$(\"#tPage\").text(totalPage);\r\n\t\tsetPaging2($(\"#pg2\"), totalCnt, showCnt, currPage);\r\n\t}\r\n\t\r\n\tfunction showAllMenu()\r\n    {\r\n    \tif($(\"#sitemap\").css(\"display\") == \"none\")\r\n    \t\t$(\"#sitemap\").css(\"display\",\"block\");\r\n    \telse\r\n    \t\t$(\"#sitemap\").css(\"display\",\"none\");\r\n    }\r\n\t\r\n\tfunction clickKeyword(keyword)\r\n\t{\r\n\t\t\r\n\t\tvar day = new Date(); \r\n\t\tvar y = day.getYear(); \r\n\t\tif(y<2000)y = y+1900; \r\n\t\tvar mon = day.getMonth(); \r\n\t\tvar date = day.getDate(); \r\n\t\tvar today = y + \"\" + (mon+1) + \"\" +date;\r\n    \tvar headerText = $(\"#headerText\").val();\r\n\t\t\r\n\t\t//키워드 클릭 수 입력\r\n   \t\tjQuery.post('/mgr/stats/keyword_save.ajax.action', \r\n   \t\t\t\t{keyword:headerText,regDT:today}, \r\n   \t\t\t\tfunction(data) {\r\n   \t\t});\r\n\t\t//alert(keyword);\r\n\t\t$(\"#headerText\").val(keyword);\r\n\t\theaderSearch(1);\r\n\t}\r\n\t\r\n\tfunction viewMoreCourse()\r\n\t{\r\n\t\tdocument.location.href = \"/home/course/recommendByUniv.sub.action?gnb=35\";\r\n\t}\r\n    function bestCourseClick( title )\r\n    {\r\n    \t$(\"#headerText\").val(title);\r\n    \theaderSearch(1);\r\n    }\r\n    \r\n    function chgSort(str)\r\n    {\r\n    \tvar sort = $(\"#sort\").val(); \r\n    \t\r\n    \tif(sort == str)\r\n    \t\tchgOrder();\r\n    \telse\r\n    \t\t$(\"#order\").val(\"1\");\r\n    \t\r\n    \tvar sort = $(\"#sort\").val(); \r\n    \t$(\"#sort\").val(str);\r\n    \t\r\n    \tif(sort != str)\r\n    \t\theaderSearch(1);\r\n    }\r\n    \r\n    function chgOrder()\r\n    {\r\n    \tvar order = $(\"#order\").val();\r\n    \t\r\n    \tif(order == \"0\")\r\n    \t\t$(\"#order\").val(\"1\");\r\n    \tif(order == \"1\")\r\n    \t\t$(\"#order\").val(\"0\");\r\n    \theaderSearch(1);\r\n    }\r\n    \r\n    \r\n    </script>\r\n    \r\n    ";
  private final static String _jspx_template8 = "\r\n</head>\r\n\r\n<body class=\"main\">\r\n<div id=\"header\"><!-- Header Start -->\r\n\t<h1><a href=\"/home/index.main.action\">CUinfo</a></h1>\r\n\r\n\t<div id=\"header_link\"><!-- top_link Start -->\r\n\t\t<ul class=\"header_link\">\r\n\t\t\t<!--  li class=\"link1\"><a href=\"#\">About CUinfo</a></li>\r\n\t\t\t<li class=\"link2\"><a class=\"_sitemap_open\" href=\"#\">Site Map</a></li>-->\r\n\t\t\t<li class=\"link3\"><a class=\"_sitemap_open\" href=\"javascript:showAllMenu();\">전체메뉴</a></li>\r\n\t\t\t<li class=\"link4\"><a href=\"javascript:bookmark()\">즐겨찾기</a></li>\r\n\t\t\t<li class=\"link5\"><a href=\"http://www.kocw.net/\" target=\"_new\">KOCW</a></li>\r\n\t\t\t<li class=\"link6\"><a href=\"http://www.riss.kr/\" target=\"_new\">RISS</a></li>\r\n\t\t</ul>\r\n\t</div><!-- top_link End -->\r\n\r\n\t<form id=\"headerForm\" name=\"headerForm\" action=\"#\" onsubmit=\"try{headerSearch(1);}catch(e){alert(e);}return false;\"><!-- box_type01 Start -->\r\n\t<input type=\"hidden\" id=\"showCnt2\" name=\"showCnt2\" value=\"10\"/>\r\n\t<input type=\"hidden\" id=\"currPage2\" name=\"currPage2\" value=\"1\"/>\r\n\t<input type=\"hidden\" id=\"sort\" name=\"sort\" value=\"\"/>\r\n\t<input type=\"hidden\" id=\"order\" name=\"order\" value=\"0\"/>\r\n\t<input type=\"hidden\" id=\"searchGubn2\" name=\"searchGubn2\" value=\"\"/>\r\n\t\r\n\t\t<fieldset class=\"top_search\">\r\n\t\t\t<select\tid=\"searchGubn\" name=\"searchGubn\" style=\"width:145px;\" >\r\n\t\t\t\t<option value=\"0\">통합검색</option>\r\n\t\t\t\t<option value=\"1\">강의검색</option>\r\n\t\t\t\t<option value=\"2\">게시물검색</option>\r\n\t\t\t\t<option value=\"3\">웹문서</option>\r\n\t\t\t</select>\r\n\t\t\t<input type=\"text\" id=\"headerText\" name=\"headerText\" size=\"20\" title=\"검색어입력\"/><a class=\"btn\" href=\"javascript:headerSearch(1);\">검색</a>\r\n\t\t</fieldset>\r\n\t</form><!-- box_type01 End -->\r\n\r\n\r\n\t<div id=\"gnb\">\r\n\t\t<ul><!-- banner_tab01 Start -->\r\n\t\t\t<li id=\"gnb1\">\r\n\t\t\t\t<a href=\"";
  private final static String _jspx_template9 = "\">";
  private final static String _jspx_template10 = "</a>\r\n\t\t\t\t<div id=\"gnb_sub1\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template11 = "\" href=\"";
  private final static String _jspx_template12 = "\">";
  private final static String _jspx_template13 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template14 = "\" href=\"";
  private final static String _jspx_template15 = "\">";
  private final static String _jspx_template16 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template17 = "\" href=\"";
  private final static String _jspx_template18 = "\">";
  private final static String _jspx_template19 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template20 = "\" href=\"";
  private final static String _jspx_template21 = "\">";
  private final static String _jspx_template22 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template23 = "\" href=\"";
  private final static String _jspx_template24 = "\">";
  private final static String _jspx_template25 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template26 = "\" href=\"";
  private final static String _jspx_template27 = "\">";
  private final static String _jspx_template28 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t\t<li id=\"gnb2\">\r\n\t\t\t\t<a href=\"";
  private final static String _jspx_template29 = "\">";
  private final static String _jspx_template30 = "</a>\r\n\t\t\t\t<div id=\"gnb_sub2\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template31 = "\" href=\"";
  private final static String _jspx_template32 = "\">";
  private final static String _jspx_template33 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template34 = "\" href=\"";
  private final static String _jspx_template35 = "\">";
  private final static String _jspx_template36 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template37 = "\" href=\"";
  private final static String _jspx_template38 = "\">";
  private final static String _jspx_template39 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t\t<li id=\"gnb3\">\r\n\t\t\t\t<a href=\"";
  private final static String _jspx_template40 = "\">";
  private final static String _jspx_template41 = "</a>\r\n\t\t\t\t<div id=\"gnb_sub3\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template42 = "\" href=\"";
  private final static String _jspx_template43 = "\">";
  private final static String _jspx_template44 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template45 = "\" href=\"";
  private final static String _jspx_template46 = "\">";
  private final static String _jspx_template47 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template48 = "\" href=\"";
  private final static String _jspx_template49 = "\">";
  private final static String _jspx_template50 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t\t<li id=\"gnb4\">\r\n\t\t\t\t<a href=\"";
  private final static String _jspx_template51 = "\">";
  private final static String _jspx_template52 = "</a>\r\n\t\t\t\t<div id=\"gnb_sub4\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template53 = "\" href=\"";
  private final static String _jspx_template54 = "\">";
  private final static String _jspx_template55 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template56 = "\" href=\"";
  private final static String _jspx_template57 = "\">";
  private final static String _jspx_template58 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template59 = "\" href=\"";
  private final static String _jspx_template60 = "\">";
  private final static String _jspx_template61 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template62 = "\" href=\"";
  private final static String _jspx_template63 = "\">";
  private final static String _jspx_template64 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template65 = "\" href=\"";
  private final static String _jspx_template66 = "\">";
  private final static String _jspx_template67 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template68 = "\" href=\"";
  private final static String _jspx_template69 = "\">";
  private final static String _jspx_template70 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t</ul><!-- banner_tab01 End -->\r\n\t</div>\r\n\t<div id=\"sitemap\" style=\"display: none;\">\r\n\t\t<a href=\"javascript:showAllMenu();\" class=\"_sitemap_close\"><img alt=\"닫기\" src=\"/home/images/sitemap/close.gif\" /></a>\r\n\t\t<ul><!-- sitemap Start -->\r\n\t\t\t<li id=\"sitemap1\" class=\"";
  private final static String _jspx_template71 = "\">\r\n\t\t\t\t<span>";
  private final static String _jspx_template72 = "</span>\r\n\t\t\t\t<div id=\"sitegnb_sub1\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template73 = "\" href=\"";
  private final static String _jspx_template74 = "\">";
  private final static String _jspx_template75 = "</a>\r\n\t\t\t\t\t<div class=\"sitemap_sub\">\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template76 = "\">- 개요 및 특징</a>\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template77 = "\">- 신입생/편입생 안내</a>\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template78 = "\">- 시간제등록 안내</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template79 = "\" href=\"";
  private final static String _jspx_template80 = "\">";
  private final static String _jspx_template81 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template82 = "\" href=\"";
  private final static String _jspx_template83 = "\">";
  private final static String _jspx_template84 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template85 = "\" href=\"";
  private final static String _jspx_template86 = "\">";
  private final static String _jspx_template87 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template88 = "\" href=\"";
  private final static String _jspx_template89 = "\">";
  private final static String _jspx_template90 = "</a>\r\n\t\t\t\t\t<div class=\"sitemap_sub\">\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template91 = "\">- 사회복지사</a>\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template92 = "\">- 보육교사</a>\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template93 = "\">- 평생교육사</a>\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template94 = "\">- 건강가정사</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template95 = "\" href=\"";
  private final static String _jspx_template96 = "\">";
  private final static String _jspx_template97 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t\t<li id=\"sitemap2\" class=\"";
  private final static String _jspx_template98 = "\">\r\n\t\t\t\t<span>";
  private final static String _jspx_template99 = "</span>\r\n\t\t\t\t<div id=\"sitegnb_sub2\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template100 = "\" href=\"";
  private final static String _jspx_template101 = "\">";
  private final static String _jspx_template102 = "</a>\r\n\t\t\t\t\t<div class=\"sitemap_sub\">\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template103 = "\">- 신/입학</a>\r\n\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template104 = "\">- 시간제등록</a>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template105 = "\" href=\"";
  private final static String _jspx_template106 = "\">";
  private final static String _jspx_template107 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template108 = "\" href=\"";
  private final static String _jspx_template109 = "\">";
  private final static String _jspx_template110 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t\t<li id=\"sitemap3\" class=\"";
  private final static String _jspx_template111 = "\">\r\n\t\t\t\t<span>";
  private final static String _jspx_template112 = "</span>\r\n\t\t\t\t<div id=\"sitegnb_sub3\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template113 = "\" href=\"";
  private final static String _jspx_template114 = "\">";
  private final static String _jspx_template115 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template116 = "\" href=\"";
  private final static String _jspx_template117 = "\">";
  private final static String _jspx_template118 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template119 = "\" href=\"";
  private final static String _jspx_template120 = "\">";
  private final static String _jspx_template121 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t\t<li id=\"sitemap4\" class=\"";
  private final static String _jspx_template122 = "\">\r\n\t\t\t\t<span>";
  private final static String _jspx_template123 = "</span>\r\n\t\t\t\t<div id=\"sitegnb_sub4\">\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template124 = "\" href=\"";
  private final static String _jspx_template125 = "\">";
  private final static String _jspx_template126 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template127 = "\" href=\"";
  private final static String _jspx_template128 = "\">";
  private final static String _jspx_template129 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template130 = "\" href=\"";
  private final static String _jspx_template131 = "\">";
  private final static String _jspx_template132 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template133 = "\" href=\"";
  private final static String _jspx_template134 = "\">";
  private final static String _jspx_template135 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template136 = "\" href=\"";
  private final static String _jspx_template137 = "\">";
  private final static String _jspx_template138 = "</a>\r\n\t\t\t\t\t<a class=\"";
  private final static String _jspx_template139 = "\" href=\"";
  private final static String _jspx_template140 = "\">";
  private final static String _jspx_template141 = "</a>\r\n\t\t\t\t</div>\r\n\t\t\t</li>\r\n\t\t</ul><!-- sitemap End -->\r\n\t</div>   \r\n\t\r\n</div><!-- Header End -->\r\n";
  private final static String _jspx_template142 = "\r\n\r\n ";
  private final static String _jspx_template143 = "\t\r\n  <div class=\"copy_box\"><!-- copy_box  Start -->\r\n    \t<a target=\"_blank\" class=\"f_left\" href=\"http://www.keris.or.kr/\"><img src=\"/home/images/main/copy2.gif\" alt=\"KERIS\" /></a>\r\n    \t<ul>\r\n    \t\t<li><a target=\"_blank\" href=\"http://www.keris.or.kr/intro/it_status01.jsp\"><img src=\"/home/images/main/copy5.gif\" alt=\"자기소개\" /></a></li>\r\n    \t\t<li><a target=\"_blank\" href=\"/home/etc/copyright.main.action\"><img src=\"/home/images/main/copy6.gif\" alt=\"저작권신고\" /></a></li>\r\n    \t\t<li><a target=\"_blank\" href=\"/home/etc/location.main.action\"><img src=\"/home/images/main/copy7.gif\" alt=\"찾아오시는길\" /></a></li>\r\n    \t\t<li><a target=\"_blank\" href=\"http://www.keris.or.kr/\"><img src=\"/home/images/main/copy8.gif\" alt=\"[100-400] 서울특별시 중구 퇴계로 299(쌍림동 22-1) KEIS빌딩 TEL : 02)2119-1114 / FAX : 02)2278-4368 COPYRIGHT©2012 KERIS. ALL RIGHT RESERVED.\" /></a></li>\r\n    \t</ul>\r\n    \t<a target=\"_blank\" class=\"f_right\" href=\"http://www.kcou.org/kcue/\"><img src=\"/home/images/main/copy4.gif\" alt=\"한국원격대학협의회\" /></a>\r\n    \t<a target=\"_blank\" class=\"f_right\" href=\"http://www.mest.go.kr/main.do\"><img src=\"/home/images/main/copy3.gif\" alt=\"교육과학기술부\" /></a>\r\n\t</div><!-- copy_box  End -->\r\n\r\n";
  private final static String _jspx_template144 = "  \r\n</body>\r\n</html>";
}
