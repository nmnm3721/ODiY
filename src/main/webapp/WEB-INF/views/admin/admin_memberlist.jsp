<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<div class="container">
	<!-- 회원번호 아이디 회원명 생년월일 성별 이메일 가입일 마지막로그인 탈퇴여부 관리자여부 -->
	<table class="table">
		<thead class="thead-dark">
			<tr class='row'>
				<th class="col-1">#</th>
				<th class="col text-truncate">ID</th>
				<th class="col text-truncate">이름</th>
				<th class="col text-truncate">생년월일</th>
				<th class="col text-truncate">성별</th>
				<th class="col text-truncate">이메일</th>
				<th class="col text-truncate">가입일</th>
				<th class="col text-truncate">최종로그인</th>
				<th class="col-1">탈퇴여부</th>
				<th class="col-1">관리자여부</th>
			</tr>
		</thead>
		<tbody>
			<%! int datalength = 89;%>
			<%! int pagenum = datalength/10 + 1; %>
			<% if (datalength>=10) {
		for (int i=0; i<10; i++) { %>
			<tr class='row'>
				<th class="col-1">
					<%=i+1%>
				</th>
				<td class='col text-truncate'>testID</td>
				<td class='col text-truncate'>testNAME</td>
				<td class='col text-truncate'>testBIRTHDAY</td>
				<td class='col text-truncate'>testSEX</td>
				<td class='col text-truncate'>testMAILsssssssssssssssssssssssssssssssssssssssssssssssss</td>
				<td class='col text-truncate'>testJOIN</td>
				<td class='col text-truncate'>testLastLogin</td>
				<td class='col-1'>P</td>
				<td class='col-1'>A</td>
			</tr>
			<%
		}
	} else if (datalength<10 && datalength>0) {
		for (int i=0; i<datalength%10; i++) { %>
			<tr class='row'>
				<th class="col-1">
					<%=i+1%>
				</th>
				<td class='col text-truncate'>testID</td>
				<td class='col text-truncate'>testNAME</td>
				<td class='col text-truncate'>testBIRTHDAY</td>
				<td class='col text-truncate'>testSEX</td>
				<td class='col text-truncate'>testMAIL</td>
				<td class='col text-truncate'>testJOIN</td>
				<td class='col text-truncate'>testLastLogin</td>
				<td class='col-1'>P</td>
				<td class='col-1'>A</td>
			</tr>
			<%
		}
			
		} else { %>
		<tr class='row'>
			<th class="col" colspan="10">
			표시할 내용이 없습니다.
			</th>
		</tr>
		 <%
	} datalength-=10;
	 %>
		</tbody>
	</table>
	<nav>
		<ul class="pagination justify-content-center">
			<li class="page-item"><a href="#" class="page-link" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			<% if (pagenum>10) {
			for (int i=0; i<10; i++) {%>
			<li class="page-item"><a href="#" class="page-link"><%= i+1 %></a></li>
			<% }
			} else if (pagenum<10 && pagenum>0) {
				for (int i=0; i<pagenum%10; i++) { %>
				<li class="page-item"><a href="#" class="page-link"><%=i+1 %></a></li>
				<%	
				}
			}
			%>
			<li class="page-item"><a href="#" class="page-link" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
		</ul>
	</nav>


</div>