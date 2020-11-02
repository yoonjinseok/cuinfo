<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" language="javascript" src="/mgr/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" language="javascript" src="/mgr/js/jquery.form.js"></script>
<script type="text/javascript" language="javascript" src="/mgr/js/common.js"></script>
<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript" language="javascript">
	$(document).ready(function(){
		
	});
	
	function selectQuery(){
		jQuery.post('/mgr/system/selectTableData.json', 
				{query:$("#query").val()}, 
				function(data) {
        			if(data.errors == true)
        			{
        				eval(data.message);
        			}
        			else
        			{
        				//
        			}
		});
	}
	
	function downloadQuery(){
 		alert($("#query").val());		
		jQuery.post('/mgr/system/downloadTableData.json', 
				{query:$("#query").val()}, 
				function(data) {
        			if(data.errors == true)
        			{
        				eval(data.message);
        			}
        			else
        			{
						var result = data.filePath.split(",");
						document.location.href = "/mgr/common/file_download2.json?"+result[0]+result[1].split("=")[1]+"&"+result[1];
        			}
		});
	}
	
</script>
</head>
<body>
	selectTable
	<br/>
	<textarea rows="40" cols="80" id="query"></textarea>
	<br/>
	<a href="javascript:selectQuery();"><input type="button" value="select"></a>
	<a href="javascript:downloadQuery();"><input type="button" value="download"></a>
	
</body>
</html>