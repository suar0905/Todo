package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 관리자 로그인 되어있지 않은 상태에서 요청 처리 불가, 즉 로그인 상태에서만 요청할 수 있도록 필터링 됨
		System.out.println("[debug] AdminLoginFilter : AdminLoginFilter.doFilter() 실행");
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("adminId") == null) { // 로그인되어 있지 않은 상태
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/adminLogin");
			return;
		}
		chain.doFilter(request, response);
}
}
