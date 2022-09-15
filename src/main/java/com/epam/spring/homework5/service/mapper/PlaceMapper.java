package com.epam.spring.homework5.service.mapper;

import com.epam.spring.homework5.controller.dto.PlaceDTO;
import com.epam.spring.homework5.service.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaceMapper {

    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    PlaceDTO mapPlaceDto(Place place);

    @Mapping(target = "id", defaultValue = "0")
    Place mapPlace(PlaceDTO placeDTO);

    void mapPresentFields(@MappingTarget Place toPlace, Place fromPlace);
}
