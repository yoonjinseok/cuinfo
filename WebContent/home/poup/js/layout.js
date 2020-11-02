

///////탭타입01(tab01_menu_box) 영역 시작
function tab_style1(div_i,className){
	for(i=1;i<=5;i++){ 
		if(document.getElementById("tab1_menu"+i)!=null){ //탭온오프변경
			if(i==div_i){
				document.getElementById("tab1_menu"+i).className='on';
			}else{
				document.getElementById("tab1_menu"+i).className='off';
			}
		}
		
		if(document.getElementById("tab1_detail"+i)!=null){ //div변경
			if(i==div_i){
				document.getElementById("tab1_detail"+i).style.display='block';
			}else{
				document.getElementById("tab1_detail"+i).style.display='none';
			}
		}
	}
}

///////탭타입01(tab01_menu_box) 영역 시작
function tab_style2(div_i,className){
	for(i=1;i<=5;i++){ 
		if(document.getElementById("tab2_menu"+i)!=null){ //탭온오프변경
			if(i==div_i){
				document.getElementById("tab2_menu"+i).className='on';
			}else{
				document.getElementById("tab2_menu"+i).className='off';
			}
		}
		
		if(document.getElementById("tab2_detail"+i)!=null){ //div변경
			if(i==div_i){
				document.getElementById("tab2_detail"+i).style.display='block';
			}else{
				document.getElementById("tab2_detail"+i).style.display='none';
			}
		}
	}
}



///////배너 슬라이딩01 시작
var ImgNum1 = 6;

function list_type01_1(slide_id,direction,maxNum) {
	//alert(slide_id+ImgNum);
	if (maxNum<=1) return; //최대값이 1이하일경우 실행안함.
	
	ImgNum1 = ImgNum1 + direction;
	if(ImgNum1 > maxNum) ImgNum1 = 1; //최소값 설정
	if(ImgNum1 == 0) ImgNum1 = maxNum; //최대값 설정

	for(i=1;i<=maxNum;i++){
		if (document.getElementById(slide_id+i)!=null){
			document.getElementById(slide_id+i).style.display='none';
		}				
	}
	document.getElementById(slide_id+ImgNum1).style.display = "block";
}



///////배너 슬라이딩02 시작
var ImgNum2 = 6;

function list_type02_1(slide_id,direction,maxNum) {
	//alert(slide_id+ImgNum);
	if (maxNum<=1) return; //최대값이 1이하일경우 실행안함.
	
	ImgNum2 = ImgNum2 + direction;
	if(ImgNum2 > maxNum) ImgNum2 = 1; //최소값 설정
	if(ImgNum2 == 0) ImgNum2 = maxNum; //최대값 설정

	for(i=1;i<=maxNum;i++){
		if (document.getElementById(slide_id+i)!=null){
			document.getElementById(slide_id+i).style.display='none';
		}				
	}
	document.getElementById(slide_id+ImgNum2).style.display = "block";
}




///////탭타입01(tab01_menu_box) 영역 시작
function faq_style1(div_i,className){
	for(i=1;i<=5;i++){ 
		if(document.getElementById("faq_q"+i)!=null){ //탭온오프변경
			if(i==div_i){
				document.getElementById("faq_q"+i).className='on';
			}else{
				document.getElementById("faq_q"+i).className='off';
			}
		}
		
		if(document.getElementById("faq_a"+i)!=null){ //div변경
			if(i==div_i){
				document.getElementById("faq_a"+i).style.display='block';
			}else{
				document.getElementById("faq_a"+i).style.display='none';
			}
		}
	}
}
