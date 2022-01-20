package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.entity.EvaluationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRepository extends MongoRepository<EvaluationToken, String> {
}
