package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.exception.PersonRequestIsNullException;
import com.github.daniilandco.alloyintegration.util.MockDataGenerator;
import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@ActiveProfiles("test")
class VerificationServiceTest {
    @Autowired
    private VerificationService verificationService;
    @Autowired
    private MockDataGenerator mockDataGenerator;

    @Test
    public void givenValidPersonDTO_whenVerify_thenReturnNonNullResponse() throws DatabaseTransactionFailureException, PersonRequestIsNullException {
        PersonDTO personDTO = mockDataGenerator.generateValidPersonDTO();
        ResponseEntity<EvaluationDTO> result = verificationService.verify(personDTO);
        Assertions.assertNotNull(result);
    }

    @Test
    public void givenAnyInvalidPersonDTO_whenVerify_thenExceptionsThrown() {
        PersonDTO personDTO = mockDataGenerator.generateValidPersonDTO();
        assertAll(
                () -> assertThrows(PersonRequestIsNullException.class, () -> verificationService.verify(null)),
                () -> assertThrows(FeignException.class, () -> verificationService.verify(personDTO.setDocumentSSN(-1))),
                () -> assertThrows(FeignException.class, () -> verificationService.verify(personDTO.setEmailAddress("Not_Email_At_ALL")))
        );
    }
}