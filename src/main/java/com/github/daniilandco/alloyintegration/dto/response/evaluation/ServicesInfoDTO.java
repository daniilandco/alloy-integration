package com.github.daniilandco.alloyintegration.dto.response.evaluation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServicesInfoDTO<T>(
        @JsonProperty("Emailage")
        T emailage,
        @JsonProperty("Socure 25")
        T socure,
        @JsonProperty("White Pages Pro")
        T whitePagesPro,
        @JsonProperty("Lexis Nexis Instant ID")
        T lexisNexisInstantID
) {
}
