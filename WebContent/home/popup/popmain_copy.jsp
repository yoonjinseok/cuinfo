<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사이버대학 체험관</title>
<link rel="stylesheet" href="../popup/css/layout.css" type="text/css"/>
<script type="text/javascript">

    //항상 위에
    function doInit() { 
        window.onblur = doOutFocus; 
    } 

    function doOutFocus() { 
        window.focus(); 
    } 

</SCRIPT>
</head>
<body onLoad="doInit()" class="body">
    
    <div class="navi">
        <div class="side-top">
        <dl>
        <dt class="one">
            <a href="../popup/popmain.jsp"><img src="../popup/images/icon/icon-home.gif"/></a>
            <img src="../popup/images/icon/icon-sitemap.gif"/>
        </dt>
        </dl>
        </div>
        <div class="side-logo">
            <a href="../popup/popmain.jsp">
                <img alt="사이버대학 체험관" src="../popup/images/logo/logo.gif">
            </a>
        </div>
        <div class="sidebar">
            <div class="sub1"><a href="../popup/popmain.jsp"></a></div>
            <div class="sub2"><a href="../popup/popmain.jsp"></a></div>
            <div class="sub3"><a href="../popup/popmain.jsp"></a></div>
            <div class="sub4"><a href="../popup/popmain.jsp"></a></div>
        </div>
    </div>
    
    
    



</body>
</html>