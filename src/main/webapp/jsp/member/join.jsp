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

<!-- <a href="https://www.naver.com" onclick="if(confirm('진짜 네이버로 이동??')==false) return false">네이버(시험버튼)</a> -->

<script type="text/javascript">
		function JoinForm_submit(form){
			form.loginId.value = form.loginId.value.trim();
			
			if(form.loginId.value.length == 0){
				alert('아이디를 입력해주세요');
				form.loginId.focus();
				return;
			}
			if(form.loginPw.value.length == 0){
				alert('비밀번호를 입력해주세요');
				form.loginId.focus();
				return;
			}
			if(form.loginPwConfirm.value.length == 0){
				alert('비밀번호 확인을 입력해주세요');
				form.loginId.focus();
				return;
			}
			if(form.name.value.length == 0){
				alert('이름을 입력해주세요');
				form.loginId.focus();
				return;
			}
		}
</script>



	<form action="doJoin" onsubmit="JoinForm_submit(this); return false">
		<div>
			아이디 : <input autocomplete="off" type="text" placeholder="아이디 입력" name="loginId" />
		</div>
		<div>
			비밀번호 :
			<input autocomplete="off"  type="text" placeholder="비밀번호 입력" name="loginPw"/>
		</div>
		<div>
			비밀번호 확인 :
			<input autocomplete="off"  type="text" placeholder="비밀번호 확인 입력" name="loginPwConfirm"/>
		</div>
		<div>
			이름 :
			<input autocomplete="off"  type="text" placeholder="이름 입력" name="name"/>
		</div>
		<button type="submit">회원가입</button>
	</form>




	<div>
		<a style="color: green" href="../home/main">메인으로 돌아가기</a>
	</div>

</body>
</html>