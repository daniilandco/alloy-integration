package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Person, String> {
    boolean existsByPhoneNumberOrEmailAddress(String phoneNumber, String emailAddress);
}
