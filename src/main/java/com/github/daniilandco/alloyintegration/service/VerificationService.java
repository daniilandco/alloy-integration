package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseFailureException;
import com.github.daniilandco.alloyintegration.model.EvaluationToken;
import com.github.daniilandco.alloyintegration.model.Person;
import org.springframework.http.ResponseEntity;

public interface VerificationService {
    ResponseEntity<EvaluationDTO> verify(final PersonDTO personDTO) throws DatabaseFailureException;

    void save(final Person person, final EvaluationToken evaluationToken) throws DatabaseFailureException;
}
