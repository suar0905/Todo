package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/logout") // /member로 시작 -> 로그인 되어있지 않은 상태에서 요청 처리 불가
public class LogoutController extends HttpServlet {

	// 로그아웃되면 로그인 페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 세션의 값을 모두 사라지게 설정
		request.getSession().invalidate();
		System.out.println("[debug] LogoutController : 로그인 세션이 모두 사라졌습니다");
		
		// 로그인 페이지로 이동
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
}
