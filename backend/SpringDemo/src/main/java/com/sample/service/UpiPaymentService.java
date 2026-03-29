package com.sample.service;

import org.springframework.stereotype.Service;

@Service("upi")
public class UpiPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }
}