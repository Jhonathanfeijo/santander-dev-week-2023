package com.santander.controller.dto;

import com.santander.domain.model.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank String name, @Valid AccountDto accountDto, @Valid CardDto cardDto) {

	public UserDto(User user) {
		this(user.getName(), new AccountDto(user.getAccount()), new CardDto(user.getCard()));
	}

	public User toUser() {
		User user = new User();
		user.setName(this.name);
		user.setAccount(this.accountDto.toAccount());
		user.setCard(this.cardDto.toCard());
		return user;
	}
}
