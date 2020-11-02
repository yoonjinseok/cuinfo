<%@ page contentType="text/xml; charset=utf-8"%><%
/*
* subject: univ_web 페이지
* @original author: SearchTool
*/
	thisCollection = "univ_web";
	if (   collection.equals("ALL") || collection.equals(thisCollection)   ) {
		int count = wnsearch.getResultCount(thisCollection);
		int thisTotalCount = wnsearch.getResultTotalCount(thisCollection);
%><Result CollName="<%=thisCollection%>" TotalCount="<%=thisTotalCount%>" Count="<%=count%>">
<%
 	if ( thisTotalCount > 0 ) {
			for(int idx = 0; idx < count; idx ++) {
%>	<Row Value="<%=idx%>">
		<DOCID><![CDATA[ <%=wnsearch.getField(thisCollection, "DOCID" , idx, false)%> ]]></DOCID>
		<subject><![CDATA[ <%=wnsearch.getField(thisCollection, "subject" , idx, true)%> ]]></subject>
		<content><![CDATA[ <%=wnsearch.getField(thisCollection, "content" , idx, true)%> ]]></content>
		<Date><![CDATA[ <%=wnsearch.getField(thisCollection, "Date" , idx, false)%> ]]></Date>
		<writer><![CDATA[ <%=wnsearch.getField(thisCollection, "writer" , idx, false)%> ]]></writer>
		<base_url><![CDATA[ <%=wnsearch.getField(thisCollection, "base_url" , idx, false)%> ]]></base_url>
		<url><![CDATA[ <%=wnsearch.getField(thisCollection, "url" , idx, false)%> ]]></url>
		<type><![CDATA[ <%=wnsearch.getField(thisCollection, "type" , idx, false)%> ]]></type>
		<source><![CDATA[ <%=wnsearch.getField(thisCollection, "source" , idx, false)%> ]]></source>
		<section><![CDATA[ <%=wnsearch.getField(thisCollection, "section" , idx, false)%> ]]></section>
	</Row>
<%
		   }
    }
%></Result>
<%
	}
%>