package com.github.daniilandco.alloyintegration.client;

import com.github.daniilandco.alloyintegration.config.FeignClientConfiguration;
import com.github.daniilandco.alloyintegration.dto.model.request.EntityDTO;
import com.github.daniilandco.alloyintegration.dto.model.response.evaluation.EvaluationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.cloud.openfeign.FeignClient(
        value = "${feign.client.name}",
        url = "${alloy.api.baseUrl}",
        configuration = FeignClientConfiguration.class
)
public interface FeignClient {
    @PostMapping(value = "/evaluations")
    ResponseEntity<EvaluationDTO> getEvaluations(@RequestBody final EntityDTO request);

    @GetMapping(value = "/entities/{entity_token}")
    ResponseEntity<com.github.daniilandco.alloyintegration.dto.model.response.entity.EntityDTO> getEntityEvaluation(@PathVariable final String entity_token);
}