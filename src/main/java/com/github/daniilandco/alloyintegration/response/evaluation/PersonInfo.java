package com.github.daniilandco.alloyintegration.response.evaluation;

public record PersonInfo(
        String name_first,
        String name_last,
        String phone_number,
        String email_address,
        String address_line_1,
        String address_line_2,
        String address_city,
        String address_state,
        String address_postal_code,
        String address_country_code,
        String birth_date,
        String document_ssn,
        String social_twitter
) {
}
