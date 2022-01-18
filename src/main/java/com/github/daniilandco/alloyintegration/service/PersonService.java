package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.entity.Person;
import com.github.daniilandco.alloyintegration.exception.PersonAlreadyExistsException;
import com.github.daniilandco.alloyintegration.response.entity.EntityResponse;
import com.github.daniilandco.alloyintegration.response.evaluation.EvaluationResponse;

public interface PersonService {
    EvaluationResponse verify(final PersonDTO personDTO) throws PersonAlreadyExistsException;

    EntityResponse fetch(final String token);

    void save(final Person person) throws PersonAlreadyExistsException;
}
