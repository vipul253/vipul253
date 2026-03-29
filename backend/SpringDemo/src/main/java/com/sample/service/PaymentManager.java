package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.service.factory.PaymentServiceFactory;

@Service
public class PaymentManager {
	@Autowired
	private PaymentServiceFactory factory;

	public void makePayment(String method, double amount) {
		factory.getPaymentService(method).processPayment(amount);
	}
}
