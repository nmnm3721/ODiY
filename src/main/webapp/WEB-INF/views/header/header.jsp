<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="${pageContext.request.contextPath}/assets/js/header.js"></script>
<div class="container">
	<div class="top" id="top">
		<!-- 스크롤 내려야 보이는 부분 -->
		<div class="minilogo hidden" id="minilogo">
			<a href="${pageContext.request.contextPath}/" title="ODiY 홈으로 이동">
				<span class="minilogo"></span>
			</a>
		</div>
		<div class="minisearch hidden" id="minisearch">
			<form method="get"
				action="${pageContext.request.contextPath}/search/search.do"
				class="form-inline">
				<input type="search" class="form-control" placeholder="어디로 갈까요?"
					aria-label="Search" name="keyword" value="${keyword}" />
				<input type="hidden" class="tour_eat_zzz" name="tour_eat_zzz" value="${tour_eat_zzz}" />
				<!-- <input type="hidden" class="detail_area" name="detail_area" value="${detail_area}" />
				<input type="hidden" class="detail_cat1" name="detail_cat1" value="${detail_cat1}" /> -->
				<input type="hidden" class="detail_desc" name="detail_desc" value="${detail_desc}" />
				<button class="btn btn-outline-secondary" type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
		<!-- 스크롤 내려야 보이는 부분 끝 -->
		<div class="minimenu" id="minimenu">
			<div class="profile">
				<a href="#"> <span class="profile" id="profilepic"></span>
				</a>
			</div>
			<div class="mini">
				<c:choose>
					<c:when test="${empty login_session_value}">
						<a href="#" data-toggle="modal" data-target="#modalsignin">Sign
							In</a>
					</c:when>
					<c:otherwise>
						<p>${login_session_value.getUserName()}</p>
					</c:otherwise>
				</c:choose>

			</div>
			<div class="mini">
				<a href="#" data-toggle="modal" data-target="#modalguide"> <i
					class="fas fa-question-circle"></i> Guide
				</a>
			</div>
			<c:choose>
				<c:when test="${empty login_session_value}">
					<div class="pmenu hidden" id="pmenu">
						<div class="pmenuc">
							<a href="#" data-toggle="modal" data-target="#modalsignin"
								class="pmenuli">로그인 하세요!</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="pmenu hidden" id="pmenu">
						<div class="pmenuc">
							<form method="get"
								action="${pageContext.request.contextPath}/mypage/mypage.do">
								<input type="hidden" name="userNum"
									value="${login_session_value.getUserNum()}" />
								<button type="submit" class="pmenuli">마이페이지</button>
							</form>
						</div>
						<div class="pdivider"></div>
						<div class="pmenuc">
							<a href="${pageContext.request.contextPath}/login/logout.do"
								class="pmenuli">로그아웃</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

	</div>
	<div class="header">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/" title="ODiY 홈으로 이동">
				<span class="logo"></span>
			</a>
		</div>
		<div class="search">
			<form method="get"
				action="${pageContext.request.contextPath}/search/search.do"
				class="form-inline">
				<input type="search" class="form-control mr-sm-2 col"
					placeholder="어디로 갈까요?" aria-label="Search" name="keyword"
					value="${keyword}" />
				<input type="hidden" class="tour_eat_zzz" name="tour_eat_zzz" value="${tour_eat_zzz}" />
				<!-- <input type="hidden" class="detail_area" name="detail_area" value="${detail_area}" />
				<input type="hidden" class="detail_cat1" name="detail_cat1" value="${detail_cat1}" /> -->
				<input type="hidden" class="detail_desc" name="detail_desc" value="${detail_desc}" />
				<button class="btn btn-outline-secondary my-2 my-sm-0 col-2"
					type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
	</div>
	<nav class="navbar navbar-expand-sm navbar-light" id="navmenu">
		<!-- 모바일에서 보이는 펼침목록 버튼 -->
		<a href="#" class="navbar-brand d-sm-none"> </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- 모바일에서 보이는 펼침목록 버튼 끝 -->
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav" id="indexnav">
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/home.do" class="nav-link">
						홈 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/search/search.do?tour_eat_zzz=tour"
					class="nav-link" id="selectTour">여행지</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/search/search.do?tour_eat_zzz=eat" class="nav-link" id="selectEat">식당</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/search/search.do?tour_eat_zzz=zzz" class="nav-link" id="selectZzz">숙박</a></li>
				<li class="nav-item"><a href="#" class="nav-link"
					id="dsearchbutton"> <i class="far fa-plus-square"></i>
				</a></li>
			</ul>
		</div>
	</nav>
	<!-- 상세검색 체크박스, + 버튼 클릭시 보임 -->
	<div class="dsearch row hidden" id="dsearch">
		<!-- <div class="col-6" style="padding: 0 5px;">
			<div class="border rounded" id="ds_area">
				<p>
					<strong>지역</strong>
				</p>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox1" class="form-check-label"><input
						type="checkbox" class="form-check-input" value="0"
						id="ds_area_inlineCheckbox1" checked />전국</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox2" class="form-check-label"><input
						type="checkbox" value="1" class="form-check-input"
						id="ds_area_inlineCheckbox2" />서울</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox3" class="form-check-label"><input
						type="checkbox" value="2" class="form-check-input"
						id="ds_area_inlineCheckbox3" />인천</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox4" class="form-check-label"><input
						type="checkbox" value="3" class="form-check-input"
						id="ds_area_inlineCheckbox4" />대전</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox5" class="form-check-label"><input
						type="checkbox" value="4" class="form-check-input"
						id="ds_area_inlineCheckbox5" />대구</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox6" class="form-check-label"><input
						type="checkbox" value="5" class="form-check-input"
						id="ds_area_inlineCheckbox6" />광주</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox7" class="form-check-label"><input
						type="checkbox" value="6" class="form-check-input"
						id="ds_area_inlineCheckbox7" />부산</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox8" class="form-check-label"><input
						type="checkbox" value="7" class="form-check-input"
						id="ds_area_inlineCheckbox8" />울산</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox9" class="form-check-label"><input
						type="checkbox" value="8" class="form-check-input"
						id="ds_area_inlineCheckbox9" />세종</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox10" class="form-check-label"><input
						type="checkbox" value="31" class="form-check-input"
						id="ds_area_inlineCheckbox10" />경기</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox11" class="form-check-label"><input
						type="checkbox" value="32" class="form-check-input"
						id="ds_area_inlineCheckbox11" />강원</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox12" class="form-check-label"><input
						type="checkbox" value="33" class="form-check-input"
						id="ds_area_inlineCheckbox12" />충북</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox13" class="form-check-label"><input
						type="checkbox" value="34" class="form-check-input"
						id="ds_area_inlineCheckbox13" />충남</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox14" class="form-check-label"><input
						type="checkbox" value="35" class="form-check-input"
						id="ds_area_inlineCheckbox14" />경북</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox15" class="form-check-label"><input
						type="checkbox" value="36" class="form-check-input"
						id="ds_area_inlineCheckbox15" />경남</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox16" class="form-check-label"><input
						type="checkbox" value="37" class="form-check-input"
						id="ds_area_inlineCheckbox16" />전북</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox17" class="form-check-label"><input
						type="checkbox" value="38" class="form-check-input"
						id="ds_area_inlineCheckbox17" />전남</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_area_inlineCheckbox18" class="form-check-label"><input
						type="checkbox" value="39" class="form-check-input"
						id="ds_area_inlineCheckbox18" />제주</label>
				</div>
			</div>
		</div>
		<div class="col-3" style="padding: 0 5px;">
			<div class="border rounded" id="ds_cat1">
				<p>
					<strong>분류</strong>
				</p>
				<div class="form-check form-check-inline">
					<label for="ds_cat1_inlineCheckbox1" class="form-check-label"><input
						type="checkbox" value="A01" class="form-check-input"
						id="ds_cat1_inlineCheckbox1" />자연</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_cat1_inlineCheckbox2" class="form-check-label"><input
						type="checkbox" value="A02" class="form-check-input"
						id="ds_cat1_inlineCheckbox2" />문화</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_cat1_inlineCheckbox3" class="form-check-label"><input
						type="checkbox" value="A03" class="form-check-input"
						id="ds_cat1_inlineCheckbox3" />레저</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_cat1_inlineCheckbox4" class="form-check-label"><input
						type="checkbox" value="A04" class="form-check-input"
						id="ds_cat1_inlineCheckbox4" />쇼핑</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_cat1_inlineCheckbox5" class="form-check-label"><input
						type="checkbox" value="A05" class="form-check-input"
						id="ds_cat1_inlineCheckbox5" />음식</label>
				</div>
				<div class="form-check form-check-inline">
					<label for="ds_cat1_inlineCheckbox6" class="form-check-label"><input
						type="checkbox" value="B02" class="form-check-input"
						id="ds_cat1_inlineCheckbox6" />숙박</label>
				</div>
			</div>
		</div> -->
		<div class="col-3" style="padding: 0 5px;">
			<div class="border rounded" id="ds_desc">
				<p>
					<strong>정렬</strong>
				</p>
				<div class="form-check">
					<input type="radio" class="form-check-input" id="dsearchRadios1"
						name="dsearchRadios" value="createdtime-desc" checked /> <label
						for="dsearchRadios1" class="form-check-label">최신순</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input" id="dsearchRadios2"
						name="dsearchRadios" value="readcount-desc" /> <label for="dsearchRadios2"
						class="form-check-label">인기순</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input" id="dsearchRadios3"
						name="dsearchRadios" value="title" /> <label for="dsearchRadios3"
						class="form-check-label">제목순</label>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- modal 영역 -->
<!-- modal guide -->
<div class="modal fade" tabindex="-1" id="modalguide" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">ODiY Guide</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>
					<i class="far fa-lightbulb"></i> 검색창에 원하는 지역이나 관광지를 입력하고 <i class="fas fa-search"></i> 버튼을 누르세요.
				</p>
				<p>
					<i class="far fa-lightbulb"></i> 여행지, 식당, 숙박 등의 메뉴를 선택하신 뒤 <i class="fas fa-search"></i> 버튼을
					클릭하시면 해당 분류만 검색됩니다.
				</p>
				<p>
					<i class="far fa-lightbulb"></i> 메뉴의 <i class="far fa-plus-square"></i> 버튼을 눌러 원하는 검색 조건을 체크하시고 <i
						class="fas fa-search"></i> 버튼을 클릭하시면 상세 조건에 맞는 검색 결과가 출력됩니다.
				</p>
				<p><i class="far fa-lightbulb"></i> 회원가입 후 원하는 여행지를 즐겨찾기에 담아 보세요.</p>
				<p><i class="far fa-lightbulb"></i> 행복한 여행을 즐기세요!</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
<!-- modal signin -->
<div class="modal fade" tabindex="-1" id="modalsignin"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">ODiY Sign-In</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="logo_move">
					<p style="color: #00dffc; font-family: 메이플스토리;">ODiY</p>
				</div>
				<form method="post"
					action="${pageContext.request.contextPath}/login/logingo.do">
					<div class="form-group">
						<input type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="user_email" placeholder="아이디">
					</div>
					<div class="form-group ">
						<input type="password" class="form-control" name="user_pw"
							id="exampleInputPassword1" placeholder="비밀번호">
					</div>
					<div>
						<p style="height: 10px;"></p>
					</div>
					<button type="submit" class="col-12 btn btn-outline-primary">로그인</button>
				</form>
				<a class="go_signup"
					href="${pageContext.request.contextPath}/signup/email.do"><button
						type="button" class="col-12 btn btn-outline-primary sign_btn">회원가입</button></a>
			</div>
			<div>
				<p style="height: 10px;"></p>
			</div>
		</div>
	</div>
</div>
</div>