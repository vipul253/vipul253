package com.sample.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CreditCardPaymentService implements PaymentService {

	@Override
	public void processPayment(double amount) {
		System.out.println("default payment service which will be injected");
		
	}

}
