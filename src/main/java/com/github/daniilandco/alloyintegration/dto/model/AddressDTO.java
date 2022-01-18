package com.github.daniilandco.alloyintegration.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class AddressDTO {
    private String address_line_1;
    private String address_line_2;
    private String address_city;
    private String address_state;
    private String address_postal_code;
    private String address_country_code;
}
