package com.github.daniilandco.alloyintegration.dto.response.evaluation;

/**
 * Record which represents Evaluation DTO.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
public record EvaluationDTO(
        Long status_code,
        String error,
        Long timestamp,
        String evaluation_token,
        String entity_token,
        String application_token,
        String application_version_id,
        SummaryDTO summary,
        String audit_archive
) {
}
