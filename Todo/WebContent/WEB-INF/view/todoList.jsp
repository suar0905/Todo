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
		padding-top: 30px;
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
	
	<div class="container">
		<div style="text-align:center;">
			<h2>${todoDate} 일정목록</h2>
			<table class="table table-bordered table-hover" border="1">
				<thead style="background-color: #F5FFFA;">
					<tr class="table-sm">
						<th>일정 날짜</th>
						<th>일정 내용</th>
						<th>중요도</th>
						<th>작성일</th>
						<th>수정일</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${todoList}">
						<tr>
							<td>${t.todoDate}</td>
							<td>${t.todoContent}</td>
							<td>
								<c:choose>
									<c:when test="${t.todoScore == 1}">
										<div>★☆☆☆☆</div>
									</c:when>
									<c:when test="${t.todoScore == 2}">
										<div>★★☆☆☆</div>
									</c:when>
									<c:when test="${t.todoScore == 3}">
										<div>★★★☆☆</div>
									</c:when>
									<c:when test="${t.todoScore == 4}">
										<div>★★★★☆</div>
									</c:when>
									<c:when test="${t.todoScore == 5}">
										<div>★★★★★</div>
									</c:when>
								</c:choose>
							</td>
							<td>${t.createDate}</td>
							<td>${t.updateDate}</td>
							<td><a class="btn btn-outline-success" href="${pageContext.request.contextPath}/member/modifyTodo?todoNo=${t.todoNo}&memberId=${t.memberId}&todoDate=${t.todoDate}&todoContent=${t.todoContent}&todoScore=${t.todoScore}&createDate=${t.createDate}&updateDate=${t.updateDate}">수정</a></td>
							<td><a class="btn btn-outline-success" href="${pageContext.request.contextPath}/member/removeTodo?todoNo=${t.todoNo}&memberId=${t.memberId}&todoDate=${t.todoDate}">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="container">
		<br><hr>
	</div>

	<div class="addPage">
		<div class="container">
			<h2>일정 추가</h2>
			<form id="addForm" method="post" action="${pageContext.request.contextPath}/member/addTodo">
				<table class="table table-bordered" border="1">
					<tr>
						<th>일정 날짜</th>
						<td><input  class="form-control-sm" type="text" name="todoDate" style="text-align:center;" value="${todoDate}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>일정 내용</th>
						<td><textarea  class="form-control" id="todoContent" name="todoContent" rows="5" cols="100" placeholder="내용을 입력해주세요"></textarea></td>
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
				<br>
				<button class="btn btn-danger" type="button" id="addBtn" onclick="button()">추가하기</button>
			</form>
		</div>
	</div>
</body>
</html>