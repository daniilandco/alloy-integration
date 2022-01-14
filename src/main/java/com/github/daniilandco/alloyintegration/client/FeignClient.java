package com.github.daniilandco.alloyintegration.client;

import com.github.daniilandco.alloyintegration.config.FeignClientConfiguration;
import com.github.daniilandco.alloyintegration.dto.model.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.cloud.openfeign.FeignClient(
        value = "${feign.client.name}",
        url = "${alloy.api.baseUrl}",
        configuration = FeignClientConfiguration.class
)
public interface FeignClient {
    @PostMapping(value = "/evaluations")
    Object getEvaluations(@RequestBody final PersonDto request);
}