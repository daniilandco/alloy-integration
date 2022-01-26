package com.github.daniilandco.alloyintegration.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;


/**
 * Class which represents person DTO.
 *
 * @author com.github.daniilandco
 * @version 1.0
 * @see com.github.daniilandco.alloyintegration.model.Person
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    @JsonProperty("name_first")
    private String firstName;
    @JsonProperty("name_last")
    private String lastName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("birth_date")
    private LocalDate birthDate;
    @JsonProperty("document_ssn")
    private String documentSSN;
    @JsonProperty("address")
    @JsonUnwrapped
    private AddressDTO addressDTO;
}
























