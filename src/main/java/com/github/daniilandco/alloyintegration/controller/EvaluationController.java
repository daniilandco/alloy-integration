package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.RestResponse;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseFailureException;
import com.github.daniilandco.alloyintegration.service.VerificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/person")
public class EvaluationController {
    private static final String UNSUCCESS_MSG = "UNSUCCESSFULL API CALL";
    private static final String SUCCESS_MSG = "SUCCESSFULL API CALL";

    private final VerificationService verificationService;

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify(@RequestBody final PersonDTO request) throws DatabaseFailureException {
        final ResponseEntity<EvaluationDTO> responseFromApi = verificationService.verify(request);
        return ResponseEntity
                .ok()
                .body(
                        new RestResponse(
                                resolveResponseStatus(responseFromApi.getStatusCode()),
                                responseFromApi.getBody())
                );
    }

    private String resolveResponseStatus(final HttpStatus status) {
        return (status.is5xxServerError() || status.is4xxClientError()) ? UNSUCCESS_MSG : SUCCESS_MSG;
    }
}
