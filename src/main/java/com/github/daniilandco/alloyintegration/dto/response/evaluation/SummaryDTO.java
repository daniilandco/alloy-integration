package com.github.daniilandco.alloyintegration.dto.response.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * Class which represents main description of evaluation.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SummaryDTO {
    private String result;
    private Double score;
    private String[] tags;
    private String outcome;
    private Map<String, String> services;
}
