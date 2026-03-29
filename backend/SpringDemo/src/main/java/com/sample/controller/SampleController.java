package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.exception.ResourceNotFoundException;
import com.sample.service.PayByConfig;
import com.sample.service.PaymentManager;

@RestController
@RequestMapping("/sample")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular development server
public class SampleController {

	@Autowired
	private PaymentManager payManager;
	
	@Autowired
	private PayByConfig payByConf;

	@GetMapping("/item/{id}")
	public String getItem(@PathVariable Long id) {
		// this is just to demonstrate custom exceptions to throw in resposeBody
		// @RestControllerAdvice GlobalExceptionHandler will further process this
		throw new ResourceNotFoundException("Item with ID " + id + " not found");
	}

	@GetMapping("/payment/{name}")
	public ResponseEntity<String> getSamplePaymentName(@PathVariable String name,@RequestParam double amt) {
		payManager.makePayment(name, 1000);
		return ResponseEntity.ok(name + " payment done");
	}
	
	@GetMapping("/payment")
	public ResponseEntity<String> getConfPaymentName() {
		//remove the @Primary from creditCardService to use from beanConfig
		payByConf.callPaymentService(1000);
		return ResponseEntity.ok("payment done");
	}

	/*
	 * Using ResponseEntity (Recommended for control) The ResponseEntity class
	 * allows you to return a response with a specific body, headers, and HTTP
	 * status code. This is the most flexible approach and is widely considered a
	 * best practice for REST APIs.
	 */
	@GetMapping("/resource")
	public ResponseEntity<String> getResource() {
		String body = "Resource found";
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	// Shortcut using a static builder method
	@GetMapping("/another-resource")
	public ResponseEntity<String> getAnotherResource() {
		String body = "Another resource found";
		return ResponseEntity.ok(body); // Implicitly sets status to 200 OK
	}

	/*
	 * Using @ResponseStatus (For static status codes) The @ResponseStatus
	 * annotation is useful when the status code is consistent every time the method
	 * is called successfully. This approach is simpler if you don't need to return
	 * different status codes based on business logic.
	 */
	@GetMapping("/simple")
	@ResponseStatus(HttpStatus.OK) // Sets the HTTP status to 200 OK
	public String getSimpleResponse() {
		return "This is a simple OK response";
	}

	/*
	 * Implicit Default (Simplest) By default, if a controller method annotated
	 * with @RestController or @ResponseBody executes without throwing an exception,
	 * Spring automatically returns an HTTP 200 OK status
	 */
	@GetMapping("/default-ok")
	public String getDefaultOkResponse() {
		// Spring automatically returns 200 OK if no exception is thrown
		return "Spring returns 200 OK by default";
	}

}
