<%@ include file="/home/js/layout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="Description" content="CUinfo 사이버 대학 종합정보 서비스" />
    <meta name="Keywords" content="사이버 대학, 사이버대학 포털, 사이버 대학 종합정보 서비스" />
    <meta name="Author" content="KERIS" />
	<title><%=MainTitle%> &gt; <%=SubTitle%></title>
	<link rel="stylesheet" type="text/css" href="<%=URL%>/css/layout.css" />
	<!--  <LINK rel="SHORTCUT ICON" href="<%=URL%>/home/images/icon/cuinfo.ico">-->
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/jquery.popupWindow.js"></script>
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/jquery.fadeSliderToggle.js"></script>
	<script type="text/javascript" language="javascript" src="<%=URL%>/js/common.js"></script>
</head>
<body id="<%=PageType%>">
<%@ include file="/home/include/header.jsp" %>

<div id="container"><!-- container Start -->

	<div id="snb">
		<%

		 if(cate_int == 11 || cate_int == 12 || cate_int == 13 || cate_int == 14 || cate_int == 15) {
		 %>
			<%@ include file="/home/include/intro.jsp" %>
		 <%
		 }
		 else if(cate_int == 21 || cate_int == 22 || cate_int == 23)
		 {
		 %>
			<%@ include file="/home/include/entr.jsp" %>
		 <%}
		 else if(cate_int == 31 || cate_int == 32 || cate_int == 33 || cate_int == 34 || cate_int == 35)
		 {
		 %>
			<%@ include file="/home/include/course.jsp" %>
		 <%}
		 else if(cate_int == 41 || cate_int == 42 || cate_int == 43 || cate_int == 44 || cate_int == 45 || cate_int == 46 || cate_int == 47)
		 {
		 %>
			<%@ include file="/home/include/refer.jsp" %>
		 <%}%>
	</div>


	<div id="contents"><!-- Contents End -->
		<div id="location_box"><!-- MainCopyBox  Start -->
			<h3><img src="<%=URL%>/images/<%=PageType%>/<%=TitleImg%>.gif" alt="<%=SubTitle%>" /></h3>
			<ul class="location">
				<li><a href="<%=URL%>/index.jsp?">Home</a></li>
				<li><a href="<%=Category%>"><%=MainTitle%></a></li>
				<li><%=SubTitle%></li>
			</ul>
		</div><!-- MainCopyBox  End -->