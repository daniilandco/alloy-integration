package com.github.daniilandco.alloyintegration.mapper;

import com.github.daniilandco.alloyintegration.dto.request.PersonDTO;
import com.github.daniilandco.alloyintegration.model.Person;
import org.mapstruct.Mapper;

/**
 * Interface which generates methods for mapping person DTO to person model.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toPerson(PersonDTO dto);
}
