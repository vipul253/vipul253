package com.sample.service;

import org.springframework.stereotype.Service;

@Service("payPal") // Explicitly named bean
public class PayPalPaymentService implements PaymentService {
	@Override
	public void processPayment(double amount) {
		System.out.println("qualifier name payPalService which will be injected if mentioned in @Qualifier");
		System.out.println("Paid ₹" + amount + " via PayPal");
	}
}
