package com.github.daniilandco.alloyintegration.service.impl;

import com.github.daniilandco.alloyintegration.client.FeignClient;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseFailureException;
import com.github.daniilandco.alloyintegration.mapper.PersonMapper;
import com.github.daniilandco.alloyintegration.model.EvaluationToken;
import com.github.daniilandco.alloyintegration.model.Person;
import com.github.daniilandco.alloyintegration.repository.EntityRepository;
import com.github.daniilandco.alloyintegration.repository.EvaluationRepository;
import com.github.daniilandco.alloyintegration.service.VerificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class VerificationServiceImpl implements VerificationService {
    private final FeignClient feignClient;
    private final EntityRepository entityRepository;
    private final EvaluationRepository evaluationRepository;
    private final PersonMapper personMapper;

    public ResponseEntity<EvaluationDTO> verify(final PersonDTO personDTO) throws DatabaseFailureException {
        final Person person = personMapper.toPerson(personDTO);
        final ResponseEntity<EvaluationDTO> response = feignClient.getEvaluations(personDTO);
        final EvaluationDTO responseBody = Objects.requireNonNull(response.getBody());
        person.setEntityToken(responseBody.entity_token());
        EvaluationToken evaluationToken = new EvaluationToken().setEvaluationToken(responseBody.evaluation_token());
        person.getEvaluationTokens().add(evaluationToken);
        this.save(person, evaluationToken);
        return response;
    }

    public void save(final Person person, final EvaluationToken evaluationToken) throws DatabaseFailureException {
        try {
            evaluationRepository.save(evaluationToken);
            entityRepository.save(person);
        } catch (Exception e) {
            evaluationRepository.delete(evaluationToken);
            entityRepository.delete(person);
            throw new DatabaseFailureException(e.getMessage());
        }
    }
}
