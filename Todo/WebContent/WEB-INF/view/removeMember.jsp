<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
	.deletePage {
		padding-top: 100px;
		text-align: center;
	}
</style>
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
<body style="background-color:#FFFAFA">
	<nav class="navbar navbar-expand-sm bg-danger navbar-dark nav justify-content-end">
	  <ul class="navbar-nav">
	    <li class="nav-item active">
	      <a class="nav-link" href="${pageContext.request.contextPath}/member/calendar">일정표</a>
	    </li>
	  </ul>
	</nav>
	
	<div class="deletePage">
		<h1>회원탈퇴</h1>
		<h5 style="color:red;">회원탈퇴를 위한 비밀번호를 입력해주세요</h5><br>
		<form id="deleteForm" method="post" action="${pageContext.request.contextPath}/member/removeMember">
			<table style="margin-left: auto; margin-right: auto;" border="1" width="500px" height="100px">
				<tr>
					<th>회원 아이디</th>
					<td><input class="btn btn-outline-dark text-dark" type ="text" name="memberId" value="${loginMember.memberId}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원 비밀번호</th>
					<td><input class="btn btn-outline-dark text-dark" type="password" id="memberPw" name="memberPw"></td>
				</tr>
			</table>
			<br>
			<button class="btn btn-outline-secondary" type="button" id="deleteBtn" onclick="button()">회원탈퇴</button>
		</form>
	</div>
</body>
</html>