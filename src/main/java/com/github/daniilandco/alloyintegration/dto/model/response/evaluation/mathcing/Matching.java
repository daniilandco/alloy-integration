package com.github.daniilandco.alloyintegration.dto.model.response.evaluation.mathcing;

public record Matching(
        MatchInfo name,
        MatchInfo phone,
        MatchInfo address,
        MatchInfo email,
        MatchInfo ssn,
        MatchInfo dob
) {
}
