package com.github.daniilandco.alloyintegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;

/**
 * Class which represents evaluation token model stored in database.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Document("evaluation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EvaluationToken {
    @MongoId(FieldType.STRING)
    private String id;
    @NotBlank(message = "evaluation token cannot be blank")
    private String evaluationToken;
}
