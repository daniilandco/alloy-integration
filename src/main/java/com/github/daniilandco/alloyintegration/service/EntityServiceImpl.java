package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.client.FeignClient;
import com.github.daniilandco.alloyintegration.dto.mapper.EntityMapper;
import com.github.daniilandco.alloyintegration.dto.model.request.EntityDTO;
import com.github.daniilandco.alloyintegration.dto.model.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.entity.Entity;
import com.github.daniilandco.alloyintegration.entity.EvaluationToken;
import com.github.daniilandco.alloyintegration.repository.AddressRepository;
import com.github.daniilandco.alloyintegration.repository.EntityRepository;
import com.github.daniilandco.alloyintegration.repository.EvaluationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EntityServiceImpl implements EntityService {
    private final FeignClient feignClient;
    private final EntityRepository entityRepository;
    private final AddressRepository addressRepository;
    private final EvaluationRepository evaluationRepository;
    private final EntityMapper entityMapper;

    public ResponseEntity<EvaluationDTO> verify(final EntityDTO entityDTO) {
        final Entity entity = entityMapper.toPerson(entityDTO);
        final ResponseEntity<EvaluationDTO> response = feignClient.getEvaluations(entityDTO);
        final EvaluationDTO responseBody = Objects.requireNonNull(response.getBody());
        entity.setEntityToken(responseBody.entity_token());
        EvaluationToken evaluationToken = new EvaluationToken().setEvaluationToken(responseBody.evaluation_token());
        entity.getEvaluationTokens().add(evaluationToken);
        this.save(entity, evaluationToken);
        return response;
    }

    public void save(final Entity entity, final EvaluationToken evaluationToken) {
        evaluationRepository.save(evaluationToken);
        addressRepository.save(entity.getAddress());
        entityRepository.save(entity);
    }

    public ResponseEntity<com.github.daniilandco.alloyintegration.dto.model.response.entity.EntityDTO> fetch(final String token) {
        return feignClient.getEntityEvaluation(token);
    }
}
