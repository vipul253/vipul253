package com.quiz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * This class will override methods like preHandle(), postHandle(), and
 * afterCompletion() to add custom logic before or after a controller handles a
 * request.
 */
public class SampleInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("request at /quiz intercepted");
		// Add pre-processing logic here (e.g., logging, authentication)
		return true; // Return false to stop further execution
	}
	// ... postHandle and afterCompletion methods
}
