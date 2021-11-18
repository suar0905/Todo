<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 수정 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
	.modifyPage {
		padding-top: 100px;
		text-align: center;
	}
</style>
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
	<nav class="navbar navbar-expand-sm bg-danger navbar-dark nav justify-content-end">
	  <ul class="navbar-nav">
	    <li class="nav-item active">
	      <a class="nav-link" href="${pageContext.request.contextPath}/member/todoList?y=${y}&m=${m}&d=${d}">일정목록</a>
	    </li>
	    <li class="nav-item active">
	      <a class="nav-link" href="${pageContext.request.contextPath}/member/calendar">일정표</a>
	    </li>
	  </ul>
	</nav>
	
	<div style="text-align:center;">
		<h1>수정전 일정</h1>
		<table class="table table-bordered" border="1">
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
	</div>
	
	<div class="modifyPage">
		<h1>일정 수정</h1>
		<form id="modifyForm" method="post" action="${pageContext.request.contextPath}/member/modifyTodo">
			<input type="hidden" name="todoNo" value="${todoNo}">
			<input type="hidden" name="memberId" value="${memberId}">
			<table style="margin-left: auto; margin-right: auto;" border="1">
				<tr>
					<th>todoDate</th>
					<td><input class="btn btn-outline-secondary" type="text" name="todoDate" value="${todoDate}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>todoContent</th>
					<td><textarea class="btn btn-outline-secondary" id="todoContent" name="todoContent" rows="5" cols="100" placeholder="Enter todoContent"></textarea></td>
				</tr>	
				<tr>
					<th>fontColor</th>
					<td><input class="btn btn-light" type="color" id="fontColor" name="fontColor"></td>
				</tr>
			</table>
			<button class="btn btn-outline-secondary" type="button" id="modifyBtn" onclick="button()">수정하기</button>
		</form>
	</div>
</body>
</html>