package com.anil.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<ExceptionResponse> handlerResourceNotFound(UserNotFoundException ex) {
		List<String> list = new ArrayList<>();
		list.add(ex.getMessage());
		list.add(ex.getLocalizedMessage());
		list.add(ex.getCause().getMessage());

		ExceptionResponse response = new ExceptionResponse();
		response.getErrorMessage();
		response.getDetails();

		response.setDetails(list);

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
}
