<%@page import="com.cyberup.controller.mgr.course.CourseMgrController"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFCell"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFRow"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="org.apache.poi.poifs.filesystem.POIFSFileSystem"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFSheet"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.cyberup.dao.course.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<%
	String uploadPath = request.getRealPath("upload");
	//업로드 경로 지정, getRealPath()는 실제 디렉토리 경로를 얻어옴
	
	System.out.println("uploadPath ==> " + uploadPath); 
	
	int size = 10*1024*1024; // 업로드 파일 최대 크기 지정
	
	String file 		= "";
	String filename 	= "";
	String realFolder 	= "";
	
	String saveFolder = "/upload/";
	
	ServletContext context 	= getServletContext();
	realFolder 				= context.getRealPath(saveFolder); // 절대 경로 가져오기
	
	//out.println("1 : " + uploadPath + "<br/>");
	//out.println("2 : " + realFolder + "<br/>");
	
	try{
			
		MultipartRequest multi = new MultipartRequest(request, realFolder, size, "UTF-8", new DefaultFileRenamePolicy());
		//파일 업로드 담당하는 부분, 폼에서 가져온 인자값을 얻기 위해request 객체 전달, 업로드 경로, 파일 최대 크기, 한글처리, 파일 중복처리
		
		file 	= multi.getParameter("file");
		//폼에서 입력한 값을 가져옴
		
		Enumeration<?> files = multi.getFileNames();
		
		file =(String)files.nextElement();
		filename=multi.getFilesystemName(file);
		//업로드한 파일들의 이름을 얻어옴
		
		//courseDao.excelUpload(uploadPath + "\\" +  filename);
		//cc.excelUpload(uploadPath + "\\" +  filename);
		
		file = uploadPath + "/" +  filename;
	}catch(Exception e){
		e.printStackTrace();
	}
%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>excepUpload.jsp</title>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/jquery.form.js"></script>
	<script type="text/javascript" language="javascript" src="/mgr/js/common.js"></script>
	<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script type="text/javascript" language="javascript">
		$(document).ready(function(){
			jQuery.post('/mgr/course/excelUpload.json.action', 
					$("#form").formSerialize(), 
					function(data) {
						alert("입력을 완료하였습니다.");
						$("#text").html(data);						
						//self.close();
			});
		});
	
	</script>
</head>
<body>
	<form id="form" name="form" method="post" action="#">
		<input type="hidden" name="file" value="<%=file %>" />
	</form>
	<div id="text">
	입력중입니다..
	</div>
</body>
</html>