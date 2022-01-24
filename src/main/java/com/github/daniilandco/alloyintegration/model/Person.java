package com.github.daniilandco.alloyintegration.model;

import lombok.AllArgsConstructor;
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

/**
 * Class which represents person model stored in database.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@Document(collection = "person")
@AllArgsConstructor
public class Person {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String entityToken;
    @DBRef
    private final Set<EvaluationToken> evaluationTokens = new HashSet<>();
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String documentSSN;
}
