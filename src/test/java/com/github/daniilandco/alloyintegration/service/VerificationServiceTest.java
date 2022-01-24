package com.github.daniilandco.alloyintegration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(properties = {
        "ALLOY_USERNAME=dpDD6z4olOSI7N4fMCsAlKjFa7reBYhu",
        "ALLOY_PASSWORD=oJm3niQX1Pdy4z675kefEIKBgFn9tQ45",
        "MONGO_USERNAME=daniilandco",
        "MONGO_PASSWORD=3n3KS26XrSPnk3f"
})
class VerificationServiceTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private VerificationService verificationService;

    @Test
    public void test() throws JsonProcessingException, DatabaseTransactionFailureException {
        String body = """
                {
                    "name_first":"Ganiel",
                    "name_last":"DoeS",
                    "phone_number":"18042562188",
                    "email_address":"john.doe@example.com",
                    "address_line_1":"41 Elizabeth Street",
                    "address_line_2":"STE 500",
                    "address_city":"New York",
                    "address_state":"NY",
                    "address_postal_code":"10013",
                    "address_country_code":"US",
                    "birth_date":"1985-06-13",
                    "document_ssn":"123456789"
                }""";

        ResponseEntity<EvaluationDTO> result = verificationService.verify(objectMapper.readValue(body, PersonDTO.class));
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

}