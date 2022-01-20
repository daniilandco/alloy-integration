package com.github.daniilandco.alloyintegration.dto.model.response.evaluation.mathcing;


public record MatchInfo(
        Double score,
        String[] matched,
        String[] unmatched
) {
}
