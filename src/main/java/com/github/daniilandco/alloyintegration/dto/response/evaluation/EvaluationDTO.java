package com.github.daniilandco.alloyintegration.dto.response.evaluation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Record which represents Evaluation DTO.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record EvaluationDTO(
        Long status_code,
        String error,
        Long timestamp,
        String evaluation_token,
        String entity_token,
        String application_token,
        String application_version_id,
        SummaryDTO summary,
//        Object required,
//        Object optional,
        String audit_archive
) {
}
