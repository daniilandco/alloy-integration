package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.response.RestResponse;
import com.github.daniilandco.alloyintegration.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    private static final String SUCCESS_MSG = "SUCCESSFULL API CALL";

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify(@RequestBody final PersonDTO request) {
        return ResponseEntity
                .ok(new RestResponse(
                        SUCCESS_MSG,
                        personService.verify(request)
                ));
    }

    @GetMapping("/fetch/{token}")
    @ResponseBody
    public ResponseEntity<?> fetch(@PathVariable final String token) {
        return ResponseEntity
                .ok(new RestResponse(
                        SUCCESS_MSG,
                        personService.fetch(token)
                ));
    }
}
