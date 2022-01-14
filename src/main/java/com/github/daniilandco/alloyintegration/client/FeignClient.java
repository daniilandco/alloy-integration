package com.github.daniilandco.alloyintegration.client;

import com.github.daniilandco.alloyintegration.config.FeignClientConfiguration;
import com.github.daniilandco.alloyintegration.request.PersonRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.cloud.openfeign.FeignClient(
        value = "${feign.client.name}",
        url = "${alloy.api.baseUrl}",
        configuration = FeignClientConfiguration.class
)
public interface FeignClient {
    @PostMapping(value = "/evaluations")
    Object getEvaluations(@RequestBody final PersonRequest request);
}