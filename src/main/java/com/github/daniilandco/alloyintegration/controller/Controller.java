package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloy_integration.request.PersonRequest;
import com.github.daniilandco.alloy_integration.response.RestResponse;
import com.github.daniilandco.alloy_integration.service.RestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final RestService restService;

    public Controller(RestService restService) {
        this.restService = restService;
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody PersonRequest request) {
        return ResponseEntity
                .ok(new RestResponse("successful api call", restService.getEvaluations(request)));
    }
}
