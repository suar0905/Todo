<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 목록 상세보기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
	.addPage {
		padding-top: 100px;
		text-align: center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addBtn').click(function(){
			if($('#todoContent').val() == '') {
				alert('내용을 입력하세요');
				return;
			}
			
			$('#addForm').submit();
		});
	});
</script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-danger navbar-dark nav justify-content-end">
	  <ul class="navbar-nav">
	    <li class="nav-item active">
	      <a class="nav-link" href="${pageContext.request.contextPath}/member/calendar">일정표</a>
	    </li>
	  </ul>
	</nav>
	
	<div style="text-align:center;">
		<h1>${todoDate} 일정목록</h1>
		<table class="table table-bordered table-hover" border="1">
			<thead style="background-color: #F5FFFA;">
				<tr>
					<th>todoDate</th>
					<th>todoContent</th>
					<th>createDate</th>
					<th>updateDate</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${todoList}">
					<tr>
						<td>${t.todoDate}</td>
						<td>${t.todoContent}</td>
						<td>${t.createDate}</td>
						<td>${t.updateDate}</td>
						<td><a class="btn btn-outline-success" href="${pageContext.request.contextPath}/member/modifyTodo?todoNo=${t.todoNo}&memberId=${t.memberId}&todoDate=${t.todoDate}&todoContent=${t.todoContent}&createDate=${t.createDate}&updateDate=${t.updateDate}">수정</a></td>
						<td><a class="btn btn-outline-success" href="${pageContext.request.contextPath}/member/removeTodo?todoNo=${t.todoNo}&memberId=${t.memberId}&todoDate=${t.todoDate}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="addPage">
		<h1>일정 추가</h1>
		<form id="addForm" method="post" action="${pageContext.request.contextPath}/member/addTodo">
			<table style="margin-left: auto; margin-right: auto;" border="1">
				<tr>
					<th>todoDate</th>
					<td><input  class="btn btn-outline-secondary type="text" name="todoDate" value="${todoDate}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>todoContent</th>
					<td><textarea  class="btn btn-outline-secondary id="todoContent" name="todoContent" rows="5" cols="100" placeholder="Enter todoContent"></textarea></td>
				</tr>
				<tr>
					<th>fontColor</th>
					<td><input class="btn btn-light" type="color" id="fontColor" name="fontColor"></td>
				</tr>
			</table>
			<br>
			<button class="btn btn-outline-secondary" type="button" id="addBtn" onclick="button()">추가하기</button>
		</form>
	</div>
</body>
</html>