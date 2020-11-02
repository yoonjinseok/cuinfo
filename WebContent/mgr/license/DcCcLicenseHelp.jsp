<%@page import="com.cyberup.controller.mgr.course.CommonConstants"%>
<%@page import="com.cyberup.controller.mgr.course.CollLicense"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="collLicInc" class="com.cyberup.controller.mgr.course.CollLicInclude" scope="session" /> 


<%
	// elementId값을 통해 해당 요소설명을 불러온다. 
	String sElementId = request.getParameter( "elementId" );
    CollLicense article = new CollLicense();
    if(sElementId.equals("001"))
    {
    	article.setSymbol(CommonConstants.LIC_NO_DERIVATIVE);
    	article.setElementDesc(collLicInc.getCCDeed(CommonConstants.LIC_ATTRIBUTION));
    }
    else if(sElementId.equals("002"))
    {
    	article.setSymbol(CommonConstants.LIC_NONCOMMERCIAL);
    	article.setElementDesc(collLicInc.getCCDeed(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_NONCOMMERCIAL));
    }
    else if(sElementId.equals("003"))
    {
    	article.setSymbol(CommonConstants.LIC_NO_DERIVATIVE);
    	article.setElementDesc(collLicInc.getCCDeed(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_NO_DERIVATIVE));
    }
    else if(sElementId.equals("004"))
    {
    	article.setSymbol(CommonConstants.LIC_SHARE_ALIKE);
    	article.setElementDesc(collLicInc.getCCDeed(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_SHARE_ALIKE));
    }
%>
<html>
<head>
<title>라이선스 정보</title>
</head>

<body bgcolor=#eeeeee leftmargin="0" topmargin="0" marginheight="0">
<center>
<br/>

<table width="96%" border="0" cellspacing="0" cellpadding="1">
	<tr>
		<td bgcolor=#000000>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height=10 bgcolor=#ffffff></td>
				</tr>
				<tr>
					<td bgcolor=#ffffff align=center>
						<table width="90%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img src="/mgr/license/resource/s_<%=article.getSymbol()%>.gif">
								</td>
							</tr>
							<tr>
								<td height=10></td>
							</tr>
							<tr>
								<td>
									<%=article.getElementDesc()%>
								</td>
							</tr>
							<tr>
								<td height=20></td>
							</tr>
							<tr>
								<td align=center>
									<a href="javascript:window.close();"><img src="/mgr/license/resource/table_unB_38.gif" border="0"></a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
			</table>
		</td>
	</tr>
</table>

</center>
</body>
</html>
