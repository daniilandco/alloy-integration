package com.github.daniilandco.alloyintegration.dto.model.response.evaluation.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServicesFormatted(
        @JsonProperty("Emailage")
        Object emailage,
        @JsonProperty("White Pages Pro")
        Object whitePagesPro,
        @JsonProperty("Socure")
        Object socure
) {
}
