package com.anil.api.exception;

import java.util.List;

public class ExceptionResponse {

	private String errorMessage;
	private List<String> details;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String errorMessage, List<String> details) {
		super();
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [errorMessage=" + errorMessage + ", details=" + details + "]";
	}

}