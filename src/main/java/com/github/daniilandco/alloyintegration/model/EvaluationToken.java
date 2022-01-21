package com.github.daniilandco.alloyintegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

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
