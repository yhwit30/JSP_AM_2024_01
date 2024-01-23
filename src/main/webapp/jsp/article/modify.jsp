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
<title>게시물 수정</title>
</head>
<body>

	<h2><%=articleRow.get("id") %> 번 게시물 수정</h2>
	
	<form method="POST" action="doModify">
	<input type="hidden" value="<%=articleRow.get("id") %>" name="id"/>
		<div>
			제목 : <input type="text"  name="title" value="<%=articleRow.get("title")%>"/>
		</div>
		<div>
			내용 :
			<textarea type="text" name="body"> <%=articleRow.get("body")%></textarea>
		</div>
		<button type="submit">작성</button>
	</form>


	<div>
		<a style="color: green" href="list">목록으로 돌아가기</a>
	</div>
</body>
</html>

