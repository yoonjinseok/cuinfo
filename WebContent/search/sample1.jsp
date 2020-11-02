<%
/**
 * file: sample1.jsp
 * subject: �⺻ �˻� ����
 *  ------------------------------------------------------------------------
 *  @original author: KoreaWISEnut
 *  @edit author: KoreaWISEnut
 *  @update date 2008.01.07
 *  ------------------------------------------------------------------------
*/
 %>
<%@ page contentType="text/html;charset=euc-kr" language="java" %>
<%@ include file="./common/WNSearch.jsp" %>
<% request.setCharacterEncoding("euc-kr");%>
<%
String query = getCheckReq(request, "query", "");
String[] collections = new String[] {"univ_web"};
String[] searchFields = null; //�˻� �ʵ� ��ü�� �˻��Ѵ�.

//WNSearch Class�� object�� �����Ѵ�.
WNSearch wnsearch = new WNSearch(true, false, collections, searchFields) ;

//Collection �⺻ ���� ��Ҹ� �����Ѵ�.
wnsearch.setCollectionInfoValue("univ_web", PAGE_INFO, 0+","+10);
wnsearch.setCollectionInfoValue("univ_web", SORT_FIELD, "DATE,1/RANK,1");
//wnsearch.setCollectionInfoValue("univ_lecture", DATE_RANGE, "1971/01/02,2020/12/31,-");// ��¥�˻�
//wnsearch.setCollectionInfoValue("univ_lecture", EXQUERY_FIELD, "<PUB_CD:!111535>");// Ȯ��˻�
//wnsearch.setCollectionInfoValue("univ_lecture", COLLECTION_QUERY, "<title:�α�>");// Ȯ��˻�
//wnsearch.setCollectionInfoValue("univ_lecture", FILTER_OPERATION, "gubun<match>FILE");// ���͸� �˻�

// �˻� Ű���带 �Է� �� �� ����� ��û�Ѵ�.
// �˻� �ʵ� ��ü �˻�
wnsearch.search(query, true, false);

// ����� �޽��� ���
String debugMsg = wnsearch.printDebug() != null ? wnsearch.printDebug().trim() : "";
out.println(debugMsg);
%>
<html>
<head>
  <meta http-equiv="content-type" content="text/html;charset=euc-kr">
  <title> search formula-1 api sample 1</title>
</head>
<body>
  <form name="search" method="post" action="sample1.jsp" >
    <input name="query" type="text" size="50" value="<%=query%>"><input name="btn" type="submit" value="�˻�" ><br><br>
<%
//�˻� ����� ����ϱ� ���ؼ� count�� ��´�.
int count = wnsearch.getResultCount("univ_web");
int totalCount = wnsearch.getResultTotalCount("univ_web");
out.println("<p>totalCount : " + totalCount);
out.println("</p>");

//count��ŭ Loop�� �����ϸ鼭 ����� ȭ�鿡 ����Ѵ�.
for(int idx = 0; idx < count; idx ++) {
	out.println("subject : " + wnsearch.getField("univ_web", "subject", idx, false));
	out.println("<br>");
	out.println("content : " + wnsearch.getField("univ_web", "content", idx, false));
	out.println("<p>");
	out.println("source : " + wnsearch.getField("univ_web", "source", idx, false));
	out.println("<p>");
}

%>
  </form>
</body>
</html>

<%
wnsearch.closeServer(); //�˻������ ������ �����Ѵ�.
%>
