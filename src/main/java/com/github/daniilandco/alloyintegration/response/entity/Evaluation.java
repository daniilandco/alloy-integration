package com.github.daniilandco.alloyintegration.response.entity;

public record Evaluation(
        String evaluation_token,
        Long timestamp,
        String status,
        String application_name,
        String outcome
) {
}