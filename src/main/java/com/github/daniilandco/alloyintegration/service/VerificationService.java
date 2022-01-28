package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.service.impl.VerificationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Interface for verifying person using Alloy API integration.
 *
 * @author com.github.daniilandco
 * @version 1.0
 * @see VerificationServiceImpl
 */
@Validated
public interface VerificationService {
    ResponseEntity<EvaluationDTO> verify(@Valid @NotNull final PersonDTO personDTO) throws DatabaseTransactionFailureException;
}
