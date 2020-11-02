function ImageOver(imgEL){
 imgEL.src = imgEL.src.replace("_off.gif", "_on.gif");
}
function ImageOut(imgEL){
 imgEL.src = imgEL.src.replace("_on.gif", "_off.gif");
}






$(document).ready(function() {
	$(".faq_q_box").click(function(){   
		$(this).next().fadeSliderToggle()
		 return false;
	})
	
	/*
	 * 전체메뉴 이벤트. sub.jsp 에서 구현하기위해 주석처리함.
	$('._sitemap_open').click(function(e){		
		$("#sitemap").show();
	});	

	$('._sitemap_close').click(function(e){		
		$("#sitemap").hide();
	});	
	 * */
	
	$(".list_type1").find("li:nth-child(even)").addClass("even");	
	$(".list_type1").find("li:last-child").addClass("bottom");	
	$(".search_list_area").find(".class_box").find("dd:nth-child(even)").addClass("even");
	
	/* 예외 발생.
	$(".photo_box").find("dd:nth-of-type(3)").addClass("even");	
	$(".photo_box").find("dd:nth-of-type(4)").addClass("even");	
	*/
	
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
});


