package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloy_integration.request.PersonRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestService {
    private final WebClient webClient;

    public RestService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Object getEvaluations(PersonRequest personRequest) {
        // send POST request and return response
        return this.webClient
                .post()
                .uri("/evaluations")
                .body(Mono.just(personRequest), PersonRequest.class)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}
