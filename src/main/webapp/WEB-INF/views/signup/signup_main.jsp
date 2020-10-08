<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>SignUp</title>

<!-- bootstrap css -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../plugins/ajax/ajax_helper.css">
<!-- Local CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bottom.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/signup.css" type="text/css" />

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/f6b62fe7f2.js"
	crossorigin="anonymous"></script>

<!-- Datepicker(생년월일 선택 플러그인)-->
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<!-- Datepicker CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/wbn-datepicker.css">
	<!-- Datepicker Js -->
	<script src="${pageContext.request.contextPath}/assets/js/wbn-datepicker.min.js"></script>	
		
		
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/73acf29cbb.js"></script>



</head>
<body>
	<%@ include file="../header/header.jsp"%>
	<%@ include file="main_signup.jsp"%>
	<%@ include file="../footer/footer.jsp"%>
</body>
</html>