package com.github.daniilandco.alloyintegration.client;

import com.github.daniilandco.alloyintegration.config.FeignClientConfig;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Interface with functionality to call external Alloy API.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@org.springframework.cloud.openfeign.FeignClient(
        value = "${feign.client.name}",
        url = "${alloy.api.baseUrl}",
        configuration = FeignClientConfig.class
)
public interface FeignClient {
    /**
     * This method always returns Response from Alloy API either it is successful or not.
     *
     * @param request body for post request as Person DTO which is consumed by Alloy API
     * @return ResponseEntity with EvaluationDTO as body
     * @see EvaluationDTO
     * @see PersonDTO
     */
    @PostMapping(value = "/evaluations")
    ResponseEntity<EvaluationDTO> getEvaluations(@RequestBody final PersonDTO request);
}