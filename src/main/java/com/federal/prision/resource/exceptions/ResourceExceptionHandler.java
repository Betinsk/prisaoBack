package com.federal.prision.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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
	
	@ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> handleDataIntegrity(
	        Exception e,
	        HttpServletRequest request) {

	    HttpStatus status = HttpStatus.CONFLICT;

	    StandardError err = new StandardError(
	            System.currentTimeMillis(),
	            status.value(),
	            "Database error",
	            "Violação de integridade (registro duplicado ou FK inválida)",
	            request.getRequestURI()
	    );

	    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> handleValidation(
	        org.springframework.web.bind.MethodArgumentNotValidException e,
	        HttpServletRequest request) {

	    StringBuilder sb = new StringBuilder();

	    e.getBindingResult().getFieldErrors().forEach(error -> {
	        sb.append(error.getField())
	          .append(": ")
	          .append(error.getDefaultMessage())
	          .append("; ");
	    });

	    HttpStatus status = HttpStatus.BAD_REQUEST;

	    StandardError err = new StandardError(
	            System.currentTimeMillis(),
	            status.value(),
	            "Validation error",
	            sb.toString(),
	            request.getRequestURI()
	    );

	    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<StandardError> handleMethodNotAllowed(
	        org.springframework.web.HttpRequestMethodNotSupportedException e,
	        HttpServletRequest request) {

	    HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED; // 405

	    StandardError err = new StandardError(
	            System.currentTimeMillis(),
	            status.value(),
	            "Method not allowed",
	            e.getMessage(),
	            request.getRequestURI()
	    );

	    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<StandardError> handleBadCredentials(
	        BadCredentialsException e,
	        HttpServletRequest request) {

	    StandardError err = new StandardError(
	            System.currentTimeMillis(),
	            HttpStatus.UNAUTHORIZED.value(),
	            "Unauthorized",
	            "Email ou senha incorretos",
	            request.getRequestURI()
	    );

	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
}
			