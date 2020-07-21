<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<div class="container">
	<div class="top">
		<!-- 스크롤 내려야 보이는 부분 -->
		<div class="minilogo">
			<a href="index.html" title="ODiY 홈으로 이동"><span class="minilogo"></span></a>
		</div>
		<div class="minisearch">
			<form action="search/search.html" class="form-inline">
				<input type="search" class="form-control col" placeholder="어디로 갈까요?"
					aria-label="Search" />
				<button class="btn btn-outline-secondary col-2" type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
		<!-- 스크롤 내려야 보이는 부분 끝 -->
		<div class="minimenu">
			<div class="profile">
				<a href="#"><span class="profile"></span></a>
			</div>
			<div class="mini">
				<a href="#">Sign In</a>
			</div>
			<div class="mini">
				<a href="#"><i class="fas fa-question-circle"></i> Guide</a>
			</div>
			<div class="pmenu">
				<div class="pmenuc">
					<a href="#" class="pmenuli">나의 프로필</a>
				</div>
				<div class="pmenuc">
					<a href="#" class="pmenuli">즐겨찾기</a>
				</div>
				<div class="pmenuc">
					<a href="#" class="pmenuli">여행계획</a>
				</div>
				<div class="pdivider"></div>
				<div class="pmenuc">
					<a href="#" class="pmenuli">로그아웃</a>
				</div>
			</div>
		</div>

	</div>
	<div class="header">
		<div class="logo">
			<a href="index.html" title="ODiY 홈으로 이동"><span class="logo"></span></a>
		</div>
		<div class="search">
			<form action="" class="form-inline">
				<input type="search" class="form-control mr-sm-2 col"
					placeholder="어디로 갈까요?" aria-label="Search" />
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
			<ul class="navbar-nav">
				<li class="nav-item"><a href="#" class="nav-link">내주변</a></li>
				<li class="nav-item active"><a href="#" class="nav-link">여행지
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a href="#" class="nav-link">코스</a></li>
				<li class="nav-item"><a href="#" class="nav-link">식당</a></li>
				<li class="nav-item"><a href="#" class="nav-link">숙박</a></li>
				<li class="nav-item"><a href="#" class="nav-link">축제</a></li>
				<li class="nav-item"><a href="#" class="nav-link"><i
						class="far fa-plus-square"></i></a></li>
			</ul>
		</div>
	</nav>
	<!-- 상세검색 체크박스, + 버튼 클릭시 보임 -->
	<div class="dsearch row">
		<div class="col-4" style="padding: 0 5px;">
			<div class="border rounded">
				<p>
					<strong>지역</strong>
				</p>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input" value="option1"
						id="inlineCheckbox1" checked /> <label for="inlineCheckbox1"
						class="form-check-label">전국</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input" value="option2"
						id="inlineCheckbox2" /> <label for="inlineCheckbox2"
						class="form-check-label">서울</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input" value="option3"
						id="inlineCheckbox3" /> <label for="inlineCheckbox3"
						class="form-check-label">경기</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input" value="option4"
						id="inlineCheckbox4" /> <label for="inlineCheckbox4"
						class="form-check-label">인천</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input" value="option5"
						id="inlineCheckbox5" /> <label for="inlineCheckbox5"
						class="form-check-label">대전</label>
				</div>
			</div>
		</div>
		<div class="col-5" style="padding: 0 5px;">
			<div class="border rounded">
				<p>
					<strong>소분류</strong>
				</p>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input"
						id="inlineCheckbox1" value="option1" /><label
						for="inlineCheckbox1" class="form-check-label">소분류 1</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input"
						id="inlineCheckbox2" value="option2" /><label
						for="inlineCheckbox2" class="form-check-label">소분류 2</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input"
						id="inlineCheckbox3" value="option3" /><label
						for="inlineCheckbox3" class="form-check-label">소분류글자긴거1</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input"
						id="inlineCheckbox4" value="option4" /><label
						for="inlineCheckbox4" class="form-check-label">소분류글자긴거3</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input"
						id="inlineCheckbox5" value="option5" /><label
						for="inlineCheckbox5" class="form-check-label">소분류 5</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="checkbox" class="form-check-input"
						id="inlineCheckbox6" value="option6" /><label
						for="inlineCheckbox6" class="form-check-label">소분류 6</label>
				</div>
			</div>
		</div>
		<div class="col-3" style="padding: 0 5px;">
			<div class="border rounded">
				<p>
					<strong>정렬</strong>
				</p>
				<div class="form-check">
					<input type="radio" class="form-check-input" id="dsearchRadios1"
						name="dsearchRadios" value="option1" checked /><label
						for="dsearchRadios1" class="form-check-label">등록일</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input" id="dsearchRadios2"
						name="dsearchRadios" value="option2" /><label
						for="dsearchRadios2" class="form-check-label">조회수</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input" id="dsearchRadios3"
						name="dsearchRadios" value="option3" /><label
						for="dsearchRadios3" class="form-check-label">좋아요</label>
				</div>
			</div>
		</div>
	</div>

</div>