<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>ODiY - Offers, Destinations, in your mind</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- Local CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/site/css/common.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/site/css/bottom.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/02_Oh/css/tripPlan.css"
	type="text/css" />
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/73acf29cbb.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- ************************************************* -->
	<%@ include file="../../site/header.jsp"%>

	<main>
		<div class="container">
			<div class="page-header-left plan-head">
				<h2>MY ODiY</h2>
			</div>
			<div class="row plan-row">
				<div class="col-12">
					<h3>추석 양평 여행</h3>
				</div>
				<div class="col-12">
					<img src="img/222.JPG" />
				</div>
			</div>
		</div>
		<div class="container">
			<div class="page-header-left plan-head">
				<h2>MY ROUTE</h2>
			</div>
			<div class="row plan-row">
				<div class="col-md-8">
					<%
						for (int i = 0; i < 5; i++) {
					%>
					<div class="item">
						<div class="box">
							<a href="detail.jsp"><img
								src="https://via.placeholder.com/180x180" alt=""></a>
						</div>
						<a href="detail.jsp"><h4>아주 아주 간단한 제목~~~~~~~~~~~~~~~~~~~~</h4></a>
						<br />
						<p>아주 아주 간단한 설명ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ</p>
						<br /> <br />
						<p>#태그는 하면 하고 말면 말고ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ</p>
					</div>
					<%
						}
					%>
				</div>
				<div class="col-md-4 plan-map">
					<img src="img/111.JPG" />
				</div>
			</div>
		</div>
		<div class="container plan-btn-container">
			<div class="page-header-left plan-head">
				<h2>MY MEMO</h2>
			</div>
			<div class="row plan-row">
				<div class="col-12">
					<textarea name="memo" id="memo" placeholder="여행계획에 대한 메모를 남겨보세요."></textarea>
				</div>
			</div>
			<div class="plan-btn-group">
				<button type="button" class="btn btn-outline-primary plan-btn">수정</button>
				<button type="button" class="btn btn-outline-primary plan-btn">저장</button>
			</div>
		</div>
	</main>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="../plugins/ajax/ajax_helper.js"></script>
	<!-- Place your kit's code here -->
	<script src="https://kit.fontawesome.com/f6b62fe7f2.js"
		crossorigin="anonymous"></script>


	<!-- ********************************************************** -->
	<%@ include file="../../site/footer.jsp"%>