<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
int cPage = (int) request.getAttribute("page");
int totalPage = (int) request.getAttribute("totalPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>게시물 목록</title>
</head>
<body>
	<div>
		<a href="../home/main">메인으로 이동</a>
	</div>
	<div>
		<a href="write">글쓰기</a>
	</div>


	<h2>게시물 목록</h2>

	<table style="border-collapse: collapse; border-color: green"
		border="1px">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성날짜</th>
				<th>제목</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Map<String, Object> articleRow : articleRows) {
			%>
			<tr style="text-align: center;">
				<td><%=articleRow.get("id")%></td>
				<td><%=articleRow.get("regDate")%></td>
				<td><a href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a></td>
				<td><a href="modify?id=<%=articleRow.get("id")%>">수정</a></td>
				<td><a href="doDelete?id=<%=articleRow.get("id")%>">del</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<style type="text/css">
.page {
	font-size: 1rem;
}

.page>a {
	color: black;
	text-decoration: none;
}

.page>a.cPage {
	color: red;
	text-decoration: underline;
	font-size: 1.2rem;
}
</style>

	<div class="page">
		<%
		int pageWide = 3; //페이지 보여줄 좌우 각 범위
		
		if (cPage > 1) {
		%>
		<a href="list?page=1">맨앞</a> &nbsp; &nbsp;
		<%
		}
		
		if (cPage > (pageWide+1)) {
			%>
			<a href="list?page=<%=cPage - (pageWide+1) %>">◀</a> 
			<%
			}
		

		if (cPage > 0 && cPage <= pageWide) {
		for (int i = 1; i <= 6; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		} else if (cPage > pageWide && cPage <= totalPage - pageWide) {
		for (int i = cPage - pageWide; i <= cPage + pageWide; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		} else if (cPage > totalPage - pageWide) {
		for (int i = totalPage - pageWide; i <= totalPage; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		}
		
		if (cPage < totalPage - pageWide) {
			%>
			<a href="list?page=<%=cPage + (pageWide+1) %>">▶</a> 
			<%
			}

		
		if (cPage < totalPage) {
		%>
		 &nbsp;&nbsp;<a href="list?page=<%=totalPage%>">맨뒤</a>
		<%
		}
		%>
	</div>

</body>
</html>

