package com.github.daniilandco.alloyintegration.service.impl;

import com.github.daniilandco.alloyintegration.client.FeignClient;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.mapper.PersonMapper;
import com.github.daniilandco.alloyintegration.model.EvaluationToken;
import com.github.daniilandco.alloyintegration.model.Person;
import com.github.daniilandco.alloyintegration.repository.EvaluationRepository;
import com.github.daniilandco.alloyintegration.repository.PersonRepository;
import com.github.daniilandco.alloyintegration.service.VerificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Class implementation of VerificationService interface.
 *
 * @author com.github.daniilandco
 * @version 1.0
 * @see VerificationService
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class VerificationServiceImpl implements VerificationService {
    private final FeignClient feignClient;
    private final PersonRepository personRepository;
    private final EvaluationRepository evaluationRepository;
    private final PersonMapper personMapper;


    /**
     * Returns ResponseEntity with EvaluationDTO as body.
     * <p>
     * This method calls Alloy API via FeignClient, then creates transaction to a database.
     * If transaction is not successful it throws DatabaseTransactionFailureException.
     *
     * @param personDTO body for post request as Person DTO which is consumed by Alloy API
     * @return ResponseEntity with EvaluationDTO as body
     * @see EvaluationDTO
     * @see PersonDTO
     * @see FeignClient
     * @see VerificationService
     */
    public ResponseEntity<EvaluationDTO> verify(final PersonDTO personDTO) throws DatabaseTransactionFailureException {
        final Person person = personMapper.toPerson(personDTO);
        final ResponseEntity<EvaluationDTO> response = feignClient.getEvaluations(personDTO);
        final EvaluationDTO responseBody = Objects.requireNonNull(response.getBody());
        person.setEntityToken(responseBody.entity_token());
        EvaluationToken evaluationToken = new EvaluationToken().setEvaluationToken(responseBody.evaluation_token());
        person.getEvaluationTokens().add(evaluationToken);
        this.save(person, evaluationToken);
        return response;
    }

    /**
     * This method saves person and evaulation token models to a database by using transaction.
     * If during transaction there was an exception it generates new DatabaseTransactionFailureException
     * which will be handled by global exception handler.
     *
     * @param person          person model for storing in a database.
     * @param evaluationToken evaluationToken model for storing in a database.
     * @see DatabaseTransactionFailureException
     */
    private void save(final Person person, final EvaluationToken evaluationToken) throws DatabaseTransactionFailureException {
        try {
            evaluationRepository.save(evaluationToken);
            personRepository.save(person);
        } catch (Exception e) {
            throw new DatabaseTransactionFailureException("could not persist given person and evaluation token");
        }
    }
}
