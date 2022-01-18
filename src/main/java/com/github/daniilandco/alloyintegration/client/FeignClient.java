package com.github.daniilandco.alloyintegration.client;

import com.github.daniilandco.alloyintegration.config.FeignClientConfiguration;
import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.response.entity.EntityResponse;
import com.github.daniilandco.alloyintegration.response.evaluation.EvaluationResponse;
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
    EvaluationResponse getEvaluations(@RequestBody final PersonDTO request);

    @GetMapping(value = "/entities/{token}")
    EntityResponse getEntityInfo(@PathVariable final String token);
}