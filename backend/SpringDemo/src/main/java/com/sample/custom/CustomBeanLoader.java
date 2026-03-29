package com.sample.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanLoader {

	@Autowired
	private ApplicationContext applicationContext;

	public Object getBeanDynamically(String beanName) {
		return applicationContext.getBean(beanName);
	}
}
/*
 * 3. Programmatic Bean Lookup using ApplicationContext For highly specific
 * scenarios where you need to fetch an arbitrary bean manually based on complex
 * logic not suited for the factory pattern, you can inject the
 * ApplicationContext itself and call getBean() programmatically. This approach
 * is generally less recommended as it couples your code to the Spring container
 * and circumvents standard dependency injection, but it offers complete
 * control.
 */