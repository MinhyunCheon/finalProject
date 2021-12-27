package kr.co.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null) {
			session.setAttribute("dest", request.getRequestURI());
			session.setAttribute("qString", request.getQueryString());
			response.sendRedirect("sign-in");
			return false;
		}
		
		
		return true;
	}
}
