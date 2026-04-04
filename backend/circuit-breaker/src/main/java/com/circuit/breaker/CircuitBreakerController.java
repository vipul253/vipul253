package com.circuit.breaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
	private final SampleService sampleService;

	public CircuitBreakerController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@GetMapping("/circuitBreakerTest")
	public String testCircuitBreaker() {
		return sampleService.callExternalService();
	}
}
