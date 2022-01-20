package com.github.daniilandco.alloyintegration.dto.model.response.evaluation;

public record Summary(
        String result,
        Double score,
        String[] tags,
        String outcome,
        ServicesInfo<String> services
) {
}
