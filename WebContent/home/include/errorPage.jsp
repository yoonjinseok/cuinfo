<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERROR PAGE</title>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>

</head>
<body>
<img src="/mgr/images/layout/error1.gif" alt="에러발생" style="display: block; margin-left: auto; margin-right: auto; margin-top: 100px;"/>

<script>
	alert("시스템 오류가 발생하여 이전화면으로 이동합니다.");
	history.back();
</script>
</body>
</html>