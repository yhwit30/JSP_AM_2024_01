<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
int cPage = (int) request.getAttribute("page");
int loginedMemberId = (int) request.getAttribute("loginedMemberId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>

	<h2><%=articleRow.get("id")%>
		번 게시물 수정
	</h2>
	<div>
		번호 :
		<%=articleRow.get("id")%></div>
	<div>
		날짜 :
		<%=articleRow.get("regDate")%>
	</div>
	<form method="POST" action="doModify">
		<input type="hidden" value="<%=loginedMemberId%>" name="loginedMemberId" /> 
		<input type="hidden" value="<%=articleRow.get("id")%>" name="id" /> 
		<input type="hidden" value="<%=cPage%>" name="page" />
		<div>
			제목 : <input type="text" name="title"
				value="<%=articleRow.get("title")%>" />
		</div>
		<div>
			내용 :
			<textarea type="text" name="body"> <%=articleRow.get("body")%></textarea>
		</div>
		<button type="submit">수정</button>
	</form>


	<div>
		<a style="color: green" href="list?page=<%=cPage%>">목록으로 돌아가기</a>
	</div>
</body>
</html>

