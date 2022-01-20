package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Entity, String> {
    boolean existsByPhoneNumberOrEmailAddress(String phoneNumber, String emailAddress);
}
