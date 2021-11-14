<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 목록 상세보기</title>
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
	<h1><a href="${pageContext.request.contextPath}/member/calendar">달력보기</a></h1>
	<h1>${todoDate} Todo List</h1>
	<table border="1">
		<thead>
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
					<td><a href="${pageContext.request.contextPath}/member/modifyTodo?todoNo=${t.todoNo}&memberId=${t.memberId}&todoDate=${t.todoDate}&todoContent=${t.todoContent}&createDate=${t.createDate}&updateDate=${t.updateDate}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/member/removeTodo?todoNo=${t.todoNo}&memberId=${t.memberId}&todoDate=${t.todoDate}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>일정 추가</h1>
	<form id="addForm" method="post" action="${pageContext.request.contextPath}/member/addTodo">
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
		<button type="button" id="addBtn" onclick="button()">추가하기</button>
	</form>
	
</body>
</html>