package com.capgemini.exception;

/*
 * Exception class for Invalid Product Id
 * This exception occur whenever we try to update or delete product object whose product Id is not used before 
 * This exception occur for create if we try to save product object whose product Id already used
 */
public class InvalidProductException extends Exception {

	// A serial Id for exception
	private static final long serialVersionUID = 7678293686776203206L;

	// A constructor having a attribute of message
	public InvalidProductException(String message) {
		super(message);
	}

	// Override a method getMessage for returning the super class message
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
