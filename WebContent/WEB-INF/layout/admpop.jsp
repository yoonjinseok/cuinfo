<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CUinfo 관리시스템 > <decorator:title /></title>
	<script type="text/javascript" src="/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery.form.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/common.js"></script>
	<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script type="text/javascript" language="javascript" src="/js/jquery.tooltip.js"></script>
	
<!--	<link rel="stylesheet" type="text/css" href="/mgr/css/layout.css" />-->
	<link rel="stylesheet" type="text/css" href="/mgr/css/popup.css" />
	<link rel="stylesheet" type="text/css" href="/css/jquery.tooltip.css" />
	<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
    
    <decorator:head />
    
    <script type="text/javascript" language="javascript">	
	$(document).ready(function(){
		applyListStyle();
	});
	</script>
</head>
<body style="width:100%;padding:0 0px;">
<div id="wrap">
  <div class="top">
	<div class="topL">
        	<div class="topR"></div>
	</div>
</div>  
<div class="mid">
	<div class="midL">
		<div class="midR">
			<div class="conS">
	<!--내용 삽입 -->		
    <div id=content-area>
    <!----  START OF :: 컨텐츠 영역 ---->
    <decorator:body />
    <!----  END OF :: 컨텐츠 영역 ---->
    </div>
   <!--내용 삽입 끝-->
  			</div>
		</div>
	</div>
</div>
<div class="botC">
 	<div class="botL">
 		<div class="botR"></div>
	</div>
</div>
</body>
</html>