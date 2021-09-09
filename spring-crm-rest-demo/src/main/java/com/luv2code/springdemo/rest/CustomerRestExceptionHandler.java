package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	//exc handler for customernotfound
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e){
		
		//make customer error response
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											e.getMessage(),
											System.currentTimeMillis());
		//return response entity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//exc handler catch all
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e){
		
		//make customer error response
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											e.getMessage(),
											System.currentTimeMillis());
		//return response entity
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
