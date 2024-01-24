<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>welcome to register page~! 둥글게 둥글게 짝 손뼉을 치면서 짝</h2>


	<form action="doRegister">
		<div>
			아이디 : <input type="text" name="loginId" />
		</div>
		<div>
			비밀번호 :
			<input type="text" name="loginPw">
		</div>
		<div>
			비밀번호 확인 :
			<input type="text" name="loginPwConfirm">
		</div>
		<div>
			이름 :
			<input type="text" name="name">
		</div>
		<button type="submit">회원가입</button>
	</form>




	<div>
		<a style="color: green" href="../article/list">리스트로 돌아가기</a>
	</div>

</body>
</html>