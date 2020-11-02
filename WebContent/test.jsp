

<%@page import="java.net.URLDecoder"%>
<%
 try{
	 
	 URLDecoder.decode("","UTF-8");
 }catch(Exception e){
	 
 }
%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			TEST.JSP
		</title>
		<script type="text/javascript">
			alert("test server start!");
		</script>
	</head>
	<body>
		1
		<video src="mp4/test.mp4" width="400" height="300" autoplay="autoplay"></video>
		2
		<video src="http://210.102.104.52/dcoll_cuinfo/testmp4/cuinfo.mp4" width="400" height="300" autoplay="autoplay"></video>
		3
		<embed src="http://210.102.104.52/dcoll_cuinfo/testmp4/cuinfo.mp4" autostart="true" width="400" height="300"></embed>
		4
		<video poster="movie.jpg" controls>
			<source src="http://210.102.104.52/dcoll_cuinfo/testmp4/cuinfo.mp4" type="video/mp4"/>
		</video>

	</body>
</html>