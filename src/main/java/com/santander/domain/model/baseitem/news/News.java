package com.santander.domain.model.baseitem.news;

import com.santander.domain.model.baseitem.BaseItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "news")
@Table(name = "news")
public class News extends BaseItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String icon;
	private String description;
}
