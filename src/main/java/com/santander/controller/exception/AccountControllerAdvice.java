package com.santander.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.santander.service.exception.AccountAlreadyExistsException;

@RestControllerAdvice
public class AccountControllerAdvice {

	@ExceptionHandler(AccountAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String AccountAlreadyExistsExceptionHandler(AccountAlreadyExistsException ex) {
		return ex.getMessage();
	}
}
