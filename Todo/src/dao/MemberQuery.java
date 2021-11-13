package dao;

// SQL Query문 작성 및 변수 선언하는 곳
public class MemberQuery {
	public static final String LOGIN; // 로그인
	public static final String INSERT_MEMBER; // 회원가입
	public static final String DELETE_MEMBER; // 회원탈퇴
	
	static {
		// member 테이블에서 member_id가 ?이고, member_pw가 ?일 때, memberId, memberPw를 조회하여라
		LOGIN = "SELECT member_id memberId, member_pw memberPw FROM member WHERE member_id=? AND member_pw=?";
		// member 테이블에서 member_id, member_pw, create_date, update_date를 ?,?,NOW(),NOW()값으로 추가하여라
		INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, create_date, update_date) VALUES(?,?,NOW(),NOW())";
		// member 테이블에서 member_id가 ?이고, member_pw가 ?일 때의 데이터를 삭제하여라
		DELETE_MEMBER = "DELETE FROM member WHERE member_id=? AND member_pw=?";
	}
}
