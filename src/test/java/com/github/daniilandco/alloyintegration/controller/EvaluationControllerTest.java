package com.github.daniilandco.alloyintegration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.daniilandco.alloyintegration.AlloyIntegrationApplicationTests;
import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.util.MockDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
class EvaluationControllerTest extends AlloyIntegrationApplicationTests {
    private static final String VERIFY_ENDPOINT = "/api/v1/verify";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockDataGenerator mockDataGenerator;

    @Test
    public void givenValid_whenVerify_thenValid() throws Exception {
        final PersonDTO requestBody = mockDataGenerator.generateValidPersonDTO();
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonValidResponse("body"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenNull_whenVerify_thenError() throws Exception {
        this.mockMvc.perform(postJson(null))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponse("$"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenInvalidEmail_whenVerify_thenError() throws Exception {
        final PersonDTO requestBody = mockDataGenerator.generateValidPersonDTO()
                .setEmailAddress("WrongEmailAddressFormat!");
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponse("$"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenInvalidSSN_whenVerify_thenError() throws Exception {
        final PersonDTO requestBody = mockDataGenerator.generateValidPersonDTO()
                .setDocumentSSN("WrongSSNAtAll");
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponse("$"))
                .andExpect(status().isBadRequest());

        requestBody.setDocumentSSN("12345678");
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponse("$"))
                .andExpect(status().isBadRequest());

        requestBody.setDocumentSSN("1234567890");
        this.mockMvc.perform(postJson(requestBody))
                .andDo(print())
                .andExpectAll(validateJsonErrorResponse("$"))
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

    private ResultMatcher[] validateJsonErrorResponse(String prefix) {
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