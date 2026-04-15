package com.quiz.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class SampleWebRequestInterceptor implements WebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws Exception {
		// Example: Log a custom header
		String authHeader = request.getHeader("Authorization");
		System.out.println("PreHandle: Intercepting request with auth: " + authHeader);
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		System.out.println("PostHandle: Executed after controller");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		System.out.println("AfterCompletion: Request cycle finished");
	}

}
