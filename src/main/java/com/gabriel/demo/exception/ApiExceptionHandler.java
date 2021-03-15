package com.gabriel.demo.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiExceptionDetails apiException = new ApiExceptionDetails(e.getMessage(),
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException,badRequest);

	}
	
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<ValidationExceptionDetails> handleValidationException(MethodArgumentNotValidException e){	
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		List<FieldError> fieldErros = e.getBindingResult().getFieldErrors();
		String fields = fieldErros.stream().map(FieldError::getField)
				.collect(Collectors.joining(","));
		String fieldsMessage = fieldErros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));		
		
		ValidationExceptionDetails validationExceptionDetails =
				new ValidationExceptionDetails(e.getMessage(), HttpStatus.BAD_REQUEST, 
						ZonedDateTime.now(ZoneId.of("Z")),
						fields, fieldsMessage);
		return new ResponseEntity<>(validationExceptionDetails, badRequest );
				
						
	}
	
	
}
