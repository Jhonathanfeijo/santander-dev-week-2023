package com.santander.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.santander.domain.service.exception.CardAlreadyExistsException;

@RestControllerAdvice
public class CardControllerAdvice {

	@ExceptionHandler(CardAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String CardAlreadyExistsException(CardAlreadyExistsException ex) {
		return ex.getMessage();
	}
}
