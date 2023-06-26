package com.scw.module.shared.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResAlertException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResAlertException(String exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}

	public ResAlertException(Exception e) {
		// TODO Auto-generated constructor stub
	}
}
