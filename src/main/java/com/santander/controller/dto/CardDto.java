package com.santander.controller.dto;

import java.math.BigDecimal;

import com.santander.domain.model.Card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CardDto(@NotBlank String number, @NotNull BigDecimal limit) {

	public CardDto(Card card) {
		this( card.getNumber(), card.getLimit());
	}

	public Card toCard() {
		Card card = new Card();
		card.setLimit(this.limit);
		card.setNumber(this.number);
		return card;
	}
}
