package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloyintegration.client.FeignClient;
import com.github.daniilandco.alloyintegration.dto.model.PersonDto;
import com.github.daniilandco.alloyintegration.response.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private final FeignClient restClient;

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify(@RequestBody final PersonDto request) {
        return ResponseEntity
                .ok(new RestResponse(
                        "successful api call",
                        restClient.getEvaluations(request)
                ));

    }
}
