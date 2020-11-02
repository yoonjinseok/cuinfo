<%@ page contentType="text/xml; charset=utf-8"%><%
/*
* subject: univ_lecture 페이지
* @original author: SearchTool
*/
	thisCollection = "univ_lecture_year";
	if (   collection.equals("ALL") || collection.equals(thisCollection)   ) {
		int count = wnsearch.getResultCount(thisCollection);
		int thisTotalCount = wnsearch.getResultTotalCount(thisCollection);
%><Result CollName="<%=thisCollection%>" TotalCount="<%=thisTotalCount%>" Count="<%=count%>">
<%
 	if ( thisTotalCount > 0 ) {
			for(int idx = 0; idx < count; idx ++) {
%>	<Row Value="<%=idx%>">
		<DOCID><![CDATA[ <%=wnsearch.getField(thisCollection, "DOCID" , idx, false)%> ]]></DOCID>
		<courseIdentifier><![CDATA[ <%=wnsearch.getField(thisCollection, "courseIdentifier" , idx, false)%> ]]></courseIdentifier>
		<title><![CDATA[ <%=wnsearch.getField(thisCollection, "title" , idx, true)%> ]]></title>
		<keyword><![CDATA[ <%=wnsearch.getField(thisCollection, "keyword" , idx, true)%> ]]></keyword>
		<regDate><![CDATA[ <%=wnsearch.getField(thisCollection, "regDate" , idx, false)%> ]]></regDate>
		<univName><![CDATA[ <%=wnsearch.getField(thisCollection, "univName" , idx, true)%> ]]></univName>
		<deptName><![CDATA[ <%=wnsearch.getField(thisCollection, "deptName" , idx, false)%> ]]></deptName>
		<description><![CDATA[ <%=wnsearch.getField(thisCollection, "description" , idx, true)%> ]]></description>
		<contName><![CDATA[ <%=wnsearch.getField(thisCollection, "contName" , idx, true)%> ]]></contName>
		<credit><![CDATA[ <%=wnsearch.getField(thisCollection, "credit" , idx, false)%> ]]></credit>
		<termSemester><![CDATA[ <%=wnsearch.getField(thisCollection, "termSemester" , idx, false)%> ]]></termSemester>
		<clicksCnt><![CDATA[ <%=wnsearch.getField(thisCollection, "clicksCnt" , idx, false)%> ]]></clicksCnt>
		<departmentId><![CDATA[ <%=wnsearch.getField(thisCollection, "departmentId" , idx, false)%> ]]></departmentId>
		<universityId><![CDATA[ <%=wnsearch.getField(thisCollection, "universityId" , idx, false)%> ]]></universityId>
		<publicYn><![CDATA[ <%=wnsearch.getField(thisCollection, "publicYn" , idx, false)%> ]]></publicYn>
	</Row>
<%
		   }
    }
%></Result>
<%
	}
%>