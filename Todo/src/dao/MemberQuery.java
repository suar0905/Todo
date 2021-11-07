package dao;

// SQL Query문 작성 및 변수 선언하는 곳
public class MemberQuery {
	public static final String LOGIN; // 로그인
	
	static {
		// member 테이블에서 member_id가 ?이고, member_pw가 ?일 때, memberId, memberPw를 조회하여라
		LOGIN = "SELECT member_id memberId, member_pw memberPw FROM member WHERE member_id=? AND member_pw=?";
	}
}
