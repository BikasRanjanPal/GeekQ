package com.geekq.api.gateway.exceptions;
public class InvalidParametersException extends QuizException {

	private static final long serialVersionUID = 1L;

	public InvalidParametersException() {
		super();
	}

	public InvalidParametersException(String message) {
		super(message);
	}
}
