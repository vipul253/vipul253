package com.sample.service;

import org.springframework.stereotype.Service;

@Service
public class PayByConfig {

	private final PaymentService paymentService;

    // Spring injects the appropriate bean (UpiService or PaypalService)
    public PayByConfig(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String callPaymentService(double amount) {
        // This calls the method of the conditionally loaded bean
    	// currently this is giving @Primary cc bean
        paymentService.processPayment(amount);
        return "payment done by name set in config file "+paymentService.getClass().getName();
    }
}
