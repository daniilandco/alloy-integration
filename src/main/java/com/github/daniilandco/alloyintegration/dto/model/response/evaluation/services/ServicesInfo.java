package com.github.daniilandco.alloyintegration.dto.model.response.evaluation.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServicesInfo(
        @JsonProperty("Emailage")
        String emailage,
        @JsonProperty("Socure")
        String socure,
        @JsonProperty("White Pages Pro")
        String whitePagesPro
) {
}
