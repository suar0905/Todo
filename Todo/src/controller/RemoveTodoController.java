package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Todo;

@WebServlet("/member/removeTodo")
public class RemoveTodoController extends HttpServlet {
	private TodoService todoService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// todoList.jsp에서 값 가져옴
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String memberId = request.getParameter("memberId");
		String todoDate = request.getParameter("todoDate");
		// 디버깅 코드
		System.out.println("[debug] RemoveTodoController : todoNo 확인 -> " + todoNo);
		System.out.println("[debug] RemoveTodoController : memberId 확인 -> " + memberId);
		System.out.println("[debug] RemoveTodoController : todoDate 확인 -> " + todoDate);
		
		// TodoService 클래스 객체 생성
		todoService = new TodoService();
		
		// Todo 클래스 객체 생성
		Todo todo = new Todo();
		todo.setTodoNo(todoNo);
		todo.setMemberId(memberId);
		System.out.println("[debug] RemoveTodoController : todo 확인 -> " + todo);
		
		// removeTodo() 메소드가 성공한지, 실패한지 확인하기 위한 변수
		int check = todoService.removeTodo(todo);
		
		// 문자열 가져오기(y = 0~3번째 자리 숫자), (m = 5번째방부터 시작 5~6 숫자), (d = 8번째방부터 시작 8~9 숫자)
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);
		System.out.println("[debug] RemoveTodoController : y값 -> " + y);
		System.out.println("[debug] RemoveTodoController : m값 -> " + m);
		System.out.println("[debug] RemoveTodoController : d값 -> " + d);
		
		if(check == 1) { // 삭제 성공
			System.out.println("[debug] RemoveTodoController : 삭제 성공!");
			// todoList 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/todoList?y="+y+"&m="+m+"&d="+d);
			return;
		} else { // 삭제 실패
			System.out.println("[debug] RemoveTodoController : 삭제 실패!");
			// todoList 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/todoList?y="+y+"&m="+m+"&d="+d);
			return;
		}
	}

}
