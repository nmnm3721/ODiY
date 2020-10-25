$( () => {
	/** 상세검색 토글 */
	$("#dsearchbutton").click(function(e) {
		e.preventDefault();
		$("#dsearch").toggleClass("hidden");
	});
	$("#profilepic").click(function(e) {
		e.preventDefault();
		$("#pmenu").toggleClass("hidden");
	});
	
	/** 서브메뉴 클릭 시 hidden input에 파라미터 전달 */
	
	let tour_eat_zzz="";
	$("#selectTour").click(function() {
		tour_eat_zzz="tour";
		$(".tour_eat_zzz").val(tour_eat_zzz);
	});
	$("#selectEat").click(function() {
		tour_eat_zzz="eat";
		$(".tour_eat_zzz").val(tour_eat_zzz);
	});
	$("#selectZzz").click(function() {
		tour_eat_zzz="zzz";
		$(".tour_eat_zzz").val(tour_eat_zzz);
	});
	
	/** 페이지 로딩 시 전달된 파라미터 분류에 따라 active 강조 처리*/
	
	$(document).ready(function() {
		if($(".tour_eat_zzz").val()=="tour") {
			$("#indexnav>li:nth-child(2)").addClass("active");
			$("#indexnav>li:nth-child(3)").removeClass("active");
			$("#indexnav>li:nth-child(4)").removeClass("active");
		};
		if($(".tour_eat_zzz").val()=="eat") {
			$("#indexnav>li:nth-child(2)").removeClass("active");
			$("#indexnav>li:nth-child(3)").addClass("active");
			$("#indexnav>li:nth-child(4)").removeClass("active");
		};
		if($(".tour_eat_zzz").val()=="zzz") {
			$("#indexnav>li:nth-child(2)").removeClass("active");
			$("#indexnav>li:nth-child(3)").removeClass("active");
			$("#indexnav>li:nth-child(4)").addClass("active");
		};		
	});

	/** 체크박스 일괄선택기능 (전국) */
//	$("#ds_area_inlineCheckbox1").change(function() {
//		$("#ds_area input").prop('checked', $(this).prop('checked'));
//	});
	
	/** 체크박스 상태를 hidden input으로 전달 */
//	let detail_area="";
//	$("#ds_area .form-check-input").change(function() {
//		// 체크박스에 변경이 일어나면 각 체크박스 중 체크 된 체크박스 value값을 모아 string 생성
//		detail_area="0";
//		$("#ds_area .form-check-input:checked").each(function() {
//			detail_area+="-";
//			detail_area+=$(this).val();
//		});
//		$(".detail_area").val(detail_area);
//	});
//	
//	let detail_cat1="";
//	$("#ds_cat1 .form-check-input").change(function() {
//		// 체크박스에 변경이 일어나면 각 체크박스 중 체크 된 체크박스 value값을 모아 string 생성
//		detail_cat1="0";
//		$("#ds_cat1 .form-check-input:checked").each(function() {
//			detail_cat1+="-";
//			detail_cat1+=$(this).val();
//		});
//		$(".detail_cat1").val(detail_cat1);
//	});
	
	let detail_desc="";
	$("#ds_desc .form-check-input").change(function() {
		// 체크박스에 변경이 일어나면 각 체크박스 중 체크 된 체크박스 value값을 hidden input에 전달
		detail_desc=$("#ds_desc .form-check-input:checked").val();
		$(".detail_desc").val(detail_desc);
	});
	
	/** 페이지가 모두 로드되었을 때, hidden input value값에 따라 상세검색 라디오버튼 지정 */
	$(document).ready(function() {
		$("#ds_desc input").each(function() {
			if ($(this).val()==$(".detail_desc").val()) {
				$(this).prop("checked",true);
			} else {
				$(this).prop("checked",false);
			}
		});
	});
	
	/** 스크롤 내려갈 때 헤더 고정 이벤트 */
	let didScroll;
	$(window).scroll(function(){
		didScroll=true;
	});
	setInterval(function(){
		if (didScroll) {
			hasScrolled();
			didScroll=false;
		}
		mobileChange();
	}, 500);
	let hasScrolled = function() {
		if ($(window).scrollTop()>=75 && $(window).width()>=640) {
			$("#minilogo").removeClass("hidden").show(100);
			$("#minisearch").removeClass("hidden").show(300);
			$("#navmenu").addClass("fixse");
			$("#dsearch").css("position","fixed").addClass("fixds");
		} else if($(window).scrollTop()<=35 && $(window).width()>=640) {
					$("#minilogo").addClass("hidden").hide(100);
					$("#minisearch").addClass("hidden").hide(300);
					$("#navmenu").removeClass("fixse");
					$("#dsearch").css("position","absolute").removeClass("fixds");
				}
	};
	let mobileChange = function() {
		if ($(window).width()<=580) {
			$("#dsearch").css("width","360px");
			$("#dsearch").css("margin-left","20px");
		} else {
			$("#dsearch").css("width","420px");
			$("#dsearch").css("margin-left","200px");
		}
	}
});