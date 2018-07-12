package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ProjectResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ProjectException.class })
	public final ResponseEntity<ExceptionResponse> handleOtherExceptions(ProjectException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { ProjectIllegalArgumentException.class })
	public final ResponseEntity<ExceptionResponse> handleIllegalArgumentException(ProjectIllegalArgumentException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessages(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}