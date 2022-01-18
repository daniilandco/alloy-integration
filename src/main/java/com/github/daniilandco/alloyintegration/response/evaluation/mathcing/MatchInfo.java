package com.github.daniilandco.alloyintegration.response.evaluation.mathcing;


public record MatchInfo(
        Double score,
        String[] matched,
        String[] unmatched
) {
}
