package com.github.daniilandco.alloyintegration.dto.model.response.evaluation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServicesInfo<T>(
        @JsonProperty("Emailage")
        T emailage,
        @JsonProperty("Socure")
        T socure,
        @JsonProperty("White Pages Pro")
        T whitePagesPro
) {
}
