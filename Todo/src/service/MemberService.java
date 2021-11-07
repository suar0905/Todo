package service;

import java.sql.Connection;

import commons.DBUtil;
import dao.MemberDao;
import vo.Member;

// select -> get, insert -> add, update -> modify, delete -> remove
public class MemberService {
	// MemberService가 어떤 행위를 하기 위해서 사용되어지는 memberDao는 매번 동일해야 하니 맨 윗부분에 선언
	private MemberDao memberDao;
	
	// (1) 로그인 메소드
	public Member login(Member member) {
		// Member 클래스 객체 변수 선언
		Member loginMember = null;
		// Connection 클래스 객체 변수 선언
		Connection conn = null;
		try {
			// Connection 클래스 객체에 변수 값 할당
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			System.out.println("[debug] MemberService : conn 확인 -> " + conn);
			// MemberDao 클래스 객체 생성
			memberDao = new MemberDao();
			loginMember = memberDao.login(conn, member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("[debug] MemberService : conn이 종료되었습니다 ");
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
}
