package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalendarService;
import vo.Member;
import vo.Todo;

@WebServlet("/member/calendar")
public class CalendarController extends HttpServlet {
	private CalendarService calendarService;
	
	// 달력 페이지
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentYear = request.getParameter("currentYear");
		String currentMonth = request.getParameter("currentMonth");
		String option = request.getParameter("option");
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		
		// 디버깅 코드
		System.out.println("[debug] CalendarController : currentYear 확인 -> " + currentYear);
		System.out.println("[debug] CalendarController : currentMonth 확인 -> " + currentMonth);
		System.out.println("[debug] CalendarController : option 확인 -> " + option);
		System.out.println("[debug] CalendarController : memberId 확인 -> " + memberId);
		
		// CalendarService 클래스 객체 생성
		calendarService = new CalendarService();
		Map<String, Object> map = calendarService.getTargetCalendar(memberId, currentYear, currentMonth, option);
		System.out.println("[debug] CalendarController : map 확인 -> " + map);
				
		// 모델
		request.setAttribute("targetYear", map.get("targetYear"));
		request.setAttribute("targetMonth", map.get("targetMonth"));
		request.setAttribute("endDay", map.get("endDay"));
		// 달력을 출력할 때 앞/뒤 필요한 공백 <td>
		request.setAttribute("startBlank", map.get("startBlank"));
		request.setAttribute("endBlank", map.get("endBlank"));
		// 달력에 출력할 todo 내용 목록
		request.setAttribute("todoList", map.get("todoList"));
		
		request.getRequestDispatcher("/WEB-INF/view/calendar.jsp").forward(request, response);
	}

}
