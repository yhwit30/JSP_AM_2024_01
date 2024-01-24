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
		<a href="../test">testing</a>
	</div>

	<br>

	<div>
		<a href="../home/main">메인으로 이동</a>
	</div>
	<div>
		<a href="write">글쓰기</a>
	</div>


	<h2>게시물 목록</h2>

	<table class="table"
		style="border-collapse: collapse; border-color: green" border="1px">
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
				<td><a
					href="detail?id=<%=articleRow.get("id")%>&page=<%=cPage%>"><%=articleRow.get("title")%></a></td>
				<td><a
					href="modify?id=<%=articleRow.get("id")%>&page=<%=cPage%>">수정</a></td>
				<td><a
					href="delete?id=<%=articleRow.get("id")%>&page=<%=cPage%>">del</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<div class="page">
		<%
		int pageWide = 3; //페이지 보여줄 좌우 각 범위

		if (cPage > 1) {
		%>
		<a href="list?page=1">맨앞</a> &nbsp; &nbsp;
		<%
		}

		if (cPage > (pageWide + 1)) {
		%>
		<a href="list?page=<%=cPage - (pageWide + 1)%>">◀</a>
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
		<a href="list?page=<%=cPage + (pageWide + 1)%>">▶</a>
		<%
		}

		if (cPage < totalPage) {
		%>
		&nbsp;&nbsp;<a href="list?page=<%=totalPage%>">맨뒤</a>
		<%
		}
		%>
	</div>

	<div class="page page2">
		<%
		int pageSize = 10;
		int from = ((cPage - 1) / pageSize) * pageSize + 1;
		int end = from + pageSize - 1;
		if (end > totalPage) {
			end = totalPage;
		}

		if (cPage > 1) {
		%>
		<a href="list?page=1">맨앞</a> &nbsp; &nbsp;
		<%
		}

		if (from > pageSize) {
		%>
		<a href="list?page=<%=from - pageSize%>">◀</a>
		<%
		}

		for (int i = from; i <= end; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}

		if (end < totalPage) {
		%>
		<a href="list?page=<%=from + pageSize%>">▶</a>
		<%
		}

		if (cPage < totalPage) {
		%>
		&nbsp;&nbsp;<a href="list?page=<%=totalPage%>">맨뒤</a>
		<%
		}
		%>


	</div>


	<style type="text/css">
h2 {
	text-align: center;
}

.table {
	margin-left: auto;
	margin-right: auto;
}

.page {
	font-size: 1rem;
	text-align: center;
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


</body>
</html>

