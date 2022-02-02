package com.github.daniilandco.alloyintegration.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class which represents person's address info.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AddressDTO {
    @JsonProperty("address_line_1")
    private String addressLine1;
    @JsonProperty("address_line_2")
    private String addressLine2;
    @JsonProperty("address_city")
    private String addressCity;
    @JsonProperty("address_state")
    private String addressState;
    @JsonProperty("address_postal_code")
    private String addressPostalCode;
    @JsonProperty("address_country_code")
    private String addressCountryCode;
}
