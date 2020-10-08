<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<div>
	<div class="container page-all">
		<div>
			<h2 align="center">회원가입</h2>
			<hr />
		</div>
		<div>
			<!--아이디시작-->
			<form class="join_form" id="join_form" method="post"
				action="${pageContext.request.contextPath}/signup/joins.do">
				<div class="form-group input-email">
					<!--이메일 아이디-->
					<!-- 전 단계에서 전송 받은 userEmail값을 출력만 하는 용도 -->
					<label class="email_label" for="user_email">이메일</label> 
					<input class="form-control email_" name="user_email" id="user_email"
						value="${userEmail}" placeholder="${userEmail}" disabled>
					<!-- 전 단계에서 전송 받은 userEmail값을 가지고 있다가 post한다 -->
					<input type="hidden" class="form-control email_" name="user_email" id="user_email"
						value="${userEmail}" placeholder="${userEmail}">
									
					<!-- 	<input type="text"
					class="birth form-control col-3 num_" name="num_gogo"
						placeholder="인증번호(4자)">
					 <button class="btn btn-primary num_go" type="button">인증번호전송</button>
					<button class="btn btn-primary id_check" type="button">중복검사</button>
					-->

					<!--**아이디 끝-->
				</div>
				<div class="form-group input-pw">
					<!--비밀번호 시작-->
					<label for="user_pw">비밀번호</label> <input type="password"
						id="user_pw" name="user_pw" class="form-control"
						placeholder="비밀번호를 입력해 주세요">
					<!--**비밀번호 끝-->
				</div>
				<div class="form-group input-pw2">
					<!--비밀번호 재확인 시작-->
					<label for="user_pw_re">비밀번호 재확인</label> <input type="password"
						id="user_pw_re" name="user_pw_re" class="form-control"
						placeholder="비밀번호를 한번 더 입력해 주세요">
					<!--**비밀번호 재확인 끝-->
				</div>
				<div class="form-group input-name">
					<!--이름 시작-->
					<label for="user_name">닉네임</label> <input type="text"
						id="user_name" name="user_name" class="form-control"
						placeholder="닉네임을 입력해 주세요">

					<!--**이름 끝-->
				</div>

				<div class="form-group input-birth">
					<!--생년월일 시작-->
					<label for="txtDate">생년월일</label> <input id="datepicker"
						name="txtDate" class="form-control"
						placeholder="클릭하여 캘린더에서 생년월일을 선택해 주세요">
					<!--생년월일 끝-->
				</div>
				<div class="form-group input-seibetu">
					<small id="passwordHelpBlock" class="form-text text-muted">
					</small>
					<button type="submit" id="ok"
						class="btn btn-primary btn-lg btn-block">회원가입</button>
				</div>

			</form>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/assets/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/validate/additional-methods.min.js"></script>

<script>
$(function() {
    $("#datepicker").datepicker({
    	
  // 생년월일 선택 위한 bootstrap datepicker 기능.
  // wbn-datepicker.js 파일 에서 db 입력 형식 맞추기 위환 yy-mm-dd로 출력 작업, 
  // yearRange: "-100:+0"( 연도선택 지난 100년동안의 범위) 및 한글화 작업 진행함월 선택시 ex) 1월 일 경우 01 로 변환하여 전송함. 
  });
});

</script>