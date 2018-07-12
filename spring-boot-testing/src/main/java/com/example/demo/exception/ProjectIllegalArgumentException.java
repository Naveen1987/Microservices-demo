package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;

public class ProjectIllegalArgumentException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> messages;
	public List<String> getMessages() {
		return messages;
	}
	public ProjectIllegalArgumentException(Errors error) {
		messages=new ArrayList<>();
		error.getFieldErrors().forEach(er->{messages.add(er.getDefaultMessage());});
	}
	
	
}
