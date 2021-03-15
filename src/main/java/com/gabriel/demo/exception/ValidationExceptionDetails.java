package com.gabriel.demo.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ValidationExceptionDetails extends ApiExceptionDetails {
	private String field;
	private String fieldMessage;
	
	public String getField() {
		return field;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}

	public ValidationExceptionDetails(String message, HttpStatus httpStatus, 
			ZonedDateTime timesTamp, String field, String fieldMessage) {
		super(message, httpStatus, timesTamp);
		this.field = field;
		this.fieldMessage = fieldMessage;
	}

}
