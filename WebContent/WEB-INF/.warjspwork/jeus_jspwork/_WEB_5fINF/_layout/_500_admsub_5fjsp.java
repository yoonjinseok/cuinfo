package jeus_jspwork._WEB_5fINF._layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import com.cyberup.model.admin.Authority;
import java.util.List;
import com.cyberup.model.admin.Admin;
import com.cyberup.framework.model.SessionLoginInfo;
import com.cyberup.framework.model.LoginInfo;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class _500_admsub_5fjsp extends jeus.servlet.jsp.HttpJspBase {

  public final String[] __jeusGetIncludedJspFiles() {
    return new String[] {
      "/mgr/include/footer.jsp"
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
      out.write(_jspx_template5);
      out.write(_jspx_template6);
      out.write(_jspx_template7);
      out.write(_jspx_template8);
      out.write(_jspx_template9);
      // jsp code [from=(12,3);to=(146,1)]
      
      
      String gnb = request.getParameter("gnb");  
      String URL = "/mgr";
      String BodyType = "";
      String GnbOn1 = ""; String GnbOn2 = ""; String GnbOn3 = ""; String GnbOn4 = ""; String GnbOn5 = ""; String GnbOn6 = ""; String GnbOn7 = "";
      String SnbOn11 = ""; String SnbOn12 = ""; String SnbOn13 = "";
      String SnbOn21 = ""; String SnbOn22 = ""; String SnbOn23 = ""; String SnbOn24 = ""; String SnbOn25 = ""; String SnbOn26 = "";
      String SnbOn31 = ""; String SnbOn32 = ""; String SnbOn33 = "";
      String SnbOn41 = ""; String SnbOn42 = ""; String SnbOn43 = ""; String SnbOn44 = ""; String SnbOn45 = "";String SnbOn46 = "";String SnbOn47 = "";
      String SnbOn51 = ""; String SnbOn52 = ""; String SnbOn53 = ""; String SnbOn54 = "";
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
      String SnbNmae33 = "검색통계";					String PageUrl33 = "/mgr/stats/keywordStats.sub.action?gnb=33";
      
      if(cate_int == 31 || cate_int == 32 || cate_int == 33){	
      	MainTitle="통계현황";		
      	GnbOn3 = "on" ;	 
      	Category = "/mgr/stats/courseByPeriod.jsp?gnb=31";
      	PageType = "stats" ;
      }
      if(cate_int == 31){	SubTitle="강좌등록통계";			SnbOn31="on";	TitleImg="title1";	PageUrl = "/mgr/stats/courseByPeriod.sub.action?gnb=31";			}
      if(cate_int == 32){	SubTitle="서비스조회수 통계";		SnbOn32="on";	TitleImg="title2";	PageUrl = "/mgr/stats/courseHits.sub.action?gnb=32";				}
      if(cate_int == 33){	SubTitle="검색통계";				SnbOn33="on";	TitleImg="title3";	PageUrl = "/mgr/stats/keywordStats.sub.action?gnb=33";		}	
      																	                                                                       
      
      
      //홈페이지관리
      String GnbName4 = "홈페이지관리";
      String SnbNmae41 = "사이버대학뉴스";					String PageUrl41 = "/mgr/home/newsFeed.sub.action?gnb=41";
      String SnbNmae42 = "대학행사안내";						String PageUrl42 = "/mgr/home/boardUniv.sub.action?gnb=42";
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

      out.write(_jspx_template10);
      // ----  decorator:title ---- invoke //
      if (_jspx_th_decorator_title_0_fn(pageContext, null)) return;


      out.write(_jspx_template11);
      // ----  decorator:head ---- invoke //
      if (_jspx_th_decorator_head_0_fn(pageContext, null)) return;


      out.write(_jspx_template12);
      // jsp code [from=(205,14);to=(205,22)]
      out.print(PageType);

      out.write(_jspx_template13);
      // jsp code [from=(207,18);to=(207,21)]
      out.print(URL);

      out.write(_jspx_template14);
      // jsp code [from=(210,14);to=(210,52)]
      out.print(loginInfo.currentUser().getUserName() );

      out.write(_jspx_template15);
      // jsp code [from=(217,6);to=(223,5)]
      
      			List<Authority> menus = null;
      			for(int i = 1; i <= admin.getAuthGroups().size(); i++)
      			{
      				menus = admin.getAllowMenus(admin.getAuthGroups().get(i-1).getGroupId());
      
      				

      out.write(_jspx_template16);
      // jsp code [from=(224,19);to=(224,70)]
      out.print(menus.get(0).getMenuId().toString().substring(1,2) );

      out.write(_jspx_template17);
      // jsp code [from=(224,83);to=(230,5)]
      
      					if(i == 1) out.println(GnbOn1); 
      					if(i == 2) out.println(GnbOn2);
      					if(i == 3) out.println(GnbOn3);
      					if(i == 4) out.println(GnbOn4);
      					if(i == 5) out.println(GnbOn5);
      				

      out.write(_jspx_template18);
      // jsp code [from=(231,18);to=(231,44)]
      out.print(menus.get(0).getMenuPath());

      out.write(_jspx_template19);
      // jsp code [from=(231,82);to=(231,132)]
      out.print(menus.get(0).getMenuId().toString().substring(1,2));

      out.write(_jspx_template20);
      // jsp code [from=(231,140);to=(237,6)]
      
      						if(i == 1) out.println(GnbName1); 
      						if(i == 2) out.println(GnbName2);
      						if(i == 3) out.println(GnbName3);
      						if(i == 4) out.println(GnbName4);
      						if(i == 5) out.println(GnbName5);
      					

      out.write(_jspx_template21);
      // jsp code [from=(238,25);to=(238,76)]
      out.print(menus.get(0).getMenuId().toString().substring(1,2) );

      out.write(_jspx_template22);
      // jsp code [from=(240,9);to=(243,8)]
      
      						for(int k = 1; k <= menus.size(); k++)
      						{
      							

      out.write(_jspx_template23);
      // jsp code [from=(244,20);to=(244,48)]
      out.print(menus.get(k-1).getMenuPath());

      out.write(_jspx_template24);
      // jsp code [from=(244,62);to=(244,133)]
      out.print((menus.get(k-1).getMenuId().endsWith(String.valueOf(cate_int)))?"on":"");

      out.write(_jspx_template25);
      // jsp code [from=(244,140);to=(244,168)]
      out.print(menus.get(k-1).getMenuName());

      out.write(_jspx_template26);
      // jsp code [from=(245,10);to=(247,7)]
      
      						}
      						

      out.write(_jspx_template27);
      // jsp code [from=(250,7);to=(252,4)]
      
      			}
      			

      out.write(_jspx_template28);
      // jsp code [from=(261,4);to=(264,2)]
      
      	if(gnb != null && !"0".equals(gnb))
      	{
      	

      out.write(_jspx_template29);
      // jsp code [from=(268,10);to=(268,19)]
      out.print(MainTitle);

      out.write(_jspx_template30);
      // jsp code [from=(270,6);to=(276,6)]
      
      			if(gnb != null && !"0".equals(gnb))
      			{
      				List<Authority> submenus = admin.getAllowMenus("M" + gnb.substring(0, 1));
      				for(int k = 1; k <= submenus.size(); k++)
      				{
      					

      out.write(_jspx_template31);
      // jsp code [from=(277,20);to=(277,76)]
      out.print(submenus.get(k-1).getMenuId().toString().substring(2,3) );

      out.write(_jspx_template32);
      // jsp code [from=(277,90);to=(277,164)]
      out.print((submenus.get(k-1).getMenuId().endsWith(String.valueOf(cate_int)))?"on":"");

      out.write(_jspx_template33);
      // jsp code [from=(277,180);to=(277,211)]
      out.print(submenus.get(k-1).getMenuPath());

      out.write(_jspx_template34);
      // jsp code [from=(277,218);to=(277,249)]
      out.print(submenus.get(k-1).getMenuName());

      out.write(_jspx_template35);
      // jsp code [from=(278,8);to=(281,4)]
      
      				}
      			}
      			

      out.write(_jspx_template36);
      // jsp code [from=(287,4);to=(289,2)]
      
      	} 
      	

      out.write(_jspx_template37);
      // ----  decorator:body ---- invoke //
      if (_jspx_th_decorator_body_0_fn(pageContext, null)) return;


      out.write(_jspx_template38);
      // jsp code [from=(297,7);to=(300,2)]
      
      	if(gnb != null && !"0".equals(gnb))
      	{ 
      	

      out.write(_jspx_template39);
      // jsp code [from=(303,7);to=(305,2)]
      
      	} 
      	

      out.write(_jspx_template40);
      out.write(_jspx_template41);
      out.write(_jspx_template42);

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
  private final static String _jspx_template5 = "\r\n";
  private final static String _jspx_template6 = "\r\n";
  private final static String _jspx_template7 = "\r\n";
  private final static String _jspx_template8 = "\r\n";
  private final static String _jspx_template9 = "\r\n \r\n";
  private final static String _jspx_template10 = "\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n<head>\r\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\t<title>CUinfo 관리시스템 > ";
  private final static String _jspx_template11 = "</title>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/mgr/js/jquery-1.4.4.min.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/mgr/js/jquery.form.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/mgr/js/common.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/js/jquery.tooltip.js\"></script>\r\n\t\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/jquery.tooltip.css\" />\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/mgr/css/layout.css\" />\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css\" />\r\n    \r\n    ";
  private final static String _jspx_template12 = "\r\n    \r\n    <script type=\"text/javascript\" language=\"javascript\">\r\n\tfunction logout()\r\n\t{\r\n\t\tjQuery.post('/mgr/user/logout.json', \r\n\t\t\t\t'', \r\n\t\t\t\tfunction(data) {\r\n        \t\t\tif(data.errors == true)\r\n        \t\t\t{\r\n        \t\t\t\teval(data.message);\r\n        \t\t\t}\r\n        \t\t\telse\r\n        \t\t\t{\r\n\t\t\t\t\t\tdocument.location.href('/mgr/');\r\n        \t\t\t}\r\n\t\t\t});\r\n\t}\r\n\r\n\tfunction infoModify()\r\n\t{\r\n\t\tshowModalWin('/mgr/user/modify.pop.action', '800px', '500px');\r\n\t}\r\n\t\r\n\t$(document).ready(function(){\r\n\t\tapplyListStyle();\r\n\t});\r\n\t\r\n\tfunction excelUpload()\r\n\t{\r\n\t\tvar pop = window.open(\"/mgr/excel.jsp\",\"excel\",\"width=800,height=600,scrollbars=yes,toolbar=no,location=no,status=yes\");\r\n\t\t\r\n\t\tif(pop)\r\n\t\t\tpop.focus();\r\n\t\t\r\n\t}\r\n\t\r\n\t\r\n\t\r\n\t</script>\r\n\t\r\n</head>\r\n<body id=\"";
  private final static String _jspx_template13 = "\">\r\n\t<div id=\"header\"><!-- Header Start -->\r\n\t<h1><a href=\"";
  private final static String _jspx_template14 = "/main.sub.action\"><img src=\"/mgr/images/layout/header_logo.gif\" alt=\"CUinfo 관리시스템\" /></a></h1>\r\n\r\n\t\t<ul class=\"header_link\">\r\n\t\t\t<li><b>";
  private final static String _jspx_template15 = "</b>님 좋은 하루 되세요!</li>\r\n\t\t\t<li><a href=\"javascript:logout();\"><img src=\"/mgr/images/btn/logout.gif\" alt=\"로그아웃\" /></a></li>\r\n\t\t\t<li><a href=\"javascript:infoModify();\"><img src=\"/mgr/images/btn/modify.gif\" alt=\"정보수정\" /></a></li>\r\n\t\t\t<li>&nbsp;&nbsp;<a href=\"javascript:excelUpload();\">&nbsp;</a></li>\r\n\t\t</ul>\r\n\r\n\t\t<ul id=\"gnb\"><!-- Gnb Start -->\r\n\t\t\t";
  private final static String _jspx_template16 = "\r\n\t\t\t\t<li id=\"gnb";
  private final static String _jspx_template17 = "\" class=\"";
  private final static String _jspx_template18 = "\">\r\n\t\t\t\t\t<a href=\"";
  private final static String _jspx_template19 = "\" onmouseover=\"javascript:gnb_on(";
  private final static String _jspx_template20 = ");\">";
  private final static String _jspx_template21 = "</a>\r\n\t\t\t\t\t<div id=\"gnb_sub";
  private final static String _jspx_template22 = "\">\r\n\t\t\t\t\t\t \r\n\t\t\t\t\t\t";
  private final static String _jspx_template23 = "\r\n\t\t\t\t\t\t\t<a href=\"";
  private final static String _jspx_template24 = "\" class=\"";
  private final static String _jspx_template25 = "\">";
  private final static String _jspx_template26 = "</a>\r\n\t\t\t\t\t\t\t";
  private final static String _jspx_template27 = "\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</li>\r\n\t\t\t\t";
  private final static String _jspx_template28 = "\r\n\t\t</ul><!-- banner_tab01 End -->\r\n\t\t\r\n\t\t<div class=\"logo_link\"><!-- logo_link Start -->\r\n\t\t\t<a href=\"/home/index.main.action\" target=\"_blank\">CU info</a> |  <a href=\"http://www.kocw.net\" target=\"_blank\">KOCW</a>  |  <a href=\"http://www.riss.kr/\" target=\"_blank\">RISS</a>\r\n\t\t</div><!-- logo_link End -->\r\n\t\t\r\n\t</div><!-- Header End -->\r\n\t\r\n\t";
  private final static String _jspx_template29 = "\r\n\t<div id=\"container\"><!-- container Start -->\r\n\r\n\t<div id=\"snb\">\r\n\t\t<h2>";
  private final static String _jspx_template30 = "</h2>\r\n\t\t<ul>\t\t\r\n\t\t\t";
  private final static String _jspx_template31 = "\r\n\t\t\t\t\t<li id=\"snb";
  private final static String _jspx_template32 = "\" class=\"";
  private final static String _jspx_template33 = "\"><a href=\"";
  private final static String _jspx_template34 = "\">";
  private final static String _jspx_template35 = "</a></li>\r\n\t\t\t\t\t";
  private final static String _jspx_template36 = "\r\n\t\t</ul>\r\n\t</div>\r\n\r\n\r\n\t<div id=\"contents\"><!-- Contents End -->\r\n\t";
  private final static String _jspx_template37 = "\r\n\t\r\n    <div id=content-area>\r\n    <!----  START OF :: 컨텐츠 영역 ---->\r\n    ";
  private final static String _jspx_template38 = "\r\n    <!----  END OF :: 컨텐츠 영역 ---->\r\n    </div>\r\n    \r\n    ";
  private final static String _jspx_template39 = "\r\n    </div>\r\n    </div>\r\n    ";
  private final static String _jspx_template40 = "\r\n\r\n\t";
  private final static String _jspx_template41 = "\r\n\t</div><!-- Contents Section End -->\r\n\r\n</div><!-- container End -->\r\n\r\n<div id=\"footer\">\r\n\t<p>\r\n\t\t<span class=\"f_left\">[100-400] 서울특별시 중구 퇴계로 299(쌍림동 22-1) KEIS빌딩</span>\r\n\t\t<span>TEL : 02)2118-1114 </span>\r\n\t</p>\r\n\t<p>\r\n\t\t<span class=\"f_left\">COPYRIGHT©2012 KERIS. ALL RIGHT RESERVED.</span>\r\n\t\t<span>FAX : 02)2278-4368</span>\r\n\t</p>\r\n</div>\r\n</body>\r\n</html>";
  private final static String _jspx_template42 = "\r\n\r\n</body>\r\n</html>";
}
