<%@ page contentType="text/xml; charset=utf-8"%><%
/*
* subject: univ_bbs 페이지
* @original author: SearchTool
*/
	thisCollection = "univ_bbs";
	if (   collection.equals("ALL") || collection.equals(thisCollection)   ) {
		int count = wnsearch.getResultCount(thisCollection);
		int thisTotalCount = wnsearch.getResultTotalCount(thisCollection);
%><Result CollName="<%=thisCollection%>" TotalCount="<%=thisTotalCount%>" Count="<%=count%>">
<%
 	if ( thisTotalCount > 0 ) {
			for(int idx = 0; idx < count; idx ++) {
%>	<Row Value="<%=idx%>">
		<DOCID><![CDATA[ <%=wnsearch.getField(thisCollection, "DOCID" , idx, false)%> ]]></DOCID>
		<gubn><![CDATA[ <%=wnsearch.getField(thisCollection, "gubn" , idx, false)%> ]]></gubn>
		<title><![CDATA[ <%=wnsearch.getField(thisCollection, "title" , idx, true)%> ]]></title>
		<CONTENT><![CDATA[ <%=wnsearch.getField(thisCollection, "content" , idx, true)%> ]]></CONTENT>
		<regDate><![CDATA[ <%=wnsearch.getField(thisCollection, "regDate" , idx, false)%> ]]></regDate>
		<hitsCnt><![CDATA[ <%=wnsearch.getField(thisCollection, "hitsCnt" , idx, false)%> ]]></hitsCnt>
	</Row>
<%
		   }
    }
%></Result>
<%
	}
%>