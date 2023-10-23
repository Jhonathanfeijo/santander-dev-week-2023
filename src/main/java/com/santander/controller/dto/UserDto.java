package com.santander.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santander.domain.model.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record UserDto(@Valid @NotBlank String name, @Valid AccountDto accountDto, @Valid CardDto cardDto,
	@JsonIgnore	@Valid List<UserNewsDto> userNewsDtoList, @JsonIgnore @Valid List<UserFeatureDto> userFeatureDtoList) {

	public UserDto(User user) {
		this(user.getName(), new AccountDto(user.getAccount()), new CardDto(user.getCard()),
				UserNewsDto.toUserNewsDtoList(user), UserFeatureDto.toUserFeatureDtoList(user));
	}

	public User toUser() {
		User user = new User();
		user.setName(this.name);
		user.setAccount(this.accountDto.toAccount());
		user.setCard(this.cardDto.toCard());
		if (this.userNewsDtoList != null && !this.userNewsDtoList.isEmpty())
			user.setUserNews(UserNewsDto.toUserNewsList(user, userNewsDtoList));
		if (this.userFeatureDtoList != null && !this.userFeatureDtoList.isEmpty())
			user.setUserFeatures(UserFeatureDto.toUserFeatureList(user, userFeatureDtoList));
		return user;
	}
}
