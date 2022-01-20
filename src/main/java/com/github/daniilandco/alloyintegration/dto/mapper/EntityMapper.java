package com.github.daniilandco.alloyintegration.dto.mapper;

import com.github.daniilandco.alloyintegration.dto.model.request.AddressDTO;
import com.github.daniilandco.alloyintegration.dto.model.request.EntityDTO;
import com.github.daniilandco.alloyintegration.entity.Address;
import com.github.daniilandco.alloyintegration.entity.Entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    EntityDTO toDTO(Entity entity);

    Entity toPerson(EntityDTO dto);

    AddressDTO toDTO(final Address address);

    Address toAddress(final AddressDTO dto);
}
