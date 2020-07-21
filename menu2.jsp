<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.io.File" %>
	
<%!String isDir = "tomcat/webapps/ROOT";%>
<%!int row = 0;%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">이름</th>
			<th scope="col">유형</th>
		</tr>
	</thead>
	<tbody>
		<% for (File info: new File(isDir).listFiles()) { 
				row++; %>
		<tr>
			<th scope="row"><%=row %></th>
			<%
		if (info.isDirectory()) {
			%>
			<td><a href="<%=info.getName()%>"><%=info.getName()%></a></td>
			<td>폴더</td>
			<%
		} else if (info.isFile()) {
			%>
			<td><a href="<%=info.getName() %>"><%=info.getName() %></a></td>
			<td>파일</td>
			<% } %> </tr> <% } %>
	</tbody>
</table>
