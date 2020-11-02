<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
//get방식으로 넘어값을 변수선언하여 저장
String pmn = request.getParameter("pmn");

//값이 없을때 초기화
if(pmn==null){pmn="11";}

System.out.print(pmn);
//String body="";
//String navi="";
String sub1="sub1_00"; String sub2="sub2_00"; String sub3="sub3_00";
String pmnUrl11="../popup/popmain.jsp?pmn=11";
String pmnUrl22="../popup/popmain.jsp?pmn=22";
String pmnUrl33="../popup/popmain.jsp?pmn=33";

if(pmn.equals("11")){sub1="sub1_11";}
else if(pmn.equals("22")){sub2="sub2_22";}
else if(pmn.equals("33")){sub3="sub3_33";}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>사이버대학 체험관</title>
<link rel="stylesheet" href="/home/popup/css/layout.css" type="text/css"/>
<link rel="stylesheet" href="/home/popup/css/slide.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>

<!-- <script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js"></script>
<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.slide.js"></script> -->
</head>
<body>
<form name="popupForm">

<%if(pmn.substring(0, 1).equals("1")){ %>
    <%@ include file="/home/popup/view/include/fspage00.jsp"%>
<%}else if(pmn.substring(0, 1).equals("2")){ %>
    <%@ include file="/home/popup/view/include/secondpage00.jsp"%>
<%}else if(pmn.substring(0, 1).equals("3")){ %>
    <%@ include file="/home/popup/view/include/thirdpage00.jsp"%>
<%} %>
<!-- <span id="secondBody"></span> -->
<div class="navi">
        <div class="side-top">
        <dl>
        <dt class="one">
            <a href="<%=pmnUrl11%>"><img src="/home/popup/images/icon/icon-home.gif"/></a>
            <img src="../popup/images/icon/icon-sitemap.gif"/>
        </dt>
        </dl>
        </div>
        <div class="side-logo">
            <a href="<%=pmnUrl11%>">
                <img alt="사이버대학 체험관" src="/home/popup/images/logo/CUinfo_main_logo.gif">
            </a>
        </div>  
        <div class="sidebar">
            <div class="<%=sub1%>"><a href="<%=pmnUrl11%>"></a></div>
            <div class="<%=sub2%>"><a href="<%=pmnUrl22%>"></a></div>
            <div class="<%=sub3%>"><a href="<%=pmnUrl33%>"></a></div>
            <div class="bottom"></div>
        </div>
</div>
</form>


<script type="text/javascript">
    var pn = 11;
    
    function next00(){
        
    	//hide();
        /* $('#firstBody').hide("slide", { direction: "left" }, 300); */
        
        var url = "/home/popup/view/include/fspage"+pn+".jsp";
        
        var AjaxHTML = 
            $.ajax({
            url: url,
            param: pn,
            type: "POST",
            dataType: "jsp",
            async: false
         }).responseText;
        $('#firstBody').hide().slideDown(1000).html(AjaxHTML);
       /*  $('#firstBody').hide("slide", { direction: "left" }, 800);
        $('#secondBody').hide("slide", { direction: "left" }, 800).show("slide", { direction: "right" }, 800).html(AjaxHTML); */
      
         pn+=11;
        
    }
function next11(){
        
    	//hide();
        /* $('#firstBody').hide("slide", { direction: "left" }, 300); */
        
        var url = "/home/popup/view/include/secondpage"+pn+".jsp";
        
        var AjaxHTML = 
            $.ajax({
            url: url,
            param: pn,
            type: "POST",
            dataType: "jsp",
            async: false
         }).responseText;
        $('#firstBody').hide().slideDown(1000).html(AjaxHTML);
       /*  $('#firstBody').hide("slide", { direction: "left" }, 800);
        $('#secondBody').hide("slide", { direction: "left" }, 800).show("slide", { direction: "right" }, 800).html(AjaxHTML); */
      
         pn+=11;
        
    }
function next22(){
    
	//hide();
    /* $('#firstBody').hide("slide", { direction: "left" }, 300); */
    
    var url = "/home/popup/view/include/thirdpage"+pn+".jsp";
    
    var AjaxHTML = 
        $.ajax({
        url: url,
        param: pn,
        type: "POST",
        dataType: "jsp",
        async: false
     }).responseText;
    $('#firstBody').hide().slideDown(1000).html(AjaxHTML);
   /*  $('#firstBody').hide("slide", { direction: "left" }, 800);
    $('#secondBody').hide("slide", { direction: "left" }, 800).show("slide", { direction: "right" }, 800).html(AjaxHTML); */
     pn+=11;
	}
    
    function hide(){	
    	$('#firstBody').hide("slide", { direction: "left" }, 800);
    }
    
    function forSuccess(){
    	
    	if(opener.closed){
    		window.open("/home/intro/successStory.sub.action?gnb=15","","width=746,height=615,toolbar=yes,location=yes");
    	}else{
	   		opener.location.href="/home/intro/successStory.sub.action?gnb=15";
	   		opener.focus();
    	}
//     	window.open("/home/intro/successStory.sub.action?gnb=15","","width=746,height=615,toolbar=yes,location=yes");
		
    	
    }
    function forLecture(){
    	
    	//opener.location.href="/home/course/sampleCourse.sub.action?gnb=44";
      	window.open("/home/course/sampleCourse.sub.action?gnb=44","","width=746,height=615,toolbar=yes,location=yes");
    }
    
</script>
    
    



</body>
</html>