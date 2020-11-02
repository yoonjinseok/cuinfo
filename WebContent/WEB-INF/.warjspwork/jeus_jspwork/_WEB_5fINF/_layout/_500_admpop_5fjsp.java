package jeus_jspwork._WEB_5fINF._layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;


public class _500_admpop_5fjsp extends jeus.servlet.jsp.HttpJspBase {

  public final String[] __jeusGetIncludedJspFiles() {
    return null;
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
      // ----  decorator:title ---- invoke //
      if (_jspx_th_decorator_title_0_fn(pageContext, null)) return;


      out.write(_jspx_template3);
      // ----  decorator:head ---- invoke //
      if (_jspx_th_decorator_head_0_fn(pageContext, null)) return;


      out.write(_jspx_template4);
      // ----  decorator:body ---- invoke //
      if (_jspx_th_decorator_body_0_fn(pageContext, null)) return;


      out.write(_jspx_template5);

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
  private final static String _jspx_template2 = "\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n<head>\r\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\t<title>CUinfo 관리시스템 > ";
  private final static String _jspx_template3 = "</title>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/mgr/js/jquery-1.4.4.min.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/mgr/js/jquery.form.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/mgr/js/common.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"javascript\" src=\"/js/jquery.tooltip.js\"></script>\r\n\t\r\n<!--\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/mgr/css/layout.css\" />-->\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/mgr/css/popup.css\" />\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/jquery.tooltip.css\" />\r\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css\" />\r\n    \r\n    ";
  private final static String _jspx_template4 = "\r\n    \r\n    <script type=\"text/javascript\" language=\"javascript\">\t\r\n\t$(document).ready(function(){\r\n\t\tapplyListStyle();\r\n\t});\r\n\t</script>\r\n</head>\r\n<body style=\"width:100%;padding:0 0px;\">\r\n<div id=\"wrap\">\r\n  <div class=\"top\">\r\n\t<div class=\"topL\">\r\n        \t<div class=\"topR\"></div>\r\n\t</div>\r\n</div>  \r\n<div class=\"mid\">\r\n\t<div class=\"midL\">\r\n\t\t<div class=\"midR\">\r\n\t\t\t<div class=\"conS\">\r\n\t<!--내용 삽입 -->\t\t\r\n    <div id=content-area>\r\n    <!----  START OF :: 컨텐츠 영역 ---->\r\n    ";
  private final static String _jspx_template5 = "\r\n    <!----  END OF :: 컨텐츠 영역 ---->\r\n    </div>\r\n   <!--내용 삽입 끝-->\r\n  \t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n<div class=\"botC\">\r\n \t<div class=\"botL\">\r\n \t\t<div class=\"botR\"></div>\r\n\t</div>\r\n</div>\r\n</body>\r\n</html>";
}
