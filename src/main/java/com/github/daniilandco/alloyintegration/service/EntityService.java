package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.dto.model.request.EntityDTO;
import com.github.daniilandco.alloyintegration.dto.model.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.entity.Entity;
import com.github.daniilandco.alloyintegration.entity.EvaluationToken;
import com.github.daniilandco.alloyintegration.exception.PersonAlreadyExistsException;
import org.springframework.http.ResponseEntity;

public interface EntityService {
    ResponseEntity<EvaluationDTO> verify(final EntityDTO entityDTO) throws PersonAlreadyExistsException;

    ResponseEntity<com.github.daniilandco.alloyintegration.dto.model.response.entity.EntityDTO> fetch(final String token);

    void save(final Entity entity, final EvaluationToken evaluationToken);
}
