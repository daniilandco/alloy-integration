package com.github.daniilandco.alloyintegration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@TestPropertySource(properties = {"ALLOY_USERNAME=dpDD6z4olOSI7N4fMCsAlKjFa7reBYhu", "ALLOY_PASSWORD=oJm3niQX1Pdy4z675kefEIKBgFn9tQ45", "MONGO_USERNAME=daniilandco", "MONGO_PASSWORD=3n3KS26XrSPnk3f"})
@AutoConfigureMockMvc
class EvaluationControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testOk() throws Exception {
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

        this.mockMvc.perform(post("/api/v1/verify")
                        .contentType(MediaType.APPLICATION_JSON).content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testBad() throws Exception {
        String body = """
                {
                    "name_first":"Ganiel",
                    "name_last":"DoeS",
                    "phone_number":"18042562188",
                    "email_address":"john",
                    "address_line_1":"41 Elizabeth Street",
                    "address_line_2":"STE 500",
                    "address_city":"New York",
                    "address_state":"NY",
                    "address_postal_code":"10013",
                    "address_country_code":"US",
                    "birth_date":"1985-06-13",
                    "document_ssn":"123456789"
                }""";

        this.mockMvc.perform(post("/api/v1/verify")
                        .contentType(MediaType.APPLICATION_JSON).content(body))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}