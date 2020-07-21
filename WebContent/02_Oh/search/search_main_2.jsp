<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="../site/header.jsp"%>
<!-- ************************************************* -->
<main>
	<div class="container">
		<div class="page-header">
			<div class="input-group">
				<input type="text" class="form-control"
					placeholder="검색어를 입력하세요. 한 글자 공백도 쌉가능."> <span
					class="input-group-btn">
					<button type="button" class="btn btn-default" id="search">
						<i class="fas fa-search"></i>
					</button>
				</span>
			</div>
		</div>
		<%
			for (int i = 0; i < 10; i++) {
		%>
		<div class="row">
			<div class="col-md-9 col-xs-10">
				<div class="left">
					<div class="box">
						<img src="https://via.placeholder.com/180x180" alt="">
					</div>
					<h4>아주 아주 간단한 제목</h4>
					<br />
					<p>아주 아주 간단한 설명</p>
					<br /> <br />
					<p>#태그는 하면 하고 말면 말고</p>
				</div>
			</div>
			<div class="col-md-3 col-xs-2">
				<div class="right">
					<!--체크박스디자인-->
					<label class="favorite">
						<input type="checkbox" name="check" id="check<%=i%>">
						<label for="check<%=i%>" class="check-box"></label>
						<label for="check<%=i%>" class="check-text">담기</label>
					</label>
					<!--**체크박스디자인끝-->
				</div>
			</div>
		</div>
		<%
			}
		%>
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
<%@ include file="../site/footer.jsp"%>