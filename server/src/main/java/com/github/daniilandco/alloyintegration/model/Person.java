package com.github.daniilandco.alloyintegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

/**
 * Class which represents person model stored in database.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Document(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person {
    @MongoId(FieldType.STRING)
    private String id;
    private String entityToken;
    @DBRef
    private final Set<EvaluationToken> evaluationTokens = new HashSet<>();
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Email
    private String emailAddress;
    private String documentSSN;
}
