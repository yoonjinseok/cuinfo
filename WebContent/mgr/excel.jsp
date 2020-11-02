<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>excel.jsp</title>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery.form.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/common.js"></script>
	<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script type="text/javascript" language="javascript">
	
	$(document).ready(function(){
		//alert("ready!");	
	
	});
	
	function upload()
	{
		$("#form").submit();
	}
	
</script>
</head>
<body>
	<form id="form" name="form" target="_self" action="/mgr/excelUpload.jsp" method="post" enctype="multipart/form-data">
			excel : <input type="file" id="file" name="file" /> &nbsp;&nbsp;&nbsp;<input type="button" value="저장" onclick="upload()"/>
	</form>
	
	
	
	
</body>
</html>