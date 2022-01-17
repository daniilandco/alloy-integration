package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.client.FeignClient;
import com.github.daniilandco.alloyintegration.dto.mapper.PersonMapper;
import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.entity.Person;
import com.github.daniilandco.alloyintegration.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {
    private final FeignClient feignClient;
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public Object verify(final PersonDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);
        personRepository.save(person);
        return feignClient.getEvaluations(personDTO);
    }

    public Object fetch(String token) {
        return feignClient.getEntityInfo(token);
    }
}
