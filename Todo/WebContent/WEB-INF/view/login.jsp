<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ // 현재 문서가 준비되면 매개변수로 넣은 콜백 함수를 실행하라는 의미
		$('#loginBtn').click(function(){
			if($('#memberId').val() == '') {
				alert('memberId를 입력하세요');
				return;
			}
			if($('#memberPw').val() == '') {
				alert('memberPw를 입력하세요');
				return;
			}
			
			$('#loginForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>LOGIN</h1>
	<form id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" id="memberId" name="memberId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="memberPw" name="memberPw"></td>
			</tr>
		</table>
		<button type="button" id="loginBtn" onclick="button()">로그인</button>
	</form>
</body>
</html>