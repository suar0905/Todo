<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 수정 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
	.modifyPage {
		padding-top: 30px;
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
	
	<div class="container">
		<div style="text-align:center;">
			<h2>수정 전 일정정보</h2>
			<table class="table table-bordered" border="1">
				<tr style="background-color: #F5FFFA;">
					<th>일정날짜</th>
					<th>일정내용</th>
					<th>중요도</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
				<tr>
					<td>${todoDate}</td>
					<td>${todoContent}</td>
					<td>
						<c:choose>
							<c:when test="${todoScore == 1}">
								<div>★☆☆☆☆</div>
							</c:when>
							<c:when test="${todoScore == 2}">
								<div>★★☆☆☆</div>
							</c:when>
							<c:when test="${todoScore == 3}">
								<div>★★★☆☆</div>
							</c:when>
							<c:when test="${todoScore == 4}">
								<div>★★★★☆</div>
							</c:when>
							<c:when test="${todoScore == 5}">
								<div>★★★★★</div>
							</c:when>
						</c:choose>	
					</td>
					<td>${createDate}</td>
					<td>${updateDate}</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="container">
		<br><hr>
	</div>
	
	<div class="modifyPage">
		<div class="container">
			<h2>일정 수정</h2>
			<form id="modifyForm" method="post" action="${pageContext.request.contextPath}/member/modifyTodo">
				<input type="hidden" name="todoNo" value="${todoNo}">
				<input type="hidden" name="memberId" value="${memberId}">
				<table class="table table-bordered" border="1">
					<tr>
						<th>일정 날짜</th>
						<td><input class="form-control-sm" type="text" name="todoDate" value="${todoDate}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>일정 내용</th>
						<td><textarea class="form-control" id="todoContent" name="todoContent" rows="5" cols="100" placeholder="수정할 내용을 입력해주세요"></textarea></td>
					</tr>
					<tr>
						<th>중요도</th>
						<td>
							<select name="todoScore" class="form-control-sm">
								<option value="1">★☆☆☆☆</option>
								<option value="2">★★☆☆☆</option>
								<option value="3">★★★☆☆</option>
								<option value="4">★★★★☆</option>
								<option value="5">★★★★★</option>
							</select>
						</td>
					</tr>	
					<tr>
						<th>글자 색상</th>
						<td><input class="form-control-sm" type="color" id="fontColor" name="fontColor"></td>
					</tr>
				</table>
				<button class="btn btn-danger" type="button" id="modifyBtn" onclick="button()">수정하기</button>
			</form>
		</div>
	</div>
</body>
</html>