package com.github.daniilandco.alloyintegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "person")
public class Entity {
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
    @DBRef
    private Address address;
    private String birthDate;
    @NotBlank
    private String documentSsn;
}
