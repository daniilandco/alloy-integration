package com.github.daniilandco.alloyintegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Class which represents evaluation token model stored in database.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document("evaluation")
public class EvaluationToken {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String evaluationToken;
}
