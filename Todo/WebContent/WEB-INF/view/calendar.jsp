<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body >
	<nav class="navbar navbar-expand-sm bg-danger navbar-dark nav justify-content-end">
	  <ul class="navbar-nav">
	    <li class="nav-item active">
	      <a class="nav-link" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	    </li>
	    <li class="nav-item active">
	      <a class="nav-link" href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>
	    </li>
	  </ul>
	</nav>
	<h1 style="text-align:center;">
		${loginMember.memberId}님 반갑습니다
	</h1>
	
	<div>
		<!-- 달력 생성 -->
		<h2 style="text-align:center;">
			<span><a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre"><-이전달</a></span>
			${targetYear}년 ${targetMonth}월
			<span><a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">다음달-></a></span>
		</h2>
		
		<h4> ${targetMonth}월달의 총 일정 개수 : <span class="text-danger">${todoList.size()}</span>개</h4>
		<table class="table table-bordered table-sm" border="1" style="text-align:center;">
			<thead style="background-color: #FFF0F5;">
				<tr>
					<th style="color:red;">일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th style="color:red;">토</th>
				</tr>
			</thead>
			<tbody style="background-color: #FFFAFA;">
				<tr>
					<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1"> <!-- ${startBlank+endDay+endBlank} : 전체 <td>의 개수 -->
						<c:if test="${i-startBlank >= 1 && i-startBlank <= endDay}">
							<td>
								<a href="${pageContext.request.contextPath}/member/todoList?y=${targetYear}&m=${targetMonth}&d=${i-startBlank}">${i-startBlank}</a>
								<div>
									<!-- 날짜별 일정 -->
									<c:forEach var="todo" items="${todoList}">
										<c:if test="${(i-startBlank) == todo.todoDate.substring(8)}"> <!-- todo.todoDate.substring(8)는 2021-10-22이면 22를 의미 -->
											<div style="color:${todo.fontColor};">[${todo.todoContent}]</div>
										</c:if>
									</c:forEach>
								</div>
							</td>
						</c:if>
						
						<c:if test="${i-startBlank < 1 || i-startBlank > endDay}">
							<td>&nbsp;</td> <!-- &nbsp; : 한칸씩 띄운다  -->
						</c:if>
						
						<c:if test="${i%7 == 0 }">
							<tr></tr>
						</c:if>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>