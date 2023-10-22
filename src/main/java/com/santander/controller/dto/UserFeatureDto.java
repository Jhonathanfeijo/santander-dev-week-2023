package com.santander.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.santander.domain.model.User;
import com.santander.domain.model.baseitem.feature.UserFeature;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UserFeatureDto(@NotNull @Valid FeatureDto FeatureDto) {

	public UserFeatureDto(UserFeature userFeature) {
		this(new FeatureDto(userFeature.getFeature()));
	}

	public UserFeature toUserFeature(User user) {
		if (FeatureDto == null)
			return null;
		UserFeature userFeature = new UserFeature();
		userFeature.setFeature(FeatureDto.tofeature());
		userFeature.setUser(user);
		return userFeature;
	}

	public static List<UserFeatureDto> toUserFeatureDtoList(User user) {
		if (user == null || user.getUserFeatures() == null)
			return null;
		List<UserFeatureDto> userFeatureDtoList = user.getUserFeatures().stream().map(userFeature -> {
			return new UserFeatureDto(userFeature);
		}).toList();
		return userFeatureDtoList;
	}

	public static List<UserFeature> toUserFeatureList(User user, List<UserFeatureDto> userFeatureDtoList) {
		if (userFeatureDtoList == null)
			return null;
		List<UserFeature> userFeatureList = new ArrayList<UserFeature>();
		userFeatureDtoList.stream().map(userFeatureDto -> {
			userFeatureDtoList.add(userFeatureDto);
			return userFeatureDto.toUserFeature(user);
		});
		return userFeatureList;
	}
}