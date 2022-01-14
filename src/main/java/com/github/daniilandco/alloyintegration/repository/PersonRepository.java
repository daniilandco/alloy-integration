package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
