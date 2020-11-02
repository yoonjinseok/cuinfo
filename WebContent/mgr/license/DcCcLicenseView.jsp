<%@page import="com.cyberup.controller.mgr.course.CollLicense"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="collLicInc" class="com.cyberup.controller.mgr.course.CollLicInclude" scope="session" /> 

<%
	// request 배열값을 받아서 자체 배열에 저장
	Map map = request.getParameterMap();
	Iterator entries = map.entrySet().iterator();
    Map.Entry entry = null;

	String name = null;
	String[] sElementIds = null;
	String[] sDefaultValues = null;

   	List lKeys = new ArrayList();    

    while( entries.hasNext() ) {
		entry = (Map.Entry)entries.next();
		name = (String)entry.getKey();
        
     	if ( name.equals("elementId") )
     		sElementIds = (String[])entry.getValue();
     	else if ( name.equals("defaultValue") )
     		sDefaultValues = (String[])entry.getValue();
    }
    
    // 가져온 request 배열값을 CollLicense에 세팅 
    int iElementSize = sElementIds == null ? 0 : sElementIds.length;
    int iDefaultSize = sDefaultValues == null ? 0 : sDefaultValues.length;
    
    int iSize = iElementSize <= iDefaultSize ? iElementSize : iDefaultSize;
    for(int i=0;i<iSize;i++)
    {
    	CollLicense colllic = new CollLicense();
    	colllic.setElementId(sElementIds[i]);
    	colllic.setADefaultValue(sDefaultValues[i]);
    	
    	lKeys.add(colllic);
    }
      
%>

<%
	String openLegalCode = request.getParameter("openLegalCodeYN");
	
	// session으로 설정한 collLicInc에 request 배열값을 저장하여 다음페이지에서 호출할 수 있도록 한다.
	if ( openLegalCode == null || !openLegalCode.equals("Y") )
	{
		collLicInc.setCCDeed(lKeys);
%>
<html>
<BODY leftMargin=0 rightMargin=0 bottomMargin=0 marginWidth=0 topMargin=0 marginheight="0" marginwidth="0" onLoad="window.resizeTo(670,620);">
<TABLE border=0 cellPadding=0 cellSpacing=0 height="100%" width="100%">
	<tr>
		<td height="100%">
			<IFRAME frameBorder=0 src="DcCcLicenseViewTop.jsp" height="100%" name=CCPreviewTop width="100%"></IFRAME>
		</td>
	</tr>
	<tr>
		<td align=center>
			<a href="javascript:history.go(-1);"><img src="/mgr/license/resource/table_unB_84.gif" border=0></a>
			&nbsp;			&nbsp;
			<a href="javascript:parent.window.close();"><img src="/mgr/license/resource/table_unB_38.gif" border=0></a>
		</td>
	</tr>
</table>
</body>
</html>
<%
	}
	else
	{
		 String sUrl = "http://creativecommons.org/licenses/"+collLicInc.getCCDeedName(lKeys)+"/2.0/kr/";
		 response.sendRedirect(sUrl);
	}
%>
