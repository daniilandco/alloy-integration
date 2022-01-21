package com.github.daniilandco.alloyintegration.model;

import com.github.daniilandco.alloyintegration.dto.request.AddressDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Document(collection = "person")
public class Person extends AddressDTO {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String entityToken;
    @DBRef
    private Set<EvaluationToken> evaluationTokens = new HashSet<>();
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String documentSsn;

    public Person(String addressLine1, String addressLine2, String addressCity, String addressState, String addressPostalCode, String addressCountryCode, String id, String entityToken, String firstName, String lastName, String phoneNumber, String emailAddress, String documentSsn) {
        super(addressLine1, addressLine2, addressCity, addressState, addressPostalCode, addressCountryCode);
        this.id = id;
        this.entityToken = entityToken;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.documentSsn = documentSsn;
    }
}
