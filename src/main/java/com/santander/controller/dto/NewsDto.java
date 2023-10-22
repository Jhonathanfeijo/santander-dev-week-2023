package com.santander.controller.dto;

import com.santander.domain.model.baseitem.news.News;

import jakarta.validation.constraints.NotBlank;

public record NewsDto(@NotBlank String icon, @NotBlank String description) {

	public NewsDto(News news) {
		this(news.getIcon(), news.getDescription());
	}
	
	public News toNews() {
		News news = new News();
		news.setIcon(this.icon);
		news.setDescription(this.description);
		return news;
	}
}
