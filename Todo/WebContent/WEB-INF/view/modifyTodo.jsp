<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 수정 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#modifyBtn').click(function(){
			if($('#todoContent').val() == '') {
				alert('todoContent를 입력하세요');
				return;
			}
			
			$('#modifyForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>수정전 일정</h1>
	<table border="1">
		<tr>
			<th>todoDate</th>
			<th>todoContent</th>
			<th>createDate</th>
			<th>updateDate</th>
		</tr>
		<tr>
			<td>${todoDate}</td>
			<td>${todoContent}</td>
			<td>${createDate}</td>
			<td>${updateDate}</td>
		</tr>
	</table>
	
	<h1>일정 수정하기</h1>
	<form id="modifyForm" method="post" action="${pageContext.request.contextPath}/member/modifyTodo">
		<input type="hidden" name="todoNo" value="${todoNo}">
		<input type="hidden" name="memberId" value="${memberId}">
		<table border="1">
			<tr>
				<th>todoDate</th>
				<td><input type="text" name="todoDate" value="${todoDate}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>todoContent</th>
				<td><textarea id="todoContent" name="todoContent" rows="5" cols="100" placeholder="Enter todoContent"></textarea></td>
			</tr>	
		</table>
		<button type="button" id="modifyBtn" onclick="button()">수정하기</button>
	</form>
</body>
</html>