package com.learning.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {

	private LocalDate timestamp;
	private String message;
	private String details;
	public ErrorDetails(LocalDate now, String message2, String description) {
		// TODO Auto-generated constructor stub
		super();
		this.timestamp = now;
		this.message = message2;
		this.details = description;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getDetails() {
		return details;
	}	
	
}
