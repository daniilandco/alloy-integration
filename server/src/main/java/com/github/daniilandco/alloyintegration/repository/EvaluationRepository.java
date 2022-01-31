package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.model.EvaluationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface which gives us access to database for manipulating with evaluation model.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
public interface EvaluationRepository extends MongoRepository<EvaluationToken, String> {
}
