package com.github.daniilandco.alloyintegration.dto.mapper;

import com.github.daniilandco.alloyintegration.dto.model.PersonDTO;
import com.github.daniilandco.alloyintegration.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(Person person);

    Person toPerson(PersonDTO dto);
}
