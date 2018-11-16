package net.kzn.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		super("Product is not available");
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}

	public String getMessage() {
		return message;
	}

}
