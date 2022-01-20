package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
