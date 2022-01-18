package com.github.daniilandco.alloyintegration.response.evaluation;

import com.github.daniilandco.alloyintegration.response.evaluation.mathcing.Matching;
import com.github.daniilandco.alloyintegration.response.evaluation.services.ServicesFormatted;
import com.github.daniilandco.alloyintegration.response.evaluation.services.ServicesRaw;
import com.github.daniilandco.alloyintegration.response.evaluation.social.Social;

public record EvaluationResponse(
        Long status_code,
        String error,
        Long timestamp,
        String evaluation_token,
        String entity_token,
        String application_token,
        String application_version_id,
        Summary summary,
        PersonInfo supplied,
        PersonInfo formatted,
        Matching matching,
        Diligence diligence,
        Social related_data,
        ServicesRaw raw_responses,
        ServicesFormatted formatted_responses,
        String audit_archive
) {
}
