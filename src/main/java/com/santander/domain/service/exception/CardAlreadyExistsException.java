package com.santander.domain.service.exception;

public class CardAlreadyExistsException extends RuntimeException{

	public CardAlreadyExistsException() {
		super("Cartão já existe");
	}
}
