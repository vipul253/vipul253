package com.sample.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sample.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", "Not Found");
		errorResponse.put("message", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
/*
 * @RestControllerAdvice and @ControllerAdvice both annotations provide a
 * mechanism for global exception handling and other cross-cutting concerns
 * (like @InitBinder and @ModelAttribute) across multiple controllers, keeping
 * your controller code clean and organized. By default, they apply to all
 * controllers in the application, but you can narrow their scope using
 * attributes like basePackages or annotations
 */
