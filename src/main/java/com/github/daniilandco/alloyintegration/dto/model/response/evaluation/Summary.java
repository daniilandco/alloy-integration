package com.github.daniilandco.alloyintegration.dto.model.response.evaluation;

import com.github.daniilandco.alloyintegration.dto.model.response.evaluation.services.ServicesInfo;

public record Summary(
        String result,
        Double score,
        String[] tags,
        String outcome,
        ServicesInfo services
) {
}
