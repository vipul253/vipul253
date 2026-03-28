package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SampleCheckoutService {

	// Automatically injects the @Primary bean (CreditCardPaymentService)
    @Autowired
    private PaymentService defaultPaymentService;

    // Explicitly injects the "payPalService" bean using @Qualifier
    @Autowired
    @Qualifier("payPalService")
    private PaymentService payPalPaymentService;
    
    public void paymentServiceCaller() {
    	defaultPaymentService.processPayment(123.4);
    	payPalPaymentService.processPayment(123.4);
	}
}
