package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/todoList")
public class TodoListController extends HttpServlet {
	private TodoService todoService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String y = request.getParameter("y");
		String m = request.getParameter("m");
		String d = request.getParameter("d");
		if(m.length() < 2) { // m의 길이가 2보다 작으면, 즉 한자리이면
			m = "0" + m;
		}
		if(d.length() < 2) { // d의 길이가 2보다 작으면, 즉 한자리이면
			d = "0" + d;
		}
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		String todoDate = y + "-" + m + "-" + d;
		// 디버깅 코드
		System.out.println("[debug] TodoListController : y값 확인 -> " + y);
		System.out.println("[debug] TodoListController : m값 확인 -> " + m);
		System.out.println("[debug] TodoListController : d값 확인 -> " + d);
		System.out.println("[debug] TodoListController : memberId값 확인 -> " + memberId);
		System.out.println("[debug] TodoListController : todoDate값 확인 -> " + todoDate);
		
		// Todo 클래스 객체 생성
		Todo todo = new Todo();
		todo.setMemberId(memberId);
		todo.setTodoDate(todoDate);
		System.out.println("[debug] TodoListController : todo값 확인 -> " + todo);
		
		// TodoService 클래스 객체 생성
		todoService = new TodoService();
		List<Todo> todoList = todoService.getTodoListByDate(todo);
		// todoList.jsp에 지정한(todoList, todoDate) 값들을 보내줌
		request.setAttribute("todoList", todoList);
		request.setAttribute("todoDate", todoDate);
		
		request.getRequestDispatcher("/WEB-INF/view/todoList.jsp").forward(request, response);
	}
}
