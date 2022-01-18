package com.github.daniilandco.alloyintegration.response.entity;

public record EntityResponse(
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
