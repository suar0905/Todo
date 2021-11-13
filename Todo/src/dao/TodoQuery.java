package dao;

public class TodoQuery {
	public static final String SELECT_TODO_LIST_BY_DATE; // 캘린더(달력) 일정 표현
	public static final String DELETE_TODO; // 회원탈퇴시 todo list도 삭제
	public static final String INSERT_TODO_LIST; // 일정 추가
	public static final String UPDATE_TODO_LIST; // 일정 수정
	public static final String DELETE_TODO_LIST; // 일정 삭제
	
	static {
		// todo 테이블에서 member_id가 ?이고, todo_date가 ?일 때, todoNo, memberId, todoDate, todoContent, createDate, updateDate를 조회하여라
		SELECT_TODO_LIST_BY_DATE = 
				"SELECT todo_no todoNo, member_id memberId, todo_date todoDate, todo_content todoContent, create_date createDate, update_date updateDate "
				+ "FROM todo WHERE member_id=? AND todo_date=?";
		// todo 테이블에서 member_id가 ?일 때의 데이터를 삭제하여라
		DELETE_TODO = "DELETE FROM todo WHERE member_id=?";
		// todo 테이블에서 member_id, todo_date, todo_content, create_date, update_date 항목에 ?,?,?,NOW(),NOW()값을 추가하여라
		INSERT_TODO_LIST = "INSERT INTO todo(member_id, todo_date, todo_content, create_date, update_date) VALUES(?,?,?,NOW(),NOW())";
		//
		UPDATE_TODO_LIST = "";
		//
		DELETE_TODO_LIST = "";
	}
}
