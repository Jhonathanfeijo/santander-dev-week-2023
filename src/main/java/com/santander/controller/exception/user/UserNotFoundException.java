package com.santander.controller.exception.user;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super("Usuário não encontrado");
	}
}
