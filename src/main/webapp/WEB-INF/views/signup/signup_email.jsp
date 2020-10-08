<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
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

<!-- bootstrap js -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/f6b62fe7f2.js"
	crossorigin="anonymous"></script>

	
	<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/73acf29cbb.js"></script>



</head>
<body>
	<%@ include file="../header/header.jsp"%>
	<%@ include file="email.jsp"%>
	<%@ include file="../footer/footer.jsp"%>
</body>
</html>