<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- ************************************************* -->
<main>
	<div class="container">

		<c:choose>

			<c:when test="${empty output}">
				<h2
					style="font-family: 메이플스토리2; text-align: center; margin-top: 300px; margin-bottom: 300px;">조회결과가
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

					<div class="smain row">
						<div class="col-md-1 col-0"></div>
						<div class="col-md-8 col-10">
							<a href="${detailURL}">
								<div class="left">
									<div class="box">
										<c:choose>
											<c:when test="${empty item.firstimage2}">
												<img
													src="https://via.placeholder.com/180x150/CCC/222/?text=No Image" />
											</c:when>
											<c:otherwise>
												<img src="${item.firstimage2}" />
											</c:otherwise>
										</c:choose>
									</div>
									<h4>${item.title}</h4>
									<br />
									<p>#위치 : ${item.addr1}</p>
									<p>등록일 : ${item.createdtime} / 최근 수정일 :
										${item.modifiedtime}</p>
								</div>
							</a>
						</div>
						<div class="col-md-2 col-2">
							<div class="right">
								<!--체크박스디자인-->
								<form class="favorite" method="post"
									action="${pageContext.request.contextPath}/favorite_add.do">
									<input type="hidden" name="pagename" value="search" />
									<input type="hidden" name="contentid" value="${item.contentid}" />
									<input type="hidden" name="keyword" value="${keyword}" />
									<input type="hidden" name="userNum" value="${login_session_value.getUserNum()}" />
									<button type="submit" class="btn btn-primary"
										style="font-family: 메이플스토리2;">
										<i class="fas fa-star"></i> <span>즐겨찾기 추가</span>
									</button>
								</form>
								<!--체크박스디자인끝-->
							</div>
						</div>
						<div class="col-md-1 col-0"></div>
					</div>
				</c:forEach>
			</c:otherwise>

		</c:choose>


	</div>

	<div class="container page-numbering">
		<!-- 페이지 번호 구현 -->
		<%-- 이전 그룹에 대한 링크 --%>
		<c:choose>
			<%-- 이전 그룹으로 이동 가능하다면? --%>
			<c:when test="${pageData.prevPage > 0}">
				<%-- 이동할 URL 생성 --%>
				<c:url value="/search/search.do" var="prevPageUrl">
					<c:param name="page" value="${pageData.prevPage}"></c:param>
					<c:param name="keyword" value="${keyword}"></c:param>
					<c:param name="tour_eat_zzz" value="${tour_eat_zzz}"></c:param>
					<c:param name="detail_desc" value="${detail_desc}"></c:param>
				</c:url>
				<a href="${prevPageUrl}">[이전]</a>
			</c:when>

			<c:otherwise>
			[이전]
		</c:otherwise>

		</c:choose>


		<%-- 페이지 번호 (시작 페이지부터 끝 페이지까지 반복) --%>
		<c:forEach var="i" begin="${pageData.startPage}"
			end="${pageData.endPage}" varStatus="status">
			<%-- 이동할 URL 생성 --%>
			<c:url value="/search/search.do" var="pageUrl">
				<c:param name="page" value="${i}"></c:param>
				<c:param name="keyword" value="${keyword}"></c:param>
				<c:param name="tour_eat_zzz" value="${tour_eat_zzz}"></c:param>
				<c:param name="detail_desc" value="${detail_desc}"></c:param>
			</c:url>

			<%-- 페이지 번호 출력 --%>
			<c:choose>
				<%-- 현재 머물고 있는 페이지 번호를 출력할 경우 링크 적용 안함 --%>
				<c:when test="${pageData.nowPage == i}">
					<strong>[${i}]</strong>
				</c:when>
				<%-- 나머지 페이지의 경우 링크 적용함 --%>
				<c:otherwise>
					<a href="${pageUrl}">[${i}]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>


		<%-- 다음 그룹에 대한 링크 --%>
		<c:choose>
			<%-- 다음 그룹으로 이동 가능하다면? --%>
			<c:when test="${pageData.nextPage > 0}">
				<%-- 이동할 URL 생성 --%>
				<c:url value="/search/search.do" var="nextPageUrl">
					<c:param name="page" value="${pageData.nextPage}"></c:param>
					<c:param name="keyword" value="${keyword}"></c:param>
					<c:param name="tour_eat_zzz" value="${tour_eat_zzz}"></c:param>
					<c:param name="detail_desc" value="${detail_desc}"></c:param>
				</c:url>
				<a href="${nextPageUrl}">[다음]</a>
			</c:when>

			<c:otherwise>
			[다음]
		</c:otherwise>

		</c:choose>


	</div>




</main>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
	
</script>

<!-- ********************************************************** -->