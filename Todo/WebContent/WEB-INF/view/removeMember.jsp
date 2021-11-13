<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ // 현재 문서가 준비되면 매개변수로 넣은 콜백 함수를 실행하라는 의미
		$('#deleteBtn').click(function(){
			if($('#memberPw').val() == '') {
				alert('memberPw를 입력하세요');
				return;
			}
			
			$('#deleteForm').submit();
		});
	});
</script>
</head>
<body>
	<div>
		<h1>회원탈퇴</h1>
		<h5>회원탈퇴를 위한 비밀번호를 입력해주세요</h5><br>
		<form id="deleteForm" method="post" action="${pageContext.request.contextPath}/member/removeMember">
			<table border="1">
				<tr>
					<th>회원 아이디</th>
					<td><input type ="text" name="memberId" value="${loginMember.memberId}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원 비밀번호</th>
					<td><input type="password" id="memberPw" name="memberPw"></td>
				</tr>
			</table>
			<div>
				<button type="button" id="deleteBtn" onclick="button()">회원탈퇴</button>
				<a href="${pageContext.request.contextPath}/member/calendar">달력보기</a>
			</div>
		</form>
	</div>
</body>
</html>