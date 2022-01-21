package com.github.daniilandco.alloyintegration.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


/**
 * Class which represents Person DTO.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {
    /**
     * First name field
     */
    @JsonProperty("name_first")
    protected String firstName;
    /**
     * Second name field
     */
    @JsonProperty("name_last")
    protected String lastName;
    /**
     * Phone number field
     */
    @JsonProperty("phone_number")
    protected String phoneNumber;
    /**
     * Email address field
     */
    @JsonProperty("email_address")
    protected String emailAddress;
    /**
     * Birth date field
     */
    @JsonProperty("birth_date")
    protected String birthDate;
    /**
     * Document ssn field
     */
    @JsonProperty("document_ssn")
    protected String documentSsn;
    @JsonProperty("address")
    @JsonUnwrapped
    protected AddressDTO addressDTO;

    /**
     * Constructor - creates new PersonDTO object with particular fields
     *
     * @param firstName    - Person first name
     * @param lastName     - Person last name
     * @param phoneNumber  - Person phone number
     * @param emailAddress - Person email address
     *                     //     * @param addressDTO:addressLine1 - Person address line 1
     *                     //     * @param addressDTO:addresLine2 - Person address line 2
     *                     //     * @param addressCity - Person address city
     *                     //     * @param addressState - Person address state
     *                     //     * @param addressPostalCode - Person postal code
     *                     //     * @param addressCountryCode - Person country code
     */
    public PersonDTO(String firstName, String lastName, String phoneNumber, String emailAddress, String birthDate, String documentSsn, AddressDTO addressDTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
        this.documentSsn = documentSsn;
        this.addressDTO = addressDTO;
    }
}
