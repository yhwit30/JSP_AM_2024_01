<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>게시물 목록</title>
</head>
<body>

<a href="../home/main">메인으로 이동</a>

<a href="detail" target="_blank">디테일 시험버튼</a>

	<h2>게시물 목록 v4</h2>

	<ul>
		<%
		for (Map<String, Object> articleRow : articleRows) {
		%>
		<li><%=articleRow.get("id")%>번,<%=articleRow.get("regDate")%>,<%=articleRow.get("title")%>,<%=articleRow.get("body")%></li>
		<a href="detail?id=<%=articleRow.get("id")%>" target="_blank">디테일</a>
		<%
		}
		%>
	</ul>

	<h2>게시물 목록 v3</h2>

	<ul>
		<%
		for (int i = 0; i < articleRows.size(); i++) {
		%>
		<li><%=articleRows.get(i).get("id")%>번, <%=articleRows.get(i).get("regDate")%>,<%=articleRows.get(i).get("title")%>,<%=articleRows.get(i).get("body")%></li>
		<%
		}
		%>
	</ul>

</body>
</html>