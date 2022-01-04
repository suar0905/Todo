package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class CalendarService {
	private TodoDao todoDao;
	
	public Map<String, Object> getTargetCalendar(String memberId, String currentYear, String currentMonth, String option) { // option = pre(이전), next(다음)
		// 1) 달력 소스 코드
		Map<String, Object> map = new HashMap();
		
		// 오늘 날짜를 보여주기 위해(오늘 날짜의 년도와 월을 가진다)
		Calendar c = Calendar.getInstance();
		System.out.println("[debug] CalendarService : c 확인 -> " + c);
		
		if(currentYear != null && currentMonth != null) { // 매개변수 값인 currentYear값과 currentMonth값을 
			int y = 0; // 년도
			int m = 0; // 월
			y = Integer.parseInt(currentYear); // 숫자형으로 재정의
			m = Integer.parseInt(currentMonth); // 숫자형으로 재정의, 알고리즘 구현에서 월은 1~12월
			System.out.println("[debug] CalendarService : y 확인 -> " + y);
			System.out.println("[debug] CalendarService : m 확인 -> " + m);
			
			if(option != null && option.equals("pre")) {
				m = m - 1; // m값이 0일때 이슈발생됨
				// 이슈 해결(m값이 0이되면 12로 변환하고, 년도의 값을 1 빼준다)
				if(m == 0) {
					m = 12;
					y = y - 1; 
				} 
			} else if(option != null && option.equals("next")) {
					m = m + 1; // m값이 13일때 이슈발생됨
					// 이슈 해결(m값이 13이되면 1로 변환하고, 년도의 값을 1 더해준다)
					if(m == 13) {
						m = 1;
						y = y + 1;
					}
			  }
			c.set(Calendar.YEAR, y); // 매개변수의 값인 년도로 바꾸어준다
			c.set(Calendar.MONTH, m-1); // 매개변수의 값인 월로 바꾸어준다(월은 자바 api에선 0~11이다)		
		}
		c.set(Calendar.DATE, 1); // c의 객체가 오늘의 정보인데 같은 달 1일로 변경하겠다
		
		// 달력에 필요한 데이터모델(controller가 받고 view에다 넘겨줌)
		int targetYear = c.get(Calendar.YEAR); // 오늘 년도
		int targetMonth = c.get(Calendar.MONTH) + 1; // 오늘 월, + 1을 한 이유 : 월을 1월부터 12월이지만 프로그램에선 0부터 11이기 때문이다
		int endDay = c.getActualMaximum(Calendar.DATE); // 오늘 월의 마지막 일자
		System.out.println("[debug] CalendarService : targetYear 확인 -> " + targetYear);
		System.out.println("[debug] CalendarService : targetMonth 확인 -> " + targetMonth);
		System.out.println("[debug] CalendarService : endDay 확인 -> " + endDay);
		
		// 달력 앞, 뒤 공백의 개수
		int startBlank = 0; // 현재 타겟이 되는 달의 1일의 요일 -> 일요일이면 0, 월요일 1 ... 토요일 6
		startBlank = c.get(Calendar.DAY_OF_WEEK) - 1; // -1 이유 : 0 ~ 6이기 때문에
		System.out.println("[debug] CalendarService : startBlank 확인 -> " + startBlank);
		int endBlank = 0; // 전체의 <td>의 개수 = startBlank + endDay + endBlank ----- ( startBlank + endDay ) / 7 했을 때 0으로 나누어 떨어지면 endBlank는 0
		endBlank = 7 - (startBlank + endDay) % 7;
		if(endBlank == 7) {
			endBlank = 0;
		}
		System.out.println("[debug] CalendarService : endBlank 확인 -> " + endBlank);
		
		map.put("targetYear", targetYear);
		map.put("targetMonth", targetMonth);
		map.put("endDay", endDay);
		map.put("startBlank", startBlank);
		map.put("endBlank", endBlank);
		System.out.println("[debug] CalendarService : 첫 번째 map값 확인 -> " + map);
		
		// 2. 달력에 추가할 모델(todo) 알고리즘 코드
		List<Todo> todoList = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			Todo todo = new Todo(); // memberId, todoDate(년,월)가 필요, memberId는 매개변수로 입력받고, todoDate는 위에서 구해놓은 targetYear, targetMonth를 이용해서 구함
			todo.setMemberId(memberId);
			
			/*
			String t = ""; // t는 공백 변수 (targetMonth가 1,2,3...9일때 두자리 수를 만들기 위한 변수)
			if(targetMonth < 10) { // targetMonth가 10보다 작으면
				t="0";
			}
			*/
			
			String strYear ="" + targetYear;
			String strMonth ="" + targetMonth;
			if(targetMonth < 10) { // targetMonth가 10보다 작으면
				strMonth = "0" + targetMonth;
			}
			todo.setTodoDate(strYear+"-"+strMonth);
			System.out.println("[debug] CalendarService : strYear 확인 -> " +strYear);
			System.out.println("[debug] CalendarService : strMonth 확인 -> " +strMonth);
			System.out.println("[debug] CalendarService : todo 확인 -> " +todo);
			
			todoList = todoDao.selectTodoListByMonth(conn, todo);
			System.out.println("[debug] CalendarService : todoList 확인 -> " + todoList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		map.put("todoList", todoList);
		System.out.println("[debug] CalendarService : 두 번째 map값 확인 -> " + map);
		
		return map;
	}	
}
