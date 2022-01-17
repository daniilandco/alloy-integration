package com.github.daniilandco.alloyintegration.entity;

import com.github.daniilandco.alloyintegration.dto.model.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "person")
public class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String phoneNumber;
    @Indexed(unique = true)
    private String emailAddress;
    private AddressDTO addressInfo;
    private String birthDate;
    private String documentSsn;

    public Person() {
    }
}
