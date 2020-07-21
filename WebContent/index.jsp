<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ODiY</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- Local CSS -->
<link rel="stylesheet" href="index/css/odiyhelp.css" type=text/css />
<link rel="stylesheet" href="index/css/common.css" type=text/css />
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/73acf29cbb.js"></script>
</head>
<body>
	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- 페이지 시작 -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="index.jsp">
			<span class="logo d-inline-block align-middle"></span>
			Offers, Destinations, in your mind
		</a>
	</nav>
	<div class="container">
		<h4>ODiY 프로젝트 지원용 페이지</h4>
		<div class="header row">
			<div class="content col">
				<%@ include file="index/menu1.jsp"%>
			</div>
			<div class="sidebar col-3">
			<%@ include file="index/sidebar.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>