<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- ************************************************* -->
<main>
	<div class="container">
		<!-- 
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
		-->
		<%
			for (int i = 0; i < 10; i++) {
		%>
		<div class="smain row">
			<div class="col-md-9 col-xs-10">
				<div class="left">
					<div class="box">
						<a href="detail.jsp"><img src="https://via.placeholder.com/180x180" alt=""></a>
					</div>
					<a href="detail.jsp"><h4>아주 아주 간단한 제목</h4></a>
					<br />
					<p>아주 아주 간단한 설명</p>
					<br /> <br />
					<p>#태그는 하면 하고 말면 말고</p>
				</div>
			</div>
			<div class="col-md-3 col-xs-2">
				<div class="right">
					<!--체크박스디자인-->
					<label class="favorite"> <input type="checkbox"
						name="check" id="check<%=i%>"> <label for="check<%=i%>"
						class="check-box"></label> <label for="check<%=i%>"
						class="check-text">담기</label>
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

<!-- ********************************************************** -->