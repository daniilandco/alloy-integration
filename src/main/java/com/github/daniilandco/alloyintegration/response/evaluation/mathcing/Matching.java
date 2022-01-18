package com.github.daniilandco.alloyintegration.response.evaluation.mathcing;

public record Matching(
        MatchInfo name,
        MatchInfo phone,
        MatchInfo address,
        MatchInfo email,
        MatchInfo ssn,
        MatchInfo dob
) {
}
