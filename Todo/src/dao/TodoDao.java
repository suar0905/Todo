package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Todo;

public class TodoDao {
 	
	// (6) 캘린더에 일정내용 5글자 표시 메소드
	public List<Todo> selectTodoListByMonth(Connection conn, Todo todo) throws SQLException {
		// 디버깅 코드
		System.out.println("[debug] TodoDao : memberId, todoDate값 확인 -> " + todo.toString());
		
		// 쿼리 생성
		String sql = TodoQuery.SELECT_TODO_LIST_BY_MONTH;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		
		List<Todo> list = new ArrayList<Todo>();
		
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoDate(rs.getString("todoDate"));
			t.setTodoContent(rs.getString("todoContent5"));
			t.setFontColor(rs.getString("fontColor"));
			list.add(t);
		}
		
		// 기록 종료
		rs.close();
		stmt.close();
		
		return list;
	}
	
	// (5) 일정 삭제 메소드
	public int deleteTodoList(Connection conn, Todo todo) throws SQLException {
		// 디버깅 코드
		System.out.println("[debug] TodoDao : todoNo, memberId값 확인 -> " + todo.toString());
		
		// 쿼리 생성
		String sql = TodoQuery.DELETE_TODO_LIST;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, todo.getTodoNo());
		stmt.setString(2, todo.getMemberId());
		
		// 쿼리 실행
		int deleteRs = stmt.executeUpdate();
		
		if(deleteRs == 1) {
			System.out.println("[debug] TodoDao : 삭제 성공!");
		} else {
			System.out.println("[debug] TodoDao : 삭제 실패!");
		}
		
		// 기록 종료
		stmt.close();
		
		return deleteRs;
	}
	
	// (4) 일정 수정 메소드
	public int updateTodoList(Connection conn, Todo todo) throws SQLException {
		// 디버깅 코드
		System.out.println("[debug] TodoDao : todoContent, fontColor, todoNo, memberId, todoScore 값 확인 -> " + todo.toString());
		
		// 쿼리 생성
		String sql = TodoQuery.UPDATE_TODO_LIST;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoContent());
		stmt.setInt(2, todo.getTodoScore());
		stmt.setString(3, todo.getFontColor());
		stmt.setInt(4, todo.getTodoNo());
		stmt.setString(5, todo.getMemberId());
		
		// 쿼리 실행
		int updateRs = stmt.executeUpdate();
		
		if(updateRs == 1) {
			System.out.println("[debug] TodoDao : 수정 성공!");
		} else {
			System.out.println("[debug] TodoDao : 수정 실패!");
		}
		
		// 기록 종료
		stmt.close();
		
		return updateRs;
	}
	
	// (3) 일정 추가 메소드
	public int insertTodo(Connection conn, Todo todo) throws SQLException {
		// 디버깅 코드
		System.out.println("[debug] TodoDao : memberId, todoDate, todoContent, todoScore, fontColor값 확인 -> " + todo.toString());
		
		// 쿼리 생성
		String sql = TodoQuery.INSERT_TODO_LIST;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		stmt.setString(3, todo.getTodoContent());
		stmt.setInt(4, todo.getTodoScore());
		stmt.setString(5, todo.getFontColor());
		
		// 쿼리 실행
		int insertRs = stmt.executeUpdate();
		
		if(insertRs == 1) {
			System.out.println("[debug] TodoDao : 입력 성공!");
		} else {
			System.out.println("[debug] TodoDao : 입력 실패!");
		}
		
		// 기록 종료
		stmt.close();
		
		return insertRs; 
	}
	
	// (2) 회원탈퇴시 todo list도 삭제 메소드
	public void deleteTodo(Connection conn, String memberId) throws SQLException {
		// 디버깅 코드
		System.out.println("[debug] TodoDao : memberId 확인 -> " + memberId);
		
		// 쿼리 생성
		String sql = TodoQuery.DELETE_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		
		// 쿼리 실행
		stmt.executeUpdate();
		
		// 기록 종료
		stmt.close();
	}
	
	// (1) 달력 일정 구하는 메소드
	public List<Todo> selectTodoListByDate(Connection conn, Todo todo) throws SQLException {
		// 디버깅 코드
		System.out.println("[debug] TodoDao : memberId, todoDate 확인 -> " + todo.toString());
		
		// 쿼리 생성
		String sql = TodoQuery.SELECT_TODO_LIST_BY_DATE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		
		// List 클래스 배열 객체 생성
		List<Todo> todoList = new ArrayList<>();
		
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoNo(rs.getInt("todoNo"));
			t.setMemberId(rs.getString("memberId"));
			t.setTodoDate(rs.getString("todoDate"));
			t.setTodoContent(rs.getString("todoContent"));
			t.setTodoScore(rs.getInt("todoScore"));
			t.setCreateDate(rs.getString("createDate"));
			t.setUpdateDate(rs.getString("updateDate"));
			
			todoList.add(t);
		}
		
		// 기록 종료
		rs.close();
		stmt.close();
		
		return todoList;
	}
}
