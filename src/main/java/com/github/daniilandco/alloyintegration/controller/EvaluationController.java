package com.github.daniilandco.alloyintegration.controller;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.RestResponseWrapper;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.exception.PersonRequestIsNullException;
import com.github.daniilandco.alloyintegration.service.VerificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling a person verifying  requests.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class EvaluationController {
    private final VerificationService verificationService;

    /**
     * Returns ResponseEntity if Alloy API call was successful.
     * If not Exception will be caught by GlobalExceptionHandler and processed there.
     *
     * @param request body for post request as Person DTO
     * @return ResponseEntity with RestResponseWrapper as body which contains EvaluationDTO
     * @see EvaluationDTO
     * @see PersonDTO
     * @see com.github.daniilandco.alloyintegration.advice.GlobalExceptionHandler
     */
    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify(@RequestBody(required = false) final PersonDTO request) throws DatabaseTransactionFailureException, PersonRequestIsNullException {
        final ResponseEntity<EvaluationDTO> responseFromApi = verificationService.verify(request);
        return ResponseEntity.ok().body(new RestResponseWrapper<>(HttpStatus.OK.toString(), responseFromApi.getBody()));
    }
}
