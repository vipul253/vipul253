package com.sample.custom;

//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.sample.service.PayPalPaymentService;
//import com.sample.service.PaymentService;
//import com.sample.service.UpiPaymentService;

//@Configuration
public class PaymentServiceByConfig {
//  we are using the PaymentServiceFactory so code commented here as we don't define bean on start but get on runtime based on name in request
//	@Bean
//	@ConditionalOnProperty(name = "app.custom.payment", havingValue = "simple")
//	PaymentService simpleService() {
//		return new UpiPaymentService();
//	}
//
//	@Bean
//	@ConditionalOnProperty(name = "app.custom.payment", havingValue = "advanced")
//	PaymentService advancedService() {
//		return new PayPalPaymentService();
//	}
}

/*
 * 2. Using @ConditionalOnProperty (Recommended for application startup
 * conditions) If the decision only needs to be made once when the application
 * starts (e.g., based on a configuration file or environment variable), Spring
 * Boot's @ConditionalOnProperty is ideal. The application will only load the
 * specified bean into the context, and no dynamic switching is possible at
 * runtime without a restart. Medium Medium +3 Define beans
 * with @ConditionalOnProperty
 */
