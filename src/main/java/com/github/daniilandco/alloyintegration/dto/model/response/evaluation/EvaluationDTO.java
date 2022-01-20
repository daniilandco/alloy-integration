package com.github.daniilandco.alloyintegration.dto.model.response.evaluation;

import com.github.daniilandco.alloyintegration.dto.model.response.evaluation.mathcing.Matching;
import com.github.daniilandco.alloyintegration.dto.model.response.evaluation.social.Social;

public record EvaluationDTO(
        Long status_code,
        String error,
        Long timestamp,
        String evaluation_token,
        String entity_token,
        String application_token,
        String application_version_id,
        Summary summary,
        EntityInfo supplied,
        EntityInfo formatted,
        Matching matching,
        Diligence diligence,
        Social related_data,
        ServicesInfo<Object[]> raw_responses,
        ServicesInfo<Object> formatted_responses,
        String audit_archive
) {
}
