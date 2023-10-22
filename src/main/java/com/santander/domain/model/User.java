package com.santander.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santander.domain.model.baseitem.feature.UserFeature;
import com.santander.domain.model.baseitem.news.UserNews;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column
	private String name;
	@NotNull
	@JoinColumn(name = "account_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	@NotNull
	@JoinColumn(name = "card_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Card card;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public List<UserNews> userNews;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private List<UserFeature> userFeatures;
}
