package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	
	// 회원가입 페이지
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}

	// 회원가입 기능 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// addMember.jsp에서 값 가져옴
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		// 디버깅 코드
		System.out.println("[debug] AddMemberController : memberId -> " + memberId);
		System.out.println("[debug] AddMemberController : memberPw -> " + memberPw);
		
		// Member 클래스 객체 생성
		Member paramMember = new Member();
		paramMember.setMemberId(memberId);
		paramMember.setMemberPw(memberPw);
		System.out.println("[debug] AddMemberController : paramMember -> " + paramMember);
		
		// MemberSerive 클래스 객체 생성
		memberService = new MemberService();
		
		int insertCheck = memberService.addMember(paramMember);
		
		if(insertCheck == 1) { // 회원가입 성공 시
			System.out.println("[debug] AddMemberController : " + memberId + "님 회원가입에 성공하셨습니다!");
			// 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} else { // 회원가입 실패 시
			System.out.println("[debug] AddMemberController : " + memberId + "님 회원가입에 실패하셨습니다!");
			// 회원가입 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/addMember");
			return;
		}
	}

}
