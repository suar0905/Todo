package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	// (2) 일정 추가 메소드
	public int addTodo(Todo todo) {
		// 디버깅 코드
		System.out.println("[debug] TodoService : todo 확인 -> " + todo.toString());
				
		int insertRs = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			// TodoDao 클래스 객체 생성
			todoDao = new TodoDao();
			insertRs = todoDao.insertTodo(conn, todo);
			System.out.println("[debug] TodoService : insertRs 확인 -> " + insertRs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return insertRs;
	} 
	
	// (1) 캘린더(달력) 일정 구하는 메소드
	public List<Todo> getTodoListByDate(Todo todo) {
		// 디버깅 코드
		System.out.println("[debug] TodoService : memberId, todoDate 확인 -> " + todo.toString());
		
		List<Todo> todoList = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			// TodoDao 클래스 객체 생성
			todoDao = new TodoDao();
			todoList = todoDao.selectTodoListByDate(conn, todo);
			System.out.println("[debug] TodoService : todoList -> " + todoList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return todoList;
	}
}
