package com.santander.domain.service.exception;

public class AccountAlreadyExistsException extends RuntimeException {

	public AccountAlreadyExistsException() {
		super("Conta já cadastrada");
	}
}
