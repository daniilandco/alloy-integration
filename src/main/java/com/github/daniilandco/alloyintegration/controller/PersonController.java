package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloyintegration.dto.model.request.EntityDTO;
import com.github.daniilandco.alloyintegration.dto.model.response.RestResponse;
import com.github.daniilandco.alloyintegration.dto.model.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.PersonAlreadyExistsException;
import com.github.daniilandco.alloyintegration.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/person")
public class PersonController {
    private static final String UNSUCCESS_MSG = "UNSUCCESSFULL API CALL";

    private static final String SUCCESS_MSG = "SUCCESSFULL API CALL";
    private final EntityService entityService;

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify(@RequestBody final EntityDTO request) throws PersonAlreadyExistsException {
        final ResponseEntity<EvaluationDTO> responseFromApi = entityService.verify(request);
        return new ResponseEntity<>(new RestResponse(
                resolveResponseStatus(responseFromApi.getStatusCode()),
                responseFromApi.getBody()
        ), responseFromApi.getStatusCode());
    }

    @GetMapping("/fetch/{token}")
    @ResponseBody
    public ResponseEntity<?> fetch(@PathVariable final String token) {
        final ResponseEntity<com.github.daniilandco.alloyintegration.dto.model.response.entity.EntityDTO> responseFromApi = entityService.fetch(token);
        return new ResponseEntity<>(new RestResponse(
                resolveResponseStatus(responseFromApi.getStatusCode()),
                responseFromApi.getBody()
        ), responseFromApi.getStatusCode());
    }

    private String resolveResponseStatus(final HttpStatus status) {
        return (status.is5xxServerError() || status.is4xxClientError()) ? UNSUCCESS_MSG : SUCCESS_MSG;
    }
}
