package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Todo;

@WebServlet("/member/modifyTodo")
public class ModifyTodoController extends HttpServlet {
	private TodoService todoService;
	
	// 일정 수정 페이지
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// modifyTodo.jsp에서 사용할 데이터
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String memberId = request.getParameter("memberId");
		String todoDate = request.getParameter("todoDate");
		String todoContent = request.getParameter("todoContent");
		String createDate = request.getParameter("createDate");
		String updateDate = request.getParameter("updateDate");
		
		// 디버깅 코드
		System.out.println("[debug] ModifyTodoController(doGet) : todoNo 확인 -> " + todoNo);
		System.out.println("[debug] ModifyTodoController(doGet) : memberId 확인 -> " + memberId);
		System.out.println("[debug] ModifyTodoController(doGet) : todoDate 확인 -> " + todoDate);
		System.out.println("[debug] ModifyTodoController(doGet) : todoContent 확인 -> " + todoContent);
		System.out.println("[debug] ModifyTodoController(doGet) : createDate 확인 -> " + createDate);
		System.out.println("[debug] ModifyTodoController(doGet) : updateDate 확인 -> " + updateDate);
		
		// 수정에 필요한 데이터 전달
		request.setAttribute("todoNo", todoNo);
		request.setAttribute("memberId", memberId);
		request.setAttribute("todoDate", todoDate);
		request.setAttribute("todoContent", todoContent);
		request.setAttribute("createDate", createDate);
		request.setAttribute("updateDate", updateDate);
		request.setAttribute("y", todoDate.substring(0,4));
		request.setAttribute("m", todoDate.substring(5,7));
		request.setAttribute("d", todoDate.substring(8,10));
		
		request.getRequestDispatcher("/WEB-INF/view/modifyTodo.jsp").forward(request, response);
	}

	// 일정 수정 액션 기능
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// modifyTodo.jsp에서 값 가져옴
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String memberId = request.getParameter("memberId");
		String todoDate = request.getParameter("todoDate");
		String todoContent = request.getParameter("todoContent");
		String fontColor = request.getParameter("fontColor");
		
		// 디버깅 코드
		System.out.println("[debug] ModifyTodoController(doPost) : todoNo 확인 -> " + todoNo);
		System.out.println("[debug] ModifyTodoController(doPost) : memberId 확인 -> " + memberId);
		System.out.println("[debug] ModifyTodoController(doPost) : todoDate 확인 -> " + todoDate);
		System.out.println("[debug] ModifyTodoController(doPost) : todoContent 확인 -> " + todoContent);
		System.out.println("[debug] ModifyTodoController(doPost) : fontColor 확인 -> " + fontColor);
		
		// Todo 클래스 객체 생성
		Todo todo = new Todo();
		todo.setTodoNo(todoNo);
		todo.setMemberId(memberId);
		todo.setTodoDate(todoDate);
		todo.setTodoContent(todoContent);
		todo.setFontColor(fontColor);
		
		// TodoService 클래스 객체 생성
		todoService = new TodoService();
		
		// modifyTodo() 메소드가 성공한지, 실패한지 확인하기 위한 변수
		int check = todoService.modifyTodo(todo);
		
		// 문자열 가져오기(y = 0~3번째 자리 숫자), (m = 5번째방부터 시작 5~6 숫자), (d = 8번째방부터 시작 8~9 숫자)
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);
		System.out.println("[debug] ModifyTodoController : y값 확인 -> " + y);
		System.out.println("[debug] ModifyTodoController : m값 확인 -> " + m);
		System.out.println("[debug] ModifyTodoController : d값 확인 -> " + d);
		
		if(check == 1) { // 수정 성공
			System.out.println("[debug] ModifyTodoController : 수정 성공!");
			// todoList 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/todoList?y="+y+"&m="+m+"&d="+d);
			return;
		} else { // 수정 실패
			System.out.println("[debug] ModifyTodoController : 수정 실패!");
			// todoList 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/todoList?y="+y+"&m="+m+"&d="+d);
			return;
		}
	}

}