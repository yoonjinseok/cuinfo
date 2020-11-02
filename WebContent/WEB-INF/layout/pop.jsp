<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<html>
<head>
    <title><decorator:title default="사이버대학포탈" /></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="Description" content="CUinfo 사이버 대학 종합정보 서비스" />
    <meta name="Keywords" content="사이버 대학, 사이버대학 포털, 사이버 대학 종합정보 서비스" />
    <meta name="Author" content="KERIS" />
    <script type="text/javascript" language="javascript" src="/home/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="/home/js/jquery.form.js"></script>
	<script type="text/javascript" language="javascript" src="/home/js/common.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/layout.css" />
	<link rel="stylesheet" type="text/css" href="/css/popup.css" />

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