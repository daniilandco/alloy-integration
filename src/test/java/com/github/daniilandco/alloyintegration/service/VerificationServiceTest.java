package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.AlloyIntegrationApplicationTests;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.exception.PersonRequestIsNullException;
import com.github.daniilandco.alloyintegration.util.MockDataGenerator;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceTest extends AlloyIntegrationApplicationTests {
    @Autowired
    private VerificationService verificationService;
    @Autowired
    private MockDataGenerator mockDataGenerator;

    @Test
    public void givenValid_whenVerify_thenValid() throws DatabaseTransactionFailureException, PersonRequestIsNullException {
        PersonDTO personDTO = mockDataGenerator.generateValidPersonDTO();
        ResponseEntity<EvaluationDTO> result = verificationService.verify(personDTO);
        assertAll(
                () -> assertNotNull(result),
                () -> assertTrue(result.getStatusCode().is2xxSuccessful()),
                () -> assertTrue(result.hasBody())
        );
    }

    @Test
    public void givenInvalid_whenVerify_thenException() {
        PersonDTO personDTO = mockDataGenerator.generateValidPersonDTO();
        assertAll(
                () -> assertThrows(PersonRequestIsNullException.class, () -> verificationService.verify(null)),
                () -> assertThrows(FeignException.class, () -> verificationService.verify(personDTO.setDocumentSSN("-1"))),
                () -> assertThrows(FeignException.class, () -> verificationService.verify(personDTO.setEmailAddress("Not_Email_At_ALL")))
        );
    }
}