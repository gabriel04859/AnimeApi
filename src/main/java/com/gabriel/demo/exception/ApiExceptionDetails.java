package com.gabriel.demo.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiExceptionDetails {
	private final String message;
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimesTamp() {
		return timesTamp;
	}

	private final HttpStatus httpStatus;
	private final ZonedDateTime timesTamp;
	
	public ApiExceptionDetails(String message, HttpStatus httpStatus, ZonedDateTime timesTamp) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timesTamp = timesTamp;
	}
	
	

}
