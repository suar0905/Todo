package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // /* : 모든 controller의 요청(get,post)을 가로채겠다
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// chain.doFilter(request, response)를 기준으로 요청 전 필터
		request.setCharacterEncoding("UTF-8"); // doPost() 메소드 상단에(요청처리전) 무조건 있어야한다 - post방식으로 넘어오는 데이터들의 인코딩 셋팅
		System.out.println("[debug] EncodingFilter : doFilter() 실팽");
		
		chain.doFilter(request, response); // 사용자가 요청한(doPost) 컨트롤러 메소드
		
		// chain.doFilter(request, response)를 기준으로 요청 후 필터
	}
}
