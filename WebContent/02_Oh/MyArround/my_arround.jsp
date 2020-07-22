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
	href="<%=request.getContextPath()%>/site/css/search_main.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/02_Oh/css/myArround.css"
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
		<div class="container arround-container">
			<img src="img/111.JPG" />
			<button type="button" class="btn btn-primary arround-btn"><i class="fas fa-crosshairs"></i></button>
			<div class="dropdown arround-dropdown1">
				<button class="btn btn-secondary dropdown-toggle arround-drop" type="button"
					id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Dropdown</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
					<button class="dropdown-item" type="button">Action</button>
					<button class="dropdown-item" type="button">Another action</button>
					<button class="dropdown-item" type="button">Something else
						here</button>
				</div>
			</div>
			<div class="dropdown arround-dropdown2">
				<button class="btn btn-secondary dropdown-toggle arround-drop" type="button"
					id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Dropdown</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
					<button class="dropdown-item" type="button">Action</button>
					<button class="dropdown-item" type="button">Another action</button>
					<button class="dropdown-item" type="button">Something else
						here</button>
				</div>
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