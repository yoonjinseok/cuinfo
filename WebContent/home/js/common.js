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
	/*
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
	 * */
}

$(document).ready(function() {
	
	/*
	 * 전체메뉴 이벤트. sub.jsp 에서 구현하기위해 주석처리함.
	$('._sitemap_open').click(function(e){		
		$("#sitemap").show();
	});	

	$('._sitemap_close').click(function(e){		
		$("#sitemap").hide();
	});	
	 * */
	
	$(".faq_q_box").click(function(){   
		/*$(this).next().fadeSliderToggle();
		alert();
		 return false;
		*/
	});
});	

function applyListStyle(){
	$(".list_type1").find("li:nth-child(even)").addClass("even");	
	$(".list_type1").find("li:last-child").addClass("bottom");	

	$(".search_list_area").find(".class_box").find("dd:nth-child(even)").addClass("even");	
/*
	$(".photo_box").find("dd:nth-of-type(3)").addClass("even");	
	$(".photo_box").find("dd:nth-of-type(4)").addClass("even");	
 * */

	
	$(".univ_table.type1").find("tr:nth-child(even)").addClass("even");	

	$(".table_type1").find("tbody").find("tr:nth-child(even)").addClass("even");	
	$(".table_type1").find("tbody").find("tr:last-child").addClass("bottom");	
	$(".table_type1").find("tbody").find("td:last-child").addClass("end");	
	$(".table_type1").find("thead").find("tr").find("th:first-child").addClass("first");


	$(".univ_table").find("tbody").find("tr:last-child").addClass("bottom");	


	$("#location_box").find("ul").find("li:first-child").addClass("home");

	$(".borad_search").find("input[type='text']").addClass("type1");
	$(".faq_search").find("input[type='text']").addClass("type1");


	$("._search_major_sub").find("a:last-child").addClass("end");	

	

	$(".faq_list").find("li:last-child").addClass("last");

	$('._popup_type1').popupWindow({ 
		width:500, height:315, top:150, left:150 
	}); 

	$('._file_upload').popupWindow({ 
		width:500, height:230, top:150, left:150 
	}); 

	$("._popup_close").click(function(){
		window.close(); 
	}); 

}

function showModalWin(sURL, iWidth, iHeight)
{
    return window.showModalDialog(sURL, self, "dialogWidth:"+iWidth+"; dialogHeight:"+iHeight+"; center:yes");
}


//2012고도화 추가
function showWin(sURL, wname, iWidth, iHeight)
{
	
	
     //스크린의 크기
    sw=screen.availWidth;
    sh=screen.availHeight;
    
    //열 창의 포지션
    px=(sw-iWidth)/2;
    py=(sh-iHeight)/2;

	var pop = window.open(sURL, wname, "width="+iWidth+",height="+iHeight+",left="+px+",top="+py+",resizable=no,scrollbars=yes");
	
	if(pop)
		pop.focus();
	
}


/*
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
		 position.append("<a class=\"page\" href=\"javascript:goPage(1);\"><img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" /></a>");
		 position.append("<a class=\"page\" href=\"javascript:goPage("+(currPage-1)+");\"><img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" /></a>");
	 }
	 else
	 {
		 position.append("<img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" />");

		 position.append("<img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" />");
	 }
	 for(i = startpage; i <= endpage; i++){
	  if(i != currPage){
			  position.append("<a href=\"javascript:goPage("+i+");\">"+i+"</a>");
	  }
	  else
	  {
			  position.append("<span class='self'>"+i+"</span>");
	  }
	 }
	 

	 if((totpages > 1) && (currPage != totpages)){
		position.append("<a class=\"page\" href=\"javascript:goPage("+(currPage+1)+");\"><img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" /></a>");
		position.append("<a class=\"page\" href=\"javascript:goPage("+totpages+");\"><img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" /></a>");
	 }
	 else
	 {
		 position.append("<img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" />");
		 position.append("<img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" />");
	 }
}

function setPaging2(position, totalCnt, showCnt, currPage)
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
		position.append("<a class=\"page\" href=\"javascript:headerSearch(1);\"><img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" /></a>");
		position.append("<a class=\"page\" href=\"javascript:headerSearch("+(currPage-1)+");\"><img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" /></a>");
	}
	else
	{
		position.append("<img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" />");
		position.append("<img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" />");
	}
	for(i = startpage; i <= endpage; i++){
		if(i != currPage){
			position.append("<a href=\"javascript:headerSearch("+i+");\">"+i+"</a>");
		}
		else
		{
			position.append("<span class='self'>"+i+"</font>");
		}
	}
	
	
	if((totpages > 1) && (currPage != totpages)){
		position.append("<a class=\"page\" href=\"javascript:headerSearch("+(currPage+1)+");\"><img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" /></a>");
		position.append("<a class=\"page\" href=\"javascript:headerSearch("+totpages+");\"><img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" /></a>");
	}
	else
	{
		position.append("<img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" />");
		position.append("<img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" />");
	}
}
*/

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
		position.append("<a class=\"page\" href=\"javascript:goPage(1);\"><img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" /></a>");
		position.append("&nbsp;");
		position.append("&nbsp;");
		position.append("<a class=\"page\" href=\"javascript:goPage("+(currPage-1)+");\"><img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" /></a>");
	}
	else
	{
		position.append("<img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" />");
		position.append("&nbsp;");
		position.append("&nbsp;");
		
		position.append("<img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" />");
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
	
	
	if((totpages > 1) && (currPage != totpages)){
		position.append("<a class=\"page\" href=\"javascript:goPage("+(currPage+1)+");\"><img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" /></a>");
		position.append("&nbsp;");
		position.append("&nbsp;");
		
		position.append("<a class=\"page\" href=\"javascript:goPage("+totpages+");\"><img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" /></a>");
	}
	else
	{
		position.append("<img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" />");
		position.append("&nbsp;");
		position.append("&nbsp;");
		position.append("<img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" />");
	}
}

function setPaging2(position, totalCnt, showCnt, currPage)
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
		position.append("<a class=\"page\" href=\"javascript:headerSearch(1);\"><img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" /></a>");
		position.append("&nbsp;");
		position.append("&nbsp;");
		position.append("<a class=\"page\" href=\"javascript:headerSearch("+(currPage-1)+");\"><img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" /></a>");
	}
	else
	{
		position.append("<img src=\"/home/images/btn/pre02.gif\" alt=\"맨처음으로\" />");
		position.append("&nbsp;");
		position.append("&nbsp;");
		
		position.append("<img src=\"/home/images/btn/pre01.gif\" alt=\"처음으로\" />");
	}
	for(i = startpage; i <= endpage; i++){
		position.append("&nbsp;");
		if(i != currPage){
			position.append("<a href=\"javascript:headerSearch("+i+");\">"+i+"</a>&nbsp;");
		}
		else
		{
			position.append("<span class='self'>"+i+"</span>&nbsp;");
		}
	}
	
	
	if((totpages > 1) && (currPage != totpages)){
		position.append("<a class=\"page\" href=\"javascript:headerSearch("+(currPage+1)+");\"><img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" /></a>");
		position.append("&nbsp;");
		position.append("&nbsp;");
		
		position.append("<a class=\"page\" href=\"javascript:headerSearch("+totpages+");\"><img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" /></a>");
	}
	else
	{
		position.append("<img src=\"/home/images/btn/next01.gif\" alt=\"다음으로\" />");
		position.append("&nbsp;");
		position.append("&nbsp;");
		position.append("<img src=\"/home/images/btn/next02.gif\" alt=\"맨끝으로\" />");
	}
}

//get 방식으로 변수를 넘길경우 인코딩이 깨지므로 사용함.
function encoding( str )
{
	return escape(encodeURIComponent(str));
}

//SNS 공유하기
function sns(type){
	var url = "";
	var linkAddr = window.location.href;
	var title = document.title;

	if(type==1){ //트위터
		url = "http://twitter.com/home?status="+ encodeURI(title)+" : "+ linkAddr ; 
	}else if(type ==2){ //페이스북
		url = "http://www.facebook.com/sharer.php?u="+ linkAddr +"&t="+ encodeURI(title); 
	}else{ //미투데이
		url = "http://me2day.net/posts/new?new_post[body]='"+encodeURI(title)+"' : "+linkAddr+"&new_post[tags]="+encodeURI("CUInfo"); 
	}
	window.open(url, "SNS1","width=800, height=500, scrollbar=yes,toolbar=no,status=no");
}

//프린트
function getPageDocHtml() {
    return document.getElementById("contents").innerHTML;
}

function contentPrint() {
    var printWin = window.open("/home/common/printPage.jsp", "printWindow", "width=780,height=650,resizable=yes,scrollbars=yes");
  
	printWin.focus();
} 

//숫자만 입력될 수 있도록 함
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

//즐겨찾기 스크립트
function bookmark(){
	if (window.sidebar && window.sidebar.addPanel){ // Firefox 
		window.sidebar.addPanel('사이버대학 종합정보 ', 'http://www.cuinfo.net',"");
	} 
	else if ( document.all ) { // IE Favorite
		window.external.AddFavorite('http://www.cuinfo.net', '사이버대학 종합정보 '); 
	}
	else if (window.opera && window.print) {//opera
		alert("The current release of Opera will not add a bookmark from this script.");
	}
	else if (navigator.appName=="Netscape") { 
		alert("Please click OK, then press <Ctrl-D> to bookmark this page.");
	}
	
}


