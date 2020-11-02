<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title><decorator:title default="사이버대학포탈" /></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <script language="JAVAScript" src="<c:url value='/js/jquery-1.4.4.min.js'/>"></script>
    <script language="JAVAScript" src="<c:url value='/js/jquery.form.js'/>"></script>
    
    <decorator:head />
</head>
<body>

    <div id=content-area>
    <!----  START OF :: 컨텐츠 영역 ---->
    <decorator:body />
    <!----  END OF :: 컨텐츠 영역 ---->
    </div>
    
</body>
</html>