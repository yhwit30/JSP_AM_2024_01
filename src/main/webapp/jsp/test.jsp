<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>hello this is test.jsp</h2>


<form method="POST" action="test">
		<div>
			제목 : <input type="text" placeholder="제목을 입력해주세요" name="title" />
		</div>
		<div>
			내용 :
			<textarea type="text" placeholder="내용을 입력해주세요" name="body"></textarea>
		</div>
		<button type="submit">작성</button>
	</form>
	

</body>
</html>