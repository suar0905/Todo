package commons;

import java.sql.Connection;
import java.sql.DriverManager;

// service가 dao를 호출할 때 DBUtil 호출을 통해 service가 만든 connection을 제공해준다 -> 이렇게 한 이유 : 트랜잭션 처리를 위해
public class DBUtil {
	/* static 사용 이유 : 전역적으로 쉽게 재사용하는 멤버나 잘 변하지 않는 변수나, 메소드를 사용할때 주로 사용된다.
	   만들어 놓고 클래스 호출, 객체(인스턴스) 생성을 따로 할 필요없이 바로바로 사용할 수 있기 때문에 사용성이 좋기때문이다. */
	public static Connection getConnection(String url, String user, String password) {
		// conn 변수 선언
		Connection conn = null;
		try {
			// conn 변수에 매개변수 입력값 할당
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("[debug] DBUtil : conn실행 -> " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
