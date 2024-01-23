<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
int totalPage = (int) request.getAttribute("totalPage");
int cPage = (int) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>게시물 목록</title>
</head>
<body>

	<a href="../home/main">메인으로 이동</a>

	<h2>게시물 목록</h2>

	<table style="border-collapse: collapse" ; border="3px">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성날짜</th>
				<th>제목</th>
				<th>디테일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Map<String, Object> articleRow : articleRows) {
			%>

			<tr style="text-align: center;">
				<td><%=articleRow.get("id")%>번</td>
				<td><%=articleRow.get("regDate")%></td>
				<td><%=articleRow.get("title")%></td>
				<td><a href="detail?id=<%=articleRow.get("id")%>">디테일</a></td>
				<td><a href="delete?id=<%=articleRow.get("id")%>">글 삭제</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<div class="page">
		<%
		for (int i = 1; i <= totalPage; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : "" %>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		%>
	</div>

	<style type="text/css">
.page {
	font-size: 1.4rem;
}

.page>a {
	color: black;
	text-decoration: none;
}

.page>a.cPage {
	color: red;
	text-decoration: underline;
}
</style>



</body>
</html>