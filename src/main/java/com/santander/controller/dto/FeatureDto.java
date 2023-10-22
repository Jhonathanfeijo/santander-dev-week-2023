package com.santander.controller.dto;

import com.santander.domain.model.baseitem.feature.Feature;

import jakarta.validation.constraints.NotBlank;

public record FeatureDto (@NotBlank String icon, @NotBlank String description) {


		public FeatureDto(Feature feature ) {
			this(feature.getIcon(), feature.getDescription());
		}
		
		public Feature tofeature() {
			Feature feature = new Feature();
			feature.setIcon(this.icon);
			feature.setDescription(this.description);
			return feature;
		}
	}

