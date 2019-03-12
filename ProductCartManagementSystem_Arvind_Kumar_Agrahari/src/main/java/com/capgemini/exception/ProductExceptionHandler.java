package com.capgemini.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// This class is responsible for handle the exception and validation of Product object
@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

	// Handle all the type of exception if there no exception handler for an exception which is occurring
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // Returning the exception message
	}
	
	// Handle the InvalidProductException
	@ExceptionHandler(InvalidProductException.class)
	public final ResponseEntity<Object> handleInvalidProductException(InvalidProductException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // Returning the exception message
	}
	
	// Handle the NoDataFoundException
	@ExceptionHandler(NoDataFoundException.class)
	public final ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // Returning the exception message
	}
	
	// Handle the Product object validation
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR); // Returning the validation message
	}
}
