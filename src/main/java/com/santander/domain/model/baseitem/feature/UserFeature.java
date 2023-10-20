package com.santander.domain.model.baseitem.feature;

import com.santander.domain.model.baseitem.UserItens;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_feature")
@Setter
@Getter
public class UserFeature extends UserItens {

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinColumn(name = "feature_id")
	private Feature feature;

}
