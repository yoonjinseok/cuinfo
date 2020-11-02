var manager_Collection = null;
var manager_CollectionEntry = null;
var manager_CollectionEntryCheck = null;

function manager_getCollectionEntry(coll) {
	if (manager_Collection == null) {
		manager_Collection = new Array();
		manager_CollectionEntry = new Array();
		manager_CollectionEntryCheck = new Array();
	}
	
	var finded = false;
	var i;
	for (i = 0; i < manager_Collection.length; i ++)
		if (manager_Collection[i] == coll) {
			finded = true;
			break;
		}
		
	if (finded) {	//	exist collection
		return i;
	}
	else {			//	not exist collection 
		var index = manager_Collection.length;
		manager_Collection[index] = coll;
		manager_CollectionEntry[index] = new Array();
		manager_CollectionEntryCheck[index] = new Array();
		return index;
	}
		
}

function manager_addDocIdForDelete(coll, docid, checkid) {
	//alert(coll + " : " + docid + " : " + checkid);
	var index = manager_getCollectionEntry(coll);
	
	var entry = manager_CollectionEntry[index];
	var entryCheck = manager_CollectionEntryCheck[index];
	
	/*	is exist docid	*/
	for (var i = 0; i < entry.length; i ++) 
		if (entry[i] == docid) {	/*	exist docid	*/
			entryCheck[i] = document.getElementById(checkid).checked;
			return;		
		}
		
	/*	not exist docid	*/
	entry[entry.length] = docid;
	entryCheck[entryCheck.length] = document.getElementById(checkid).checked;
}

function manager_runDelete(wwwUrl, managerUrl, searcherIP, searcherPort) {
	if (manager_Collection == null) return ;
	
	var xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
	xmlString    += "<Request>\n";
	xmlString    += "<MGR>\n";
	xmlString    += "<Command>Indexer</Command>\n";
	xmlString    += "<Data>\n";
	xmlString    += "<Job>Delete Document</Job>\n";
	xmlString    += "<Searcher>\n";
	xmlString    += "<IP>" + searcherIP  + "</IP>\n";
	xmlString    += "<Port>" + searcherPort  + "</Port>\n";
	xmlString    += "</Searcher>\n";
	
	for (var i = 0; i < manager_Collection.length; i ++) {
		
		xmlString    += "<Collection>\n";
		xmlString    += "<Name>" + manager_Collection[i] + "</Name>\n";
		
		var list = manager_CollectionEntry[i];
		var lstCheck = manager_CollectionEntryCheck[i];
		var docids = "";
		for (var j = 0; j < list.length; j ++) {
			//alert(list[j] + " " + lstCheck[j]);
			if (lstCheck[j]) {
				xmlString    += "<DOCID>" + list[j] + "</DOCID>\n";
			}
		}
		
		xmlString    += "</Collection>\n";
	}
	
	xmlString += "</Data>\n";
	xmlString += "</MGR>\n";
	xmlString += "</Request>\n";
	
	manager_sendDeleteDocs(wwwUrl, xmlString, managerUrl);
}


/****************************************************************************
 XMLHTTPRequest 객체를 생성해서 url에 parameter와 함께 post 방식으로 보낸다.
*****************************************************************************/
var manager_XMLHttp = null;   
function manager_getXMLHttpRequest() {   
	if (manager_XMLHttp == null) {   
		var tryThese = [   
				function () {	var obj = new XMLHttpRequest()
								obj.overrideMimeType('text/xml');
								return obj; 
							},
				function () { 	return new ActiveXObject('Microsoft.XMLHTTP'); },
				function () { 	return new ActiveXObject('Msxml2.XMLHTTP'); }, 
				null
			];

		for (var i = 0; i < tryThese.length; i++) {   
			manager_XMLHttp = tryThese[i];   
			var func = tryThese[i];   
			try {   
				return func();   
			} catch (e) {   
				//	skip
			}   
		}   
	} else {   
		return manager_XMLHttp();   
	}
} 

/*  send data   */
function manager_sendDeleteDocs(wwwUrl, xmlString, managerUrl) {	
	var req = manager_getXMLHttpRequest();
	//alert(wwwUrl + " url:" + managerUrl + "\n" + xmlString + "\n");

	if (req) {
		req.open("POST", wwwUrl, true);		// true는 결과가 나오기전까지 대기
		req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8'); // post방식은 utf-8 필수 세팅
		req.onreadystatechange = function() {
				//alert(req.responseText);	//req.responseXML
				if (req.readyState == 4) { 
					// 정상 응답이라면
					if (req.status == 200) {
						//alert(req.responseText);	
					} else {
						//alert("not 200 \n" + req.responseText);
					}
					alert(req.responseText);	
				} else {
				}
			}
		req.send("xml=" + xmlString + "&" + "sfmurl=" + managerUrl);
	}
}