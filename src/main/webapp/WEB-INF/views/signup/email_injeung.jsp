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
			<form action="join_injeung.do${dice}" method="post"> <!-- 받아온 인증코드를 컨트롤러로 넘겨서 일치하는지 확인 -->   
				<div class="row form-group input-email">
					<!-- email.jsp에서 입력한 이메일 값 출력 -->
					<!--이메일 인증번호 입력 -->
					<input type="text" class="hidden" name="userEmail" value="${userEmail}" placeholder="${userEmail}"/> 
					<label for="email_injeung">${userEmail} 로 발송된 인증번호를 입력해주세요.</label> 
					<input type="number" class="form-control email_" name="email_injeung" id="to"
						placeholder="인증번호를 입력하세요.">

		
					<!-- 인증번호 확인 -->
					<input type="submit" name="submit" class="btn btn-primary varification_send" type="button" value="확인"/>
					
					<!--**아이디 끝-->
				</div>
			</form>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/assets/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/validate/additional-methods.min.js"></script>
<script src="//cdn.ckeditor.com/4.12.1/basic/ckeditor.js"></script>

<!--**이메일 인증 끝-->