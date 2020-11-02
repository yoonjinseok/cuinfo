<%
/**
 * file: sample1.jsp
 * subject: 기본 검색 샘플
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
String[] searchFields = null; //검색 필드 전체를 검색한다.

//WNSearch Class의 object를 생성한다.
WNSearch wnsearch = new WNSearch(true, false, collections, searchFields) ;

//Collection 기본 구성 요소를 설정한다.
wnsearch.setCollectionInfoValue("univ_web", PAGE_INFO, 0+","+10);
wnsearch.setCollectionInfoValue("univ_web", SORT_FIELD, "DATE,1/RANK,1");
//wnsearch.setCollectionInfoValue("univ_lecture", DATE_RANGE, "1971/01/02,2020/12/31,-");// 날짜검색
//wnsearch.setCollectionInfoValue("univ_lecture", EXQUERY_FIELD, "<PUB_CD:!111535>");// 확장검색
//wnsearch.setCollectionInfoValue("univ_lecture", COLLECTION_QUERY, "<title:로그>");// 확장검색
//wnsearch.setCollectionInfoValue("univ_lecture", FILTER_OPERATION, "gubun<match>FILE");// 필터링 검색

// 검색 키워드를 입력 한 후 결과를 요청한다.
// 검색 필드 전체 검색
wnsearch.search(query, true, false);

// 디버그 메시지 출력
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
    <input name="query" type="text" size="50" value="<%=query%>"><input name="btn" type="submit" value="검색" ><br><br>
<%
//검색 결과를 출력하기 위해서 count를 얻는다.
int count = wnsearch.getResultCount("univ_web");
int totalCount = wnsearch.getResultTotalCount("univ_web");
out.println("<p>totalCount : " + totalCount);
out.println("</p>");

//count만큼 Loop를 수행하면서 결과를 화면에 출력한다.
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
wnsearch.closeServer(); //검색기와의 연결을 종료한다.
%>
