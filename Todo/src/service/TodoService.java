package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	// (4) 일정 삭제 메소드
	public int removeTodo(Todo todo) {
		// 디버깅 코드
		System.out.println("[debug] TodoService : todoNo, memberId값 확인 -> " + todo.getTodoNo());
				
		int deleteRs = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			// TodoDao 클래스 객체 생성
			todoDao = new TodoDao();
			deleteRs = todoDao.deleteTodoList(conn, todo);
			System.out.println("[debug] TodoService : deleteRs 확인 -> " + deleteRs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteRs;
	}
	
	// (3) 일정 수정 메소드
	public int modifyTodo(Todo todo) {
		// 디버깅 코드
		System.out.println("[debug] TodoService : todoContent, todoNo, memberId값 확인 -> " + todo.toString());
		
		int updateRs = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			// TodoDao 클래스 객체 생성
			todoDao = new TodoDao();
			updateRs = todoDao.updateTodoList(conn, todo);
			System.out.println("[debug] TodoService : updateRs 확인 -> " + updateRs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateRs;
	}
	
	// (2) 일정 추가 메소드
	public int addTodo(Todo todo) {
		// 디버깅 코드
		System.out.println("[debug] TodoService : memberId, todoDate, todoContent값 확인 -> " + todo.toString());
				
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
