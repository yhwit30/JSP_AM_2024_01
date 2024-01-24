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

	<h2>hi, this is test.jsp</h2>
	<h2>안녕, 테스트서블릿에 온 걸 환영~</h2>
	<h3>이 페이지는 하나의 서블릿과 하나의 jsp만 연결하고 서블릿의 함수만으로 여러 다른 jsp데이터를 주고받을 수 있는지 확인하기 위해서 만들었어. 되기는 함.</h3>
	<div>제목, 내용을 작성하고 '작성' 누르면 DB 테이블 article에 데이터 생성할거야 </div>
	
	<br>

	<form action="test">
		<div>
			제목 : <input type="text" placeholder="제목을 입력해주세요" name="title" />
		</div>
		<div>
			내용 :
			<textarea type="text" placeholder="내용을 입력해주세요" name="body"></textarea>
		</div>
		<button type="submit">작성</button>
	</form>

	<a href="home/main">go to main</a>

</body>
</html>