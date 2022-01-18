package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.client.FeignClient;
import com.github.daniilandco.alloyintegration.dto.mapper.PersonMapper;
import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.entity.Person;
import com.github.daniilandco.alloyintegration.exception.PersonAlreadyExistsException;
import com.github.daniilandco.alloyintegration.repository.PersonRepository;
import com.github.daniilandco.alloyintegration.response.entity.EntityResponse;
import com.github.daniilandco.alloyintegration.response.evaluation.EvaluationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final FeignClient feignClient;
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public EvaluationResponse verify(final PersonDTO personDTO) throws PersonAlreadyExistsException {
        Person person = personMapper.toPerson(personDTO);
        this.save(person);
        return feignClient.getEvaluations(personDTO);
    }

    public void save(Person person) throws PersonAlreadyExistsException {
        if (!personRepository
                .existsByPhoneNumberOrEmailAddress(person.getPhoneNumber(), person.getEmailAddress())) {
            personRepository.save(person);
        } else {
            throw new PersonAlreadyExistsException(String.format(
                    "Person entity with email: %s or phone number: %s already exists",
                    person.getEmailAddress(),
                    person.getPhoneNumber()
            ));
        }
    }

    public EntityResponse fetch(final String token) {
        return feignClient.getEntityInfo(token);
    }
}
