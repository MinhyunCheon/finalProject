package kr.co.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PageInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if(!uri.equals("/sign-in") && !uri.equals("/login")) {
			HttpSession session = request.getSession();
			session.setAttribute("dest", request.getRequestURI());
			session.setAttribute("qString", request.getQueryString());
		}
		
		return true;
	}
}
