package com.github.daniilandco.alloyintegration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonRequest {
    @JsonProperty("name_first")
    private String firstName;
    @JsonProperty("name_last")
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    @JsonProperty("address_line_1")
    private String addressLine1;
    @JsonProperty("address_line_2")
    private String addressLine2;
    private String addressCity;
    private String addressState;
    private String addressPostalCode;
    private String addressCountryCode;
    private String birthDate;
    private String documentSsn;

    public PersonRequest() {
    }
}
