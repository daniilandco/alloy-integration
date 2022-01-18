package com.github.daniilandco.alloyintegration.response.entity;

public record Review(
        String review_token,
        String outcome,
        String reason,
        String application_name,
        Long timestamp,
        String reviewer
) {
}
