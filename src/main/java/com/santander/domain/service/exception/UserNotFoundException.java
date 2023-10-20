package com.santander.domain.service.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super("Usuário não encontrado");
	}
}
