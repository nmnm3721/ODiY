<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!--  지도 -->
<script src="${pageContext.request.contextPath}/assets/js/d3.min.js"></script>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<!--  -->
<main>
	<div class="container swiperbody">
		<div class="swiper swiper-container gallery-top">
			<div class="swiper-wrapper">
				<c:forEach var="item" items="${output}" varStatus="status">
					<c:set var="title" value="${item.title}"></c:set>

					<c:url value="/detailpage/detail.do" var="detailURL">
						<c:param name="contentid" value="${item.contentid}"></c:param>
						<c:param name="contenttypeid" value="${item.contenttypeid}"></c:param>
						<c:param name="mapx" value="${item.mapx}"></c:param>
						<c:param name="mapy" value="${item.mapy}"></c:param>
					</c:url>

					<div class="swiper-slide" onclick="location.href='${detailURL}'"
						style="background-image: url(${item.firstimage}); cursor: pointer;">
						<h2 class="item-title">${item.title}</h2>
					</div>
				</c:forEach>

			</div>
			<!-- Add Arrows -->
			<div class="swiper-button-next swiper-button-white"></div>
			<div class="swiper-button-prev swiper-button-white"></div>
		</div>
		<div class="swiper-container gallery-thumbs">
			<div class="swiper-wrapper">
				<c:forEach var="item" items="${output}" varStatus="status">
					<c:set var="title" value="${item.title}"></c:set>

					<div class="swiper-slide"
						style="background-image: url(${item.firstimage})"></div>

				</c:forEach>
			</div>
		</div>
	</div>
	<!--  -->
	<div class="container media-body">
		<div class="row">
			<div class="col-md-6 media-mdbox text-center">
				<h2 class="main-sub-title">오늘의 추천 장소</h2>
				<div class="swiper-container second-gallery">
					<div class="swiper-wrapper">
						<c:forEach var="item" items="${outputRecommend}"
							varStatus="status">
							<c:set var="title" value="${item.title}"></c:set>

							<c:url value="/detailpage/detail.do" var="detailURL">
								<c:param name="contentid" value="${item.contentid}"></c:param>
								<c:param name="contenttypeid" value="${item.contenttypeid}"></c:param>
								<c:param name="mapx" value="${item.mapx}"></c:param>
								<c:param name="mapy" value="${item.mapy}"></c:param>
							</c:url>

							<div class="swiper-slide" onclick="location.href='${detailURL}'"
								style="background-image: url(${item.firstimage}); cursor: pointer;">
								<h4 class="recommend-title">${item.title}</h4>
							</div>

						</c:forEach>
					</div>
					<!-- Add Pagination -->
					<div class="swiper-pagination"></div>
					<!-- Add Arrows -->
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
				</div>
			</div>
			<div class="col-md-6 media-mdbox text-center">
				<h2 class="main-sub-title">오늘의 추천 식당</h2>
				<div class="swiper-container third-gallery">
					<div class="swiper-wrapper">
						<c:forEach var="item" items="${outputRecommendEat}"
							varStatus="status">
							<c:set var="title" value="${item.title}"></c:set>

							<c:url value="/detailpage/detail.do" var="detailURL">
								<c:param name="contentid" value="${item.contentid}"></c:param>
								<c:param name="contenttypeid" value="${item.contenttypeid}"></c:param>
								<c:param name="mapx" value="${item.mapx}"></c:param>
								<c:param name="mapy" value="${item.mapy}"></c:param>
							</c:url>

							<div class="swiper-slide" onclick="location.href='${detailURL}'"
								style="background-image: url(${item.firstimage}); cursor: pointer;">
								<h4 class="recommend-title">${item.title}</h4>
							</div>

						</c:forEach>
					</div>
					<!-- Add Pagination -->
					<div class="swiper-pagination"></div>
					<!-- Add Arrows -->
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- 지도 -->
	<div class="container arround-container" id="map">
		<button class="btn btn-primary arround-btn arround-group" onclick="returnCurrent();">
			<i class="fas fa-crosshairs"></i>
		</button>
	</div>


	<!-- 지도 불러오기 -->

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c4a66835ae932c4af82e8a731c0b876f"></script>
		
	<!-- 현재위치 -->

	<script>
	
	var latitude = 37.502542;
        var longitude = 127.024824;
        var mapContainer = document.getElementById("map")    // 지도를 표시할 DIV
        var mapOption = {
              center : new daum.maps.LatLng(37.502542, 127.024824)    // 지도의 중심좌표
            , level : 3    // 지도의 확대레벨
        };
        
        // 지도를 생성
        var map;

        // 마커가 표시될 위치
        var markerPosition;

        // 마커를 생성
	var marker;
	
	document.addEventListener("DOMContentLoaded", function() {
	 	       function getLocation(position) {
		
		            latitude = position.coords.latitude;
		            longitude = position.coords.longitude;
		        
		            var mapOption = {
		        	              center : new daum.maps.LatLng(latitude, longitude)    // 지도의 중심좌표
		        	            , level : 3    // 지도의 확대레벨
		            };
		           		            
		            // 지도를 생성
		            map = new daum.maps.Map(mapContainer, mapOption);
		
		            // 마커가 표시될 위치
		            markerPosition = new daum.maps.LatLng(latitude, longitude);
		
		            // 마커를 생성
			    marker = new daum.maps.Marker({ position:markerPosition });
		
		            marker.setMap(map);
		        }
	 	      
	 	       
	 	     
		        if(navigator.geolocation) {
		            navigator.geolocation.getCurrentPosition(getLocation, function(error) {
		        	    
		        	    latitude = 37.502542;
		    		    longitude = 127.024824;
			        
			            
			            // 지도를 생성
			            map = new daum.maps.Map(mapContainer, mapOption);
			
			            // 마커가 표시될 위치
			            markerPosition = new daum.maps.LatLng(latitude, longitude);
			
			            // 마커를 생성
				    marker = new daum.maps.Marker({ position:markerPosition });
			
			            marker.setMap(map);
		                consol.log(error.message);    
		            });
		        } else {
		            consol.log("Geolocation을 지원하지 않는 브라우저 입니다.");
		        }
		});
	
	function returnCurrent() {
	    	
		marker.setVisible(false);
		
		// 마커가 표시될 위치
	            markerPosition = new daum.maps.LatLng(latitude, longitude);
	
	            // 마커를 생성
		    marker = new daum.maps.Marker({ position:markerPosition });
		    marker.setMap(map);
	            
		
	           var moveLatLon = new kakao.maps.LatLng(latitude, longitude);
		    
		    // 지도 중심을 이동 시킵니다
		    map.setCenter(moveLatLon);
	}
	
	</script>

	<!-- --------------------------------------------------- -->

	<script>
		/* Swiper */
		var galleryThumbs = new Swiper('.gallery-thumbs', {

			spaceBetween : 10,
			slidesPerView : 5,
			freeMode : true,
			watchSlidesVisibility : true,
			watchSlidesProgress : true,
		});
		var galleryTop = new Swiper('.gallery-top', {
			loop : true,
			autoplay : { // 다음 슬라이드로 자동으로 넘어감 
				delay : 5000, //1000->1초
				disableOnInteraction : false, // true시 유저가 슬라이드 클릭시 자동이동이 멈춤. 
			},
			spaceBetween : 10,
			navigation : {
				nextEl : '.swiper-button-next',
				prevEl : '.swiper-button-prev',
			},
			thumbs : {
				swiper : galleryThumbs
			}
		});

		var swiper = new Swiper('.second-gallery', {
			loop : true,
			autoplay : { // 다음 슬라이드로 자동으로 넘어감 
				delay : 4000, //1000->1초
				disableOnInteraction : false, // true시 유저가 슬라이드 클릭시 자동이동이 멈춤. 
			},
			spaceBetween : 30,
			effect : 'fade',
			pagination : {
				el : '.swiper-pagination',
				clickable : true,
			},
			navigation : {
				nextEl : '.swiper-button-next',
				prevEl : '.swiper-button-prev',
			},
		});

		var swiper = new Swiper('.third-gallery', {
			loop : true,
			autoplay : { // 다음 슬라이드로 자동으로 넘어감 
				delay : 4000, //1000->1초
				disableOnInteraction : false, // true시 유저가 슬라이드 클릭시 자동이동이 멈춤. 
			},
			spaceBetween : 30,
			effect : 'fade',
			pagination : {
				el : '.swiper-pagination',
				clickable : true,
			},
			navigation : {
				nextEl : '.swiper-button-next',
				prevEl : '.swiper-button-prev',
			},
		});
		/* D3 */
		$(".dg-map svg").mouseover(function(event) {
			var _path = event.target;
			var city_name = _path.id;
			var new_p = document.createElement('p');
			var province = $(_path).parent()[0].id;
			d3.select(_path).style("fill", "#008c9e");
			//console.log(city_name);
		}).mouseout(function(event) {
			var _path = event.target;
			d3.select(_path).style("fill", "#fff");
		});

		function go_branch(city_do) {
			var Arr = Array("sejong", "chungnam", "jeju",
					"gyeongnam", "gyeongbuk", "jeonbuk",
					"chungbuk", "gangwon", "gyeonggi",
					"jeonnam", "ulsan", "busan", "daegu",
					"daejeon", "incheon", "seoul",
					"gwangju");
			var strArr = Array("세종특별자치시", "충청남도", "제주특별자치도",
					"경상남도", "경상북도", "전라북도", "충청북도", "강원도",
					"경기도", "전라남도", "울산광역시", "부산광역시",
					"대구광역시", "대전광역시", "인천광역시", "서울특별시",
					"광주광역시");
			//alert(city_do);
			var idx = Arr.indexOf(city_do);
			//alert(strArr[idx]);
			location.href = "./branches.php?stx=" + strArr[idx];
		}

		/*가맹점 지도 색칠*/
		$(document).ready(function() {
			var mapCondition = '<?=$stx?>';
			if (mapCondition == '세종특별자치시') {
				$('#sejong').css("fill", "#cbc3ac");
			} else if (mapCondition == '충청남도') {
				$('#chungnam').css("fill", "#cbc3ac");
			} else if (mapCondition == '제주특별자치도') {
				$('#jeju').css("fill", "#cbc3ac");
			} else if (mapCondition == '경상남도') {
				$('#gyeongnam').css("fill", "#cbc3ac");
			} else if (mapCondition == '경상북도') {
				$('#gyeongbuk').css("fill", "#cbc3ac");
			} else if (mapCondition == '전라북도') {
				$('#jeonbuk').css("fill", "#cbc3ac");
			} else if (mapCondition == '충청북도') {
				$('#chungbuk').css("fill", "#cbc3ac");
			} else if (mapCondition == '경기도') {
				$('#gyeonggi').css("fill", "#cbc3ac");
			} else if (mapCondition == '전라남도') {
				$('#jeonnam').css("fill", "#cbc3ac");
			} else if (mapCondition == '울산광역시') {
				$('#ulsan').css("fill", "#cbc3ac");
			} else if (mapCondition == '부산광역시') {
				$('#busan').css("fill", "#cbc3ac");
			} else if (mapCondition == '대구광역시') {
				$('#daegu').css("fill", "#cbc3ac");
			} else if (mapCondition == '대전광역시') {
				$('#daejeon').css("fill", "#cbc3ac");
			} else if (mapCondition == '인천광역시') {
				$('#incheon').css("fill", "#cbc3ac");
			} else if (mapCondition == '서울특별시') {
				$('#seoul').css("fill", "#cbc3ac");
			} else if (mapCondition == '광주광역시') {
				$('#gwangju').css("fill", "#cbc3ac");
			}
		});
		$(window).load(function() {
			$(".trigger_popup_fricc").click(function() {
				$('.hover_bkgr_fricc').show();
			});
			$('.hover_bkgr_fricc').click(function() {
				$('.hover_bkgr_fricc').hide();
			});
			$('.popupCloseButton').click(function() {
				$('.hover_bkgr_fricc').hide();
			});
		});
	</script>
</main>