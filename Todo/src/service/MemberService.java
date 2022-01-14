package service;

import java.sql.Connection;

import commons.DBUtil;
import dao.MemberDao;
import dao.TodoDao;
import vo.Member;

// select -> get, insert -> add, update -> modify, delete -> remove
public class MemberService {
	// MemberService가 어떤 행위를 하기 위해서 사용되어지는 memberDao와 todoDao는 매번 동일해야 하니 맨 윗부분에 선언
	private MemberDao memberDao;
	private TodoDao todoDao;
	
	// (3) 회원탈퇴 메소드
	public boolean removeMember(String memberId, String memberPw) {
		// 디버깅 코드
		System.out.println("[debug] MemberService : memberId값 확인 -> " + memberId);
		System.out.println("[debug] MemberService : memberPw값 확인 -> " + memberPw);
		
		boolean result = false;
		Connection conn = DBUtil.getConnection("jdbc:mariadb://3.34.40.41:3306/todo", "root", "java1004");;
		try {
			// 트랜잭션 처리
			conn.setAutoCommit(false); // deleteMember() 메소드와 deleteTodo() 메소드를 처음에 실패했다고 가정
			// 먼저 todo list부터 삭제
			todoDao = new TodoDao();
			todoDao.deleteTodo(conn, memberId);
			// 비밀번호가 틀려서 삭제가 안될 경우 강제로 예외를 발생(throw)시켜 catch절로 이동해서 rollback 되도록
			memberDao = new MemberDao();
			if(memberDao.deleteMember(conn, memberId, memberPw) != 1) {
				throw new Exception();
			}
			conn.commit();
			result = true; // try 절이 정상적으로 실행되면 finally 절으로 이동
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // deleteMember() 메소드와 deleteTodo() 메소드 중 하나라도 에러가 발생시 롤백 시킴
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// (2) 회원가입 메소드
	public int addMember(Member member) {
		// 디버깅 코드
		System.out.println("[debug] MemberService : memberId, memberPw값 확인 -> " + member.toString());
		
		int insertRs = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://3.34.40.41:3306/todo", "root", "java1004");
			memberDao = new MemberDao();
			insertRs = memberDao.insertMember(conn, member);
			System.out.println("[debug] MemberService : insertRs -> " + insertRs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertRs;
	}
	
	// (1) 로그인 메소드
	public Member login(Member member) {
		// Member 클래스 객체 변수 선언
		Member loginMember = null;
		// Connection 클래스 객체 변수 선언
		Connection conn = null;
		try {
			// Connection 클래스 객체에 변수 값 할당
			conn = DBUtil.getConnection("jdbc:mariadb://3.34.40.41:3306/todo", "root", "java1004");
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
