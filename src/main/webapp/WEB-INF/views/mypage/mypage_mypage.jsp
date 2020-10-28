<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<div class="kuwasii">
		<!--MY INFO-->
		<hr />
		<h2>MY INFO</h2>
		<hr />
	</div>






	<form method="post"
		action="${pageContext.request.contextPath}/mypage/mypage.do"
		enctype="multipart/form-data">
		<input type="hidden" name="user_num"
			value="${login_session_value.getUserNum()}">

		<div class="row  myinfo">


			<div class="col-md-4 col-4 profilepic"></div>

			<div class="col-md-4 col-4 infobox">
				<p>
				<h6>아이디</h6>
				${login_session_value.getUserEmail()}
				</p>
				<p>
				<h6>닉네임</h6>
				${login_session_value.getUserName()}
				</p>
				<p>
				<h6>비밀번호</h6>
				****
				</p>
			</div>
			<div style="clear: both" class="col-md-4 col-4 infochangebutton">
				<span>
					<button type="button"
						class="btn btn-outline-primary infochange_btn">회원정보 변경</button>
				</span>
			</div>

		</div>

		<div class="row  myinfochange hidden">




			<div class="col-md-4col-4 infobox">
				<p>
				<h6>아이디</h6>
				${login_session_value.getUserEmail()}
				</p>
				<p>
				<h6>이름</h6>
				<input type="name" id="user_name" name="user_name"
					class="form-control" placeholder="바꿀 닉네임">
				</p>

				<p>
				<h6>바꿀 비밀번호</h6>
				<input type="password" id="user_pw" name="user_pw"
					class="form-control" placeholder="바꿀비밀번호">
				</p>

			</div>
			<div style="clear: both"></div>
			<div class="col-md-4 col-4 infochangebutton">
				<span>
					<button type="submit"
						class="btn btn-outline-primary infochange_btn_done">수정완료</button>
				</span>

			</div>
			

		</div>
		
	</form>
	
	
	<form method="post"
		action="${pageContext.request.contextPath}/mypage/mypageout.do">
		<input type="hidden" name="user_num"
			value="${login_session_value.getUserNum()}">
			
			
			
			
			<div class=" infochangebutton">
				<span>
					<button  type="submit"
						class="btn btn-outline-danger infochange_btn_done">회원탈퇴</button>
				</span>

			</div>
		</form>
		
<br />
<br />

	<!--MY INFO 끝-->
	<!--MY FAVORITE 시작-->
	<div>
		<!--제목-->
		<hr />
		<h2>MY FAVORITE</h2>
		<hr />
	</div>
	<!---->
	<!---->

	<div class="favorite-item row">
		<c:choose>

			<c:when test="${empty output}">
				<h2
					style="font-family: 메이플스토리2; text-align: center; margin-top: 300px; margin-bottom: 300px;">즐겨찾기가
					없습니다.</h2>
			</c:when>

			<c:otherwise>
				<c:forEach var="item" items="${output}" varStatus="status">
					<c:set var="title" value="${item.title}"></c:set>

					<c:url value="/detailpage/detail.do" var="detailURL">
						<c:param name="contentid" value="${item.contentid}"></c:param>
						<c:param name="contenttypeid" value="${item.contenttypeid}"></c:param>
						<c:param name="mapx" value="${item.mapx}"></c:param>
						<c:param name="mapy" value="${item.mapy}"></c:param>
					</c:url>

					<div class="row col-sm-6 favorite-item-diag">

						<div class="col-md-4 fav-thumbnail">
							<a href="${detailURL}"> <c:choose>
									<c:when test="${empty item.firstimage2}">
										<img
											src="https://via.placeholder.com/150x120/CCC/222/?text=No Image" />
									</c:when>
									<c:otherwise>
										<img src="${item.firstimage2}" class="favorite-thumb" />
									</c:otherwise>
								</c:choose>
							</a>
						</div>
						<div class="col-md-6 col-10 favorite-text">
							<a href="${detailURL}">
								<div>
									<h4>${item.title}</h4>
									<br />
									<p>#위치 : ${item.addr1}</p>
									<p>등록일 : ${item.createdtime} / 최근 수정일 :
										${item.modifiedtime}</p>
								</div>
							</a>
						</div>
						<div class="col-md-1 col-2 favorite-btn">
							<button type="button" class="favorite-set" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								<i class="fas fa-ellipsis-h"></i>
							</button>
							<div class="dropdown-menu dropdown-menu-right favorite-dropdown">
								<form method="post"
									action="${pageContext.request.contextPath}/favorite_del.do">
									<input type="hidden" name="contentid" value="${item.contentid}" />
									<input type="hidden" name="userNum"
										value="${login_session_value.getUserNum()}" />
									<button class="dropdown-item" type="submit">즐겨찾기 삭제</button>
								</form>
							</div>
						</div>

					</div>
				</c:forEach>
			</c:otherwise>

		</c:choose>

	</div>



</div>

<script>
	// 개인정보 수정
	$(".myinfochange").hide(function() {
	});
	// With the element initially shown, we can hide it slowly:
	$(".infochange_btn").click(function() {
		$(".myinfo").hide("slow", function() {
		});
		$(".myinfochange").removeClass("hidden").show("slow", function() {
		});
		;
	});
</script>
