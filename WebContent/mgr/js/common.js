function getFileSize(filesize) {
    unit = "bytes";
    
    if (filesize > 1024) {
    filesize = (filesize / 1024);
    unit = "Kbytes"; }
    if (filesize > 1024) {
    filesize = (filesize / 1024);
    unit = "Mbytes"; }
    if (filesize > 1024) {
    filesize = (filesize / 1024);
    unit = "Gbytes"; }
    if (filesize > 1024) {
    filesize = (filesize / 1024);
    unit = "Tbytes"; }
    
    filesize = Math.round(filesize,0);
    return filesize + unit;
};

function ImageOver(imgEL){
 imgEL.src = imgEL.src.replace("_off.gif", "_on.gif");
}
function ImageOut(imgEL){
 imgEL.src = imgEL.src.replace("_on.gif", "_off.gif");
}


function gnb_on(div_i,className){
	for(i=1;i<=7;i++){ 
		if(document.getElementById("gnb"+i)!=null){ //버튼ON/OFF
			if(i==div_i){
				document.getElementById("gnb"+i).className='on';
			}else{
				document.getElementById("gnb"+i).className='off';
			}
		}
		
		if(document.getElementById("gnb_sub"+i)!=null){ //div변경
			if(i==div_i){
				document.getElementById("gnb_sub"+i).style.display='block';
			}else{
				document.getElementById("gnb_sub"+i).style.display='none';
			}
		}
	}
}

function applyListStyle(){
	$(".list_type01").find("tbody").find("tr:nth-child(even)").addClass("even");	

	$(".list_type01").find("tr").find("th:first-child").addClass("first");	
	$(".list_type01").find("tr").find("td:first-child").addClass("first");	
	$(".list_type02").find("tr").find("th:last-child").addClass("last");	
	$(".list_type02").find("tr").find("td:last-child").addClass("last");	
};

function showWin(sURL, wname, iWidth, iHeight)
{
     //스크린의 크기
    sw=screen.availWidth;
    sh=screen.availHeight;
    
    //열 창의 포지션
    px=(sw-iWidth)/2;
    py=(sh-iHeight)/2;

    var pop;
    
    pop = window.open(sURL, wname, "width="+iWidth+",height="+iHeight+",left="+px+",top="+py+",resizable=no,scrollbars=yes");
    
    if(pop)
    	pop.focus();
}
var wins = new Array();
function popup(url, name, width, height, scrollable, resizable, status) {

    var top = (screen.width-width)/2;
    var left = (screen.height-height)/2;

    var option = "resizable=" + resizable + ", scrollbars=" + scrollable
               + ", toolbar=no, width=" + width + ", height=" + height
               + ", status=" + status + ", location=no, directory=no, menubar=no";
    var win = window.open('', name, option);
    // win.moveTo(top, left);
    win.focus();

    if( url ) win.location.href = url;

    wins[wins.length] = win;
}

function showModalWin(sURL, iWidth, iHeight)
{
    return window.showModalDialog(encodeURI(sURL), self, "dialogWidth:"+iWidth+"; dialogHeight:"+iHeight+"; center:yes");
}


function showModalWinParam(sURL, iWidth, iHeight,getParam, postParam)
{
	if(getParam.length>0){
		sURL = sURL + "?"+ getParam;
	}	
	if(postParam.length>0){
		postParam = "["+ postParam + "]";
	}else{
		postParam = self;	
	}
    return window.showModalDialog(sURL, postParam, "dialogWidth:"+iWidth+"; dialogHeight:"+iHeight+"; center:yes");
}

function setPaging(position, totalCnt, showCnt, currPage)
{
	var PAGEUNIT = 10;	// 페이징사이즈
	var totpages = Math.ceil(totalCnt/showCnt); //총페이지수
	 var thisblock = Math.ceil(currPage/PAGEUNIT); //현재 페이징블럭
	 var startpage, endpage;
	 var ret_HTML = "";

	 // 현재 페이지블럭의 시작페이지번호
	 if(thisblock > 1){
	  startpage = (thisblock-1)*PAGEUNIT+1;
	 }else{
	  startpage = 1;
	 }
	 
	 // 현재 페이지블럭의 끝페이지번호
	 if( (thisblock*PAGEUNIT) >= totpages ){
	  endpage = totpages;
	 }else{
	  endpage = thisblock*PAGEUNIT;
	 } 
	 
	 position.html('');

	 if(currPage > 1){
		 position.append("<a class=\"page\" href=\"javascript:goPage(1);\"><img src=\"/mgr/images/btn/pre02.gif\" alt=\"맨처음으로\" /></a>");
		 position.append("&nbsp;");
		 position.append("&nbsp;");
		 position.append("<a class=\"page\" href=\"javascript:goPage("+(currPage-1)+");\"><img src=\"/mgr/images/btn/pre01.gif\" alt=\"처음으로\" /></a>");
	 }
	 else
	 {
		 position.append("<img src=\"/mgr/images/btn/pre02.gif\" alt=\"맨처음으로\" />");
		 position.append("&nbsp;");
		 position.append("&nbsp;");
		 position.append("<img src=\"/mgr/images/btn/pre01.gif\" alt=\"처음으로\" />");
	 }
	 
	 for(i = startpage; i <= endpage; i++){
	  position.append("&nbsp;");
	  if(i != currPage){
		  position.append("<a href=\"javascript:goPage("+i+");\">"+i+"</a>&nbsp;");
	  }
	  else
	  {
		  position.append("<span class='self'>"+i+"</span>&nbsp;");
	  }
	 }
	
	 if((totpages > 1 ) && (currPage != totpages)){
		position.append("<a class=\"page\" href=\"javascript:goPage("+(currPage+1)+");\"><img src=\"/mgr/images/btn/next01.gif\" alt=\"다음으로\" /></a>");
		position.append("&nbsp;");
		position.append("&nbsp;");
		position.append("<a class=\"page\" href=\"javascript:goPage("+totpages+");\"><img src=\"/mgr/images/btn/next02.gif\" alt=\"맨끝으로\" /></a>");
	 }
	 else
	 {
		 position.append("<img src=\"/mgr/images/btn/next01.gif\" alt=\"다음으로\" />");
		 position.append("&nbsp;");
		 position.append("&nbsp;");
		 position.append("<img src=\"/mgr/images/btn/next02.gif\" alt=\"맨끝으로\" />");
	 }
}

function showCalendar(obj, format)
{
	if(format == undefined)
	{
		format = 'yy-mm-dd';
	}
	
	obj.datepicker({dateFormat: format
		,yearRange: 'c-15:c+15'
		, showButtonPanel: false
		, changeYear: true
		, dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']});
}

//텍스트박스에서 날짜를 받아 달력형식(format)으로 변경한다.
function setDateFormat(obj,format){
	var strPattern;
	if(format == undefined) format = "-";
	
	if(format != "/"){	
		strPattern = eval("/" + format + "/g");
	}else{
		strPattern = eval("/\//g");
	}
	
	var strDate  = obj.value.replace(strPattern,"");

	var strYear  = strDate.substr(0,4);
	var strMonth = strDate.substr(4,2);
	var strDay   = strDate.substr(6,2);

	var resultDate = new Date(strYear, strMonth - 1,strDay);
	
	if(resultDate.getFullYear() != strYear ||
	   resultDate.getMonth() + 1  != eval(strMonth) ||
	   resultDate.getDate() != strDay){
		obj.value = "";
	}else{
		obj.value = strYear + format + strMonth + format + strDay;
	}
}

//왼쪽으로 채워줄 값을 넣어서 길이를 맞춰줌
//  totalLength : 문자 최대 길이, addString : 채워줄 값
function lpad(strVal, totalLength, addString){
	if(addString == undefined) addString = "0";
	
	strVal = strVal +"";
	strVal = trim(strVal);	
	while(strVal.length < totalLength)	strVal = addString + strVal;
	return strVal;
}

//trim처리. 
function trim(strVal){
	strVal = strVal +"";
	strVal =  strVal.replace(/^\s*/,'').replace(/\s*$/, ''); 
	return strVal;
}

function numbersonly(obj) { 
	
	var tmpValue = obj.value.toString();
    var regexp = /[^0-9]/gi;
    var repexp = '';
    if (regexp.test(tmpValue)){
        alert("숫자만 입력가능합니다.");
        tmpValue = tmpValue.replace(regexp, "");
        obj.value = tmpValue;
    }		
}


function sort(sorting)
{
	if($("#sorting").val() != sorting)
		$('#ascending').val('0');
	else
	{
		if($("#ascending").val() == '0')
			$('#ascending').val('1');
		else
			$('#ascending').val('0');
	}
		
	$("#sorting").val(sorting);
	goPage(1);
}
