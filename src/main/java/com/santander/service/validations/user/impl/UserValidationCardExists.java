package com.santander.service.validations.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.santander.domain.model.User;
import com.santander.domain.repository.UserRepository;
import com.santander.service.exception.CardAlreadyExistsException;
import com.santander.service.validations.user.UserValidation;

@Component
public class UserValidationCardExists implements UserValidation {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void validar(User user) {
		var cardExists = userRepository.existsByCardNumber(user.getCard().getNumber());
		if (cardExists)
			throw new CardAlreadyExistsException();
	}
}
