<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<div class="kuwasii">
		<!--관광지이름-->
		<hr />
		<h2 class="detail-subtitle">${output.title}</h2>
		<hr />

		<!--관광지이름완료!-->
	</div>
	<!--체크박스(담기)-->
	<form class="favorite" method="post"
		action="${pageContext.request.contextPath}/favorite_add.do">
		<input type="hidden" name="pagename" value="detail" /> <input
			type="hidden" name="contentid" value="${output.contentid}" /> <input
			type="hidden" name="keyword" value="${keyword}" /> <input
			type="hidden" name="userNum"
			value="${login_session_value.getUserNum()}" />
		<button type="submit" class="btn btn-primary"
			style="font-family: 메이플스토리;">즐겨찾기 추가</button>
	</form>
	<!--체크박스(담기)완료!-->
	<!--상세정보 사진,글-->

	<div class="row col-12">
		<div id="box" class="col-md-6 col-12 kuwasii-img">
			<c:choose>
				<c:when test="${empty output.firstimage}">
					<img
						src="https://via.placeholder.com/450x300/CCC/222/?text=No Image" />
				</c:when>
				<c:otherwise>
					<img src="${output.firstimage}" />
				</c:otherwise>
			</c:choose>
		</div>
		<div id="box" class="col-md-6 col-12 kuwasii-kaki">
			<h4 class="detail-subtitle">관광지정보</h4>
			<p class="detail-intro">${itemBase.overview}</p>
		</div>
	</div>

	<!--상세정보 사진,글완료!-->
	<!--상세정보 전화번호,주소,이용시간 등등-->
	<div class="joho">
		<!--제목-->
		<hr />
		<h2 class="detail-subtitle">상세정보</h2>
		<hr />
		<!--제목완료!-->
		<!--전화번호-->
		<li><font size="4" class="detail-intro">문의 및 안내 전화번호</font>
			<div class="detail-intro-text">

				<c:choose>
					<c:when test="${not empty output.tel}">
							${output.tel}
						</c:when>
				</c:choose>
			</div> <br /></li>
		<!--전화번호완료!-->
		<!--홈페이지링크 연동받을때 link_home 클래스로 받기-->
		<li><font size="4" class="detail-intro">홈페이지 링크</font>
			<div class="detail-intro-text">

				<c:choose>
					<c:when test="${not empty itemBase.homepage}">
							${itemBase.homepage}
						</c:when>
				</c:choose>
			</div> <br /></li>
		<!--홈페이지링크 완료!-->
		<!--주소-->
		<li><font size="4" class="detail-intro">주소</font>
			<div class="detail-intro-text">

				<c:choose>
					<c:when test="${not empty output.addr1}">
							${output.addr1}
						</c:when>
				</c:choose>
			</div> <br /></li>
		<!--주소완료!-->
		<!--이용시간-->
		<li><font size="4" class="detail-intro">이용시간</font>
			<div class="detail-intro-text">

				<c:choose>
					<c:when test="${not empty itemIntro.usetime}">
							${itemIntro.usetime}
						</c:when>
					<c:when test="${not empty itemIntro.usetimeculture}">
							${itemIntro.usetimeculture}
						</c:when>
					<c:when test="${not empty itemIntro.usetimeleports}">
							${itemIntro.usetimeleports}
						</c:when>
				</c:choose>
			</div> <br /></li>
		<!--이용시간완료!-->
		<!--휴일-->
		<li><font size="4" class="detail-intro">휴일</font>
			<div class="detail-intro-text">

				<c:choose>
					<c:when test="${not empty itemIntro.restdate}">
							${itemIntro.restdate}
						</c:when>
					<c:when test="${not empty itemIntro.restdateculture}">
							${itemIntro.restdateculture}
						</c:when>
					<c:when test="${not empty itemIntro.restdateleports}">
							${itemIntro.restdateleports}
						</c:when>
					<c:when test="${not empty itemIntro.restdateshopping}">
							${itemIntro.restdateshopping}
						</c:when>
					<c:when test="${not empty itemIntro.restdatefood}">
							${itemIntro.restdatefood}
						</c:when>
				</c:choose>
			</div> <br /></li>
		<!--휴일완료!-->
		<!--주차-->
		<li><font size="4" class="detail-intro">주차 여부</font>
			<div class="detail-intro-text">

				<c:choose>
					<c:when test="${not empty itemIntro.parking}">
							${itemIntro.parking}
						</c:when>
					<c:when test="${not empty itemIntro.parkingculture}">
							${itemIntro.parkingculture}
						</c:when>
					<c:when test="${not empty itemIntro.parkingleports}">
							${itemIntro.parkingleports}
						</c:when>
					<c:when test="${not empty itemIntro.parkinglodging}">
							${itemIntro.parkinglodging}
						</c:when>
					<c:when test="${not empty itemIntro.parkingshopping}">
							${itemIntro.parkingshopping}
						</c:when>
					<c:when test="${not empty itemIntro.parkingfood}">
							${itemIntro.parkingfood}
						</c:when>
				</c:choose>
			</div> <br /></li>
		<!--주차 완료!-->
		<!--입장료-->
		<li><font size="4" class="detail-intro">이용요금</font>
			<div class="detail-intro-text">

				<c:choose>
					<c:when test="${not empty itemIntro.usefee}">
							${itemIntro.usefee}
						</c:when>
					<c:when test="${not empty itemIntro.usetimefestival}">
							${itemIntro.usetimefestival}
						</c:when>
				</c:choose>
			</div> <br /></li>
		<!--입장료 완료!-->
	</div>
	<!--상세정보 전화번호,주소,이용시간 등등 완료!-->
	<!--편의기능시작-->
	<div class="benri">
		<c:choose>

			<c:when test="${empty output.mapx}">
				<h2
					style="font-family: 메이플스토리2; text-align: center; margin-top: 300px; margin-bottom: 300px;">위치정보가
					없습니다.</h2>
			</c:when>

			<c:otherwise>
				<!--지도시작-->
				<hr />
				<h2 class="detail-subtitle">위치 지도</h2>
				<hr />
				<div id="detail-map"></div>
				<!--로드뷰출력 -->
				<div id="detail-roadview" style="margin:auto; width:90%; height:300px;"></div> <!--#detail-roadview css 적용이 안됨.. -->
			</c:otherwise>
		</c:choose>

		<!--지도끝!-->
		<!--지역주변 추천-->
		<c:choose>

			<c:when test="${empty recommendOutput}">
				<h2
					style="font-family: 메이플스토리2; text-align: center; margin-top: 300px; margin-bottom: 300px;">지역
					추천 조회결과가 없습니다.</h2>
			</c:when>

			<c:otherwise>
				<div class="place_osusume">
					<hr />
					<h2 class="detail-subtitle">지역주변 추천</h2>
					<hr />
					<div class="row">
						<c:forEach var="item" items="${recommendOutput}"
							varStatus="status">

							<c:url value="/detailpage/detail.do" var="detailURL">
								<c:param name="contentid" value="${item.contentid}"></c:param>
								<c:param name="contenttypeid" value="${item.contenttypeid}"></c:param>
								<c:param name="mapx" value="${item.mapx}"></c:param>
								<c:param name="mapy" value="${item.mapy}"></c:param>
							</c:url>

							<div class="col-lg-4 col-12 detail-recommend-thum">
								<a href="${detailURL}" class="thumbnail detail-recommend-title">
									<img src="${item.firstimage}" class="pick-size img-responsive" />
									<h5 class="detail-recommend-title">${item.title}</h5>
								</a>
							</div>

						</c:forEach>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		<!--지역주변 추천끝!-->
		<!--지역 축제-->
		<c:choose>

			<c:when test="${empty festivalOutput}">
				<h2
					style="font-family: 메이플스토리2; text-align: center; margin-top: 300px; margin-bottom: 300px;">지역
					축제 조회결과가 없습니다.</h2>
			</c:when>

			<c:otherwise>
				<div class="place_party">
					<hr />
					<h2 class="detail-subtitle">지역 축제</h2>
					<hr />
					<div class="row">
						<c:forEach var="item" items="${festivalOutput}" varStatus="status">

							<c:url value="/detailpage/detail.do" var="detailURL">
								<c:param name="contentid" value="${item.contentid}"></c:param>
								<c:param name="contenttypeid" value="${item.contenttypeid}"></c:param>
								<c:param name="mapx" value="${item.mapx}"></c:param>
								<c:param name="mapy" value="${item.mapy}"></c:param>
							</c:url>

							<div class="col-lg-4 col-12 detail-recommend-thum">
								<a href="${detailURL}" class="thumbnail detail-recommend-title">
									<img src="${item.firstimage}" class="pick-size img-responsive" />
									<h5 class="detail-recommend-title">${item.title}</h5>
								</a>
							</div>

						</c:forEach>

					</div>
					<hr />
				</div>
			</c:otherwise>
		</c:choose>
		<!--지역 축제 끝!-->


	</div>
</div>

<!-- 지도 불러오기 -->

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c4a66835ae932c4af82e8a731c0b876f"></script>

<script>
	var container = document.getElementById("detail-map");
	var latitude = ${output.mapy};
	var longitude = ${output.mapx};
	var options = {
		center : new kakao.maps.LatLng(latitude, longitude),
		level : 3
	};

	var map = new kakao.maps.Map(container, options);

	var markerPosition = new kakao.maps.LatLng(latitude, longitude);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	
	
	// 로드뷰 출력
	var roadviewContainer = document.getElementById('detail-roadview'); //로드뷰를 표시할 div
	var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
	var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

	var position = new kakao.maps.LatLng(latitude, longitude);

	// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
	roadviewClient.getNearestPanoId(position, 50, function(panoId) {
	    roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
	});
</script>