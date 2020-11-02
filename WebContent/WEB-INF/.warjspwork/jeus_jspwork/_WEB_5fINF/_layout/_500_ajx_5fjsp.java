package jeus_jspwork._WEB_5fINF._layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;


public class _500_ajx_5fjsp extends jeus.servlet.jsp.HttpJspBase {

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
      // ----  decorator:head ---- invoke //
      if (_jspx_th_decorator_head_0_fn(pageContext, null)) return;


      out.write(_jspx_template2);
      // ----  decorator:body ---- invoke //
      if (_jspx_th_decorator_body_0_fn(pageContext, null)) return;


      out.write(_jspx_template3);

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
  private final static String _jspx_template1 = "\r\n\r\n<head>\r\n    \r\n    ";
  private final static String _jspx_template2 = "\r\n</head>\r\n<body>\r\n";
  private final static String _jspx_template3 = "\r\n<script>\r\napplyListStyle();\r\n</script>\r\n</body>";
}
