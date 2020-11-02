/***********************************************  
 XMLHTTPRequest 객체를 생성해서 url에 parameter와 함께 post 방식으로 보낸다.
 결과는 processReqChange를 통해서 확인
**********************************************/
var XMLHttp = null;   
function getXMLHttpRequest() {   
	if (XMLHttp == null) {   
		var tryThese = [   
			function () { 
				var obj = new XMLHttpRequest();
				obj.overrideMimeType('text/xml');
				return obj; 
			},
			function () { return new ActiveXObject('Microsoft.XMLHTTP'); },
			function () { return new ActiveXObject('Msxml2.XMLHTTP'); }, 
			null
		];

		for (var i = 0; i < tryThese.length; i++) {   
			XMLHttp = tryThese[i];   
			var func = tryThese[i];   
			try {   
				return func();   
			} catch (e) {   
				// pass   
			}   
		}   
	}else {   
		return XMLHttp();   
	}
} 
 
/**********************************************
* 입력된 키워드를 WNSimple서버로 전송하고 req객체에서
*   결과를 전달 받는다.
**********************************************/
function loadXMLDoc(_str, url) {
    var str = checkStr(_str);
	var param = "query="+str+"&target=spellcheck";
	req = getXMLHttpRequest();
	if (req) {
		req.open("POST", url, true);		// false는 결과가 나오기전까지 대기
		req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8'); // post방식은 utf-8 필수 세팅
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				// 정상 응답이라면
				if (req.status == 200) {
					// 서버로 부터 전달 받은 값 이용
					buildResult(req);
				}
			}
		}
		req.send(param);
    } 
}

/**********************************************
*   입력된 키워드 체크
**********************************************/
function checkStr(str) {
    var ch;
    var returnStr = "";
    for (var i=0;i<str.length;i++) {
        ch = str.charAt(i);
        if(ch==" ")
            returnStr += "%20";
        else
            returnStr +=ch;
    }
    return returnStr;
}

/**********************************************
* 추천어 XML 파싱
**********************************************/
function firstChildValue(xml, idx, tagname) {
	var xmltest = xml.getElementsByTagName(tagname)[idx];
	var ret = "error";
	if(xmltest != null){
		ret = xml.getElementsByTagName(tagname)[idx].firstChild.nodeValue;
	}
	return ret
}

/**********************************************
* 결과를 html로 화면 노출
**********************************************/
function buildResult(req) {
	xmlRet = req.responseXML;
	var qObj = document.getElementById("query");
	var returnValue = firstChildValue(xmlRet, 0, "Return");
	if(returnValue == 0) { //추천해줄 키워드가 없는 경우
		var str = "검색어 <span class=\"red\">'"+qObj.value+"'</span>에 대한 통합검색 검색결과 입니다. ";
		document.getElementById("ota").innerHTML = str;
	}else if(returnValue == 1 ) { //한/영 키변환 또는 영문 스펠링 체크 결과가 있는 경우
		var word = firstChildValue(xmlRet, 0, "Word");
		var str = "검색어 <span class=\"red\">'"+qObj.value+"'</span>에 대한 통합검색 검색결과 입니다.";
		    str +=" 혹시 찾고 싶은 것이 '<a href=\"javascript:research('"+word+"');\">"+word+"</a>' 인가요?";
		document.getElementById("ota").innerHTML = str;
	}else if(returnValue == 2) { //오타 사전에서 찾은 경우
		var word = firstChildValue(xmlRet, 0, "Word");
		var str = "검색어 <span class=\"red\">'"+qObj.value+"'</span>에 대한 통합검색 검색결과 입니다.";
		    str +=" 혹시 찾고 싶은 것이 '<a href=\"javascript:research('"+word+"');\">"+word+"</a>' 인가요?";
		document.getElementById("ota").innerHTML = str;
	}else if(returnValue == 3) { //영단어 오타 자동 추천
		var word = firstChildValue(xmlRet, 0, "Word");
		var str = "검색어 <span class=\"red\">'"+qObj.value+"'</span>에 대한 통합검색 검색결과 입니다.";
		    str +=" 혹시 찾고 싶은 것이 '<a href=\"javascript:research('"+word+"');\">"+word+"</a>' 인가요?";
		document.getElementById("ota").innerHTML = str;
	}
	else {
		return;
	}
}

/**********************************************
* 제시단어 재검색
**********************************************/
function research(query) {
	   	var searchForm = document.search;
	   	document.search.query.value=query;
	   	searchForm.submit();
	}