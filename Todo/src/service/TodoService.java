package service;

import java.sql.Connection;
import java.util.List;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	// (1) 캘린더(달력) 일정 구하는 메소드
	public List<Todo> getTodoListByDate(Todo todo) {
		List<Todo> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			// TodoDao 클래스 객체 생성
			todoDao = new TodoDao();
			list = todoDao.selectTodoListByDate(conn, todo);
			System.out.println("[debug] TodoService : list -> " + list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
