
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>프린트</title>
<link rel="stylesheet" type="text/css" href="/home/css/print.css" />
</head>
<script type="text/javascript" language="javascript">

function initPage() {
	
   document.getElementById("printpage").innerHTML = opener.getPageDocHtml();
   sns_box.style.visibility = "hidden";
}

function removeTag()
{
	var objA = document.getElementsByTagName("a");
	for(i=0; i<objA.length;i++)
	{
		objA[i].href = "#";
	}
}

function runPrint()
{
	window.onbeforeprint = function(){
		document.getElementById("header1").style.visibility = "hidden";
		document.getElementById("print1").style.visibility = "hidden";
	};

	window.onafterprint = function(){
		document.getElementById("header1").style.visibility = "visible";
		document.getElementById("print1").style.visibility = "visible";
	};	

	 window.focus();
    window.print();
}


</script>
<noscript>javascript를 지원하지않는 브라우저에서는  프린트기능을 지원하지않습니다.</noscript>
<body onLoad="initPage();removeTag();">
<div id="header1">
	<h1>프린트</h1>
	<a class="_popup_close" href="javascript:self.close()"><img src="/mgr/images/btn/close.gif" alt="닫기"  onclick="self.close();"/></a>
</div>
<div class="t_center m_b30" id="print1">
  <input type="image" src="/home/images/btn/print.gif" onclick="runPrint()" alt="프린트"  style="float:right; padding:10px 0 0 15px" />
</div>
<div id="contents" style="width:100%"><!-- Contents End -->
		<div id="printpage"></div>
</div><!-- Contents Section End -->

</body>
</html>