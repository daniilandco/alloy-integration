package com.github.daniilandco.alloyintegration.dto.response.evaluation;

import java.util.Map;

/**
 * Record which represents main description of evaluation.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
public record SummaryDTO(
        String result,
        Double score,
        String[] tags,
        String outcome,
        Map<String, String> services
) {
}
