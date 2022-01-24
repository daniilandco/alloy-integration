package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.service.impl.VerificationServiceImpl;
import org.springframework.http.ResponseEntity;

/**
 * Interface for verifying person using Alloy API integration.
 *
 * @author com.github.daniilandco
 * @version 1.0
 * @see VerificationServiceImpl
 */
public interface VerificationService {
    ResponseEntity<EvaluationDTO> verify(final PersonDTO personDTO) throws DatabaseTransactionFailureException;
}
