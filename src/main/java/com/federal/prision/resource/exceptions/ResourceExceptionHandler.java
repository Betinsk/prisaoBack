package com.federal.prision.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
 class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException  e,
		HttpServletRequest request) {
		

		 StandardError err = new StandardError(
	                System.currentTimeMillis(),
	                HttpStatus.NOT_FOUND.value(),
	                "Not Found",
	                e.getMessage(),
	                request.getRequestURI()
	        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}	
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<StandardError> badRequest(
			ValidationException e,
	        HttpServletRequest request) {

	    HttpStatus status = HttpStatus.BAD_REQUEST;

	    StandardError err = new StandardError(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "Person not created",
                e.getMessage(),
                request.getRequestURI()
        );
    
    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> badRequest(
			DatabaseException  e,
	        HttpServletRequest request) {

	    HttpStatus status = HttpStatus.CONFLICT;

	    StandardError err = new StandardError(
                System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                e.getMessage(),
                request.getRequestURI()
        );
    
    return ResponseEntity.status(status).body(err);
	}
	
}
			