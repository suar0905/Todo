<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력 페이지</title>
</head>
<body>
	<h1>
		${loginMember.memberId}님 반갑습니다
		<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
		<a href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>
	</h1>
	
	<div>
		<!-- 달력 생성 -->
		<h1>
			${targetYear}년 ${targetMonth}월
			<span><a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre">▼</a></span>
			<span><a href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">▲</a></span>
		</h1>
		
		<h3> ${targetMonth}월달의 총 일정 개수 : ${todoList.size()}개</h3>
		<table border="3">
			<tr>
				<td>일</td><td>월</td><td>화</td><td>수</td><td>목</td><td>금</td><td>토</td>
			</tr>
			<tr>
				<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1"> <!-- ${startBlank+endDay+endBlank} : 전체 <td>의 개수 -->
					<c:if test="${i-startBlank >= 1 && i-startBlank <= endDay}">
						<td>
							<a href="${pageContext.request.contextPath}/member/todoList?y=${targetYear}&m=${targetMonth}&d=${i-startBlank}">${i-startBlank}</a>
							<div>
								<!-- 날짜별 일정 -->
								<c:forEach var="todo" items="${todoList}">
									<c:if test="${(i-startBlank) == todo.todoDate.substring(8)}"> <!-- todo.todoDate.substring(8)는 2021-10-22이면 22를 의미 -->
										<div>${todo.todoContent}</div>
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
		</table>
	</div>
</body>
</html>