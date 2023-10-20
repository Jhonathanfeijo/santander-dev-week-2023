package com.santander.service.exception;

public class CardAlreadyExistsException extends RuntimeException{

	public CardAlreadyExistsException() {
		super("Cartão já existe");
	}
}
