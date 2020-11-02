/***********************************************  
 XMLHTTPRequest ��ü�� �����ؼ� url�� parameter�� �Բ� post ������� ������.
 ����� processReqChange�� ���ؼ� Ȯ��
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
* �Էµ� Ű���带 WNSimple������ �����ϰ� req��ü����
*   ����� ���� �޴´�.
**********************************************/
function loadXMLDoc(_str, url) {
    var str = checkStr(_str);
	var param = "query="+str+"&target=spellcheck";
	req = getXMLHttpRequest();
	if (req) {
		req.open("POST", url, true);		// false�� ����� ������������ ���
		req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8'); // post����� utf-8 �ʼ� ����
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				// ���� �����̶��
				if (req.status == 200) {
					// ������ ���� ���� ���� �� �̿�
					buildResult(req);
				}
			}
		}
		req.send(param);
    } 
}

/**********************************************
*   �Էµ� Ű���� üũ
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
* ��õ�� XML �Ľ�
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
* ����� html�� ȭ�� ����
**********************************************/
function buildResult(req) {
	xmlRet = req.responseXML;
	var qObj = document.getElementById("query");
	var returnValue = firstChildValue(xmlRet, 0, "Return");
	if(returnValue == 0) { //��õ���� Ű���尡 ���� ���
		var str = "�˻��� <span class=\"red\">'"+qObj.value+"'</span>�� ���� ���հ˻� �˻���� �Դϴ�. ";
		document.getElementById("ota").innerHTML = str;
	}else if(returnValue == 1 ) { //��/�� Ű��ȯ �Ǵ� ���� ���縵 üũ ����� �ִ� ���
		var word = firstChildValue(xmlRet, 0, "Word");
		var str = "�˻��� <span class=\"red\">'"+qObj.value+"'</span>�� ���� ���հ˻� �˻���� �Դϴ�.";
		    str +=" Ȥ�� ã�� ���� ���� '<a href=\"javascript:research('"+word+"');\">"+word+"</a>' �ΰ���?";
		document.getElementById("ota").innerHTML = str;
	}else if(returnValue == 2) { //��Ÿ �������� ã�� ���
		var word = firstChildValue(xmlRet, 0, "Word");
		var str = "�˻��� <span class=\"red\">'"+qObj.value+"'</span>�� ���� ���հ˻� �˻���� �Դϴ�.";
		    str +=" Ȥ�� ã�� ���� ���� '<a href=\"javascript:research('"+word+"');\">"+word+"</a>' �ΰ���?";
		document.getElementById("ota").innerHTML = str;
	}else if(returnValue == 3) { //���ܾ� ��Ÿ �ڵ� ��õ
		var word = firstChildValue(xmlRet, 0, "Word");
		var str = "�˻��� <span class=\"red\">'"+qObj.value+"'</span>�� ���� ���հ˻� �˻���� �Դϴ�.";
		    str +=" Ȥ�� ã�� ���� ���� '<a href=\"javascript:research('"+word+"');\">"+word+"</a>' �ΰ���?";
		document.getElementById("ota").innerHTML = str;
	}
	else {
		return;
	}
}

/**********************************************
* ���ôܾ� ��˻�
**********************************************/
function research(query) {
	   	var searchForm = document.search;
	   	document.search.query.value=query;
	   	searchForm.submit();
	}