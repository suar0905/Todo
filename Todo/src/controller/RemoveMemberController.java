package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {
	// controller 클래스가 service 클래스를 메소드마다 생성하기 보단 한 번에 지정하여 편하게 부르기 위해 맨 윗부분에 선언
	private MemberService memberService;
	
	// 회원탈퇴 페이지
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
	}

	// 회원탈퇴 기능 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// remove.jsp에서 값 가져옴
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		// 디버깅 코드
		System.out.println("[debug] RemoveMemberController : memberId값 -> " + memberId);
		System.out.println("[debug] RemoveMemberController : memberPw값 -> " + memberPw);
		
		// memberService 클래스 객체 생성
		memberService = new MemberService();
		
		// removeMember() 메소드가 성공했는지, 실패했는지 확인하기 위한 변수
		boolean check = memberService.removeMember(memberId, memberPw);
		
		if(check) { // 회원탈퇴 성공
			System.out.println("[debug] RemoveMemberController :" + memberId + "님 회원탈퇴 성공!");
			// logout 서비스를 이용하여 기존 세션에 대한 정보를 제거하고 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member/logout");
			return;
		} else { // 회원탈퇴 실패
			System.out.println("[debug] RemoveMemberController :" + memberId + "님 회원탈퇴 실패!");
			response.sendRedirect(request.getContextPath() + "/member/calendar");
			return;
		}
	}
}
