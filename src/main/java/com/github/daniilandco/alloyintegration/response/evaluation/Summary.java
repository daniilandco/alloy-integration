package com.github.daniilandco.alloyintegration.response.evaluation;

import com.github.daniilandco.alloyintegration.response.evaluation.services.ServicesInfo;

public record Summary(
        String result,
        Double score,
        String[] tags,
        String outcome,
        ServicesInfo services
) {
}
