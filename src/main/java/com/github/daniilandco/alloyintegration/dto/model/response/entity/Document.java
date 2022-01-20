package com.github.daniilandco.alloyintegration.dto.model.response.entity;

public record Document(
        String document_token,
        Long timestamp,
        String type,
        String name
) {
}
