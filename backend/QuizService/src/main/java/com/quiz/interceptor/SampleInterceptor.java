package com.quiz.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * This class will override methods like preHandle(), postHandle(), and
 * afterCompletion() to add custom logic before or after a controller handles a
 * request.
 */
@Component
public class SampleInterceptor implements HandlerInterceptor {

	// 1. preHandle: Executed before the controller method
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("request at /quiz intercepted "+ request.getRequestURI());
		// Add pre-processing logic here (e.g., logging, authentication)
		return true; // Return false to stop further execution
	}

	// 2. postHandle: Executed after the controller but BEFORE view rendering
	// Note: Not called if the controller throws an exception.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2. postHandle: Controller finished, view not yet rendered.");
		if (modelAndView != null) {
			modelAndView.addObject("customAttr", "Added by Interceptor");
		}
	}

	// 3. afterCompletion: Executed after the ENTIRE request (including view
	// rendering)
	// Always runs, making it ideal for resource cleanup or logging performance.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("3. afterCompletion: Request fully processed.");
		if (ex != null) {
			System.out.println("An error occurred: " + ex.getMessage());
		}
	}
}
