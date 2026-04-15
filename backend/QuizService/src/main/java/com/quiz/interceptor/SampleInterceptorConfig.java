package com.quiz.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SampleInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private SampleWebRequestInterceptor webReqInterceptor;

	@Autowired
	private SampleInterceptor httpReqInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(httpReqInterceptor).addPathPatterns("/quiz/**");
		registry.addWebRequestInterceptor(webReqInterceptor).addPathPatterns("/quiz/**")
				// Optional: limit to specific paths
				// Optional: exclude specific paths
				.excludePathPatterns("/api/login");
	}
}
