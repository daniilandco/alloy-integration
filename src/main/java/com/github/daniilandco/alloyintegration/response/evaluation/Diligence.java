package com.github.daniilandco.alloyintegration.response.evaluation;

public record Diligence(
        WatchLists watchlists,
        Fraud fraud,
        String financial,
        String identity_questions
) {
}
