package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class PostConstructSample implements InitializingBean {

	    public PostConstructSample() {
	        System.out.println("1. Constructor: Bean is instantiated");
	    }

	    @PostConstruct
	    public void init() {
	        System.out.println("2. @PostConstruct: Runs after DI but before usage");
	    }

	    @Override
	    public void afterPropertiesSet() {
	        System.out.println("3. InitializingBean: Runs after @PostConstruct");
	    }
}
