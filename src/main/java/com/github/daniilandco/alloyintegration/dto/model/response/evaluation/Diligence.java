package com.github.daniilandco.alloyintegration.dto.model.response.evaluation;

public record Diligence(
        WatchLists watchlists,
        Fraud fraud,
        String financial,
        String identity_questions
) {
}
