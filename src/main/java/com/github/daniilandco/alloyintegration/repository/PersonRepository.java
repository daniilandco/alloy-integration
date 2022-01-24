package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface which gives us access to database for manipulating with person model.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
