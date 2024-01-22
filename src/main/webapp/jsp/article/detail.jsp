<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세</title>
</head>
<body>

	<h2>게시물 상세</h2>

	<ul>
		<li>번호 : <%=articleRow.get("id")%>번
		</li>
		<li>날짜 : <%=articleRow.get("regDate")%>
		</li>
		<li>제목 : <%=articleRow.get("title")%>
		</li>
		<li>내용 : <%=articleRow.get("body")%>
		</li>
	</ul>

</body>
</html>


