package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/addTodo")
public class AddTodoController extends HttpServlet {
	private TodoService todoService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// todoList.jsp에서 값 가져옴
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		String todoDate = request.getParameter("todoDate");
		String todoContent = request.getParameter("todoContent");
		String fontColor = request.getParameter("fontColor");
		int todoScore = Integer.parseInt(request.getParameter("todoScore"));
		
		// 디버깅코드
		System.out.println("[debug] AddTodoController : memberId값 확인 -> " + memberId);
		System.out.println("[debug] AddTodoController : todoDate값 확인 -> " + todoDate);
		System.out.println("[debug] AddTodoController : todoContent값 확인 -> " + todoContent);
		System.out.println("[debug] AddTodoController : fontColor값 확인 -> " + fontColor);
		System.out.println("[debug] AddTodoController : todoScore값 확인 -> " + todoScore);
		
		// Todo 클래스 객체 생성
		Todo todo = new Todo();
		todo.setMemberId(memberId);
		todo.setTodoDate(todoDate);
		todo.setTodoContent(todoContent);
		todo.setFontColor(fontColor);
		todo.setTodoScore(todoScore);
		System.out.println("[debug] AddTodoController : todo값 확인 -> " + todo);
		
		// TodoService 클래스 객체 생성
		todoService = new TodoService();
		
		// addTodo() 메소드가 성공한지, 실패한지 확인하기 위한 변수
		int check = todoService.addTodo(todo);
		
		// 문자열 가져오기(y = 0~3번째 자리 숫자), (m = 5번째방부터 시작 5~6 숫자), (d = 8번째방부터 시작 8~9 숫자)
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);
		System.out.println("[debug] AddTodoController : y값 확인 -> " + y);
		System.out.println("[debug] AddTodoController : m값 확인 -> " + m);
		System.out.println("[debug] AddTodoController : d값 확인 -> " + d);
		
		if(check == 1) { // 입력 성공
			System.out.println("[debug] AddTodoController : 입력 성공!");
			// todoList 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/todoList?y="+y+"&m="+m+"&d="+d);
			return;
		} else { // 입력 실패
			System.out.println("[debug] AddTodoController : 입력 실패!");
			// todoList 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/todoList?y="+y+"&m="+m+"&d="+d);
			return;
		}
	}
}
