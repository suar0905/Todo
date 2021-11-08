<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addBtn').click(function(){
			if($('#memberId').val() == '') {
				alert('아이디를 입력하세요');
				return;
			}
			if($('#memberPw').val() == '') {
				alert('비밀번호를 입력하세요');
				return;
			}
			
			$('#addForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form id="addForm" method="post" action="${pageContext.request.contextPath}/addMember">
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
		<div>
			<button type="button" id="addBtn" onclick="button()">회원가입</button>
			<button type="reset">초기화</button>
			<a href="${pageContext.request.contextPath}/login">로그인</a>
		</div>
	</form>
</body>
</html>