package com.github.daniilandco.alloyintegration.response.evaluation;

public record Fraud(
        Double score,
        String[] flags
) {
}
