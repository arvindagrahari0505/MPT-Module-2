package com.capgemini.exception;

/*
 * Exception class if there is no data found Product
 * This exception occur whenever we try to access product object whose product Id is not used before
 * This exception occur whenever we try to access all the product object from database but there is no data in table
 */
public class NoDataFoundException extends Exception {

	// A serial Id for exception
	private static final long serialVersionUID = -3771524605423364446L;

	// A constructor having a attribute of message
	public NoDataFoundException(String message) {
		super(message);
	}

	// Override a method getMessage for returning the super class message
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
