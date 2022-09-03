package com.epam.spring.homework4.service.mapper;

import com.epam.spring.homework4.controller.dto.PlaceDTO;
import com.epam.spring.homework4.service.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    PlaceDTO mapPlaceDto(Place place);

    Place mapPlace(PlaceDTO placeDTO);
}
