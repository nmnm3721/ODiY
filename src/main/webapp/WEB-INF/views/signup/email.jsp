
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
			
				action="auth.do">
				<div class="row form-group input-email">
					<!--이메일 시작-->
					<!--새롭게-->
					<label class="email_label" for="to">이메일</label> <input
						type="email" class="form-control email_" name="userEmail" id="to"
						placeholder="ODiY@example.com">
					<!-- 이메일 중복검사 + 인증번호 전송 -->
					<input type="submit" name="submit" class="btn btn-primary varification_send" type="button" value="인증번호전송"/>

					<!--**아이디 끝-->
				</div>
			</form>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/assets/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/validate/additional-methods.min.js"></script>
<script src="//cdn.ckeditor.com/4.12.1/basic/ckeditor.js"></script>
<script>
// 중복검사+ 이메일인증 버튼 Jquery 기능 (삭제)
//	$(".id_check").click(function() {
//		var userEmail = $('input[name=userEmail]').val();
//		$(".id_check").hide("slow", function() {
//		});
//		$(".varification_send").removeClass("hidden").show("slow", function() {
//		});
//		;
//	});
</script>
<!--**이메일 인증 끝-->