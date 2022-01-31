package com.github.daniilandco.alloyintegration.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


/**
 * Class which represents person DTO.
 *
 * @author com.github.daniilandco
 * @version 1.0
 * @see com.github.daniilandco.alloyintegration.model.Person
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {
    @JsonProperty("name_first")
    private String firstName;
    @JsonProperty("name_last")
    private String lastName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("email_address")
    @Email(message = "email should be in a right format", regexp = ".+@.+\\..+")
    @NotNull(message = "email cannot be null")
    private String emailAddress;
    @JsonProperty("birth_date")
    @DateTimeFormat
    private LocalDate birthDate;
    @JsonProperty("document_ssn")
    @Pattern(regexp = "[\\d]{9}", message = "document SSN should be 9 digit number")
    @NotNull(message = "document SSN cannot be null")
    private String documentSSN;
    @JsonProperty("address")
    @JsonUnwrapped
    private AddressDTO addressDTO;
}
























