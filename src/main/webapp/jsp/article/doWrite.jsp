<%-- <%@ page import="java.util.List"%> --%>
<%-- <%@ page import="java.util.Map"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int lastId = (int) request.getAttribute("lastId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>게시물 작성</title>
</head>
<body>

	<form action="doWrite">
		<div>제목 :</div>
		<div>
			<input type="text" name="title">
		</div>
		<div>내용 :</div>
		<div>
			<input type="text" name="body" placeholder="내용을 입력하세요!"
				style="width: 300px; height: 200px; font-size: 20px;">
		</div>

		<input type="submit" value="submit"/> 
	</form>


	<a href="list">목록으로 이동</a>
	<%-- <h2><%=lastId %> 번 게시물이 생성되었습니다.</h2> --%>

<%-- 	<script>alert('<%=lastId%>번 글이 생성되었습니다.');location.replace('/article/list');</script> --%>


</body>
</html>