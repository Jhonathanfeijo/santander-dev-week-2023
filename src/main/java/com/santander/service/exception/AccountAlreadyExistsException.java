package com.santander.service.exception;

public class AccountAlreadyExistsException extends RuntimeException {

	public AccountAlreadyExistsException() {
		super("Conta já cadastrada");
	}
}
