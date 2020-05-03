package com.capgemini.survey.exceptions;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException{
	
	String message;
	public org.apache.log4j.Logger logger = Logger.getLogger(NotFoundException.class);

	public NotFoundException(String message) {
		this.message = message;
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
