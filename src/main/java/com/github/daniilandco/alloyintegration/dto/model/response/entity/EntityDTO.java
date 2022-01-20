package com.github.daniilandco.alloyintegration.dto.model.response.entity;

public record EntityDTO(
        String name,
        String type,
        String entity_token,
        Boolean archived,
        Long created,
        Evaluation[] evaluations,
        Document[] documents,
        Review[] reviews
) {
}
