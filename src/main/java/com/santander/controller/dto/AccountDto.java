package com.santander.controller.dto;

import java.math.BigDecimal;

import com.santander.domain.model.Account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record AccountDto(@NotBlank String number, @NotBlank String agency, @NotNull @PositiveOrZero BigDecimal limit,
		@NotNull BigDecimal balance) {

	public AccountDto(Account account) {
		this(account.getNumber(), account.getAgency(), account.getLimit(), account.getBalance());
	}

	public Account toAccount() {
		Account account = new Account();
		account.setAgency(this.agency);
		account.setBalance(this.balance);
		account.setLimit(this.limit);
		account.setNumber(this.number);
		return account;
	}
}
