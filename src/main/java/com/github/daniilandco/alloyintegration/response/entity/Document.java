package com.github.daniilandco.alloyintegration.response.entity;

public record Document(
        String document_token,
        Long timestamp,
        String type,
        String name
) {
}
