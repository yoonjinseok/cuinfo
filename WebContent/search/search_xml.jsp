<?xml version="1.0" encoding="utf-8"?>
<%@ page contentType="text/xml; charset=utf-8"%>
<%@ include file="./common/WNSearch.jsp" %>
<% request.setCharacterEncoding("utf-8");%>
<%    
 
    boolean isRealTimeKeyword = false;
    boolean isPopKeyword = true;
    boolean isDebug = false;

    int TOTALVIEWCOUNT = 3;    
    response.setHeader("Access-Control-Allow-Origin", "*"); //html 
    Calendar nowDate = Calendar.getInstance();
    int nowYear   = nowDate.get(Calendar.YEAR);
    int nowMonth  = nowDate.get(Calendar.MONTH) + 1;
    int nowDay    = nowDate.get(Calendar.DAY_OF_MONTH);
    int startCount      = parseInt(getCheckReqXSS(request, "startCount", "0"), 0);
    int listCount       = parseInt(getCheckReqXSS(request, "listCount", "10"), 10);
    String query        = getCheckReqXSS(request, "query", "");          //
    String collection   = getCheckReqXSS(request, "collection", "ALL");  //

    String rt   = getCheckReqXSS(request, "rt", "");              //
    String rt2   = getCheckReqXSS(request, "rt2", "");            //
    String requery   = getCheckReqXSS(request, "requery", "");    //
    String sort   = getCheckReqXSS(request, "sort", "DATE");      //
    String order   = getCheckReqXSS(request, "order", "1");      //
    String range   = getCheckReqXSS(request, "range", "0");       //
    String startDate   = getCheckReqXSS(request, "sdate", "");    //
    String endDate   = getCheckReqXSS(request, "edate", "");      //
    String departmentId   = getCheckReqXSS(request, "departmentId", "");      //
	String universityId   = getCheckReqXSS(request, "universityId", "");      //
	String publicYn   = getCheckReqXSS(request, "publicYn", "");      //

    String sfield   = "";

    String [] field = request.getParameterValues("sfield");
    if ( field != null ) {
        for ( int x=0; x<field.length;x++) {
            sfield = sfield + field[x] + ",";
        }

    } else sfield = "ALL";

    if ( range.equals("0") ) {
        startDate = "";
        endDate = "";
    }

    String[] collections = null;
    if(collection.equals("ALL")) { //
	    //հ univ_lecture_year  2012.03.14
        collections = COLLECTIONS_NEW;
    } else {                        //
        collections = new String[] { collection };
    }

    String search = query ;
    String strOperation  = "" ; //operation
    String exquery = "" ;       //exquery 
    int totalCount = 0;

    if ( rt.equals("1") && !requery.equals("") ) {
		   search = query + " " + requery;
 	} else if ( rt2.equals("1") && !requery.equals("") ) {
 		search = requery ;
  	}

    String[] searchFields = null;
	
    if ( !departmentId.equals("") ) {
        exquery += "<departmentId:" + departmentId + ">";
    }
	if ( !universityId.equals("") ) {
        exquery += " <universityId:" + universityId + ">";
    }
	 if ( !publicYn.equals("") ) {
        exquery += " <publicYn:" + publicYn + ">";
    }

    WNSearch wnsearch = new WNSearch(isDebug,false, collections, searchFields);

    int viewResultCount = listCount;
    if ( collection.equals("ALL") ||  collection.equals("") )
        viewResultCount = TOTALVIEWCOUNT;

    out.println("<Search>");
    for (int i = 0; i < collections.length; i++) {
        //  
        wnsearch.setCollectionInfoValue(collections[i], PAGE_INFO, startCount+","+viewResultCount);

        //
        if ( !query.equals("") ) {
			  wnsearch.setCollectionInfoValue(collections[i], SORT_FIELD, sort + ","+order);
              //wnsearch.setCollectionInfoValue(collections[i], SORT_FIELD, sort + ",1");
        } else {
              wnsearch.setCollectionInfoValue(collections[i], DATE_RANGE, "1970/01/01,2030/01/01,-");
              wnsearch.setCollectionInfoValue(collections[i], SORT_FIELD, "DATE,1");
        }
        //sfield 
        if ( !sfield.equals("") && sfield.indexOf("ALL") == -1 ) wnsearch.setCollectionInfoValue(collections[i], SEARCH_FIELD, sfield );
        //operation 
        if ( !strOperation.equals("") ) wnsearch.setCollectionInfoValue(collections[i], FILTER_OPERATION, strOperation);
        //exquery 
        if ( !exquery.equals("") ) wnsearch.setCollectionInfoValue(collections[i], EXQUERY_FIELD, exquery );
        //
        if ( !startDate.equals("")  && !endDate.equals("") )
             wnsearch.setCollectionInfoValue(collections[i], DATE_RANGE, startDate.replaceAll("-","/") + "," + endDate.replaceAll("-","/") + ",-");
        //
        else if ( !startDate.equals("")  && endDate.equals("") )
             wnsearch.setCollectionInfoValue(collections[i], DATE_RANGE, startDate.replaceAll("-","/") + "," + nowYear + "/" + nowMonth + "/" + nowDay + ",-");


		if(!exquery.equals("")){
			exquery = exquery.replaceAll("<","");
			exquery = exquery.replaceAll(">","");
		}

%>
	<Options Collection="<%=collections[i] %>">
		<StartCount><%=startCount %></StartCount>
		<ResultCount><%= viewResultCount %></ResultCount>
		<SearchField><%= sfield %></SearchField>
		<Sort><%= sort %></Sort>
		<Order><%= order %></Order>
		<Operation><%= strOperation%></Operation>
		<ExQuery><%=exquery%></ExQuery>
		<DateRange><%= startDate%>-<%=endDate%></DateRange>
	</Options>
<%
    }

    wnsearch.search(search, true, isRealTimeKeyword);

     //
    String debugMsg = wnsearch.printDebug() != null ? wnsearch.printDebug().trim() : "";
    if ( isDebug ) {
        out.println("<Debug><![CDATA["+debugMsg +"]]</Debug>");
    }

     //
    if ( collection.equals("ALL") ) {
        for (int i = 0; i < collections.length; i++) {
           totalCount += wnsearch.getResultTotalCount(collections[i]);
        }
    } else {
      //
        totalCount = wnsearch.getResultTotalCount(collection);
    }

    String thisCollection = "";
	String kmaQuery_t="";
	//kmaQuery_t = wnsearch.getHighlightKeyword();
%><Condition>
	<Query><![CDATA[<%=search%>]]></Query>
	<KMAQuery><![CDATA[<%=kmaQuery_t%>]]></KMAQuery>
	<TotalCount><![CDATA[<%=totalCount%>]]></TotalCount>
</Condition>
<%@ include file="./result/result_univ_lecture.jsp" %>
<% if(!collection.equals("ALL")){
%>
<%@ include file="./result/result_univ_lecture_year.jsp" %>
<%}%>
<%@ include file="./result/result_univ_bbs.jsp" %>
<%@ include file="./result/result_univ_web.jsp" %>
</Search>
<%
     if ( wnsearch != null )
          wnsearch.closeServer();
%>