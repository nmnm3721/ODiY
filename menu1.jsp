<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.io.File"%>
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
		<%
			for (File info : new File(isDir).listFiles()) {
			row++;
		%>
		<tr>
			<th scope="row"><%=row%></th>
			<%
				if (info.isDirectory()) {
			%>
			<td><%=info.getName()%></td>
			<td>폴더</td>
		</tr>
		<%
			String isDir2 = "tomcat/webapps/ROOT/" + info.getName();
		for (File info2 : new File(isDir2).listFiles()) {
		%>
		<tr>
			<th scope="row">》》</th>
			<%
				if (info2.isDirectory()) {
			%>
			<td><%=info2.getName()%></td>
			<td>폴더 내 폴더</td>
			<%
				} else if (info2.isFile()) {
			%>
			<td><a href="<%=info.getName() + "/" + info2.getName()%>"><%=info.getName() + "/" + info2.getName()%></a></td>
			<td>폴더 내 파일</td>
			<%
				}
			%>
		</tr>
		<%
			}
		} else if (info.isFile()) {
		%>
		<td><a href="<%=info.getName()%>"><%=info.getName()%></a></td>
		<td>파일</td>
		</tr>
		<%
			}
		%>
		
		<%
			} row=0;
		%>
	</tbody>
</table>
