package com.sample.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("creditCard")
public class CreditCardPaymentService implements PaymentService {

	@Override
	public void processPayment(double amount) {
		System.out.println("This @Primary will be used by spring as default for PaymentService instance");
		System.out.println("Paid ₹" + amount + " via Credit Card");
	}

}
