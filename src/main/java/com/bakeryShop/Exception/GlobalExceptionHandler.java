package com.bakeryShop.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {	
		
	@ExceptionHandler(EmailOrPasswordInvalidException.class)
	public ResponseEntity<ErrorDetails> handleCustomerAlreadyPresentException(EmailOrPasswordInvalidException ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCustomerNotFoundException(NotFoundException ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailIdAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handleEmailIdAlreadyExistsException(EmailIdAlreadyExistsException ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
