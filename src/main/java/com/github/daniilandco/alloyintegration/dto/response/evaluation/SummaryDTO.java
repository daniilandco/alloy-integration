package com.github.daniilandco.alloyintegration.dto.response.evaluation;

public record SummaryDTO(
        String result,
        Double score,
        String[] tags,
        String outcome,
        ServicesInfoDTO<String> services
) {
}
