package com.github.daniilandco.alloyintegration.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @JsonProperty("address_line_1")
    protected String addressLine1;
    @JsonProperty("address_line_2")
    protected String addressLine2;
    @JsonProperty("address_city")
    protected String addressCity;
    @JsonProperty("address_state")
    protected String addressState;
    @JsonProperty("address_postal_code")
    protected String addressPostalCode;
    @JsonProperty("address_country_code")
    protected String addressCountryCode;
}
