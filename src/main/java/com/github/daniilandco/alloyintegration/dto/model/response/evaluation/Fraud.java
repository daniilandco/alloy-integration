package com.github.daniilandco.alloyintegration.dto.model.response.evaluation;

public record Fraud(
        Double score,
        String[] flags
) {
}
