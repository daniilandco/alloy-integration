package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.exception.PersonAlreadyExistsException;
import com.github.daniilandco.alloyintegration.response.RestResponse;
import com.github.daniilandco.alloyintegration.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/person")
public class PersonController {
    private final PersonService personService;

    private static final String SUCCESS_MSG = "SUCCESSFULL API CALL";

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify(@RequestBody final PersonDTO request) throws PersonAlreadyExistsException {
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
