<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>ODiY - Offers, Destinations, in your mind</title>
<!-- CSS -->

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- Swiper CSS -->
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/swiper.css" />

<!-- Local CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/common.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bottom.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets//css/myArround.css"
	type="text/css" />
<!-- JS -->

<!-- Bootstrap, jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/73acf29cbb.js"></script>

<!-- swiper.js -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- Local JS -->
<script type="text/javascript">
$( function() {
	$("#indexnav li:nth-child(1)").addClass("active");
});
</script>

</head>
<body>
	<jsp:include page="header/header.jsp"></jsp:include>
	<jsp:include page="mainpage/imain.jsp"></jsp:include>
	<jsp:include page="footer/footer.jsp"></jsp:include>

</body>
</html>