package com.sample.service.factory;

import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sample.service.PaymentService;

@Component
public class PaymentServiceFactory {

	private final Map<String, PaymentService> paymentServices;

	//@Autowired // Spring automatically populates this map
	public PaymentServiceFactory(Map<String, PaymentService> paymentServices) {
		this.paymentServices = paymentServices;
	}

	public PaymentService getPaymentService(String method) {
		PaymentService service = paymentServices.get(method);
		if (service == null) {
			throw new RuntimeException("Unknown payment method: " + method);
		}
		return service;
	}
}
/*
 * 1. Map-Based Strategy Pattern (Recommended for per-request/dynamic choice)
 * This is the most common and elegant solution in modern Spring Boot for
 * selecting among multiple implementations of the same interface at runtime
 * based on an input parameter (like a user preference, request header, or
 * business logic condition).
 */
