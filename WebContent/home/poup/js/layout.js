

///////��Ÿ��01(tab01_menu_box) ���� ����
function tab_style1(div_i,className){
	for(i=1;i<=5;i++){ 
		if(document.getElementById("tab1_menu"+i)!=null){ //�ǿ¿�������
			if(i==div_i){
				document.getElementById("tab1_menu"+i).className='on';
			}else{
				document.getElementById("tab1_menu"+i).className='off';
			}
		}
		
		if(document.getElementById("tab1_detail"+i)!=null){ //div����
			if(i==div_i){
				document.getElementById("tab1_detail"+i).style.display='block';
			}else{
				document.getElementById("tab1_detail"+i).style.display='none';
			}
		}
	}
}

///////��Ÿ��01(tab01_menu_box) ���� ����
function tab_style2(div_i,className){
	for(i=1;i<=5;i++){ 
		if(document.getElementById("tab2_menu"+i)!=null){ //�ǿ¿�������
			if(i==div_i){
				document.getElementById("tab2_menu"+i).className='on';
			}else{
				document.getElementById("tab2_menu"+i).className='off';
			}
		}
		
		if(document.getElementById("tab2_detail"+i)!=null){ //div����
			if(i==div_i){
				document.getElementById("tab2_detail"+i).style.display='block';
			}else{
				document.getElementById("tab2_detail"+i).style.display='none';
			}
		}
	}
}



///////��� �����̵�01 ����
var ImgNum1 = 6;

function list_type01_1(slide_id,direction,maxNum) {
	//alert(slide_id+ImgNum);
	if (maxNum<=1) return; //�ִ밪�� 1�����ϰ�� �������.
	
	ImgNum1 = ImgNum1 + direction;
	if(ImgNum1 > maxNum) ImgNum1 = 1; //�ּҰ� ����
	if(ImgNum1 == 0) ImgNum1 = maxNum; //�ִ밪 ����

	for(i=1;i<=maxNum;i++){
		if (document.getElementById(slide_id+i)!=null){
			document.getElementById(slide_id+i).style.display='none';
		}				
	}
	document.getElementById(slide_id+ImgNum1).style.display = "block";
}



///////��� �����̵�02 ����
var ImgNum2 = 6;

function list_type02_1(slide_id,direction,maxNum) {
	//alert(slide_id+ImgNum);
	if (maxNum<=1) return; //�ִ밪�� 1�����ϰ�� �������.
	
	ImgNum2 = ImgNum2 + direction;
	if(ImgNum2 > maxNum) ImgNum2 = 1; //�ּҰ� ����
	if(ImgNum2 == 0) ImgNum2 = maxNum; //�ִ밪 ����

	for(i=1;i<=maxNum;i++){
		if (document.getElementById(slide_id+i)!=null){
			document.getElementById(slide_id+i).style.display='none';
		}				
	}
	document.getElementById(slide_id+ImgNum2).style.display = "block";
}




///////��Ÿ��01(tab01_menu_box) ���� ����
function faq_style1(div_i,className){
	for(i=1;i<=5;i++){ 
		if(document.getElementById("faq_q"+i)!=null){ //�ǿ¿�������
			if(i==div_i){
				document.getElementById("faq_q"+i).className='on';
			}else{
				document.getElementById("faq_q"+i).className='off';
			}
		}
		
		if(document.getElementById("faq_a"+i)!=null){ //div����
			if(i==div_i){
				document.getElementById("faq_a"+i).style.display='block';
			}else{
				document.getElementById("faq_a"+i).style.display='none';
			}
		}
	}
}
