package com.github.daniilandco.alloyintegration.dto.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class EntityDTO {
    @JsonProperty("name_first")
    private String firstName;
    @JsonProperty("name_last")
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    @JsonUnwrapped
    private AddressDTO address;
    private String birthDate;
    private String documentSsn;
}
