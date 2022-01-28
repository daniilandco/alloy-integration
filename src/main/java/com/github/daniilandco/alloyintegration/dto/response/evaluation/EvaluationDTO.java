package com.github.daniilandco.alloyintegration.dto.response.evaluation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class that represents Evaluation DTO.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EvaluationDTO {
    @JsonProperty("status_code")
    private Long statusCode;
    @JsonProperty("error")
    private String error;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("evaluation_token")
    private String evaluationToken;
    @JsonProperty("entity_token")
    private String entityToken;
    @JsonProperty("application_token")
    private String applicationToken;
    @JsonProperty("summary")
    private SummaryDTO summary;
}
