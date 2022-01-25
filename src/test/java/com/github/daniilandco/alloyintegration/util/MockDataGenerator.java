package com.github.daniilandco.alloyintegration.util;

import com.github.daniilandco.alloyintegration.dto.request.AddressDTO;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import org.springframework.stereotype.Service;
import org.vaadin.artur.exampledata.ChanceIntegerType;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class MockDataGenerator {
    public PersonDTO generateValidPersonDTO() {
        var generator = new ExampleDataGenerator<>(PersonDTO.class, LocalDateTime.now());
        generator.setData(PersonDTO::setFirstName, DataType.FIRST_NAME);
        generator.setData(PersonDTO::setLastName, DataType.LAST_NAME);
        generator.setData(PersonDTO::setEmailAddress, DataType.EMAIL);
        generator.setData(PersonDTO::setPhoneNumber, DataType.PHONE_NUMBER);
        generator.setData(PersonDTO::setBirthDate, DataType.DATE_OF_BIRTH);
        generator.setData(PersonDTO::setDocumentSSN, new ChanceIntegerType("integer", "{min: 100000000, max: 999999999}"));
        return generator.createBean(new Random().nextInt())
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
        return generator.createBean(new Random().nextInt());
    }

    public String generateRandomString() {
        return UUID.randomUUID().toString();
    }
}
