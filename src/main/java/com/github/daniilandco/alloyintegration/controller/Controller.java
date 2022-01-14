package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.response.RestResponse;
import com.github.daniilandco.alloyintegration.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private final PersonService personService;

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify(@RequestBody final PersonDTO request) {
        return ResponseEntity
                .ok(new RestResponse(
                        "successful api call",
                        personService.verify(request)
                ));
    }
}
