$(function(){

	if('#visual_ChangeIMG3'){
		
		var visualrolling_vUl3 = $('#visual_ChangeIMG3'); // 롤링시킬 리스트 ul
		var visualrolling_vLi3 = $('li', visualrolling_vUl3); // 롤링시킬 리스트 li

		var visualrolling_pause3 = false; // 자동롤링을 위한 변수
		var main_visual3 = $('.future'); // 롤링배너의 전체 wrap, 와꾸
		var visualrolling_num3 = 0;
		var visualrolling_max_num3 = visualrolling_vLi3.length; // 롤링되는 리스트의 총 갯수
		
		/* 롤링되는 리스트 선택 버튼 클릭 이벤트*/
//		controlBtn2.find('a').mouseenter(function(){
//			
//			visualrolling_pause2 = false;
//			var T_exp_id2 = $(this).parent().attr('id').split('_'); // 언더바로 구분된 숫자로 순서를 인식함
//			visualrolling_auto_roll2(T_exp_id2[T_exp_id2.length-1]); // 클릭된 영역의 클래스의 on,off와 롤링되는 리스트의 show, hide
//			visualrolling_pause2 = true;
//		});
		 
		/* 마우스 오버 시 롤링을 멈추는 이벤트 */
		main_visual3.hover(function(){
		visualrolling_pause3 = true; // 마우스 오버 시, 멈춰랏
		}, function(){
			visualrolling_pause3 = false; // 마우스 아웃 시, 롤링되랏
		});

		$(".roll li").each(function(index){
			$(this).mouseenter(function(){
				visualrolling_auto_roll3(index);
			});
		});
		
		
		/* 클래스의 on,off와 롤링되는 리스트의 show, hide */
		function visualrolling_auto_roll3(goNum3) {
			/* 롤링을 위해 기존의 롤링되던 이벤트를 초기화 */
			visualrolling_vLi3.hide(); // 보여져 있던 모든 롤링 리스트 숨김
			visualrolling_vLi3.removeClass('on'); // 롤링 리스트의 on 클래스 제거
			
			if (typeof(goNum3) == "number") { // 보여질 리스트가 선택됨
				visualrolling_num3 = goNum3;
				
				$('#changeImg3_' + goNum3).show(); // 선택된 리스트를 보이기
				$('#changeImg3_' + goNum3).addClass('on'); // 선택된 리스트에 클래스 on 추가
				
				$(".future .roll li").attr("class","off");
				$(".future .roll li").eq(goNum3).attr("class","on");
						
			} else { // 보여질 리스트를 따로 선택하지 않으면
				
				visualrolling_num3++; // 1씩 증가하여 다음 리스트로 이동시킨다
				if(visualrolling_num3 == visualrolling_max_num3){ 
					visualrolling_num3 = 0;
				} // 리스트 총갯수보다 1 많아지면, 즉 모든 리스트가 롤링되면 다시 처음으로 가서 롤링
				
				$('#changeImg3_' + visualrolling_num3).fadeIn(2000); // 리스트 보이기
				$('#changeImg3_' + visualrolling_num3).addClass('on'); // 리스트에 클래스 on 추가
				if(visualrolling_num3=='0'){
					$(".future .roll li").attr("class","off");
					$(".future .roll li").eq(0).attr("class","on");
				}else if(visualrolling_num3=='1'){
					$(".future .roll li").attr("class","off");
					$(".future .roll li").eq(1).attr("class","on");
				}else if(visualrolling_num3=='2'){
					$(".future .roll li").attr("class","off");
					$(".future .roll li").eq(2).attr("class","on");
				}else{
					$(".future .roll li").attr("class","off");
					$(".future .roll li").eq(3).attr("class","on");
				}
				
			
				
			};
		};

		/* 자동롤링 선택 및 롤링지연시간 조절 - 지우면 자동롤링 안되게 함 */
		setInterval(function(){
			if (!visualrolling_pause3)
				visualrolling_auto_roll3();
		}, 5000);
	};
	
	
if('#visual_ChangeIMG9'){
		
		var visualrolling_vUl9 = $('#visual_ChangeIMG9'); // 롤링시킬 리스트 ul
		var visualrolling_vLi9 = $('li', visualrolling_vUl9); // 롤링시킬 리스트 li

		var visualrolling_pause9 = false; // 자동롤링을 위한 변수
		var main_visual9 = $('.future1'); // 롤링배너의 전체 wrap, 와꾸
		var visualrolling_num9 = 0;
		var visualrolling_max_num9 = visualrolling_vLi9.length; // 롤링되는 리스트의 총 갯수
		
		/* 마우스 오버 시 롤링을 멈추는 이벤트 */
		main_visual9.hover(function(){
		visualrolling_pause9 = true; // 마우스 오버 시, 멈춰랏
		}, function(){
			visualrolling_pause9 = false; // 마우스 아웃 시, 롤링되랏
		});

		$(".rolll li").each(function(index){
			$(this).mouseenter(function(){
				visualrolling_auto_roll9(index);
			});
		});
		
		
		
		function visualrolling_auto_roll9(goNum9) {
			
			visualrolling_vLi9.hide(); 
			visualrolling_vLi9.removeClass('on'); 
			
			if (typeof(goNum9) == "number") { 
				visualrolling_num9 = goNum9;
				
				$('#changeImg9_' + goNum9).show(); 
				$('#changeImg9_' + goNum9).addClass('on'); 
				
				$(".future1 .rolll li").attr("class","off");
				$(".future1 .rolll li").eq(goNum9).attr("class","on");
						
			} else { 
				
				visualrolling_num9++; 
				if(visualrolling_num9 == visualrolling_max_num9){ 
					visualrolling_num9 = 0;
				} // 리스트 총갯수보다 1 많아지면, 즉 모든 리스트가 롤링되면 다시 처음으로 가서 롤링
				
				$('#changeImg9_' + visualrolling_num9).fadeIn(2000); // 리스트 보이기
				$('#changeImg9_' + visualrolling_num9).addClass('on'); // 리스트에 클래스 on 추가
				
				if(visualrolling_num9=='0'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(0).attr("class","on");
				}else if(visualrolling_num9=='1'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(1).attr("class","on");
				}else if(visualrolling_num9=='2'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(2).attr("class","on");
				}else if(visualrolling_num9=='3'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(3).attr("class","on");
				}else if(visualrolling_num9=='4'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(4).attr("class","on");
				}else if(visualrolling_num9=='5'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(5).attr("class","on");
				}else if(visualrolling_num9=='6'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(6).attr("class","on");
				}else if(visualrolling_num9=='7'){
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(7).attr("class","on");
				}else{
					$(".future1 .rolll li").attr("class","off");
					$(".future1 .rolll li").eq(8).attr("class","on");
				}
				
			
				
			};
		};

		/* 자동롤링 선택 및 롤링지연시간 조절 - 지우면 자동롤링 안되게 함*/ 
		setInterval(function(){
			if (!visualrolling_pause9)
				visualrolling_auto_roll9();
		}, 5000);
		
	};

	


/* area_rolling_banner
--------------------------------------------------------*/

	// &lt;![CDATA[

	// 선택한 요소에 설정한 동작일 때, 자동롤링 정지
	$(".area_rolling_banner").mouseenter(function(){ 
		$("#rotate-left").yakurotate( 'stop' );
	});
	// 선택한 요소에 설정한 동작일 때, 자동롤링 시작
	$(".area_rolling_banner").mouseleave(function(){
		$("#rotate-left").yakurotate( 'play' );
	});

	$("#rotate-left").yakurotate({

		'duration' : 1500, // 롤링되는 속도
		'interval' : 3000, // 롤링되는 시간 간격
		'stopButton' : '#leftstopButton', // 롤링 시작버튼
		'playButton' : '#leftplayButton', // 롤링 멈춤버튼
		'prevButton' : '#leftprevButton', // 이전 리스트 롤링
		'nextButton' : '#leftnextButton', // 다음 리스트 롤링
		'fade': false, // 페이드인, 아웃 효과
		'move' : 'left', // 이동방향. top과 left 둘 중 선택
		'activeClass': 'on', // 활성화되는 리스트에 생성되는 클래스명
		'autoStart' : true , // 자동 롤링 선택
		'navContainer' : '.nav_rotate_left', // 롤링 네비게이션 설정
		'showNav' : true, // 롤링 네비게이션 보이기
		'opacity' : true // 투명도 설정

	});



});

