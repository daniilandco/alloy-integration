package com.github.daniilandco.alloyintegration.mapper;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(Person person);

    Person toPerson(PersonDTO dto);
}
