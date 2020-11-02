<%@ page contentType="text/html;charset=UTF-8"%>
                 
<jsp:useBean id="collLicInc" class="com.cyberup.controller.mgr.course.CollLicInclude" scope="session" />       

<%
// DcCcLicenseView에서 설정한 collLicInc session값을 collLicInc을 통해 미리보기 설명을 가져온다.
%>
<%=collLicInc.getCCDeed(collLicInc.getCCDeed())%>
