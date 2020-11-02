<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CUinfo 관리시스템</title>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery.form.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/common.js"></script>
    <script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
    
    <decorator:head />
    
    <script type="text/javascript" language="javascript">	
	$(document).ready(function(){
		applyListStyle();
	});
	</script>
</head>
<body>
    <div id=content-area>
    <!----  START OF :: 컨텐츠 영역 ---->
    <decorator:body />
    <!----  END OF :: 컨텐츠 영역 ---->
    </div>

</body>
</html>