package com.santander.domain.model.baseitem.news;

import com.santander.domain.model.baseitem.UserItens;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_news")
@Setter
@Getter
public class UserNews extends UserItens {

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinColumn(name = "news_id")
	private News news;
	
}
