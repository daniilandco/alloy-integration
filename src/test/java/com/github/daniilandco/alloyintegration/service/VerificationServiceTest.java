package com.github.daniilandco.alloyintegration.service;

import com.github.daniilandco.alloyintegration.client.FeignClient;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.dto.response.evaluation.EvaluationDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.mapper.PersonMapper;
import com.github.daniilandco.alloyintegration.repository.EvaluationRepository;
import com.github.daniilandco.alloyintegration.repository.PersonRepository;
import com.github.daniilandco.alloyintegration.service.impl.VerificationServiceImpl;
import com.github.daniilandco.alloyintegration.util.MockDataGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolationException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ActiveProfiles("test")
@Validated
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VerificationServiceTest {
    @Autowired
    private VerificationService verificationService;
    private static VerificationService mockVerificationService;
    private static EvaluationDTO mockEvaluationDTO;
    private static PersonDTO mockPersonDTO;
    @Autowired
    private MockDataGenerator mockDataGenerator;
    @MockBean
    private FeignClient feignClient;
    @Mock
    private EvaluationRepository evaluationRepository;

    @BeforeAll
    public void setUp(@Autowired PersonMapper personMapper, @Autowired PersonRepository personRepository) {
        mockVerificationService = new VerificationServiceImpl(feignClient, personRepository, evaluationRepository, personMapper);
    }

    @BeforeEach
    public void init() {
        mockEvaluationDTO = new EvaluationDTO().setEvaluationToken(UUID.randomUUID().toString());
        mockPersonDTO = mockDataGenerator.generateValidPersonDTO();
    }

    @Test
    public void givenValid_whenVerify_thenResponse() throws DatabaseTransactionFailureException {
        given(feignClient.getEvaluations(Mockito.any(PersonDTO.class)))
                .willReturn(new ResponseEntity<>(mockEvaluationDTO, HttpStatus.CREATED));

        ResponseEntity<EvaluationDTO> result = verificationService.verify(mockPersonDTO);

        assertAll(
                () -> assertNotNull(result),
                () -> assertTrue(result.getStatusCode().is2xxSuccessful()),
                () -> assertTrue(result.hasBody())
        );
    }

    @Test
    public void givenInvalid_whenVerify_thenException() {
        assertAll(
                () -> assertThrows(ConstraintViolationException.class, () -> verificationService.verify(null)),
                () -> assertThrows(ConstraintViolationException.class, () -> verificationService.verify(mockPersonDTO.setDocumentSSN("-1"))),
                () -> assertThrows(ConstraintViolationException.class, () -> verificationService.verify(mockPersonDTO.setEmailAddress("Not_Email_At_ALL")))
        );
    }

    @Test
    public void givenTransactionError_whenVerify_thenTransactionFailureException() {
        given(feignClient.getEvaluations(Mockito.any(PersonDTO.class)))
                .willReturn(new ResponseEntity<>(mockEvaluationDTO.setEvaluationToken(null), HttpStatus.CREATED));
        assertThrows(DatabaseTransactionFailureException.class, () -> mockVerificationService.verify(mockPersonDTO));
    }
}