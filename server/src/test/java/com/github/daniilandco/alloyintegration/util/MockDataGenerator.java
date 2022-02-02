package com.github.daniilandco.alloyintegration.util;

import com.github.daniilandco.alloyintegration.dto.request.AddressDTO;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import org.springframework.stereotype.Service;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MockDataGenerator {
    private final static Random randomizer = new Random();

    public PersonDTO generateValidPersonDTO() {
        var generator = new ExampleDataGenerator<>(PersonDTO.class, LocalDateTime.now());
        generator.setData(PersonDTO::setFirstName, DataType.FIRST_NAME);
        generator.setData(PersonDTO::setLastName, DataType.LAST_NAME);
        generator.setData(PersonDTO::setEmailAddress, DataType.EMAIL);
        generator.setData(PersonDTO::setPhoneNumber, DataType.PHONE_NUMBER);
        generator.setData(PersonDTO::setBirthDate, DataType.DATE_OF_BIRTH);
        return generator.createBean(randomizer.nextInt())
                .setDocumentSSN(String.format("%09d", randomizer.nextInt(1000000000)))
                .setAddressDTO(generateValidAddressDTO());
    }

    public AddressDTO generateValidAddressDTO() {
        var generator = new ExampleDataGenerator<>(AddressDTO.class, LocalDateTime.now());
        generator.setData(AddressDTO::setAddressCity, DataType.CITY);
        generator.setData(AddressDTO::setAddressLine1, DataType.ADDRESS);
        generator.setData(AddressDTO::setAddressLine2, DataType.ADDRESS);
        generator.setData(AddressDTO::setAddressState, DataType.STATE);
        generator.setData(AddressDTO::setAddressCountryCode, DataType.COUNTRY);
        generator.setData(AddressDTO::setAddressPostalCode, DataType.ZIP_CODE);
        return generator.createBean(randomizer.nextInt());
    }

    public EvaluationDTO generateValidEvaluationDTO() {
        var generator = new ExampleDataGenerator<>(EvaluationDTO.class, LocalDateTime.now());
        generator.setData(EvaluationDTO::setEvaluationToken, DataType.WORD);
        generator.setData(EvaluationDTO::setApplicationToken, DataType.WORD);
        generator.setData(EvaluationDTO::setEntityToken, DataType.WORD);
        return generator.createBean(randomizer.nextInt())
                .setStatusCode(randomizer.nextLong())
                .setTimestamp(randomizer.nextLong());
    }
}
