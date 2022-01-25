package com.github.daniilandco.alloyintegration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.util.MockDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class EvaluationControllerTest {
    private static final String VERIFY_ENDPOINT = "/api/v1/verify";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockDataGenerator mockDataGenerator;

    @Test
    public void givenValidPersonDTO_whenVerify_thenReturnValidEvaluationDTO() throws Exception {
        final PersonDTO requestBody = mockDataGenerator.generateValidPersonDTO();
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonValidResponse("body"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenInvalidPersonDTO_whenVerify_thenPersonRequestIsNullException() throws Exception {
        this.mockMvc.perform(postJson(null))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponses("$"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenPersonDTOWithWrongEmailAddressFormat_whenVerify_thenReturnClientError() throws Exception {
        final PersonDTO requestBody = mockDataGenerator.generateValidPersonDTO()
                .setEmailAddress("WrongEmailAddressFormat!");
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponses("$"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenPersonDTOWithDocumentSSNFormat_whenVerify_thenReturnClientError() throws Exception {
        final PersonDTO requestBody = mockDataGenerator.generateValidPersonDTO()
                .setDocumentSSN(0);
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponses("$"))
                .andExpect(status().isBadRequest());

        requestBody.setDocumentSSN(12345678);
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponses("$"))
                .andExpect(status().isBadRequest());

        requestBody.setDocumentSSN(1234567890);
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponses("$"))
                .andExpect(status().isBadRequest());
    }


    private ResultMatcher[] validateJsonValidResponse(String prefix) {
        return new ResultMatcher[]{
                jsonPath(prefix + ".status_code").hasJsonPath(),
                jsonPath(prefix + ".timestamp").hasJsonPath(),
                jsonPath(prefix + ".evaluation_token").hasJsonPath(),
                jsonPath(prefix + ".entity_token").hasJsonPath(),
                jsonPath(prefix + ".application_token").hasJsonPath(),
                jsonPath(prefix + ".application_version_id").hasJsonPath()
        };
    }

    private ResultMatcher[] validateJsonErrorResponses(String prefix) {
        return new ResultMatcher[]{
                jsonPath(prefix + ".status").hasJsonPath(),
                jsonPath(prefix + ".title").hasJsonPath(),
                jsonPath(prefix + ".details").hasJsonPath()
        };
    }

    private MockHttpServletRequestBuilder postJson(Object body) {
        try {
            return post(VERIFY_ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(body));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}