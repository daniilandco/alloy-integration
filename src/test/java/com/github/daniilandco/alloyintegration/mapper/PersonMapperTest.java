package com.github.daniilandco.alloyintegration.mapper;

import com.github.daniilandco.alloyintegration.AlloyIntegrationApplicationTests;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.model.Person;
import com.github.daniilandco.alloyintegration.util.MockDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest extends AlloyIntegrationApplicationTests {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private MockDataGenerator mockDataGenerator;

    @Test
    public void givenValid_whenMapToPerson_thenValid() {
        PersonDTO personDTO = mockDataGenerator.generateValidPersonDTO();
        Person person = personMapper.toPerson(personDTO);
        assertAll(
                () -> assertNotNull(person),
                () -> assertEquals(personDTO.getFirstName(), person.getFirstName()),
                () -> assertEquals(personDTO.getLastName(), person.getLastName()),
                () -> assertEquals(personDTO.getPhoneNumber(), person.getPhoneNumber()),
                () -> assertEquals(personDTO.getEmailAddress(), person.getEmailAddress()),
                () -> assertEquals(personDTO.getDocumentSSN(), person.getDocumentSSN()),
                () -> assertNotNull(person.getEvaluationTokens())
        );
    }
}