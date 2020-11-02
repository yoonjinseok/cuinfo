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
	

	function insertQuery(){
		alert($("#insertquery").val());
		if( confirm("정말 data를 insert하시겠습니까?" )){
		jQuery.post('/mgr/system/insertTableData.json', 
				{insertquery:$("#insertquery").val()}, 
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
	}}
	function updateQuery(){
		alert($("#updatequery").val());
		if( confirm("정말 data를 update하시겠습니까?" )){
		jQuery.post('/mgr/system/updateTableData.json', 
				{updatequery:$("#updatequery").val()}, 
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
	}}
	function deleteQuery(){
		alert($("#deletequery").val());
		if( confirm("정말 data를 delete하시겠습니까?" )){
		jQuery.post('/mgr/system/deleteTableData.json', 
				{deletequery:$("#deletequery").val()}, 
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
	}}
	
	
</script>
</head>
<body>
	insertData
	<br/>
	<textarea rows="20" cols="100" id="insertquery"></textarea>
	<br/>
	<a href="javascript:insertQuery();"><input type="button" value="insert"></a>
	<br/>
	<br/>
	updateData
	<br/>
	<textarea rows="20" cols="100" id="updatequery"></textarea>
	<br/>
	<a href="javascript:updateQuery();"><input type="button" value="update"></a>
	<br/>
	<br/>
	deleteData
	<br/>
	<textarea rows="20" cols="100" id="deletequery"></textarea>
	<br/>
	<a href="javascript:deleteQuery();"><input type="button" value="delete"></a>
	<br/>
	<br/>
</body>
</html>