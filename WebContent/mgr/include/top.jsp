<%@ include file="/mgr/js/layout.jsp" %>
<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><%=MainTitle%> &gt; <%=SubTitle%></title>
	<link rel="stylesheet" type="text/css" href="/mgr/css/layout.css" />
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery.popupWindow.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/common.js"></script>
</head>
<body id="<%=PageType%>">
<%@ include file="/mgr/include/header.jsp" %>



<div id="container"><!-- container Start -->

	<div id="snb">
		<%

		 if(cate_int == 11 || cate_int == 12 || cate_int == 13) {
		 %>
			<%@ include file="/mgr/include/univ.jsp" %>
		 <%
		 }
		 else if(cate_int == 21 || cate_int == 22 || cate_int == 23 || cate_int == 24 || cate_int == 25) 
		 {  
		 %>
			<%@ include file="/mgr/include/course.jsp" %>
		 <%}
		 else if(cate_int == 31 || cate_int == 32 || cate_int == 33) 
		 {  
		 %>
			<%@ include file="/mgr/include/stats.jsp" %>
		 <%}
		 else if(cate_int == 41 || cate_int == 42 || cate_int == 43 || cate_int == 44 || cate_int == 45 || cate_int == 46) 
		 {  
		 %>
			<%@ include file="/mgr/include/home.jsp" %>
		 <%}
		 else if(cate_int == 51 || cate_int == 52 || cate_int == 53 || cate_int == 54) 
		 {  
		 %>
			<%@ include file="/mgr/include/system.jsp" %>
		 <%}%>
	</div>


	<div id="contents"><!-- Contents End -->
		<div id="location_box"><!-- MainCopyBox  Start -->
			<h3><%=SubTitle%></h3>
			<ul class="location">
				<li><a href="<%=URL%>/index.jsp?">Home</a></li>
				<li><a href="<%=Category%>"><%=MainTitle%></a></li>
				<li><%=SubTitle%></li>
			</ul>
		</div><!-- MainCopyBox  End -->