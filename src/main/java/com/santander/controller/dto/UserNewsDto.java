package com.santander.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.santander.domain.model.User;
import com.santander.domain.model.baseitem.news.UserNews;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UserNewsDto(@NotNull @Valid NewsDto newsDto) {

	public UserNewsDto(UserNews userNews) {
		this(new NewsDto(userNews.getNews()));
	}

	public UserNews toUserNews(User user) {
		if (newsDto == null)
			return null;
		UserNews userNews = new UserNews();
		userNews.setNews(newsDto.toNews());
		userNews.setUser(user);
		return userNews;
	}

	public static List<UserNewsDto> toUserNewsDtoList(User user) {
		if (user == null || user.getUserNews() == null)
			return null;
		List<UserNewsDto> userNewsDtoList = user.getUserNews().stream().map(userNews -> {
			return new UserNewsDto(userNews);
		}).toList();
		return userNewsDtoList;
	}

	public static List<UserNews> toUserNewsList(User user, List<UserNewsDto> userNewsDtoList) {
		if (userNewsDtoList == null)
			return null;
		List<UserNews> userNewsList = new ArrayList<UserNews>();
		userNewsDtoList.stream().map(userNewsDto -> {
			UserNews userNews = userNewsDto.toUserNews(user);
			userNewsList.add(userNews);
			return null;
		});
		return userNewsList;
	}
}
